package com.fuhuadata.service;

import com.fuhuadata.domain.FreightCost;
import com.fuhuadata.domain.query.FreightCostQuery;
import com.fuhuadata.domain.query.Result;

import java.util.List;

/**
 * 国内运费成本service
 * Created by intanswer on 2017/1/17.
 */
public interface FreightCostService  {

    public Result<FreightCost> addFreightCost(FreightCost freightCost);

    public Result updateFreightCostById(int id, FreightCost freightCost);

    public Result deleteFreightCostById(int id);

    /**
     * 查询列表，包含分页查询
     * 查询分页信息，请设置
     * Query(设置当前页数)
     * Query(设置当前页面数据行数)
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getTotal()返回结果总数
     * 通过result.getModel()得到查询的单页列表信息
     * @param freightCostQuery
     * @return
     */
    public Result<List<FreightCost>> getFreightCostsByPage(FreightCostQuery freightCostQuery);

    public Result<List<FreightCost>> getFreightCostsByQuery(FreightCostQuery freightCostQuery);

    public Result<Integer> count(FreightCostQuery freightCostQuery);

}
