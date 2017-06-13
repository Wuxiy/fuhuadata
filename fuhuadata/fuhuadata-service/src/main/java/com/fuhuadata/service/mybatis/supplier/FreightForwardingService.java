package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.FreightForwarding;
import com.fuhuadata.domain.query.QueryFreightforwarding;
import com.fuhuadata.service.mybatis.BaseService;
import com.github.pagehelper.PageInfo;


/**
 *  货代 service
 * Created by wuxiy on 2017/5/23.
 */
public interface FreightForwardingService extends BaseService<FreightForwarding,Integer>{

    PageInfo<FreightForwarding> getForwardingList(QueryFreightforwarding query);

    FreightForwarding getFreightForwardingInfo(Integer id);

    /**
     * 仓库合作货代列表
     * @param query
     * @return
     */
    PageInfo<FreightForwarding> getForwardingListByWarehouseId(QueryFreightforwarding query);
}
