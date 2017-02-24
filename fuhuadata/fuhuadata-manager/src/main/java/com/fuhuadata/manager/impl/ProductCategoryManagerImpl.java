package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.ProductCategoryDao;
import com.fuhuadata.domain.ProductCategory;
import com.fuhuadata.manager.ProductCategoryManager;
import com.fuhuadata.vo.ProductCategoryTree;
import com.fuhuadata.vo.ProductCategoryVO;

import java.util.List;

/**
 * 产品目录Manager
 * Created by intanswer on 2017/2/22.
 */
public class ProductCategoryManagerImpl implements ProductCategoryManager {
    private ProductCategoryDao productCategoryDao;
    @Override
    public ProductCategory addProductCategory(ProductCategory productCategory) {

        return productCategoryDao.addProductCategory(productCategory);
    }

    @Override
    public boolean updateProductCategoryById(int id, ProductCategory productCategory) {
        return productCategoryDao.updateProductCategoryById(id,productCategory)==1?true:false;
    }

    @Override
    public boolean deleteProductCategoryById(int id) {
        return productCategoryDao.deleteProductCategoryById(id)==1?true:false;
    }

    @Override
    public ProductCategory getProductCategoryById(int id) {
        return productCategoryDao.getProductCategoryById(id);
    }

    @Override
    public List<ProductCategory> getAll() {
        return productCategoryDao.getAll();
    }

    @Override
    public List<ProductCategory> getProductCategoryByPId(int pid) {
        return productCategoryDao.getProductCategoryByParentId(pid);
    }

    @Override
    public List<ProductCategoryVO> getProductCategoryByLevel() {
        return productCategoryDao.getProductCategoryByLevel();
    }

    public void setProductCategoryDao(ProductCategoryDao productCategoryDao) {
        this.productCategoryDao = productCategoryDao;
    }
    public ProductCategoryDao getProductCategoryDao(){
        return this.productCategoryDao;
    }
}
