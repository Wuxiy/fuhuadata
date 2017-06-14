package com.fuhuadata.service.task;

import com.fuhuadata.dao.task.SyncProductDao;
import com.fuhuadata.domain.task.SyncProduct;
import com.fuhuadata.domain.task.SyncWare;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.transaction.TransactionDefinition.PROPAGATION_REQUIRED;

/**
 * 同步产品档案
 * 步骤如下：
 * 1.将oracle的数据按名称分组同步到mysql的product_info表（以名称为唯一索引，存在则修改，不存在则插入）
 * 2.将oracle的数据不分组同步到mysql的product_ware表（以nc_id为唯一索引，存在则修改，不存在则插入）
 * 3.在mysql中补写product_info中的分类信息
 * 4.在mysql中补写product_ware中的product_info_info信息
 * Created by hexingfu on 2017/5/9.
 */
@Service("syncProduct")
public class SyncProductService {
    private static final Logger log = Logger.getLogger(SyncProductService.class);
    @Autowired
    private SyncProductDao syncProductDao;
    @Transactional
    public void sync(){
        try {
            //从oracle中获取产品列表
            List<SyncProduct> productList = syncProductDao.getProductListFormOracle();
            //更新mysql产品数据
            syncProductDao.modifyProductInMysql(productList);
            //从oracle中获取商品列表
            List<SyncWare> wareList = syncProductDao.getWareListFormOracle();
            //更新mysql商品列表
            syncProductDao.modifyWareInMysql(wareList);
            //fix product
            syncProductDao.fixProductInMysql();
            //fix ware
            syncProductDao.fixWareInMysql();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
