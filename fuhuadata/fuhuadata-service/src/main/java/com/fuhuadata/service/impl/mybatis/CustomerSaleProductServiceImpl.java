package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.domain.mybatis.CustomerSaleCountry;
import com.fuhuadata.domain.mybatis.CustomerSaleProduct;
import com.fuhuadata.domain.query.QueryCustomerSaleProduct;
import com.fuhuadata.service.exception.ServiceException;
import com.fuhuadata.service.mybatis.CustomerSaleCountryService;
import com.fuhuadata.service.mybatis.CustomerSaleProductService;
import com.fuhuadata.service.util.MessageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/4/2017
 */
@Service
public class CustomerSaleProductServiceImpl extends BaseServiceImpl<CustomerSaleProduct, Integer>
        implements CustomerSaleProductService {

    private CustomerSaleCountryService countryService;

    @Autowired
    private void setCountryService(CustomerSaleCountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public PageInfo<CustomerSaleProduct> listProducts(QueryCustomerSaleProduct query) {

        if (query == null) {
            return null;
        }

        Example example = newExample();
        Example.Criteria criteria = example.createCriteria().andEqualTo("customerId", query.getCustomerId());

        if (StringUtils.isNotEmpty(query.getProductName())) {
            criteria.andLike("productName", "%" + query.getProductName() + "%");
        }
        if (StringUtils.isNotEmpty(query.getYear())) {
            criteria.andEqualTo("year", query.getYear());
        }
        example.orderBy("create_time asc");

        PageHelper.startPage(query.getIndex(), query.getPageSize());
        List<CustomerSaleProduct> products = listByExample(example);
        return new PageInfo<CustomerSaleProduct>(products);
    }

    @Override
    public CustomerSaleProduct getProductAndCountriesByProductId(Integer productId) {

        if (productId == null) {
            return null;
        }

        CustomerSaleProduct product = get(productId);
        if (product != null) {
            List<CustomerSaleCountry> countries = countryService.listCountriesByProductId(productId);
            product.setCountries(countries);
        }

        return product;
    }

    @Override
    public void saveOrUpdateProductsAndCountries(CustomerSaleProduct product, List<Integer> deleteCountryIds) {

        if (product == null) {
            return;
        }

        try {
            saveOrUpdateSelective(product);// 保存销售产品
        } catch (RuntimeException e) {
            if (e instanceof DuplicateKeyException) {
                throw new ServiceException(
                        MessageUtils.message("customer.product.purchase.duplicate", product.getYear(), product.getProductName()),
                        e);
            } else {
                throw e;
            }
        }

        List<CustomerSaleCountry> countries = product.getCountries();
        for (CustomerSaleCountry country : countries) {
            country.setSaleId(product.getId());// 设置销售产品id
            country.setProductId(Integer.valueOf(product.getProductId()));// 设置标准产品id
        }

        countryService.saveOrUpdateCountries(countries);// 新增或更新目的国

        countryService.deleteCountries(deleteCountryIds);// 删除目的国
    }

    @Override
    public int deleteProducts(List<Integer> productIds) {

        int result = 0;

        for (Integer productId : productIds) {
            countryService.deleteCountriesByProductId(productId);
            result += delete(productId);
        }

        return result;
    }
}
