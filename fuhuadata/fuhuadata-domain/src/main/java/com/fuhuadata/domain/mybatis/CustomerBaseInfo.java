package com.fuhuadata.domain.mybatis;

import com.fasterxml.jackson.annotation.JsonView;
import com.fuhuadata.domain.json.Views;

import javax.persistence.*;
import java.util.Date;

@Table(name = "customer_base_info")
public class CustomerBaseInfo extends BaseEntity<Integer> {
    /**
     * 客户编号
     */
    @JsonView(Views.Viewable.class)
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    /**
     * nc系统客户pk
     */
    @Column(name = "nc_id")
    private String ncId;

    /**
     * 企业全称
     */
    @Column(name = "full_name")
    private String fullName;

    /**
     * 企业简称
     */
    @Column(name = "short_name")
    private String shortName;

    /**
     * 企业类型,0客户,1竞对
     */
    @Column(name = "company_type")
    private Integer companyType;

    /**
     * 地区code
     */
    @Column(name = "customer_area_id")
    private String customerAreaId;

    /**
     * 地区分类,例如北美洲
     */
    @Column(name = "customer_area")
    private String customerArea;

    /**
     * 客户税号
     */
    @Column(name = "customer_duty_paragraph")
    private String customerDutyParagraph;

    /**
     * 销售组织code
     */
    @Column(name = "sale_organization_id")
    private String saleOrganizationId;

    /**
     * 销售组织名称
     */
    @Column(name = "sale_organization_name")
    private String saleOrganizationName;

    /**
     * 企业性质名称集合，逗号分隔
     */
    @Column(name = "full_enterprise_nature")
    private String fullEnterpriseNature;

    /**
     * 其他企业性质
     */
    @Column(name = "other_enterprise_nature")
    private String otherEnterpriseNature;

    /**
     * 注册资金
     */
    @Column(name = "registered_funds")
    private String registeredFunds;

    /**
     * 注册地址
     */
    @Column(name = "registered_address")
    private String registeredAddress;

    /**
     * 经营范围
     */
    @Column(name = "management_scope")
    private String managementScope;

    /**
     * 中信保编号
     */
    @Column(name = "zhongxinbao_number")
    private String zhongxinbaoNumber;

    /**
     * 中信保信用评级,0未知,1:1A,2:2A,3:3A,4:4A
     */
    @Column(name = "zhongxinbao_level")
    private Integer zhongxinbaoLevel;

    /**
     * 企业电话
     */
    @Column(name = "enterprise_phone")
    private String enterprisePhone;

    /**
     * 企业邮箱
     */
    @Column(name = "enterprise_email")
    private String enterpriseEmail;

    /**
     * 企业信息完成度
     */
    @Column(name = "customer_completion")
    private String customerCompletion;

    /**
     * 1:战略客户,2:大客户 3:重要客户 4:一般客户 5:风险客户
     */
    @Column(name = "customer_level")
    private String customerLevel;

    /**
     * 1:合作 2:潜在 3:流失
     */
    @Column(name = "customer_type")
    private Byte customerType;

    /**
     * 潜在客户机会来源 1:展会，2：门户网站 3：农药店考察 4：客户介绍 5：主动联系 6：其他
     */
    @Column(name = "opportunity_source")
    private Byte opportunitySource;

    /**
     * 其他机会来源
     */
    @Column(name = "other_opportunity")
    private String otherOpportunity;

    /**
     * 机会描述
     */
    @Column(name = "opportunity_describle")
    private String opportunityDescrible;

    /**
     * 是否有中国分公司 0：无 1：有
     */
    @Column(name = "has_chi_company")
    private Byte hasChiCompany;

    /**
     * 是否有中方采购 0：无 1：有
     */
    @Column(name = "has_chi_purchase")
    private Byte hasChiPurchase;

    /**
     * 客户状态  0：流失 1：正常
     */
    @Column(name = "customer_status")
    private Byte customerStatus;

    /**
     * 流失原因分析
     */
    @Column(name = "loss_reason")
    private String lossReason;

    /**
     * 资质文件保存路径
     */
    @Column(name = "qualifications_file_url")
    private String qualificationsFileUrl;

    /**
     * 工厂位置
     */
    @Column(name = "factory_location")
    private String factoryLocation;

