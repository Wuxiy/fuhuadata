package com.fuhuadata.domain.mybatis;

import com.fuhuadata.domain.plugin.Treeable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_areacl")
public class AreaCl extends BaseEntity<String> implements Treeable<String> {

    /**
     * 地区分类主键
     */
    @Id
    @Column(name = "pk_areacl")
    private String pkAreacl;

    /**
     * 地区分类编码
     */
    private String code;

    /**
     * 地区分类名称
     */
    private String name;

    /**
     * 上级地区分类
     */
    @Column(name = "pk_fatherarea")
    private String pkFatherarea;

    /**
     * 获取地区分类主键
     *
     * @return pk_areacl - 地区分类主键
     */
    public String getPkAreacl() {
        return pkAreacl;
    }

    /**
     * 设置地区分类主键
     *
     * @param pkAreacl 地区分类主键
     */
    public void setPkAreacl(String pkAreacl) {
        this.pkAreacl = pkAreacl == null ? null : pkAreacl.trim();
    }

    /**
     * 获取地区分类编码
     *
     * @return code - 地区分类编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置地区分类编码
     *
     * @param code 地区分类编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取地区分类名称
     *
     * @return name - 地区分类名称
     */
    public String getName() {
        return name;
    }

    @Override
    public String getIcon() {
        return null;
    }

    @Override
    public void setIcon(String icon) {

    }

    @Override
    public String getParentId() {
        return pkFatherarea;
    }

    @Override
    public void setParentId(String parentId) {
        this.pkFatherarea = parentId;
    }

    @Override
    public String getParentIds() {
        return null;
    }

    @Override
    public void setParentIds(String parentIds) {

    }

    @Override
    public String getSeparator() {
        return ",";
    }

    @Override
    public String makeSelfAsNewParentIds() {
        return null;
    }

    @Override
    public Integer getWeight() {
        return 0;
    }

    @Override
    public void setWeight(Integer weight) {

    }

    @Override
    public boolean isRoot() {
        return getParentId() != null && getParentId().equals("~");
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public boolean isHasChildren() {
        return false;
    }

    @Override
    public String getRootDefaultIcon() {
        return null;
    }

    @Override
    public String getBranchDefaultIcon() {
        return null;
    }

    @Override
    public String getLeafDefaultIcon() {
        return null;
    }

    /**
     * 设置地区分类名称
     *
     * @param name 地区分类名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取上级地区分类
     *
     * @return pk_fatherarea - 上级地区分类
     */
    public String getPkFatherarea() {
        return pkFatherarea;
    }

    /**
     * 设置上级地区分类
     *
     * @param pkFatherarea 上级地区分类
     */
    public void setPkFatherarea(String pkFatherarea) {
        this.pkFatherarea = pkFatherarea == null ? null : pkFatherarea.trim();
    }

    @Override
    public void setId(String s) {
        this.pkAreacl = s;
    }

    @Override
    public String getId() {
        return this.pkAreacl;
    }
}