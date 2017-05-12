package com.fuhuadata.domain.oracle;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "ET_RECEIPT_B")
public class ReCeipt extends BaseEntity<String> {
    @Id
    @Column(name = "PK_RECEIPT_B")
    private String pkReceiptB;

    @Column(name = "BCOLLECT")
    private String bcollect;

    @Column(name = "CBCTID")
    private String cbctid;

    @Column(name = "CCTCURRENCYID")
    private String cctcurrencyid;

    @Column(name = "CDEPTID")
    private String cdeptid;

    @Column(name = "CDEPTVID")
    private String cdeptvid;

    @Column(name = "CDTID")
    private String cdtid;

    @Column(name = "CEMPLOYEEID")
    private String cemployeeid;

    @Column(name = "CMATERIALID")
    private String cmaterialid;

    @Column(name = "CMATERIALVID")
    private String cmaterialvid;

    @Column(name = "CPAYPLANID")
    private String cpayplanid;

    @Column(name = "CROWNO")
    private String crowno;

    @Column(name = "CSALEORGID")
    private String csaleorgid;

    @Column(name = "CSALEORGVID")
    private String csaleorgvid;

    @Column(name = "DBILLDATE")
    private String dbilldate;

    @Column(name = "DR")
    private Long dr;

    @Column(name = "FCLAIMSTATUS")
    private BigDecimal fclaimstatus;

    @Column(name = "FRECEIPTTYPE")
    private BigDecimal freceipttype;

    @Column(name = "NARORIGMNY")
    private BigDecimal narorigmny;

    @Column(name = "NCLAIMCTMNY")
    private BigDecimal nclaimctmny;

    @Column(name = "NCLAIMMNY")
    private BigDecimal nclaimmny;

    @Column(name = "NCLAIMORIGMNY")
    private BigDecimal nclaimorigmny;

    @Column(name = "NCLAIMUSDMNY")
    private BigDecimal nclaimusdmny;

    @Column(name = "NCTEXCHANGERATE")
    private BigDecimal nctexchangerate;

    @Column(name = "PK_GROUP")
    private String pkGroup;

    @Column(name = "PK_ORG")
    private String pkOrg;

    @Column(name = "PK_RECEIPT")
    private String pkReceipt;

    @Column(name = "TS")
    private String ts;

    @Column(name = "VBCTCODE")
    private String vbctcode;

    @Column(name = "VBDEF1")
    private String vbdef1;

    @Column(name = "VBDEF10")
    private String vbdef10;

    @Column(name = "VBDEF11")
    private String vbdef11;

    @Column(name = "VBDEF12")
    private String vbdef12;

    @Column(name = "VBDEF13")
    private String vbdef13;

    @Column(name = "VBDEF14")
    private String vbdef14;

    @Column(name = "VBDEF15")
    private String vbdef15;

    @Column(name = "VBDEF16")
    private String vbdef16;

    @Column(name = "VBDEF17")
    private String vbdef17;

    @Column(name = "VBDEF18")
    private String vbdef18;

    @Column(name = "VBDEF19")
    private String vbdef19;

    @Column(name = "VBDEF2")
    private String vbdef2;

    @Column(name = "VBDEF20")
    private String vbdef20;

    @Column(name = "VBDEF3")
    private String vbdef3;

    @Column(name = "VBDEF4")
    private String vbdef4;

    @Column(name = "VBDEF5")
    private String vbdef5;

    @Column(name = "VBDEF6")
    private String vbdef6;

    @Column(name = "VBDEF7")
    private String vbdef7;

    @Column(name = "VBDEF8")
    private String vbdef8;

    @Column(name = "VBDEF9")
    private String vbdef9;

    @Column(name = "VDTCODE")
    private String vdtcode;

    @Column(name = "VPAYPLANROWNO")
    private String vpayplanrowno;

    /**
     * @return PK_RECEIPT_B
     */
    public String getPkReceiptB() {
        return pkReceiptB;
    }

    /**
     * @param pkReceiptB
     */
    public void setPkReceiptB(String pkReceiptB) {
        this.pkReceiptB = pkReceiptB == null ? null : pkReceiptB.trim();
    }

    /**
     * @return BCOLLECT
     */
    public String getBcollect() {
        return bcollect;
    }

