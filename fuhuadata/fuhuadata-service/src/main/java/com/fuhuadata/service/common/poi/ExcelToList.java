package com.fuhuadata.service.common.poi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuhuadata.domain.customs.CustomesDataTypePropertyEditor;
import com.fuhuadata.domain.customs.CustomsData;
import com.fuhuadata.service.common.poi.exception.ExcelException;
import com.fuhuadata.service.util.SpringUtils;
import com.google.common.collect.Maps;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;

import java.beans.PropertyEditor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * <p>User: wangjie
 * <p>Date: 6/19/2017
 */
public class ExcelToList<T> {

    private Workbook workbook = null;
    private ArrayList<T> listData = null;
    private Class<T> entityClass = null;
    private LinkedHashMap<String, String> fieldMap = null;
    private HashMap<String, Integer> columnIndexMap = null;
    private Map<String, PropertyEditor> propertyEditorMap = null;

    private static ConversionService conversionService;

    public ExcelToList(InputStream inputStream, Class<T> entityClass, LinkedHashMap<String, String> fieldMap)
            throws IOException, InvalidFormatException {
        this(inputStream, entityClass, fieldMap, null);
    }

    public ExcelToList(InputStream inputStream, Class<T> entityClass, LinkedHashMap<String, String> fieldMap, Map<String, PropertyEditor> propertyEditorMap)
            throws IOException, InvalidFormatException {

        this.workbook = WorkbookFactory.create(inputStream);
        this.fieldMap = fieldMap;
        this.entityClass = entityClass;
        this.propertyEditorMap = propertyEditorMap;
    }

    public static void setConversionService(ConversionService conversionService) {
        ExcelToList.conversionService = conversionService;
    }

    public static ConversionService getConversionService() {
        if (conversionService == null) {
            synchronized (ExcelToList.class) {
                if (conversionService == null) {
                    try {
                        conversionService = SpringUtils.getBean(ConversionService.class);
                    } catch (Exception e) {
                        throw new ExcelException("ConversionService不能为空");
                    }
                }
            }
        }
        return conversionService;
    }

    public List<T> covertToList() {

        Sheet sheet = null;
        Row row = null;
        int lastRowNum = 0;
        this.listData = new ArrayList<>(10000);
        this.columnIndexMap = new HashMap<>();

        sheet = this.workbook.getSheetAt(0);
        if (sheet.getPhysicalNumberOfRows() > 1) {

            // 处理列名，以便后面根据实体中文名取出excel中的数据
            Row firstRow = sheet.getRow(0);
            for (Cell cell : firstRow) {
                String columnName = cell.getRichStringCellValue().getString();
                columnIndexMap.put(columnName, cell.getColumnIndex());
            }

            lastRowNum = sheet.getLastRowNum();
            for (int rowNum = 1; rowNum <= lastRowNum; rowNum++) {
                row = sheet.getRow(rowNum);
                this.rowToEntityList(row);
            }

            closeWorkbook();

            return this.listData;
        } else {
            throw new ExcelException("Excel表无数据");
        }
    }

    private void closeWorkbook() {
        try {
            this.workbook.close();
        } catch (IOException e) {
            throw new ExcelException("关闭 InputStream 流失败", e);
        }
    }

    private void rowToEntityList(Row row) {

        T instance;
        try {
            instance = entityClass.newInstance();
        } catch (Exception e) {
            throw new ExcelException("初始化实体[" + entityClass.getSimpleName() + "]失败");
        }

        BeanWrapper beanWrapper = new BeanWrapperImpl(instance);
        beanWrapper.setAutoGrowNestedPaths(true);
        beanWrapper.setConversionService(getConversionService());
        registerCustomEditor(beanWrapper);

        fieldMap.entrySet().forEach(zhEnEntry -> {
            String cnName = zhEnEntry.getKey();
            String enName = zhEnEntry.getValue();
            Integer cellnum = columnIndexMap.get(cnName);

            if (cellnum != null) {
                Cell cell = row.getCell(cellnum);
                beanWrapper.setPropertyValue(enName, getCellValue(cell));
            }
        });

        listData.add((T) beanWrapper.getWrappedInstance());
    }

    private void registerCustomEditor(BeanWrapper beanWrapper) {

        if (propertyEditorMap == null) {
            return;
        }

        this.propertyEditorMap.forEach((s, propertyEditor) -> beanWrapper.registerCustomEditor(null, s, propertyEditor));
    }

    private Object getCellValue(Cell cell) {

        Object value = null;

        switch (cell.getCellTypeEnum()) {
            case STRING:
                value = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    value = cell.getDateCellValue();
                } else {
                    value = cell.getNumericCellValue();
                }
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case FORMULA:
                value = cell.getCellFormula();
                break;
            case BLANK:
                value = "";
                break;
            default:
                value = null;
        }

        return value;
    }

    public static void main(String[] args) throws IOException, InvalidFormatException {

        String excelPath = "C:\\Users\\user\\Desktop\\customs_data_less.xls";
        String largeExcelPath = "C:\\Users\\user\\Desktop\\海关数据-四川福华-草甘膦-1501-1512汇总数据分析.xls";
        String large07ExcelPath = "C:\\Users\\user\\Desktop\\海关数据-四川福华-草甘膦-1501-1512汇总数据分析.xlsx";
        File file = new File(large07ExcelPath);

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

        Map<String, PropertyEditor> propertyEditorMap = new HashMap<>();
        propertyEditorMap.put("type", new CustomesDataTypePropertyEditor());

        ConversionService conversionService = new DefaultFormattingConversionService(true);

        ExcelToList.setConversionService(conversionService);

        ExcelToList<CustomsData> excelToList =
                new ExcelToList<>(new FileInputStream(file), CustomsData.class, fieldMap, propertyEditorMap);

        long startTime = System.currentTimeMillis();

        List<CustomsData> datas = excelToList.covertToList();

        long endTime = System.currentTimeMillis();

        System.out.println("Excel转换时间：" + (endTime - startTime) + "ms");

        ObjectMapper objectMapper = new ObjectMapper();
        datas.forEach(customsData -> {
            try {
                System.out.println(objectMapper.writeValueAsString(customsData));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
    }
}
