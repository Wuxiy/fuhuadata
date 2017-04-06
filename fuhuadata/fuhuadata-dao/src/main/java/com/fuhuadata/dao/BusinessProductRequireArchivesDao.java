package com.fuhuadata.dao;


import com.fuhuadata.domain.BusinessProductRequire;
import com.fuhuadata.domain.BusinessProductRequireArchives;

/**
 * Created by hexingfu on 2017/4/5.
 */
public interface BusinessProductRequireArchivesDao {

    int addProductRequireArchives(BusinessProductRequireArchives businessProductRequireArchives);

    int updateProductRequireArchives(BusinessProductRequireArchives businessProductRequireArchives);

    int deleteProductRequireArchives(int id);

    /**
     * 根据订单产品表主键获取产品要求
     * @param orderProductId
     * @return
     */
    BusinessProductRequireArchives getByOrderProductId(int orderProductId);

}
