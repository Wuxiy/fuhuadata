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
        return 0;
    }

    @Override
    public int deleteExhibitionById(int id) {
        return 0;
    }

    @Override
    public int count(ExhibitionInfoQuery exhibitionInfoQuery) {
        return ((Integer) this.queryForObject(COUNT,exhibitionInfoQuery)).intValue();
    }
}