    /**
     * @param bcollect
     */
    public void setBcollect(String bcollect) {
        this.bcollect = bcollect == null ? null : bcollect.trim();
    }

    /**
     * @return CBCTID
     */
    public String getCbctid() {
        return cbctid;
    }

    /**
     * @param cbctid
     */
    public void setCbctid(String cbctid) {
        this.cbctid = cbctid == null ? null : cbctid.trim();
    }

    /**
     * @return CCTCURRENCYID
     */
    public String getCctcurrencyid() {
        return cctcurrencyid;
    }

    /**
     * @param cctcurrencyid
     */
    public void setCctcurrencyid(String cctcurrencyid) {
        this.cctcurrencyid = cctcurrencyid == null ? null : cctcurrencyid.trim();
    }

    /**
     * @return CDEPTID
     */
    public String getCdeptid() {
        return cdeptid;
    }

    /**
     * @param cdeptid
     */
    public void setCdeptid(String cdeptid) {
        this.cdeptid = cdeptid == null ? null : cdeptid.trim();
    }

    /**
     * @return CDEPTVID
     */
    public String getCdeptvid() {
        return cdeptvid;
    }

    /**
     * @param cdeptvid
     */
    public void setCdeptvid(String cdeptvid) {
        this.cdeptvid = cdeptvid == null ? null : cdeptvid.trim();
    }

    /**
     * @return CDTID
     */
    public String getCdtid() {
        return cdtid;
    }

    /**
     * @param cdtid
     */
    public void setCdtid(String cdtid) {
        this.cdtid = cdtid == null ? null : cdtid.trim();
    }

    /**
     * @return CEMPLOYEEID
     */
    public String getCemployeeid() {
        return cemployeeid;
    }

    /**
     * @param cemployeeid
     */
    public void setCemployeeid(String cemployeeid) {
        this.cemployeeid = cemployeeid == null ? null : cemployeeid.trim();
    }

    /**
     * @return CMATERIALID
     */
    public String getCmaterialid() {
        return cmaterialid;
    }

    /**
     * @param cmaterialid
     */
    public void setCmaterialid(String cmaterialid) {
        this.cmaterialid = cmaterialid == null ? null : cmaterialid.trim();
    }

    /**
     * @return CMATERIALVID
     */
    public String getCmaterialvid() {
        return cmaterialvid;
    }

    /**
     * @param cmaterialvid
     */
    public void setCmaterialvid(String cmaterialvid) {
        this.cmaterialvid = cmaterialvid == null ? null : cmaterialvid.trim();
    }

    /**
     * @return CPAYPLANID
     */
    public String getCpayplanid() {
        return cpayplanid;
    }

    /**
     * @param cpayplanid
     */
    public void setCpayplanid(String cpayplanid) {
        this.cpayplanid = cpayplanid == null ? null : cpayplanid.trim();
    }

    /**
     * @return CROWNO
     */
    public String getCrowno() {
        return crowno;
    }

    /**
     * @param crowno
     */
    public void setCrowno(String crowno) {
        this.crowno = crowno == null ? null : crowno.trim();
    }

    /**
     * @return CSALEORGID
     */
    public String getCsaleorgid() {
        return csaleorgid;
    }

    /**
     * @param csaleorgid
     */
    public void setCsaleorgid(String csaleorgid) {
        this.csaleorgid = csaleorgid == null ? null : csaleorgid.trim();
    }

    /**
     * @return CSALEORGVID
     */
    public String getCsaleorgvid() {
        return csaleorgvid;
    }

