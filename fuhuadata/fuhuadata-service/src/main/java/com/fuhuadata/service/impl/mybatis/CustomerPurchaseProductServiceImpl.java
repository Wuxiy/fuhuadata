package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.dao.mapper.CustomerPurchaseProductMapper;
import com.fuhuadata.domain.mybatis.CustomerPurchaseProduct;
import com.fuhuadata.domain.mybatis.CustomerPurchaseSupplier;
import com.fuhuadata.domain.query.QueryCustomerPurchaseProduct;
import com.fuhuadata.service.exception.ServiceException;
import com.fuhuadata.service.mybatis.CustomerPurchaseProductService;
import com.fuhuadata.service.mybatis.CustomerPurchaseSupplierService;
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
public class CustomerPurchaseProductServiceImpl extends BaseServiceImpl<CustomerPurchaseProduct, Integer>
        implements CustomerPurchaseProductService {

    private CustomerPurchaseProductMapper getProductMapper() {
        return (CustomerPurchaseProductMapper) baseMapper;
    }

    private CustomerPurchaseSupplierService supplierService;

    @Autowired
    private void setSupplierService(CustomerPurchaseSupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @Override
    public PageInfo<CustomerPurchaseProduct> listProducts(QueryCustomerPurchaseProduct query) {
        if (query == null) {
            return null;
        }

        Example example = newExample();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("customerId", query.getCustomerId());

        if (StringUtils.isNotEmpty(query.getProductName())) {
            criteria.andLike("productName", "%" + query.getProductName() + "%");
        }
        if (StringUtils.isNotEmpty(query.getYear())) {
            criteria.andEqualTo("year", query.getYear());
        }
        example.orderBy("create_time asc");

        PageHelper.startPage(query.getIndex(), query.getPageSize());
        List<CustomerPurchaseProduct> products = listByExample(example);
        return new PageInfo<CustomerPurchaseProduct>(products);
    }

    @Override
    public CustomerPurchaseProduct getProductAndSupplierByProductId(Integer productId) {

        if (productId == null) {
            return null;
        }

        CustomerPurchaseProduct product = get(productId);
        if (product != null) {
            List<CustomerPurchaseSupplier> suppliers = supplierService.listSupplierByProductId(productId);
            product.setSuppliers(suppliers);
        }

        return product;
    }

    @Override
    public void saveOrUpdatePurchaseProductAndSuppliers(CustomerPurchaseProduct product,
                                                        List<Integer> deletedSupplierIds) {

        if (product == null) {
            return;
        }

        try {
            saveOrUpdateSelective(product);// 保存采购产品
        } catch (RuntimeException e) {
            if (e instanceof DuplicateKeyException) {
                throw new ServiceException(
                        MessageUtils.message("customer.product.purchase.duplicate", product.getYear(), product.getProductName()),
                        e);
            } else {
                throw e;
            }
        }

        List<CustomerPurchaseSupplier> suppliers = product.getSuppliers();
        for (CustomerPurchaseSupplier supplier : suppliers) {
            supplier.setPurchaseId(product.getId());// 设置采购产品id
            supplier.setProductId(product.getProductId());// 设置标准产品id
        }

        supplierService.saveOrUpdateSuppliers(suppliers);// 保存新增供应商或更新供应商

        supplierService.deleteSuppliersByIds(deletedSupplierIds);// 删除供应商
    }

    @Override
    public int deleteProducts(List<Integer> productIds) {
        int result = 0;

        for (Integer productId : productIds) {
            supplierService.deleteSuppliersByProductId(productId);
            result += delete(productId);
        }

        return result;
    }
}
