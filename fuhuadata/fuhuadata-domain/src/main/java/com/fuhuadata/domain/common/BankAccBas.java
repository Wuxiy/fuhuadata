package com.fuhuadata.domain.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.*;
import java.beans.IntrospectionException;
import java.util.Date;

/**
 * 银行账户
 */
@Table(name = "s_bankaccbas")
public class BankAccBas extends BaseEntity<Integer> {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * nc主键
     */
    @Column(name = "pk_bankaccbas")
    private String pkBankaccbas;

    /**
     * 客户id, acctype=0时关联s_factory.id
     */
    @Column(name = "customer_id")
    private Integer customerId;

    /**
     * 开户银行, t_bankdoc.pk_bankdoc
     */
    @Column(name = "pk_bankdoc")
    private String pkBankdoc;

    /**
     * 开户银行名称
     */
    @Transient
    private String bankDocName;

    /**
     * 银行类别, t_backtype.pk_banktype
     */
    @Column(name = "pk_banktype")
    private String pkBanktype;

    /**
     * 银行类别名称
     */
    @Transient
    private String bankTypeName;

    /**
     * 集团
     */
    @Column(name = "pk_group")
    private String pkGroup;

    /**
     * 组织, p_organization.nc_id
     */
    @Column(name = "pk_org")
    private String pkOrg;

    /**
     * 币种, t_currtype.pk_currtype
     */
    @Column(name = "pk_currtype")
    private String pkCurrtype;

    /**
     * 币种名称
     */
    @Transient
    private String currtypeName;

    /**
     * 名称
     */
    private String name;

    /**
     * 户名, nc.accname
     */
    private String accname;

    /**
     * 账号, nc.accnum
     */
    private String accnum;

    /**
     * 开户日期, nc.accopendate
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date accopendate;

    /**
     * 账户类型: 0=加工厂
     */
    private Short acctype;

    /**
     * 账户性质: 0=公司，1=个人
     */
    private Short accountproperty;

    /**
     * 账户状态: 0=正常，1=冻结，2=部分冻结，3=销户
     */
    private Short accstate;

    /**
     * 删除状态：0=删除，1=正常
     */
    @Transient
    private Integer deletedStatus;

    /**
     * 所在地
     */
    private String address;

    /**
     * 启用状态
     */
    private Short enablestate;

    /**
     * 助记码
     */
    private String mnecode;

    /**
     * 创建时间
     */
    private Date creationtime;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改时间
     */
    private Date modifiedtime;

    /**
     * 修改人
     */
    private String modifier;

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
     * 获取nc主键
     *
     * @return pk_bankaccbas - nc主键
     */
    public String getPkBankaccbas() {
        return pkBankaccbas;
    }

    /**
     * 设置nc主键
     *
     * @param pkBankaccbas nc主键
     */
    public void setPkBankaccbas(String pkBankaccbas) {
        this.pkBankaccbas = pkBankaccbas == null ? null : pkBankaccbas.trim();
    }

    /**
     * 获取开户银行, t_bankdoc.pk_bankdoc
     *
     * @return pk_bankdoc - 开户银行, t_bankdoc.pk_bankdoc
     */
    public String getPkBankdoc() {
        return pkBankdoc;
    }

    /**
     * 设置开户银行, t_bankdoc.pk_bankdoc
     *
     * @param pkBankdoc 开户银行, t_bankdoc.pk_bankdoc
     */
    public void setPkBankdoc(String pkBankdoc) {
        this.pkBankdoc = pkBankdoc == null ? null : pkBankdoc.trim();
    }

    /**
     * 获取银行类别, t_backtype.pk_banktype
     *
     * @return pk_banktype - 银行类别, t_backtype.pk_banktype
     */
    public String getPkBanktype() {
        return pkBanktype;
    }

    /**
     * 设置银行类别, t_backtype.pk_banktype
     *
     * @param pkBanktype 银行类别, t_backtype.pk_banktype
     */
    public void setPkBanktype(String pkBanktype) {
        this.pkBanktype = pkBanktype == null ? null : pkBanktype.trim();
    }

    /**
     * 获取集团
     *
     * @return pk_group - 集团
     */
    public String getPkGroup() {
        return pkGroup;
    }

    /**
     * 设置集团
     *
     * @param pkGroup 集团
     */
    public void setPkGroup(String pkGroup) {
        this.pkGroup = pkGroup == null ? null : pkGroup.trim();
    }

    /**
     * 获取组织, p_organization.nc_id
     *
     * @return pk_org - 组织, p_organization.nc_id
     */
    public String getPkOrg() {
        return pkOrg;
    }

