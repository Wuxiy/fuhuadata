package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.BCodeDao;
import com.fuhuadata.domain.BCode;
import com.fuhuadata.domain.query.QueryBCode;
import com.fuhuadata.manager.BCodeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hexingfu on 2017/3/28.
 */
@Component
@Scope("singleton")
public class BCodeManagerImpl implements BCodeManager {

    @Autowired
    private BCodeDao bCodeDao;

    public synchronized int getNextBusinessCode() {
        return this.getNeedResetNext(1);
    }

    public synchronized int getNextOrderCode() {
        return this.getNeedResetNext(2);
    }

    public synchronized int getNextStandardProductCode() {
        return this.getNotNeedResetNext(3);
    }

    @Override
    public synchronized int getNextPackagingMaterialCode() {
        return this.getNotNeedResetNext(4);
    }

    private String getFormateToday(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    private int getNeedResetNext(int type){
        String today = getFormateToday();
        QueryBCode qb = new QueryBCode(type,today);
        BCode code = bCodeDao.getBcodeByQuery(qb);
        //如果当天没有数据，则生成当天数据
        if(code == null){
            code = new  BCode();
            code.setcType(type);
            code.setcDate(today);
            code.setCurrentVal(1);
            code.setNeedReset(1);
            bCodeDao.insertBcode(code);
            return 1;
        }else{
            int val = code.setNextVal();
            bCodeDao.setCurrentVal(code);
            return val;
        }
    }

    private int getNotNeedResetNext(int type){
        QueryBCode qb = new QueryBCode(type,null);
        BCode code = bCodeDao.getBcodeByQuery(qb);
        //如果当天没有数据，则初始化数据
        if(code == null){
            code = new  BCode();
            code.setcType(type);
            code.setCurrentVal(1);
            code.setNeedReset(0);
            bCodeDao.insertBcode(code);
            return 1;
        }else{
            int val = code.setNextVal();
            bCodeDao.setCurrentVal(code);
            return val;
        }
    }
}
