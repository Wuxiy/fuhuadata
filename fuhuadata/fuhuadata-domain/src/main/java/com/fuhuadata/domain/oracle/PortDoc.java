package com.fuhuadata.domain.oracle;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;


public class PortDoc extends BaseEntity<String> {
    @Id
    @Column(name = "PK_PORTDOC")
    private String pkPortdoc;

    @Column(name = "CDISTRICTID")
    private String cdistrictid;

    @Column(name = "CREATIONTIME")
    private String creationtime;

    @Column(name = "CREATOR")
    private String creator;

    @Column(name = "DR")
    private Long dr;

    @Column(name = "ENABLESTATE")
    private BigDecimal enablestate;

    @Column(name = "MODIFIEDTIME")
    private String modifiedtime;

    @Column(name = "MODIFIER")
    private String modifier;

    @Column(name = "PK_GROUP")
    private String pkGroup;

    @Column(name = "PK_ORG")
    private String pkOrg;

    @Column(name = "TS")
    private String ts;

    @Column(name = "VCODE")
    private String vcode;

    @Column(name = "VDEF1")
    private String vdef1;

    @Column(name = "VDEF10")
    private String vdef10;

    @Column(name = "VDEF11")
    private String vdef11;

    @Column(name = "VDEF12")
    private String vdef12;

    @Column(name = "VDEF13")
    private String vdef13;

    @Column(name = "VDEF14")
    private String vdef14;

    @Column(name = "VDEF15")
    private String vdef15;

    @Column(name = "VDEF16")
    private String vdef16;

    @Column(name = "VDEF17")
    private String vdef17;

    @Column(name = "VDEF18")
    private String vdef18;

    @Column(name = "VDEF19")
    private String vdef19;

    @Column(name = "VDEF2")
    private String vdef2;

    @Column(name = "VDEF20")
    private String vdef20;

    @Column(name = "VDEF3")
    private String vdef3;

    @Column(name = "VDEF4")
    private String vdef4;

    @Column(name = "VDEF5")
    private String vdef5;

    @Column(name = "VDEF6")
    private String vdef6;

    @Column(name = "VDEF7")
    private String vdef7;

    @Column(name = "VDEF8")
    private String vdef8;

    @Column(name = "VDEF9")
    private String vdef9;

    @Column(name = "VENNAME")
    private String venname;

    @Column(name = "VNAME")
    private String vname;

    @Column(name = "VNAME2")
    private String vname2;

    @Column(name = "VNAME3")
    private String vname3;

    @Column(name = "VNAME4")
    private String vname4;

    @Column(name = "VNAME5")
    private String vname5;

    @Column(name = "VNAME6")
    private String vname6;

    @Column(name = "VNOTE")
    private String vnote;

    private String country;
    private String ecountry;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEcountry() {
        return ecountry;
    }

    public void setEcountry(String ecountry) {
        this.ecountry = ecountry;
    }

    /**
     * @return PK_PORTDOC
     */
    public String getPkPortdoc() {
        return pkPortdoc;
    }

    /**
     * @param pkPortdoc
     */
    public void setPkPortdoc(String pkPortdoc) {
        this.pkPortdoc = pkPortdoc == null ? null : pkPortdoc.trim();
    }

    /**
     * @return CDISTRICTID
     */
    public String getCdistrictid() {
        return cdistrictid;
    }

