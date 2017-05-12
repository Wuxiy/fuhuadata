package com.fuhuadata.domain.mybatis;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "t_currency_rate")
public class CurrencyRate extends BaseEntity<Integer> {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * nc币种主键
     */
    @Column(name = "pk_currtype")
    private String pkCurrtype;

    /**
     * 币种名称
     */
    @Column(name = "curr_name")
    private String currName;

    /**
     * 币种code
     */
    @Column(name = "curr_code")
    private String currCode;

    /**
     * 转换币种的主键
     */
    @Column(name = "to_pk")
    private String toPk;

    /**
     * 转换币种的名称
     */
    @Column(name = "to_name")
    private String toName;

    /**
     * 转换币种code
     */
    @Column(name = "to_code")
    private String toCode;

    /**
     * 汇率
     */
    private BigDecimal rate;

    /**
     * 当天汇率日期
     */
    @Column(name = "real_time")
    private Date realTime;

    /**
     * 汇率上次修改日期，生成时默认是上一天汇率的 show_time，更新后更新为当天的时间
     */
    @Column(name = "show_time")
    private Date showTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取创建时间
     *
     * @return gmt_create - 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置创建时间
     *
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取更新时间
     *
     * @return gmt_modified - 更新时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置更新时间
     *
     * @param gmtModified 更新时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取nc币种主键
     *
     * @return pk_currtype - nc币种主键
     */
    public String getPkCurrtype() {
        return pkCurrtype;
    }

    /**
     * 设置nc币种主键
     *
     * @param pkCurrtype nc币种主键
     */
    public void setPkCurrtype(String pkCurrtype) {
        this.pkCurrtype = pkCurrtype == null ? null : pkCurrtype.trim();
    }

    /**
     * 获取币种名称
     *
     * @return curr_name - 币种名称
     */
    public String getCurrName() {
        return currName;
    }

    /**
     * 设置币种名称
     *
     * @param currName 币种名称
     */
    public void setCurrName(String currName) {
        this.currName = currName == null ? null : currName.trim();
    }

    /**
     * 获取币种code
     *
     * @return curr_code - 币种code
     */
    public String getCurrCode() {
        return currCode;
    }

    /**
     * 设置币种code
     *
     * @param currCode 币种code
     */
    public void setCurrCode(String currCode) {
        this.currCode = currCode == null ? null : currCode.trim();
    }

    /**
     * 获取转换币种的主键
     *
     * @return to_pk - 转换币种的主键
     */
    public String getToPk() {
        return toPk;
    }

    /**
     * 设置转换币种的主键
     *
     * @param toPk 转换币种的主键
     */
    public void setToPk(String toPk) {
        this.toPk = toPk == null ? null : toPk.trim();
    }

    /**
     * 获取转换币种的名称
     *
     * @return to_name - 转换币种的名称
     */
    public String getToName() {
        return toName;
    }

    /**
     * 设置转换币种的名称
     *
     * @param toName 转换币种的名称
     */
    public void setToName(String toName) {
        this.toName = toName == null ? null : toName.trim();
    }

    /**
     * 获取转换币种code
     *
     * @return to_code - 转换币种code
     */
    public String getToCode() {
        return toCode;
    }

    /**
     * 设置转换币种code
     *
     * @param toCode 转换币种code
     */
    public void setToCode(String toCode) {
        this.toCode = toCode == null ? null : toCode.trim();
    }

    /**
     * 获取汇率
     *
     * @return rate - 汇率
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * 设置汇率
     *
     * @param rate 汇率
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * 获取汇率日期
     *
     * @return real_time - 汇率日期
     */
    public Date getRealTime() {
        return realTime;
    }

    /**
     * 设置汇率日期
     *
     * @param realTime 汇率日期
     */
    public void setRealTime(Date realTime) {
        this.realTime = realTime;
    }

    /**
     * 获取汇率上次修改日期
     *
     * @return show_time - 汇率上次修改日期
     */
    public Date getShowTime() {
        return showTime;
    }

    /**
     * 设置汇率上次修改日期
     *
     * @param showTime 汇率上次修改日期
     */
    public void setShowTime(Date showTime) {
        this.showTime = showTime;
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
}