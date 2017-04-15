package com.fuhuadata.vo;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 3/24/2017
 */
public class BaseTreeVo<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = -1401407381179324776L;

    private ID cid;// 当前节点id
    private ID pid;// 父节点id
    private String cname;// 当前节点名称
    private Boolean isParent;// 是否是父节点
    private Boolean open = false;// 节点是否展开
    private List<BaseTreeVo<ID>> nodes;// 子节点集合

    public ID getCid() {
        return cid;
    }

    public void setCid(ID cid) {
        this.cid = cid;
    }

    public ID getPid() {
        return pid;
    }

    public void setPid(ID pid) {
        this.pid = pid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<BaseTreeVo<ID>> getNodes() {
        return nodes;
    }

    public void setNodes(List<BaseTreeVo<ID>> nodes) {
        this.nodes = nodes;
    }

    /**
     * 添加子节点
     *
     * @param child
     */
    public void addChildNode(BaseTreeVo child) {
        if (this.nodes == null) {
            this.nodes = Lists.newArrayList();
        }

        nodes.add(child);
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean parent) {
        isParent = parent;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
}
