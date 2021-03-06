package com.fuhuadata.service.impl;

import com.fuhuadata.dao.*;
import com.fuhuadata.domain.*;
import com.fuhuadata.domain.query.BusinessOrderProductsAddByCopy;
import com.fuhuadata.domain.query.QueryBusinessOrderProduct;
import com.fuhuadata.domain.query.QueryCustomerProductArchives;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.service.BusinessOrderProductService;
import com.fuhuadata.service.exception.ServiceException;
import com.fuhuadata.service.util.LoginUtils;
import com.fuhuadata.vo.BusinessOrderProductVO;
import com.fuhuadata.vo.Price.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
    @Autowired
    private BusinessOrderDao businessOrderDao;
    @Autowired
    private IncomeDao incomeDao;
    @Autowired
    private ProductInfoDao productInfoDao;
    @Autowired
    private ProductWareDao productWareDao;
    public int addBusinessOrderProduct(BusinessOrderProduct businessOrderProduct,List<BusinessOrderProductComponent> businessOrderProductComponents) {
        try {
            businessOrderProduct.setCreateUserId(LoginUtils.getLoginId());
            businessOrderProduct.setCreateUserName(LoginUtils.getLoginName());
            businessOrderProduct.setLastmodifyUserName(LoginUtils.getLoginName());
            businessOrderProduct.setLastmodifyUserId(LoginUtils.getLoginId());
            int businessProductId = businessOrderProductDao.insertBaseInfo(businessOrderProduct);
            for(BusinessOrderProductComponent bopc:businessOrderProductComponents){
                bopc.setBusinessProductId(businessProductId);
                bopc.setWareId(businessOrderProduct.getWareId());
                bopc.setProductId(businessOrderProduct.getProductId());
            }
            if(businessOrderProductComponents.size()>0){
                boolean flag = businessOrderProductComponentDao.insertProductComponent(businessOrderProductComponents);
                if(!flag){
                    throw new Exception("插入产品成品失败");
                }
            }
            //维护档案数据
            int businessProductArchivesId = customerProductArchivesDao.addArchives(businessProductId);
            System.out.println("档案数据id"+businessProductArchivesId);
            if(businessProductArchivesId<1){
                throw new Exception("插入档案失败");
            }
            //将档案id回写到订单产品表
            BusinessOrderProduct bop = new BusinessOrderProduct();
            bop.setId(businessProductId);
            bop.setArchiveProductId(businessProductArchivesId);
            businessOrderProductDao.updateBusinessOrderProduct(bop);
            //添加产品成分档案
            if(businessOrderProductComponents.size()>0){
                Map<String,Object> pmap = new HashMap<String,Object>();
                pmap.put("businessProductId",businessProductId);
                pmap.put("businessProductArchivesId",businessProductArchivesId);
                if(businessOrderProductComponentDao.addArchives(pmap)<1){
                    throw new Exception("插入档案失败");
                }
            }
            return businessProductId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Transactional
    public Map<String,Object> addFromArchives(String customerId,String orderId,Integer businessProductId, Integer productId, Integer wareId) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("businessProductId",0);
        map.put("productRequireId",0);
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
                return map;
            }
            int business_product_archives_id = list.get(0).getId();
            //如果买过，则从档案复制信息到订单产品
            //1、复制订单产品基本信息，单据要求，订舱出运要求
            BusinessOrderProduct businessOrderProduct = new BusinessOrderProduct();
            businessOrderProduct.setOrderId(orderId);
            businessOrderProduct.setArchiveProductId(business_product_archives_id);
            businessOrderProduct.setCreateUserName(LoginUtils.getLoginName());
            businessOrderProduct.setCreateUserId(LoginUtils.getLoginId());
            businessOrderProduct.setLastmodifyUserId(LoginUtils.getLoginId());
            businessOrderProduct.setLastmodifyUserName(LoginUtils.getLoginName());
            int new_businessProductId =  businessOrderProductDao.insertFromArchives(businessOrderProduct);
            map.put("businessProductId",new_businessProductId);
            //2.复制产品成分及其费用
            Map<String,Object> param_map = new HashMap<String,Object>();
            param_map.put("businessProductId",new_businessProductId);
            param_map.put("businessProductArchivesId",business_product_archives_id);
            /*businessOrderProductComponentDao.insertFromArchives(param_map);*/
            //3.复制包装要求
            BusinessProductRequire businessProductRequire = new BusinessProductRequire();
            map.put("productRequireId", businessProductRequireDao.insertFromArchives(param_map));
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
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
        BusinessOrderProduct businessOrderProduct = businessOrderProductDao.getBaiscById(id);
        if(businessOrderProduct!=null){
            ProductWare productWare = productWareDao.getProductWareById(businessOrderProduct.getWareId());
            businessOrderProduct.setSpecification(productWare.getSpecification());
            businessOrderProduct.setModel(productWare.getModel());
        }
        return businessOrderProduct;
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
        int effect_num;
        if (businessOrderProduct.getOrderId()!=null){
            effect_num= businessOrderProductDao.updateBusinessOrderProduct_basic(businessOrderProduct);
        }else {
            effect_num = businessOrderProductDao.updateBusinessOrderProduct(businessOrderProduct);
        }
        updatePrice(businessOrderProduct);
        //更新档案数据
        customerProductArchivesDao.updateArchives(businessOrderProduct.getId());
        return effect_num;
    }
    //更新最低价，加工费
    private void updatePrice(BusinessOrderProduct businessOrderProduct) throws Exception {
        String priceType =businessOrderProduct.getPriceType()!=null ?
                businessOrderProduct.getPriceType() :
                businessOrderProductDao.getPriceType(businessOrderProduct.getId());
        if(priceType!=null &&("02".equals(priceType) || "04".equals(priceType))){
            //更新加工费
            businessOrderProduct.setProcessCost(businessOrderProductDao.calculateProcessCost(businessOrderProduct.getId()));
        }
        BusinessProductRequire businessProductRequire = new BusinessProductRequire();
        businessProductRequire.setBusinessProductId(businessOrderProduct.getId());
        if(businessProductRequireDao.getOneByQuery(businessProductRequire)!=null){
            //更新最低价
            businessOrderProduct.setMinPrice(calculateMinPrice(businessOrderProduct.getId()));
        }
        //先修改订单产品数据
        businessOrderProduct.setLastmodifyUserId(LoginUtils.getLoginId());
        businessOrderProduct.setLastmodifyUserName(LoginUtils.getLoginName());
        businessOrderProductDao.updateBusinessOrderProduct(businessOrderProduct);
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
        String priceType = businessOrderProductDao.getPriceType(businessProductId);
        Price price = null;
        if ("01".equals(priceType)) {
            price = getSelfProductionPrice(businessProductId);
        }else if("02".equals(priceType)){
            price = getOuterProcessingPrice(businessProductId);
        }else if("04".equals(priceType)){
            price = getProcurementProcessingPrice(businessProductId);
        }else if("03".equals(priceType)){
            price = getTradePrice(businessProductId);
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
        return businessOrderProductDao.calculateProcessCost(businessProductId);
    }

    /**
     *
     * @param businessProductId
     * @return
     */
    public BigDecimal calculateMinPrice(Integer businessProductId) {
        BusinessOrderProduct basic =  businessOrderProductDao.getBaiscById(businessProductId);
        BusinessOrder order = businessOrderDao.getById(basic.getOrderId());
        int tax_type = basic.getTaxType();
        if(tax_type==1){
            //按销售价退税
            return calculatePriceForSale(basic,order);
        }else if(tax_type==2){
            //按采购价
            return calculatePriceForPurchase(basic,order);
        }else if(tax_type==3){
            //不退税
            return calculatePriceForNoneTax(basic,order);
        }
        return null;
    }
    /**
     * 按销售价退税计算最低价
     * Y= {X+【港杂费单价】+【佣金单价】+【海运费单价】+【资金利息单价】+
     * 【退税率】×【海运费单价】+【其他费用】}/（1-【汇损率】-【保险费率】-【信保费率】+【退税率】-【退税率】×【保险费率】）
     */

    private BigDecimal calculatePriceForSale(BusinessOrderProduct basic,BusinessOrder order){
        //计算X值
        BigDecimal x = getX(basic,order);
        //港杂费单价
        BigDecimal portSurcharge = basic.getPortSurcharge();
        if(portSurcharge == null){
            portSurcharge = new BigDecimal(0);
        }
        //佣金单价
        BigDecimal commissionPrice = basic.getCommissionPrice();
        if(commissionPrice == null){
            commissionPrice = new BigDecimal(0);
        }
        //海运费单价
        BigDecimal oceanFreight = basic.getOceanFreight();
        if(oceanFreight == null){
            oceanFreight = new BigDecimal(0);
        }
        //资金利息单价
        BigDecimal capitalInterestPrice = basic.getCapitalInterestPrice();
        if(capitalInterestPrice == null){
            capitalInterestPrice = getCapitalInterestPrice(x,order);
        }
        //出口退税率
        BigDecimal taxFree = basic.getTaxFree();
        if(taxFree == null){
            taxFree = new BigDecimal(1);
        }
        taxFree = taxFree.divide(new BigDecimal(100),4,BigDecimal.ROUND_HALF_UP);
        //其他费用
        BigDecimal otherCost = basic.getOtherCost();
        if(otherCost == null){
            otherCost = new BigDecimal(1);
        }
        //汇损率
        BigDecimal lossRate = order.getLossRate();
        if (lossRate == null) {
            lossRate = new BigDecimal(0);
        }
        lossRate = lossRate.divide(new BigDecimal(100),4,BigDecimal.ROUND_HALF_UP);
        //保险费率
        BigDecimal premiumRate = order.getPremiumRate();
        if(premiumRate == null){
            premiumRate = new BigDecimal(0);
        }
        premiumRate = premiumRate.divide(new BigDecimal(100),4,BigDecimal.ROUND_HALF_UP);
        //信保费率
        BigDecimal guaranteeRate = order.getGuaranteeRate();
        if(guaranteeRate == null){
            guaranteeRate = new BigDecimal(0);
        }
        guaranteeRate = guaranteeRate.divide(new BigDecimal(100),4,BigDecimal.ROUND_HALF_UP);
        /**
         * Y= {X+【港杂费单价】+【佣金单价】+【海运费单价】+【资金利息单价】+
         * 【退税率】×【海运费单价】+【其他费用】}/（1-【汇损率】-【保险费率】-【信保费率】+【退税率】-【退税率】×【保险费率】）
         */
        BigDecimal z = new BigDecimal(1).subtract(lossRate).subtract(premiumRate).subtract(guaranteeRate).add(taxFree).subtract(
                taxFree.multiply(premiumRate));
        if(z.equals(BigDecimal.ZERO)){
            return new BigDecimal(0);
        }
        return x.add(portSurcharge).add(commissionPrice).add(oceanFreight).add(capitalInterestPrice)
                .add(taxFree.multiply(oceanFreight)).add(otherCost).divide(z,4,BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 按采购价退税计算最低价
     * Y={ X+【港杂费单价】+【佣金单价】+【海运费单价】+【资金利息单价】-
     * 【退税率】×X/【采购退税计算率】+【其他费用】}/(1-【汇损率】-【保险费率】-【信保费率】)
     * @param basic
     * @param order
     * @return
     */
    private BigDecimal calculatePriceForPurchase(BusinessOrderProduct basic,BusinessOrder order){
        //计算X值
        BigDecimal x = getX(basic,order);
        //港杂费单价
        BigDecimal portSurcharge = basic.getPortSurcharge();
        if(portSurcharge == null){
            portSurcharge = new BigDecimal(0);
        }
        //佣金单价
        BigDecimal commissionPrice = basic.getCommissionPrice();
        if(commissionPrice == null){
            commissionPrice = new BigDecimal(0);
        }
        //海运费单价
        BigDecimal oceanFreight = basic.getOceanFreight();
        if(oceanFreight == null){
            oceanFreight = new BigDecimal(0);
        }
        //资金利息单价
        BigDecimal capitalInterestPrice = basic.getCapitalInterestPrice();
        if(capitalInterestPrice == null){
            capitalInterestPrice = getCapitalInterestPrice(x,order);
        }
        //出口退税率
        BigDecimal taxFree = basic.getTaxFree();
        if(taxFree == null){
            taxFree = new BigDecimal(1);
        }
        taxFree = taxFree.divide(new BigDecimal(100),4,BigDecimal.ROUND_HALF_UP);
        //其他费用
        BigDecimal otherCost = basic.getOtherCost();
        if(otherCost == null){
            otherCost = new BigDecimal(1);
        }
        //汇损率
        BigDecimal lossRate = order.getLossRate();
        if (lossRate == null) {
            lossRate = new BigDecimal(0);
        }
        lossRate = lossRate.divide(new BigDecimal(100),4,BigDecimal.ROUND_HALF_UP);
        //保险费率
        BigDecimal premiumRate = order.getPremiumRate();
        if(premiumRate == null){
            premiumRate = new BigDecimal(0);
        }
        premiumRate = premiumRate.divide(new BigDecimal(100),4,BigDecimal.ROUND_HALF_UP);
        //信保费率
        BigDecimal guaranteeRate = order.getGuaranteeRate();
        if(guaranteeRate == null){
            guaranteeRate = new BigDecimal(0);
        }
        guaranteeRate = guaranteeRate.divide(new BigDecimal(100),4,BigDecimal.ROUND_HALF_UP);
        //采购退税计算率 【采购退税计算率】=1+【增值税税率】（根据根据报关产品名称从NC系统读取）
        //增值税税率
        BigDecimal zzssl = productInfoDao.getRisetaxes(basic.getWareId());

        if(zzssl==null){
            zzssl = new BigDecimal(0);
        }
        BigDecimal purchaseZZL = new BigDecimal(1).add(zzssl);
        purchaseZZL = purchaseZZL.divide(new BigDecimal(100));
        /**
         *  Y={ X+【港杂费单价】+【佣金单价】+【海运费单价】+【资金利息单价】-
         * 【退税率】×X/【采购退税计算率】+【其他费用】}/(1-【汇损率】-【保险费率】-【信保费率】)
         */
        BigDecimal z = new BigDecimal(1).subtract(lossRate).subtract(premiumRate).subtract(guaranteeRate);
        if(z.equals(BigDecimal.ZERO)){
            return new BigDecimal(0);
        }
        return x.add(portSurcharge).add(commissionPrice).add(oceanFreight).add(capitalInterestPrice)
                .subtract(taxFree.multiply(x).divide(purchaseZZL,4,BigDecimal.ROUND_HALF_UP)).add(otherCost)
                .divide(z,4,BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 不退税计算最低价
     * Y={ X+【港杂费单价】+【佣金单价】+【海运费单价】+【资金利息单价】+
     * 【其他费用】}/(1-【汇损率】-【保险费率】-【信保费率】)
     * @param basic
     * @param order
     * @return
     */
    private BigDecimal calculatePriceForNoneTax(BusinessOrderProduct basic,BusinessOrder order){
        //计算X值
        BigDecimal x = getX(basic,order);
        //港杂费单价
        BigDecimal portSurcharge = basic.getPortSurcharge();
        if(portSurcharge == null){
            portSurcharge = new BigDecimal(0);
        }
        //佣金单价
        BigDecimal commissionPrice = basic.getCommissionPrice();
        if(commissionPrice == null){
            commissionPrice = new BigDecimal(0);
        }
        //海运费单价
        BigDecimal oceanFreight = basic.getOceanFreight();
        if(oceanFreight == null){
            oceanFreight = new BigDecimal(0);
        }
        //资金利息单价
        BigDecimal capitalInterestPrice = basic.getCapitalInterestPrice();
        if(capitalInterestPrice == null){
            capitalInterestPrice = getCapitalInterestPrice(x,order);
        }
        //其他费用
        BigDecimal otherCost = basic.getOtherCost();
        if(otherCost == null){
            otherCost = new BigDecimal(1);
        }
        //汇损率
        BigDecimal lossRate = order.getLossRate();
        if (lossRate == null) {
            lossRate = new BigDecimal(0);
        }
        lossRate = lossRate.divide(new BigDecimal(100),4,BigDecimal.ROUND_HALF_UP);
        //保险费率
        BigDecimal premiumRate = order.getPremiumRate();
        if(premiumRate == null){
            premiumRate = new BigDecimal(0);
        }
        premiumRate = premiumRate.divide(new BigDecimal(100),4,BigDecimal.ROUND_HALF_UP);
        //信保费率
        BigDecimal guaranteeRate = order.getGuaranteeRate();
        if(guaranteeRate == null){
            guaranteeRate = new BigDecimal(0);
        }
        guaranteeRate = guaranteeRate.divide(new BigDecimal(100),4,BigDecimal.ROUND_HALF_UP);
        /**
         * * Y={ X+【港杂费单价】+【佣金单价】+【海运费单价】+【资金利息单价】+
         * 【其他费用】}/(1-【汇损率】-【保险费率】-【信保费率】)
         */
        BigDecimal z = new BigDecimal(1).subtract(lossRate).subtract(premiumRate).subtract(guaranteeRate);
        if(z.equals(BigDecimal.ZERO)){
            return new BigDecimal(0);
        }
        return x.add(portSurcharge).add(commissionPrice).add(oceanFreight).add(capitalInterestPrice)
                .add(otherCost).divide(z,4,BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 计算x值
     * X={(【价委会指导单价】+【采购价格】)*【单位耗用比例】+【加工费】}/【汇率】；
     * @param basic
     * @param order
     * @return
     */
    private BigDecimal getX(BusinessOrderProduct basic,BusinessOrder order){
        //价委会指导单价
        BigDecimal advisePrice =  basic.getAdvisePrice();
        if(advisePrice==null){
            advisePrice = new BigDecimal(0);
        }
        //采购价格
        BigDecimal purchasePrice =  basic.getPurchasePrice();
        if(purchasePrice==null){
            purchasePrice = new BigDecimal(0);
        }
        //单位耗用比例
        BigDecimal unitUseRate =  basic.getUnitUseRate();
        if(unitUseRate==null){
            unitUseRate = new BigDecimal(1);
        }
        //加工费
        BigDecimal processCost = new BigDecimal(0);
        String priceType = basic.getPriceType();
        //只有02原药制剂自产类加工，04原药采购制剂加工才有加工费
        if("02".equals(priceType) || "04".equals(priceType)){
            processCost = this.calculateProcessCost(basic.getId());
        }
        //原币对本币汇率
        BigDecimal nexchangerate = order.getNexchangerate();
        if(nexchangerate==null || nexchangerate.equals(BigDecimal.ZERO)){
            nexchangerate = new BigDecimal(1);
        }
        //X={(【价委会指导单价】+【采购价格】)*【单位耗用比例】+【加工费】}/【汇率】；
        return advisePrice.add(purchasePrice).multiply(unitUseRate).add(processCost).divide(nexchangerate,4,BigDecimal.ROUND_HALF_UP);
    }
    //计算资金利息单价
    private BigDecimal getCapitalInterestPrice(BigDecimal x,BusinessOrder order){
        /**
         * 如果手工填写了利息单价，则等于手工填写的利息单价；
         2）否则等于X×计息比率×资金利率×账期月数÷12，账期月数根据选择的“收款协议”
         获取相应月数
         */
        //收款协议
        Income income = incomeDao.getByCode(order.getCollectionAgreement());
        //计息比率 = 1-预付款比例
        BigDecimal interestRate = null;
        BigDecimal prepayRate =  order.getPrepayRate();
        if(prepayRate==null){
            prepayRate = new BigDecimal(0);
        }
        interestRate =new BigDecimal(1).subtract(prepayRate.divide(new BigDecimal(100),4,BigDecimal.ROUND_HALF_UP));
        //资金利率
        BigDecimal discountRate = order.getDiscountRate();
        if(discountRate==null){
            discountRate = new BigDecimal(1);
        }
        discountRate = discountRate.divide(new BigDecimal(100),4,BigDecimal.ROUND_HALF_UP);
        //账期月数
        BigDecimal month = new BigDecimal(income.getPaymentday()).divide(new BigDecimal(30),4,BigDecimal.ROUND_HALF_UP);
        //X×计息比率×资金利率×账期月数÷12
       return x.multiply(interestRate).multiply(discountRate).multiply(month).divide(new BigDecimal(12),4,BigDecimal.ROUND_HALF_UP);
    }
    /**
     *  根据orderId  获取订单产品及订单总价
     * @param orderId
     * @return
     */
    @Override
    public Result<BusinessOrderProductVO> getBusinessOrderProducts(String orderId) {
        Result<BusinessOrderProductVO> result = new Result<BusinessOrderProductVO>();
        try {
            List<BusinessOrderProduct> list= businessOrderProductDao.getBusinessOrderProducts(orderId);
            BusinessOrder  businessOrder = businessOrderDao.getBusinessOrderByOrderId(orderId);
            BusinessOrderProductVO businessOrderProductVO = new BusinessOrderProductVO();
            businessOrderProductVO.setBusinessOrder(businessOrder);
            businessOrderProductVO.setBusinessOrderProducts(list);
            result.addDefaultModel(businessOrderProductVO);
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 复制订单产品及相关产品成分和产品需求
     * @param list
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addProductSByCopy(List<BusinessOrderProductsAddByCopy> list) {
        boolean addSuccess=false;
        try {
            for (BusinessOrderProductsAddByCopy businessOrderProductsAddByCopy:list){
                businessOrderProductsAddByCopy.setBusinessProductId(businessOrderProductDao.addProductsByCopy(businessOrderProductsAddByCopy));
                businessOrderProductDao.addProductComponent(businessOrderProductsAddByCopy);
                addSuccess= businessOrderProductDao.addProductRequire(businessOrderProductsAddByCopy)>0;
            }
        }catch (Exception e){
            addSuccess=false;
        }
        return addSuccess;
    }
}
