package com.fuhuadata.domain.mybatis;

import javax.persistence.*;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Table(name = "customer_purchase_product")
public class CustomerPurchaseProduct extends BaseEntity<Integer> {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 客户id
     */
    @Column(name = "customer_id")
    private Integer customerId;

    /**
     * 年
     */
    private String year;

    /**
     * 标准产品id（外键）
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 产品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 年需求量
     */
    @Column(name = "annual_demands")
    private String annualDemands;

    /**
     * 平均单价，美元计
     */
    @Column(name = "average_price")
    private String averagePrice;

    /**
     * 供应商1
     */
    private String supplier1;

    /**
     * 年采购量1
     */
    @Column(name = "purchase_amount1")
    private String purchaseAmount1;

    /**
     * 平均单价1
     */
    @Column(name = "average_price1")
    private String averagePrice1;

    /**
     * 供应商2
     */
    private String supplier2;

    /**
     * 年采购量2
     */
    @Column(name = "purchase_amount2")
    private String purchaseAmount2;

    /**
     * 平均单价2
     */
    @Column(name = "average_price2")
    private String averagePrice2;

    /**
     * 供应商3
     */
    private String supplier3;

    /**
     * 年采购量3
     */
    @Column(name = "purchase_amount3")
    private String purchaseAmount3;

    /**
     * 平均单价3
     */
    @Column(name = "average_price3")
    private String averagePrice3;

    /**
     * 创建者id
     */
    @Column(name = "create_user_id")
    private Integer createUserId;

    /**
     * 创建者姓名
     */
    @Column(name = "create_user_name")
    private String createUserName;

    /**
     * 上一次修改者id
     */
    @Column(name = "lastmodify_user_id")
    private Integer lastmodifyUserId;

    /**
     * 上一次修改者姓名
     */
    @Column(name = "lastmodify_user_name")
    private String lastmodifyUserName;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    private List<CustomerPurchaseSupplier> suppliers;

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
     * 获取客户id
     *
     * @return customer_id - 客户id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * 设置客户id
     *
     * @param customerId 客户id
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取年
     *
     * @return year - 年
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置年
     *
     * @param year 年
     */
    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    /**
     * 获取标准产品id（外键）
     *
     * @return product_id - 标准产品id（外键）
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置标准产品id（外键）
     *
     * @param productId 标准产品id（外键）
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取产品名称
     *
     * @return product_name - 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置产品名称
     *
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * 获取年需求量
     *
     * @return annual_demands - 年需求量
     */
    public String getAnnualDemands() {
        return annualDemands;
    }

    /**
     * 设置年需求量
     *
     * @param annualDemands 年需求量
     */
    public void setAnnualDemands(String annualDemands) {
        this.annualDemands = annualDemands == null ? null : annualDemands.trim();
    }

    /**
     * 获取平均单价，美元计
     *
     * @return average_price - 平均单价，美元计
     */
    public String getAveragePrice() {
        return averagePrice;
    }

