package com.fuhuadata.manager;

import com.fuhuadata.domain.FreightCost;
import com.fuhuadata.domain.query.FreightCostQuery;
import com.fuhuadata.domain.query.Result;

import java.util.List;

/**
 * 国内运费成本manager
 * Created by intanswer on 2017/1/17.
 */
public interface FreightCostManager {

    /**
     * 新增返回时设置了新生成的id
     * @param freightCost
     * @return
     */
    public FreightCost addFreightCost(FreightCost freightCost);

    /**
     * 根据主键id更新记录
     * 成功返回true，失败返回false
     * @param id
     * @param freightCost
     * @return
     */
    public boolean updateFreightCostById(int id, FreightCost freightCost);

    /**
     * 按照主键id删除记录
     * @param id
     * @return
     */
    public boolean deleteFreightCostById(int id);

    public FreightCost getFreightCostById(int id);

    /**
     * Query(设置当前页数)
     * Query(设置当前页面数据行数)
     * 返回Result中，可以通过result.getTotal()返回结果总数，
     * result中包装了分页需要的信息，和当前列表
     * @param freightCostQuery
     * @return
     */
    public Result<List<FreightCost>> getFreightCostsByPage(FreightCostQuery freightCostQuery);

    /**
     * 查询列表
     * @param freightCostQuery
     * @return
     */
    public List<FreightCost> getFreightCostsByQuery(FreightCostQuery freightCostQuery);
    /**
     * 查询总数
     * @param freightCostQuery
     * @return
     */
    public int count(FreightCostQuery freightCostQuery);

}
