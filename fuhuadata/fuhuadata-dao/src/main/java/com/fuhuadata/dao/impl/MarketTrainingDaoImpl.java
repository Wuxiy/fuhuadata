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

    private static final String ADD="EXHIBITIONINFO.ADD";
    private static final String GET_PAGE="EXHIBITIONINFO.GET-PAGE";
    private static final String COUNT="EXHIBITIONINFO.COUNT";
    private static final String UPDATE="EXHIBITIONINFO.UPDATE";
    private static final String DELETE_BY_ID="EXHIBITIONINFO.DELETE-BY-ID";
    private static final String GET_ALl="EXHIBITIONINFO.GET-ALL";
    private static final String GET_BY_ID="EXHIBITIONINFO.GET-BY-ID";
    private static final String GET_BY_QUERY="EXHIBITIONINFO.GET-BY-QUERY";

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
    public MarketTraining getMarketTrainingById(int id){return (MarketTraining)this.queryForObject(GET_BY_ID,id);};

    @Override
    public List<MarketTraining> getAllMarketTrainings(){return this.queryForList(GET_ALl);}

    @Override
    public List<MarketTraining> getMarketTrainingsByQuery(MarketTrainingQuery marketTrainingQuery){
        return queryForList(GET_BY_QUERY,marketTrainingQuery);
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