    /**
     * 分销主要竞争对手
     */
    @Column(name = "major_competitors")
    private String majorCompetitors;

    /**
     * 备注
     */
    private String remark;

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
     * 价格敏感度
     */
    @JsonView(Views.Viewable.class)
    @Column(name = "price_sensitivity")
    private String priceSensitivity;

    /**
     * 忠诚度
     */
    @JsonView(Views.Viewable.class)
    private String loyalty;

    /**
     * 开始合作时间
     */
    @JsonView(Views.Viewable.class)
    @Column(name = "start_cooperation_time")
    private Date startCooperationTime;

    /**
     * 合作持续时间（月）
     */
    @Column(name = "cooperation_duration")
    private Integer cooperationDuration;

    /**
     * 采购季节
     */
    @JsonView(Views.Viewable.class)
    @Column(name = "purchasing_season")
    private String purchasingSeason;

    /**
     * 活跃周期
     */
    @JsonView(Views.Viewable.class)
    @Column(name = "active_period")
    private String activePeriod;

    /**
     * 合作紧密度（福华是否独家供应） 0:否 1:是
     */
    @JsonView(Views.Viewable.class)
    @Column(name = "is_fuhua_exclusive")
    private Byte isFuhuaExclusive;

    /**
     * 合作情况备注
     */
    @JsonView(Views.Viewable.class)
    @Column(name = "cooperation_remark")
    private String cooperationRemark;

    /**
     * 生产线
     */
    @Column(name = "production_line")
    private String productionLine;

    /**
     * 时区code
     */
    private String timezone;

    /**
     * 客户基本分类code
     */
    private String custclass;

    /**
     * 数据格式code
     */
    private String formatdoc;

    /**
     * 贸易国别code
     */
    private String countryzone;

    /**
     * 获取客户编号
     *
     * @return customer_id - 客户编号
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * 设置客户编号
     *
     * @param customerId 客户编号
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取nc系统客户pk
     *
     * @return nc_id - nc系统客户pk
     */
    public String getNcId() {
        return ncId;
    }

    /**
     * 设置nc系统客户pk
     *
     * @param ncId nc系统客户pk
     */
    public void setNcId(String ncId) {
        this.ncId = ncId == null ? null : ncId.trim();
    }

    /**
     * 获取企业全称
     *
     * @return full_name - 企业全称
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 设置企业全称
     *
     * @param fullName 企业全称
     */
    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    /**
     * 获取企业简称
     *
     * @return short_name - 企业简称
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 设置企业简称
     *
     * @param shortName 企业简称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    /**
     * 获取企业类型,0客户,1竞对
     *
     * @return company_type - 企业类型,0客户,1竞对
     */
    public Integer getCompanyType() {
        return companyType;
    }

    /**
     * 设置企业类型,0客户,1竞对
     *
     * @param companyType 企业类型,0客户,1竞对
     */
    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    /**
     * 获取地区code
     *
     * @return customer_area_id - 地区code
     */
    public String getCustomerAreaId() {
        return customerAreaId;
    }

    /**
     * 设置地区code
     *
     * @param customerAreaId 地区code
     */
    public void setCustomerAreaId(String customerAreaId) {
        this.customerAreaId = customerAreaId == null ? null : customerAreaId.trim();
    }

    /**
     * 获取地区分类,例如北美洲
     *
     * @return customer_area - 地区分类,例如北美洲
     */
    public String getCustomerArea() {
        return customerArea;
    }

    /**
     * 设置地区分类,例如北美洲
     *
     * @param customerArea 地区分类,例如北美洲
     */
    public void setCustomerArea(String customerArea) {
        this.customerArea = customerArea == null ? null : customerArea.trim();
    }

    /**
     * 获取客户税号
     *
     * @return customer_duty_paragraph - 客户税号
     */
    public String getCustomerDutyParagraph() {
        return customerDutyParagraph;
    }

    /**
     * 设置客户税号
     *
     * @param customerDutyParagraph 客户税号
     */
    public void setCustomerDutyParagraph(String customerDutyParagraph) {
        this.customerDutyParagraph = customerDutyParagraph == null ? null : customerDutyParagraph.trim();
    }

