package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.constant.NodeType;
import com.fuhuadata.domain.mybatis.Dept;
import com.fuhuadata.service.mybatis.DeptService;
import com.fuhuadata.service.mybatis.OrganizationService;
import com.fuhuadata.service.util.UserTreeCache;
import com.fuhuadata.vo.MixNodeVO;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
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

    @PostConstruct
    public void refreshOrgAndDeptCache() {
        orgService.listOrgNodes();
        listDeptNodes();
    }

    @Override
    public List<MixNodeVO> getOrgDeptTree() {
        List<MixNodeVO> orgs = orgService.listOrgNodes();
        orgs.addAll(listDeptNodes());

        return convertToTree(orgs);
    }

    private List<MixNodeVO> convertToTree(List<MixNodeVO> flatNodes) {
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
            if (isRoot(node)) {
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
    private boolean isRoot(MixNodeVO nodeVO) {
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

    private MixNodeVO convertToNode(Dept dept) {

        MixNodeVO nodeVO = new MixNodeVO(NodeType.DEPT.key);

        nodeVO.setCid(dept.getPkDept());
        nodeVO.setCname(dept.getName());
        nodeVO.setPid(dept.getParentId());
        nodeVO.setNcId(dept.getPkDept());
        nodeVO.setIsParent(true);

        return nodeVO;
    }
}
