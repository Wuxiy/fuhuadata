package com.fuhuadata.domain.oracle;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "ET_RECEIPT")
public class ReCeipt extends BaseEntity<String> {
    @Id
    @Column(name = "PK_RECEIPT")
    private String pkReceipt;

    @Column(name = "APPROVER")
    private String approver;

    @Column(name = "BCLAIMEND")
    private String bclaimend;

    @Column(name = "BHASRECBILL")
    private String bhasrecbill;

    @Column(name = "BILLMAKER")
    private String billmaker;

    @Column(name = "CCTID")
    private String cctid;

    @Column(name = "CCURRENCYID")
    private String ccurrencyid;

    @Column(name = "CCUSTBANKACCID")
    private String ccustbankaccid;

    @Column(name = "CCUSTBANKACCODE")
    private String ccustbankaccode;

    @Column(name = "CCUSTBANKID")
    private String ccustbankid;

    @Column(name = "CCUSTOMERID")
    private String ccustomerid;

    @Column(name = "CLCID")
    private String clcid;

    @Column(name = "CORIGCURRENCYID")
    private String corigcurrencyid;

    @Column(name = "CREATIONTIME")
    private String creationtime;

    @Column(name = "CREATOR")
    private String creator;

    @Column(name = "CTRANTYPEID")
    private String ctrantypeid;

    @Column(name = "CUSDCURRENCYID")
    private String cusdcurrencyid;

    @Column(name = "DBILLDATE")
    private String dbilldate;

    @Column(name = "DMAKEDATE")
    private String dmakedate;

    @Column(name = "DR")
    private Long dr;

    @Column(name = "FBUSITYPE")
    private BigDecimal fbusitype;

    @Column(name = "FPFSTATUSFLAG")
    private BigDecimal fpfstatusflag;

    @Column(name = "FSTATUSFLAG")
    private BigDecimal fstatusflag;

    @Column(name = "MODIFIEDTIME")
    private String modifiedtime;

    @Column(name = "MODIFIER")
    private String modifier;

    @Column(name = "NEXCHANGERATE")
    private BigDecimal nexchangerate;

    @Column(name = "NFRGNMNY")
    private BigDecimal nfrgnmny;

    @Column(name = "NFRGNORIGMNY")
    private BigDecimal nfrgnorigmny;

    @Column(name = "NHOMEMNY")
    private BigDecimal nhomemny;

    @Column(name = "NRECEIPTMNY")
    private BigDecimal nreceiptmny;

    @Column(name = "NRECEIPTORIGMNY")
    private BigDecimal nreceiptorigmny;

    @Column(name = "NRECEIPTUSDMNY")
    private BigDecimal nreceiptusdmny;

    @Column(name = "NTOTALMNY")
    private BigDecimal ntotalmny;

    @Column(name = "NTOTALORIGMNY")
    private BigDecimal ntotalorigmny;

    @Column(name = "NTOTALUSDMNY")
    private BigDecimal ntotalusdmny;

    @Column(name = "NUSDEXCHGRATE")
    private BigDecimal nusdexchgrate;

    @Column(name = "PK_GROUP")
    private String pkGroup;

    @Column(name = "PK_ORG")
    private String pkOrg;

    @Column(name = "PK_ORG_V")
    private String pkOrgV;

    @Column(name = "TAUDITTIME")
    private String taudittime;

    @Column(name = "TS")
    private String ts;

    @Column(name = "VBILLCODE")
    private String vbillcode;

    @Column(name = "VCTCODE")
    private String vctcode;

    @Column(name = "VCTTYPE")
    private String vcttype;

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

    @Column(name = "VDTTYPE")
    private String vdttype;

    @Column(name = "VLCCODE")
    private String vlccode;

    @Column(name = "VTRANTYPECODE")
    private String vtrantypecode;

    /**
     * @return PK_RECEIPT
     */
    public String getPkReceipt() {
        return pkReceipt;
    }

