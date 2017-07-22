package com.fuhuadata.service.mybatis.customs;

import com.fuhuadata.dao.mapper.customs.CustomsCountryMapper;
import com.fuhuadata.domain.customs.CustomsCountry;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/23/2017
 */
@Service
public class CustomsCountryServiceImpl extends BaseServiceImpl<CustomsCountry, Integer>
        implements CustomsCountryService {

    private CustomsCountryMapper getCountryMapper() {
        return (CustomsCountryMapper) baseMapper;
    }

    private CustomsCountryService getCurrentProxy() {
        return (CustomsCountryService) AopContext.currentProxy();
    }

    @Override
    public List<CustomsCountry> listCountries() {

        Example example = newExample();
        example.setOrderByClause("weight asc");

        return getCurrentProxy().listByExample(example);
    }

    @Override
    public List<CustomsCountry> listCountries(List<Integer> countryIds) {

        Example example = newExample();
        example.setOrderByClause("weight asc");
        example.createCriteria().andIn("id", countryIds);

        return getCurrentProxy().listByExample(example);
    }
}
