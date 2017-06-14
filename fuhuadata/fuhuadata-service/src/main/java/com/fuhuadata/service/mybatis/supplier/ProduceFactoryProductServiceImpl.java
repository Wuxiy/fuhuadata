package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.dao.supplier.ProduceFactoryProductMapper;
import com.fuhuadata.domain.supplier.ProduceFactoryProduct;
import com.fuhuadata.domain.supplier.ProduceFactoryProductAddr;
import com.fuhuadata.manager.ProductWareManager;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * <p>User: wangjie
 * <p>Date: 5/23/2017
 */
@Service
public class ProduceFactoryProductServiceImpl extends BaseServiceImpl<ProduceFactoryProduct, Integer>
        implements ProduceFactoryProductService {

    private ProduceFactoryProductMapper getProductMapper() {
        return (ProduceFactoryProductMapper) baseMapper;
    }

    private ProduceFactoryProductAddrService productAddrService;

    @Resource
    private ProductWareManager productWareManager;

    @Resource
    public void setProductAddrService(ProduceFactoryProductAddrService addrService) {
        this.productAddrService = addrService;
    }

    @Override
    public ProduceFactoryProduct getById(Integer productId) {

        if (productId == null) {
            return null;
        }

        return getProductMapper().getById(productId);
    }

    @Override
    public List<ProduceFactoryProduct> listProducts(Integer factoryId) {

        if (null == factoryId) {
            return Collections.emptyList();
        }

        return getProductMapper().listFactoryProducts(factoryId);
    }

    @Override
    public ProduceFactoryProduct saveProduct(ProduceFactoryProduct product) {

        if (null == product) {
            return null;
        }

        setProductWareCode(product);

        saveSelective(product);

        saveOrUpdateAddrs(product);

        return product;
    }

    @Override
    public ProduceFactoryProduct updateProduct(ProduceFactoryProduct product) {

        if (null == product) {
            return null;
        }

        setProductWareCode(product);

        updateSelective(product);

        saveOrUpdateAddrs(product);

        return product;
    }

    @Override
    public void deleteProducts(Integer factoryId, List<Integer> productIds) {

        if (factoryId == null || CollectionUtils.isEmpty(productIds)) {
            return;
        }

        // 删除产品地址
        productIds.forEach(productAddrService::deleteProductAddrByProductId);

        Example example = newExample();
        example.createCriteria()
                .andEqualTo("factoryId", factoryId)
                .andIn("id", productIds);

        delete(example);
    }

    private void setProductWareCode(ProduceFactoryProduct product) {

        Optional.ofNullable(product)
                .map(ProduceFactoryProduct::getCmaterialId)
                .map(wareId -> productWareManager.getProductWareById(Integer.valueOf(wareId)))
                .ifPresent(productWare -> product.setCmaterialId(productWare.getCode()));
    }

    private void saveOrUpdateAddrs(ProduceFactoryProduct product) {

        List<ProduceFactoryProductAddr> productAddrs = product.getProductAddrs();
        Optional.ofNullable(productAddrs)
                .ifPresent(addrs -> addrs.forEach(addr -> addr.setProductId(product.getId())));

        productAddrService.saveOrUpdate(productAddrs);
    }
}
