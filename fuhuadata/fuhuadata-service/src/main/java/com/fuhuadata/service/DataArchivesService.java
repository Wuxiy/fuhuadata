package com.fuhuadata.service;

import com.fuhuadata.domain.query.Result;
import com.fuhuadata.vo.DataArchive.Currtype;
import com.fuhuadata.vo.DataArchive.Income;
import com.fuhuadata.vo.DataArchive.Incoterm;

import java.util.List;

/**
 * Created by intanswer on 2017/4/17.
 */
public interface DataArchivesService {

    /**
     * 收款协议
     * @return
     */
    public Result<List<Income>> getIncome();

    /**
     * 币种
     * @return
     */
    public Result<List<Currtype>> getCurrtype();

    /**
     * 贸易术语
     * @return
     */
    public Result<List<Incoterm>> getIncoterm();


}
