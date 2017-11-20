package com.fuhuadata.web.springmvc.customs;

import com.fuhuadata.domain.customs.*;
import com.fuhuadata.domain.echarts.PieData;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.domain.validation.groups.GroupOne;
import com.fuhuadata.service.mybatis.customs.CustomsDataService;
import com.fuhuadata.web.exception.InvalidRequestException;
import com.fuhuadata.web.springmvc.mybatis.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

/**
 * <p>User: wangjie
 * <p>Date: 6/28/2017
 */
@RequestMapping("/customs/data")
@Validated
@Controller
public class CustomsDataAction extends BaseController<CustomsData, Long> {

    @Resource
    private CustomsDataService customsDataService;

    @RequiresPermissions({"industry:market:view"})
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index() {
            HashMap<String,Date> dateRange =customsDataService.getDateRange();
        return new ModelAndView("industryData/countryPie")
                .addObject("maxDate",dateRange.get("maxDate"))
                .addObject("minDate",dateRange.get("minDate"));
    }

    @RequiresPermissions({"industry:market:view"})
    @RequestMapping(value = "/pie/company/vm", method = RequestMethod.GET)
    public ModelAndView companyPie() {
        //返回海关数据时间范围
        HashMap<String,Date> dateRange =customsDataService.getDateRange();
        return new ModelAndView("industryData/companyPie")
                .addObject("maxDate",dateRange.get("maxDate"))
                .addObject("minDate",dateRange.get("minDate"));
    }

    @RequiresPermissions({"industry:market:view"})
    @RequestMapping(value = "/bar/countries/vm", method = RequestMethod.GET)
    public ModelAndView countryBar() {
        //返回海关数据时间范围
        HashMap<String,Date> dateRange =customsDataService.getDateRange();
        return new ModelAndView("industryData/countryTendency")
                .addObject("maxDate",dateRange.get("maxDate"))
                .addObject("minDate",dateRange.get("minDate"));
    }

    // 出口企业趋势图
    @RequiresPermissions({"industry:market:view"})
    @RequestMapping(value = "/bar/companies/vm", method = RequestMethod.GET)
    public ModelAndView companyBar() {
        //返回海关数据时间范围
        HashMap<String,Date> dateRange =customsDataService.getDateRange();
        return new ModelAndView("industryData/companyTendency")
                .addObject("maxDate",dateRange.get("maxDate"))
                .addObject("minDate",dateRange.get("minDate"));
    }

    // 出口国家同比图
    @RequiresPermissions({"industry:market:view"})
    @RequestMapping(value = "/compare/companies/vm", method = RequestMethod.GET)
    public ModelAndView countryCompare() {
        //返回海关数据时间范围
        HashMap<String,Date> dateRange =customsDataService.getDateRange();
        return new ModelAndView("industryData/countryCompared")
                .addObject("maxDate",dateRange.get("maxDate"))
                .addObject("minDate",dateRange.get("minDate"));
    }

    @RequestMapping(value = "excel", method = RequestMethod.POST)
    @ResponseBody
    public ResultPojo importExcelData(@NotNull @RequestParam("excel") MultipartFile excel,
                                      @NotNull @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                      @NotNull @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        Result<String> result = Result.newResult(false);

        if (excel == null || startDate == null || endDate == null) {
            throw new InvalidRequestException("Bad Request");
        }

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
    public ResultPojo countryStatistics(@Validated CustomsDataQuery query, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InvalidRequestException("Bad Request", bindingResult);
        }

        Result<List<PieData>> result = Result.newResult(false);

        query.setStatCategory(StatCategory.COUNTRY);
        List<PieData> pieDatas = customsDataService.listCustomsData(query);
        result.addDefaultModel(pieDatas);
        result.setSuccess(true);

        return result.getResultPojo();
    }

    /**
     * 出口公司饼图数据
     * @param query
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "company", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo companyStatistics(@Validated CustomsDataQuery query, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InvalidRequestException("Bad Request", bindingResult);
        }

        Result<List<PieData>> result = Result.newResult(false);

        query.setStatCategory(StatCategory.COMPANY);
        List<PieData> pieData = customsDataService.listCustomsData(query);
        result.addDefaultModel(pieData);
        result.setSuccess(true);

        return result.getResultPojo();
    }

    /**
     * 出口国家柱状图数据
     * @param query
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/bar/country", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo countryBarStatistic(@Validated({Default.class, GroupOne.class}) CustomsDataQuery query,
                                          BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InvalidRequestException("Bad Request", bindingResult);
        }

        Result<BarResult> result = Result.newResult(false);

        // 设置开始日期为月份的第一天
        query.setStartDate(query.getStartDate().with(firstDayOfMonth()));
        // 设置结束日期为月份的最后一天
        query.setEndDate(query.getEndDate().with(lastDayOfMonth()));
        query.setStatCategory(StatCategory.COUNTRY);

        BarResult companyBarData = customsDataService.getCountryBarData(query);
        result.addDefaultModel(companyBarData);
        result.setSuccess(true);

        return result.getResultPojo();
    }

    /**
     * 出口公司柱状图数据
     * @param query
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/bar/company", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo companyBarStatistic(@Validated({Default.class, GroupOne.class}) CustomsDataQuery query,
                                          BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InvalidRequestException("Bad Request", bindingResult);
        }

        Result<BarResult> result = Result.newResult(false);

        // 设置开始日期为月份的第一天
        query.setStartDate(query.getStartDate().with(firstDayOfMonth()));
        // 设置结束日期为月份的最后一天
        query.setEndDate(query.getEndDate().with(lastDayOfMonth()));
        query.setStatCategory(StatCategory.COMPANY);

        BarResult companyBarData = customsDataService.getCompanyBarData(query);
        result.addDefaultModel(companyBarData);
        result.setSuccess(true);

        return result.getResultPojo();
    }

    /**
     * 同比图-出口国家分析
     * @param query
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/compare/country", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo countryCompareStatistic(@Validated({Default.class, GroupOne.class}) CompareQuery query,
                                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InvalidRequestException("Bad Request", bindingResult);
        }

        Result<BarResult> result = Result.newResult(false);

        query.setTimeType("month");
        query.setStatCategory(StatCategory.COUNTRY);

        BarResult countryCompareData = customsDataService.getCountryCompareData(query);
        result.addDefaultModel(countryCompareData);
        result.setSuccess(true);

        return result.getResultPojo();
    }
}