    /**
     * @param cdistrictid
     */
    public void setCdistrictid(String cdistrictid) {
        this.cdistrictid = cdistrictid == null ? null : cdistrictid.trim();
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
     * @return VCODE
     */
    public String getVcode() {
        return vcode;
    }

    /**
     * @param vcode
     */
    public void setVcode(String vcode) {
        this.vcode = vcode == null ? null : vcode.trim();
    }

    /**
     * @return VDEF1
     */
    public String getVdef1() {
        return vdef1;
    }

    /**
     * @param vdef1
     */
    public void setVdef1(String vdef1) {
        this.vdef1 = vdef1 == null ? null : vdef1.trim();
    }

    /**
     * @return VDEF10
     */
    public String getVdef10() {
        return vdef10;
    }

    /**
     * @param vdef10
     */
    public void setVdef10(String vdef10) {
        this.vdef10 = vdef10 == null ? null : vdef10.trim();
    }

    /**
     * @return VDEF11
     */
    public String getVdef11() {
        return vdef11;
    }

    /**
     * @param vdef11
     */
    public void setVdef11(String vdef11) {
        this.vdef11 = vdef11 == null ? null : vdef11.trim();
    }

    /**
     * @return VDEF12
     */
    public String getVdef12() {
        return vdef12;
    }

    /**
     * @param vdef12
     */
    public void setVdef12(String vdef12) {
        this.vdef12 = vdef12 == null ? null : vdef12.trim();
    }

    /**
     * @return VDEF13
     */
    public String getVdef13() {
        return vdef13;
    }

    /**
     * @param vdef13
     */
    public void setVdef13(String vdef13) {
        this.vdef13 = vdef13 == null ? null : vdef13.trim();
    }

    /**
     * @return VDEF14
     */
    public String getVdef14() {
        return vdef14;
    }

    /**
     * @param vdef14
     */
    public void setVdef14(String vdef14) {
        this.vdef14 = vdef14 == null ? null : vdef14.trim();
    }

    /**
     * @return VDEF15
     */
    public String getVdef15() {
        return vdef15;
    }

    /**
     * @param vdef15
     */
    public void setVdef15(String vdef15) {
        this.vdef15 = vdef15 == null ? null : vdef15.trim();
    }

    /**
     * @return VDEF16
     */
    public String getVdef16() {
        return vdef16;
    }

    /**
     * @param vdef16
     */
    public void setVdef16(String vdef16) {
        this.vdef16 = vdef16 == null ? null : vdef16.trim();
    }

    /**
     * @return VDEF17
     */
    public String getVdef17() {
        return vdef17;
    }

    /**
     * @param vdef17
     */
    public void setVdef17(String vdef17) {
        this.vdef17 = vdef17 == null ? null : vdef17.trim();
    }

    /**
     * @return VDEF18
     */
    public String getVdef18() {
        return vdef18;
    }

    /**
     * @param vdef18
     */
    public void setVdef18(String vdef18) {
        this.vdef18 = vdef18 == null ? null : vdef18.trim();
    }

    /**
     * @return VDEF19
     */
    public String getVdef19() {
        return vdef19;
    }

    /**
     * @param vdef19
     */
    public void setVdef19(String vdef19) {
        this.vdef19 = vdef19 == null ? null : vdef19.trim();
    }

    /**
     * @return VDEF2
     */
    public String getVdef2() {
        return vdef2;
    }

    /**
     * @param vdef2
     */
    public void setVdef2(String vdef2) {
        this.vdef2 = vdef2 == null ? null : vdef2.trim();
    }

    /**
     * @return VDEF20
     */
    public String getVdef20() {
        return vdef20;
    }

    /**
     * @param vdef20
     */
    public void setVdef20(String vdef20) {
        this.vdef20 = vdef20 == null ? null : vdef20.trim();
    }

    /**
     * @return VDEF3
     */
    public String getVdef3() {
        return vdef3;
    }

    /**
     * @param vdef3
     */
    public void setVdef3(String vdef3) {
        this.vdef3 = vdef3 == null ? null : vdef3.trim();
    }

    /**
     * @return VDEF4
     */
    public String getVdef4() {
        return vdef4;
    }

    /**
     * @param vdef4
     */
    public void setVdef4(String vdef4) {
        this.vdef4 = vdef4 == null ? null : vdef4.trim();
    }

    /**
     * @return VDEF5
     */
    public String getVdef5() {
        return vdef5;
    }

    /**
     * @param vdef5
     */
    public void setVdef5(String vdef5) {
        this.vdef5 = vdef5 == null ? null : vdef5.trim();
    }

    /**
     * @return VDEF6
     */
    public String getVdef6() {
        return vdef6;
    }

    /**
     * @param vdef6
     */
    public void setVdef6(String vdef6) {
        this.vdef6 = vdef6 == null ? null : vdef6.trim();
    }

    /**
     * @return VDEF7
     */
    public String getVdef7() {
        return vdef7;
    }

    /**
     * @param vdef7
     */
    public void setVdef7(String vdef7) {
        this.vdef7 = vdef7 == null ? null : vdef7.trim();
    }

    /**
     * @return VDEF8
     */
    public String getVdef8() {
        return vdef8;
    }

    /**
     * @param vdef8
     */
    public void setVdef8(String vdef8) {
        this.vdef8 = vdef8 == null ? null : vdef8.trim();
    }

    /**
     * @return VDEF9
     */
    public String getVdef9() {
        return vdef9;
    }

    /**
     * @param vdef9
     */
    public void setVdef9(String vdef9) {
        this.vdef9 = vdef9 == null ? null : vdef9.trim();
    }

    /**
     * @return VENNAME
     */
    public String getVenname() {
        return venname;
    }

    /**
     * @param venname
     */
    public void setVenname(String venname) {
        this.venname = venname == null ? null : venname.trim();
    }

    /**
     * @return VNAME
     */
    public String getVname() {
        return vname;
    }

    /**
     * @param vname
     */
    public void setVname(String vname) {
        this.vname = vname == null ? null : vname.trim();
    }

    /**
     * @return VNAME2
     */
    public String getVname2() {
        return vname2;
    }

    /**
     * @param vname2
     */
    public void setVname2(String vname2) {
        this.vname2 = vname2 == null ? null : vname2.trim();
    }

    /**
     * @return VNAME3
     */
    public String getVname3() {
        return vname3;
    }

    /**
     * @param vname3
     */
    public void setVname3(String vname3) {
        this.vname3 = vname3 == null ? null : vname3.trim();
    }

    /**
     * @return VNAME4
     */
    public String getVname4() {
        return vname4;
    }

    /**
     * @param vname4
     */
    public void setVname4(String vname4) {
        this.vname4 = vname4 == null ? null : vname4.trim();
    }

    /**
     * @return VNAME5
     */
    public String getVname5() {
        return vname5;
    }

    /**
     * @param vname5
     */
    public void setVname5(String vname5) {
        this.vname5 = vname5 == null ? null : vname5.trim();
    }

    /**
     * @return VNAME6
     */
    public String getVname6() {
        return vname6;
    }

    /**
     * @param vname6
     */
    public void setVname6(String vname6) {
        this.vname6 = vname6 == null ? null : vname6.trim();
    }

    /**
     * @return VNOTE
     */
    public String getVnote() {
        return vnote;
    }

    /**
     * @param vnote
     */
    public void setVnote(String vnote) {
        this.vnote = vnote == null ? null : vnote.trim();
    }

    @Override
    public void setId(String s) {
        this.pkPortdoc = s;
    }

    @Override
    public String getId() {
        return this.pkPortdoc;
    }
}