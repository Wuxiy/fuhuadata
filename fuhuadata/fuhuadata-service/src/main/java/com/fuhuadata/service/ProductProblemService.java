package com.fuhuadata.service;

import com.fuhuadata.domain.ProductProblem;
import com.fuhuadata.domain.query.ProductProblemQuery;
import com.fuhuadata.domain.query.Result;

import java.util.List;

/**
 * 产品问题service
 * Created by wuxi on 2017/1/16.
 */
public interface ProductProblemService {

    /**
     * 新增ProductProblem
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel()得到新增的ProductProblem
     * @param productProblem
     * @return
     */
    public Result<ProductProblem> addProductProblem(ProductProblem productProblem);

    public Result updateProductProblemById(int id, ProductProblem productProblem);

    /**
     * 按照主键id删除记录
     * 返回result，通过rsult.isSuccess（）判断删除是否成功
     * @param id
     * @return
     */
    public Result deleteProductProblemById(int id);

    public Result<ProductProblem> getProductProblemById(int id);

    public Result<List<ProductProblem>> getProductProblemByQuery(ProductProblemQuery productProblemQuery);

    /**
     * 查询列表，包含分页查询
     * 查询分页信息，请设置
     * Query(设置当前页数)
     * Query(设置当前页面数据行数)
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getTotal()返回结果总数
     * 通过result.getModel()得到查询的单页列表信息
     * @param productProblemQuery
     * @return
     */
    public Result<List<ProductProblem>> getProductProblemsByPage(ProductProblemQuery productProblemQuery);

    /**
     * 查询总数
     * @param productProblemQuery
     * @return
     */
    public Result<Integer> count(ProductProblemQuery productProblemQuery);
}
