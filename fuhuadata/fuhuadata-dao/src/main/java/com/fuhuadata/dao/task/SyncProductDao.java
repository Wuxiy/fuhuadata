package com.fuhuadata.dao.task;

import com.fuhuadata.domain.task.SyncProduct;
import com.fuhuadata.domain.task.SyncWare;

import java.util.List;

/**
 * Created by hexingfu on 2017/5/9.
 */
public interface SyncProductDao {

    //从oracle查询产品列表
    List<SyncProduct> getProductListFormOracle()throws Exception;
    //更新mysql中的产品数据
    void modifyProductInMysql(List<SyncProduct> plist)throws Exception;
    //从oracle查询产品（带规格）列表
    List<SyncWare> getWareListFormOracle()throws Exception;
    //更新mysql中的产品（带规格）数据
    void modifyWareInMysql(List<SyncWare> plist)throws Exception;
    //在mysql中补全产品信息
    void fixProductInMysql()throws Exception;
    //在mysql中补全产品规格信息
    void fixWareInMysql()throws Exception;

}
