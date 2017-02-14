package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.MarketTrainingDao;
import com.fuhuadata.domain.MarketTraining;
import com.fuhuadata.domain.query.MarketTrainingQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by intanswer on 2017/1/12.
 */
public class MarketTrainingDaoImpl extends SqlMapClientTemplate implements MarketTrainingDao {
    public static final String ADD="MARKETTRAINING.ADD";
    private static final String UPDATE="MARKETTRAINING.UPDATE";
    private static final String DELETE_BY_ID="MARKETTRAINING.DELETE-BY-ID";
    public static final String GET_PAGE="MARKETTRAINING.GET-PAGE";
    public static final String COUNT="MARKETTRAINING.COUNT";

    @Override
    public MarketTraining addMartketTraining(MarketTraining marketTraining) {
        marketTraining.setTranId((Integer)this.insert(ADD,marketTraining));
        return marketTraining;
    }

    @Override
    public int updateMarketTrainingById(int id, MarketTraining marketTraining) {
        marketTraining.setTranId(id);
        return this.update(UPDATE,marketTraining);
    }

    @Override
    public int deleteMarketTrainingById(int id) {
        return this.delete(DELETE_BY_ID,id);
    }

    @Override
    public List<MarketTraining> getMarketTrainingsByPage(MarketTrainingQuery marketTrainingQuery) {
        List<MarketTraining> list=this.queryForList(GET_PAGE,marketTrainingQuery);
        return list;
    }

    @Override
    public int count(MarketTrainingQuery marketTrainingQuery) {
        return ((Integer)this.queryForObject(COUNT,marketTrainingQuery)).intValue();
    }
}
