package com.fuhuadata.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * json_tree
 * Created by intanswer on 2017/2/24.
 */
public class CategoryTree implements Serializable {

    private String cid;
    private String pid;
    private String cname;
    private int isLeaf;//是否是产品叶子节点，0：不是（此种情况为分类目录） 1：是
    private List<CategoryTree> nodes =new ArrayList<CategoryTree>();

    public CategoryTree(){

    }

    public int getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(int isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<CategoryTree> getNodes() {
        return nodes;
    }

    public void setNodes(List<CategoryTree> nodes) {
        this.nodes = nodes;
    }

    /**
     * 添加当前节点的nodes
     * @param categy
     */
    public void addChildNode(CategoryTree categy){
        if(this.nodes == null){
            this.nodes = new ArrayList<CategoryTree>();
        }
        this.nodes.add(categy);
    }

}
