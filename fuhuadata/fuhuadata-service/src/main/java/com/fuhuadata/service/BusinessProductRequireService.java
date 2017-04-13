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

    BusinessProductRequire getOneByQuery(int productRequireId);

}
