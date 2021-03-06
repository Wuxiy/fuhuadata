package com.fuhuadata.domain.mybatis.supplier;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fuhuadata.domain.common.BankAccBas;
import com.fuhuadata.domain.mybatis.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *  货代
 */
@Table(name = "s_freight_forwarding")
public class FreightForwarding extends BaseEntity<Integer>{
    /**
     * 货代id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * nc货代编码
     */
    private String code;

    /**
     * 基本分类
     */
    @Column(name = "pk_supplierclass")
    private String pkSupplierclass;

    /**
     * 所属组织
     */
    @Column(name="pk_org")
    private String pkOrg;

    /**
     * 企业全称
     */
    private String name;

    /**
     * 企业简称
     */
    private String shortname;

    /**
     * 类型，0常规，1非常规，2自定
     */
    private Integer supprop;

    /**
     * 社会信用代码
     */
    @Column(name = "credit_code")
    private String creditCode;

    /**
     * 办公地址
     */
    @Column(name = "office_address")
    private String officeAddress;

    /**
     * 企业联系电话
     */
    private String tel1;

    /**
     * 合作时间
     */
    @Column(name = "cooperate_time")
    private Integer cooperateTime;

    /**
     * 开始合作时间
     */
    @Column(name = "start_cooperate_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startCooperateTime;

    /**
     * 注册资金
     */
    private BigDecimal registerfund;

    /**
     * 联系人
     */
    @Transient
    @Column(name = "link_man")
    private String linkMan;

    /**
     * 联系电话
     */
    @Transient
    private String linkPhone;

    /**
     * 邮箱
     */
    @Transient
    private String email;

    /**
     * 注册地址
     */
    private String corpaddress;

    /**
     * 运输方式，方式id的json数组
     */
    @Column(name = "transportation_methods")
    private String transportationMethods;

    /**
     * 货代备注
     */
    private String memo;

    /**
     * 营业执照
     */
    @Column(name = "business_licence")
    private String businessLicence;

    /**
     * 经营资格登记证
     */
    @Column(name = "registration_certificate")
    private String registrationCertificate;

    /**
     * 无船承运业务经营资格登记证
     */
    @Column(name = "NVOCC")
    private String nvocc;

    /**
     * 是否进入电子系统 1：是 0 ：否
     */
    @Column(name = "enter_electronic_system")
    private Integer enterElectronicSystem;

    /**
     * 综合评分
     */
    @Column(name = "combined_scoring")
    private BigDecimal combinedScoring;

    /**
     * 创建者id
     */
    @Column(name = "creator")
    private Integer creator;

    /**
     * 创建者姓名
     */
    @Column(name = "create_user_name")
    private String createUserName;

    /**
     * 上一次修改者id
     */
    @Column(name = "modifier")
    private Integer modifier;
    /**
     * 上一次修改者姓名
     */
    @Column(name = "lastmodify_user_name")
    private String lastmodifyUserName;
    /**
     * 创建时间
     */
    @Column(name = "creationtime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creationtime;

    /**
     * 修改时间
     */
    @Column(name = "modifiedtime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedtime;

    /**
     * 自定义字段
     */
    @Column(name = "custom_field")
    private String customField;

    /**
     * 详情联系人
     */
    @Transient
    private List<SupplierLinkman> linkmen;

    /**
     * 银行账户
     */
    @Transient
    private List<BankAccBas> bankAccBass;

    /**
     * 仓库名称
     */
    @Transient
    private String warehouseName;

    /**
     * 获取货代id
     *
     * @return id - 货代id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置货代id
     *
     * @param id 货代id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取nc货代编码
     *
     * @return code - nc货代编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置nc货代编码
     *
     * @param code nc货代编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取所属组织
     *
     * @return pk_supplierclass - 所属组织
     */
    public String getPkSupplierclass() {
        return pkSupplierclass;
    }

    /**
     * 设置所属组织
     *
     * @param pkSupplierclass 所属组织
     */
    public void setPkSupplierclass(String pkSupplierclass) {
        this.pkSupplierclass = pkSupplierclass == null ? null : pkSupplierclass.trim();
    }

    /**
     * 获取企业全称
     *
     * @return name - 企业全称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置企业全称
     *
     * @param name 企业全称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取企业简称
     *
     * @return shortname - 企业简称
     */
    public String getShortname() {
        return shortname;
    }

    /**
     * 设置企业简称
     *
     * @param shortname 企业简称
     */
    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }

    /**
     * 获取类型，0常规，1非常规，2自定
     *
     * @return supprop - 类型，0常规，1非常规，2自定
     */
    public Integer getSupprop() {
        return supprop;
    }

    /**
     * 设置类型，0常规，1非常规，2自定
     *
     * @param supprop 类型，0常规，1非常规，2自定
     */
    public void setSupprop(Integer supprop) {
        this.supprop = supprop;
    }

    /**
     * 获取社会信用代码
     *
     * @return credit_code - 社会信用代码
     */
    public String getCreditCode() {
        return creditCode;
    }

    /**
     * 设置社会信用代码
     *
     * @param creditCode 社会信用代码
     */
    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode == null ? null : creditCode.trim();
    }

    /**
     * 获取办公地址
     *
     * @return office_address - 办公地址
     */
    public String getOfficeAddress() {
        return officeAddress;
    }

    /**
     * 设置办公地址
     *
     * @param officeAddress 办公地址
     */
    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress == null ? null : officeAddress.trim();
    }

