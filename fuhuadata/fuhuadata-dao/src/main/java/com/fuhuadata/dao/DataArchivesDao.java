package com.fuhuadata.dao;

import com.fuhuadata.vo.DataArchive.Currtype;
import com.fuhuadata.vo.DataArchive.Income;
import com.fuhuadata.vo.DataArchive.Incoterm;

import java.util.List;

/**
 * 数据档案
 * Created by intanswer on 2017/4/17.
 */
public interface DataArchivesDao {
    /**
     * 收款协议
     * @return
     */
    public List<Income> getIncome();

    /**
     * 币种
     * @return
     */
    public List<Currtype> getCurrtype();

    /**
     * 贸易术语
     * @return
     */
    public List<Incoterm> getIncoterm();
}
