package com.fuhuadata.domain.oracle;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "BD_INCOTERM")
public class IncoTerm extends BaseEntity<String> {
    @Id
    @Column(name = "PK_INCOTERM")
    private String pkIncoterm;

    @Column(name = "CODE")
    private String code;

    @Column(name = "CREATIONTIME")
    private String creationtime;

    @Column(name = "CREATOR")
    private String creator;

    @Column(name = "DATAORIGINFLAG")
    private BigDecimal dataoriginflag;

    @Column(name = "DATATYPE")
    private BigDecimal datatype;

    @Column(name = "DR")
    private Long dr;

    @Column(name = "FACTORYSHIP")
    private String factoryship;

    @Column(name = "MODIFIEDTIME")
    private String modifiedtime;

    @Column(name = "MODIFIER")
    private String modifier;

    @Column(name = "NAME")
    private String name;

    @Column(name = "NAME2")
    private String name2;

    @Column(name = "NAME3")
    private String name3;

    @Column(name = "NAME4")
    private String name4;

    @Column(name = "NAME5")
    private String name5;

    @Column(name = "NAME6")
    private String name6;

    @Column(name = "PK_GROUP")
    private String pkGroup;

    @Column(name = "PK_ORG")
    private String pkOrg;

    @Column(name = "TS")
    private String ts;

    @Column(name = "ISINCLUFARE")
    private String isinclufare;

    @Column(name = "ISINCLUPREM")
    private String isincluprem;

    /**
     * @return PK_INCOTERM
     */
    public String getPkIncoterm() {
        return pkIncoterm;
    }

    /**
     * @param pkIncoterm
     */
    public void setPkIncoterm(String pkIncoterm) {
        this.pkIncoterm = pkIncoterm == null ? null : pkIncoterm.trim();
    }

    /**
     * @return CODE
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * @return CREATIONTIME
     */
    public String getCreationtime() {
        return creationtime;
    }

    /**
     * @param creationtime
     */
    public void setCreationtime(String creationtime) {
        this.creationtime = creationtime == null ? null : creationtime.trim();
    }

    /**
     * @return CREATOR
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * @return DATAORIGINFLAG
     */
    public BigDecimal getDataoriginflag() {
        return dataoriginflag;
    }

    /**
     * @param dataoriginflag
     */
    public void setDataoriginflag(BigDecimal dataoriginflag) {
        this.dataoriginflag = dataoriginflag;
    }

    /**
     * @return DATATYPE
     */
    public BigDecimal getDatatype() {
        return datatype;
    }

    /**
     * @param datatype
     */
    public void setDatatype(BigDecimal datatype) {
        this.datatype = datatype;
    }

    /**
     * @return DR
     */
    public Long getDr() {
        return dr;
    }

    /**
     * @param dr
     */
    public void setDr(Long dr) {
        this.dr = dr;
    }

    /**
     * @return FACTORYSHIP
     */
    public String getFactoryship() {
        return factoryship;
    }

    /**
     * @param factoryship
     */
    public void setFactoryship(String factoryship) {
        this.factoryship = factoryship == null ? null : factoryship.trim();
    }

    /**
     * @return MODIFIEDTIME
     */
    public String getModifiedtime() {
        return modifiedtime;
    }

    /**
     * @param modifiedtime
     */
    public void setModifiedtime(String modifiedtime) {
        this.modifiedtime = modifiedtime == null ? null : modifiedtime.trim();
    }

    /**
     * @return MODIFIER
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * @param modifier
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return NAME2
     */
    public String getName2() {
        return name2;
    }

    /**
     * @param name2
     */
    public void setName2(String name2) {
        this.name2 = name2 == null ? null : name2.trim();
    }

    /**
     * @return NAME3
     */
    public String getName3() {
        return name3;
    }

    /**
     * @param name3
     */
    public void setName3(String name3) {
        this.name3 = name3 == null ? null : name3.trim();
    }

    /**
     * @return NAME4
     */
    public String getName4() {
        return name4;
    }

    /**
     * @param name4
     */
    public void setName4(String name4) {
        this.name4 = name4 == null ? null : name4.trim();
    }

    /**
     * @return NAME5
     */
    public String getName5() {
        return name5;
    }

    /**
     * @param name5
     */
    public void setName5(String name5) {
        this.name5 = name5 == null ? null : name5.trim();
    }

    /**
     * @return NAME6
     */
    public String getName6() {
        return name6;
    }

    /**
     * @param name6
     */
    public void setName6(String name6) {
        this.name6 = name6 == null ? null : name6.trim();
    }

    /**
     * @return PK_GROUP
     */
    public String getPkGroup() {
        return pkGroup;
    }

    /**
     * @param pkGroup
     */
    public void setPkGroup(String pkGroup) {
        this.pkGroup = pkGroup == null ? null : pkGroup.trim();
    }

    /**
     * @return PK_ORG
     */
    public String getPkOrg() {
        return pkOrg;
    }

    /**
     * @param pkOrg
     */
    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg == null ? null : pkOrg.trim();
    }

    /**
     * @return TS
     */
    public String getTs() {
        return ts;
    }

    /**
     * @param ts
     */
    public void setTs(String ts) {
        this.ts = ts == null ? null : ts.trim();
    }

    /**
     * @return ISINCLUFARE
     */
    public String getIsinclufare() {
        return isinclufare;
    }

    /**
     * @param isinclufare
     */
    public void setIsinclufare(String isinclufare) {
        this.isinclufare = isinclufare == null ? null : isinclufare.trim();
    }

    /**
     * @return ISINCLUPREM
     */
    public String getIsincluprem() {
        return isincluprem;
    }

    /**
     * @param isincluprem
     */
    public void setIsincluprem(String isincluprem) {
        this.isincluprem = isincluprem == null ? null : isincluprem.trim();
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