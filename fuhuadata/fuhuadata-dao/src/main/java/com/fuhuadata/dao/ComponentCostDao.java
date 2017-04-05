package com.fuhuadata.dao;

import com.fuhuadata.domain.ComponentCost;
import com.fuhuadata.domain.KProductComponent;
import com.fuhuadata.domain.query.ComponentCostQuery;

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


    public int addSuitableProduct(List<KProductComponent> KProductComponents);

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

    public int deleteProductComponentCostById(int componentId);

    /**
     * 根据主键id获取ComponentCost
     * @param id
     * @return
     */
    public ComponentCost getComponentCostById(int id);

    /**
     * 根据适用品类获取成分
     * @param productCategoryId
     * @return
     */
    public List<ComponentCost> getComponentCostByCategoryId(int productCategoryId);

    /**
     * 根据成分id获取适用品类
     * @param id
     * @return
     */
    public List<KProductComponent> getProductComponentByComponentId(int id);

    /**
     * 查询不带分页
     * @param componentCostQuery
     * @return
     */
    public List<ComponentCost> getComponentCostsByQuery(ComponentCostQuery componentCostQuery);

    /**
     * 分页查询列表
     * Query(设置当前页数和当前页面行数）
     * @param componentCostQuery
     * @return
     */
    public List<ComponentCost> getComponentCostsByPage(ComponentCostQuery componentCostQuery);

    /**
     * 查询总数
     * @param componentCostQuery
     * @return
     */
    public int count(ComponentCostQuery componentCostQuery);

}
