package com.fuhuadata.vo;

import java.util.ArrayList;
import java.util.List;

/**
 *  评分项树
 * Created by wuxiy on 2017/6/2.
 */
public class ScoreItemTree {
    private String cid;
    private String pname;
    private String cname;
    private List<ScoreItemTree> nodes =new ArrayList<ScoreItemTree>();

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    /**
     * 添加当前节点的nodes
     * @param scoreItemTree
     */
    public void addChildNode(ScoreItemTree scoreItemTree){
        if(this.nodes == null){
            this.nodes = new ArrayList<ScoreItemTree>();
        }
        this.nodes.add(scoreItemTree);
    }

}
