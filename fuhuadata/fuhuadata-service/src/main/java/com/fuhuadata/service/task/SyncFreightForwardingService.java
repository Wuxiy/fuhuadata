package com.fuhuadata.service.task;

import com.fuhuadata.dao.task.SyncFreightForwardingDao;
import com.fuhuadata.domain.common.BankAccBas;
import com.fuhuadata.domain.common.BankAccType;
import com.fuhuadata.domain.mybatis.supplier.FreightForwarding;
import com.fuhuadata.domain.mybatis.supplier.LinkmanType;
import com.fuhuadata.domain.mybatis.supplier.SupplierLinkman;
import com.fuhuadata.domain.mybatis.supplier.WarehouseInfo;
import com.fuhuadata.service.mybatis.BaseService;
import com.fuhuadata.service.mybatis.common.BankAccBasService;
import com.fuhuadata.service.mybatis.common.BankAccBasServiceImpl;
import com.fuhuadata.service.mybatis.supplier.FreightForwardingService;
import com.fuhuadata.service.mybatis.supplier.SupplierLinkmanService;
import com.fuhuadata.service.mybatis.supplier.WarehouseInfoService;
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
    @Autowired
    private SyncFreightForwardingDao syncFreightForwardingDao;
    @Autowired
    private FreightForwardingService freightForwardingService;
    @Autowired
    private BankAccBasService bankAccBasService;
    @Autowired
    private SupplierLinkmanService supplierLinkmanService;
    @Autowired
    private WarehouseInfoService warehouseInfoService;

    @Transactional
    public void sync(){
        try {
            List<FreightForwarding> list=syncFreightForwardingDao.getOrcalData();
            List<FreightForwarding> oldList= freightForwardingService.list();
            Map<String,FreightForwarding> map= list.stream().collect(Collectors.toMap(FreightForwarding::getCode,(p)->p));
            for (FreightForwarding oldfreightForwarding:oldList){
                int oid=oldfreightForwarding.getId();
                map.get(oldfreightForwarding.getCode()).setId(oid);
            }
            for (FreightForwarding freightForwarding:list){
                freightForwardingService.saveOrUpdateSelective(freightForwarding);
            }
            syncBankacc();
            syncLinkMan();
            syncStorDoc();
        }catch (Exception e){
            e.printStackTrace();
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
                map.get(oldBankAccBas.getPkBankaccbas()).setId(oid);
            }
                bankAccBasService.saveOrUpdateBanks(list);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void syncLinkMan(){

        try {
            List<SupplierLinkman> list=syncFreightForwardingDao.getOraclLinkMan();
            List<SupplierLinkman> oldList=supplierLinkmanService.listLinkmen(LinkmanType.Forwarding);
            Map<String ,SupplierLinkman> map=list.stream().collect(Collectors.toMap(SupplierLinkman::getPkLinkman,(p)->p));
            for (SupplierLinkman supplierLinkman:oldList){
                int oid=supplierLinkman.getId();
                map.get(supplierLinkman.getPkLinkman()).setId(oid);
            }
            supplierLinkmanService.saveOrUpdateLinkmen(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void syncStorDoc(){
        try {
            List<WarehouseInfo> list=syncFreightForwardingDao.getStorDoc();
            List<WarehouseInfo> oldList=warehouseInfoService.list();
            Map<String ,WarehouseInfo> map=list.stream().collect(Collectors.toMap(WarehouseInfo::getCode,(p)->p));
            for (WarehouseInfo warehouseInfo:oldList){
                int oid=warehouseInfo.getId();
                map.get(warehouseInfo.getCode()).setId(oid);
            }
            for (WarehouseInfo a:list){
                warehouseInfoService.saveOrUpdateSelective(a);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
