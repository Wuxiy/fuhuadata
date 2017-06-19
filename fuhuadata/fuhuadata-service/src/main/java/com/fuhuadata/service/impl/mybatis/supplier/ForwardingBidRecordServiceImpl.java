package com.fuhuadata.service.impl.mybatis.supplier;


import com.fuhuadata.domain.mybatis.supplier.ForwardingBidRecord;
import com.fuhuadata.domain.query.QueryForwardBidRecord;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.fuhuadata.service.mybatis.supplier.ForwardingBidRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 *  货代竞标记录 service
 * Created by wuxiy on 2017/5/23.
 */
@Service
public class ForwardingBidRecordServiceImpl extends BaseServiceImpl<ForwardingBidRecord,Integer> implements ForwardingBidRecordService {
    @Override
    public PageInfo<ForwardingBidRecord> getForwardingBidRecordList(QueryForwardBidRecord query) {
        if(query==null) return null;
        Example example= newExample();
        Example.Criteria criteria = example.createCriteria().andEqualTo("freightforwardingId",query.getFreightforwardingId());
        if(StringUtils.isNotEmpty(query.getPurchasePlanCode())){
            criteria.andLike("purchasePlanCode","%"+query.getPurchasePlanCode()+"%");
        }
        if(StringUtils.isNotEmpty(query.getEntryName())){
            criteria.andLike("entryName","%"+query.getEntryName()+"%");
        }
        if(query.getIsBid()!=null){
            criteria.andEqualTo("isBid",query.getIsBid());
        }
        //是否恶意竞标
        if(query.getMaliciousBid()!=null){
            criteria.andEqualTo("maliciousBid",query.getMaliciousBid());
        }

        if(query.getIsModifyPrice()!=null){
            criteria.andEqualTo("isModifyPrice",query.getIsModifyPrice());
        }
        example.orderBy("create_time desc");
        PageHelper.startPage(query.getIndex(),query.getPageSize());
        List<ForwardingBidRecord> list = listByExample(example);
        return new PageInfo<>(list);
    }
}
