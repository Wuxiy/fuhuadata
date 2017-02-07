package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.ProductProblemDao;
import com.fuhuadata.domain.ProductProblem;
import com.fuhuadata.domain.query.ProductProblemQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.ProductProblemManager;

import java.util.List;

/**
 * 产品问题ManagerImpl
 * Created by intanswer on 2017/1/16.
 */
public class ProductProblemManagerImpl implements ProductProblemManager {
    private ProductProblemDao productProblemDao;
    @Override
    public ProductProblem addProductProblem(ProductProblem productProblem) {
        return productProblemDao.addProductProblem(productProblem);
    }

    /**
     * Dao成功更新返回1
     * @param id
     * @param productProblem
     * @return
     */
    @Override
    public boolean updateProductProblemById(int id, ProductProblem productProblem) {
        return productProblemDao.updateProductProblemById(id,productProblem) == 1 ? true:false;
    }

    @Override
    public boolean deleteProductProblemById(int id) {
        return productProblemDao.deleteProductProblemById(id) == 1 ? true:false;
    }

    /**
     * 查询列表，包含分页查询
     * 查询分页信息，请设置
     * Query(设置当前页数)
     * Query（设置当前页面数据）
     * 返回Result中，可以通过result。getTotal()返回结果总数
     * result中包装了分页需要的信息，和当前列表
     * @param productProblemQuery
     * @return
     */
    @Override
    public Result<List<ProductProblem>> getProductProblemsByPage(ProductProblemQuery productProblemQuery) {
        Result<List<ProductProblem>> result = new Result<List<ProductProblem>>();
        int totalItem=productProblemDao.count(productProblemQuery);
        productProblemQuery.setTotalItem(totalItem);
        if(totalItem > 0){
            result.addDefaultModel("ProductProblems",productProblemDao.getProductProblemsByPage(productProblemQuery));
        }else{
            result.addDefaultModel("ProductProblems",productProblemDao.getProductProblemsByPage(productProblemQuery));
        }
        result.setPageSize(productProblemQuery.getPageSize());
        result.setIndex(productProblemQuery.getIndex());
        result.setTotalItem(totalItem);
        return result;
    }

    @Override
    public int count(ProductProblemQuery productProblemQuery) {
        return productProblemDao.count(productProblemQuery);
    }
}
