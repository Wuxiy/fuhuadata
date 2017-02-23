package com.fuhuadata.manager;

import com.fuhuadata.domain.PortChargesCost;
import com.fuhuadata.domain.query.PortChargesCostQuery;
import com.fuhuadata.domain.query.Result;

import javax.sound.sampled.Port;
import java.util.List;

/**
 * 港杂费成本manager
 * Created by intanswer on 2017/1/17.
 */
public interface PortChargesCostManager {
    /**
     * 新增返回时设置了新生成的id
     * @param portChargesCost
     * @return
     */
    public PortChargesCost addPortChargesCost(PortChargesCost portChargesCost);

    public PortChargesCost getPortChargesCostById(int id);

    public boolean updatePortChargesCostById(int id,PortChargesCost portChargesCost);

    public boolean deletePortChargesCostById(int id);

    public List<PortChargesCost> getAllPortChargesCosts();


    public List<PortChargesCost> getPortChargesCostByQuery(PortChargesCostQuery portChargesCostQuery);

    /**
     * Query(设置当前页数)
     * Query(设置当前页面数据行数)
     * 返回Result中，可以通过result.getTotal()返回结果总数，
     * result中包装了分页需要的信息，和当前列表
     * @param portChargesCostQuery
     * @return
     */
    public Result<List<PortChargesCost>> getPortChargesCostsByPage(PortChargesCostQuery portChargesCostQuery);

    /**
     * 查询总数
     * @param portChargesCostQuery
     * @return
     */
    public int count(PortChargesCostQuery portChargesCostQuery);


}
