package com.fuhuadata.service;

import com.fuhuadata.domain.PreparationProcessCost;
import com.fuhuadata.domain.query.PreparationProcessCostQuery;
import com.fuhuadata.domain.query.Result;

import java.util.List;

/**
 * 制剂加工成本Service
 * Created by intanswer on 2017/1/17.
 */
public interface PreparationProcessCostService {
    /**
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel（）得到新增的PreparationProcessCost
     * @param preparationProcessCost
     * @return
     */
    public Result<PreparationProcessCost> addPreparationProcessCost(PreparationProcessCost preparationProcessCost);

    public Result updatePreparationProcessCost(int id, PreparationProcessCost preparationProcessCost);

    public Result deletePreparationProcessCost(int id);
    /**
     * 查询列表，包含分页查询
     * 查询分页信息，请设置
     * Query(设置当前页数)
     * Query(设置当前页面数据行数)
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getTotal()返回结果总数
     * 通过result.getModel()得到查询的单页列表信息
     * @param preparationProcessCostQuery
     * @return
     */
    public Result<List<PreparationProcessCost>> getPreparationProcessCostsByPage(PreparationProcessCostQuery preparationProcessCostQuery);

    public Result<Integer> count(PreparationProcessCostQuery preparationProcessCostQuery);

}
