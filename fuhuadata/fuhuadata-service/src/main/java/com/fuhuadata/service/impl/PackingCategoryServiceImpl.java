package com.fuhuadata.service.impl;

import com.fuhuadata.domain.PackingCategory;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.PackingCategoryManager;
import com.fuhuadata.service.PackingCategoryService;
import com.fuhuadata.vo.CategoryTree;
import com.fuhuadata.vo.PackingCategoryVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

/**
 * Created by intanswer on 2017/2/23.
 */
public class PackingCategoryServiceImpl implements PackingCategoryService {
    private static final Log log= LogFactory.getLog(PackingCategoryServiceImpl.class);
    private PackingCategoryManager packingCategoryManager;
    @Override
    public Result<PackingCategory> addPackingCategory(PackingCategory packingCategory) {
        Result<PackingCategory> result = new Result<PackingCategory>();
        try{
            result.addDefaultModel(packingCategoryManager.addPackingCategory(packingCategory));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("添加包材目录树节点错误",e);
        }
        return result;
    }

    @Override
    public Result updatePackingCategoryById(int id, PackingCategory packingCategory) {
        Result result = new Result();
        try{
            result.setSuccess(packingCategoryManager.updatePackingCategoryById(id,packingCategory));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据id更新包材目录节点错误",e);
        }
        return result;
    }

    @Override
    public Result deltePackingCategoryById(int id) {
        Result result = new Result();
        try {
           result.setSuccess(packingCategoryManager.deletePackingCategoryById(id));
        } catch (Exception e) {
            result.setSuccess(false);
            log.error("根据id删除包材树节点错误",e);
        }
        return result;
    }

    @Override
    public Result<List<PackingCategory>> getAll() {
        Result<List<PackingCategory>> result = new Result<List<PackingCategory>>();
        try {
            result.addDefaultModel("PackingCategory",packingCategoryManager.getAll());
        } catch (Exception e) {
            result.setSuccess(false);
            log.error("获取包材目录树原数据错误",e);
        }
        return result;
    }

    @Override
    public Result<List<CategoryTree>> getAllByTree() {
        List<CategoryTree> tree=new ArrayList<CategoryTree>();
        Result<List<CategoryTree>> result=new Result<List<CategoryTree>>();
        try {
            List<PackingCategoryVO> list = packingCategoryManager.getAllByLevel();
            result.addDefaultModel("CategoryTree", getAllNode(list));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("获取包材目录树错误",e);
        }
        return result;
    }


    /**
     * map构造list树
     * @param list
     * @return
     */
    public  List<CategoryTree> getAllNode(List<PackingCategoryVO> list){
        Map<Integer, CategoryTree> map = new HashMap<Integer, CategoryTree>();
        List<CategoryTree> root_list = new ArrayList<CategoryTree>();
        try {
            for (PackingCategoryVO vo : list) {
                CategoryTree child = null;
                CategoryTree parent = null;
                //从三级判断
                if (vo.getChildId() != null) {
                    child = new CategoryTree();
                    child.setCname(vo.getChildName());
                    child.setPid(vo.getParentId());
                    child.setCid(vo.getChildId());
                }
                parent = map.get(vo.getParentId());
                if (parent == null) {
                    parent = new CategoryTree();
                    parent.setCid(vo.getParentId());
                    parent.setPid(0);
                    parent.setCname(vo.getParentName());
                }
                if (child != null) {
                    parent.addChildNode(child);
                }
                map.put(parent.getCid(), parent);
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

    /**
     * 递归方法
     * @param cid
     * @return
     */
    public CategoryTree recursiveTree(int cid ){
        PackingCategory packingCategory=packingCategoryManager.getPackingCategoryById(cid);
        //构造多children集合的list
        CategoryTree node = new CategoryTree();
        node.setCid(packingCategory.getCategoryId());
        node.setCname(packingCategory.getCategoryName());
        node.setPid(packingCategory.getParentId());
        //获取当前节点的全部子节点
        List<PackingCategory> list=packingCategoryManager.getPackingCategoryByPId(cid);

        List<CategoryTree> childTreeNodes =new ArrayList<CategoryTree>();
        for(int i=0;i<list.size();i++){
            CategoryTree tree = new CategoryTree();
            tree.setCid(list.get(i).getCategoryId());
            tree.setPid(list.get(i).getParentId());
            tree.setCname(list.get(i).getCategoryName());
            childTreeNodes.add(tree);
        }
        for(CategoryTree child : childTreeNodes){
            CategoryTree n = recursiveTree(child.getCid()); //递归
            node.getNodes().add(n);
        }
        return node;
    }

    public PackingCategoryManager getPackingCategoryManager() {
        return packingCategoryManager;
    }

    public void setPackingCategoryManager(PackingCategoryManager packingCategoryManager) {
        this.packingCategoryManager = packingCategoryManager;
    }
}
