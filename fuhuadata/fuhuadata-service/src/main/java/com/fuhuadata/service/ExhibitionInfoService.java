package com.fuhuadata.service;

import com.fuhuadata.domain.ExhibitionInfo;
import com.fuhuadata.domain.query.ExhibitionInfoQuery;
import com.fuhuadata.domain.query.Result;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by intanswer on 2017/1/13.
 */
public interface ExhibitionInfoService {

    public Result<ExhibitionInfo> addExhibitionInfo(ExhibitionInfo exhibitionInfo);

    public Result<List<ExhibitionInfo>> getExhibitionInfosByPage(ExhibitionInfoQuery exhibitonInfoQuery);

    public Result updateExhibitionInfoById(int id,ExhibitionInfo exhibitionInfo);

    public Result deleteExhibitionInfoById(int id);

    public  Result<Integer> count(ExhibitionInfoQuery exhibitionInfoQuery);


}
