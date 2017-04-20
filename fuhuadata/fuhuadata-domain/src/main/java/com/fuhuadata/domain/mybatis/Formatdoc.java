package com.fuhuadata.domain.mybatis;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_formatdoc")
public class Formatdoc extends BaseEntity<String> {
    /**
     * 主键
     */
    @Id
    @Column(name = "pk_formatdoc")
    private String pkFormatdoc;

    /**
     * 名称
     */
    private String name;

    /**
     * 编码
     */
    private String code;

    /**
     * 获取主键
     *
     * @return pk_formatdoc - 主键
     */
    public String getPkFormatdoc() {
        return pkFormatdoc;
    }

    /**
     * 设置主键
     *
     * @param pkFormatdoc 主键
     */
    public void setPkFormatdoc(String pkFormatdoc) {
        this.pkFormatdoc = pkFormatdoc == null ? null : pkFormatdoc.trim();
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
     * 获取编码
     *
     * @return code - 编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置编码
     *
     * @param code 编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    @Override
    public void setId(String s) {
        this.pkFormatdoc = s;
    }

    @Override
    public String getId() {
        return this.pkFormatdoc;
    }
}