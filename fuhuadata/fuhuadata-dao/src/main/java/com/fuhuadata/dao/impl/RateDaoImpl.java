package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.RateDao;
import com.fuhuadata.domain.Rate;
import com.fuhuadata.domain.query.RateQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * 费率DaoImpl
 * Created by young on 2017/2/8.
 */
public class RateDaoImpl extends SqlMapClientTemplate implements RateDao{

    public static final String ADD = "RATE.ADD";
    public static final String UPDATE = "RATE.UPDATE";
    public static final String DELETE_BY_ID = "RATE.DELETE_BY_ID";
    public static final String GET_PAGE = "RATE.GET_PAGE";
    public static final String COUNT = "RATE.COUNT";
    public static final String GET_BY_QUERY="RATE.GET-BY-QUERY";

    @Override
    public Rate addRate(Rate rate){
        rate.setRateId((Integer) this.insert(ADD,rate));
        return rate;
    }

    @Override
    public int updateRateById(int id,Rate rate){
        rate.setRateId(id);
        return this.update(UPDATE,rate);
    }

    @Override
    public int deleteRateById(int id){
        return this.delete(DELETE_BY_ID,id);
    }

    @Override
    public List<Rate> getRateByQuery(RateQuery rateQuery) {
        return this.queryForList(GET_BY_QUERY,rateQuery);
    }

    @Override
    public List<Rate> getRatesByPage(RateQuery rateQuery) {
        return this.queryForList(GET_PAGE,rateQuery);
    }

    @Override
    public int count(RateQuery rateQuery) {
        return ((Integer) this.queryForObject(COUNT,rateQuery)).intValue();
    }

}
