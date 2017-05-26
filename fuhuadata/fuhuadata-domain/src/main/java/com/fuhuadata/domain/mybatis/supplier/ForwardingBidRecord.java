package com.fuhuadata.domain.mybatis.supplier;

import com.fuhuadata.domain.mybatis.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;


/**
 *   货代竞标记录
 */
@Table(name = "s_forwarding_bid_record")
public class ForwardingBidRecord extends BaseEntity<Integer>{
    /**
     * 竞标主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 货代id
     */
    @Column(name = "freightforwarding_id")
    private String freightforwardingId;

    /**
     * 仓库id
     */
    @Column(name = "warehouse_id")
    private String warehouseId;

    /**
     * 采购方案编号
     */
    @Column(name = "purchase_plan_code")
    private String purchasePlanCode;

    /**
     * 项目名称
     */
    @Column(name = "entry_name")
    private String entryName;

    /**
     * 竞标价格
     */
    @Column(name = "bid_price")
    private BigDecimal bidPrice;

    /**
     * 项目竞标最低价格
     */
    @Column(name = "lowest_bid_price")
    private BigDecimal lowestBidPrice;

    /**
     * 是否中标
     */
    @Column(name = "is_bid")
    private Integer isBid;

    /**
     * 是否接受调价
     */
    @Column(name = "is_modify_price")
    private Integer isModifyPrice;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 评价时间
     */
    @Column(name = "evaluate_time")
    private Date evaluateTime;

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
     * 获取竞标主键id
     *
     * @return id - 竞标主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置竞标主键id
     *
     * @param id 竞标主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取货代id
     *
     * @return freightforwarding_id - 货代id
     */
    public String getFreightforwardingId() {
        return freightforwardingId;
    }

    /**
     * 设置货代id
     *
     * @param freightforwardingId 货代id
     */
    public void setFreightforwardingId(String freightforwardingId) {
        this.freightforwardingId = freightforwardingId == null ? null : freightforwardingId.trim();
    }

    /**
     * 获取仓库id
     *
     * @return warehouse_id - 仓库id
     */
    public String getWarehouseId() {
        return warehouseId;
    }

    /**
     * 设置仓库id
     *
     * @param warehouseId 仓库id
     */
    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId == null ? null : warehouseId.trim();
    }

    /**
     * 获取采购方案编号
     *
     * @return purchase_plan_code - 采购方案编号
     */
    public String getPurchasePlanCode() {
        return purchasePlanCode;
    }

    /**
     * 设置采购方案编号
     *
     * @param purchasePlanCode 采购方案编号
     */
    public void setPurchasePlanCode(String purchasePlanCode) {
        this.purchasePlanCode = purchasePlanCode == null ? null : purchasePlanCode.trim();
    }

    /**
     * 获取项目名称
     *
     * @return entry_name - 项目名称
     */
    public String getEntryName() {
        return entryName;
    }

    /**
     * 设置项目名称
     *
     * @param entryName 项目名称
     */
    public void setEntryName(String entryName) {
        this.entryName = entryName == null ? null : entryName.trim();
    }

    /**
     * 获取竞标价格
     *
     * @return bid_price - 竞标价格
     */
    public BigDecimal getBidPrice() {
        return bidPrice;
    }

    /**
     * 设置竞标价格
     *
     * @param bidPrice 竞标价格
     */
    public void setBidPrice(BigDecimal bidPrice) {
        this.bidPrice = bidPrice;
    }

    /**
     * 获取项目竞标最低价格
     *
     * @return lowest_bid_price - 项目竞标最低价格
     */
    public BigDecimal getLowestBidPrice() {
        return lowestBidPrice;
    }

    /**
     * 设置项目竞标最低价格
     *
     * @param lowestBidPrice 项目竞标最低价格
     */
    public void setLowestBidPrice(BigDecimal lowestBidPrice) {
        this.lowestBidPrice = lowestBidPrice;
    }

    /**
     * 获取是否中标
     *
     * @return is_bid - 是否中标
     */
    public Integer getIsBid() {
        return isBid;
    }

    /**
     * 设置是否中标
     *
     * @param isBid 是否中标
     */
    public void setIsBid(Integer isBid) {
        this.isBid = isBid;
    }

    /**
     * 获取是否接受调价
     *
     * @return is_modify_price - 是否接受调价
     */
    public Integer getIsModifyPrice() {
        return isModifyPrice;
    }

    /**
     * 设置是否接受调价
     *
     * @param isModifyPrice 是否接受调价
     */
    public void setIsModifyPrice(Integer isModifyPrice) {
        this.isModifyPrice = isModifyPrice;
    }

    /**
     * 获取备注
     *
     * @return remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取评价时间
     *
     * @return evaluate_time - 评价时间
     */
    public Date getEvaluateTime() {
        return evaluateTime;
    }

    /**
     * 设置评价时间
     *
     * @param evaluateTime 评价时间
     */
    public void setEvaluateTime(Date evaluateTime) {
        this.evaluateTime = evaluateTime;
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