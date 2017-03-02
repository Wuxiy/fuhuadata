package com.fuhuadata.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * json_tree
 * Created by intanswer on 2017/2/24.
 */
public class CategoryTree implements Serializable {

    private Integer cid;
    private Integer pid;
    private String cname;

    private List<CategoryTree> nodes =new ArrayList<CategoryTree>();

    public CategoryTree(){

    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
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
}
