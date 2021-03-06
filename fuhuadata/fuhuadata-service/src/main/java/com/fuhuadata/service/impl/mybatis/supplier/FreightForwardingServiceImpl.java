package com.fuhuadata.service.impl.mybatis.supplier;

import com.fuhuadata.dao.mapper.supplier.FreightForwardingMapper;
import com.fuhuadata.domain.common.BankAccBas;
import com.fuhuadata.domain.common.BankAccType;
import com.fuhuadata.domain.mybatis.supplier.FreightForwarding;
import com.fuhuadata.domain.mybatis.supplier.LinkmanType;
import com.fuhuadata.domain.mybatis.supplier.SupplierLinkman;
import com.fuhuadata.domain.query.QueryFreightforwarding;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.fuhuadata.service.mybatis.common.BankAccBasService;
import com.fuhuadata.service.mybatis.supplier.FreightForwardingService;
import com.fuhuadata.service.mybatis.supplier.SupplierLinkmanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  货代 service
 * Created by wuxiy on 2017/5/23.
 */
@Service
public class FreightForwardingServiceImpl extends BaseServiceImpl<FreightForwarding,Integer>
        implements FreightForwardingService{

    private FreightForwardingMapper getFreightForwardingMapper() {
        return (FreightForwardingMapper) baseMapper;
    }

    @Autowired
    private SupplierLinkmanService supplierLinkmanService;
    @Autowired
    private BankAccBasService bankAccBasService;

    /**
     * 分页列表
     * @param query
     * @return
     */
    @Override
    public PageInfo<FreightForwarding> getForwardingList(QueryFreightforwarding query) {
        if(query==null) return null;
        PageHelper.startPage(query.getIndex(),query.getPageSize());
        List<FreightForwarding> freightForwardings = getFreightForwardingMapper().getForwardingList();
        return new PageInfo<>(freightForwardings);
    }

    /**
     * 货代详情
     * @param id
     * @return
     */
    @Override
    public FreightForwarding getFreightForwardingInfo(Integer id) {
        if(id ==null) return null;
        FreightForwarding  freightForwarding = get(id);
        if(freightForwarding !=null){
            List<SupplierLinkman> linkmen  =  supplierLinkmanService.listLinkmen(LinkmanType.Forwarding,id);
            freightForwarding.setLinkmen(linkmen);
            List<BankAccBas> bankDocs = bankAccBasService.listBankAccs(BankAccType.Forwarding.key,id);
            freightForwarding.setBankAccBass(bankDocs);
        }
        return freightForwarding;
    }


    @Override
    public PageInfo<FreightForwarding> getForwardingListByWarehouseId(QueryFreightforwarding query) {
        PageHelper.startPage(query.getIndex(),query.getPageSize());
        List<FreightForwarding> freightForwardings = getFreightForwardingMapper().getForwardingListByWarehouseId(query.getWarehouseId());

        return new PageInfo<>(freightForwardings);
    }
}
