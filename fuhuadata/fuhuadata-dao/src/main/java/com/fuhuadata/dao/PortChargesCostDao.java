package com.fuhuadata.dao;

import com.fuhuadata.domain.PortChargesCost;
import com.fuhuadata.domain.query.PortChargesCostQuery;

import javax.sound.sampled.Port;
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
     * @param portChargesCost
     * @return
     */
    public boolean updatePortChargesCostById(List<PortChargesCost> portChargesCost);

    /**
     * 按照主键id删除记录，成功返回1
     * @param id
     * @return
     */
    public int deletePortChargesCostById(int id);

    public List<PortChargesCost> getAllortChargesCosts();
    /**
     * 通过id获取港杂费信息
     * @param id
     * @return
     */
    public PortChargesCost getPortChargesCostById(int id);

    /**
     * 分页查询列表
     * Query(设置当前页数和当前页面行数）
     * @param portChargesCostQuery
     * @return
     */
    public List<PortChargesCost> getPortChargesCostsByPage(PortChargesCostQuery portChargesCostQuery);

    /**
     * 查询列表，不包含分页查询
     * @param portChargesCostQuery
     * @return
     */
    public List<PortChargesCost> getPortChargesCostByQuery(PortChargesCostQuery portChargesCostQuery);
    /**
     * 查询总数
     * @param portChargesCostQuery
     * @return
     */
    public int count(PortChargesCostQuery portChargesCostQuery);


}
