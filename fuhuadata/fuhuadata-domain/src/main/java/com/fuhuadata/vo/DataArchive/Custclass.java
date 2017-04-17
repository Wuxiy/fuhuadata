package com.fuhuadata.vo.DataArchive;


/**
 *  客户基本分类
 * Created by intanswer on 2017/4/15.
 */
public class Custclass {
    /**主键**/
    private String pkCustclass;

    /**名称**/
    private String name;

    /**客户基本分类编码**/
    private String code;

    /**上级客户基本分类**/
    private String parentId;

    /**启用状态 1=未启用，2=已启用，3=已停用**/
    private int  enablestate;

    public String getPkCustclass() {
        return pkCustclass;
    }

    public void setPkCustclass(String pkCustclass) {
        this.pkCustclass = pkCustclass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getEnablestate() {
        return enablestate;
    }

    public void setEnablestate(int enablestate) {
        this.enablestate = enablestate;
    }
}
