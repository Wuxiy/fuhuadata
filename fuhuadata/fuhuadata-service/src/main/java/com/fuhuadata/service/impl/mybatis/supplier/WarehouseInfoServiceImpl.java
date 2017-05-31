package com.fuhuadata.service.impl.mybatis.supplier;

import com.fuhuadata.dao.mapper.supplier.WarehouseInfoMapper;
import com.fuhuadata.domain.mybatis.supplier.WarehouseInfo;
import com.fuhuadata.domain.query.QueryWarehouseInfo;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.fuhuadata.service.mybatis.supplier.WarehouseInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 仓库 service
 * Created by wuxiy on 2017/5/23.
 */
@Service
public class WarehouseInfoServiceImpl extends BaseServiceImpl<WarehouseInfo,Integer>
        implements WarehouseInfoService{

    private WarehouseInfoMapper getWarehouseInfoMapper() {
        return (WarehouseInfoMapper) baseMapper;
    }

    @Override
    public PageInfo<WarehouseInfo> listWarehouses(QueryWarehouseInfo query) {
        if(query == null) return null;
        Example example = newExample();
        example.orderBy("CREATIONTIME desc");
        PageHelper.startPage(query.getIndex(),query.getPageSize());
        List<WarehouseInfo> warehouseInfos = listByExample(example);
        return new PageInfo<>(warehouseInfos);
    }

    @Override
    public PageInfo<WarehouseInfo> getListByForwardingId(QueryWarehouseInfo query) {
        if(query==null) return null;
        PageHelper.startPage(query.getIndex(),query.getPageSize());
        List<WarehouseInfo> warehouseInfos = getWarehouseInfoMapper().getListByForwardingId(query.getForwardingId());
        return new PageInfo<>(warehouseInfos);
    }


}
