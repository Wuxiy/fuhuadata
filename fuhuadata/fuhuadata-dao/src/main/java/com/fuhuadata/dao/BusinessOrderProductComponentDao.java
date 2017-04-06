package com.fuhuadata.dao;

import com.fuhuadata.domain.BusinessOrderProductComponent;

import java.util.List;

/**
 * Created by hexingfu on 2017/4/5.
 */
public interface BusinessOrderProductComponentDao {

    /**
     * 插入产品成分及费用
     * @param businessOrderProductComponents
     * @return
     */
     boolean insertProductComponent(List<BusinessOrderProductComponent> businessOrderProductComponents);

    /**
     * 根据订单id和标准产品id获取成分及其费用
     * @param orderId
     * @param productId
     * @return
     */
    List<BusinessOrderProductComponent> getProductComponentsByOrderAndProduct(int orderId,int productId);

    /**
     * 批量更新
     * @param businessOrderProductComponents
     * @return
     */
    boolean updateProductComponent(List<BusinessOrderProductComponent> businessOrderProductComponents);

}
