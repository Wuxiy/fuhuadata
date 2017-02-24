package com.fuhuadata.dao;

import com.fuhuadata.domain.ProductCategory;
import com.fuhuadata.vo.ProductCategoryTree;
import com.fuhuadata.vo.ProductCategoryVO;

import java.util.List;

/**
 * 产品目录dao
 * Created by intanswer on 2017/2/22.
 */
public interface ProductCategoryDao {
    public ProductCategory addProductCategory(ProductCategory productCategory);

    public int deleteProductCategoryById(int id);

    public int updateProductCategoryById(int id,ProductCategory productCategory);

    public ProductCategory getProductCategoryById(int id);

    public List<ProductCategory> getProductCategoryByParentId(int pid);

    public List<ProductCategory> getAll();

    public List<ProductCategoryVO> getProductCategoryByLevel();

    public List<Object> getParent();

    public List<Object> getMiddle();

    public int count();

}
