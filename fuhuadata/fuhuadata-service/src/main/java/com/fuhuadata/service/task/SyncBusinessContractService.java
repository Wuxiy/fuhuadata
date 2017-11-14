package com.fuhuadata.service.task;

import com.fuhuadata.dao.task.SyncBaseInfoDao;
import com.fuhuadata.domain.business.BusinessBuyContract;
import com.fuhuadata.domain.business.BusinessBuyContractProduct;
import com.fuhuadata.domain.business.BusinessOrgiContract;
import com.fuhuadata.service.mybatis.business.BusinessBuyContractProductService;
import com.fuhuadata.service.mybatis.business.BusinessBuyContractService;
import com.fuhuadata.service.mybatis.business.BusinessOrgiContractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by zhangxiang on 2017/11/14.
 */
@Service("syncBusinessContractService")
public class SyncBusinessContractService {
    private Logger logger= LoggerFactory.getLogger(SyncBusinessContractService.class);
    @Autowired
    private SyncBaseInfoDao syncBaseInfoDao;
    @Autowired
    private BusinessBuyContractService businessBuyContractService;
    @Autowired
    private BusinessBuyContractProductService productService;
    @Autowired
    private BusinessOrgiContractService orgiContractService;
    @Transactional(rollbackFor = Exception.class)
    public void sync(){
        syncBuyContract();
        syncBuyContractProduct();
        syncOrgiContract();
    }
    private void syncBuyContract(){
        try{
            List<BusinessBuyContract> list=syncBaseInfoDao.getBusinessBuyContract();
            List<BusinessBuyContract> oldList=businessBuyContractService.list();
            Map<String,BusinessBuyContract> map=list.stream().collect(Collectors.toMap(BusinessBuyContract::getPkCtPu,(p)->p));
            for (BusinessBuyContract businessBuyContract:oldList){
                int oid=businessBuyContract.getId();
                if (map.get(businessBuyContract.getPkCtPu())!=null){
                    map.get(businessBuyContract.getPkCtPu()).setId(oid);
                }
            }
            for (BusinessBuyContract businessBuyContract:list){
                businessBuyContractService.saveOrUpdateSelective(businessBuyContract);
            }
            logger.debug("成功同步[{}]条采购合同",list.size());
        }catch (Exception e){
            logger.error("同步采购合同出错",e);
        }
    }
    private void syncBuyContractProduct(){
        try{
            List<BusinessBuyContractProduct> list=syncBaseInfoDao.getBuyContractProduct();
            List<BusinessBuyContractProduct> oldList=productService.list();
            Map<String,BusinessBuyContractProduct> map=list.stream().collect(Collectors.toMap(BusinessBuyContractProduct::getPkBuyContractProduct,(p)->p));
            for (BusinessBuyContractProduct businessBuyContractProduct:oldList){
                int oid=businessBuyContractProduct.getId();
                if (map.get(businessBuyContractProduct.getPkBuyContractProduct())!=null){
                    map.get(businessBuyContractProduct.getPkBuyContractProduct()).setId(oid);
                }
            }
            for (BusinessBuyContractProduct businessBuyContractProduct:list){
                productService.saveOrUpdateSelective(businessBuyContractProduct);
            }
            logger.debug("成功同步[{}]条采购合同产品",list.size());
        }catch (Exception e){
            logger.error("同步采购合同产品出错",e);
        }
    }
    private void syncOrgiContract(){
        try{
            List<BusinessOrgiContract> list=syncBaseInfoDao.getOrgiContract();
            List<BusinessOrgiContract> oldList=orgiContractService.list();
            Map<String,BusinessOrgiContract> map=list.stream().collect(Collectors.toMap(BusinessOrgiContract::getPkCtSale,(p)->p));
            for (BusinessOrgiContract businessOrgiContract:oldList){
                int oid=businessOrgiContract.getId();
                if (map.get(businessOrgiContract.getPkCtSale())!=null){
                    map.get(businessOrgiContract.getPkCtSale()).setId(oid);
                }
            }
            for (BusinessOrgiContract businessOrgiContract:list){
                orgiContractService.saveOrUpdateSelective(businessOrgiContract);
            }
            logger.debug("成功同步[{}]条原药合同",list.size());
        }catch (Exception e){
            logger.error("同步原药合同出错",e);
        }
    }

}
