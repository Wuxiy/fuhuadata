package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.ForwardingOrderRecord;
import com.fuhuadata.domain.query.QueryForwardingOrderRecord;
import com.fuhuadata.service.mybatis.BaseService;
import com.github.pagehelper.PageInfo;

/**
 *  货代订单记录 service
 * Created by wuxiy on 2017/5/23.
 */
public interface ForwardingOrderRecordService extends BaseService<ForwardingOrderRecord,Integer>{
    PageInfo<ForwardingOrderRecord> getForwardingOrderRecordList(QueryForwardingOrderRecord query);
}
