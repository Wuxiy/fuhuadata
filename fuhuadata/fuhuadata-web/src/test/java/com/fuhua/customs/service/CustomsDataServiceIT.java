package com.fuhua.customs.service;

import com.fuhua.test.BaseIT;
import com.fuhuadata.service.mybatis.customs.CustomsDataService;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
        File file = new File(largeExcelPath);

        long startTime = System.currentTimeMillis();
        customsDataService.importCustomsData(new FileInputStream(file));
        long endTime = System.currentTimeMillis();

        System.out.println("Excel导入：" + (endTime - startTime) + "ms");
    }
}
