package com.fuhuadata.service;

import com.fuhuadata.domain.BusinessProductRequire;

import java.util.Map;

/**
 * Created by hexingfu on 2017/4/7.
 */
public interface BusinessProductRequireService {

    int addProductRequire(BusinessProductRequire businessProductRequire);

    int updateProductRequire(BusinessProductRequire businessProductRequire);

    int deleteProductRequire(int id);

    /**
     * 根据productRequireId 或 businessProductId 查询，二者可以有一个为null
     * @param productRequireId
     * @param businessProductId
     * @return
     */
    BusinessProductRequire getOneByQuery(Integer productRequireId,Integer businessProductId);

}
