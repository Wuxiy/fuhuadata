package com.fuhuadata.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * jsontree
 * Created by intanswer on 2017/2/24.
 */
public class ProductCategoryTree implements Serializable {

    private Integer cid;
    private Integer pid;
    private String cname;

    private List nodes =new ArrayList();

    public ProductCategoryTree(){

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

    public List getNodes() {
        return nodes;
    }

    public void setNodes(List nodes) {
        this.nodes = nodes;
    }
}
