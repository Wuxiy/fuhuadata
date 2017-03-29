package com.fuhuadata.service.impl;

import com.fuhuadata.domain.PackingArchives;
import com.fuhuadata.domain.ProductInfo;
import com.fuhuadata.manager.BCodeManager;
import com.fuhuadata.service.BCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hexingfu on 2017/3/28.
 */
@Service
public class BCodeServiceImpl implements BCodeService {
    @Autowired
    private BCodeManager bCodeManager;
    //商机编号前缀
    private static final String PREFIX_BUSINESS  = "SJ";
    //商机编号后缀序号位数
    private static  final int BUSINESS_BIT_NUM = 4;
    //订单编号前缀
    private static final String PREFIX_ORDER  = "DD";
    //订单编号后缀序号位数
    private static  final int ORDER_BIT_NUM = 4;

    @Override
    public String getNextBusinessCode() {
        int indx = bCodeManager.getNextBusinessCode();
        String code = "";
        for(int i=1;i<BUSINESS_BIT_NUM;i++){
            if(indx< Math.pow(10,i) && indx>=Math.pow(10,i-1)){
                for(int j=1;j <= BUSINESS_BIT_NUM-i;j++){
                    code+="0";
                }
                break;
            }
        }
        code += indx;
        return PREFIX_BUSINESS + getToday() + code;
    }

    /*public  static void main(String[] args){
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("fuhuadata/fuhuadata-web/src/main/resources/spring-config.xml");
        BCodeService s = (BCodeService)context.getBean(BCodeService.class);
        for(int i=1;i<=100;i++){
            System.out.println(s.getNextOrderCode());
        }
    }*/
    @Override
    public String getNextOrderCode() {
        int indx = bCodeManager.getNextOrderCode();
        String code = "";
        for(int i=1;i<ORDER_BIT_NUM;i++){
            if(indx< Math.pow(10,i) && indx>=Math.pow(10,i-1)){
                for(int j=1;j <= ORDER_BIT_NUM-i;j++){
                    code+="0";
                }
                break;
            }
        }
        code += indx;
        return PREFIX_ORDER + getToday() + code;
    }

    @Override
    public String getNextStandardProductCode(ProductInfo productInfo) {
        String[] split_categroy = productInfo.getCategoryName().split("-");
        String one_level = null;
        String two_level = null;
        String three_level = null;
        one_level = productInfo.getBigCategoryId()+"";
        two_level = productInfo.getMidCategoryId() < 10
                ? "0"+productInfo.getMidCategoryId() : productInfo.getMidCategoryId()+"";
        //化工品和贸易品不存在第三级，用0占位
        if(one_level.equals("4") || one_level.equals("5")){
            three_level = "0";
        }else if(split_categroy[2].equals("原药")){
            //原药编码
            three_level = "1";
        }else{
            //水剂编码
            three_level = "2";
        }
        return one_level + two_level + three_level + bCodeManager.getNextStandardProductCode();
    }

    @Override
    public String getNextPackagingMaterialCode(PackingArchives packingArchives) {
        return packingArchives.getBigCategoryId()+ "" + bCodeManager.getNextPackagingMaterialCode();

    }

    private String getToday(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(new Date());
    }
}
