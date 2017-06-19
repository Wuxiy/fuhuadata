package com.fuhuadata.domain.business;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.*;
import java.beans.IntrospectionException;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "bussiness_orgi_contract")
public class BusinessOrgiContract extends BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 原药合同主键
     */
    @Column(name = "pk_ct_sale")
    private String pkCtSale;

    /**
     * 合同编号
     */
    @Column(name = "contract_code")
    private String contractCode;

    /**
     * 主数量
     */
    @Column(name = "main_num")
    private BigDecimal mainNum;

    /**
     * 原药单价
     */
    private BigDecimal price;

    /**
     * 原药总价
     */
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    /**
     * 实际终止日期
     */
    private Date actualvalidate;

    /**
     * 实际生效日期
     */
    private Date actualinvalidate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 供应商id
     */
    private String cvendorid;

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
     * 获取原药合同主键
     *
     * @return pk_ct_sale - 原药合同主键
     */
    public String getPkCtSale() {
        return pkCtSale;
    }

    /**
     * 设置原药合同主键
     *
     * @param pkCtSale 原药合同主键
     */
    public void setPkCtSale(String pkCtSale) {
        this.pkCtSale = pkCtSale == null ? null : pkCtSale.trim();
    }

    /**
     * 获取合同编号
     *
     * @return contract_code - 合同编号
     */
    public String getContractCode() {
        return contractCode;
    }

    /**
     * 设置合同编号
     *
     * @param contractCode 合同编号
     */
    public void setContractCode(String contractCode) {
        this.contractCode = contractCode == null ? null : contractCode.trim();
    }

    /**
     * 获取主数量
     *
     * @return main_num - 主数量
     */
    public BigDecimal getMainNum() {
        return mainNum;
    }

    /**
     * 设置主数量
     *
     * @param mainNum 主数量
     */
    public void setMainNum(BigDecimal mainNum) {
        this.mainNum = mainNum;
    }

    /**
     * 获取原药单价
     *
     * @return price - 原药单价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置原药单价
     *
     * @param price 原药单价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取原药总价
     *
     * @return total_price - 原药总价
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置原药总价
     *
     * @param totalPrice 原药总价
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取实际终止日期
     *
     * @return actualvalidate - 实际终止日期
     */
    public Date getActualvalidate() {
        return actualvalidate;
    }

    /**
     * 设置实际终止日期
     *
     * @param actualvalidate 实际终止日期
     */
    public void setActualvalidate(Date actualvalidate) {
        this.actualvalidate = actualvalidate;
    }

    /**
     * 获取实际生效日期
     *
     * @return actualinvalidate - 实际生效日期
     */
    public Date getActualinvalidate() {
        return actualinvalidate;
    }

    /**
     * 设置实际生效日期
     *
     * @param actualinvalidate 实际生效日期
     */
    public void setActualinvalidate(Date actualinvalidate) {
        this.actualinvalidate = actualinvalidate;
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
        printProperties(BusinessOrgiContract.class, "boc.");
    }

    public String getCvendorid() {
        return cvendorid;
    }

    public void setCvendorid(String cvendorid) {
        this.cvendorid = cvendorid;
    }
}