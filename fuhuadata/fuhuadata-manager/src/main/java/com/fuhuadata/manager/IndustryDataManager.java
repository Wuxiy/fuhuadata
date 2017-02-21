package com.fuhuadata.manager;

import com.fuhuadata.domain.IndustryData;
import com.fuhuadata.domain.query.IndustryDataQuery;
import com.fuhuadata.domain.query.Result;

import java.util.List;

/**
 * 行业数据Manager
 * Created by intanswer on 2017/1/23.
 */
public interface IndustryDataManager {
    public IndustryData addIndustryData(IndustryData industryData);

    public List<IndustryData> getIndustryDataByQuery(IndustryDataQuery industryDataQuery);

    public Result<List<IndustryData>> getIndustryDatasByPage(IndustryDataQuery industryDataQuery);

    public int count(IndustryDataQuery industryDataQuery);
}
