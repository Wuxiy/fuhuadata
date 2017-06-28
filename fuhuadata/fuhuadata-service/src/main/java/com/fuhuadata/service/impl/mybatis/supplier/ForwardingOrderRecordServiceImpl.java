package com.fuhuadata.service.impl.mybatis.supplier;


import com.fuhuadata.domain.mybatis.supplier.ForwardingOrderRecord;
import com.fuhuadata.domain.query.QueryForwardingOrderRecord;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;

import com.fuhuadata.service.mybatis.supplier.ForwardingOrderRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 *  货代订单记录 service
 * Created by wuxiy on 2017/5/23.
 */
@Service
public class ForwardingOrderRecordServiceImpl extends BaseServiceImpl<ForwardingOrderRecord,Integer>
        implements ForwardingOrderRecordService{
    @Override
    public PageInfo<ForwardingOrderRecord> getForwardingOrderRecordList(QueryForwardingOrderRecord query) {
        if(query == null) return null;
        Example example = newExample();
        Example.Criteria criteria= example.createCriteria();
        if(query.getFreightforwardingId()!=null){
            criteria.andEqualTo("freightforwardingId",query.getFreightforwardingId());
        }
        if(query.getWarehouseId()!=null){
            criteria.andEqualTo("warehouseId",query.getWarehouseId());
        }
        if(query.getWarehouseName()!=null){
            criteria.andLike("warehouseName","%"+query.getWarehouseName()+"%");
        }
        if(StringUtils.isNotEmpty(query.getExportContractNumber())){
            criteria.andLike("exportContractNumber","%"+query.getExportContractNumber()+"%");
        }
        if(StringUtils.isNotEmpty(query.getEntryCode())){
            criteria.andLike("entryCode","%"+query.getEntryCode()+"%");
        }
        example.orderBy("createTime").desc();
        PageHelper.startPage(query.getIndex(),query.getPageSize());
        List<ForwardingOrderRecord> list = listByExample(example);
        return new PageInfo<>(list);
    }
}
