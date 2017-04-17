package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.DataArchivesDao;
import com.fuhuadata.vo.DataArchive.Currtype;
import com.fuhuadata.vo.DataArchive.Income;
import com.fuhuadata.vo.DataArchive.Incoterm;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 *
 * Created by intanswer on 2017/4/17.
 */
public class DataArchivesDaoImpl extends SqlMapClientTemplate implements DataArchivesDao  {
    private static final String GET_INCOME = "DATAARCHIVES.GET-INCOME";
    private static final String GET_CURRTYPE = "DATAARCHIVES.GET-CURRTYPE";
    private static final String GET_INCOTERM = "DATAARCHIVES.GET-INCOTERM";
    @Override
    public List<Income> getIncome() {
        return this.queryForList(GET_INCOME);
    }

    @Override
    public List<Currtype> getCurrtype() {
        return this.queryForList(GET_CURRTYPE);
    }

    @Override
    public List<Incoterm> getIncoterm() {
        return this.queryForList(GET_INCOTERM);
    }
}
