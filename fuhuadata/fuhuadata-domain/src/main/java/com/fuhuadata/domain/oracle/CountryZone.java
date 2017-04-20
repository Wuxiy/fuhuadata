package com.fuhuadata.domain.oracle;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "BD_COUNTRYZONE")
public class CountryZone extends BaseEntity<String> {

    private static final long serialVersionUID = 4603403175679466693L;

    @Id
    @Column(name = "PK_COUNTRY")
    private String pkCountry;

    @Column(name = "BBANRULE")
    private String bbanrule;

    @Column(name = "CODE")
    private String code;

    @Column(name = "CODETH")
    private String codeth;

    @Column(name = "CREATIONTIME")
    private String creationtime;

    @Column(name = "CREATOR")
    private String creator;

    @Column(name = "DATAORIGINFLAG")
    private BigDecimal dataoriginflag;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DR")
    private Long dr;

    @Column(name = "IBANLENGTH")
    private BigDecimal ibanlength;

    @Column(name = "IBANRULE")
    private String ibanrule;

    @Column(name = "ISEUCOUNTRY")
    private String iseucountry;

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

    @Column(name = "PHONECODE")
    private String phonecode;

    @Column(name = "PK_CURRTYPE")
    private String pkCurrtype;

    @Column(name = "PK_FORMAT")
    private String pkFormat;

    @Column(name = "PK_LANG")
    private String pkLang;

    @Column(name = "PK_ORG")
    private String pkOrg;

    @Column(name = "PK_TIMEZONE")
    private String pkTimezone;

    @Column(name = "TS")
    private String ts;

    @Column(name = "WHOLENAME")
    private String wholename;

    @Column(name = "WHOLENAME2")
    private String wholename2;

    @Column(name = "WHOLENAME3")
    private String wholename3;

    @Column(name = "WHOLENAME4")
    private String wholename4;

    @Column(name = "WHOLENAME5")
    private String wholename5;

    @Column(name = "WHOLENAME6")
    private String wholename6;

    @Column(name = "ENAME")
    private String ename;

    /**
     * @return PK_COUNTRY
     */
    public String getPkCountry() {
        return pkCountry;
    }

    /**
     * @param pkCountry
     */
    public void setPkCountry(String pkCountry) {
        this.pkCountry = pkCountry == null ? null : pkCountry.trim();
    }

    /**
     * @return BBANRULE
     */
    public String getBbanrule() {
        return bbanrule;
    }

    /**
     * @param bbanrule
     */
    public void setBbanrule(String bbanrule) {
        this.bbanrule = bbanrule == null ? null : bbanrule.trim();
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
     * @return CODETH
     */
    public String getCodeth() {
        return codeth;
    }

    /**
     * @param codeth
     */
    public void setCodeth(String codeth) {
        this.codeth = codeth == null ? null : codeth.trim();
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
     * @return DESCRIPTION
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
     * @return IBANLENGTH
     */
    public BigDecimal getIbanlength() {
        return ibanlength;
    }

    /**
     * @param ibanlength
     */
    public void setIbanlength(BigDecimal ibanlength) {
        this.ibanlength = ibanlength;
    }

    /**
     * @return IBANRULE
     */
    public String getIbanrule() {
        return ibanrule;
    }

    /**
     * @param ibanrule
     */
    public void setIbanrule(String ibanrule) {
        this.ibanrule = ibanrule == null ? null : ibanrule.trim();
    }

    /**
     * @return ISEUCOUNTRY
     */
    public String getIseucountry() {
        return iseucountry;
    }

    /**
     * @param iseucountry
     */
    public void setIseucountry(String iseucountry) {
        this.iseucountry = iseucountry == null ? null : iseucountry.trim();
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
     * @return PHONECODE
     */
    public String getPhonecode() {
        return phonecode;
    }

    /**
     * @param phonecode
     */
    public void setPhonecode(String phonecode) {
        this.phonecode = phonecode == null ? null : phonecode.trim();
    }

    /**
     * @return PK_CURRTYPE
     */
    public String getPkCurrtype() {
        return pkCurrtype;
    }

    /**
     * @param pkCurrtype
     */
    public void setPkCurrtype(String pkCurrtype) {
        this.pkCurrtype = pkCurrtype == null ? null : pkCurrtype.trim();
    }

    /**
     * @return PK_FORMAT
     */
    public String getPkFormat() {
        return pkFormat;
    }

    /**
     * @param pkFormat
     */
    public void setPkFormat(String pkFormat) {
        this.pkFormat = pkFormat == null ? null : pkFormat.trim();
    }

    /**
     * @return PK_LANG
     */
    public String getPkLang() {
        return pkLang;
    }

    /**
     * @param pkLang
     */
    public void setPkLang(String pkLang) {
        this.pkLang = pkLang == null ? null : pkLang.trim();
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
     * @return PK_TIMEZONE
     */
    public String getPkTimezone() {
        return pkTimezone;
    }

    /**
     * @param pkTimezone
     */
    public void setPkTimezone(String pkTimezone) {
        this.pkTimezone = pkTimezone == null ? null : pkTimezone.trim();
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
     * @return WHOLENAME
     */
    public String getWholename() {
        return wholename;
    }

    /**
     * @param wholename
     */
    public void setWholename(String wholename) {
        this.wholename = wholename == null ? null : wholename.trim();
    }

    /**
     * @return WHOLENAME2
     */
    public String getWholename2() {
        return wholename2;
    }

    /**
     * @param wholename2
     */
    public void setWholename2(String wholename2) {
        this.wholename2 = wholename2 == null ? null : wholename2.trim();
    }

    /**
     * @return WHOLENAME3
     */
    public String getWholename3() {
        return wholename3;
    }

    /**
     * @param wholename3
     */
    public void setWholename3(String wholename3) {
        this.wholename3 = wholename3 == null ? null : wholename3.trim();
    }

    /**
     * @return WHOLENAME4
     */
    public String getWholename4() {
        return wholename4;
    }

    /**
     * @param wholename4
     */
    public void setWholename4(String wholename4) {
        this.wholename4 = wholename4 == null ? null : wholename4.trim();
    }

    /**
     * @return WHOLENAME5
     */
    public String getWholename5() {
        return wholename5;
    }

    /**
     * @param wholename5
     */
    public void setWholename5(String wholename5) {
        this.wholename5 = wholename5 == null ? null : wholename5.trim();
    }

    /**
     * @return WHOLENAME6
     */
    public String getWholename6() {
        return wholename6;
    }

    /**
     * @param wholename6
     */
    public void setWholename6(String wholename6) {
        this.wholename6 = wholename6 == null ? null : wholename6.trim();
    }

    /**
     * @return ENAME
     */
    public String getEname() {
        return ename;
    }

    /**
     * @param ename
     */
    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    @Override
    public void setId(String s) {
        this.pkCountry = s;
    }

    @Override
    public String getId() {
        return this.pkCountry;
    }
}