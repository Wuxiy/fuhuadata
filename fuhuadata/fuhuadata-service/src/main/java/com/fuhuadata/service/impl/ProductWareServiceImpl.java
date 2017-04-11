package com.fuhuadata.service.impl;

import com.fuhuadata.dao.ProductWareDao;
import com.fuhuadata.service.ProductWareService;
import com.fuhuadata.vo.ProductWareVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hexingfu on 2017/4/11.
 */
@Service
public class ProductWareServiceImpl implements ProductWareService {

    @Autowired
    private ProductWareDao productWareDao;

    @Override
    public ProductWareVo getProductWareVo(Integer productId,Integer wareId) {
        ProductWareVo productWareVo = new ProductWareVo();
        productWareVo.setWareId(wareId);
        productWareVo.setProductId(productId);
        return productWareDao.getProductWareVo(productWareVo);
    }
}
