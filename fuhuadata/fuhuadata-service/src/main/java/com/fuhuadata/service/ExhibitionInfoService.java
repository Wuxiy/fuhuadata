package com.fuhuadata.service;

import com.fuhuadata.domain.ExhibitionInfo;
import com.fuhuadata.domain.query.ExhibitionInfoQuery;
import com.fuhuadata.domain.query.Result;

import java.util.List;

/**
 * Created by intanswer on 2017/1/13.
 */
public interface ExhibitionInfoService {

    public Result<ExhibitionInfo> addExhibitionInfo(ExhibitionInfo exhibitionInfo);

    public Result<List<ExhibitionInfo>> getExhibitionInfosByPage(ExhibitionInfoQuery exhibitonInfoQuery);

    public  Result<Integer> count(ExhibitionInfoQuery exhibitionInfoQuery);


}
