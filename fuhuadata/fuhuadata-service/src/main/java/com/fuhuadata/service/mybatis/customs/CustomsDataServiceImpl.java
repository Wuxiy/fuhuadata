package com.fuhuadata.service.mybatis.customs;

import com.fuhuadata.dao.mapper.customs.CustomsDataMapper;
import com.fuhuadata.domain.customs.CustomesDataTypePropertyEditor;
import com.fuhuadata.domain.customs.CustomsData;
import com.fuhuadata.domain.customs.CustomsDataQuery;
import com.fuhuadata.domain.customs.CustomsProductRule;
import com.fuhuadata.domain.echarts.PieData;
import com.fuhuadata.service.common.poi.ExcelToList;
import com.fuhuadata.service.exception.ServiceException;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.fuhuadata.service.mybatis.customs.exception.DuplicateProductMatchException;
import com.fuhuadata.service.mybatis.customs.matcher.RegexProductMatcher;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.beans.PropertyEditor;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>User: wangjie
 * <p>Date: 6/20/2017
 */
@Service
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

    @Override
    public void importCustomsData(LocalDate startDate, LocalDate endDate, InputStream inputStream) {

        List<CustomsData> customsDatas = excelToCustomsList(inputStream);

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
        return null;
    }
}
