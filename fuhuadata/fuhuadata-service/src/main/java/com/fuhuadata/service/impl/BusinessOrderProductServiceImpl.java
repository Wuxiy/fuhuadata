package com.fuhuadata.service.impl;

import com.fuhuadata.dao.BusinessOrderProductComponentDao;
import com.fuhuadata.dao.BusinessOrderProductDao;
import com.fuhuadata.domain.BusinessOrderProduct;
import com.fuhuadata.domain.BusinessOrderProductComponent;
import com.fuhuadata.service.BusinessOrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hexingfu on 2017/4/5.
 */
@Service
public class BusinessOrderProductServiceImpl implements BusinessOrderProductService {

    @Autowired
    private BusinessOrderProductDao businessOrderProductDao;
    @Autowired
    private BusinessOrderProductComponentDao businessOrderProductComponentDao;

    @Transactional
    public int addBusinessOrderProduct(BusinessOrderProduct businessOrderProduct,List<BusinessOrderProductComponent> businessOrderProductComponents) {
        try {
            businessOrderProductComponentDao.insertProductComponent(businessOrderProductComponents);
            return businessOrderProductDao.insertBaseInfo(businessOrderProduct);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
