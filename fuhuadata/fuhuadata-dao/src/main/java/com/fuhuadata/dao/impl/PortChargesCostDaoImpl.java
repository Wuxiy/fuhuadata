package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.PortChargesCostDao;
import com.fuhuadata.domain.PortChargesCost;
import com.fuhuadata.domain.query.PortChargesCostQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by intanswer on 2017/1/18.
 */
public class PortChargesCostDaoImpl extends SqlMapClientTemplate implements PortChargesCostDao{
    public static final String ADD="PORTCHARGESCOST.ADD";
    public static final String UPDATE="PORTCHARGESCOST.UPDATE";
    public  static final String DELETE_BY_ID="PORTCHARGESCOST.DELETE-BY-ID";
    public static final String GET_PAGE="PORTCHARGESCOST.GET-PAGE";
    public static final String COUNT="PORTCHARGESCOST.COUNT";
    @Override
    public PortChargesCost addPortChargesCost(PortChargesCost portChargesCost) {
        portChargesCost.setId((Integer) this.insert(ADD,portChargesCost));
        return portChargesCost;
    }

    @Override
    public int updatePortChargesCostById(int id, PortChargesCost portChargesCost) {
        portChargesCost.setId(id);
        return this.update(UPDATE,portChargesCost);
    }

    @Override
    public int deletePortChargesCostById(int id) {
        return this.delete(DELETE_BY_ID,id);
    }

    @Override
    public List<PortChargesCost> getPortChargesCostsByPage(PortChargesCostQuery portChargesCostQuery) {
        return this.queryForList(GET_PAGE,portChargesCostQuery);
    }

    @Override
    public int count(PortChargesCostQuery portChargesCostQuery) {
        return ((Integer)this.queryForObject(COUNT,portChargesCostQuery)).intValue();
    }
}