    /**
     * 设置平均单价，美元计
     *
     * @param averagePrice 平均单价，美元计
     */
    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice == null ? null : averagePrice.trim();
    }

    /**
     * 获取供应商1
     *
     * @return supplier1 - 供应商1
     */
    public String getSupplier1() {
        return supplier1;
    }

    /**
     * 设置供应商1
     *
     * @param supplier1 供应商1
     */
    public void setSupplier1(String supplier1) {
        this.supplier1 = supplier1 == null ? null : supplier1.trim();
    }

    /**
     * 获取年采购量1
     *
     * @return purchase_amount1 - 年采购量1
     */
    public String getPurchaseAmount1() {
        return purchaseAmount1;
    }

    /**
     * 设置年采购量1
     *
     * @param purchaseAmount1 年采购量1
     */
    public void setPurchaseAmount1(String purchaseAmount1) {
        this.purchaseAmount1 = purchaseAmount1 == null ? null : purchaseAmount1.trim();
    }

    /**
     * 获取平均单价1
     *
     * @return average_price1 - 平均单价1
     */
    public String getAveragePrice1() {
        return averagePrice1;
    }

    /**
     * 设置平均单价1
     *
     * @param averagePrice1 平均单价1
     */
    public void setAveragePrice1(String averagePrice1) {
        this.averagePrice1 = averagePrice1 == null ? null : averagePrice1.trim();
    }

    /**
     * 获取供应商2
     *
     * @return supplier2 - 供应商2
     */
    public String getSupplier2() {
        return supplier2;
    }

    /**
     * 设置供应商2
     *
     * @param supplier2 供应商2
     */
    public void setSupplier2(String supplier2) {
        this.supplier2 = supplier2 == null ? null : supplier2.trim();
    }

    /**
     * 获取年采购量2
     *
     * @return purchase_amount2 - 年采购量2
     */
    public String getPurchaseAmount2() {
        return purchaseAmount2;
    }

    /**
     * 设置年采购量2
     *
     * @param purchaseAmount2 年采购量2
     */
    public void setPurchaseAmount2(String purchaseAmount2) {
        this.purchaseAmount2 = purchaseAmount2 == null ? null : purchaseAmount2.trim();
    }

    /**
     * 获取平均单价2
     *
     * @return average_price2 - 平均单价2
     */
    public String getAveragePrice2() {
        return averagePrice2;
    }

    /**
     * 设置平均单价2
     *
     * @param averagePrice2 平均单价2
     */
    public void setAveragePrice2(String averagePrice2) {
        this.averagePrice2 = averagePrice2 == null ? null : averagePrice2.trim();
    }

    /**
     * 获取供应商3
     *
     * @return supplier3 - 供应商3
     */
    public String getSupplier3() {
        return supplier3;
    }

    /**
     * 设置供应商3
     *
     * @param supplier3 供应商3
     */
    public void setSupplier3(String supplier3) {
        this.supplier3 = supplier3 == null ? null : supplier3.trim();
    }

    /**
     * 获取年采购量3
     *
     * @return purchase_amount3 - 年采购量3
     */
    public String getPurchaseAmount3() {
        return purchaseAmount3;
    }

    /**
     * 设置年采购量3
     *
     * @param purchaseAmount3 年采购量3
     */
    public void setPurchaseAmount3(String purchaseAmount3) {
        this.purchaseAmount3 = purchaseAmount3 == null ? null : purchaseAmount3.trim();
    }

    /**
     * 获取平均单价3
     *
     * @return average_price3 - 平均单价3
     */
    public String getAveragePrice3() {
        return averagePrice3;
    }

    /**
     * 设置平均单价3
     *
     * @param averagePrice3 平均单价3
     */
    public void setAveragePrice3(String averagePrice3) {
        this.averagePrice3 = averagePrice3 == null ? null : averagePrice3.trim();
    }

    /**
     * 获取创建者id
     *
     * @return create_user_id - 创建者id
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * 设置创建者id
     *
     * @param createUserId 创建者id
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 获取创建者姓名
     *
     * @return create_user_name - 创建者姓名
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 设置创建者姓名
     *
     * @param createUserName 创建者姓名
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 获取上一次修改者id
     *
     * @return lastmodify_user_id - 上一次修改者id
     */
    public Integer getLastmodifyUserId() {
        return lastmodifyUserId;
    }

    /**
     * 设置上一次修改者id
     *
     * @param lastmodifyUserId 上一次修改者id
     */
    public void setLastmodifyUserId(Integer lastmodifyUserId) {
        this.lastmodifyUserId = lastmodifyUserId;
    }

    /**
     * 获取上一次修改者姓名
     *
     * @return lastmodify_user_name - 上一次修改者姓名
     */
    public String getLastmodifyUserName() {
        return lastmodifyUserName;
    }

    /**
     * 设置上一次修改者姓名
     *
     * @param lastmodifyUserName 上一次修改者姓名
     */
    public void setLastmodifyUserName(String lastmodifyUserName) {
        this.lastmodifyUserName = lastmodifyUserName == null ? null : lastmodifyUserName.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public List<CustomerPurchaseSupplier> getSuppliers() {
        if (suppliers == null) {
            return Collections.emptyList();
        }

        return suppliers;
    }

    public void setSuppliers(List<CustomerPurchaseSupplier> suppliers) {
        this.suppliers = suppliers;
    }
}