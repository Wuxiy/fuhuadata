package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.IndustryDataDao;
import com.fuhuadata.domain.IndustryData;
import com.fuhuadata.domain.query.IndustryDataQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * 行业数据DaoImpl
 * Created by intanswer on 2017/1/23.
 */
public class IndustryDataDaoImpl extends SqlMapClientTemplate implements IndustryDataDao {
    public static final String ADD="INDUSTRYDATA.ADD";
    public static final String GET_PAGE="INDUSTRYDATA.GET-PAGE";
    public static final String COUNT="INDUSTRYDATA.COUNT";

    @Override
    public IndustryData addIndustryData(IndustryData industryData) {
        industryData.setId((Integer) this.insert(ADD,industryData));
        return industryData;
    }

    @Override
    public List<IndustryData> getIndustryDatasByPage(IndustryDataQuery industryDataQuery) {
        return this.queryForList(GET_PAGE,industryDataQuery);
    }

    @Override
    public int count(IndustryDataQuery industryDataQuery) {
        return ((Integer) this.queryForObject(COUNT,industryDataQuery)).intValue();
    }
}