    /**
     * 获取企业联系电话
     *
     * @return tel1 - 企业联系电话
     */
    public String getTel1() {
        return tel1;
    }

    /**
     * 设置企业联系电话
     *
     * @param tel1 企业联系电话
     */
    public void setTel1(String tel1) {
        this.tel1 = tel1 == null ? null : tel1.trim();
    }

    /**
     * 获取注册资金
     *
     * @return registerfund - 注册资金
     */
    public BigDecimal getRegisterfund() {
        return registerfund;
    }

    /**
     * 设置注册资金
     *
     * @param registerfund 注册资金
     */
    public void setRegisterfund(BigDecimal registerfund) {
        this.registerfund = registerfund;
    }

    /**
     * 获取联系人
     *
     * @return link_man - 联系人
     */
    public String getLinkMan() {
        return linkMan;
    }

    /**
     * 设置联系人
     *
     * @param linkMan 联系人
     */
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    /**
     * 获取联系电话
     *
     * @return link_phone - 联系电话
     */
    public String getLinkPhone() {
        return linkPhone;
    }

    /**
     * 设置联系电话
     *
     * @param linkPhone 联系电话
     */
    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
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
     * 获取注册地址
     *
     * @return corpaddress - 注册地址
     */
    public String getCorpaddress() {
        return corpaddress;
    }

    /**
     * 设置注册地址
     *
     * @param corpaddress 注册地址
     */
    public void setCorpaddress(String corpaddress) {
        this.corpaddress = corpaddress == null ? null : corpaddress.trim();
    }

    /**
     * 获取运输方式，方式id的json数组
     *
     * @return transportation_methods - 运输方式，方式id的json数组
     */
    public String getTransportationMethods() {
        return transportationMethods;
    }

    /**
     * 设置运输方式，方式id的json数组
     *
     * @param transportationMethods 运输方式，方式id的json数组
     */
    public void setTransportationMethods(String transportationMethods) {
        this.transportationMethods = transportationMethods == null ? null : transportationMethods.trim();
    }

    /**
     * 获取货代备注
     *
     * @return memo - 货代备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置货代备注
     *
     * @param memo 货代备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * 获取营业执照
     *
     * @return business_licence - 营业执照
     */
    public String getBusinessLicence() {
        return businessLicence;
    }

    /**
     * 设置营业执照
     *
     * @param businessLicence 营业执照
     */
    public void setBusinessLicence(String businessLicence) {
        this.businessLicence = businessLicence == null ? null : businessLicence.trim();
    }

    /**
     * 获取经营资格登记证
     *
     * @return registration_certificate - 经营资格登记证
     */
    public String getRegistrationCertificate() {
        return registrationCertificate;
    }

    /**
     * 设置经营资格登记证
     *
     * @param registrationCertificate 经营资格登记证
     */
    public void setRegistrationCertificate(String registrationCertificate) {
        this.registrationCertificate = registrationCertificate == null ? null : registrationCertificate.trim();
    }

    /**
     * 获取无船承运业务经营资格登记证
     *
     * @return NVOCC - 无船承运业务经营资格登记证
     */
    public String getNvocc() {
        return nvocc;
    }

    /**
     * 设置无船承运业务经营资格登记证
     *
     * @param nvocc 无船承运业务经营资格登记证
     */
    public void setNvocc(String nvocc) {
        this.nvocc = nvocc == null ? null : nvocc.trim();
    }

    /**
     * 获取是否进入电子系统 1：是 0 ：否
     *
     * @return enter_electronic_system - 是否进入电子系统 1：是 0 ：否
     */
    public Integer getEnterElectronicSystem() {
        return enterElectronicSystem;
    }

    /**
     * 设置是否进入电子系统 1：是 0 ：否
     *
     * @param enterElectronicSystem 是否进入电子系统 1：是 0 ：否
     */
    public void setEnterElectronicSystem(Integer enterElectronicSystem) {
        this.enterElectronicSystem = enterElectronicSystem;
    }

    /**
     * 获取综合评分
     *
     * @return combined_scoring - 综合评分
     */
    public BigDecimal getCombinedScoring() {
        return combinedScoring;
    }

    /**
     * 设置综合评分
     *
     * @param combinedScoring 综合评分
     */
    public void setCombinedScoring(BigDecimal combinedScoring) {
        this.combinedScoring = combinedScoring;
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
     * 获取自定义字段
     *
     * @return custom_field - 自定义字段
     */
    public String getCustomField() {
        return customField;
    }

    /**
     * 设置自定义字段
     *
     * @param customField 自定义字段
     */
    public void setCustomField(String customField) {
        this.customField = customField == null ? null : customField.trim();
    }

    public List<SupplierLinkman> getLinkmen() {
        return linkmen;
    }

    public void setLinkmen(List<SupplierLinkman> linkmen) {
        this.linkmen = linkmen;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Integer getCooperateTime() {
        return cooperateTime;
    }

    public void setCooperateTime(Integer cooperateTime) {
        this.cooperateTime = cooperateTime;
    }

    public Date getStartCooperateTime() {
        return startCooperateTime;
    }

    public void setStartCooperateTime(Date startCooperateTime) {
        this.startCooperateTime = startCooperateTime;
    }

    public List<BankAccBas> getBankAccBass() {
        return bankAccBass;
    }

    public void setBankAccBass(List<BankAccBas> bankAccBass) {
        this.bankAccBass = bankAccBass;
    }

    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    public Integer getModifier() {
        return modifier;
    }

    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg;
    }
}