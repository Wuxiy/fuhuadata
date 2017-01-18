package com.fuhuadata.dao;

import com.fuhuadata.domain.PreparationProcessCost;

import java.util.List;

/**
 * 制剂加工成本dao
 * Created by intanswer on 2017/1/17.
 */
public interface PreparationProcessCostDao {
    /**
     * 新增preparationProcessCost对象，返回设置了新生成的id
     * @param preparationProcessCost
     * @return
     */
    public PreparationProcessCost addComponentCost(PreparationProcessCost preparationProcessCost);

    /**
     * 按照主键id更新，成功返回1
     * @param id
     * @param preparationProcessCost
     * @return
     */
    public int updatePreparationProcessCostById(int id, PreparationProcessCost preparationProcessCost);

    /**
     * 按照主键id删除记录，成功返回1
     * @param id
     * @return
     */
    public int deleteComponentCostById(int id);

    /**
     * 分页查询列表
     * Query(设置当前页数和当前页面行数）
     * @param preparationProcessCost
     * @return
     */
    public List<PreparationProcessCost> getComponentCostsByPage(PreparationProcessCost preparationProcessCost);

    /**
     * 查询总数
     * @param preparationProcessCost
     * @return
     */
    public int count(PreparationProcessCost preparationProcessCost);

}
