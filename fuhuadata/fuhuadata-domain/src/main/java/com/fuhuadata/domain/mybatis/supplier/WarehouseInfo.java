package com.fuhuadata.domain.mybatis.supplier;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fuhuadata.domain.mybatis.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 仓库
 */
@Table(name = "s_warehouse_info")
public class WarehouseInfo extends BaseEntity<Integer>{
    /**
     * 仓库id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * nc仓库编码
     */
    private String code;

    /**
     * 所属组织
     */
    @Column(name = "pk_org")
    private String pkOrg;

    /**
     * 企业全称
     */
    private String name;

    /**
     * 企业简称
     */
    @Column(name = "short_name")
    private String shortName;

    /**
     * 类型，0常规，1非常规，2自定
     */
    private Integer type;

    /**
     * 社会信用代码
     */
    @Column(name = "credit_code")
    private String creditCode;

    /**
     * 注册资金
     */
    @Column(name = "register_fund")
    private BigDecimal registerFund;

    /**
     * 办公地址
     */
    @Column(name = "office_address")
    private String officeAddress;

    /**
     * 企业联系电话
     */
    private String phone;

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
     * 注册地址
     */
    @Column(name = "register_addr")
    private String registerAddr;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 仓库面积
     */
    @Column(name = "warehouse_area")
    private String warehouseArea;

    /**
     * 是否危险，0否，1是
     */
    @Column(name = "is_dangers")
    private Integer isDangers;

    /**
     * 是否内装进港，0否，1是
     */
    @Column(name = "is_Inside_entrance")
    private Integer isInsideEntrance;

    /**
     * 仓库地址
     */
    private String storaddr;

    /**
     * 仓库备注
     */
    private String memo;

    /**
     * 综合评分
     */
    @Column(name = "combined_scoring")
    private BigDecimal combinedScoring;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date modifyTime;

    /**
     * 获取仓库id
     *
     * @return id - 仓库id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置仓库id
     *
     * @param id 仓库id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取nc仓库编码
     *
     * @return code - nc仓库编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置nc仓库编码
     *
     * @param code nc仓库编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取所属组织
     *
     * @return pk_org - 所属组织
     */
    public String getPkOrg() {
        return pkOrg;
    }

    /**
     * 设置所属组织
     *
     * @param pkOrg 所属组织
     */
    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg == null ? null : pkOrg.trim();
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
     * 获取类型，0常规，1非常规，2自定
     *
     * @return type - 类型，0常规，1非常规，2自定
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型，0常规，1非常规，2自定
     *
     * @param type 类型，0常规，1非常规，2自定
     */
    public void setType(Integer type) {
        this.type = type;
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
     * 获取注册资金
     *
     * @return register_fund - 注册资金
     */
    public BigDecimal getRegisterFund() {
        return registerFund;
    }

    /**
     * 设置注册资金
     *
     * @param registerFund 注册资金
     */
    public void setRegisterFund(BigDecimal registerFund) {
        this.registerFund = registerFund;
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
     * @return phone - 企业联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置企业联系电话
     *
     * @param phone 企业联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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
     * 获取注册地址
     *
     * @return register_addr - 注册地址
     */
    public String getRegisterAddr() {
        return registerAddr;
    }

    /**
     * 设置注册地址
     *
     * @param registerAddr 注册地址
     */
    public void setRegisterAddr(String registerAddr) {
        this.registerAddr = registerAddr == null ? null : registerAddr.trim();
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
     * 获取仓库面积
     *
     * @return warehouse_area - 仓库面积
     */
    public String getWarehouseArea() {
        return warehouseArea;
    }

    /**
     * 设置仓库面积
     *
     * @param warehouseArea 仓库面积
     */
    public void setWarehouseArea(String warehouseArea) {
        this.warehouseArea = warehouseArea == null ? null : warehouseArea.trim();
    }

    /**
     * 获取是否危险，0否，1是
     *
     * @return is_dangers - 是否危险，0否，1是
     */
    public Integer getIsDangers() {
        return isDangers;
    }

    /**
     * 设置是否危险，0否，1是
     *
     * @param isDangers 是否危险，0否，1是
     */
    public void setIsDangers(Integer isDangers) {
        this.isDangers = isDangers;
    }

    /**
     * 获取是否内装进港，0否，1是
     *
     * @return is_Inside_entrance - 是否内装进港，0否，1是
     */
    public Integer getIsInsideEntrance() {
        return isInsideEntrance;
    }

    /**
     * 设置是否内装进港，0否，1是
     *
     * @param isInsideEntrance 是否内装进港，0否，1是
     */
    public void setIsInsideEntrance(Integer isInsideEntrance) {
        this.isInsideEntrance = isInsideEntrance;
    }

    /**
     * 获取仓库地址
     *
     * @return storaddr - 仓库地址
     */
    public String getStoraddr() {
        return storaddr;
    }

    /**
     * 设置仓库地址
     *
     * @param storaddr 仓库地址
     */
    public void setStoraddr(String storaddr) {
        this.storaddr = storaddr == null ? null : storaddr.trim();
    }

    /**
     * 获取仓库备注
     *
     * @return memo - 仓库备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置仓库备注
     *
     * @param memo 仓库备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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