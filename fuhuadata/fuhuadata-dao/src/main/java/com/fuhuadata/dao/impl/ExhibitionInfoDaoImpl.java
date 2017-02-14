package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.ExhibitionInfoDao;
import com.fuhuadata.domain.ExhibitionInfo;
import com.fuhuadata.domain.query.ExhibitionInfoQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by intanswer on 2017/1/13.
 */
public class ExhibitionInfoDaoImpl extends SqlMapClientTemplate implements ExhibitionInfoDao {

    private static final String ADD="EXHIBITIONINFO.ADD";
    private static final String GET_PAGE="EXHIBITIONINFO.GET-PAGE";
    private static final String COUNT="EXHIBITIONINFO.COUNT";
    private static final String UPDATE="EXHIBITIONINFO.UPDATE";
    private static final String DELETE_BY_ID="EXHIBITIONINFO.DELETE-BY-ID";
    @Override
    public ExhibitionInfo addExhibitionInfo(ExhibitionInfo exhibitionInfo) {
        exhibitionInfo.setExhibitionId((Integer) this.insert(ADD,exhibitionInfo));
        return exhibitionInfo;
    }

    @Override
    public List<ExhibitionInfo> getExhibitionInfosByPage(ExhibitionInfoQuery exhibitonInfoQuery) {
        List<ExhibitionInfo> list = this.queryForList(GET_PAGE,exhibitonInfoQuery);
        return list;
    }

    @Override
    public int updateExhibitionInfoById(int id, ExhibitionInfo exhibitionInfo) {
        exhibitionInfo.setExhibitionId(id);
        return this.update(UPDATE,exhibitionInfo);
    }
    @Override
    public int deleteExhibitionById(int id) {
        return this.update(DELETE_BY_ID,id);
    }

    @Override
    public int count(ExhibitionInfoQuery exhibitionInfoQuery) {
        return ((Integer) this.queryForObject(COUNT,exhibitionInfoQuery)).intValue();
    }
}
