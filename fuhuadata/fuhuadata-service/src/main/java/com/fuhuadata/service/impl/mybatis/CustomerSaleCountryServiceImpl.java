package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.domain.mybatis.CustomerSaleCountry;
import com.fuhuadata.service.mybatis.CustomerSaleCountryService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/4/2017
 */
@Service
public class CustomerSaleCountryServiceImpl extends BaseServiceImpl<CustomerSaleCountry, Integer>
        implements CustomerSaleCountryService {

    @Override
    public List<CustomerSaleCountry> listCountriesByProductId(Integer productId) {
        Example example = newExample();
        example.createCriteria().andEqualTo("saleId", productId);
        example.orderBy("id ase");

        return listByExample(example);
    }

    @Override
    public int saveOrUpdateCountries(List<CustomerSaleCountry> countries) {
        if (countries == null) {
            return 0;
        }

        int result = 0;
        for (CustomerSaleCountry country : countries) {
            result += saveOrUpdateSelective(country);
        }

        return result;
    }

    @Override
    public int deleteCountries(List<Integer> countryIds) {

        if (countryIds == null) {
            return 0;
        }

        int result = 0;
        for (Integer id : countryIds) {
            result += delete(id);
        }

        return result;
    }

    @Override
    public int deleteCountriesByProductId(Integer productId) {

        Example example = newExample();
        example.createCriteria().andEqualTo("saleId", productId);

        return delete(example);
    }
}