    /**
     * @param pkReceipt
     */
    public void setPkReceipt(String pkReceipt) {
        this.pkReceipt = pkReceipt == null ? null : pkReceipt.trim();
    }

    /**
     * @return APPROVER
     */
    public String getApprover() {
        return approver;
    }

    /**
     * @param approver
     */
    public void setApprover(String approver) {
        this.approver = approver == null ? null : approver.trim();
    }

    /**
     * @return BCLAIMEND
     */
    public String getBclaimend() {
        return bclaimend;
    }

    /**
     * @param bclaimend
     */
    public void setBclaimend(String bclaimend) {
        this.bclaimend = bclaimend == null ? null : bclaimend.trim();
    }

    /**
     * @return BHASRECBILL
     */
    public String getBhasrecbill() {
        return bhasrecbill;
    }

    /**
     * @param bhasrecbill
     */
    public void setBhasrecbill(String bhasrecbill) {
        this.bhasrecbill = bhasrecbill == null ? null : bhasrecbill.trim();
    }

    /**
     * @return BILLMAKER
     */
    public String getBillmaker() {
        return billmaker;
    }

    /**
     * @param billmaker
     */
    public void setBillmaker(String billmaker) {
        this.billmaker = billmaker == null ? null : billmaker.trim();
    }

    /**
     * @return CCTID
     */
    public String getCctid() {
        return cctid;
    }

    /**
     * @param cctid
     */
    public void setCctid(String cctid) {
        this.cctid = cctid == null ? null : cctid.trim();
    }

    /**
     * @return CCURRENCYID
     */
    public String getCcurrencyid() {
        return ccurrencyid;
    }

    /**
     * @param ccurrencyid
     */
    public void setCcurrencyid(String ccurrencyid) {
        this.ccurrencyid = ccurrencyid == null ? null : ccurrencyid.trim();
    }

    /**
     * @return CCUSTBANKACCID
     */
    public String getCcustbankaccid() {
        return ccustbankaccid;
    }

    /**
     * @param ccustbankaccid
     */
    public void setCcustbankaccid(String ccustbankaccid) {
        this.ccustbankaccid = ccustbankaccid == null ? null : ccustbankaccid.trim();
    }

    /**
     * @return CCUSTBANKACCODE
     */
    public String getCcustbankaccode() {
        return ccustbankaccode;
    }

    /**
     * @param ccustbankaccode
     */
    public void setCcustbankaccode(String ccustbankaccode) {
        this.ccustbankaccode = ccustbankaccode == null ? null : ccustbankaccode.trim();
    }

    /**
     * @return CCUSTBANKID
     */
    public String getCcustbankid() {
        return ccustbankid;
    }

    /**
     * @param ccustbankid
     */
    public void setCcustbankid(String ccustbankid) {
        this.ccustbankid = ccustbankid == null ? null : ccustbankid.trim();
    }

    /**
     * @return CCUSTOMERID
     */
    public String getCcustomerid() {
        return ccustomerid;
    }

    /**
     * @param ccustomerid
     */
    public void setCcustomerid(String ccustomerid) {
        this.ccustomerid = ccustomerid == null ? null : ccustomerid.trim();
    }

    /**
     * @return CLCID
     */
    public String getClcid() {
        return clcid;
    }

    /**
     * @param clcid
     */
    public void setClcid(String clcid) {
        this.clcid = clcid == null ? null : clcid.trim();
    }

    /**
     * @return CORIGCURRENCYID
     */
    public String getCorigcurrencyid() {
        return corigcurrencyid;
    }

