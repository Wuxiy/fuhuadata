package com.fuhuadata.dao;

import com.fuhuadata.domain.BusinessOrderProduct;
import com.fuhuadata.domain.BusinessOrderProductComponent;
import com.fuhuadata.domain.query.QueryBusinessOrderProduct;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by hexingfu on 2017/3/30.
 */
public interface BusinessOrderProductDao {
    /**
     * 插入产品要求基本信息
     * @param businessOrderProduct
     * @return 返回主键
     */
    int insertBaseInfo(BusinessOrderProduct businessOrderProduct) throws Exception;


    /**
     * 修改产品要求（除基本信息外的其他信息新增时不做插入，在此做修改）
     * @param businessOrderProduct
     * @return
     */
    int updateBusinessOrderProduct(BusinessOrderProduct businessOrderProduct) throws Exception;

    /**
     * 获取符合条件的所有条目
     * @param queryBusinessOrderProduct
     * @return
     */
    List<BusinessOrderProduct> getList(QueryBusinessOrderProduct queryBusinessOrderProduct);

    /**
     * 统计符合条件的条目数
     * @param queryBusinessOrderProduct
     * @return
     */
    int count(QueryBusinessOrderProduct queryBusinessOrderProduct);

    /**
     * 分页查询
     * @param queryBusinessOrderProduct
     * @return
     */
    List<BusinessOrderProduct> getListByPage(QueryBusinessOrderProduct queryBusinessOrderProduct);

}