    /**
     * @param csaleorgvid
     */
    public void setCsaleorgvid(String csaleorgvid) {
        this.csaleorgvid = csaleorgvid == null ? null : csaleorgvid.trim();
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
     * @return FCLAIMSTATUS
     */
    public BigDecimal getFclaimstatus() {
        return fclaimstatus;
    }

    /**
     * @param fclaimstatus
     */
    public void setFclaimstatus(BigDecimal fclaimstatus) {
        this.fclaimstatus = fclaimstatus;
    }

    /**
     * @return FRECEIPTTYPE
     */
    public BigDecimal getFreceipttype() {
        return freceipttype;
    }

    /**
     * @param freceipttype
     */
    public void setFreceipttype(BigDecimal freceipttype) {
        this.freceipttype = freceipttype;
    }

    /**
     * @return NARORIGMNY
     */
    public BigDecimal getNarorigmny() {
        return narorigmny;
    }

    /**
     * @param narorigmny
     */
    public void setNarorigmny(BigDecimal narorigmny) {
        this.narorigmny = narorigmny;
    }

    /**
     * @return NCLAIMCTMNY
     */
    public BigDecimal getNclaimctmny() {
        return nclaimctmny;
    }

    /**
     * @param nclaimctmny
     */
    public void setNclaimctmny(BigDecimal nclaimctmny) {
        this.nclaimctmny = nclaimctmny;
    }

    /**
     * @return NCLAIMMNY
     */
    public BigDecimal getNclaimmny() {
        return nclaimmny;
    }

    /**
     * @param nclaimmny
     */
    public void setNclaimmny(BigDecimal nclaimmny) {
        this.nclaimmny = nclaimmny;
    }

    /**
     * @return NCLAIMORIGMNY
     */
    public BigDecimal getNclaimorigmny() {
        return nclaimorigmny;
    }

    /**
     * @param nclaimorigmny
     */
    public void setNclaimorigmny(BigDecimal nclaimorigmny) {
        this.nclaimorigmny = nclaimorigmny;
    }

    /**
     * @return NCLAIMUSDMNY
     */
    public BigDecimal getNclaimusdmny() {
        return nclaimusdmny;
    }

    /**
     * @param nclaimusdmny
     */
    public void setNclaimusdmny(BigDecimal nclaimusdmny) {
        this.nclaimusdmny = nclaimusdmny;
    }

    /**
     * @return NCTEXCHANGERATE
     */
    public BigDecimal getNctexchangerate() {
        return nctexchangerate;
    }

    /**
     * @param nctexchangerate
     */
    public void setNctexchangerate(BigDecimal nctexchangerate) {
        this.nctexchangerate = nctexchangerate;
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
     * @return VBCTCODE
     */
    public String getVbctcode() {
        return vbctcode;
    }

    /**
     * @param vbctcode
     */
    public void setVbctcode(String vbctcode) {
        this.vbctcode = vbctcode == null ? null : vbctcode.trim();
    }

    /**
     * @return VBDEF1
     */
    public String getVbdef1() {
        return vbdef1;
    }

    /**
     * @param vbdef1
     */
    public void setVbdef1(String vbdef1) {
        this.vbdef1 = vbdef1 == null ? null : vbdef1.trim();
    }

    /**
     * @return VBDEF10
     */
    public String getVbdef10() {
        return vbdef10;
    }

    /**
     * @param vbdef10
     */
    public void setVbdef10(String vbdef10) {
        this.vbdef10 = vbdef10 == null ? null : vbdef10.trim();
    }

    /**
     * @return VBDEF11
     */
    public String getVbdef11() {
        return vbdef11;
    }

    /**
     * @param vbdef11
     */
    public void setVbdef11(String vbdef11) {
        this.vbdef11 = vbdef11 == null ? null : vbdef11.trim();
    }

    /**
     * @return VBDEF12
     */
    public String getVbdef12() {
        return vbdef12;
    }

    /**
     * @param vbdef12
     */
    public void setVbdef12(String vbdef12) {
        this.vbdef12 = vbdef12 == null ? null : vbdef12.trim();
    }

    /**
     * @return VBDEF13
     */
    public String getVbdef13() {
        return vbdef13;
    }

    /**
     * @param vbdef13
     */
    public void setVbdef13(String vbdef13) {
        this.vbdef13 = vbdef13 == null ? null : vbdef13.trim();
    }

    /**
     * @return VBDEF14
     */
    public String getVbdef14() {
        return vbdef14;
    }

    /**
     * @param vbdef14
     */
    public void setVbdef14(String vbdef14) {
        this.vbdef14 = vbdef14 == null ? null : vbdef14.trim();
    }

    /**
     * @return VBDEF15
     */
    public String getVbdef15() {
        return vbdef15;
    }

    /**
     * @param vbdef15
     */
    public void setVbdef15(String vbdef15) {
        this.vbdef15 = vbdef15 == null ? null : vbdef15.trim();
    }

    /**
     * @return VBDEF16
     */
    public String getVbdef16() {
        return vbdef16;
    }

    /**
     * @param vbdef16
     */
    public void setVbdef16(String vbdef16) {
        this.vbdef16 = vbdef16 == null ? null : vbdef16.trim();
    }

    /**
     * @return VBDEF17
     */
    public String getVbdef17() {
        return vbdef17;
    }

    /**
     * @param vbdef17
     */
    public void setVbdef17(String vbdef17) {
        this.vbdef17 = vbdef17 == null ? null : vbdef17.trim();
    }

    /**
     * @return VBDEF18
     */
    public String getVbdef18() {
        return vbdef18;
    }

    /**
     * @param vbdef18
     */
    public void setVbdef18(String vbdef18) {
        this.vbdef18 = vbdef18 == null ? null : vbdef18.trim();
    }

    /**
     * @return VBDEF19
     */
    public String getVbdef19() {
        return vbdef19;
    }

    /**
     * @param vbdef19
     */
    public void setVbdef19(String vbdef19) {
        this.vbdef19 = vbdef19 == null ? null : vbdef19.trim();
    }

    /**
     * @return VBDEF2
     */
    public String getVbdef2() {
        return vbdef2;
    }

    /**
     * @param vbdef2
     */
    public void setVbdef2(String vbdef2) {
        this.vbdef2 = vbdef2 == null ? null : vbdef2.trim();
    }

    /**
     * @return VBDEF20
     */
    public String getVbdef20() {
        return vbdef20;
    }

    /**
     * @param vbdef20
     */
    public void setVbdef20(String vbdef20) {
        this.vbdef20 = vbdef20 == null ? null : vbdef20.trim();
    }

    /**
     * @return VBDEF3
     */
    public String getVbdef3() {
        return vbdef3;
    }

    /**
     * @param vbdef3
     */
    public void setVbdef3(String vbdef3) {
        this.vbdef3 = vbdef3 == null ? null : vbdef3.trim();
    }

    /**
     * @return VBDEF4
     */
    public String getVbdef4() {
        return vbdef4;
    }

    /**
     * @param vbdef4
     */
    public void setVbdef4(String vbdef4) {
        this.vbdef4 = vbdef4 == null ? null : vbdef4.trim();
    }

    /**
     * @return VBDEF5
     */
    public String getVbdef5() {
        return vbdef5;
    }

    /**
     * @param vbdef5
     */
    public void setVbdef5(String vbdef5) {
        this.vbdef5 = vbdef5 == null ? null : vbdef5.trim();
    }

    /**
     * @return VBDEF6
     */
    public String getVbdef6() {
        return vbdef6;
    }

    /**
     * @param vbdef6
     */
    public void setVbdef6(String vbdef6) {
        this.vbdef6 = vbdef6 == null ? null : vbdef6.trim();
    }

    /**
     * @return VBDEF7
     */
    public String getVbdef7() {
        return vbdef7;
    }

    /**
     * @param vbdef7
     */
    public void setVbdef7(String vbdef7) {
        this.vbdef7 = vbdef7 == null ? null : vbdef7.trim();
    }

    /**
     * @return VBDEF8
     */
    public String getVbdef8() {
        return vbdef8;
    }

    /**
     * @param vbdef8
     */
    public void setVbdef8(String vbdef8) {
        this.vbdef8 = vbdef8 == null ? null : vbdef8.trim();
    }

    /**
     * @return VBDEF9
     */
    public String getVbdef9() {
        return vbdef9;
    }

    /**
     * @param vbdef9
     */
    public void setVbdef9(String vbdef9) {
        this.vbdef9 = vbdef9 == null ? null : vbdef9.trim();
    }

    /**
     * @return VDTCODE
     */
    public String getVdtcode() {
        return vdtcode;
    }

    /**
     * @param vdtcode
     */
    public void setVdtcode(String vdtcode) {
        this.vdtcode = vdtcode == null ? null : vdtcode.trim();
    }

    /**
     * @return VPAYPLANROWNO
     */
    public String getVpayplanrowno() {
        return vpayplanrowno;
    }

    /**
     * @param vpayplanrowno
     */
    public void setVpayplanrowno(String vpayplanrowno) {
        this.vpayplanrowno = vpayplanrowno == null ? null : vpayplanrowno.trim();
    }

    @Override
    public void setId(String s) {
        this.pkReceiptB = s;
    }

    @Override
    public String getId() {
        return this.pkReceiptB;
    }
}