package com.fuhuadata.domain.mybatis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fuhuadata.domain.plugin.Treeable;
import org.apache.commons.lang.StringUtils;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "p_dept")
public class Dept extends BaseEntity<Integer> implements Treeable<String> {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * nc中部门主键
     */
    @Column(name = "PK_DEPT")
    private String pkDept;

    /**
     * 上级部门
     */
    @Column(name = "PK_FATHERORG")
    private String pkFatherorg;

    /**
     * 所属集团
     */
    @Column(name = "PK_GROUP")
    private String pkGroup;

    /**
     * 所属组织
     */
    @Column(name = "PK_ORG")
    private String pkOrg;

    /**
     * 部门编码
     */
    @Column(name = "CODE")
    private String code;

    /**
     * 最后更新时间
     */
    @Column(name = "last_modify_time")
    private Date lastModifyTime;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取部门名称
     *
     * @return name - 部门名称
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
        if (StringUtils.isNotBlank(getPkFatherorg()) && getPkFatherorg().length() > 10) {
            return getPkFatherorg();
        }
        System.out.println("部门[" + getPkDept() + "]使用组织[" + getPkOrg() + "]作为上级节点");
        return getPkOrg();
    }

    @Override
    public void setParentId(String parentId) {
        throw new UnsupportedOperationException();
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
        return null;
    }

    @Override
    public String makeSelfAsNewParentIds() {
        return null;
    }

    @Override
    public Integer getWeight() {
        return null;
    }

    @Override
    public void setWeight(Integer weight) {

    }

    @Override
    public boolean isRoot() {
        return false;
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
     * 设置部门名称
     *
     * @param name 部门名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取nc中部门主键
     *
     * @return PK_DEPT - nc中部门主键
     */
    public String getPkDept() {
        return pkDept;
    }

    /**
     * 设置nc中部门主键
     *
     * @param pkDept nc中部门主键
     */
    public void setPkDept(String pkDept) {
        this.pkDept = pkDept == null ? null : pkDept.trim();
    }

    /**
     * 获取上级部门
     *
     * @return PK_FATHERORG - 上级部门
     */
    public String getPkFatherorg() {
        return pkFatherorg;
    }

    /**
     * 设置上级部门
     *
     * @param pkFatherorg 上级部门
     */
    public void setPkFatherorg(String pkFatherorg) {
        this.pkFatherorg = pkFatherorg == null ? null : pkFatherorg.trim();
    }

    /**
     * 获取所属集团
     *
     * @return PK_GROUP - 所属集团
     */
    public String getPkGroup() {
        return pkGroup;
    }

    /**
     * 设置所属集团
     *
     * @param pkGroup 所属集团
     */
    public void setPkGroup(String pkGroup) {
        this.pkGroup = pkGroup == null ? null : pkGroup.trim();
    }

    /**
     * 获取所属组织
     *
     * @return PK_ORG - 所属组织
     */
    public String getPkOrg() {
        return pkOrg;
    }

    /**
     * 设置所属组织
     *
     * @param pkOrg 所属组织
     */
    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg == null ? null : pkOrg.trim();
    }

    /**
     * 获取部门编码
     *
     * @return CODE - 部门编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置部门编码
     *
     * @param code 部门编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取最后更新时间
     *
     * @return last_modify_time - 最后更新时间
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * 设置最后更新时间
     *
     * @param lastModifyTime 最后更新时间
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}