package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.ProductProblemDao;
import com.fuhuadata.domain.ProductProblem;
import com.fuhuadata.domain.query.ProductProblemQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * 产品问题daoImpl
 * Created by intanswer on 2017/1/16.
 */
public class ProductProblemDaoImpl extends SqlMapClientTemplate implements ProductProblemDao {
    public static final String ADD = "PRODUCTPROBLEM.ADD";
    public static final String UPDATE = "PRODUCTPROBLEM.UPDATE";
    public static final String DELETE_BY_ID= "PRODUCTPROBLEM.DELETE-BY-ID";
    public static final String GET_PAGE = "PRODUCTPROBLEM.GET-PAGE";
    public static final String COUNT = "PRODUCTPROBLEM.COUNT";
    public static final String GET_BY_ID="PRODUCTPROBLEM.GET-BY-ID";
    public static final String GET_BY_QUERY="PRODUCTPROBLEM.GET-BY-QUERY";

    /**
     * 返回productProblem对象，设置了新生成的id
     * @param productProblem
     * @return
     */
    @Override
    public ProductProblem addProductProblem(ProductProblem productProblem) {
        productProblem.setProblemId((Integer)this.insert(ADD,productProblem));
        return productProblem;
    }

    @Override
    public int updateProductProblemById(int id, ProductProblem productProblem) {
        productProblem.setProblemId(id);
        return this.update(UPDATE,productProblem);
    }

    @Override
    public int deleteProductProblemById(int id) {
        return this.delete(DELETE_BY_ID,id);
    }

    @Override
    public ProductProblem getProductProblemById(int id) {
        return (ProductProblem)this.queryForObject(GET_BY_ID,id);
    }

    @Override
    public List<ProductProblem> getProductProblemByQuery(ProductProblemQuery productProblemQuery) {
        return this.queryForList(GET_BY_QUERY,productProblemQuery);
    }

    @Override
    public List<ProductProblem> getProductProblemsByPage(ProductProblemQuery productProblemQuery) {
        List<ProductProblem> list=this.queryForList(GET_PAGE,productProblemQuery);
        return list;
    }

    @Override
    public int count(ProductProblemQuery productProblemQuery) {
        return ((Integer) this.queryForObject(COUNT,productProblemQuery)).intValue();
    }
}
