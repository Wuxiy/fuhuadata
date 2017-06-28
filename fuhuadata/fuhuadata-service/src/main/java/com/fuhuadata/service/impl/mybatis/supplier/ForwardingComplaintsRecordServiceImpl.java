package com.fuhuadata.service.impl.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.ForwardingComplaintsRecord;
import com.fuhuadata.domain.query.QueryForwardingComplaintsRecord;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.fuhuadata.service.mybatis.supplier.ForwardingComplaintsRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 *  货代投诉记录 service
 * Created by wuxiy on 2017/5/23.
 */
@Service
public class ForwardingComplaintsRecordServiceImpl extends BaseServiceImpl<ForwardingComplaintsRecord,Integer>
        implements ForwardingComplaintsRecordService{
    @Override
    public PageInfo<ForwardingComplaintsRecord> getForwardingComplaintsRecordList(QueryForwardingComplaintsRecord query) {
        if(query == null) return null;
        Example example = newExample();
        Example.Criteria criteria= example.createCriteria();
        if(query.getFreightforwardingId()!=null){
            criteria.andEqualTo("freightforwardingId",query.getFreightforwardingId());
        } else if(query.getWarehouseId()!=null){
            criteria.andEqualTo("warehouseId",query.getWarehouseId());
        }

        if(StringUtils.isNotEmpty(query.getEntryCode())){
            criteria.andLike("entryCode","%"+query.getEntryCode()+"%");
        }
        if(StringUtils.isNotEmpty(query.getCustomerName())){
            criteria.andLike("customerName","%"+query.getCustomerName()+"%");
        }
        if(StringUtils.isNotEmpty(query.getProductName())){
            criteria.andLike("productName","%"+query.getProductName()+"%");
        }
        if(query.getComplaintDateEnd()!=null){
            criteria.andLessThanOrEqualTo("complaintDate",query.getComplaintDateEnd());
        }
        if(query.getComplaintDateStart()!=null){
            criteria.andGreaterThanOrEqualTo("complaintDate",query.getComplaintDateStart());
        }
        example.orderBy("createTime").desc();
        PageHelper.startPage(query.getIndex(),query.getPageSize());
        List<ForwardingComplaintsRecord> list = listByExample(example);
        return new PageInfo<>(list);
    }
}
