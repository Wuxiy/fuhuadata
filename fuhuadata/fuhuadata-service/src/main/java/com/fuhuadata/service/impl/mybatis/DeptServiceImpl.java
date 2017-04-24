package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.constant.NodeType;
import com.fuhuadata.domain.mybatis.Dept;
import com.fuhuadata.domain.mybatis.Organization;
import com.fuhuadata.domain.plugin.TreeRoot;
import com.fuhuadata.service.mybatis.DeptService;
import com.fuhuadata.service.mybatis.OrganizationService;
import com.fuhuadata.service.util.UserTreeCache;
import com.fuhuadata.vo.MixNodeVO;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>User: wangjie
 * <p>Date: 4/11/2017
 */
@Service
public class DeptServiceImpl extends BaseServiceImpl<Dept, Integer> implements DeptService {

    @Autowired
    private OrganizationService orgService;

    public void refreshOrgAndDeptCache() {
        orgService.listOrgNodes();
        listDeptNodes();
    }

    @Override
    public List<MixNodeVO> getOrgDeptTree() {
        List<MixNodeVO> orgs = orgService.listOrgNodes();
        orgs.addAll(listDeptNodes());

        return convertToTree(orgs, new TreeRoot<MixNodeVO, String>() {
            @Override
            public boolean isRoot(MixNodeVO node) {
                return isOrgRoot(node);
            }
        });
    }

    private List<MixNodeVO> convertToTree(List<MixNodeVO> flatNodes, TreeRoot<MixNodeVO, String> rootable) {
        List<MixNodeVO> roots = Lists.newArrayList();
        Map<String, MixNodeVO> lookup = Maps.newHashMap();

        for (MixNodeVO node : flatNodes) {
            String id = node.getCid();
            String ncId = node.getNcId();

            if (lookup.get(id) != null) {// 作为父节点添加过
                node.setNodes(lookup.get(id).getNodes());
            }
            lookup.put(id, node);

            if (node.getType() == NodeType.ORG.key) {
                // 判断组织是否作为部门上级被添加过
                if (lookup.get(ncId) != null) {
                    node.setNodes(lookup.get(ncId).getNodes());
                }
                lookup.put(ncId, node);
            }

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

    // 上级节点为0则为根节点
    private boolean isOrgRoot(MixNodeVO nodeVO) {
        return StringUtils.isNotBlank(nodeVO.getPid()) && nodeVO.getPid().equals("0");
    }

    @Override
    public List<MixNodeVO> listDeptNodes() {
        List<MixNodeVO> nodes = Lists.newArrayList();
        List<Dept> depts = list();

        for (Dept dept : depts) {
            MixNodeVO nodeVO = convertToNode(dept);

            UserTreeCache.put(nodeVO.getCid(), nodeVO);

            nodes.add(nodeVO);
        }

        return nodes;
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

        List<MixNodeVO> nodes = Lists.transform(depts, new Function<Dept, MixNodeVO>() {
            @Override
            public MixNodeVO apply(Dept input) {
                return convertToNode(input);
            }
        });

        return convertToTree(nodes, new TreeRoot<MixNodeVO, String>() {
            @Override
            public boolean isRoot(MixNodeVO node) {
                return Objects.equal(node.getPid(), org.getNcId());
            }
        });
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
    public Dept getDeptByCode(String code) {
        Example example = new Example(Dept.class);
        example.createCriteria().andEqualTo("code", code);

        List<Dept> depts = listByExample(example);
        if (depts.size() == 1) {
            return depts.get(0);
        }

        return null;
    }

    private MixNodeVO convertToNode(Dept dept) {

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
