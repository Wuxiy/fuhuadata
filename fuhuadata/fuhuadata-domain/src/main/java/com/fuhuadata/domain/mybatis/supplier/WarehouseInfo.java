package com.fuhuadata.domain.mybatis.supplier;

import com.fuhuadata.domain.mybatis.BaseEntity;

import java.math.BigDecimal;
import javax.persistence.*;

/**
 * 仓库
 */
@Table(name = "s_warehouse_info")
public class WarehouseInfo extends BaseEntity<Integer>{
    /**
     * crm主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 仓库主键
     */
    @Column(name = "PK_STORDOC")
    private String pkStordoc;

    /**
     * 仓库编码
     */
    @Column(name = "CODE")
    private String code;

    /**
     * 创建时间
     */
    @Column(name = "CREATIONTIME")
    private String creationtime;

    /**
     * 创建人
     */
    @Column(name = "CREATOR")
    private String creator;


    /**
     * 分布式
     */
    @Column(name = "DATAORIGINFLAG")
    private Double dataoriginflag;

//    /**
//     * 福华仓库类型(自定义档案)
//     */
//    @Column(name = "DEF1")
//    private String def1;
//
//    /**
//     * 仓库管理类型(自定义档案)
//     */
//    @Column(name = "DEF2")
//    private String def2;
//
//    /**
//     * 启用状态
//     */
//    @Column(name = "ENABLESTATE")
//    private Double enablestate;
//
//    /**
//     * 废品库
//     */
//    @Column(name = "GUBFLAG")
//    private String gubflag;
//
//    /**
//     * 代储仓
//     */
//    @Column(name = "ISAGENTSTORE")
//    private String isagentstore;
//
//    /**
//     * 影响可用量
//     */
//    @Column(name = "ISATPAFFECTED")
//    private String isatpaffected;
//
//    /**
//     * 进行存货成本计算
//     */
//    @Column(name = "ISCALCULATEDINVCOST")
//    private String iscalculatedinvcost;
//
//    /**
//     * 委外仓
//     */
//    @Column(name = "ISCOMMISSIONOUT")
//    private String iscommissionout;
//
//    /**
//     * 直运仓
//     */
//    @Column(name = "ISDIRECTSTORE")
//    private String isdirectstore;
//
//    /**
//     * 可预留
//     */
//    @Column(name = "ISOBLIGATE")
//    private String isobligate;
//
//    /**
//     * 适用零售
//     */
//    @Column(name = "ISRETAIL")
//    private String isretail;
//
//    /**
//     * 门店仓库
//     */
//    @Column(name = "ISSHOPSTORE")
//    private String isshopstore;
//
//    /**
//     * 在途仓
//     */
//    @Column(name = "ISSTOREONTHEWAY")
//    private String isstoreontheway;

    /**
     * 备注
     */
    @Column(name = "MEMO")
    private String memo;

    /**
     * 最后修改时间
     */
    @Column(name = "MODIFIEDTIME")
    private String modifiedtime;

    /**
     * 最后修改人
     */
    @Column(name = "MODIFIER")
    private String modifier;

//    /**
//     * 计划可用
//     */
//    @Column(name = "MRPFLAG")
//    private String mrpflag;
//
//    /**
//     * 加工商
//     */
//    @Column(name = "OPERATESUPPLIER")
//    private String operatesupplier;

    /**
     * 电话号码
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * 所属地点
     */
    @Column(name = "PK_ADDRESS")
    private String pkAddress;

    /**
     * 所属组织
     */
    @Column(name = "PK_GROUP")
    private String pkGroup;

    /**
     * 所属库存组织
     */
    @Column(name = "PK_ORG")
    private String pkOrg;

    /**
     * 负责人
     */
    @Column(name = "PRINCIPALCODE")
    private String principalcode;

//    /**
//     * 生产仓库
//     */
//    @Column(name = "PROFLAG")
//    private String proflag;

    /**
     * 仓库地址
     */
    @Column(name = "STORADDR")
    private String storaddr;

//    /**
//     * 保税仓
//     */
//    @Column(name = "ISKPTAXSTORE")
//    private String iskptaxstore;

    /**
     * 仓库名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 综合评分
     */
    @Column(name = "combined_scoring")
    private BigDecimal combinedScoring;

    /**
     * 是否危险品仓库 是否危险，0否，1是
     */
    @Column(name = "is_dangers")
    private Integer isDangers;

    /**
     * 是否内装进港，0否，1是
     */
    @Column(name = "is_inside_entrance")
    private Integer isInsideEntrance;

    /**
     * 启用状态 0：否  1：是
     */
    @Column(name = "enabled_state")
    private Integer enabledState;

    /**
     * 社会信用代码
     */
    @Column(name = "credit_code")
    private String creditCode;

    /**
     * 类型，0常规，1非常规，2自定
     */
    @Column(name = "supprop")
    private Integer supprop;

