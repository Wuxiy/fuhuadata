package com.fuhuadata.service.impl;

import com.fuhuadata.dao.BusinessOrderProductComponentDao;
import com.fuhuadata.domain.BusinessOrderProductComponent;
import com.fuhuadata.service.BusinessOrderProductComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by hexingfu on 2017/4/7.
 */
@Service
public class BusinessOrderProductComponentServiceImpl implements BusinessOrderProductComponentService{
    @Autowired
    private BusinessOrderProductComponentDao businessOrderProductComponentDao;

    @Override
    public boolean insertProductComponent(List<BusinessOrderProductComponent> businessOrderProductComponents) {
        return businessOrderProductComponentDao.insertProductComponent(businessOrderProductComponents);
    }

    @Override
    public int insertFromArchives(Map<String, Object> map) {
        return businessOrderProductComponentDao.insertFromArchives(map);
    }

    @Override
    public List<BusinessOrderProductComponent> getProductComponentsByBusinessProductId(int businessProductId) {
        return businessOrderProductComponentDao.getProductComponentsByBusinessProductId(businessProductId);
    }

    @Override
    public List<BusinessOrderProductComponent> getProductComponentsByProductId(int productId) {
        return businessOrderProductComponentDao.getProductComponentsByProductId(productId);
    }

    @Override
    public boolean updateProductComponent(List<BusinessOrderProductComponent> businessOrderProductComponents) {
        boolean flag = businessOrderProductComponentDao.updateProductComponent(businessOrderProductComponents);
        //修改档案，必须在修改订单产品成分之后执行
        businessOrderProductComponentDao.updateArchives(businessOrderProductComponents.get(0).getBusinessProductId());
        return flag;
    }
}
