package com.fuhuadata.service.impl;

import com.fuhuadata.domain.ProductCategory;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.ProductCategoryManager;
import com.fuhuadata.service.ProductCategoryService;
import com.fuhuadata.vo.CategoryTree;
import com.fuhuadata.vo.ProductCategoryVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

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

    /**
     * 连接查询再构造
     * @return
     */
    @Override
    public Result<List<CategoryTree>> getProductCategoryByLevel() {
        Result<List<CategoryTree>> result = new Result<List<CategoryTree>>();
        try{
            List<ProductCategoryVO> list = productCategoryManager.getProductCategoryByLevel();
            result.addDefaultModel("CategoryTree",getAllNode(list));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("分层获取产品目录树错误");
        }
        return result;
    }

    /**
     * 结合map构造树形list
     * @param list
     * @return
     */
    public List<CategoryTree> getAllNode(List<ProductCategoryVO> list){
        Map<Integer, CategoryTree> map = new HashMap<Integer, CategoryTree>();
        List<CategoryTree> root_list = new ArrayList<CategoryTree>();
        try {
            for (ProductCategoryVO vo : list) {
                CategoryTree small = null;
                CategoryTree middle = null;
                CategoryTree big = null;
                //从三级判断
                if (vo.getSmallId() != null) {
                    small = new CategoryTree();
                    small.setCname(vo.getChild());
                    small.setPid(vo.getMiddleId());
                    small.setCid(vo.getSmallId());
                }
                if (vo.getMiddleId() != null) {
                    middle = map.get(vo.getMiddleId());
                    if (middle == null) {
                        middle = new CategoryTree();
                        middle.setCid(vo.getMiddleId());
                        middle.setPid(vo.getParentId());
                        middle.setCname(vo.getMiddle());
                    }
                    if (small != null) {
                        middle.addChildNode(small);
                    }
                    map.put(middle.getCid(), middle);
                }

                big = map.get(vo.getParentId());
                if (big == null) {
                    big = new CategoryTree();
                    big.setCid(vo.getParentId());
                    big.setPid(0);
                    big.setCname(vo.getParent());
                }
                if (middle != null) {
                    big.addChildNode(middle);
                }
                map.put(big.getCid(), big);
            }

            Set<Map.Entry<Integer, CategoryTree>> entrys = map.entrySet();
            for (Map.Entry<Integer, CategoryTree> entry : entrys) {
                if (entry.getValue().getPid() == 0) {
                    root_list.add(entry.getValue());
                }
            }
        }catch (Exception e){
            log.error("获取产品树方法错误",e);
        }
        return root_list;
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

    /**
     * 构造递归json树
     * @return
     */
    @Override
    public Result<List<CategoryTree>> getAllByTree() {
        List<CategoryTree> tree=new ArrayList<CategoryTree>();
        Result<List<CategoryTree>> result=new Result<List<CategoryTree>>();
        List<ProductCategory> list=productCategoryManager.getProductCategoryByPId(0);
        int n=list.size();
        for(int i=0;i<n;i++) {
            tree.add(recursiveTree(list.get(i).getId()));
        }
        result.addDefaultModel("CategoryTree",tree);
        return result;
    }

    /**
     * 递归方法
     * @param cid
     * @return
     */
    public CategoryTree recursiveTree(int cid ){
            ProductCategory productCategory=productCategoryManager.getProductCategoryById(cid);
            //构造多children集合的list
            CategoryTree node = new CategoryTree();
            node.setCid(productCategory.getId());
            node.setCname(productCategory.getName());
            node.setPid(productCategory.getParentId());
            //获取当前节点的全部子节点
            List<ProductCategory> list=productCategoryManager.getProductCategoryByPId(cid);

            List<CategoryTree> childTreeNodes =new ArrayList<CategoryTree>();
            for(int i=0;i<list.size();i++){
                CategoryTree tree = new CategoryTree();
                tree.setCid(list.get(i).getId());
                tree.setPid(list.get(i).getParentId());
                tree.setCname(list.get(i).getName());
                childTreeNodes.add(tree);
            }
            for(CategoryTree child : childTreeNodes){
                CategoryTree n = recursiveTree(child.getCid()); //递归
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
