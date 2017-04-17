package com.fuhuadata.vo.DataArchive;

/**
 * 贸易术语档案
 * Created by intanswer on 2017/4/17.
 */
public class Incoterm {
    private String pkIncoterm;

    private String name;

    private String code;

    /**是否包含运费  0：不含 1：含**/
    private Byte isinclufare;

    /**是否包含保费   0：不含 1：含**/
    private Byte isincluprem;

    public String getPkIncoterm() {
        return pkIncoterm;
    }

    public void setPkIncoterm(String pkIncoterm) {
        this.pkIncoterm = pkIncoterm;
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

    public Byte getIsinclufare() {
        return isinclufare;
    }

    public void setIsinclufare(Byte isinclufare) {
        this.isinclufare = isinclufare;
    }

    public Byte getIsincluprem() {
        return isincluprem;
    }

    public void setIsincluprem(Byte isincluprem) {
        this.isincluprem = isincluprem;
    }
}
