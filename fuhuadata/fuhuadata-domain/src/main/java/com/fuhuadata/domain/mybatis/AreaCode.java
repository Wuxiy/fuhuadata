package com.fuhuadata.domain.mybatis;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "p_area_code")
public class AreaCode extends BaseEntity<String> {
    @Id
    private String areaid;

    @Column(name = "area_name")
    private String areaName;

    @Column(name = "e_area_name")
    private String eAreaName;

    @Column(name = "parent_id")
    private String parentId;

    @Column(name = "areaclass_id")
    private Integer areaclassId;

    private Integer level;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * @return areaid
     */
    public String getAreaid() {
        return areaid;
    }

    /**
     * @param areaid
     */
    public void setAreaid(String areaid) {
        this.areaid = areaid == null ? null : areaid.trim();
    }

    /**
     * @return area_name
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * @param areaName
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    /**
     * @return e_area_name
     */
    public String geteAreaName() {
        return eAreaName;
    }

    /**
     * @param eAreaName
     */
    public void seteAreaName(String eAreaName) {
        this.eAreaName = eAreaName == null ? null : eAreaName.trim();
    }

    /**
     * @return parent_id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * @return areaclass_id
     */
    public Integer getAreaclassId() {
        return areaclassId;
    }

    /**
     * @param areaclassId
     */
    public void setAreaclassId(Integer areaclassId) {
        this.areaclassId = areaclassId;
    }

    /**
     * @return level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public void setId(String s) {
        this.areaid = s == null ? null : s.trim();
    }

    @Override
    public String getId() {
        return this.areaid;
    }
}