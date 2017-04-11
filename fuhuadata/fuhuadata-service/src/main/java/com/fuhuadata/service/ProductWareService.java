package com.fuhuadata.service;

import com.fuhuadata.vo.ProductWareVo;

/**
 * Created by hexingfu on 2017/4/11.
 */
public interface ProductWareService {
    /**
     * 查询添加订单产品时需要的产品基本信息
     * @return
     */
    public ProductWareVo getProductWareVo(Integer productId,Integer wareId);
}
