package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.BaseEntity;
import com.fuhuadata.domain.plugin.Treeable;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.BaseTreeableService;
import com.fuhuadata.vo.BaseTreeVo;
import com.fuhuadata.web.util.SystemLogAnnotation;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * <p>User: wangjie
 * <p>Date: 3/24/2017
 */
public abstract class BaseTreeableController<E extends BaseEntity<ID> & Treeable<ID>, ID extends Serializable>
        extends BaseController<E, ID> {

    protected BaseTreeableService<E, ID> baseService;

    @Autowired
    public void setBaseService(BaseTreeableService<E, ID> baseService) {
        this.baseService = baseService;
    }

    @RequestMapping(value = "ajax/load", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo load(HttpServletRequest request,
                           @RequestParam(value = "async", defaultValue = "true" ) boolean async,
                           @RequestParam(value = "searchName", required = false) String searchName,
                           @RequestParam(value = "parentId", required = false) ID parentId) {

        String defaultOrderBy = "parent_ids asc, order_index asc";
        Example example = new Example(entityClass);
        example.setOrderByClause(defaultOrderBy);

        List<E> nodes = Lists.newArrayList();
        List<E> children = Lists.newArrayList();
        List<ID> parentIds = Lists.newArrayList();// 父节点
        HashSet<ID> rootIds = Sets.newHashSet();// 树的根节点，也就是父节点

        if (!StringUtils.isEmpty(searchName)) {
            // 找出所有符合查询条件的节点
            Example searchExample = new Example(entityClass);
            searchExample.createCriteria().andLike("name", "%" + searchName + "%");
            searchExample.setOrderByClause(defaultOrderBy);
            nodes = baseService.listByExample(searchExample);
            // 找出这些符合条件节点的子节点
            children = baseService.findChildren(nodes, example);
            // 移除所有的子节点，留下的都是第一级的父节点
            nodes.removeAll(children);
            // 收集所有的父节点的 id
            parentIds = Lists.transform(nodes, new Function<E, ID>() {
                @Override
                public ID apply(E input) {
                    return input.getId();
                }
            });

            nodes.addAll(children);
        } else {

            if (parentId != null) {
                // 查询父节点
                E parent = baseService.get(parentId);
                nodes.add(parent);
                parentIds.add(parentId);
            } else {
                E root = baseService.getRoot();
                parentId = root.getId();
                nodes.add(root);
                parentIds.add(parentId);
            }

            if (!async) {
                // 同步，查询指定父节点下的子子孙孙
                children = baseService.findChildren(nodes, example);
                nodes.addAll(children);
            } else {
                // 异步，查询下一级子节点
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("parentId", parentId);
                children = baseService.listByExample(example);
                nodes.addAll(children);
            }
        }

        rootIds = Sets.newHashSet(parentIds);

        Result<List<BaseTreeVo<ID>>> result = new Result<List<BaseTreeVo<ID>>>(true);
        result.addDefaultModel(convertToTreeList(nodes, rootIds));

        return result.getResultPojo();
    }

    @RequestMapping(value = "/ajax/next", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo ajaxCountNextIndex(@RequestParam(value = "parentId") ID parentId) {
        int nextIndex = baseService.countNextIndex(parentId);

        Result<Integer> result = new Result<Integer>(true);
        result.addDefaultModel(nextIndex);
        return result.getResultPojo();
    }

    @RequestMapping(value = "ajax/{id}", method = RequestMethod.GET)
    @ResponseBody
    @SystemLogAnnotation(module = "baseTreeable",methods = "ajaxGetById")
    public ResultPojo ajaxGet(@PathVariable("id") ID id) {
        E node = baseService.get(id);

        Result<E> result = new Result<E>(true);
        result.addDefaultModel(node);
        return result.getResultPojo();
    }

    @RequestMapping(value = "/ajax/{id}/remove", method = RequestMethod.POST)
    @ResponseBody
    public ResultPojo ajaxDeleteSelfAndChildren(@PathVariable("id") ID id) {
        E node = baseService.get(id);

        baseService.deleteSelfAndChildren(node);

        Result<E> result = new Result<E>(true);
        result.addDefaultModel(node);
        return result.getResultPojo();
    }

    @RequestMapping(value = {"/ajax/add", "/ajax/update"}, method = RequestMethod.POST)
    @ResponseBody
    public ResultPojo ajaxAddChild(E node) {
        Result<Integer> result = new Result<Integer>(true);

        if (node == null) {
            result.setSuccess(false);
            result.setMessage("记录不存在");
            return result.getResultPojo();
        }

        ID parentId = node.getParentId();
        E parent = baseService.get(parentId);

        int id = baseService.appendChild(parent, node);

        result.addDefaultModel(id);
        return result.getResultPojo();
    }

    /**
     * 将扁平的 List 转换为树结构
     * @param items 包含父节点的集合
     * @param parentIds 父节点 id 的集合
     * @return
     */
    private List<BaseTreeVo<ID>> convertToTreeList(List<E> items, HashSet<ID> parentIds) {
        List<BaseTreeVo<ID>> roots = Lists.newArrayList();
        Map<ID, BaseTreeVo<ID>> lookup = Maps.newHashMap();

        for (E item : items) {
            BaseTreeVo<ID> node = convertToTree(item);
            ID id = node.getCid();

            if (lookup.get(id) != null) {
                // 如果存在，则前面作为父节点被添加过
                // 需要同步
                node.setNodes(lookup.get(id).getNodes());
            }
            lookup.put(id, node);

            if (parentIds.contains(id)) {
                // 父节点
                roots.add(node);
            } else {
                // 检查父节点是否在 Map 中创建，
                // 如果没有则创建
                ID pid = node.getPid();
                BaseTreeVo<ID> parentNode = lookup.get(pid);
                if (parentNode == null) {
                    parentNode = new BaseTreeVo<ID>();
                    parentNode.setCid(pid);
                    lookup.put(pid, parentNode);
                }

                parentNode.addChildNode(node);
            }
        }

        return roots;
    }

    private BaseTreeVo<ID> convertToTree(E node) {
        BaseTreeVo<ID> treeNode = new BaseTreeVo<ID>();
        treeNode.setCid(node.getId());
        treeNode.setCname(node.getName());
        treeNode.setPid(node.getParentId());

        return treeNode;
    }
}