    /**
     * 设置组织, p_organization.nc_id
     *
     * @param pkOrg 组织, p_organization.nc_id
     */
    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg == null ? null : pkOrg.trim();
    }

    /**
     * 获取币种, t_currtype.pk_currtype
     *
     * @return pk_currtype - 币种, t_currtype.pk_currtype
     */
    public String getPkCurrtype() {
        return pkCurrtype;
    }

    /**
     * 设置币种, t_currtype.pk_currtype
     *
     * @param pkCurrtype 币种, t_currtype.pk_currtype
     */
    public void setPkCurrtype(String pkCurrtype) {
        this.pkCurrtype = pkCurrtype == null ? null : pkCurrtype.trim();
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取户名, nc.accname
     *
     * @return accname - 户名, nc.accname
     */
    public String getAccname() {
        return accname;
    }

    /**
     * 设置户名, nc.accname
     *
     * @param accname 户名, nc.accname
     */
    public void setAccname(String accname) {
        this.accname = accname == null ? null : accname.trim();
    }

    /**
     * 获取账号, nc.accnum
     *
     * @return accnum - 账号, nc.accnum
     */
    public String getAccnum() {
        return accnum;
    }

    /**
     * 设置账号, nc.accnum
     *
     * @param accnum 账号, nc.accnum
     */
    public void setAccnum(String accnum) {
        this.accnum = accnum == null ? null : accnum.trim();
    }

    /**
     * 获取开户日期, nc.accopendate
     *
     * @return accopendate - 开户日期, nc.accopendate
     */
    public Date getAccopendate() {
        return accopendate;
    }

    /**
     * 设置开户日期, nc.accopendate
     *
     * @param accopendate 开户日期, nc.accopendate
     */
    public void setAccopendate(Date accopendate) {
        this.accopendate = accopendate;
    }

    /**
     * 获取账户类型: 0=加工厂
     *
     * @return acctype - 账户类型: 0=加工厂
     */
    public Short getAcctype() {
        return acctype;
    }

    /**
     * 设置账户类型: 0=加工厂
     *
     * @param acctype 账户类型: 0=加工厂
     */
    public void setAcctype(Short acctype) {
        this.acctype = acctype;
    }

    /**
     * 获取账户性质: 0=公司，1=个人
     *
     * @return accountproperty - 账户性质: 0=公司，1=个人
     */
    public Short getAccountproperty() {
        return accountproperty;
    }

    /**
     * 设置账户性质: 0=公司，1=个人
     *
     * @param accountproperty 账户性质: 0=公司，1=个人
     */
    public void setAccountproperty(Short accountproperty) {
        this.accountproperty = accountproperty;
    }

    /**
     * 获取账户状态: 0=正常，1=冻结，2=部分冻结，3=销户
     *
     * @return accstate - 账户状态: 0=正常，1=冻结，2=部分冻结，3=销户
     */
    public Short getAccstate() {
        return accstate;
    }

    /**
     * 设置账户状态: 0=正常，1=冻结，2=部分冻结，3=销户
     *
     * @param accstate 账户状态: 0=正常，1=冻结，2=部分冻结，3=销户
     */
    public void setAccstate(Short accstate) {
        this.accstate = accstate;
    }

    /**
     * 获取所在地
     *
     * @return address - 所在地
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置所在地
     *
     * @param address 所在地
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取启用状态
     *
     * @return enablestate - 启用状态
     */
    public Short getEnablestate() {
        return enablestate;
    }

    /**
     * 设置启用状态
     *
     * @param enablestate 启用状态
     */
    public void setEnablestate(Short enablestate) {
        this.enablestate = enablestate;
    }

    /**
     * 获取助记码
     *
     * @return mnecode - 助记码
     */
    public String getMnecode() {
        return mnecode;
    }

    /**
     * 设置助记码
     *
     * @param mnecode 助记码
     */
    public void setMnecode(String mnecode) {
        this.mnecode = mnecode == null ? null : mnecode.trim();
    }

    /**
     * 获取创建时间
     *
     * @return creationtime - 创建时间
     */
    public Date getCreationtime() {
        return creationtime;
    }

    /**
     * 设置创建时间
     *
     * @param creationtime 创建时间
     */
    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 获取修改时间
     *
     * @return modifiedtime - 修改时间
     */
    public Date getModifiedtime() {
        return modifiedtime;
    }

    /**
     * 设置修改时间
     *
     * @param modifiedtime 修改时间
     */
    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    /**
     * 获取修改人
     *
     * @return modifier - 修改人
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置修改人
     *
     * @param modifier 修改人
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getBankDocName() {
        return bankDocName;
    }

    public void setBankDocName(String bankDocName) {
        this.bankDocName = bankDocName;
    }

    public String getBankTypeName() {
        return bankTypeName;
    }

    public void setBankTypeName(String bankTypeName) {
        this.bankTypeName = bankTypeName;
    }

    public String getCurrtypeName() {
        return currtypeName;
    }

    public void setCurrtypeName(String currtypeName) {
        this.currtypeName = currtypeName;
    }

    public static void main(String[] args) throws IntrospectionException {
        printProperties(BankAccBas.class, "bab.");
    }

    public Integer getDeletedStatus() {
        return deletedStatus;
    }

    public void setDeletedStatus(Integer deletedStatus) {
        this.deletedStatus = deletedStatus;
    }
}