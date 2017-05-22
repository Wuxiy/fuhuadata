package com.fuhuadata.domain.supplier;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "s_factory")
public class ProduceFactory extends BaseEntity<Integer> {

    /**
     * 工厂id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * nc主键
     */
    @Column(name = "pk_supplier")
    private String pkSupplier;

    /**
     * 组织code，pk_org
     */
    @Column(name = "pk_org")
    private String pkOrg;

    /**
     * 企业代码
     */
    private String code;

    /**
     * 企业名称，name
     */
    private String name;

    /**
     * 企业简称，shortname
     */
    private String abbr;

    /**
     * 企业曾用名
     */
    @Column(name = "old_name")
    private String oldName;

    /**
     * 注册资金，registerfund
     */
    private BigDecimal registerfund;

    /**
     * 注册地址
     */
    private String address;

    /**
     * nc 供应商银行账号主键，bd_custbank.pk_custbank
     */
    @Column(name = "pk_custbank")
    private String pkCustbank;

    /**
     * 开户银行
     */
    private String bank;

    /**
     * 银行类别
     */
    @Column(name = "bank_class")
    private String bankClass;

    /**
     * 币种
     */
    @Column(name = "currency_code")
    private String currencyCode;

    /**
     * 银行账号
     */
    @Column(name = "bank_account")
    private String bankAccount;

    /**
     * 银行户名
     */
    @Column(name = "bank_username")
    private String bankUsername;

    /**
     * nc 供应商联系人主键, bd_suplinkman.pk_suplinkman
     */
    @Column(name = "pk_suplinkman")
    private String pkSuplinkman;

    /**
     * 联系人
     */
    @Column(name = "link_man")
    private String linkMan;

    /**
     * 联系电话
     */
    @Column(name = "link_phone")
    private String linkPhone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 开始合作时间，第一个订单的时间，后面计算总的合作时间
     */
    @Column(name = "cooperate_time")
    private Date cooperateTime;

    /**
     * 生产许可证
     */
    @Column(name = "production_licenses")
    private String productionLicenses;

    /**
     * 农药登记证
     */
    @Column(name = "pesticide_registration")
    private String pesticideRegistration;

    /**
     * 排污许可证
     */
    @Column(name = "discharge_permit")
    private String dischargePermit;

    /**
     * 工厂管理人员组织code
     */
    @Column(name = "manager_org_code")
    private String managerOrgCode;

    /**
     * 工厂管理人员组织名称
     */
    @Column(name = "manager_org_name")
    private String managerOrgName;

    /**
     * 工厂管理人员部门code
     */
    @Column(name = "manager_dep_code")
    private String managerDepCode;

    /**
     * 工厂管理人员部门名称
     */
    @Column(name = "manager_dep_name")
    private String managerDepName;

    /**
     * 工厂管理人员code
     */
    @Column(name = "manager_code")
    private String managerCode;

    /**
     * 工厂管理人员
     */
    private String manager;

    /**
     * 综合评分
     */
    private BigDecimal score;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建者账号
     */
    @Column(name = "create_account")
    private String createAccount;

    /**
     * 创建者姓名
     */
    @Column(name = "create_name")
    private String createName;

    /**
     * 上一次修改者id
     */
    @Column(name = "modify_account")
    private String modifyAccount;

    /**
     * 上一次修改者姓名
     */
    @Column(name = "modify_name")
    private String modifyName;

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
     * 获取工厂id
     *
     * @return id - 工厂id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置工厂id
     *
     * @param id 工厂id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取nc主键
     *
     * @return pk_supplier - nc主键
     */
    public String getPkSupplier() {
        return pkSupplier;
    }

    /**
     * 设置nc主键
     *
     * @param pkSupplier nc主键
     */
    public void setPkSupplier(String pkSupplier) {
        this.pkSupplier = pkSupplier == null ? null : pkSupplier.trim();
    }

    /**
     * 获取组织code，pk_org
     *
     * @return pk_org - 组织code，pk_org
     */
    public String getPkOrg() {
        return pkOrg;
    }

