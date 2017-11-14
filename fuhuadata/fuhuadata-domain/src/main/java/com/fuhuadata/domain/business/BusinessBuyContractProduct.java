package com.fuhuadata.domain.business;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.*;
import java.beans.IntrospectionException;
import java.math.BigDecimal;

@Table(name = "business_buy_contract_product")
public class BusinessBuyContractProduct extends BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 关联采购合同pk
     */
    @Column(name = "pk_buy_contract")
    private String pkBuyContract;
    /**
     * 采购合同nc表体主键
     */
    @Column(name="pk_buy_contract_product")
    private String pkBuyContractProduct;
    /**
     * 物料编码
     */
    @Column(name = "pk_material")
    private String pkMaterial;

    /**
     * 物料编码名称
     */
    @Transient
    private String materialName;

    /**
     * 物料规格
     */
    @Transient
    private String specification;

    /**
     * 单位
     */
    private String cunit;

    /**
     * 主数量
     */
    private BigDecimal nnum;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 总价
     */
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    /**
     * 备注
     */
    private String remark;

    /**
     * 外销客户名称
     */
    @Column(name = "export_ct_client_name")
    private String exportCtClientName;

    /**
     * 外销合同号
     */
    @Column(name = "export_ct_code")
    private String exportCtCode;

    /**
     * 外销合同pk
     */
    @Column(name = "export_ct_pk")
    private String exportCtPk;

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
     * 获取关联采购合同pk
     *
     * @return pk_buy_contract - 关联采购合同pk
     */
    public String getPkBuyContract() {
        return pkBuyContract;
    }

    /**
     * 设置关联采购合同pk
     *
     * @param pkBuyContract 关联采购合同pk
     */
    public void setPkBuyContract(String pkBuyContract) {
        this.pkBuyContract = pkBuyContract == null ? null : pkBuyContract.trim();
    }
    public String getPkBuyContractProduct() {
        return pkBuyContractProduct;
    }

    public void setPkBuyContractProduct(String pkBuyContractProduct) {
        this.pkBuyContractProduct = pkBuyContractProduct;
    }
    /**
     * 获取物料编码
     *
     * @return pk_material - 物料编码
     */
    public String getPkMaterial() {
        return pkMaterial;
    }

    /**
     * 设置物料编码
     *
     * @param pkMaterial 物料编码
     */
    public void setPkMaterial(String pkMaterial) {
        this.pkMaterial = pkMaterial == null ? null : pkMaterial.trim();
    }

    /**
     * 获取单位
     *
     * @return cunit - 单位
     */
    public String getCunit() {
        return cunit;
    }

    /**
     * 设置单位
     *
     * @param cunit 单位
     */
    public void setCunit(String cunit) {
        this.cunit = cunit == null ? null : cunit.trim();
    }

    /**
     * 获取主数量
     *
     * @return nnum - 主数量
     */
    public BigDecimal getNnum() {
        return nnum;
    }

    /**
     * 设置主数量
     *
     * @param nnum 主数量
     */
    public void setNnum(BigDecimal nnum) {
        this.nnum = nnum;
    }

    /**
     * 获取单价
     *
     * @return price - 单价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置单价
     *
     * @param price 单价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取总价
     *
     * @return total_price - 总价
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置总价
     *
     * @param totalPrice 总价
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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

    /**
     * 获取外销客户名称
     *
     * @return export_ct_client_name - 外销客户名称
     */
    public String getExportCtClientName() {
        return exportCtClientName;
    }

    /**
     * 设置外销客户名称
     *
     * @param exportCtClientName 外销客户名称
     */
    public void setExportCtClientName(String exportCtClientName) {
        this.exportCtClientName = exportCtClientName == null ? null : exportCtClientName.trim();
    }

    /**
     * 获取外销合同号
     *
     * @return export_ct_code - 外销合同号
     */
    public String getExportCtCode() {
        return exportCtCode;
    }

    /**
     * 设置外销合同号
     *
     * @param exportCtCode 外销合同号
     */
    public void setExportCtCode(String exportCtCode) {
        this.exportCtCode = exportCtCode == null ? null : exportCtCode.trim();
    }

    /**
     * 获取外销合同pk
     *
     * @return export_ct_pk - 外销合同pk
     */
    public String getExportCtPk() {
        return exportCtPk;
    }

    /**
     * 设置外销合同pk
     *
     * @param exportCtPk 外销合同pk
     */
    public void setExportCtPk(String exportCtPk) {
        this.exportCtPk = exportCtPk == null ? null : exportCtPk.trim();
    }

    public static void main(String[] args) throws IntrospectionException {
        printProperties(BusinessBuyContractProduct.class, "bcp.");
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}