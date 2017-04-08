package com.fuhuadata.dao;


import com.fuhuadata.domain.BusinessProductRequire;
import com.fuhuadata.domain.BusinessProductRequireArchives;

/**
 * Created by hexingfu on 2017/4/5.
 */
public interface BusinessProductRequireArchivesDao {
    /**
     * 复制businessProductId对应的产品要求到档案
     * @param businessProductId
     * @return
     */
    int addArchives(Integer businessProductId);
    /**
     * 更新businessProductId对应的产品要求到档案
     * @param businessProductId
     * @return
     */
    int updateArchives(Integer businessProductId);

    /**
     * 根据订单产品表主键获取产品要求
     * @param orderProductId
     * @return
     */
    BusinessProductRequireArchives getByOrderProductId(int orderProductId);

}
