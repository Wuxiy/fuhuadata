package com.fuhuadata.domain.mybatis;

import java.util.Date;
import javax.persistence.*;

@Table(name = "customer_sale_product")
public class CustomerSaleProduct extends BaseEntity<Integer> {
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

    @Column(name = "product_id")
    private String productId;

    /**
     * 产品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 营销手段
     */
    @Column(name = "marketing_method")
    private String marketingMethod;

    /**
     * 总年销量
     */
    @Column(name = "year_sales_total")
    private String yearSalesTotal;

    /**
     * 销售目的国1
     */
    @Column(name = "destination_country1")
    private String destinationCountry1;

    /**
     * 年销量1
     */
    @Column(name = "year_sales1")
    private String yearSales1;

    /**
     * 市场份额1
     */
    @Column(name = "market_share1")
    private String marketShare1;

    /**
     * 销售目的国2
     */
    @Column(name = "destination_country2")
    private String destinationCountry2;

    /**
     * 年销量2
     */
    @Column(name = "year_sales2")
    private String yearSales2;

    /**
     * 市场份额2
     */
    @Column(name = "market_share2")
    private String marketShare2;

    /**
     * 销售目的国3
     */
    @Column(name = "destination_country3")
    private String destinationCountry3;

    /**
     * 年销量3
     */
    @Column(name = "year_sales3")
    private String yearSales3;

    /**
     * 市场份额3
     */
    @Column(name = "market_share3")
    private String marketShare3;

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
     * @return product_id
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
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
     * 获取品牌
     *
     * @return brand - 品牌
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置品牌
     *
     * @param brand 品牌
     */
    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    /**
     * 获取营销手段
     *
     * @return marketing_method - 营销手段
     */
    public String getMarketingMethod() {
        return marketingMethod;
    }

    /**
     * 设置营销手段
     *
     * @param marketingMethod 营销手段
     */
    public void setMarketingMethod(String marketingMethod) {
        this.marketingMethod = marketingMethod == null ? null : marketingMethod.trim();
    }

    /**
     * 获取总年销量
     *
     * @return year_sales_total - 总年销量
     */
    public String getYearSalesTotal() {
        return yearSalesTotal;
    }

    /**
     * 设置总年销量
     *
     * @param yearSalesTotal 总年销量
     */
    public void setYearSalesTotal(String yearSalesTotal) {
        this.yearSalesTotal = yearSalesTotal == null ? null : yearSalesTotal.trim();
    }

    /**
     * 获取销售目的国1
     *
     * @return destination_country1 - 销售目的国1
     */
    public String getDestinationCountry1() {
        return destinationCountry1;
    }

    /**
     * 设置销售目的国1
     *
     * @param destinationCountry1 销售目的国1
     */
    public void setDestinationCountry1(String destinationCountry1) {
        this.destinationCountry1 = destinationCountry1 == null ? null : destinationCountry1.trim();
    }

    /**
     * 获取年销量1
     *
     * @return year_sales1 - 年销量1
     */
    public String getYearSales1() {
        return yearSales1;
    }

    /**
     * 设置年销量1
     *
     * @param yearSales1 年销量1
     */
    public void setYearSales1(String yearSales1) {
        this.yearSales1 = yearSales1 == null ? null : yearSales1.trim();
    }

    /**
     * 获取市场份额1
     *
     * @return market_share1 - 市场份额1
     */
    public String getMarketShare1() {
        return marketShare1;
    }

    /**
     * 设置市场份额1
     *
     * @param marketShare1 市场份额1
     */
    public void setMarketShare1(String marketShare1) {
        this.marketShare1 = marketShare1 == null ? null : marketShare1.trim();
    }

    /**
     * 获取销售目的国2
     *
     * @return destination_country2 - 销售目的国2
     */
    public String getDestinationCountry2() {
        return destinationCountry2;
    }

    /**
     * 设置销售目的国2
     *
     * @param destinationCountry2 销售目的国2
     */
    public void setDestinationCountry2(String destinationCountry2) {
        this.destinationCountry2 = destinationCountry2 == null ? null : destinationCountry2.trim();
    }

    /**
     * 获取年销量2
     *
     * @return year_sales2 - 年销量2
     */
    public String getYearSales2() {
        return yearSales2;
    }

    /**
     * 设置年销量2
     *
     * @param yearSales2 年销量2
     */
    public void setYearSales2(String yearSales2) {
        this.yearSales2 = yearSales2 == null ? null : yearSales2.trim();
    }

    /**
     * 获取市场份额2
     *
     * @return market_share2 - 市场份额2
     */
    public String getMarketShare2() {
        return marketShare2;
    }

    /**
     * 设置市场份额2
     *
     * @param marketShare2 市场份额2
     */
    public void setMarketShare2(String marketShare2) {
        this.marketShare2 = marketShare2 == null ? null : marketShare2.trim();
    }

    /**
     * 获取销售目的国3
     *
     * @return destination_country3 - 销售目的国3
     */
    public String getDestinationCountry3() {
        return destinationCountry3;
    }

    /**
     * 设置销售目的国3
     *
     * @param destinationCountry3 销售目的国3
     */
    public void setDestinationCountry3(String destinationCountry3) {
        this.destinationCountry3 = destinationCountry3 == null ? null : destinationCountry3.trim();
    }

    /**
     * 获取年销量3
     *
     * @return year_sales3 - 年销量3
     */
    public String getYearSales3() {
        return yearSales3;
    }

    /**
     * 设置年销量3
     *
     * @param yearSales3 年销量3
     */
    public void setYearSales3(String yearSales3) {
        this.yearSales3 = yearSales3 == null ? null : yearSales3.trim();
    }

    /**
     * 获取市场份额3
     *
     * @return market_share3 - 市场份额3
     */
    public String getMarketShare3() {
        return marketShare3;
    }

    /**
     * 设置市场份额3
     *
     * @param marketShare3 市场份额3
     */
    public void setMarketShare3(String marketShare3) {
        this.marketShare3 = marketShare3 == null ? null : marketShare3.trim();
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
}