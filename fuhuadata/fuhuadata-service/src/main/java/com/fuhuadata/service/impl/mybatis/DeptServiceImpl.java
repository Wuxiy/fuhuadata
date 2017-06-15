package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.constant.NodeType;
import com.fuhuadata.domain.mybatis.Dept;
import com.fuhuadata.domain.mybatis.Organization;
import com.fuhuadata.domain.plugin.NodeRoot;
import com.fuhuadata.domain.plugin.TreeRoot;
import com.fuhuadata.service.mybatis.DeptService;
import com.fuhuadata.service.mybatis.OrganizationService;
import com.fuhuadata.vo.MixNodeVO;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * <p>User: wangjie
 * <p>Date: 4/11/2017
 */
@Service
public class DeptServiceImpl extends BaseServiceImpl<Dept, Integer> implements DeptService {

    @Resource
    private OrganizationService orgService;

    private DeptService getCurrentProxy() {
        return (DeptService) AopContext.currentProxy();
    }

    @Override
    public List<MixNodeVO> getOrgDeptTree() {
        List<MixNodeVO> orgs = orgService.listOrgNodes();
        orgs.addAll(listDeptNodes());

        return convertToTree(orgs, new NodeRoot<MixNodeVO, String>());
    }

    private List<MixNodeVO> convertToTree(List<MixNodeVO> flatNodes, TreeRoot<MixNodeVO, String> rootable) {
        List<MixNodeVO> roots = Lists.newArrayList();
        Map<String, MixNodeVO> lookup = Maps.newHashMap();

        for (MixNodeVO node : flatNodes) {// 遍历所有的组织和部门节点
            String id = node.getCid();

            if (lookup.get(id) != null) {// 作为父节点添加过
                node.setNodes(lookup.get(id).getNodes());
            }
            lookup.put(id, node);

            String pid = node.getPid();
            if (rootable.isRoot(node)) {
                roots.add(node);
            } else {
                MixNodeVO parent = lookup.get(pid);
                if (parent == null) {// 没找到则新建
                    parent = new MixNodeVO(null);
                    parent.setCid(pid);
                    lookup.put(pid, parent);
                }
                parent.addChildNode(node);
            }
        }

        return roots;
    }

    @Override
    public List<MixNodeVO> listDeptNodes() {
        List<Dept> depts = getCurrentProxy().list();

        return depts.stream()
                .map(this::convertToNode)
                .collect(toList());
    }

    @Override
    public List<MixNodeVO> getDeptTree(Integer orgId) {

        final Organization org = orgService.get(orgId);

        return getDeptTree(org);
    }

    @Override
    public List<MixNodeVO> getDeptTree(String orgCode) {

        final Organization org = orgService.getByCode(orgCode);

        return getDeptTree(org);
    }

    @Override
    public List<MixNodeVO> getDeptTree(final Organization org) {

        List<Dept> depts = listDepts(org.getNcId());

        List<MixNodeVO> nodes = Lists.transform(depts, input -> {
            MixNodeVO node = convertToNode(input);
            node.setIsParent(false);
            return node;
        });

        return convertToTree(nodes, node -> Objects.equal(node.getPid(), org.getNcId()));
    }

    @Override
    public List<Dept> listDepts(String pkOrg) {
        if (StringUtils.isBlank(pkOrg)) {
            return Collections.emptyList();
        }

        Example example = new Example(Dept.class);
        example.createCriteria().andEqualTo("pkOrg", pkOrg);
        return listByExample(example);
    }

    @Override
    public List<Dept> listDepts(Integer orgId) {
        Organization org = orgService.get(orgId);

        if (org == null) {
            return Collections.emptyList();
        }

        return listDepts(org.getNcId());
    }

    @Override
    public Dept getByCode(String code) {
        Example example = new Example(Dept.class);
        example.createCriteria().andEqualTo("code", code);

        List<Dept> depts = listByExample(example);
        if (depts.size() == 1) {
            return depts.get(0);
        }

        return null;
    }

    @Override
    public Dept getByNcId(String pkDept) {

        if (StringUtils.isEmpty(pkDept)) {
            return null;
        }

        Dept dept = newEntity();
        dept.setPkDept(pkDept);

        return getCurrentProxy().get(dept);
    }

    @Override
    public Optional<Dept> getOptByNcId(String pkDep) {

        return Optional.ofNullable(getCurrentProxy().getByNcId(pkDep));
    }

    @Override
    public MixNodeVO getMixNodeByNcId(String pkOrg) {

        Dept dept = getCurrentProxy().getByNcId(pkOrg);
        if (dept == null) {
            return null;
        }

        return convertToNode(dept);
    }

    @Override
    public MixNodeVO getOrgOrDepPNode(String pid) {

        if (StringUtils.isEmpty(pid)) {
            return null;
        }

        // 是否是组织节点
        MixNodeVO pNode = orgService.getOptByNcId(pid)
                .map(orgService::convertToNode)
                .orElse(null);

        // 如果在组织节点中未找到，则在部门节点中找
        if (pNode == null) {
            pNode = getCurrentProxy().getOptByNcId(pid)
                        .map(this::convertToNode)
                        .orElse(null);
        }

        return pNode;
    }

    @Override
    public MixNodeVO convertToNode(Dept dept) {

        MixNodeVO nodeVO = new MixNodeVO(NodeType.DEPT.key);

        nodeVO.setCid(dept.getPkDept());
        nodeVO.setCode(dept.getCode());
        nodeVO.setCname(dept.getName());
        nodeVO.setPid(dept.getParentId());
        nodeVO.setNcId(dept.getPkDept());
        nodeVO.setIsParent(true);

        return nodeVO;
    }
}
