package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.ExhibitionInfoDao;
import com.fuhuadata.domain.ExhibitionInfo;
import com.fuhuadata.domain.query.ExhibitionInfoQuery;
import com.fuhuadata.manager.ExhibitionInfoManager;
import com.fuhuadata.domain.query.Result;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by intanswer on 2017/1/13.
 */
public class ExhibitionInfoManagerImpl extends SqlMapClientTemplate implements ExhibitionInfoManager{

    private ExhibitionInfoDao exhibitionInfoDao;
    @Override

    public ExhibitionInfo addExhibitionInfo(ExhibitionInfo exhibitionInfo) {

        return exhibitionInfoDao.addExhibitionInfo(exhibitionInfo);
    }
    public boolean updateExhibitionInfoById(int id,ExhibitionInfo exhibitionInfo){
        return exhibitionInfoDao.updateExhibitionInfoById(id,exhibitionInfo)==1?true:false;
    }

    @Override
    public boolean deleteExhibitionInfoById(int id) {
        return exhibitionInfoDao.deleteExhibitionById(id)==1?true:false;
    }

    @Override
    public Result<List<ExhibitionInfo>> getExhibitionInfosByPage(ExhibitionInfoQuery exhibitionInfoQuery) {
        Result<List<ExhibitionInfo>> result = new Result<List<ExhibitionInfo>>();
        //统计查询总数
        int totalItem = exhibitionInfoDao.count(exhibitionInfoQuery);
        exhibitionInfoQuery.setTotalItem(totalItem);
        if(totalItem > 0){
            result.addDefaultModel("ExhibitionInfos",exhibitionInfoDao.getExhibitionInfosByPage(exhibitionInfoQuery));
        }else{
            result.addDefaultModel("ExhibitionInfos",new ArrayList<ExhibitionInfo>());
        }
        result.setPageSize(exhibitionInfoQuery.getPageSize());
        result.setIndex(exhibitionInfoQuery.getIndex());
        result.setTotalItem(totalItem);
        return result;
    }

    @Override
    public int count(ExhibitionInfoQuery exhibitionInfoQuery) {
        return exhibitionInfoDao.count(exhibitionInfoQuery);
    }

    public ExhibitionInfoDao getExhibitionInfoDao(){
        return this.exhibitionInfoDao;
    }

    public void setExhibitionInfoDao(ExhibitionInfoDao exhibitionInfoDao){
        this.exhibitionInfoDao=exhibitionInfoDao;
    }
}
