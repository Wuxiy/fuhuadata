package com.fuhuadata.domain.mybatis;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_income")
public class Income extends BaseEntity<String> {
    /**
     * 主键
     */
    @Id
    @Column(name = "pk_income")
    private String pkIncome;

    /**
     * 协议名称
     */
    private String name;

    /**
     * 账期天数
     */
    private Integer paymentday;

    /**
     * 协议号 
     */
    private String code;

    /**
     * 协议生效日期
     */
    private Date effectdate;

    /**
     * 协议失效日期
     */
    private Date diseffectdate;

    /**
     * 备注
     */
    private String meno;

    /**
     * 获取主键
     *
     * @return pk_income - 主键
     */
    public String getPkIncome() {
        return pkIncome;
    }

    /**
     * 设置主键
     *
     * @param pkIncome 主键
     */
    public void setPkIncome(String pkIncome) {
        this.pkIncome = pkIncome == null ? null : pkIncome.trim();
    }

    /**
     * 获取协议名称
     *
     * @return name - 协议名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置协议名称
     *
     * @param name 协议名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取账期天数
     *
     * @return paymentday - 账期天数
     */
    public Integer getPaymentday() {
        return paymentday;
    }

    /**
     * 设置账期天数
     *
     * @param paymentday 账期天数
     */
    public void setPaymentday(Integer paymentday) {
        this.paymentday = paymentday;
    }

    /**
     * 获取协议号 
     *
     * @return code - 协议号 
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置协议号 
     *
     * @param code 协议号 
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取协议生效日期
     *
     * @return effectdate - 协议生效日期
     */
    public Date getEffectdate() {
        return effectdate;
    }

    /**
     * 设置协议生效日期
     *
     * @param effectdate 协议生效日期
     */
    public void setEffectdate(Date effectdate) {
        this.effectdate = effectdate;
    }

    /**
     * 获取协议失效日期
     *
     * @return diseffectdate - 协议失效日期
     */
    public Date getDiseffectdate() {
        return diseffectdate;
    }

    /**
     * 设置协议失效日期
     *
     * @param diseffectdate 协议失效日期
     */
    public void setDiseffectdate(Date diseffectdate) {
        this.diseffectdate = diseffectdate;
    }

    /**
     * 获取备注
     *
     * @return meno - 备注
     */
    public String getMeno() {
        return meno;
    }

    /**
     * 设置备注
     *
     * @param meno 备注
     */
    public void setMeno(String meno) {
        this.meno = meno == null ? null : meno.trim();
    }

    @Override
    public void setId(String s) {
        this.pkIncome = s;
    }

    @Override
    public String getId() {
        return pkIncome;
    }
}