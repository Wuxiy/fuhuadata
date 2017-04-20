package com.fuhuadata.domain.mybatis;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_incoterm")
public class Incoterm extends BaseEntity<String> {
    /**
     * 主键
     */
    @Id
    @Column(name = "pk_incoterm")
    private String pkIncoterm;

    /**
     * 名称
     */
    private String name;

    /**
     * 代码
     */
    private String code;

    /**
     * 是否包含运费  0：不含 1：含
     */
    private Byte isinclufare;

    /**
     * 是否包含保费   0：不含 1：含
     */
    private Byte isincluprem;

    /**
     * 获取主键
     *
     * @return pk_incoterm - 主键
     */
    public String getPkIncoterm() {
        return pkIncoterm;
    }

    /**
     * 设置主键
     *
     * @param pkIncoterm 主键
     */
    public void setPkIncoterm(String pkIncoterm) {
        this.pkIncoterm = pkIncoterm == null ? null : pkIncoterm.trim();
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取代码
     *
     * @return code - 代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置代码
     *
     * @param code 代码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取是否包含运费  0：不含 1：含
     *
     * @return isinclufare - 是否包含运费  0：不含 1：含
     */
    public Byte getIsinclufare() {
        return isinclufare;
    }

    /**
     * 设置是否包含运费  0：不含 1：含
     *
     * @param isinclufare 是否包含运费  0：不含 1：含
     */
    public void setIsinclufare(Byte isinclufare) {
        this.isinclufare = isinclufare;
    }

    /**
     * 获取是否包含保费   0：不含 1：含
     *
     * @return isincluprem - 是否包含保费   0：不含 1：含
     */
    public Byte getIsincluprem() {
        return isincluprem;
    }

    /**
     * 设置是否包含保费   0：不含 1：含
     *
     * @param isincluprem 是否包含保费   0：不含 1：含
     */
    public void setIsincluprem(Byte isincluprem) {
        this.isincluprem = isincluprem;
    }

    @Override
    public void setId(String s) {
        this.pkIncoterm = s;
    }

    @Override
    public String getId() {
        return this.pkIncoterm;
    }
}