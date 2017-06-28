package com.fuhuadata.dao.mapper.customs;

import com.fuhuadata.dao.mapper.BaseMapper;
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

    List<PieData> listCustomsStatistics(CustomsDataQuery query);

    /**
     * 删除指定日期内的海关数据
     * @param startDate
     * @param endDate
     * @return
     */
    int deleteCustomsDataBetweenDate(@Param("startDate") LocalDate startDate,
                                     @Param("endDate") LocalDate endDate);
}