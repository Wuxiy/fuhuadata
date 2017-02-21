package com.fuhuadata.service.impl;

import com.fuhuadata.dao.ProductProblemDao;
import com.fuhuadata.domain.ProductProblem;
import com.fuhuadata.domain.query.ProductProblemQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.ProductProblemManager;
import com.fuhuadata.service.ProductProblemService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Created by intanswer on 2017/1/16.
 */
public class ProductProblemServiceImpl implements ProductProblemService {

    private static final Log log = LogFactory.getLog(ProductProblemServiceImpl.class);
    private ProductProblemManager productProblemManager;

    @Override
    public Result<ProductProblem> addProductProblem(ProductProblem productProblem) {
        Result<ProductProblem> result = new Result<ProductProblem>();
        try {
            result.addDefaultModel(productProblemManager.addProductProblem(productProblem));
        } catch (Exception e) {
            result.setSuccess(false);
            log.error("添加产品问题失败", e);
        }
        return result;
    }

    @Override
    public Result updateProductProblemById(int id, ProductProblem productProblem) {
        Result result = new Result();
        try {
            result.setSuccess(productProblemManager.updateProductProblemById(id, productProblem));
        } catch (Exception e) {
            result.setSuccess(false);
            log.error("更新产品问题失败", e);
        }
        return result;
    }

    @Override
    public Result deleteProductProblemById(int id) {
        Result result = new Result();
        try {
            result.setSuccess(productProblemManager.deleteProductProblemById(id));
        } catch (Exception e) {
            result.setSuccess(false);
            log.error("删除产品问题失败", e);
        }
        return result;
    }

    @Override
    public Result<ProductProblem> getProductProblemById(int id) {
        Result<ProductProblem> result = new Result<ProductProblem>();
        try {
            ProductProblem productProblem = productProblemManager.getProductProblemById(id);
            if(productProblem == null){
                result.setSimpleErrorMsg(0, "当前产品问题信息不存在，请重试");
            }else{
                result.addDefaultModel("ProductProblems", productProblem);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            // 打印日志
            log.error("根据id获取产品问题信息错误",e);
        }
        return result;
    }

    @Override
    public Result<List<ProductProblem>> getProductProblemByQuery(ProductProblemQuery productProblemQuery) {
        Result<List<ProductProblem>> result = new Result<List<ProductProblem>>();
        try {
            result.addDefaultModel("ProductProblems", productProblemManager.getProductProblemByQuery(productProblemQuery));
        } catch (Exception e) {
            result.setSuccess(false);
            // 打印日志
            log.error("查询产品问题列表错误",e);
        }
        return result;
    }

    @Override
    public Result<List<ProductProblem>> getProductProblemsByPage(ProductProblemQuery productProblemQuery) {
        Result<List<ProductProblem>> result = new Result<List<ProductProblem>>();
        try {
            result = productProblemManager.getProductProblemsByPage(productProblemQuery);
        } catch (Exception e) {
            result.setSuccess(false);
            log.error("分页获取产品问题失败", e);
        }
        return result;
    }

    @Override
    public Result<Integer> count(ProductProblemQuery productProblemQuery) {
        Result<Integer> result = new Result<Integer>();
        try {
            result.addDefaultModel(productProblemManager.count(productProblemQuery));
        } catch (Exception e) {
            result.setSuccess(false);
            log.error("查询产品问题数量失败", e);
        }
        return result;
    }

    public ProductProblemManager getProductProblemManager(){
        return productProblemManager;
    }
    public void setProductProblemManager(ProductProblemManager productProblemManager){
        this.productProblemManager=productProblemManager;
    }
}
