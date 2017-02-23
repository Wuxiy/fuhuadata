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

    public List<ExhibitionInfo> getAllExhibitionInfos();

    /**
     * 此接口不包含分页查询，查询结果为空时返回空的list对象
     * @param exhibitionInfoQuery
     * @return
     */
    public List<ExhibitionInfo> getExhibitionInfosByQuery(ExhibitionInfoQuery exhibitionInfoQuery);

    /**
     * 通过主键id查询EXHIBITIONINFO，查询不到返回NULL值
     * @param id
     * @return
     */
    public ExhibitionInfo getExhibitionInfoById(int id);

    public int updateExhibitionInfoById(int id,ExhibitionInfo exhibitionInfo);

    public int deleteExhibitionById(int id);

    public int count(ExhibitionInfoQuery exhibitionInfoQuery);

}
