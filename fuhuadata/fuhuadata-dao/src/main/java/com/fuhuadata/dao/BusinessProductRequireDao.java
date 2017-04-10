package com.fuhuadata.dao;


import com.fuhuadata.domain.BusinessProductRequire;

import java.util.Map;

/**
 * Created by hexingfu on 2017/4/5.
 */
public interface BusinessProductRequireDao{

    int addProductRequire(BusinessProductRequire businessProductRequire);

    int insertFromArchives(Map<String,Object> map);

    int updateProductRequire(BusinessProductRequire businessProductRequire);

    int deleteProductRequire(int id);

    /**
     * 根据订单产品表主键获取产品要求
     * @param orderProductId
     * @return
     */
    BusinessProductRequire getByOrderProductId(int orderProductId);

}