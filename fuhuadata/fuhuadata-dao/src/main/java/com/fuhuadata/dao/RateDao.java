package com.fuhuadata.dao;

import com.fuhuadata.domain.Rate;
import com.fuhuadata.domain.query.RateQuery;

import java.util.List;

/**
 * 费率Dao
 * Created by young on 2017/2/8.
 */
public interface RateDao {
    /**
     * 新增rate对象，返回设置了新生成的id
     * @param rate
     * @return
     */
    public Rate addRate(Rate rate);

    /**
     * 按照主键id更新，成功返回1
     * @param id
     * @param rate
     * @return
     */
    public int updateRateById(int id, Rate rate);

    /**
     * 按照主键id删除记录，成功返回1
     * @param id
     * @return
     */
    public int deleteRateById(int id);

    /**
     * 查询不带分页
     * @param rateQuery
     * @return
     */
    public List<Rate> getRateByQuery(RateQuery rateQuery);

    /**
     * 分页查询列表
     * Query(设置当前页数和当前页面行数）
     * @param rateQuery
     * @return
     */
    public List<Rate> getRatesByPage(RateQuery rateQuery);

    /**
     * 查询总数
     * @param rateQuery
     * @return
     */
    public int count(RateQuery rateQuery);
}
