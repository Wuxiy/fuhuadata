package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.ProductCategoryDao;
import com.fuhuadata.domain.ProductCategory;
import com.fuhuadata.vo.ProductCategoryVO;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by intanswer on 2017/2/22.
 */
public class ProductCategoryDaoImpl extends SqlMapClientTemplate implements ProductCategoryDao {
    public static final String ADD="PRODUCTCATEGORY.ADD";
    public static final String GET_ALL="PRODUCTCATEGORY.GET-ALL";
    public static final String GET_BY_LEVEL="PRODUCTCATEGORY.GET-BY-LEVEL";
    public static final String GET_BY_WARE="PRODUCTCATEGORY.GET-BY-WARE";
    public static final String UPDATE="PRODUCTCATEGORY.UPDATE";
    public static final String DELETE="PRODUCTCATEGORY.DELETE";
    public static final String COUNT="PRODUCTCATEGORY.COUNT";
    public static final String GET_BY_ID="PRODUCTCATEGORY.GET-BY-ID";
    public static final String GET_BY_PID="PRODUCTCATEGORY.GET-BY-PID";
    @Override
    public ProductCategory addProductCategory(ProductCategory productCategory) {
        productCategory.setId((Integer)this.insert(ADD,productCategory));
        return productCategory;
    }

    @Override
    public int deleteProductCategoryById(int id) {
        return this.delete(DELETE,id);
    }

    @Override
    public int updateProductCategoryById(int id, ProductCategory productCategory) {
        return this.update(UPDATE,productCategory);
    }

    @Override
    public ProductCategory getProductCategoryById(int id) {
        return (ProductCategory) this.queryForObject(GET_BY_ID,id);
    }

    @Override
    public List<ProductCategory> getProductCategoryByParentId(int pid) {
        return this.queryForList(GET_BY_PID,pid);
    }

    @Override
    public List<ProductCategory> getAll() {
        return this.queryForList(GET_ALL);
    }

    @Override
    public List<ProductCategoryVO> getProductCategoryByLevel() {
        return this.queryForList(GET_BY_LEVEL);
    }

    @Override
    public List<Object> getParent() {
        return null;
    }

    @Override
    public List<Object> getMiddle() {
        return null;
    }

    @Override
    public int count() {
        return ((Integer)this.queryForObject(COUNT)).intValue();
    }

    @Override
    public List<ProductCategoryVO> getProductWare() {
        return this.queryForList(GET_BY_WARE);
    }
}
