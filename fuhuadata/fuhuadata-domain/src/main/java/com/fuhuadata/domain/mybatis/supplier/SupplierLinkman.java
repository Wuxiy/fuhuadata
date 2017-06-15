package com.fuhuadata.domain.mybatis.supplier;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * 供应商联系人
 */
@Table(name = "s_supplier_linkman")
public class SupplierLinkman extends BaseEntity<Integer>{
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * nc联系人主键
     */
    @Column(name = "pk_linkman")
    private String pkLinkman;

    /**
     * 供应商类型 0：加工厂 1：货代  2：仓库
     */
    @Column(name = "supplier_type")
    private Integer supplierType;

    /**
     * 供应商id
     */
    @Column(name = "suppier_id")
    private Integer suppierId;

    /**
     * 联系人编码
     */
    private String code;

    /**
     * 联系人姓名
     */
    private String name;

    /**
     * 手机
     */
    private String cell;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 职位
     */
    private String vjob;

    /**
     * 是否默认 0：否 1：是
     */
    private Integer isdefault;

    /**
     * 通讯地址
     */
    private String address;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 传真
     */
    private String tax;

    /**
     * 邮编
     */
    private String postcode;

    /**
     * 其他备注信息
     */
    private String meno;

    /**
     * 删除状态：0=删除
     */
    private Integer deletedStatus;

    /**
     * 创建者id
     */
    private String creator;

    /**
     * 创建者姓名
     */
    @Column(name = "create_user_name")
    private String createUserName;

    /**
     * 上一次修改者id
     */
    private String modifier;

    /**
     * 上一次修改者姓名
     */
    @Column(name = "lastmodify_user_name")
    private String lastmodifyUserName;

    /**
     * 创建时间
     */
    private Date creationtime;

    /**
     * 修改时间
     */
    private Date modifiedtime;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取nc联系人主键
     *
     * @return pk_linkman - nc联系人主键
     */
    public String getPkLinkman() {
        return pkLinkman;
    }

    /**
     * 设置nc联系人主键
     *
     * @param pkLinkman nc联系人主键
     */
    public void setPkLinkman(String pkLinkman) {
        this.pkLinkman = pkLinkman == null ? null : pkLinkman.trim();
    }

    /**
     * 获取供应商类型 0：加工厂 1：货代  2：仓库
     *
     * @return supplier_type - 供应商类型 0：加工厂 1：货代  2：仓库
     */
    public Integer getSupplierType() {
        return supplierType;
    }

    /**
     * 设置供应商类型 0：加工厂 1：货代  2：仓库
     *
     * @param supplierType 供应商类型 0：加工厂 1：货代  2：仓库
     */
    public void setSupplierType(Integer supplierType) {
        this.supplierType = supplierType;
    }

    /**
     * 获取供应商id
     *
     * @return suppier_id - 供应商id
     */
    public Integer getSuppierId() {
        return suppierId;
    }

    /**
     * 设置供应商id
     *
     * @param suppierId 供应商id
     */
    public void setSuppierId(Integer suppierId) {
        this.suppierId = suppierId;
    }

    /**
     * 获取联系人编码
     *
     * @return code - 联系人编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置联系人编码
     *
     * @param code 联系人编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取联系人姓名
     *
     * @return name - 联系人姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置联系人姓名
     *
     * @param name 联系人姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取手机
     *
     * @return cell - 手机
     */
    public String getCell() {
        return cell;
    }

    /**
     * 设置手机
     *
     * @param cell 手机
     */
    public void setCell(String cell) {
        this.cell = cell == null ? null : cell.trim();
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
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取职位
     *
     * @return vjob - 职位
     */
    public String getVjob() {
        return vjob;
    }

    /**
     * 设置职位
     *
     * @param vjob 职位
     */
    public void setVjob(String vjob) {
        this.vjob = vjob == null ? null : vjob.trim();
    }

    /**
     * 获取是否默认 0：否 1：是
     *
     * @return isdefault - 是否默认 0：否 1：是
     */
    public Integer getIsdefault() {
        return isdefault;
    }

    /**
     * 设置是否默认 0：否 1：是
     *
     * @param isdefault 是否默认 0：否 1：是
     */
    public void setIsdefault(Integer isdefault) {
        this.isdefault = isdefault;
    }

    /**
     * 获取通讯地址
     *
     * @return address - 通讯地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置通讯地址
     *
     * @param address 通讯地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    /**
     * 获取传真
     *
     * @return tax - 传真
     */
    public String getTax() {
        return tax;
    }

    /**
     * 设置传真
     *
     * @param tax 传真
     */
    public void setTax(String tax) {
        this.tax = tax == null ? null : tax.trim();
    }

    /**
     * 获取邮编
     *
     * @return postcode - 邮编
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * 设置邮编
     *
     * @param postcode 邮编
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    /**
     * 获取其他备注信息
     *
     * @return meno - 其他备注信息
     */
    public String getMeno() {
        return meno;
    }

    /**
     * 设置其他备注信息
     *
     * @param meno 其他备注信息
     */
    public void setMeno(String meno) {
        this.meno = meno == null ? null : meno.trim();
    }

    /**
     * 获取创建者id
     *
     * @return creator - 创建者id
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建者id
     *
     * @param creator 创建者id
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
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
     * @return modifier - 上一次修改者id
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置上一次修改者id
     *
     * @param modifier 上一次修改者id
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
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

    public Integer getDeletedStatus() {
        return deletedStatus;
    }

    public void setDeletedStatus(Integer deletedStatus) {
        this.deletedStatus = deletedStatus;
    }
}