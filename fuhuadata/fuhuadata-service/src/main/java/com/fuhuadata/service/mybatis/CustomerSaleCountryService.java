package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.CustomerSaleCountry;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/4/2017
 */
public interface CustomerSaleCountryService extends BaseService<CustomerSaleCountry, Integer> {

    /**
     * 获取销售产品目的国
     * @param productId
     * @return
     */
    List<CustomerSaleCountry> listCountriesByProductId(Integer productId);

    /**
     * 新增或保存目的国
     * @param countries
     * @return
     */
    int saveOrUpdateCountries(List<CustomerSaleCountry> countries);

    /**
     * 通过id删除目的国
     * @param countryIds
     * @return
     */
    int deleteCountries(List<Integer> countryIds);

    /**
     * 删除销售产品目的国
     * @param productId
     * @return
     */
    int deleteCountriesByProductId(Integer productId);
}
