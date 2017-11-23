package com.fuhuadata.service;

import com.fuhuadata.domain.BusinessOrderProduct;
import com.fuhuadata.domain.BusinessOrderProductComponent;
import com.fuhuadata.domain.query.BusinessOrderProductsAddByCopy;
import com.fuhuadata.domain.query.QueryBusinessOrderProduct;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.vo.BusinessOrderProductVO;
import com.fuhuadata.vo.Price.Price;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by hexingfu on 2017/4/5.
 */
public interface BusinessOrderProductService {

    /**
     * 插入产品要求基本信息和产品成分及费用信息
     * @param businessOrderProduct
     * @return
     */
    int addBusinessOrderProduct(BusinessOrderProduct businessOrderProduct,List<BusinessOrderProductComponent> businessOrderProductComponents);

    /**
     * 根据用户用户，产品及其规格型号查询用户是否购买过相同产品，购买过则自动添加产品要求信息
     * @param customerId
     * @param orderId
     * @param businessProductId
     * @param productId
     * @param wareId
     * @return
     */
    Map<String,Object> addFromArchives(String customerId, String orderId, Integer businessProductId, Integer productId, Integer wareId);

    /**
     * /**
     * 根据id集合删除订单产品相关所有信息，但是不删除档案
     * @param businessProductIds
     */
    public boolean deleteAllInfoByIds(String businessProductIds);

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
     * 根据订单产品id计算产品单价
     * @param businessProductId
     * @return
     */
    Price getPriceForBusinessProduct(Integer businessProductId);

    /**
     * 计算加工费
     * @param businessProductId
     * @return
     */
    BigDecimal calculateProcessCost(Integer businessProductId);

    /**
     * 计算最低销售单价
     * @param businessProductId
     * @return
     */
    BigDecimal calculateMinPrice(Integer businessProductId);

    /**
     * 根据orderId获取订单产品
     * @param orderId
     * @return
     */
    public Result<BusinessOrderProductVO> getBusinessOrderProducts(String orderId);

    public boolean addProductSByCopy(List<BusinessOrderProductsAddByCopy> list);
}
