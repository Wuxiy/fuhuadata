package com.fuhuadata.domain.oracle;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "BD_CUSTCLASS")
public class CustClass extends BaseEntity<String> {
    @Id
    @Column(name = "PK_CUSTCLASS")
    private String pkCustclass;

    @Column(name = "CODE")
    private String code;

    @Column(name = "CREATIONTIME")
    private String creationtime;

    @Column(name = "CREATOR")
    private String creator;

    @Column(name = "DATAORIGINFLAG")
    private BigDecimal dataoriginflag;

    @Column(name = "DEF1")
    private String def1;

    @Column(name = "DEF2")
    private String def2;

    @Column(name = "DEF3")
    private String def3;

    @Column(name = "DEF4")
    private String def4;

    @Column(name = "DEF5")
    private String def5;

    @Column(name = "DR")
    private Long dr;

    @Column(name = "ENABLESTATE")
    private BigDecimal enablestate;

    @Column(name = "INNERCODE")
    private String innercode;

    @Column(name = "MNECODE")
    private String mnecode;

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

    @Column(name = "PARENT_ID")
    private String parentId;

    @Column(name = "PK_GROUP")
    private String pkGroup;

    @Column(name = "PK_ORG")
    private String pkOrg;

    @Column(name = "TS")
    private String ts;

    /**
     * @return PK_CUSTCLASS
     */
    public String getPkCustclass() {
        return pkCustclass;
    }

    /**
     * @param pkCustclass
     */
    public void setPkCustclass(String pkCustclass) {
        this.pkCustclass = pkCustclass == null ? null : pkCustclass.trim();
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
     * @return DEF1
     */
    public String getDef1() {
        return def1;
    }

    /**
     * @param def1
     */
    public void setDef1(String def1) {
        this.def1 = def1 == null ? null : def1.trim();
    }

    /**
     * @return DEF2
     */
    public String getDef2() {
        return def2;
    }

    /**
     * @param def2
     */
    public void setDef2(String def2) {
        this.def2 = def2 == null ? null : def2.trim();
    }

    /**
     * @return DEF3
     */
    public String getDef3() {
        return def3;
    }

    /**
     * @param def3
     */
    public void setDef3(String def3) {
        this.def3 = def3 == null ? null : def3.trim();
    }

    /**
     * @return DEF4
     */
    public String getDef4() {
        return def4;
    }

    /**
     * @param def4
     */
    public void setDef4(String def4) {
        this.def4 = def4 == null ? null : def4.trim();
    }

    /**
     * @return DEF5
     */
    public String getDef5() {
        return def5;
    }

    /**
     * @param def5
     */
    public void setDef5(String def5) {
        this.def5 = def5 == null ? null : def5.trim();
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
     * @return ENABLESTATE
     */
    public BigDecimal getEnablestate() {
        return enablestate;
    }

    /**
     * @param enablestate
     */
    public void setEnablestate(BigDecimal enablestate) {
        this.enablestate = enablestate;
    }

    /**
     * @return INNERCODE
     */
    public String getInnercode() {
        return innercode;
    }

    /**
     * @param innercode
     */
    public void setInnercode(String innercode) {
        this.innercode = innercode == null ? null : innercode.trim();
    }

    /**
     * @return MNECODE
     */
    public String getMnecode() {
        return mnecode;
    }

    /**
     * @param mnecode
     */
    public void setMnecode(String mnecode) {
        this.mnecode = mnecode == null ? null : mnecode.trim();
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
     * @return PARENT_ID
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

    @Override
    public void setId(String s) {
        this.pkCustclass = s;
    }

    @Override
    public String getId() {
        return this.pkCustclass;
    }
}