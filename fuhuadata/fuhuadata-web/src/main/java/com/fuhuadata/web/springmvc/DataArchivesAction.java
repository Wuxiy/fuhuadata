package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.DataArchivesService;
import com.fuhuadata.vo.DataArchive.Currtype;
import com.fuhuadata.vo.DataArchive.Income;
import com.fuhuadata.vo.DataArchive.Incoterm;
import com.fuhuadata.vo.DataArchive.Portdoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by intanswer on 2017/4/17.
 */
@Controller
@RequestMapping("/dataArchives")
public class DataArchivesAction {

    @Autowired
    private DataArchivesService dataArchivesService;

    /**
     * 收款协议
     * @return
     */
    @RequestMapping("/getIncome")
    @ResponseBody
    public ResultPojo getIncome(){
        Result<List<Income>> result = new Result<List<Income>>();
        try {
            result = dataArchivesService.getIncome();
        }catch (Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
     }

    /**
     *  贸易术语
     * @return
     */
    @RequestMapping("/getIncoterm")
    @ResponseBody
    public ResultPojo getIncoterm(){
        Result<List<Incoterm>> result = new Result<List<Incoterm>>();
        try {
            result = dataArchivesService.getIncoterm();
        }catch (Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     *  币种
     * @return
     */
    @RequestMapping("/getCurrtype")
    @ResponseBody
    public ResultPojo getCurrtype(){
        Result<List<Currtype>> result = new Result<List<Currtype>>();
        try {
            result = dataArchivesService.getCurrtype();
        }catch (Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     *  港口档案
     * @return
     */
    @RequestMapping("/getPortdoc")
    @ResponseBody
    public ResultPojo getPortdoc(@RequestBody Portdoc portdoc){
        Result<List<Portdoc>> result = new Result<List<Portdoc>>();
        try {
            result = dataArchivesService.getPortdoc(portdoc);
        }catch (Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }
}
