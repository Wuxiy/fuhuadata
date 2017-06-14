package com.fuhuadata.domain.business;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.*;
import java.beans.IntrospectionException;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "business_buy_contract")
public class BusinessBuyContract extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 采购合同nc主键
     */
    @Column(name = "pk_ct_pu")
    private String pkCtPu;

    /**
     * 合同名称
     */
    private String ctname;

    /**
     * 合同编码
     */
    private String vbillcode;

    /**
     * 总数量
     */
    @Column(name = "total_number")
    private BigDecimal totalNumber;

    /**
     * 价税合计
     */
    private BigDecimal ntotalorigmny;

    /**
     * 本位币
     */
    private String ccurrencyid;

    /**
     * 币种
     */
    private String corigcurrencyid;

    /**
     * 合同签订日期
     */
    private Date subscribedate;

    /**
     * 计划生效日期
     */
    private Date valdate;

    /**
     * 计划终止日期
     */
    private Date invallidate;

    /**
     * 实际生效日期
     */
    private Date actualvalidate;

    /**
     * 实际终止日期
     */
    private Date actualinvalidate;

    /**
     * 供应商ncid
     */
    private String cvendorid;

    /**
     * 备注
     */
    private String remark;

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
     * 获取采购合同nc主键
     *
     * @return pk_ct_pu - 采购合同nc主键
     */
    public String getPkCtPu() {
        return pkCtPu;
    }

    /**
     * 设置采购合同nc主键
     *
     * @param pkCtPu 采购合同nc主键
     */
    public void setPkCtPu(String pkCtPu) {
        this.pkCtPu = pkCtPu == null ? null : pkCtPu.trim();
    }

    /**
     * 获取合同名称
     *
     * @return ctname - 合同名称
     */
    public String getCtname() {
        return ctname;
    }

    /**
     * 设置合同名称
     *
     * @param ctname 合同名称
     */
    public void setCtname(String ctname) {
        this.ctname = ctname == null ? null : ctname.trim();
    }

    /**
     * 获取合同编码
     *
     * @return vbillcode - 合同编码
     */
    public String getVbillcode() {
        return vbillcode;
    }

    /**
     * 设置合同编码
     *
     * @param vbillcode 合同编码
     */
    public void setVbillcode(String vbillcode) {
        this.vbillcode = vbillcode == null ? null : vbillcode.trim();
    }

    /**
     * 获取总数量
     *
     * @return total_number - 总数量
     */
    public BigDecimal getTotalNumber() {
        return totalNumber;
    }

    /**
     * 设置总数量
     *
     * @param totalNumber 总数量
     */
    public void setTotalNumber(BigDecimal totalNumber) {
        this.totalNumber = totalNumber;
    }

    /**
     * 获取价税合计
     *
     * @return ntotalorigmny - 价税合计
     */
    public BigDecimal getNtotalorigmny() {
        return ntotalorigmny;
    }

    /**
     * 设置价税合计
     *
     * @param ntotalorigmny 价税合计
     */
    public void setNtotalorigmny(BigDecimal ntotalorigmny) {
        this.ntotalorigmny = ntotalorigmny;
    }

    /**
     * 获取本位币
     *
     * @return ccurrencyid - 本位币
     */
    public String getCcurrencyid() {
        return ccurrencyid;
    }

    /**
     * 设置本位币
     *
     * @param ccurrencyid 本位币
     */
    public void setCcurrencyid(String ccurrencyid) {
        this.ccurrencyid = ccurrencyid == null ? null : ccurrencyid.trim();
    }

    /**
     * 获取币种
     *
     * @return corigcurrencyid - 币种
     */
    public String getCorigcurrencyid() {
        return corigcurrencyid;
    }

    /**
     * 设置币种
     *
     * @param corigcurrencyid 币种
     */
    public void setCorigcurrencyid(String corigcurrencyid) {
        this.corigcurrencyid = corigcurrencyid == null ? null : corigcurrencyid.trim();
    }

    /**
     * 获取合同签订日期
     *
     * @return subscribedate - 合同签订日期
     */
    public Date getSubscribedate() {
        return subscribedate;
    }

    /**
     * 设置合同签订日期
     *
     * @param subscribedate 合同签订日期
     */
    public void setSubscribedate(Date subscribedate) {
        this.subscribedate = subscribedate;
    }

    /**
     * 获取计划生效日期
     *
     * @return valdate - 计划生效日期
     */
    public Date getValdate() {
        return valdate;
    }

    /**
     * 设置计划生效日期
     *
     * @param valdate 计划生效日期
     */
    public void setValdate(Date valdate) {
        this.valdate = valdate;
    }

    /**
     * 获取计划终止日期
     *
     * @return invallidate - 计划终止日期
     */
    public Date getInvallidate() {
        return invallidate;
    }

    /**
     * 设置计划终止日期
     *
     * @param invallidate 计划终止日期
     */
    public void setInvallidate(Date invallidate) {
        this.invallidate = invallidate;
    }

    /**
     * 获取实际生效日期
     *
     * @return actualvalidate - 实际生效日期
     */
    public Date getActualvalidate() {
        return actualvalidate;
    }

    /**
     * 设置实际生效日期
     *
     * @param actualvalidate 实际生效日期
     */
    public void setActualvalidate(Date actualvalidate) {
        this.actualvalidate = actualvalidate;
    }

    /**
     * 获取实际终止日期
     *
     * @return actualinvalidate - 实际终止日期
     */
    public Date getActualinvalidate() {
        return actualinvalidate;
    }

    /**
     * 设置实际终止日期
     *
     * @param actualinvalidate 实际终止日期
     */
    public void setActualinvalidate(Date actualinvalidate) {
        this.actualinvalidate = actualinvalidate;
    }

    /**
     * 获取供应商ncid
     *
     * @return cvendorid - 供应商ncid
     */
    public String getCvendorid() {
        return cvendorid;
    }

    /**
     * 设置供应商ncid
     *
     * @param cvendorid 供应商ncid
     */
    public void setCvendorid(String cvendorid) {
        this.cvendorid = cvendorid == null ? null : cvendorid.trim();
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public static void main(String[] args) throws IntrospectionException {

        printProperties(BusinessBuyContract.class, "bbc.");
    }
}