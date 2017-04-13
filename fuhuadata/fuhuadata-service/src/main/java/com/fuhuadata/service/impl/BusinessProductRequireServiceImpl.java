package com.fuhuadata.service.impl;

import com.fuhuadata.dao.BusinessProductRequireArchivesDao;
import com.fuhuadata.dao.BusinessProductRequireDao;
import com.fuhuadata.domain.BusinessProductRequire;
import com.fuhuadata.service.BusinessProductRequireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by hexingfu on 2017/4/7.
 */
@Service
public class BusinessProductRequireServiceImpl implements BusinessProductRequireService {
    @Autowired
    private BusinessProductRequireDao businessProductRequireDao;
    @Autowired
    private BusinessProductRequireArchivesDao businessProductRequireArchivesDao;

    @Override
    public int addProductRequire(BusinessProductRequire businessProductRequire) {
        int requireId =  businessProductRequireDao.addProductRequire(businessProductRequire);
        //新增档案，必须在新增产品要求之后执行
        businessProductRequireArchivesDao.addArchives(businessProductRequire.getBusinessProductId());
        return requireId;
    }


    @Override
    public int updateProductRequire(BusinessProductRequire businessProductRequire) {
        int eff_num = businessProductRequireDao.updateProductRequire(businessProductRequire);
        //更新档案，必须在更新产品要求之后执行
        businessProductRequireArchivesDao.updateArchives(businessProductRequire.getBusinessProductId());
        return eff_num;
    }

    @Override
    public int deleteProductRequire(int id) {
        return businessProductRequireDao.deleteProductRequire(id);
    }

    public BusinessProductRequire getOneByQuery(int productRequireId) {
        BusinessProductRequire businessProductRequire = new BusinessProductRequire();
        businessProductRequire.setId(productRequireId);
        return businessProductRequireDao.getOneByQuery(businessProductRequire);
    }
}
