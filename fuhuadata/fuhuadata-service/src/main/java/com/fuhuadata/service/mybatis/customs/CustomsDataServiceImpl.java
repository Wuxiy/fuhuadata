package com.fuhuadata.service.mybatis.customs;

import com.fuhuadata.dao.mapper.customs.CustomsDataMapper;
import com.fuhuadata.domain.customs.*;
import com.fuhuadata.domain.echarts.PieData;
import com.fuhuadata.service.common.poi.ExcelToList;
import com.fuhuadata.service.exception.ServiceException;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.fuhuadata.service.mybatis.customs.exception.DuplicateProductMatchException;
import com.fuhuadata.service.mybatis.customs.matcher.RegexProductMatcher;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.beans.PropertyEditor;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * <p>User: wangjie
 * <p>Date: 6/20/2017
 */
@Service
@Validated
public class CustomsDataServiceImpl extends BaseServiceImpl<CustomsData, Long>
        implements CustomsDataService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private CustomsDataMapper getCustomsDataMapper() {
        return (CustomsDataMapper) baseMapper;
    }

    private CustomsDataMapper getBatchCustomsMapper() {
        return this.sqlSessionBatch.getMapper(CustomsDataMapper.class);
    }

    @Resource
    private CustomsProductRuleService productRuleService;

    @Resource
    private CustomsCountryService countryService;

    @Resource
    private CustomsCompanyService companyService;

    @Override
    public void importCustomsData(@NotNull LocalDate startDate, @NotNull LocalDate endDate, @NotNull InputStream inputStream) {

        if (inputStream == null || startDate == null || endDate == null) {
            return;
        }

        List<CustomsData> customsDatas = excelToCustomsList(inputStream);

        // 删除数据库已存在的海关数据
        endDate = endDate.plusDays(1);
        getBatchCustomsMapper().deleteCustomsDataBetweenDate(startDate, endDate);
        // 保存海关数据到数据库
        long startTime = System.currentTimeMillis();
        saveCustomsDatas(customsDatas);
        long endTime = System.currentTimeMillis();
        logger.info("海关数据插入数据库时间：" + (endTime - startTime) + "ms");

        updateCustomsCountryId();
        updateCustomsCompanyId();
    }

    private List<CustomsData> excelToCustomsList(InputStream inputStream) {
        LinkedHashMap<String, String> fieldMap = getCustomsDataFiledMap();

        Map<String, PropertyEditor> propertyEditorMap = new HashMap<>();
        propertyEditorMap.put("type", new CustomesDataTypePropertyEditor());

        ExcelToList<CustomsData> excelToList;
        try {
            excelToList = new ExcelToList<>(inputStream, CustomsData.class, fieldMap, propertyEditorMap);
        } catch (Exception e) {
            try {
                inputStream.close();
            } catch (IOException e1) {
                throw new ServiceException("上传流关闭失败", e1);
            }
            throw new ServiceException("Excel 导入失败", e);
        }

        long startTime = System.currentTimeMillis();
        List<CustomsData> customsDatas = excelToList.covertToList();
        long endTime = System.currentTimeMillis();
        logger.info("Excel转换时间：" + (endTime - startTime) + " ms");

        return customsDatas;
    }

    private LinkedHashMap<String, String> getCustomsDataFiledMap() {
        LinkedHashMap<String, String> fieldMap = Maps.newLinkedHashMap();
        fieldMap.put("日期", "cdate");
        fieldMap.put("进出口", "type");
        fieldMap.put("海关口岸", "customsOrg");
        fieldMap.put("主管关区", "customsArea");
        fieldMap.put("目的港或起运港", "port");
        fieldMap.put("中转国", "transitCountry");
        fieldMap.put("目的国或起运国", "originDestCountry");
        fieldMap.put("所属洲", "continent");
        fieldMap.put("申报单位名称", "declareCompany");
        fieldMap.put("货主单位名称", "shipperCompany");
        fieldMap.put("经营单位名称", "operationCompany");
        fieldMap.put("经营单位代码", "operationComCode");
        fieldMap.put("产销地", "productMarketLocation");
        fieldMap.put("海关编码", "customsCode");
        fieldMap.put("产品名称", "productName");
        fieldMap.put("规格", "specifications");
        fieldMap.put("成交方式", "dealMethod");
        fieldMap.put("申报单价", "declarePrice");
        fieldMap.put("价格单位", "priceUnit");
        fieldMap.put("申报数量", "declareNum");
        fieldMap.put("申报单位", "declareNumUnit");
        fieldMap.put("总价", "totalPrice");
        fieldMap.put("法定数量", "legalNum");
        fieldMap.put("法定单位", "legalUnit");
        fieldMap.put("美元单价", "dollarPrice");
        fieldMap.put("美元总价", "dollarTotal");
        fieldMap.put("美元币制", "dollarCrrency");
        fieldMap.put("毛重", "grossWeight");
        fieldMap.put("净重", "netWeight");
        fieldMap.put("重量单位", "weightUnit");
        fieldMap.put("贸易方式", "tradeMode");
        fieldMap.put("运输方式", "tradeMode");
        fieldMap.put("件数", "transportMode");
        fieldMap.put("包装种类", "packingType");
        fieldMap.put("企业性质", "enterpriseNature");
        fieldMap.put("地址", "address");
        fieldMap.put("电话", "telephoneNumber");
        fieldMap.put("传真", "fax");
        fieldMap.put("邮编", "postCode");
        fieldMap.put("邮箱", "email");
        fieldMap.put("联系人", "contactMan");
        return fieldMap;
    }

    private void saveCustomsDatas(List<CustomsData> customsDatas) {

        List<CustomsProductRule> rules = productRuleService.listProductRules();
        RegexProductMatcher matcher = new RegexProductMatcher(rules);

        int count = 0;
        CustomsDataMapper batchCustomsMapper = getBatchCustomsMapper();
        for (CustomsData entity : customsDatas) {

            try {
                handleCustomsData(entity);// 设置目的国id和公司id
                Integer productId = matcher.matchProductId(entity.getProductName(), entity.getSpecifications());
                entity.setProductId(productId != null ? productId : 0);// 未匹配的产品，productId设置为0
            } catch (DuplicateProductMatchException e) {
                logger.error(e.getMessage(), e);
                entity.setProductId(100);
            }

            batchCustomsMapper.saveCustomsData(entity);
            count++;

            if (count % BATCH_SIZE == 0) {
                sqlSessionBatch.flushStatements();
            }
        }

        logger.error("产品规则匹配重复的海关数据：[{}]", matcher.duplicateData.toJSONString());

        sqlSessionBatch.flushStatements();
    }

    private void handleCustomsData(CustomsData entity) {
        entity.setDestCountryId(33);// 目的国默认 Others
        entity.setCompanyId(2);// 公司默认 Others
    }

    @Override
    public int updateCustomsCountryId() {

        return getBatchCustomsMapper().updateCustomsCountryId();
    }

    @Override
    public int updateCustomsCompanyId() {

        return getBatchCustomsMapper().updateCustomsCompany();
    }

    @Override
    public List<PieData> listCustomsData(CustomsDataQuery query) {

        if (query.getEndDate() != null) {
            query.setEndDate(query.getEndDate().plusDays(1));
        }

        if (StatCategory.COUNTRY == query.getStatCategory()) {
            List<PieData> pieData = getCustomsDataMapper().listCountryCustomsStatistics(query);
            return listCountryPieData(pieData);
        } else if (StatCategory.COMPANY == query.getStatCategory()) {
            List<PieData> pieData = getCustomsDataMapper().listCompanyCustomsStatistics(query);
            return listCompanyPieData(pieData);
        }

        return Collections.emptyList();
    }

    @Override
    public BarResult getCountryBarData(CustomsDataQuery query) {

        List<BarData> barData = getCustomsDataMapper().listCountryBarData(query);

        List<Integer> countryIds = query.getStatIds();
        List<CustomsCountry> countries = countryService.listCountries(countryIds);
        List<String> countryNames = countries.stream()
                .map(CustomsCountry::getName)
                .collect(toList());
        Map<Integer, String> idMapName = countries.stream()
                .collect(toMap(CustomsCountry::getId, CustomsCountry::getName));

        return getBarResult(query, barData, countryNames, idMapName);
    }

    @Override
    public BarResult getCompanyBarData(CustomsDataQuery query) {

        List<BarData> barData = getCustomsDataMapper().listCompanyBarData(query);

        List<Integer> companyIds = query.getStatIds();
        List<CustomsCompany> companies = companyService.listCompanies(companyIds);
        List<String> companyNames = companies.stream()
                .map(CustomsCompany::getName)
                .collect(toList());
        Map<Integer, String> idToName = companies.stream()
                .collect(toMap(CustomsCompany::getId, CustomsCompany::getName));

        return getBarResult(query, barData, companyNames, idToName);
    }

    @Override
    public BarResult getCountryCompareData(CompareQuery query) {

        LocalDate startDate = query.getStartDate();
        query.setFirstStartDate(startDate.with(firstDayOfMonth()));
        query.setFirstEndDate(startDate.with(lastDayOfMonth()));
        query.setStartDate(null);

        LocalDate endDate = query.getEndDate();
        query.setSecondStartDate(endDate.with(firstDayOfMonth()));
        query.setSecondEndDate(endDate.with(lastDayOfMonth()));
        query.setEndDate(null);

        // 数据库数据
        List<BarData> barData = getCustomsDataMapper().listCountryCompareData(query);

        // 获取同比图分类
        List<Integer> countryIds = query.getStatIds();
        List<CustomsCountry> countries = countryService.listCountries(countryIds);
        Map<Integer, String> countryIdToName = countries.stream()
                .collect(toMap(CustomsCountry::getId, CustomsCountry::getName));
        List<String> categories = countries.stream()
                .map(CustomsCountry::getName)
                .collect(toList());

        BiFunction<Integer, Integer, String> nameFunction = (year, month) -> year + "-" + month;

        // 获取同比图标识，这里是对比的两个月份 yyyy-MM
        List<String> legends = Lists.newArrayList();
        legends.add(nameFunction.apply(startDate.getYear(), startDate.getMonthValue()));
        legends.add(nameFunction.apply(endDate.getYear(), endDate.getMonthValue()));

        BarResult barResult = new BarResult();
        barResult.setCategories(categories);
        barResult.setLegends(legends);
        ListMultimap<String, Double> barOriginalData = barResult.initData();

        for (BarData record : barData) {
            barOriginalData.get(nameFunction.apply(record.getYearFlag(), record.getMonthFlag()))
                    .set(categories.indexOf(countryIdToName.get(record.getId())), record.getValue());
        }

        return barResult;
    }

    @Override
    public HashMap getDateRange() {
        return getCustomsDataMapper().getDateRange() ;
    }

    private BarResult getBarResult(CustomsDataQuery query, List<BarData> barData, List<String> countryNames, Map<Integer, String> idMapName) {
        String timeType = query.getTimeType();
        LocalDate startDate = query.getStartDate();
        LocalDate endDate = query.getEndDate();

        Function<BarData, String> meterName = null;
        List<BarMeter> meters = null;
        if ("year".equals(timeType)) {

            meters = BarMeter.listMetersOfYear(startDate, endDate);
            meterName = (BarData record) -> BarMeter.getMeterName(record.getYearFlag());

        } else if ("month".equals(timeType)) {

            meters = BarMeter.listMeterOfMonth(startDate, endDate);// 获取两个日期之间的间隔月份
            meterName = (BarData record) -> BarMeter.getMeterName(record.getYearFlag(), record.getMonthFlag());
        }

        if (meterName == null || meters == null) {
            return null;
        }

        List<String> categoryNames = meters.stream()
                .map(BarMeter::getName)
                .collect(toList());

        BarResult barResult = new BarResult();
        barResult.setLegends(countryNames);// 设置标签
        barResult.setCategories(categoryNames);// 设置分类
        ListMultimap<String, Double> barOrgiData = barResult.initData();// 根据标签、分类初始化数据

        for (BarData record : barData) {
            barOrgiData.get(idMapName.get(record.getId()))
                    .set(categoryNames.indexOf(meterName.apply(record)), record.getValue());
        }
        return barResult;
    }

    private List<PieData> listCountryPieData(List<PieData> countryData) {

        Map<Integer, PieData> countryDataMap = countryData.stream()
                .collect(toMap(PieData::getId, Function.identity()));

        return countryService.listCountries()
                .stream()
                .map(country -> {
                    PieData pieData = null;

                    if (countryDataMap.get(country.getId()) != null) {
                        pieData = countryDataMap.get(country.getId());
                    } else {
                        pieData = new PieData(country.getId(), country.getName(), 0.0);
                    }

                    return pieData;
                })
                .collect(toList());
    }

    private List<PieData> listCompanyPieData(List<PieData> companyData) {

        Map<Integer, PieData> pieMap = companyData.stream()
                .collect(toMap(PieData::getId, Function.identity()));

        return companyService.listTopCompanies()
                .stream()
                .map(company -> {
                    PieData pieData = null;

                    if (pieMap.get(company.getId()) != null) {
                        pieData = pieMap.get(company.getId());
                    } else {
                        pieData = new PieData(company.getId(), company.getName(), 0.0);
                    }

                    return pieData;
                })
                .collect(toList());
    }
}
