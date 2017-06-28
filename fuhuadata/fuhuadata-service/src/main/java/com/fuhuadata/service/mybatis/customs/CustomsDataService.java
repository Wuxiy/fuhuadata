package com.fuhuadata.service.mybatis.customs;

import com.fuhuadata.domain.customs.CustomsData;
import com.fuhuadata.domain.customs.CustomsDataQuery;
import com.fuhuadata.domain.echarts.PieData;
import com.fuhuadata.service.mybatis.BaseService;

import java.io.InputStream;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/20/2017
 */
public interface CustomsDataService extends BaseService<CustomsData, Long> {

    /**
     * 导入 Excel
     * @param inputStream
     */
    void importCustomsData(InputStream inputStream);

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

    List<PieData> listCustomsData(CustomsDataQuery query);
}
