package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.WarehouseInfo;
import com.fuhuadata.domain.query.QueryWarehouseInfo;
import com.fuhuadata.service.mybatis.BaseService;
import com.github.pagehelper.PageInfo;


/**
 * 仓库 service
 * Created by wuxiy on 2017/5/23.
 */
public interface WarehouseInfoService extends BaseService<WarehouseInfo,Integer> {

    /**
     * 仓库分页列表
     * @param query
     * @return
     */
    PageInfo<WarehouseInfo> listWarehouses(QueryWarehouseInfo query);

    /**
     * 获取货代关联仓库
     * @param query
     * @return
     */
    PageInfo<WarehouseInfo> getListByForwardingId(QueryWarehouseInfo query);


}
