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
     * 根据id或者订单产品主键获取产品要求
     * @param businessProductRequire
     * @return
     */
    BusinessProductRequire getOneByQuery(BusinessProductRequire businessProductRequire );

}
