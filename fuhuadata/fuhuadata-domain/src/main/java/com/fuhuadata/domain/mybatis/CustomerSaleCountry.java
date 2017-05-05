package com.fuhuadata.domain.mybatis;

import javax.persistence.*;

@Table(name = "customer_sale_country")
public class CustomerSaleCountry extends BaseEntity<Integer> {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 销售产品id
     */
    @Column(name = "sale_id")
    private Integer saleId;

    /**
     * 标准产品id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 销售目的国
     */
    @Column(name = "destination_country")
    private String destinationCountry;

    /**
     * 年销售量
     */
    @Column(name = "year_sales")
    private String yearSales;

    /**
     * 市场份额
     */
    @Column(name = "market_share")
    private String marketShare;

    /**
     * 主计量单位
     */
    private String measurement;

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
     * 获取销售目的国
     *
     * @return destination_country - 销售目的国
     */
    public String getDestinationCountry() {
        return destinationCountry;
    }

    /**
     * 设置销售目的国
     *
     * @param destinationCountry 销售目的国
     */
    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry == null ? null : destinationCountry.trim();
    }

    /**
     * 获取年销售量
     *
     * @return year_sales - 年销售量
     */
    public String getYearSales() {
        return yearSales;
    }

    /**
     * 设置年销售量
     *
     * @param yearSales 年销售量
     */
    public void setYearSales(String yearSales) {
        this.yearSales = yearSales == null ? null : yearSales.trim();
    }

    /**
     * 获取市场份额
     *
     * @return market_share - 市场份额
     */
    public String getMarketShare() {
        return marketShare;
    }

    /**
     * 设置市场份额
     *
     * @param marketShare 市场份额
     */
    public void setMarketShare(String marketShare) {
        this.marketShare = marketShare == null ? null : marketShare.trim();
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }
}