    /**
     * @param corigcurrencyid
     */
    public void setCorigcurrencyid(String corigcurrencyid) {
        this.corigcurrencyid = corigcurrencyid == null ? null : corigcurrencyid.trim();
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
     * @return CTRANTYPEID
     */
    public String getCtrantypeid() {
        return ctrantypeid;
    }

    /**
     * @param ctrantypeid
     */
    public void setCtrantypeid(String ctrantypeid) {
        this.ctrantypeid = ctrantypeid == null ? null : ctrantypeid.trim();
    }

    /**
     * @return CUSDCURRENCYID
     */
    public String getCusdcurrencyid() {
        return cusdcurrencyid;
    }

    /**
     * @param cusdcurrencyid
     */
    public void setCusdcurrencyid(String cusdcurrencyid) {
        this.cusdcurrencyid = cusdcurrencyid == null ? null : cusdcurrencyid.trim();
    }

    /**
     * @return DBILLDATE
     */
    public String getDbilldate() {
        return dbilldate;
    }

    /**
     * @param dbilldate
     */
    public void setDbilldate(String dbilldate) {
        this.dbilldate = dbilldate == null ? null : dbilldate.trim();
    }

    /**
     * @return DMAKEDATE
     */
    public String getDmakedate() {
        return dmakedate;
    }

    /**
     * @param dmakedate
     */
    public void setDmakedate(String dmakedate) {
        this.dmakedate = dmakedate == null ? null : dmakedate.trim();
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
     * @return FBUSITYPE
     */
    public BigDecimal getFbusitype() {
        return fbusitype;
    }

    /**
     * @param fbusitype
     */
    public void setFbusitype(BigDecimal fbusitype) {
        this.fbusitype = fbusitype;
    }

    /**
     * @return FPFSTATUSFLAG
     */
    public BigDecimal getFpfstatusflag() {
        return fpfstatusflag;
    }

    /**
     * @param fpfstatusflag
     */
    public void setFpfstatusflag(BigDecimal fpfstatusflag) {
        this.fpfstatusflag = fpfstatusflag;
    }

    /**
     * @return FSTATUSFLAG
     */
    public BigDecimal getFstatusflag() {
        return fstatusflag;
    }

    /**
     * @param fstatusflag
     */
    public void setFstatusflag(BigDecimal fstatusflag) {
        this.fstatusflag = fstatusflag;
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
     * @return NEXCHANGERATE
     */
    public BigDecimal getNexchangerate() {
        return nexchangerate;
    }

    /**
     * @param nexchangerate
     */
    public void setNexchangerate(BigDecimal nexchangerate) {
        this.nexchangerate = nexchangerate;
    }

    /**
     * @return NFRGNMNY
     */
    public BigDecimal getNfrgnmny() {
        return nfrgnmny;
    }

    /**
     * @param nfrgnmny
     */
    public void setNfrgnmny(BigDecimal nfrgnmny) {
        this.nfrgnmny = nfrgnmny;
    }

    /**
     * @return NFRGNORIGMNY
     */
    public BigDecimal getNfrgnorigmny() {
        return nfrgnorigmny;
    }

    /**
     * @param nfrgnorigmny
     */
    public void setNfrgnorigmny(BigDecimal nfrgnorigmny) {
        this.nfrgnorigmny = nfrgnorigmny;
    }

    /**
     * @return NHOMEMNY
     */
    public BigDecimal getNhomemny() {
        return nhomemny;
    }

    /**
     * @param nhomemny
     */
    public void setNhomemny(BigDecimal nhomemny) {
        this.nhomemny = nhomemny;
    }

    /**
     * @return NRECEIPTMNY
     */
    public BigDecimal getNreceiptmny() {
        return nreceiptmny;
    }

    /**
     * @param nreceiptmny
     */
    public void setNreceiptmny(BigDecimal nreceiptmny) {
        this.nreceiptmny = nreceiptmny;
    }

    /**
     * @return NRECEIPTORIGMNY
     */
    public BigDecimal getNreceiptorigmny() {
        return nreceiptorigmny;
    }

    /**
     * @param nreceiptorigmny
     */
    public void setNreceiptorigmny(BigDecimal nreceiptorigmny) {
        this.nreceiptorigmny = nreceiptorigmny;
    }

    /**
     * @return NRECEIPTUSDMNY
     */
    public BigDecimal getNreceiptusdmny() {
        return nreceiptusdmny;
    }

    /**
     * @param nreceiptusdmny
     */
    public void setNreceiptusdmny(BigDecimal nreceiptusdmny) {
        this.nreceiptusdmny = nreceiptusdmny;
    }

    /**
     * @return NTOTALMNY
     */
    public BigDecimal getNtotalmny() {
        return ntotalmny;
    }

    /**
     * @param ntotalmny
     */
    public void setNtotalmny(BigDecimal ntotalmny) {
        this.ntotalmny = ntotalmny;
    }

    /**
     * @return NTOTALORIGMNY
     */
    public BigDecimal getNtotalorigmny() {
        return ntotalorigmny;
    }

    /**
     * @param ntotalorigmny
     */
    public void setNtotalorigmny(BigDecimal ntotalorigmny) {
        this.ntotalorigmny = ntotalorigmny;
    }

    /**
     * @return NTOTALUSDMNY
     */
    public BigDecimal getNtotalusdmny() {
        return ntotalusdmny;
    }

    /**
     * @param ntotalusdmny
     */
    public void setNtotalusdmny(BigDecimal ntotalusdmny) {
        this.ntotalusdmny = ntotalusdmny;
    }

    /**
     * @return NUSDEXCHGRATE
     */
    public BigDecimal getNusdexchgrate() {
        return nusdexchgrate;
    }

    /**
     * @param nusdexchgrate
     */
    public void setNusdexchgrate(BigDecimal nusdexchgrate) {
        this.nusdexchgrate = nusdexchgrate;
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
     * @return PK_ORG_V
     */
    public String getPkOrgV() {
        return pkOrgV;
    }

    /**
     * @param pkOrgV
     */
    public void setPkOrgV(String pkOrgV) {
        this.pkOrgV = pkOrgV == null ? null : pkOrgV.trim();
    }

    /**
     * @return TAUDITTIME
     */
    public String getTaudittime() {
        return taudittime;
    }

    /**
     * @param taudittime
     */
    public void setTaudittime(String taudittime) {
        this.taudittime = taudittime == null ? null : taudittime.trim();
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
     * @return VBILLCODE
     */
    public String getVbillcode() {
        return vbillcode;
    }

    /**
     * @param vbillcode
     */
    public void setVbillcode(String vbillcode) {
        this.vbillcode = vbillcode == null ? null : vbillcode.trim();
    }

    /**
     * @return VCTCODE
     */
    public String getVctcode() {
        return vctcode;
    }

    /**
     * @param vctcode
     */
    public void setVctcode(String vctcode) {
        this.vctcode = vctcode == null ? null : vctcode.trim();
    }

    /**
     * @return VCTTYPE
     */
    public String getVcttype() {
        return vcttype;
    }

    /**
     * @param vcttype
     */
    public void setVcttype(String vcttype) {
        this.vcttype = vcttype == null ? null : vcttype.trim();
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
     * @return VDTTYPE
     */
    public String getVdttype() {
        return vdttype;
    }

    /**
     * @param vdttype
     */
    public void setVdttype(String vdttype) {
        this.vdttype = vdttype == null ? null : vdttype.trim();
    }

    /**
     * @return VLCCODE
     */
    public String getVlccode() {
        return vlccode;
    }

    /**
     * @param vlccode
     */
    public void setVlccode(String vlccode) {
        this.vlccode = vlccode == null ? null : vlccode.trim();
    }

    /**
     * @return VTRANTYPECODE
     */
    public String getVtrantypecode() {
        return vtrantypecode;
    }

    /**
     * @param vtrantypecode
     */
    public void setVtrantypecode(String vtrantypecode) {
        this.vtrantypecode = vtrantypecode == null ? null : vtrantypecode.trim();
    }

    @Override
    public void setId(String s) {
        this.pkReceipt=s;
    }

    @Override
    public String getId() {
        return this.pkReceipt;
    }
}