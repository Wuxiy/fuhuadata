package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.ForwardingComplaintsRecord;
import com.fuhuadata.domain.query.QueryForwardingComplaintsRecord;
import com.fuhuadata.service.mybatis.BaseService;
import com.github.pagehelper.PageInfo;



/**
 *  货代投诉记录 service
 * Created by wuxiy on 2017/5/23.
 */
public interface ForwardingComplaintsRecordService extends BaseService<ForwardingComplaintsRecord,Integer>{
    PageInfo<ForwardingComplaintsRecord> getForwardingComplaintsRecordList(QueryForwardingComplaintsRecord query);
}
