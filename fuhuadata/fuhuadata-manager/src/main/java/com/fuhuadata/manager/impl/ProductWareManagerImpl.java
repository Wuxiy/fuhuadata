package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.ProductWareDao;
import com.fuhuadata.domain.ProductWare;
import com.fuhuadata.manager.ProductWareManager;

import java.util.List;

/**
 * Created by intanswer on 2017/3/4.
 */
public class ProductWareManagerImpl implements ProductWareManager {

    private ProductWareDao productWareDao;
    @Override
    public ProductWare addProductWare(ProductWare productWare) {
        return productWareDao.addProductWare(productWare);
    }

    @Override
    public boolean deleteProductWareById(int id) {
        return productWareDao.deleteProductWareById(id)==1 ? true:false;
    }

    @Override
    public boolean updateProductWareById(int id, ProductWare productWare) {
        return productWareDao.updateProductWareById(id,productWare)==1?true : false;
    }

    @Override
    public List<ProductWare> getProductWareByPId(int id) {
        return productWareDao.getProductWareByPId(id);
    }

    @Override
    public ProductWare getProductWareById(int id) {
        return productWareDao.getProductWareById(id);
    }

    @Override
    public int countByPId(int id) {
        return productWareDao.countByPId(id);
    }

    public void setProductWareDao(ProductWareDao productWareDao) {
        this.productWareDao = productWareDao;
    }
    public ProductWareDao getProductWareDao(){
        return this.productWareDao;
    }
}
