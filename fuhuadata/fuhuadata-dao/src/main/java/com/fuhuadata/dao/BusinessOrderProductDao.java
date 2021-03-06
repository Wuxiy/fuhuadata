package com.fuhuadata.dao;

import com.fuhuadata.domain.BusinessOrderProduct;
import com.fuhuadata.domain.query.BusinessOrderProductsAddByCopy;
import com.fuhuadata.domain.query.QueryBusinessOrderProduct;
import com.fuhuadata.vo.BusinessOrderProductList;

import java.math.BigDecimal;
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
     * 通过复制档案新增产品要求基本信息、单据要求，订舱出运要求
     * @param businessOrderProduct
     * @return
     * @throws Exception
     */
    int insertFromArchives(BusinessOrderProduct businessOrderProduct)throws Exception;


    /**
     * 修改产品要求（除基本信息外的其他信息新增时不做插入，在此做修改）
     * @param businessOrderProduct
     * @return
     */
    int updateBusinessOrderProduct(BusinessOrderProduct businessOrderProduct) throws Exception;

    /**
     * 只提供更新产品基本信息时更新接口
     * @param businessOrderProduct
     * @return
     * @throws Exception
     */
    int updateBusinessOrderProduct_basic(BusinessOrderProduct businessOrderProduct) throws Exception;
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


    /**
     * 根据id集合删除订单产品相关所有信息，但是不删除档案
     * @param businessProductIds
     */
    boolean deleteAllInfoByIds(String businessProductIds)throws Exception;

    /**
     * 获取订单产品基本信息
     * @param id
     * @return
     */
    BusinessOrderProduct getBaiscById(int id);

    /**
     * 根据id获取单据要求
     * @param id
     * @return
     */
    BusinessOrderProduct getDocumentaryById(int id);

    /**
     * 根据id获取装箱出运要求
     * @param id
     * @return
     */
    BusinessOrderProduct getPackageRequireById(int id);

    /**
     * 获取订单产品的几个计算方式
     * @param businessProduct
     * @return
     */
    String getPriceType(Integer businessProduct);

    /**
     * 计算加工费
     * @param businessProductId
     * @return
     */
    BigDecimal calculateProcessCost(Integer businessProductId);


    /**
     * 根据订单id获取订单产品列表
     * @param orderId
     * @return
     */
    public List<BusinessOrderProductList> getOrderProductList(String orderId);

    /**
     * 根据订单id获取订单产品
     * @param orderId
     * @return
     */
    public List<BusinessOrderProduct> getBusinessOrderProducts(String orderId);

    public boolean updateBusinessOrderProducts(List<BusinessOrderProduct> businessOrderProducts);

    /**
     * 复制订单产品表
     * @param businessOrderProductsAddByCopy
     * @return
     * @throws Exception
     */
    public int addProductsByCopy(BusinessOrderProductsAddByCopy businessOrderProductsAddByCopy) throws Exception;

    public int addProductComponent(BusinessOrderProductsAddByCopy businessOrderProductsAddByCopy) throws Exception;

    public int addProductRequire(BusinessOrderProductsAddByCopy businessOrderProductsAddByCopy) throws Exception;
}