    /**
     * 获取销售组织code
     *
     * @return sale_organization_id - 销售组织code
     */
    public String getSaleOrganizationId() {
        return saleOrganizationId;
    }

    /**
     * 设置销售组织code
     *
     * @param saleOrganizationId 销售组织code
     */
    public void setSaleOrganizationId(String saleOrganizationId) {
        this.saleOrganizationId = saleOrganizationId == null ? null : saleOrganizationId.trim();
    }

    /**
     * 获取销售组织名称
     *
     * @return sale_organization_name - 销售组织名称
     */
    public String getSaleOrganizationName() {
        return saleOrganizationName;
    }

    /**
     * 设置销售组织名称
     *
     * @param saleOrganizationName 销售组织名称
     */
    public void setSaleOrganizationName(String saleOrganizationName) {
        this.saleOrganizationName = saleOrganizationName == null ? null : saleOrganizationName.trim();
    }

    /**
     * 获取企业性质名称集合，逗号分隔
     *
     * @return full_enterprise_nature - 企业性质名称集合，逗号分隔
     */
    public String getFullEnterpriseNature() {
        return fullEnterpriseNature;
    }

    /**
     * 设置企业性质名称集合，逗号分隔
     *
     * @param fullEnterpriseNature 企业性质名称集合，逗号分隔
     */
    public void setFullEnterpriseNature(String fullEnterpriseNature) {
        this.fullEnterpriseNature = fullEnterpriseNature == null ? null : fullEnterpriseNature.trim();
    }

    /**
     * 获取其他企业性质
     *
     * @return other_enterprise_nature - 其他企业性质
     */
    public String getOtherEnterpriseNature() {
        return otherEnterpriseNature;
    }

    /**
     * 设置其他企业性质
     *
     * @param otherEnterpriseNature 其他企业性质
     */
    public void setOtherEnterpriseNature(String otherEnterpriseNature) {
        this.otherEnterpriseNature = otherEnterpriseNature == null ? null : otherEnterpriseNature.trim();
    }

    /**
     * 获取注册资金
     *
     * @return registered_funds - 注册资金
     */
    public String getRegisteredFunds() {
        return registeredFunds;
    }

    /**
     * 设置注册资金
     *
     * @param registeredFunds 注册资金
     */
    public void setRegisteredFunds(String registeredFunds) {
        this.registeredFunds = registeredFunds == null ? null : registeredFunds.trim();
    }

    /**
     * 获取注册地址
     *
     * @return registered_address - 注册地址
     */
    public String getRegisteredAddress() {
        return registeredAddress;
    }

