package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.*;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.*;
import com.fuhuadata.vo.CategoryTree;
import com.fuhuadata.vo.PackingArchivesVO;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Think on 2017/3/29.
 */
@Controller
@RequestMapping("/businessProduct/*")
public class BusinessOrderProductAction {

    private static final Logger log = Logger.getLogger(BusinessOrderProductAction.class);
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private BusinessOrderProductService businessOrderProductService;
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private BusinessOrderProductComponentService businessOrderProductComponentService;
    @Autowired
    private BusinessProductRequireService businessProductRequireService;
    @Autowired
    private PackingArchivesService packingArchivesService;

    /**
     * 进入添加订单产品基本信息页面
     * @param orderId
     * @return
     */
    @RequestMapping("/intoProductBasicInfoRequire")
    public ModelAndView intoProductBasicInfoRequire(String orderId,Integer businessProductId,Integer customerId){
        return new ModelAndView("salesStatistics/productBasicInfoRequire")
                .addObject("orderId",orderId)
                .addObject("customerId",customerId)
                .addObject("businessProductId",businessProductId);
    }

    /**
     * 初始化产品树
     * @return
     */
    @ResponseBody
    @RequestMapping("/initProductCatetroy")
    public ResultPojo initProductCatetroy(){
        Result<List<CategoryTree>> result = new Result<List<CategoryTree>>();
        try{
            result = productCategoryService.getTreeHasProductWare();
        }catch(Exception e){
            result.setSuccess(false);
            log.error("添加订单产品-初始化产品树失败，原因:"+e.getMessage());
        }
        return result.getResultPojo();
    }

    /**
     * 查询订单基本信息和产品成分信息
     * @param businessProductId
     * @return
     */
    @ResponseBody
    @RequestMapping("/detailBaseInfo")

    public Map<String,Object> detailBaseInfo(Integer businessProductId){
        Map<String,Object> map = new HashMap<String,Object>();
        //查询订单产品基本信息
        map.put("basicInfo",this.businessOrderProductService.getBaiscById(businessProductId));
        map.put("components",this.businessOrderProductComponentService.getProductComponentsByBusinessProductId(businessProductId));
        return map;
    }

    /**
     * 根据所选产品及其型号检查该用户是否购买过当前产品，如果购买过，则从档案复制数据
     * @param customerId
     * @param orderId
     * @param businessProductId
     * @param productId
     * @param wareId
     * @return
     */
    @ResponseBody
    @RequestMapping("/addFromArchives")
    public Map<String,Object> addFromArchives(Integer customerId,String orderId,
                                      Integer businessProductId,Integer productId,Integer wareId){
        Map<String,Object> map = new HashMap<String,Object>();
        try {

            boolean flag = businessOrderProductService.addFromArchives(customerId,orderId,businessProductId,productId,wareId);
            map.put("reload",flag);//如果成功复制档案，则需要重新加载页面，进入修改模式
            //如果第一次购买，则不需要重新加载页面，但是需要根据所选产品查询报关产品，加载产品成分
            if(!flag){
                //查询报关产品
                ProductInfo productInfo = productInfoService.getCustomsClearanceInfo(productId);
                if(productInfo!=null){
                    map.put("customsClearanceId",productInfo.getCustomsClearanceId());
                    map.put("customsClearanceName",productInfo.getCustomsClearanceName());
                }
                //查询产品成分信息
                map.put("components",businessOrderProductComponentService.getProductComponentsByProductId(productId));
            }
        } catch (Exception e) {
            log.error("添加订单产品-从档案复制新增失败，原因:"+e.getMessage());
        }
        return map;
    }

    /**
     * 保存订单产品基本信息和产品成分
     * @param businessOrderProduct
     * @param businessOrderProductComponents
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/saveBaseInfoAndComponents")
    public ResultPojo saveBaseInfoAndComponents(BusinessOrderProduct businessOrderProduct,BusinessOrderProductComponent[] businessOrderProductComponents){
        Integer businessProductId = businessOrderProduct.getId();
        ResultPojo pojo = new ResultPojo();
        List<BusinessOrderProductComponent> list = new ArrayList<BusinessOrderProductComponent>();
        for(BusinessOrderProductComponent bopc:businessOrderProductComponents){
            list.add(bopc);
        }
        try {
            //修改
            if(businessProductId!=null && businessProductId>0){
                //修改基本信息
                businessOrderProductService.updateBusinessOrderProduct(businessOrderProduct);
                //修改成分及费用信息
                businessOrderProductComponentService.updateProductComponent(list);
            }else{
                //新增
                businessProductId = businessOrderProductService.addBusinessOrderProduct(businessOrderProduct,list);
            }
        } catch (Exception e) {
            e.printStackTrace();
            pojo.setData(false);
        }
        pojo.setData(true);
        return pojo;
    }

    /**
     * 进入产品要求页面
     * @param orderId
     * @param businessProductId
     * @return
     */
    @RequestMapping("/intoProductRequire")
    public ModelAndView intoProductProcCompRequire(String orderId,Integer businessProductId ){
        return new ModelAndView("salesStatistics/productProcCompRequire")
                .addObject("orderId",orderId)
                .addObject("businessProductId",businessProductId);
    }