    /**
     * 设置组织code，pk_org
     *
     * @param pkOrg 组织code，pk_org
     */
    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg == null ? null : pkOrg.trim();
    }

    /**
     * 获取企业代码
     *
     * @return code - 企业代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置企业代码
     *
     * @param code 企业代码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取企业名称，name
     *
     * @return name - 企业名称，name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置企业名称，name
     *
     * @param name 企业名称，name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取企业简称，shortname
     *
     * @return abbr - 企业简称，shortname
     */
    public String getAbbr() {
        return abbr;
    }

    /**
     * 设置企业简称，shortname
     *
     * @param abbr 企业简称，shortname
     */
    public void setAbbr(String abbr) {
        this.abbr = abbr == null ? null : abbr.trim();
    }

    /**
     * 获取企业曾用名
     *
     * @return old_name - 企业曾用名
     */
    public String getOldName() {
        return oldName;
    }

    /**
     * 设置企业曾用名
     *
     * @param oldName 企业曾用名
     */
    public void setOldName(String oldName) {
        this.oldName = oldName == null ? null : oldName.trim();
    }

    /**
     * 获取注册资金，registerfund
     *
     * @return registerfund - 注册资金，registerfund
     */
    public BigDecimal getRegisterfund() {
        return registerfund;
    }

    /**
     * 设置注册资金，registerfund
     *
     * @param registerfund 注册资金，registerfund
     */
    public void setRegisterfund(BigDecimal registerfund) {
        this.registerfund = registerfund;
    }

    /**
     * 获取注册地址
     *
     * @return address - 注册地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置注册地址
     *
     * @param address 注册地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取nc 供应商银行账号主键，bd_custbank.pk_custbank
     *
     * @return pk_custbank - nc 供应商银行账号主键，bd_custbank.pk_custbank
     */
    public String getPkCustbank() {
        return pkCustbank;
    }

    /**
     * 设置nc 供应商银行账号主键，bd_custbank.pk_custbank
     *
     * @param pkCustbank nc 供应商银行账号主键，bd_custbank.pk_custbank
     */
    public void setPkCustbank(String pkCustbank) {
        this.pkCustbank = pkCustbank == null ? null : pkCustbank.trim();
    }

    /**
     * 获取开户银行
     *
     * @return bank - 开户银行
     */
    public String getBank() {
        return bank;
    }

    /**
     * 设置开户银行
     *
     * @param bank 开户银行
     */
    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    /**
     * 获取银行类别
     *
     * @return bank_class - 银行类别
     */
    public String getBankClass() {
        return bankClass;
    }

    /**
     * 设置银行类别
     *
     * @param bankClass 银行类别
     */
    public void setBankClass(String bankClass) {
        this.bankClass = bankClass == null ? null : bankClass.trim();
    }

    /**
     * 获取币种
     *
     * @return currency_code - 币种
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * 设置币种
     *
     * @param currencyCode 币种
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode == null ? null : currencyCode.trim();
    }

    /**
     * 获取银行账号
     *
     * @return bank_account - 银行账号
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * 设置银行账号
     *
     * @param bankAccount 银行账号
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    /**
     * 获取银行户名
     *
     * @return bank_username - 银行户名
     */
    public String getBankUsername() {
        return bankUsername;
    }

    /**
     * 设置银行户名
     *
     * @param bankUsername 银行户名
     */
    public void setBankUsername(String bankUsername) {
        this.bankUsername = bankUsername == null ? null : bankUsername.trim();
    }

    /**
     * 获取nc 供应商联系人主键, bd_suplinkman.pk_suplinkman
     *
     * @return pk_suplinkman - nc 供应商联系人主键, bd_suplinkman.pk_suplinkman
     */
    public String getPkSuplinkman() {
        return pkSuplinkman;
    }

    /**
     * 设置nc 供应商联系人主键, bd_suplinkman.pk_suplinkman
     *
     * @param pkSuplinkman nc 供应商联系人主键, bd_suplinkman.pk_suplinkman
     */
    public void setPkSuplinkman(String pkSuplinkman) {
        this.pkSuplinkman = pkSuplinkman == null ? null : pkSuplinkman.trim();
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
     * 获取开始合作时间，第一个订单的时间，后面计算总的合作时间
     *
     * @return cooperate_time - 开始合作时间，第一个订单的时间，后面计算总的合作时间
     */
    public Date getCooperateTime() {
        return cooperateTime;
    }

    /**
     * 设置开始合作时间，第一个订单的时间，后面计算总的合作时间
     *
     * @param cooperateTime 开始合作时间，第一个订单的时间，后面计算总的合作时间
     */
    public void setCooperateTime(Date cooperateTime) {
        this.cooperateTime = cooperateTime;
    }

    /**
     * 获取生产许可证
     *
     * @return production_licenses - 生产许可证
     */
    public String getProductionLicenses() {
        return productionLicenses;
    }

    /**
     * 设置生产许可证
     *
     * @param productionLicenses 生产许可证
     */
    public void setProductionLicenses(String productionLicenses) {
        this.productionLicenses = productionLicenses == null ? null : productionLicenses.trim();
    }

    /**
     * 获取农药登记证
     *
     * @return pesticide_registration - 农药登记证
     */
    public String getPesticideRegistration() {
        return pesticideRegistration;
    }

    /**
     * 设置农药登记证
     *
     * @param pesticideRegistration 农药登记证
     */
    public void setPesticideRegistration(String pesticideRegistration) {
        this.pesticideRegistration = pesticideRegistration == null ? null : pesticideRegistration.trim();
    }

    /**
     * 获取排污许可证
     *
     * @return discharge_permit - 排污许可证
     */
    public String getDischargePermit() {
        return dischargePermit;
    }

    /**
     * 设置排污许可证
     *
     * @param dischargePermit 排污许可证
     */
    public void setDischargePermit(String dischargePermit) {
        this.dischargePermit = dischargePermit == null ? null : dischargePermit.trim();
    }

    /**
     * 获取工厂管理人员组织code
     *
     * @return manager_org_code - 工厂管理人员组织code
     */
    public String getManagerOrgCode() {
        return managerOrgCode;
    }

    /**
     * 设置工厂管理人员组织code
     *
     * @param managerOrgCode 工厂管理人员组织code
     */
    public void setManagerOrgCode(String managerOrgCode) {
        this.managerOrgCode = managerOrgCode == null ? null : managerOrgCode.trim();
    }

    /**
     * 获取工厂管理人员组织名称
     *
     * @return manager_org_name - 工厂管理人员组织名称
     */
    public String getManagerOrgName() {
        return managerOrgName;
    }

    /**
     * 设置工厂管理人员组织名称
     *
     * @param managerOrgName 工厂管理人员组织名称
     */
    public void setManagerOrgName(String managerOrgName) {
        this.managerOrgName = managerOrgName == null ? null : managerOrgName.trim();
    }

    /**
     * 获取工厂管理人员部门code
     *
     * @return manager_dep_code - 工厂管理人员部门code
     */
    public String getManagerDepCode() {
        return managerDepCode;
    }

    /**
     * 设置工厂管理人员部门code
     *
     * @param managerDepCode 工厂管理人员部门code
     */
    public void setManagerDepCode(String managerDepCode) {
        this.managerDepCode = managerDepCode == null ? null : managerDepCode.trim();
    }

    /**
     * 获取工厂管理人员部门名称
     *
     * @return manager_dep_name - 工厂管理人员部门名称
     */
    public String getManagerDepName() {
        return managerDepName;
    }

    /**
     * 设置工厂管理人员部门名称
     *
     * @param managerDepName 工厂管理人员部门名称
     */
    public void setManagerDepName(String managerDepName) {
        this.managerDepName = managerDepName == null ? null : managerDepName.trim();
    }

    /**
     * 获取工厂管理人员code
     *
     * @return manager_code - 工厂管理人员code
     */
    public String getManagerCode() {
        return managerCode;
    }

    /**
     * 设置工厂管理人员code
     *
     * @param managerCode 工厂管理人员code
     */
    public void setManagerCode(String managerCode) {
        this.managerCode = managerCode == null ? null : managerCode.trim();
    }

    /**
     * 获取工厂管理人员
     *
     * @return manager - 工厂管理人员
     */
    public String getManager() {
        return manager;
    }

    /**
     * 设置工厂管理人员
     *
     * @param manager 工厂管理人员
     */
    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    /**
     * 获取综合评分
     *
     * @return score - 综合评分
     */
    public BigDecimal getScore() {
        return score;
    }

    /**
     * 设置综合评分
     *
     * @param score 综合评分
     */
    public void setScore(BigDecimal score) {
        this.score = score;
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
     * 获取创建者账号
     *
     * @return create_account - 创建者账号
     */
    public String getCreateAccount() {
        return createAccount;
    }

    /**
     * 设置创建者账号
     *
     * @param createAccount 创建者账号
     */
    public void setCreateAccount(String createAccount) {
        this.createAccount = createAccount == null ? null : createAccount.trim();
    }

    /**
     * 获取创建者姓名
     *
     * @return create_name - 创建者姓名
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * 设置创建者姓名
     *
     * @param createName 创建者姓名
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    /**
     * 获取上一次修改者id
     *
     * @return modify_account - 上一次修改者id
     */
    public String getModifyAccount() {
        return modifyAccount;
    }

    /**
     * 设置上一次修改者id
     *
     * @param modifyAccount 上一次修改者id
     */
    public void setModifyAccount(String modifyAccount) {
        this.modifyAccount = modifyAccount == null ? null : modifyAccount.trim();
    }

    /**
     * 获取上一次修改者姓名
     *
     * @return modify_name - 上一次修改者姓名
     */
    public String getModifyName() {
        return modifyName;
    }

    /**
     * 设置上一次修改者姓名
     *
     * @param modifyName 上一次修改者姓名
     */
    public void setModifyName(String modifyName) {
        this.modifyName = modifyName == null ? null : modifyName.trim();
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