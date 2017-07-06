package com.fuhuadata.dao.mapper.customs;

import com.fuhuadata.dao.mapper.BaseMapper;
import com.fuhuadata.domain.customs.BarData;
import com.fuhuadata.domain.customs.CompareQuery;
import com.fuhuadata.domain.customs.CustomsData;
import com.fuhuadata.domain.customs.CustomsDataQuery;
import com.fuhuadata.domain.echarts.PieData;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

public interface CustomsDataMapper extends BaseMapper<CustomsData, Long> {

    void saveCustomsData(CustomsData customsData);

    int updateCustomsCountryId();

    /**
     * 更新海关数据某一个目的国的顶级国家id
     * @return
     */
    int updateCustomsCompany();

    List<CustomsData> listCustomsData();

    /**
     * 出口国家海关数据分析
     * @param query
     * @return
     */
    List<PieData> listCountryCustomsStatistics(CustomsDataQuery query);

    /**
     * 出口企业海关数据饼图分析
     * @param query
     * @return
     */
    List<PieData> listCompanyCustomsStatistics(CustomsDataQuery query);

    /**
     * 删除指定日期内的海关数据
     * @param startDate
     * @param endDate
     * @return
     */
    int deleteCustomsDataBetweenDate(@Param("startDate") LocalDate startDate,
                                     @Param("endDate") LocalDate endDate);

    /**
     * 出口国家柱状图数据
     * @param query
     * @return
     */
    List<BarData> listCountryBarData(CustomsDataQuery query);

    /**
     * 出口企业柱状图数据
     * @param query
     * @return
     */
    List<BarData> listCompanyBarData(CustomsDataQuery query);

    /**
     * 出口国家同比图数据
     * @param query
     * @return
     */
    List<BarData> listCountryCompareData(CompareQuery query);
}