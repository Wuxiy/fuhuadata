package com.fuhuadata.service.mybatis.customs;

import com.fuhuadata.domain.customs.CustomsCountry;
import com.fuhuadata.service.mybatis.BaseService;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/23/2017
 */
public interface CustomsCountryService extends BaseService<CustomsCountry, Integer> {

    List<CustomsCountry> listCountries();
}
