package com.fuhuadata.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * json_tree
 * Created by intanswer on 2017/2/24.
 */
public class  CategoryTree implements Serializable {

    private String cid;
    private String pid;
    private String cname;
    private List<CategoryTree> nodes =new ArrayList<CategoryTree>();

    public CategoryTree(){

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
