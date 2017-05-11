package com.fuhuadata.domain.mybatis;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "t_receipt")
public class Receipt extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * NC_id
     */
    @Column(name = "pk_receipt_b")
    private String pkReceiptB;

    /**
     * 合同id
     */
    private String cbctid;

    /**
     * 合同币种
     */
    private String cctcurrencyid;

    /**
     * 认领状态：1=自由，2=确认，3=完成，
     */
    private Byte fclaimstatus;

    /**
     * 收汇水单类型 1=货款，2=国外扣费
     */
    private Byte freceipttype;

    /**
     * 认领本币金额
     */
    private BigDecimal nclaimmny;

    /**
     * 更新时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取NC_id
     *
     * @return pk_receipt_b - NC_id
     */
    public String getPkReceiptB() {
        return pkReceiptB;
    }

    /**
     * 设置NC_id
     *
     * @param pkReceiptB NC_id
     */
    public void setPkReceiptB(String pkReceiptB) {
        this.pkReceiptB = pkReceiptB == null ? null : pkReceiptB.trim();
    }

    /**
     * 获取合同id
     *
     * @return cbctid - 合同id
     */
    public String getCbctid() {
        return cbctid;
    }

    /**
     * 设置合同id
     *
     * @param cbctid 合同id
     */
    public void setCbctid(String cbctid) {
        this.cbctid = cbctid == null ? null : cbctid.trim();
    }

    /**
     * 获取合同币种
     *
     * @return cctcurrencyid - 合同币种
     */
    public String getCctcurrencyid() {
        return cctcurrencyid;
    }

    /**
     * 设置合同币种
     *
     * @param cctcurrencyid 合同币种
     */
    public void setCctcurrencyid(String cctcurrencyid) {
        this.cctcurrencyid = cctcurrencyid == null ? null : cctcurrencyid.trim();
    }

    /**
     * 获取认领状态：1=自由，2=确认，3=完成，
     *
     * @return fclaimstatus - 认领状态：1=自由，2=确认，3=完成，
     */
    public Byte getFclaimstatus() {
        return fclaimstatus;
    }

    /**
     * 设置认领状态：1=自由，2=确认，3=完成，
     *
     * @param fclaimstatus 认领状态：1=自由，2=确认，3=完成，
     */
    public void setFclaimstatus(Byte fclaimstatus) {
        this.fclaimstatus = fclaimstatus;
    }

    /**
     * 获取收汇水单类型 1=货款，2=国外扣费
     *
     * @return freceipttype - 收汇水单类型 1=货款，2=国外扣费
     */
    public Byte getFreceipttype() {
        return freceipttype;
    }

    /**
     * 设置收汇水单类型 1=货款，2=国外扣费
     *
     * @param freceipttype 收汇水单类型 1=货款，2=国外扣费
     */
    public void setFreceipttype(Byte freceipttype) {
        this.freceipttype = freceipttype;
    }

    /**
     * 获取认领本币金额
     *
     * @return nclaimmny - 认领本币金额
     */
    public BigDecimal getNclaimmny() {
        return nclaimmny;
    }

    /**
     * 设置认领本币金额
     *
     * @param nclaimmny 认领本币金额
     */
    public void setNclaimmny(BigDecimal nclaimmny) {
        this.nclaimmny = nclaimmny;
    }

    /**
     * 获取更新时间
     *
     * @return modify_time - 更新时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置更新时间
     *
     * @param modifyTime 更新时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}