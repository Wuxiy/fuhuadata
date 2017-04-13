package com.fuhuadata.service.impl;

import com.fuhuadata.dao.BusinessOrderProductComponentDao;
import com.fuhuadata.dao.BusinessOrderProductDao;
import com.fuhuadata.dao.BusinessProductRequireDao;
import com.fuhuadata.dao.CustomerProductArchivesDao;
import com.fuhuadata.domain.BusinessOrderProduct;
import com.fuhuadata.domain.BusinessOrderProductComponent;
import com.fuhuadata.domain.BusinessProductRequire;
import com.fuhuadata.domain.CustomerProductArchives;
import com.fuhuadata.domain.query.QueryBusinessOrderProduct;
import com.fuhuadata.domain.query.QueryCustomerProductArchives;
import com.fuhuadata.service.BusinessOrderProductService;
import com.fuhuadata.vo.Price.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hexingfu on 2017/4/5.
 */
@Service
public class BusinessOrderProductServiceImpl implements BusinessOrderProductService {

    @Autowired
    private BusinessOrderProductDao businessOrderProductDao;
    @Autowired
    private BusinessOrderProductComponentDao businessOrderProductComponentDao;
    @Autowired
    private CustomerProductArchivesDao customerProductArchivesDao;
    @Autowired
    private BusinessProductRequireDao businessProductRequireDao;


    @Transactional
    public int addBusinessOrderProduct(BusinessOrderProduct businessOrderProduct,List<BusinessOrderProductComponent> businessOrderProductComponents) {
        try {
            int businessProductId = businessOrderProductDao.insertBaseInfo(businessOrderProduct);
            for(BusinessOrderProductComponent bopc:businessOrderProductComponents){
                bopc.setBusinessProductId(businessProductId);
            }
            boolean flag = businessOrderProductComponentDao.insertProductComponent(businessOrderProductComponents);
            if(!flag){
               throw new Exception("插入产品成品失败");
            }
            //维护档案数据
            int businessProductArchivesId = customerProductArchivesDao.addArchives(businessProductId);
            if(businessProductArchivesId<1){
                throw new Exception("插入档案失败");
            }
            Map<String,Object> pmap = new HashMap<String,Object>();
            pmap.put("businessProductId",businessProductId);
            pmap.put("businessProductArchivesId",businessProductArchivesId);
            if(businessOrderProductComponentDao.addArchives(pmap)<1){
                throw new Exception("插入档案失败");
            }
            return businessProductId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Transactional
    public int addFromArchives(String customerId,String orderId,Integer businessProductId, Integer productId, Integer wareId) {
        try {
            //如果是修改状态，则删除当前数据，然后再复制档案数据
            if(businessProductId!=null && businessProductId>0){
                businessOrderProductDao.deleteAllInfoByIds(businessProductId+"");
            }
            //检查该用户是否买过当前规格型号的产品
            QueryCustomerProductArchives queryCustomerProductArchives = new QueryCustomerProductArchives();
            queryCustomerProductArchives.setCustomerId(customerId);
            queryCustomerProductArchives.setProductId(productId);
            queryCustomerProductArchives.setWareId(wareId);
            List<CustomerProductArchives> list = customerProductArchivesDao.getCustomerProductInfosByQuery(queryCustomerProductArchives);
            if(list == null || list.size()==0){
                return 0;
            }
            int business_product_archives_id = list.get(0).getId();
            //如果买过，则从档案复制信息到订单产品
            //1、复制订单产品基本信息，单据要求，订舱出运要求
            BusinessOrderProduct businessOrderProduct = new BusinessOrderProduct();
            businessOrderProduct.setOrderId(orderId);
            businessOrderProduct.setArchiveProductId(business_product_archives_id);
            businessOrderProduct.setCreateUserName("admin");
            businessOrderProduct.setCreateUserId(0);
            businessOrderProduct.setLastmodifyUserId(0);
            businessOrderProduct.setLastmodifyUserName("admin");
            int new_businessProductId =  businessOrderProductDao.insertFromArchives(businessOrderProduct);
            //2.复制产品成分及其费用
            Map<String,Object> param_map = new HashMap<String,Object>();
            param_map.put("businessProductId",new_businessProductId);
            param_map.put("businessProductArchivesId",business_product_archives_id);
            businessOrderProductComponentDao.insertFromArchives(param_map);
            //3.复制包装要求
            BusinessProductRequire businessProductRequire = new BusinessProductRequire();
            businessProductRequireDao.insertFromArchives(param_map);
            return new_businessProductId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean deleteAllInfoByIds(String businessProductIds) {
        try {
            return businessOrderProductDao.deleteAllInfoByIds(businessProductIds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public BusinessOrderProduct getBaiscById(int id) {
        return businessOrderProductDao.getBaiscById(id);
    }

    @Override
    public BusinessOrderProduct getDocumentaryById(int id) {
        return businessOrderProductDao.getDocumentaryById(id);
    }

    @Override
    public BusinessOrderProduct getPackageRequireById(int id) {
        return businessOrderProductDao.getPackageRequireById(id);
    }

    @Override
    public int updateBusinessOrderProduct(BusinessOrderProduct businessOrderProduct) throws Exception {
        //先修改订单产品数据
       int effect_num =  businessOrderProductDao.updateBusinessOrderProduct(businessOrderProduct);
        //更新档案数据
        customerProductArchivesDao.updateArchives(businessOrderProduct.getId());
        return effect_num;
    }

    @Override
    public List<BusinessOrderProduct> getList(QueryBusinessOrderProduct queryBusinessOrderProduct) {
        return businessOrderProductDao.getList(queryBusinessOrderProduct);
    }

    @Override
    public int count(QueryBusinessOrderProduct queryBusinessOrderProduct) {
        return businessOrderProductDao.count(queryBusinessOrderProduct);
    }

    @Override
    public List<BusinessOrderProduct> getListByPage(QueryBusinessOrderProduct queryBusinessOrderProduct) {
        return businessOrderProductDao.getListByPage(queryBusinessOrderProduct);
    }

    @Override
    public Price getPriceForBusinessProduct(Integer businessProductId) {
        //查询订单产品的价格计算方式
        int priceType = businessOrderProductDao.getPriceType(businessProductId);
        Price price = null;
        switch (priceType){
            case 0:
                price = getSelfProductionPrice(businessProductId);
                break;
            case 1:
                price = getOuterProcessingPrice(businessProductId);
                break;
            case 2:
                price = getProcurementProcessingPrice(businessProductId);
                break;
            case 3:
                price = getTradePrice(businessProductId);
                break;
        }
        return price;
    }

    /**
     * 自产类价格计算
     * @param businessProductId
     * @return
     */
    private Price getSelfProductionPrice(Integer businessProductId){
        return null;
    }

    /**
     * 外加工价格计算
     * @param businessProductId
     * @return
     */
    private Price getOuterProcessingPrice(Integer businessProductId){
        return null;
    }

    /**
     * 原药采购加工类价格计算
     * @param businessProductId
     * @return
     */
    private Price getProcurementProcessingPrice(Integer businessProductId){
        return null;
    }

    /**
     * 贸易类价格计算
     * @param businessProductId
     * @return
     */
    private Price getTradePrice(Integer businessProductId){
        return null;
    }

    @Override
    public BigDecimal calculateProcessCost(Integer businessProductId) {
        return null;
    }

    @Override
    public BigDecimal calculateMinPrice(Integer businessProductId) {
        return null;
    }
}
