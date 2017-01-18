package com.fuhuadata.dao;

import com.fuhuadata.domain.PortChargesCost;
import com.fuhuadata.domain.query.PortChargesCostQuery;

import java.util.List;

/**
 * 港杂费dao
 * Created by intanswer on 2017/1/17.
 */
public interface PortChargesCostDao {
    /**
     * 新增PortChargesCost对象，返回设置了新生成的id
     * @param portChargesCost
     * @return
     */
    public PortChargesCost addPortChargesCost(PortChargesCost portChargesCost);

    /**
     * 按照主键id更新，成功返回1
     * @param id
     * @param portChargesCost
     * @return
     */
    public int updatePortChargesCostById(int id, PortChargesCost portChargesCost);

    /**
     * 按照主键id删除记录，成功返回1
     * @param id
     * @return
     */
    public int deletePortChargesCostById(int id);

    /**
     * 分页查询列表
     * Query(设置当前页数和当前页面行数）
     * @param portChargesCostQuery
     * @return
     */
    public List<PortChargesCost> getPortChargesCostsByPage(PortChargesCostQuery portChargesCostQuery);

    /**
     * 查询总数
     * @param portChargesCostQuery
     * @return
     */
    public int count(PortChargesCostQuery portChargesCostQuery);

}