    /**
     * 设置注册地址
     *
     * @param registeredAddress 注册地址
     */
    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress == null ? null : registeredAddress.trim();
    }

    /**
     * 获取经营范围
     *
     * @return management_scope - 经营范围
     */
    public String getManagementScope() {
        return managementScope;
    }

    /**
     * 设置经营范围
     *
     * @param managementScope 经营范围
     */
    public void setManagementScope(String managementScope) {
        this.managementScope = managementScope == null ? null : managementScope.trim();
    }

    /**
     * 获取中信保编号
     *
     * @return zhongxinbao_number - 中信保编号
     */
    public String getZhongxinbaoNumber() {
        return zhongxinbaoNumber;
    }

    /**
     * 设置中信保编号
     *
     * @param zhongxinbaoNumber 中信保编号
     */
    public void setZhongxinbaoNumber(String zhongxinbaoNumber) {
        this.zhongxinbaoNumber = zhongxinbaoNumber == null ? null : zhongxinbaoNumber.trim();
    }

    /**
     * 获取中信保信用评级,0未知,1:1A,2:2A,3:3A,4:4A
     *
     * @return zhongxinbao_level - 中信保信用评级,0未知,1:1A,2:2A,3:3A,4:4A
     */
    public Integer getZhongxinbaoLevel() {
        return zhongxinbaoLevel;
    }

    /**
     * 设置中信保信用评级,0未知,1:1A,2:2A,3:3A,4:4A
     *
     * @param zhongxinbaoLevel 中信保信用评级,0未知,1:1A,2:2A,3:3A,4:4A
     */
    public void setZhongxinbaoLevel(Integer zhongxinbaoLevel) {
        this.zhongxinbaoLevel = zhongxinbaoLevel;
    }

    /**
     * 获取企业电话
     *
     * @return enterprise_phone - 企业电话
     */
    public String getEnterprisePhone() {
        return enterprisePhone;
    }

    /**
     * 设置企业电话
     *
     * @param enterprisePhone 企业电话
     */
    public void setEnterprisePhone(String enterprisePhone) {
        this.enterprisePhone = enterprisePhone == null ? null : enterprisePhone.trim();
    }

    /**
     * 获取企业邮箱
     *
     * @return enterprise_email - 企业邮箱
     */
    public String getEnterpriseEmail() {
        return enterpriseEmail;
    }

    /**
     * 设置企业邮箱
     *
     * @param enterpriseEmail 企业邮箱
     */
    public void setEnterpriseEmail(String enterpriseEmail) {
        this.enterpriseEmail = enterpriseEmail == null ? null : enterpriseEmail.trim();
    }

    /**
     * 获取企业信息完成度
     *
     * @return customer_completion - 企业信息完成度
     */
    public String getCustomerCompletion() {
        return customerCompletion;
    }

    /**
     * 设置企业信息完成度
     *
     * @param customerCompletion 企业信息完成度
     */
    public void setCustomerCompletion(String customerCompletion) {
        this.customerCompletion = customerCompletion == null ? null : customerCompletion.trim();
    }

    /**
     * 获取1:战略客户,2:大客户 3:重要客户 4:一般客户 5:风险客户
     *
     * @return customer_level - 1:战略客户,2:大客户 3:重要客户 4:一般客户 5:风险客户
     */
    public String getCustomerLevel() {
        return customerLevel;
    }

    /**
     * 设置1:战略客户,2:大客户 3:重要客户 4:一般客户 5:风险客户
     *
     * @param customerLevel 1:战略客户,2:大客户 3:重要客户 4:一般客户 5:风险客户
     */
    public void setCustomerLevel(String customerLevel) {
        this.customerLevel = customerLevel == null ? null : customerLevel.trim();
    }

    /**
     * 获取1:合作 2:潜在 3:流失
     *
     * @return customer_type - 1:合作 2:潜在 3:流失
     */
    public Byte getCustomerType() {
        return customerType;
    }

    /**
     * 设置1:合作 2:潜在 3:流失
     *
     * @param customerType 1:合作 2:潜在 3:流失
     */
    public void setCustomerType(Byte customerType) {
        this.customerType = customerType;
    }

    /**
     * 获取潜在客户机会来源 1:展会，2：门户网站 3：农药店考察 4：客户介绍 5：主动联系 6：其他
     *
     * @return opportunity_source - 潜在客户机会来源 1:展会，2：门户网站 3：农药店考察 4：客户介绍 5：主动联系 6：其他
     */
    public Byte getOpportunitySource() {
        return opportunitySource;
    }

    /**
     * 设置潜在客户机会来源 1:展会，2：门户网站 3：农药店考察 4：客户介绍 5：主动联系 6：其他
     *
     * @param opportunitySource 潜在客户机会来源 1:展会，2：门户网站 3：农药店考察 4：客户介绍 5：主动联系 6：其他
     */
    public void setOpportunitySource(Byte opportunitySource) {
        this.opportunitySource = opportunitySource;
    }

    /**
     * 获取其他机会来源
     *
     * @return other_opportunity - 其他机会来源
     */
    public String getOtherOpportunity() {
        return otherOpportunity;
    }

    /**
     * 设置其他机会来源
     *
     * @param otherOpportunity 其他机会来源
     */
    public void setOtherOpportunity(String otherOpportunity) {
        this.otherOpportunity = otherOpportunity == null ? null : otherOpportunity.trim();
    }

    /**
     * 获取机会描述
     *
     * @return opportunity_describle - 机会描述
     */
    public String getOpportunityDescrible() {
        return opportunityDescrible;
    }

    /**
     * 设置机会描述
     *
     * @param opportunityDescrible 机会描述
     */
    public void setOpportunityDescrible(String opportunityDescrible) {
        this.opportunityDescrible = opportunityDescrible == null ? null : opportunityDescrible.trim();
    }

    /**
     * 获取是否有中国分公司 0：无 1：有
     *
     * @return has_chi_company - 是否有中国分公司 0：无 1：有
     */
    public Byte getHasChiCompany() {
        return hasChiCompany;
    }

    /**
     * 设置是否有中国分公司 0：无 1：有
     *
     * @param hasChiCompany 是否有中国分公司 0：无 1：有
     */
    public void setHasChiCompany(Byte hasChiCompany) {
        this.hasChiCompany = hasChiCompany;
    }

    /**
     * 获取是否有中方采购 0：无 1：有
     *
     * @return has_chi_purchase - 是否有中方采购 0：无 1：有
     */
    public Byte getHasChiPurchase() {
        return hasChiPurchase;
    }

    /**
     * 设置是否有中方采购 0：无 1：有
     *
     * @param hasChiPurchase 是否有中方采购 0：无 1：有
     */
    public void setHasChiPurchase(Byte hasChiPurchase) {
        this.hasChiPurchase = hasChiPurchase;
    }

    /**
     * 获取客户状态  0：流失 1：正常
     *
     * @return customer_status - 客户状态  0：流失 1：正常
     */
    public Byte getCustomerStatus() {
        return customerStatus;
    }

    /**
     * 设置客户状态  0：流失 1：正常
     *
     * @param customerStatus 客户状态  0：流失 1：正常
     */
    public void setCustomerStatus(Byte customerStatus) {
        this.customerStatus = customerStatus;
    }

    /**
     * 获取流失原因分析
     *
     * @return loss_reason - 流失原因分析
     */
    public String getLossReason() {
        return lossReason;
    }

    /**
     * 设置流失原因分析
     *
     * @param lossReason 流失原因分析
     */
    public void setLossReason(String lossReason) {
        this.lossReason = lossReason == null ? null : lossReason.trim();
    }

    /**
     * 获取资质文件保存路径
     *
     * @return qualifications_file_url - 资质文件保存路径
     */
    public String getQualificationsFileUrl() {
        return qualificationsFileUrl;
    }

    /**
     * 设置资质文件保存路径
     *
     * @param qualificationsFileUrl 资质文件保存路径
     */
    public void setQualificationsFileUrl(String qualificationsFileUrl) {
        this.qualificationsFileUrl = qualificationsFileUrl == null ? null : qualificationsFileUrl.trim();
    }

    /**
     * 获取工厂位置
     *
     * @return factory_location - 工厂位置
     */
    public String getFactoryLocation() {
        return factoryLocation;
    }

    /**
     * 设置工厂位置
     *
     * @param factoryLocation 工厂位置
     */
    public void setFactoryLocation(String factoryLocation) {
        this.factoryLocation = factoryLocation == null ? null : factoryLocation.trim();
    }

    /**
     * 获取分销主要竞争对手
     *
     * @return major_competitors - 分销主要竞争对手
     */
    public String getMajorCompetitors() {
        return majorCompetitors;
    }

    /**
     * 设置分销主要竞争对手
     *
     * @param majorCompetitors 分销主要竞争对手
     */
    public void setMajorCompetitors(String majorCompetitors) {
        this.majorCompetitors = majorCompetitors == null ? null : majorCompetitors.trim();
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

    /**
     * 获取价格敏感度
     *
     * @return price_sensitivity - 价格敏感度
     */
    public String getPriceSensitivity() {
        return priceSensitivity;
    }

    /**
     * 设置价格敏感度
     *
     * @param priceSensitivity 价格敏感度
     */
    public void setPriceSensitivity(String priceSensitivity) {
        this.priceSensitivity = priceSensitivity == null ? null : priceSensitivity.trim();
    }

    /**
     * 获取忠诚度
     *
     * @return loyalty - 忠诚度
     */
    public String getLoyalty() {
        return loyalty;
    }

    /**
     * 设置忠诚度
     *
     * @param loyalty 忠诚度
     */
    public void setLoyalty(String loyalty) {
        this.loyalty = loyalty == null ? null : loyalty.trim();
    }

    /**
     * 获取开始合作时间
     *
     * @return start_cooperation_time - 开始合作时间
     */
    public Date getStartCooperationTime() {
        return startCooperationTime;
    }

    /**
     * 设置开始合作时间
     *
     * @param startCooperationTime 开始合作时间
     */
    public void setStartCooperationTime(Date startCooperationTime) {
        this.startCooperationTime = startCooperationTime;
    }

    /**
     * 获取合作持续时间（月）
     *
     * @return cooperation_duration - 合作持续时间（月）
     */
    public Integer getCooperationDuration() {
        return cooperationDuration;
    }

    /**
     * 设置合作持续时间（月）
     *
     * @param cooperationDuration 合作持续时间（月）
     */
    public void setCooperationDuration(Integer cooperationDuration) {
        this.cooperationDuration = cooperationDuration;
    }

    /**
     * 获取采购季节
     *
     * @return purchasing_season - 采购季节
     */
    public String getPurchasingSeason() {
        return purchasingSeason;
    }

    /**
     * 设置采购季节
     *
     * @param purchasingSeason 采购季节
     */
    public void setPurchasingSeason(String purchasingSeason) {
        this.purchasingSeason = purchasingSeason == null ? null : purchasingSeason.trim();
    }

    /**
     * 获取活跃周期
     *
     * @return active_period - 活跃周期
     */
    public String getActivePeriod() {
        return activePeriod;
    }

    /**
     * 设置活跃周期
     *
     * @param activePeriod 活跃周期
     */
    public void setActivePeriod(String activePeriod) {
        this.activePeriod = activePeriod == null ? null : activePeriod.trim();
    }

    /**
     * 获取合作紧密度（福华是否独家供应） 0:否 1:是
     *
     * @return is_fuhua_exclusive - 合作紧密度（福华是否独家供应） 0:否 1:是
     */
    public Byte getIsFuhuaExclusive() {
        return isFuhuaExclusive;
    }

    /**
     * 设置合作紧密度（福华是否独家供应） 0:否 1:是
     *
     * @param isFuhuaExclusive 合作紧密度（福华是否独家供应） 0:否 1:是
     */
    public void setIsFuhuaExclusive(Byte isFuhuaExclusive) {
        this.isFuhuaExclusive = isFuhuaExclusive;
    }

    /**
     * 获取合作情况备注
     *
     * @return cooperation_remark - 合作情况备注
     */
    public String getCooperationRemark() {
        return cooperationRemark;
    }

    /**
     * 设置合作情况备注
     *
     * @param cooperationRemark 合作情况备注
     */
    public void setCooperationRemark(String cooperationRemark) {
        this.cooperationRemark = cooperationRemark == null ? null : cooperationRemark.trim();
    }

    /**
     * 获取生产线
     *
     * @return production_line - 生产线
     */
    public String getProductionLine() {
        return productionLine;
    }

    /**
     * 设置生产线
     *
     * @param productionLine 生产线
     */
    public void setProductionLine(String productionLine) {
        this.productionLine = productionLine == null ? null : productionLine.trim();
    }

    /**
     * 获取时区code
     *
     * @return timezone - 时区code
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * 设置时区code
     *
     * @param timezone 时区code
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone == null ? null : timezone.trim();
    }

    /**
     * 获取客户基本分类code
     *
     * @return custclass - 客户基本分类code
     */
    public String getCustclass() {
        return custclass;
    }

    /**
     * 设置客户基本分类code
     *
     * @param custclass 客户基本分类code
     */
    public void setCustclass(String custclass) {
        this.custclass = custclass == null ? null : custclass.trim();
    }

    /**
     * 获取数据格式code
     *
     * @return formatdoc - 数据格式code
     */
    public String getFormatdoc() {
        return formatdoc;
    }

    /**
     * 设置数据格式code
     *
     * @param formatdoc 数据格式code
     */
    public void setFormatdoc(String formatdoc) {
        this.formatdoc = formatdoc == null ? null : formatdoc.trim();
    }

    /**
     * 获取贸易国别code
     *
     * @return countryzone - 贸易国别code
     */
    public String getCountryzone() {
        return countryzone;
    }

    /**
     * 设置贸易国别code
     *
     * @param countryzone 贸易国别code
     */
    public void setCountryzone(String countryzone) {
        this.countryzone = countryzone == null ? null : countryzone.trim();
    }

    @Override
    public void setId(Integer id) {
        this.customerId = id;
    }

    @Override
    public Integer getId() {
        return this.customerId;
    }
}