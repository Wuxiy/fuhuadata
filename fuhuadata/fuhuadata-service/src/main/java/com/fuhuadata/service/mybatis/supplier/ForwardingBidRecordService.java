package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.ForwardingBidRecord;
import com.fuhuadata.domain.query.QueryForwardBidRecord;
import com.fuhuadata.service.mybatis.BaseService;
import com.github.pagehelper.PageInfo;

/**
 *  货代竞标记录 service
 * Created by wuxiy on 2017/5/23.
 */
public interface ForwardingBidRecordService extends BaseService<ForwardingBidRecord,Integer>{
    PageInfo<ForwardingBidRecord> getForwardingBidRecordList(QueryForwardBidRecord query);

}
