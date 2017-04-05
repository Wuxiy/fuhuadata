package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.BaseDao;
import com.fuhuadata.dao.PortChargesCostDao;
import com.fuhuadata.domain.PortChargesCost;
import com.fuhuadata.domain.query.PortChargesCostQuery;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import javax.sound.sampled.Port;
import java.util.List;

/**
 * Created by intanswer on 2017/1/18.
 */
public class PortChargesCostDaoImpl extends BaseDao<PortChargesCost> implements PortChargesCostDao{
    public static final String ADD="PORTCHARGESCOST.ADD";
    public static final String UPDATE="PORTCHARGESCOST.UPDATE";
    public  static final String DELETE_BY_ID="PORTCHARGESCOST.DELETE-BY-ID";
    public static final String GET_BY_ID="PORTCHARGESCOST.GET-BY-ID";
    public static final String GET_PAGE="PORTCHARGESCOST.GET-PAGE";
    public static final String COUNT="PORTCHARGESCOST.COUNT";
    public static final String GET_BY_QUERY="PORTCHARGESCOST.GET-BY-QUERY";
    public static final String GET_ALL="PORTCHARGESCOST.GET-ALL";

    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;
    @Override
    public PortChargesCost addPortChargesCost(PortChargesCost portChargesCost) {
        portChargesCost.setPortId((Integer) sqlMapClientTemplate.insert(ADD,portChargesCost));
        return portChargesCost;
    }

    @Override
    public boolean updatePortChargesCostById(List<PortChargesCost> portChargesCost) {
        return this.batch(sqlMapClientTemplate,UPDATE,portChargesCost);
    }

    @Override
    public int deletePortChargesCostById(int id) {
        return sqlMapClientTemplate.delete(DELETE_BY_ID,id);
    }

    @Override
    public List<PortChargesCost> getAllortChargesCosts() {
        return sqlMapClientTemplate.queryForList(GET_ALL);
    }

    @Override
    public PortChargesCost getPortChargesCostById(int id) {
        return (PortChargesCost) sqlMapClientTemplate.queryForObject(GET_BY_ID,id);
    }

    @Override
    public List<PortChargesCost> getPortChargesCostsByPage(PortChargesCostQuery portChargesCostQuery) {
        return sqlMapClientTemplate.queryForList(GET_PAGE,portChargesCostQuery);
    }

    @Override
    public List<PortChargesCost> getPortChargesCostByQuery(PortChargesCostQuery portChargesCostQuery) {
        return sqlMapClientTemplate.queryForList(GET_BY_QUERY,portChargesCostQuery);
    }

    @Override
    public int count(PortChargesCostQuery portChargesCostQuery) {
        return ((Integer)sqlMapClientTemplate.queryForObject(COUNT,portChargesCostQuery)).intValue();
    }
}
