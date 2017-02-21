package com.fuhuadata.manager;

import com.fuhuadata.domain.ProductProblem;
import com.fuhuadata.domain.query.ProductProblemQuery;
import com.fuhuadata.domain.query.Result;

import java.net.PortUnreachableException;
import java.util.List;

/**
 * 产品问题Manager
 * Created by intanswer on 2017/1/13.
 */
public interface ProductProblemManager {
    /**
     * 新增ProductProblem，返回ProductProblem对象（设置了新生成id）
     * @param productProblem
     * @return
     */
    public ProductProblem addProductProblem(ProductProblem productProblem);

    /**
     * 按照主键id更新ProductProblem，请重新new ProductProblem 的更新对象，设置要更新的字段
     * 成功返回true，失败返回false
     * @param id
     * @param productProblem
     * @return
     */
        public boolean updateProductProblemById(int id, ProductProblem productProblem);

    /**
     * 根据主键id删除产品问题
     * @param id
     * @return
     */
    public boolean deleteProductProblemById(int id);

    public ProductProblem getProductProblemById(int id);

    public List<ProductProblem> getProductProblemByQuery(ProductProblemQuery productProblemQuery);

    /**
     * 查询列表，包含分页查询，
     * 查询分页信息，请设置
     * Query（设置当前页数）
     * Query（设置当前页数数据行数）
     * 返回Result中，可以通过result.getTotal()返回结果总数
     * result中封装了分页需要的信息，和当前列表
     * @param productProblemQuery
     * @return
     */
    public Result<List<ProductProblem>> getProductProblemsByPage(ProductProblemQuery productProblemQuery);

    public int count(ProductProblemQuery productProblemQuery);

}
