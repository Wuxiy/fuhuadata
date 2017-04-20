package com.fuhuadata.domain.mybatis;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_currtype")
public class Currtype extends BaseEntity<String> {
    /**
     * 主键
     */
    @Id
    @Column(name = "pk_currtype")
    private String pkCurrtype;

    /**
     * 名称
     */
    private String name;

    /**
     * 代码
     */
    private String code;

    /**
     * 获取主键
     *
     * @return pk_currtype - 主键
     */
    public String getPkCurrtype() {
        return pkCurrtype;
    }

    /**
     * 设置主键
     *
     * @param pkCurrtype 主键
     */
    public void setPkCurrtype(String pkCurrtype) {
        this.pkCurrtype = pkCurrtype == null ? null : pkCurrtype.trim();
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

    @Override
    public void setId(String s) {
        this.pkCurrtype = s;
    }

    @Override
    public String getId() {
        return pkCurrtype;
    }
}