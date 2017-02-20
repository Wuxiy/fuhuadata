package com.fuhuadata.dao;

import com.fuhuadata.domain.FreightCost;
import com.fuhuadata.domain.query.FreightCostQuery;

import java.util.List;

/**
 * 国内运费成本Dao
 * Created by intanswer on 2017/1/17.
 */
public interface FreightCostDao {

    /**
     * 新增FreightCost对象，返回FreightCost对象（设置了新生成的id）
     * @param freightCost
     * @return
     */
    public FreightCost addFreightCost(FreightCost freightCost);
    /**
     * 按照主键id更新FreightCost，成功返回1
     */
    public int updateFreightCostById(int id, FreightCost freightCost);

    /**
     * 按照id删除记录，成功返回1
     * @param id
     * @return
     */
    public int deleteFreightCostById(int id);

    /**
     * 查询列表，包含分页查询，查询结果为空返回空的List对象
     * 查询分页信息，请设置
     * Query(设置当前页数)
     * Query(设置当前页面数据行数)
     * @param freightCostQuery
     * @return
     */
    public List<FreightCost> getFreightCostsByPage(FreightCostQuery freightCostQuery);

    public List<FreightCost> getFreightCostByQuery(FreightCostQuery freightCostQuery);

    /**
     * 查询总数
     * @param freightCostQuery
     * @return
     */
    public int count(FreightCostQuery freightCostQuery);

}
