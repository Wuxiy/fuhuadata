package com.fuhuadata.service.mybatis.customs;

import com.fuhuadata.domain.customs.BarResult;
import com.fuhuadata.domain.customs.CompareQuery;
import com.fuhuadata.domain.customs.CustomsData;
import com.fuhuadata.domain.customs.CustomsDataQuery;
import com.fuhuadata.domain.echarts.PieData;
import com.fuhuadata.service.mybatis.BaseService;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/20/2017
 */
public interface CustomsDataService extends BaseService<CustomsData, Long> {

    /**
     * 导入 Excel
     * @param startDate
     * @param endDate
     * @param inputStream
     */
    void importCustomsData(LocalDate startDate, LocalDate endDate, InputStream inputStream);

    /**
     * 更新导入海关数据的国家id
     * @return
     */
    int updateCustomsCountryId();

    /**
     * 更新海关数据的公司id
     * @return
     */
    int updateCustomsCompanyId();

    /**
     * 获取海关数据分析结果，出口国家分析 or 出口企业分析
     * @param query
     * @return
     */
    List<PieData> listCustomsData(CustomsDataQuery query);

    /**
     * 获取出口国家柱状图
     * @param query
     * @return
     */
    BarResult getCountryBarData(CustomsDataQuery query);

    /**
     * 获取出口公司柱状图数据
     * @param query
     * @return
     */
    BarResult getCompanyBarData(CustomsDataQuery query);

    /**
     * 出口国家同比图数据
     * @param query
     * @return
     */
    BarResult getCountryCompareData(CompareQuery query);
}
