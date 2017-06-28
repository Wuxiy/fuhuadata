package com.fuhuadata.web.springmvc.customs;

import com.fuhuadata.domain.customs.CustomsData;
import com.fuhuadata.domain.customs.CustomsDataQuery;
import com.fuhuadata.domain.echarts.PieData;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.customs.CustomsDataService;
import com.fuhuadata.web.springmvc.mybatis.BaseController;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/28/2017
 */
@RequestMapping("/customs/data")
@Controller
public class CustomsDataAction extends BaseController<CustomsData, Long> {

    @Resource
    private CustomsDataService customsDataService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "industryData/countryPie";
    }

    @RequestMapping(value = "excel", method = RequestMethod.POST)
    @ResponseBody
    public ResultPojo importExcelData(@RequestParam("excel") MultipartFile excel,
                                      @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                      @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        Result<String> result = Result.newResult(false);

        try {
            // 导入海关数据
            customsDataService.importCustomsData(startDate, endDate, excel.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException("文件上传失败", e);
        }

        result.addDefaultModel("success");
        result.setSuccess(true);

        return result.getResultPojo();
    }

    @RequestMapping(value = "country", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo countryStatistics(CustomsDataQuery query) {

        Result<List<PieData>> result = Result.newResult(false);

        List<PieData> pieDatas = customsDataService.listCustomsData(query);
        result.addDefaultModel(pieDatas);
        result.setSuccess(true);

        return result.getResultPojo();
    }
}
