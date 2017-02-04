package com.fuhuadata.dao;

import com.fuhuadata.domain.IndustryData;
import com.fuhuadata.domain.query.IndustryDataQuery;

import java.util.List;

/**
 * 行业数据dao
 * Created by intanswer on 2017/1/23.
 */
public interface IndustryDataDao {

    public IndustryData addIndustryData(IndustryData industryData);

    //public int updateIndustryDataById(int id,IndustryData industryData);

    public List<IndustryData> getIndustryDatasByPage(IndustryDataQuery industryDataQuery);

    public int count(IndustryDataQuery industryDataQuery);


}
