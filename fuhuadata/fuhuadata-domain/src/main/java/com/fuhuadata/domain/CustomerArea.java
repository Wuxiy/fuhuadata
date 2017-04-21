package com.fuhuadata.domain;

import java.io.Serializable;

/**
 * 客户地区目录dao实体
 * Created by hexingfu on 2017/3/9.
 */
public class CustomerArea implements Serializable{

    /**区域id**/
    private String pkAreacl;
    /**区域名称**/
    private String name;
    /**父级id**/
    private String pkFatherarea;

    public String getPkAreacl() {
        return pkAreacl;
    }

    public void setPkAreacl(String pkAreacl) {
        this.pkAreacl = pkAreacl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPkFatherarea() {
        return pkFatherarea;
    }

    public void setPkFatherarea(String pkFatherarea) {
        this.pkFatherarea = pkFatherarea;
    }
}
