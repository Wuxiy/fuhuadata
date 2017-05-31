package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.supplier.ProduceFactoryProductAddr;
import com.fuhuadata.service.mybatis.BaseService;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/23/2017
 */
public interface ProduceFactoryProductAddrService extends BaseService<ProduceFactoryProductAddr, Integer> {

    /**
     * 保存产品地址
     * @param addrs
     * @return
     */
    int saveProductAddrs(List<ProduceFactoryProductAddr> addrs);

    /**
     * 更新地址
     * @param addrs
     * @return
     */
    int updateProductAddrs(List<ProduceFactoryProductAddr> addrs);

    /**
     * 保存或更新地址
     * @param addrs
     * @return
     */
    void saveOrUpdate(List<ProduceFactoryProductAddr> addrs);

    /**
     * 删除产品地址
     * @param productId
     */
    void deleteProductAddrByProductId(Integer productId);

}
