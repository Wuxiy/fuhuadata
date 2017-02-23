package com.fuhuadata.service;

import com.fuhuadata.domain.Rate;
import com.fuhuadata.domain.query.RateQuery;
import com.fuhuadata.domain.query.Result;

import java.util.List;

/**
 * 费率service
 * Created by young on 2017/2/9.
 */
public interface RateService {

    /**
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel（）得到新增的Rate
     * @param rate
     * @return
     */

    public Result<Rate> addRate(Rate rate);
    public Result updateRate(int id,Rate rate);
    public Result deleteRate(int id);
    public Result<Rate> getRateById(int id);

    public Result<List<Rate>> getRateByQuery(RateQuery rateQuery);

    /**
     * 查询列表，包含分页查询
     * 查询分页信息，请设置
     * Query(设置当前页数)
     * Query(设置当前页面数据行数)
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getTotal()返回结果总数
     * 通过result.getModel()得到查询的单页列表信息
     * @param rateQuery
     * @return
     */
    public Result<List<Rate>> getRatesByPage(RateQuery rateQuery);

    public Result count(RateQuery rateQuery);

}