    /**
     *查询产品要求信息
     * @param businessProductId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getProductRequireInfo")
    public Map<String,Object> getProductRequireInfo(Integer businessProductId){
        Map<String,Object> map = new HashMap<String,Object>();
        //存放外包装数据
        List<PackingArchives> outer = new ArrayList<PackingArchives>();
        //存放辅材数据
        List<PackingArchives> auxiliary = new ArrayList<PackingArchives>();
        BusinessProductRequire businessProductRequire = this.businessProductRequireService.getByOrderProductId(businessProductId);
        map.put("productRequire",businessProductRequire);
        if(businessProductRequire!=null){
            //如果查询到有信息，则需要查询该主材的型号列表和辅材列表便于前端渲染已选型号和辅材外包装
            PackingArchivesVO pao = packingArchivesService.getPackingArchivesById(businessProductRequire.getMainPackingId()).getModel();
            map.put("modelist",pao.getImagePath());
            List<PackingArchives> allList = pao.getNodes();
            if(allList!=null){
                //由于主材关联的辅材和外包装id集中存在一个字段中，所以allList中既包含辅材也包含外包装在此需做区分
                for(PackingArchives pa:allList){
                    //外包装的id为2
                    if(pa.getBigCategoryId()==2){
                        outer.add(pa);
                    }else if(pa.getBigCategoryId()==3){
                        auxiliary.add(pa);
                    }
                }
            }
        }
        map.put("outer",outer);
        map.put("auxiliary",auxiliary);
        return map;
    }

    /**
     * 选择某一主材后，查询其默认信息
     * @param packingArchivesId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getPackingArchivesInfo")
    public Map<String,Object> getPackingArchivesInfo(Integer packingArchivesId){
        Map<String,Object> map = new HashMap<String,Object>();
        //存放外包装数据
        List<PackingArchives> outer = new ArrayList<PackingArchives>();
        //存放辅材数据
        List<PackingArchives> auxiliary = new ArrayList<PackingArchives>();
        PackingArchivesVO pao = packingArchivesService.getPackingArchivesById(packingArchivesId).getModel();
        map.put("modelist",pao.getImagePath());
        map.put("main",pao.getPack());
        List<PackingArchives> allList = pao.getNodes();
        if(allList!=null){
            //由于主材关联的辅材和外包装id集中存在一个字段中，所以allList中既包含辅材也包含外包装在此需做区分
            for(PackingArchives pa:allList){
                //外包装的id为2
                if(pa.getBigCategoryId()==2){
                    outer.add(pa);
                }else if(pa.getBigCategoryId()==3){
                    auxiliary.add(pa);
                }
            }
        }
        return map;
    }

    /**
     * 保存产品要求
     * @param businessProductRequire
     * @return
     */
    @ResponseBody
    @RequestMapping("/saveProductRequire")
    public boolean saveProductRequire(BusinessProductRequire businessProductRequire){
        Integer businessProductRequireId = businessProductRequire.getId();
        try {
            if(businessProductRequireId == null || businessProductRequireId == 0){
                 //没有id则新增数据
                businessProductRequireId =  businessProductRequireService.addProductRequire(businessProductRequire);
            }else{
                businessProductRequireService.updateProductRequire(businessProductRequire);
            }
            return true;
        } catch (Exception e) {
            log.error("保存产品要求错误：" + e.getMessage());
        }
        return false;
    }

    /**
     * 进入单据要求页面
     * @param businessProductId
     * @return
     */
    @RequestMapping("intoDocumentary")
    public ModelAndView intoDocumentary(Integer businessProductId){
        return new ModelAndView("").addObject("businessProductId",businessProductId);
    }

    /**
     * 获取单据要求
     * @param businessProductId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getDocumentary")
    public Map<String,Object> getDocumentary(Integer businessProductId){
        Map<String,Object> map = new HashMap<String,Object>();
        BusinessOrderProduct businessOrderProduct = businessOrderProductService.
                getDocumentaryById(businessProductId);
        map.put("documentaryType",businessOrderProduct.getDocumentaryType());
        map.put("documentaryRequire",businessOrderProduct.getDocumentaryRequire());
        map.put("otherDocumentaryRequire",businessOrderProduct.getOtherDocumentaryRequire());
        return map;
    }

    /**
     * 保存单据要求或订舱出运要求
     * @param businessOrderProduct
     * @return
     */
    @ResponseBody
    @RequestMapping("/saveDocumentaryOrPacking")
    public boolean saveDocumentaryOrPacking(BusinessOrderProduct businessOrderProduct){
        try {
            if(businessOrderProduct.getId()!=null){
               businessOrderProductService.updateBusinessOrderProduct(businessOrderProduct);
               return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 进入订舱出运要求页面
     * @param businessProductId
     * @return
     */
    @RequestMapping("intoPackageRequire")
    public ModelAndView intoPackageRequire(Integer businessProductId){
        return new ModelAndView().addObject("businessProductId",businessProductId);
    }

    /**
     * 获取订舱出运要求
     * @param businessProductId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getPackageRequire")
    public BusinessOrderProduct getPackageRequire(Integer businessProductId){
       return businessOrderProductService.getPackageRequireById(businessProductId);
    }
}
