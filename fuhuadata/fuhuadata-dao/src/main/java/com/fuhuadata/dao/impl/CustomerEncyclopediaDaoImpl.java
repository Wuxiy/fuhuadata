package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.CustomerEncyclopediaDao;
import com.fuhuadata.domain.CustomerEncyclopedia;
import com.fuhuadata.domain.query.CustomerEncyclopediaQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * 客户百科daoImpl
 * Created by intanswer on 2017/1/16.
 */
public class CustomerEncyclopediaDaoImpl extends SqlMapClientTemplate implements CustomerEncyclopediaDao {
    public static final String ADD = "CUSTOMERENCYCLOPEDIA.ADD";
    public static final String UPDATE = "CUSTOMERENCYCLOPEDIA.UPDATE";
    public static final String DELETE = "CUSTOMERENCYCLOPEDIA.DELETE-BY-ID";
    public static final String GET_PAGE = "CUSTOMERENCYCLOPEDIA.GET-PAGE";
    public static final String COUNT = "CUSTOMERENCYCLOPEDIA.COUNT";
    @Override
    public CustomerEncyclopedia addCustomerEncyclopedia(CustomerEncyclopedia customerEncyclopedia) {
        customerEncyclopedia.setEncyId((Integer) this.insert(ADD,customerEncyclopedia));
        return customerEncyclopedia;
    }

    @Override
    public int updateCustomerEncyclopediaById(int id, CustomerEncyclopedia customerEncyclopedia) {
        customerEncyclopedia.setEncyId(id);
        return this.update(UPDATE,customerEncyclopedia);
    }

    @Override
    public int deleteCustomerEncyclopediaById(int id) {
        return this.delete(DELETE,id);
    }

    @Override
    public List<CustomerEncyclopedia> getCustomerEncyclopediasByPage(CustomerEncyclopediaQuery customerEncyclopediaQuery) {
        return this.queryForList(GET_PAGE,customerEncyclopediaQuery);
    }

    @Override
    public int count(CustomerEncyclopediaQuery customerEncyclopediaQuery) {
        return ((Integer) this.queryForObject(COUNT,customerEncyclopediaQuery)).intValue();
    }
}
