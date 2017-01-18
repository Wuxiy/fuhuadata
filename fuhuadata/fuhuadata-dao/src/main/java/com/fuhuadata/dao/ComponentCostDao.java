package com.fuhuadata.dao;

import com.fuhuadata.domain.ComponentCost;

import java.util.List;

/**
 * 成分价格dao
 * Created by intanswer on 2017/1/17.
 */
public interface ComponentCostDao {
    /**
     * 新增componentCost对象，返回设置了新生成的id
     * @param componentCost
     * @return
     */
    public ComponentCost addComponentCost(ComponentCost componentCost);

    /**
     * 按照主键id更新，成功返回1
     * @param id
     * @param componentCost
     * @return
     */
    public int updateComponentCostById(int id, ComponentCost componentCost);

    /**
     * 按照主键id删除记录，成功返回1
     * @param id
     * @return
     */
    public int deleteComponentCostById(int id);

    /**
     * 分页查询列表
     * Query(设置当前页数和当前页面行数）
     * @param componentCost
     * @return
     */
    public List<ComponentCost> getComponentCostsByPage(ComponentCost componentCost);

    /**
     * 查询总数
     * @param componentCost
     * @return
     */
    public int count(ComponentCost componentCost);

}
