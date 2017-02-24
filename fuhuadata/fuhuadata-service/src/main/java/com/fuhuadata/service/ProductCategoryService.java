package com.fuhuadata.service;

import com.fuhuadata.domain.ProductCategory;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.vo.ProductCategoryTree;
import com.fuhuadata.vo.ProductCategoryVO;

import java.util.List;


/**
 * Created by intanswer on 2017/2/23.
 */
public interface ProductCategoryService {
    public Result<ProductCategory> addProductCategory(ProductCategory productCategory);

    public Result updateProductCategoryById(int id,ProductCategory productCategory);

    public Result deleteProductCategoryById(int id);

    public Result<List<ProductCategoryVO>> getProductCategoryByLevel();

    public Result<List<ProductCategory>> getAll();

    public Result<List<ProductCategoryTree>> getAllByTree();
}
