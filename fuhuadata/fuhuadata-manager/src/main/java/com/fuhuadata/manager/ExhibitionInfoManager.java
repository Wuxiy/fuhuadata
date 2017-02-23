package com.fuhuadata.manager;

import com.fuhuadata.domain.ExhibitionInfo;
import com.fuhuadata.domain.query.ExhibitionInfoQuery;
import com.fuhuadata.domain.query.Result;

import java.util.List;

/**
 * 展会动态Manager
 * Created by intanswer on 2017/1/13.
 */
public interface ExhibitionInfoManager {

    public ExhibitionInfo addExhibitionInfo(ExhibitionInfo exhibitionInfo);

    public boolean updateExhibitionInfoById(int id,ExhibitionInfo exhibitionInfo);

    public boolean deleteExhibitionInfoById(int id);

    public ExhibitionInfo getExhibitionInfoById(int id);

    public List<ExhibitionInfo> getAllExhibitionInfos();

    public List<ExhibitionInfo> getExhibitionInfosByQuery(ExhibitionInfoQuery exhibitionInfoQuery);

    public Result<List<ExhibitionInfo>> getExhibitionInfosByPage(ExhibitionInfoQuery exhibitionInfoQuery);

    public int count(ExhibitionInfoQuery exhibitionInfoQuery);

}
