package com.fuhuadata.dao;

import com.fuhuadata.domain.ExhibitionInfo;
import com.fuhuadata.domain.query.ExhibitionInfoQuery;

import java.util.List;

/**
 * 展会动态信息dao
 * Created by intanswer on 2017/1/13.
 */
public interface ExhibitionInfoDao {
    public ExhibitionInfo addExhibitionInfo(ExhibitionInfo exhibitionInfo);

    public List<ExhibitionInfo> getExhibitionInfosByPage(ExhibitionInfoQuery exhibitonInfoQuery);

    public int count(ExhibitionInfoQuery exhibitionInfoQuery);

}
