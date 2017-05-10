package com.fuhuadata.dao.task;

import com.fuhuadata.domain.task.SyncProduct;
import com.fuhuadata.domain.task.SyncWare;

import java.util.List;

/**
 * Created by hexingfu on 2017/5/9.
 */
public interface SyncProductDao {

    //从oracle查询产品列表
    List<SyncProduct> getProductListFormOracle();
    //更新mysql中的产品数据
    void updateProductInMysql(List<SyncProduct> plist);
    //从oracle查询产品（带规格）列表
    List<SyncWare> getWareListFormOracle();
    //更新mysql中的产品（带规格）数据
    void updateWareInMysql(List<SyncWare> plist);
    //在mysql中不全产品信息
    void fixProductInMysql();
    //在mysql中补全产品规格信息
    void fixWareInMysql();

}
