package com.fuhuadata.domain.mybatis;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_custclass")
public class Custclass extends BaseEntity<String> {
    /**
     * 主键
     */
    @Id
    @Column(name = "pk_custclass")
    private String pkCustclass;

    /**
     * 客户基本分类名称
     */
    private String name;

    /**
     * 客户基本分类编码
     */
    private String code;

    /**
     * 上级客户基本分类
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 启用状态 1=未启用，2=已启用，3=已停用， 
     */
    private Byte enablestate;

    /**
     * 获取主键
     *
     * @return pk_custclass - 主键
     */
    public String getPkCustclass() {
        return pkCustclass;
    }

    /**
     * 设置主键
     *
     * @param pkCustclass 主键
     */
    public void setPkCustclass(String pkCustclass) {
        this.pkCustclass = pkCustclass == null ? null : pkCustclass.trim();
    }

    /**
     * 获取客户基本分类名称
     *
     * @return name - 客户基本分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置客户基本分类名称
     *
     * @param name 客户基本分类名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取客户基本分类编码
     *
     * @return code - 客户基本分类编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置客户基本分类编码
     *
     * @param code 客户基本分类编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取上级客户基本分类
     *
     * @return parent_id - 上级客户基本分类
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置上级客户基本分类
     *
     * @param parentId 上级客户基本分类
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 获取启用状态 1=未启用，2=已启用，3=已停用， 
     *
     * @return enablestate - 启用状态 1=未启用，2=已启用，3=已停用， 
     */
    public Byte getEnablestate() {
        return enablestate;
    }

    /**
     * 设置启用状态 1=未启用，2=已启用，3=已停用， 
     *
     * @param enablestate 启用状态 1=未启用，2=已启用，3=已停用， 
     */
    public void setEnablestate(Byte enablestate) {
        this.enablestate = enablestate;
    }

    @Override
    public void setId(String s) {
        this.pkCustclass = s;
    }

    @Override
    public String getId() {
        return this.pkCustclass;
    }
}