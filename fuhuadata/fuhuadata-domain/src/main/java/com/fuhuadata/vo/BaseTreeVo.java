package com.fuhuadata.vo;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 3/24/2017
 */
public class BaseTreeVo<ID extends Serializable> {

    private ID cid;
    private ID pid;
    private String cname;
    private List<BaseTreeVo> nodes;

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

    public List<BaseTreeVo> getNodes() {
        return nodes;
    }

    public void setNodes(List<BaseTreeVo> nodes) {
        this.nodes = nodes;
    }

    /**
     * 添加子节点
     * @param child
     */
    public void addChildNode(BaseTreeVo child) {
        if (this.nodes == null) {
            this.nodes = Lists.newArrayList();
        }

        nodes.add(child);
    }
}
