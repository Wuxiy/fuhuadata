package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.supplier.FactoryEvaItem;
import com.fuhuadata.service.mybatis.BaseService;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/5/2017
 */
public interface FactoryEvaItemService extends BaseService<FactoryEvaItem, Integer> {

    List<FactoryEvaItem> listItemAndScoreByOrderId(Integer orderId);

    List<FactoryEvaItem> saveOrUpdate(Integer orderId, List<FactoryEvaItem> items);
}
