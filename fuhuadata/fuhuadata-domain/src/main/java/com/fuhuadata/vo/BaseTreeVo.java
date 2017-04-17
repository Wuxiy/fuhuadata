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
    private boolean isParent;// 是否是父节点
    private boolean root;// 是否是根节点
    private boolean open = false;// 节点是否展开
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
    public void addChildNode(BaseTreeVo<ID> child) {
        if (this.nodes == null) {
            this.nodes = Lists.newArrayList();
        }

        nodes.add(child);
    }

    public boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(boolean parent) {
        isParent = parent;
    }

    public boolean getOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Boolean isRoot() {
        return root;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }
}
