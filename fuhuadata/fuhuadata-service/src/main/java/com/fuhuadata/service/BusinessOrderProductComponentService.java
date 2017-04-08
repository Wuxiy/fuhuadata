package com.fuhuadata.service;

import com.fuhuadata.domain.BusinessOrderProductComponent;

import java.util.List;
import java.util.Map;

/**
 * Created by hexingfu on 2017/4/7.
 */
public interface BusinessOrderProductComponentService {

    /**
     * 插入产品成分及费用
     * @param businessOrderProductComponents
     * @return
     */
    boolean insertProductComponent(List<BusinessOrderProductComponent> businessOrderProductComponents);

    /**
     * 通过复制档案插入产品成分及费用
     * @param map 必须参数：businessProductId 当前订单产品（表）id，businessProductArchivesId 客户产品档案id
     * @return
     */
    int insertFromArchives(Map<String,Object> map);

    /**
     * 根据订单产品表id获取成分及其费用
     * @param businessProductId
     * @return
     */
    List<BusinessOrderProductComponent> getProductComponentsByBusinessProductId(int businessProductId);

    /**
     * 根据产品查询该产品的成分及其费用
     * @param productId
     * @return
     */
    List<BusinessOrderProductComponent> getProductComponentsByProductId(int productId);
    /**
     * 批量更新
     * @param businessOrderProductComponents
     * @return
     */
    boolean updateProductComponent(List<BusinessOrderProductComponent> businessOrderProductComponents);
}