    /**
     * 仓储面积
     */
    @Column(name="storage_area")
    private BigDecimal storageArea;
    /**
     * 获取crm主键
     *
     * @return id - crm主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置crm主键
     *
     * @param id crm主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取仓库主键
     *
     * @return PK_STORDOC - 仓库主键
     */
    public String getPkStordoc() {
        return pkStordoc;
    }

    /**
     * 设置仓库主键
     *
     * @param pkStordoc 仓库主键
     */
    public void setPkStordoc(String pkStordoc) {
        this.pkStordoc = pkStordoc == null ? null : pkStordoc.trim();
    }

    /**
     * 获取仓库编码
     *
     * @return CODE - 仓库编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置仓库编码
     *
     * @param code 仓库编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取创建时间
     *
     * @return CREATIONTIME - 创建时间
     */
    public String getCreationtime() {
        return creationtime;
    }

    /**
     * 设置创建时间
     *
     * @param creationtime 创建时间
     */
    public void setCreationtime(String creationtime) {
        this.creationtime = creationtime == null ? null : creationtime.trim();
    }

    /**
     * 获取创建人
     *
     * @return CREATOR - 创建人
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
     * 获取分布式
     *
     * @return DATAORIGINFLAG - 分布式
     */
    public Double getDataoriginflag() {
        return dataoriginflag;
    }

    /**
     * 设置分布式
     *
     * @param dataoriginflag 分布式
     */
    public void setDataoriginflag(Double dataoriginflag) {
        this.dataoriginflag = dataoriginflag;
    }




    /**
     * 获取备注
     *
     * @return MEMO - 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * 获取最后修改时间
     *
     * @return MODIFIEDTIME - 最后修改时间
     */
    public String getModifiedtime() {
        return modifiedtime;
    }

    /**
     * 设置最后修改时间
     *
     * @param modifiedtime 最后修改时间
     */
    public void setModifiedtime(String modifiedtime) {
        this.modifiedtime = modifiedtime == null ? null : modifiedtime.trim();
    }

    /**
     * 获取最后修改人
     *
     * @return MODIFIER - 最后修改人
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置最后修改人
     *
     * @param modifier 最后修改人
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 获取电话号码
     *
     * @return PHONE - 电话号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话号码
     *
     * @param phone 电话号码
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取所属地点
     *
     * @return PK_ADDRESS - 所属地点
     */
    public String getPkAddress() {
        return pkAddress;
    }

    /**
     * 设置所属地点
     *
     * @param pkAddress 所属地点
     */
    public void setPkAddress(String pkAddress) {
        this.pkAddress = pkAddress == null ? null : pkAddress.trim();
    }

    /**
     * 获取所属组织
     *
     * @return PK_GROUP - 所属组织
     */
    public String getPkGroup() {
        return pkGroup;
    }

    /**
     * 设置所属组织
     *
     * @param pkGroup 所属组织
     */
    public void setPkGroup(String pkGroup) {
        this.pkGroup = pkGroup == null ? null : pkGroup.trim();
    }

    /**
     * 获取所属库存组织
     *
     * @return PK_ORG - 所属库存组织
     */
    public String getPkOrg() {
        return pkOrg;
    }

    /**
     * 设置所属库存组织
     *
     * @param pkOrg 所属库存组织
     */
    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg == null ? null : pkOrg.trim();
    }

    /**
     * 获取负责人
     *
     * @return PRINCIPALCODE - 负责人
     */
    public String getPrincipalcode() {
        return principalcode;
    }

    /**
     * 设置负责人
     *
     * @param principalcode 负责人
     */
    public void setPrincipalcode(String principalcode) {
        this.principalcode = principalcode == null ? null : principalcode.trim();
    }

    /**
     * 获取仓库地址
     *
     * @return STORADDR - 仓库地址
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
     * 获取仓库名称
     *
     * @return NAME - 仓库名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置仓库名称
     *
     * @param name 仓库名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
     * 获取是否危险品仓库 是否危险，0否，1是
     *
     * @return is_dangers - 是否危险品仓库 是否危险，0否，1是
     */
    public Integer getIsDangers() {
        return isDangers;
    }

    /**
     * 设置是否危险品仓库 是否危险，0否，1是
     *
     * @param isDangers 是否危险品仓库 是否危险，0否，1是
     */
    public void setIsDangers(Integer isDangers) {
        this.isDangers = isDangers;
    }

    /**
     * 获取是否内装进港，0否，1是
     *
     * @return is_inside_entrance - 是否内装进港，0否，1是
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
     * 获取启用状态 0：否  1：是
     *
     * @return enabled_state - 启用状态 0：否  1：是
     */
    public Integer getEnabledState() {
        return enabledState;
    }

    /**
     * 设置启用状态 0：否  1：是
     *
     * @param enabledState 启用状态 0：否  1：是
     */
    public void setEnabledState(Integer enabledState) {
        this.enabledState = enabledState;
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

    public Integer getSupprop() {
        return supprop;
    }

    public void setSupprop(Integer supprop) {
        this.supprop = supprop;
    }

    public BigDecimal getStorageArea() {
        return storageArea;
    }

    public void setStorageArea(BigDecimal storageArea) {
        this.storageArea = storageArea;
    }
}