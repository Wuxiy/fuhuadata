package com.fuhuadata.dao;

import com.fuhuadata.domain.ProductProblem;
import com.fuhuadata.domain.query.ProductProblemQuery;

import java.util.List;

/**
 * 产品问题dao
 * Created by intanswer on 2017/1/13.
 */
public interface ProductProblemDao {
    /**
     * 新增产品问题
     * @param productProblem
     * @return
     */
    public ProductProblem addProductProblem(ProductProblem productProblem);

    /**
     * 根据id更新产品问题，成功返回1
     * @param id
     * @param productProblem
     * @return
     */
    public int updateProductProblemById(int id, ProductProblem productProblem);

    /**
     * 根据id删除产品问题，成功删除返回1
     * @param id
     * @return
     */
    public int deleteProductProblemById(int id);

    /**
     *  查询列表，包含分页查询，查询结果为空返回空的List对象
     * 查询分页信息，请设置
     * Query(设置当前页数)
     * Query(设置当前页面数据行数)
     * @param productProblemQuery
     * @return
     */
    public List<ProductProblem> getProductProblemsByPage(ProductProblemQuery productProblemQuery);

    /**
     * 查询产品问题数量
     * @param productProblemQuery
     * @return
     */
    public int count(ProductProblemQuery productProblemQuery);
}
