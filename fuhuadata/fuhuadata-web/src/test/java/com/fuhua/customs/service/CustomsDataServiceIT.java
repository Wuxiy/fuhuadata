package com.fuhua.customs.service;

import com.fuhua.test.BaseIT;
import com.fuhuadata.domain.customs.CustomsDataQuery;
import com.fuhuadata.domain.echarts.PieData;
import com.fuhuadata.service.mybatis.customs.CustomsDataService;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/20/2017
 */
public class CustomsDataServiceIT extends BaseIT {

    @Resource
    private CustomsDataService customsDataService;

    @Test
    public void testImportExcel() throws FileNotFoundException {

        String excelPath = "C:\\Users\\user\\Desktop\\customs_data_less.xls";
        String largeExcelPath = "C:\\Users\\user\\Desktop\\海关数据-四川福华-草甘膦-1501-1512汇总数据分析.xls";
        String large07ExcelPath = "C:\\Users\\user\\Desktop\\海关数据-四川福华-草甘膦-1501-1512汇总数据分析.xlsx";
        File file = new File(large07ExcelPath);

        long startTime = System.currentTimeMillis();
        customsDataService.importCustomsData(null, null, new FileInputStream(file));
        long endTime = System.currentTimeMillis();

        System.out.println("Excel导入：" + (endTime - startTime) + "ms");
    }

    @Test
    public void testListCountryStatistics() {

        CustomsDataQuery query = new CustomsDataQuery();
        query.setStartDate(LocalDate.of(2015, Month.JANUARY, 1));
        query.setEndDate(LocalDate.of(2015, Month.JANUARY, 1));
        query.setStatType("dollar_total");
        query.setCategoryType("type");
        query.setCategoryId(1);

        List<PieData> pieDatas = customsDataService.listCustomsData(query);
    }
}
