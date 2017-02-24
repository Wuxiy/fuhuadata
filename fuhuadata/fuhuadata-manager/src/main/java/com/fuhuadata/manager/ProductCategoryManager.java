package com.fuhuadata.manager;

import com.fuhuadata.domain.ProductCategory;
import com.fuhuadata.vo.ProductCategoryVO;

import java.util.List;

/**
 * 产品目录
 * Created by intanswer on 2017/2/22.
 */
public interface ProductCategoryManager {

    public ProductCategory addProductCategory(ProductCategory productCategory);

    public boolean updateProductCategoryById(int id,ProductCategory productCategory);

    public boolean deleteProductCategoryById(int id);

    public ProductCategory getProductCategoryById(int id);

    public List<ProductCategory> getAll();

    public List<ProductCategory> getProductCategoryByPId(int pid);

    public List<ProductCategoryVO> getProductCategoryByLevel();
}
