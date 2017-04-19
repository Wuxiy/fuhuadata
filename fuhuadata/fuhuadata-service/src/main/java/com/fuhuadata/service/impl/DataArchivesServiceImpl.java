package com.fuhuadata.service.impl;

import com.fuhuadata.dao.DataArchivesDao;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.service.DataArchivesService;
import com.fuhuadata.vo.DataArchive.Currtype;
import com.fuhuadata.vo.DataArchive.Income;
import com.fuhuadata.vo.DataArchive.Incoterm;
import com.fuhuadata.vo.DataArchive.Portdoc;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sound.sampled.Port;
import java.util.List;

/**
 *
 * Created by intanswer on 2017/4/17.
 */
public class DataArchivesServiceImpl implements DataArchivesService{

    private static final Log log = LogFactory.getLog(DataArchivesServiceImpl.class);

    @Autowired
    private DataArchivesDao dataArchivesDao;

    @Override
    public Result<List<Income>> getIncome() {
       Result<List<Income>> result = new Result<List<Income>>();
       try{
           result.addDefaultModel("incomes",dataArchivesDao.getIncome());
       }catch(Exception e){
           result.setSuccess(false);
           log.error("获取收款协议出错",e);
       }
       return result;
    }

    @Override
    public Result<List<Currtype>> getCurrtype() {
        Result<List<Currtype>> result = new Result<List<Currtype>>();
        try{
            result.addDefaultModel("currtypes",dataArchivesDao.getCurrtype());
        }catch(Exception e){
            result.setSuccess(false);
            log.error("获取币种出错",e);
        }
        return result;
    }

    @Override
    public Result<List<Incoterm>> getIncoterm() {
        Result<List<Incoterm>> result = new Result<List<Incoterm>>();
        try{
            result.addDefaultModel("incomes",dataArchivesDao.getIncoterm());
        }catch(Exception e){
            result.setSuccess(false);
            log.error("获取贸易术语出错",e);
        }
        return result;
    }

    @Override
    public Result<List<Portdoc>> getPortdoc(Portdoc portdoc) {
        Result<List<Portdoc>> result = new Result<List<Portdoc>>();
        try{
            result.addDefaultModel("portdocs",dataArchivesDao.getPortdoc(portdoc));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("获取港口档案出错",e);
        }
        return result;
    }
}
