package com.fuhuadata.service.impl;

import com.fuhuadata.domain.ProductCategory;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.ProductCategoryManager;
import com.fuhuadata.service.ProductCategoryService;
import com.fuhuadata.vo.ProductCategoryTree;
import com.fuhuadata.vo.ProductCategoryVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品目录树service
 * Created by intanswer on 2017/2/23.
 */
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final static Log log = LogFactory.getLog(ProductCategoryServiceImpl.class);
    private ProductCategoryManager productCategoryManager;

    @Override
    public Result<ProductCategory> addProductCategory(ProductCategory productCategory) {
        Result<ProductCategory> result = new Result<ProductCategory>();
        try{
            result.addDefaultModel(productCategoryManager.addProductCategory(productCategory));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("添加产品目录树错误",e);
        }
        return result;
    }

    @Override
    public Result updateProductCategoryById(int id, ProductCategory productCategory) {
        Result result = new Result();
        try{
            result.setSuccess(productCategoryManager.updateProductCategoryById(id,productCategory));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("修改产品目录树错误",e);
        }
        return result;
    }

    @Override
    public Result deleteProductCategoryById(int id) {
        Result result = new Result();
        try{
            result.setSuccess(productCategoryManager.deleteProductCategoryById(id));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据id删除产品目录树错误");
        }
        return result;
    }

    @Override
    public Result<List<ProductCategoryVO>> getProductCategoryByLevel() {
        Result<List<ProductCategoryVO>> result = new Result<List<ProductCategoryVO>>();
        try{
            result.addDefaultModel("ProductCategoryVO",productCategoryManager.getProductCategoryByLevel() );
        }catch(Exception e){
            result.setSuccess(false);
            log.error("分层获取产品目录树错误");
        }
        return result;
    }

    @Override
    public Result<List<ProductCategory>> getAll() {
        Result<List<ProductCategory>> result = new Result<List<ProductCategory>>();
        try{
            result.addDefaultModel("ProductCategory",productCategoryManager.getAll());
        }catch(Exception e){
            result.setSuccess(false);
            log.error("产品目录树原数据获取错误",e);
        }
        return result;
    }

    @Override
    public Result<List<ProductCategoryTree>> getAllByTree() {
        Result<List<ProductCategoryTree>> result=new Result<List<ProductCategoryTree>>();
        List<ProductCategoryTree> list=productCategoryManager.getProductCategoryByPId(0);
        int n=list.size();
        for(int i=0;i<n;i++) {
          System.out.println(recursiveTree(list.get(i).getCid()));
        }
        return result;
    }

    public ProductCategoryTree recursiveTree(int cid ){
        ProductCategoryTree node=productCategoryManager.getProductCategoryById(cid);
        List<ProductCategoryTree> childTreeNodes=productCategoryManager.getProductCategoryByPId(cid);
        for(ProductCategoryTree child : childTreeNodes){
            ProductCategoryTree n = recursiveTree(child.getCid()); //递归
            node.getNodes().add(n);
        }
        return node;
    }

    public void setProductCategoryManager(ProductCategoryManager productCategoryManager) {
        this.productCategoryManager = productCategoryManager;
    }
    public ProductCategoryManager getProductCategoryManager(){
        return this.productCategoryManager;
    }


}
