package com.fuhuadata.service.task;

import com.fuhuadata.dao.task.SyncBaseInfoDao;
import com.fuhuadata.domain.common.BankAccBas;
import com.fuhuadata.domain.common.BankAccType;
import com.fuhuadata.domain.mybatis.CustomerBaseInfo;
import com.fuhuadata.domain.mybatis.supplier.FreightForwarding;
import com.fuhuadata.domain.mybatis.supplier.LinkmanType;
import com.fuhuadata.domain.mybatis.supplier.SupplierLinkman;
import com.fuhuadata.domain.mybatis.supplier.WarehouseInfo;
import com.fuhuadata.service.mybatis.BaseService;
import com.fuhuadata.service.mybatis.CustomerBaseInfoService;
import com.fuhuadata.service.mybatis.common.BankAccBasService;
import com.fuhuadata.service.mybatis.common.BankAccBasServiceImpl;
import com.fuhuadata.service.mybatis.supplier.FreightForwardingService;
import com.fuhuadata.service.mybatis.supplier.SupplierLinkmanService;
import com.fuhuadata.service.mybatis.supplier.WarehouseInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by zhangxiang on 2017/6/9.
 */
@Service("syncFreightForwarding")
public class SyncFreightForwardingService {
    private Logger logger= LoggerFactory.getLogger(SyncFreightForwardingService.class);
    @Autowired
    private SyncBaseInfoDao syncFreightForwardingDao;
    @Autowired
    private FreightForwardingService freightForwardingService;
    @Autowired
    private BankAccBasService bankAccBasService;
    @Autowired
    private SupplierLinkmanService supplierLinkmanService;
    @Autowired
    private WarehouseInfoService warehouseInfoService;
    @Autowired
    private CustomerBaseInfoService customerBaseInfoService;

    @Transactional(rollbackFor = Exception.class)
    public void sync(){
        try {
            List<FreightForwarding> list=syncFreightForwardingDao.getOrcalData();
            List<FreightForwarding> oldList= freightForwardingService.list();
            Map<String,FreightForwarding> map= list.stream().collect(Collectors.toMap(FreightForwarding::getCode,(p)->p));
            for (FreightForwarding oldfreightForwarding:oldList){
                int oid=oldfreightForwarding.getId();
                if (map.get(oldfreightForwarding.getCode())!=null){
                    map.get(oldfreightForwarding.getCode()).setId(oid);
                }
            }
            for (FreightForwarding freightForwarding:list){
                freightForwardingService.saveOrUpdateSelective(freightForwarding);
            }
            syncCustomerDoc();
            //syncBankacc();
            //syncLinkMan();
            syncStorDoc();
        }catch (Exception e){
            e.printStackTrace();
            logger.warn("-!-!-同步货代出错-!-!-");
        }
    }

    /**
     * 更新同步货代银行账户
     */
    private void syncBankacc(){
        try {
            List<BankAccBas> list=syncFreightForwardingDao.getOraclBankAcc();
            List<BankAccBas> oldList=bankAccBasService.listBankAccs(BankAccType.Forwarding);
            Map<String ,BankAccBas> map=list.stream().collect(Collectors.toMap(BankAccBas::getPkBankaccbas,(p)->p));
            for (BankAccBas oldBankAccBas:oldList){
                int oid=oldBankAccBas.getId();
                if (map.get(oldBankAccBas.getPkBankaccbas())!=null){
                    map.get(oldBankAccBas.getPkBankaccbas()).setId(oid);
                }
            }
            for (BankAccBas a:list){
                bankAccBasService.saveOrUpdateSelective(a);

            }
            logger.debug("成功同步[{}]条-货代银行账户-数据",list.size());
        }catch (Exception e){
            e.printStackTrace();
            logger.warn("同步货代银行账户出错");
        }
    }
    private void syncLinkMan(){

        try {
            List<SupplierLinkman> list=syncFreightForwardingDao.getOraclLinkMan();
            List<SupplierLinkman> oldList=supplierLinkmanService.listLinkmen(LinkmanType.Forwarding);
            Map<String ,SupplierLinkman> map=list.stream().collect(Collectors.toMap(SupplierLinkman::getPkLinkman,(p)->p));
            for (SupplierLinkman supplierLinkman:oldList){
                int oid=supplierLinkman.getId();
                if (map.get(supplierLinkman.getPkLinkman())!=null){
                    map.get(supplierLinkman.getPkLinkman()).setId(oid);
                }
            }
            supplierLinkmanService.saveOrUpdateLinkmen(list);
            logger.debug("成功同步[{}]条-联系人-数据",list.size());
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("同步货代联系人出错");
        }

    }
    private void syncStorDoc(){
        try {
            List<WarehouseInfo> list=syncFreightForwardingDao.getStorDoc();
            List<WarehouseInfo> oldList=warehouseInfoService.list();
            Map<String ,WarehouseInfo> map=list.stream().collect(Collectors.toMap(WarehouseInfo::getPkStordoc,(p)->p));
            for (WarehouseInfo warehouseInfo:oldList){
                int oid=warehouseInfo.getId();
                if (map.get(warehouseInfo.getPkStordoc())!=null){
                    map.get(warehouseInfo.getPkStordoc()).setId(oid);
                }
            }
            for (WarehouseInfo a:list){
                warehouseInfoService.saveOrUpdateSelective(a);
            }
            logger.debug("成功同步[{}]条-仓库-数据",list.size());
        }catch (Exception e){
            e.printStackTrace();
            logger.warn("同步货代仓库出错");
        }
    }
    private void syncCustomerDoc(){
        try{
            List<CustomerBaseInfo> list=syncFreightForwardingDao.getCustomerBaseInfo();
            List<CustomerBaseInfo> oldList=customerBaseInfoService.list();
            Map<String ,CustomerBaseInfo> map=list.stream().collect(Collectors.toMap(CustomerBaseInfo::getNcId,(p)->p));
            for (CustomerBaseInfo customerBaseInfo:oldList){
                int oid=customerBaseInfo.getId();
                if (map.get(customerBaseInfo.getNcId())!=null){
                    map.get(customerBaseInfo.getNcId()).setId(oid);
                }
            }
            for (CustomerBaseInfo a:list){
                customerBaseInfoService.saveOrUpdateSelective(a);
            }
            logger.debug("成功同步[{}]条-客户-数据",list.size());
        }catch (Exception e){
            e.printStackTrace();
            logger.warn("同步customer信息出错");
        }
    }
}
