package com.fuhuadata.domain.customs;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "customs_data")
public class CustomsData extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 进出口发生日期
     */
    private Date cdate;

    /**
     * 出口：1，进口：2
     */
    private Boolean type;

    /**
     * 进出口海关口岸
     */
    @Column(name = "customs_org")
    private String customsOrg;

    /**
     * 主管关区
     */
    @Column(name = "customs_area")
    private String customsArea;

    /**
     * 目的港或起运港
     */
    private String port;

    /**
     * 中转国
     */
    @Column(name = "transit_country")
    private String transitCountry;

    /**
     * 目的国或起运国
     */
    @Column(name = "origin_dest_country")
    private String originDestCountry;

    /**
     * 所属大洲
     */
    private String continent;

    /**
     * 申报单位
     */
    @Column(name = "declare_company")
    private String declareCompany;

    /**
     * 货主单位
     */
    @Column(name = "shipper_company")
    private String shipperCompany;

    /**
     * 经营单位
     */
    @Column(name = "operation_company")
    private String operationCompany;

    /**
     * 经营单位代码
     */
    @Column(name = "operation_com_code")
    private String operationComCode;

    /**
     * 产销地
     */
    @Column(name = "product_market_location")
    private String productMarketLocation;

    /**
     * 海关编码
     */
    @Column(name = "customs_code")
    private String customsCode;

    /**
     * 产品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 规格
     */
    private String specifications;

    /**
     * 成交方式
     */
    @Column(name = "deal_method")
    private String dealMethod;

    /**
     * 申报单价
     */
    @Column(name = "declare_price")
    private BigDecimal declarePrice;

    /**
     * 价格单位
     */
    @Column(name = "price_unit")
    private String priceUnit;

    /**
     * 申报数量
     */
    @Column(name = "declare_num")
    private BigDecimal declareNum;

    /**
     * 申报数量的单位
     */
    @Column(name = "declare_num_unit")
    private String declareNumUnit;

    /**
     * 总价
     */
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    /**
     * 法定数量
     */
    @Column(name = "legal_num")
    private BigDecimal legalNum;

    /**
     * 法定单位
     */
    @Column(name = "legal_unit")
    private String legalUnit;

    /**
     * 美元单价
     */
    @Column(name = "dollar_price")
    private BigDecimal dollarPrice;

    /**
     * 美元总价
     */
    @Column(name = "dollar_total")
    private BigDecimal dollarTotal;

    /**
     * 美元币制
     */
    @Column(name = "dollar_crrency")
    private String dollarCrrency;

    /**
     * 毛重
     */
    @Column(name = "gross_weight")
    private BigDecimal grossWeight;

    /**
     * 净重
     */
    @Column(name = "net_weight")
    private BigDecimal netWeight;

    /**
     * 重量单位
     */
    @Column(name = "weight_unit")
    private String weightUnit;

    /**
     * 贸易方式
     */
    @Column(name = "trade_mode")
    private String tradeMode;

    /**
     * 运输方式
     */
    @Column(name = "transport_mode")
    private String transportMode;

    /**
     * 件数
     */
    @Column(name = "number_of_packages")
    private BigDecimal numberOfPackages;

    /**
     * 包装种类
     */
    @Column(name = "packing_type")
    private String packingType;

    /**
     * 企业性质
     */
    @Column(name = "enterprise_nature")
    private String enterpriseNature;

    /**
     * 企业地址
     */
    private String address;

    /**
     * 企业电话
     */
    @Column(name = "telephone_number")
    private String telephoneNumber;

    /**
     * 企业传真
     */
    private String fax;

    /**
     * 企业邮编
     */
    @Column(name = "post_code")
    private String postCode;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 联系人
     */
    @Column(name = "contact_man")
    private String contactMan;

    /**
     * 入库时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取进出口发生日期
     *
     * @return cdate - 进出口发生日期
     */
    public Date getCdate() {
        return cdate;
    }

    /**
     * 设置进出口发生日期
     *
     * @param cdate 进出口发生日期
     */
    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    /**
     * 获取出口：1，进口：2
     *
     * @return type - 出口：1，进口：2
     */
    public Boolean getType() {
        return type;
    }

    /**
     * 设置出口：1，进口：2
     *
     * @param type 出口：1，进口：2
     */
    public void setType(Boolean type) {
        this.type = type;
    }

    /**
     * 获取进出口海关口岸
     *
     * @return customs_org - 进出口海关口岸
     */
    public String getCustomsOrg() {
        return customsOrg;
    }

    /**
     * 设置进出口海关口岸
     *
     * @param customsOrg 进出口海关口岸
     */
    public void setCustomsOrg(String customsOrg) {
        this.customsOrg = customsOrg == null ? null : customsOrg.trim();
    }

    /**
     * 获取主管关区
     *
     * @return customs_area - 主管关区
     */
    public String getCustomsArea() {
        return customsArea;
    }

    /**
     * 设置主管关区
     *
     * @param customsArea 主管关区
     */
    public void setCustomsArea(String customsArea) {
        this.customsArea = customsArea == null ? null : customsArea.trim();
    }

    /**
     * 获取目的港或起运港
     *
     * @return port - 目的港或起运港
     */
    public String getPort() {
        return port;
    }

    /**
     * 设置目的港或起运港
     *
     * @param port 目的港或起运港
     */
    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    /**
     * 获取中转国
     *
     * @return transit_country - 中转国
     */
    public String getTransitCountry() {
        return transitCountry;
    }

    /**
     * 设置中转国
     *
     * @param transitCountry 中转国
     */
    public void setTransitCountry(String transitCountry) {
        this.transitCountry = transitCountry == null ? null : transitCountry.trim();
    }

    /**
     * 获取目的国或起运国
     *
     * @return origin_dest_country - 目的国或起运国
     */
    public String getOriginDestCountry() {
        return originDestCountry;
    }

    /**
     * 设置目的国或起运国
     *
     * @param originDestCountry 目的国或起运国
     */
    public void setOriginDestCountry(String originDestCountry) {
        this.originDestCountry = originDestCountry == null ? null : originDestCountry.trim();
    }

    /**
     * 获取所属大洲
     *
     * @return continent - 所属大洲
     */
    public String getContinent() {
        return continent;
    }

    /**
     * 设置所属大洲
     *
     * @param continent 所属大洲
     */
    public void setContinent(String continent) {
        this.continent = continent == null ? null : continent.trim();
    }

    /**
     * 获取申报单位
     *
     * @return declare_company - 申报单位
     */
    public String getDeclareCompany() {
        return declareCompany;
    }

    /**
     * 设置申报单位
     *
     * @param declareCompany 申报单位
     */
    public void setDeclareCompany(String declareCompany) {
        this.declareCompany = declareCompany == null ? null : declareCompany.trim();
    }

    /**
     * 获取货主单位
     *
     * @return shipper_company - 货主单位
     */
    public String getShipperCompany() {
        return shipperCompany;
    }

    /**
     * 设置货主单位
     *
     * @param shipperCompany 货主单位
     */
    public void setShipperCompany(String shipperCompany) {
        this.shipperCompany = shipperCompany == null ? null : shipperCompany.trim();
    }

    /**
     * 获取经营单位
     *
     * @return operation_company - 经营单位
     */
    public String getOperationCompany() {
        return operationCompany;
    }

    /**
     * 设置经营单位
     *
     * @param operationCompany 经营单位
     */
    public void setOperationCompany(String operationCompany) {
        this.operationCompany = operationCompany == null ? null : operationCompany.trim();
    }

    /**
     * 获取经营单位代码
     *
     * @return operation_com_code - 经营单位代码
     */
    public String getOperationComCode() {
        return operationComCode;
    }

    /**
     * 设置经营单位代码
     *
     * @param operationComCode 经营单位代码
     */
    public void setOperationComCode(String operationComCode) {
        this.operationComCode = operationComCode == null ? null : operationComCode.trim();
    }

    /**
     * 获取产销地
     *
     * @return product_market_location - 产销地
     */
    public String getProductMarketLocation() {
        return productMarketLocation;
    }

    /**
     * 设置产销地
     *
     * @param productMarketLocation 产销地
     */
    public void setProductMarketLocation(String productMarketLocation) {
        this.productMarketLocation = productMarketLocation == null ? null : productMarketLocation.trim();
    }

    /**
     * 获取海关编码
     *
     * @return customs_code - 海关编码
     */
    public String getCustomsCode() {
        return customsCode;
    }

    /**
     * 设置海关编码
     *
     * @param customsCode 海关编码
     */
    public void setCustomsCode(String customsCode) {
        this.customsCode = customsCode == null ? null : customsCode.trim();
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
     * 获取规格
     *
     * @return specifications - 规格
     */
    public String getSpecifications() {
        return specifications;
    }

    /**
     * 设置规格
     *
     * @param specifications 规格
     */
    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    /**
     * 获取成交方式
     *
     * @return deal_method - 成交方式
     */
    public String getDealMethod() {
        return dealMethod;
    }

    /**
     * 设置成交方式
     *
     * @param dealMethod 成交方式
     */
    public void setDealMethod(String dealMethod) {
        this.dealMethod = dealMethod == null ? null : dealMethod.trim();
    }

    /**
     * 获取申报单价
     *
     * @return declare_price - 申报单价
     */
    public BigDecimal getDeclarePrice() {
        return declarePrice;
    }

    /**
     * 设置申报单价
     *
     * @param declarePrice 申报单价
     */
    public void setDeclarePrice(BigDecimal declarePrice) {
        this.declarePrice = declarePrice;
    }

    /**
     * 获取价格单位
     *
     * @return price_unit - 价格单位
     */
    public String getPriceUnit() {
        return priceUnit;
    }

    /**
     * 设置价格单位
     *
     * @param priceUnit 价格单位
     */
    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit == null ? null : priceUnit.trim();
    }

    /**
     * 获取申报数量
     *
     * @return declare_num - 申报数量
     */
    public BigDecimal getDeclareNum() {
        return declareNum;
    }

    /**
     * 设置申报数量
     *
     * @param declareNum 申报数量
     */
    public void setDeclareNum(BigDecimal declareNum) {
        this.declareNum = declareNum;
    }

    /**
     * 获取申报数量的单位
     *
     * @return declare_num_unit - 申报数量的单位
     */
    public String getDeclareNumUnit() {
        return declareNumUnit;
    }

    /**
     * 设置申报数量的单位
     *
     * @param declareNumUnit 申报数量的单位
     */
    public void setDeclareNumUnit(String declareNumUnit) {
        this.declareNumUnit = declareNumUnit == null ? null : declareNumUnit.trim();
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
     * 获取法定数量
     *
     * @return legal_num - 法定数量
     */
    public BigDecimal getLegalNum() {
        return legalNum;
    }

    /**
     * 设置法定数量
     *
     * @param legalNum 法定数量
     */
    public void setLegalNum(BigDecimal legalNum) {
        this.legalNum = legalNum;
    }

    /**
     * 获取法定单位
     *
     * @return legal_unit - 法定单位
     */
    public String getLegalUnit() {
        return legalUnit;
    }

    /**
     * 设置法定单位
     *
     * @param legalUnit 法定单位
     */
    public void setLegalUnit(String legalUnit) {
        this.legalUnit = legalUnit == null ? null : legalUnit.trim();
    }

    /**
     * 获取美元单价
     *
     * @return dollar_price - 美元单价
     */
    public BigDecimal getDollarPrice() {
        return dollarPrice;
    }

    /**
     * 设置美元单价
     *
     * @param dollarPrice 美元单价
     */
    public void setDollarPrice(BigDecimal dollarPrice) {
        this.dollarPrice = dollarPrice;
    }

    /**
     * 获取美元总价
     *
     * @return dollar_total - 美元总价
     */
    public BigDecimal getDollarTotal() {
        return dollarTotal;
    }

    /**
     * 设置美元总价
     *
     * @param dollarTotal 美元总价
     */
    public void setDollarTotal(BigDecimal dollarTotal) {
        this.dollarTotal = dollarTotal;
    }

    /**
     * 获取美元币制
     *
     * @return dollar_crrency - 美元币制
     */
    public String getDollarCrrency() {
        return dollarCrrency;
    }

    /**
     * 设置美元币制
     *
     * @param dollarCrrency 美元币制
     */
    public void setDollarCrrency(String dollarCrrency) {
        this.dollarCrrency = dollarCrrency == null ? null : dollarCrrency.trim();
    }

    /**
     * 获取毛重
     *
     * @return gross_weight - 毛重
     */
    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    /**
     * 设置毛重
     *
     * @param grossWeight 毛重
     */
    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    /**
     * 获取净重
     *
     * @return net_weight - 净重
     */
    public BigDecimal getNetWeight() {
        return netWeight;
    }

    /**
     * 设置净重
     *
     * @param netWeight 净重
     */
    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    /**
     * 获取重量单位
     *
     * @return weight_unit - 重量单位
     */
    public String getWeightUnit() {
        return weightUnit;
    }

    /**
     * 设置重量单位
     *
     * @param weightUnit 重量单位
     */
    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit == null ? null : weightUnit.trim();
    }

    /**
     * 获取贸易方式
     *
     * @return trade_mode - 贸易方式
     */
    public String getTradeMode() {
        return tradeMode;
    }

    /**
     * 设置贸易方式
     *
     * @param tradeMode 贸易方式
     */
    public void setTradeMode(String tradeMode) {
        this.tradeMode = tradeMode == null ? null : tradeMode.trim();
    }

    /**
     * 获取运输方式
     *
     * @return transport_mode - 运输方式
     */
    public String getTransportMode() {
        return transportMode;
    }

    /**
     * 设置运输方式
     *
     * @param transportMode 运输方式
     */
    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode == null ? null : transportMode.trim();
    }

    /**
     * 获取件数
     *
     * @return number_of_packages - 件数
     */
    public BigDecimal getNumberOfPackages() {
        return numberOfPackages;
    }

    /**
     * 设置件数
     *
     * @param numberOfPackages 件数
     */
    public void setNumberOfPackages(BigDecimal numberOfPackages) {
        this.numberOfPackages = numberOfPackages;
    }

    /**
     * 获取包装种类
     *
     * @return packing_type - 包装种类
     */
    public String getPackingType() {
        return packingType;
    }

    /**
     * 设置包装种类
     *
     * @param packingType 包装种类
     */
    public void setPackingType(String packingType) {
        this.packingType = packingType == null ? null : packingType.trim();
    }

    /**
     * 获取企业性质
     *
     * @return enterprise_nature - 企业性质
     */
    public String getEnterpriseNature() {
        return enterpriseNature;
    }

    /**
     * 设置企业性质
     *
     * @param enterpriseNature 企业性质
     */
    public void setEnterpriseNature(String enterpriseNature) {
        this.enterpriseNature = enterpriseNature == null ? null : enterpriseNature.trim();
    }

    /**
     * 获取企业地址
     *
     * @return address - 企业地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置企业地址
     *
     * @param address 企业地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取企业电话
     *
     * @return telephone_number - 企业电话
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * 设置企业电话
     *
     * @param telephoneNumber 企业电话
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber == null ? null : telephoneNumber.trim();
    }

    /**
     * 获取企业传真
     *
     * @return fax - 企业传真
     */
    public String getFax() {
        return fax;
    }

    /**
     * 设置企业传真
     *
     * @param fax 企业传真
     */
    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    /**
     * 获取企业邮编
     *
     * @return post_code - 企业邮编
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * 设置企业邮编
     *
     * @param postCode 企业邮编
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取联系人
     *
     * @return contact_man - 联系人
     */
    public String getContactMan() {
        return contactMan;
    }

    /**
     * 设置联系人
     *
     * @param contactMan 联系人
     */
    public void setContactMan(String contactMan) {
        this.contactMan = contactMan == null ? null : contactMan.trim();
    }

    /**
     * 获取入库时间
     *
     * @return create_time - 入库时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置入库时间
     *
     * @param createTime 入库时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}