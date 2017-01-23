package com.fuhuadata.service;

import com.fuhuadata.domain.IndustryData;
import com.fuhuadata.domain.query.IndustryDataQuery;
import com.fuhuadata.domain.query.Result;

import java.util.List;

/**
 * 行业数据service
 * Created by intanswer on 2017/1/23.
 */
public interface IndustryDataService {

    public Result<IndustryData> addIndustryData(IndustryData industryData);

    public Result<List<IndustryData>> getIndustryDatasByPage(IndustryDataQuery industryDataQuery);

    public Result<Integer> count(IndustryDataQuery industryDataQuery);
}
