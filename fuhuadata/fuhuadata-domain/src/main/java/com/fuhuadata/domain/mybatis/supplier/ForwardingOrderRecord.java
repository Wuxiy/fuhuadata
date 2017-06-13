package com.fuhuadata.domain.mybatis.supplier;

import com.fuhuadata.domain.mybatis.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "s_forwarding_order_record")
public class ForwardingOrderRecord extends BaseEntity<Integer>{
    /**
     * 货代订单记录id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 仓库id
     */
    @Column(name = "warehouse_id")
    private Integer warehouseId;

    /**
     * 竞标记录id
     */
    @Column(name = "bid_id")
    private Integer bidId;

    /**
     * 仓库名称
     */
    @Column(name = "warehouse_name")
    private String warehouseName;

    /**
     * 进仓编号
     */
    @Column(name = "entry_code")
    private String entryCode;

    /**
     * 货代名称
     */
    @Column(name = "forwarding_name")
    private String forwardingName;

    /**
     * 对应外销合同号
     */
    @Column(name = "export_contract_number")
    private String exportContractNumber;

    /**
     * 是否危险品
     */
    @Column(name = "is_dangers")
    private Integer isDangers;

    /**
     * 出运金额
     */
    @Column(name = "shipment_amount")
    private BigDecimal shipmentAmount;

    /**
     * 出运数量
     */
    @Column(name = "shipment_quantity")
    private BigDecimal shipmentQuantity;

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
     * 获取货代订单记录id
     *
     * @return id - 货代订单记录id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置货代订单记录id
     *
     * @param id 货代订单记录id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取仓库id
     *
     * @return warehouse_id - 仓库id
     */
    public Integer getWarehouseId() {
        return warehouseId;
    }

    /**
     * 设置仓库id
     *
     * @param warehouseId 仓库id
     */
    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    /**
     * 获取竞标记录id
     *
     * @return bid_id - 竞标记录id
     */
    public Integer getBidId() {
        return bidId;
    }

    /**
     * 设置竞标记录id
     *
     * @param bidId 竞标记录id
     */
    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    /**
     * 获取仓库名称
     *
     * @return warehouse_name - 仓库名称
     */
    public String getWarehouseName() {
        return warehouseName;
    }

    /**
     * 设置仓库名称
     *
     * @param warehouseName 仓库名称
     */
    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName == null ? null : warehouseName.trim();
    }

    /**
     * 获取进仓编号
     *
     * @return entry_code - 进仓编号
     */
    public String getEntryCode() {
        return entryCode;
    }

    /**
     * 设置进仓编号
     *
     * @param entryCode 进仓编号
     */
    public void setEntryCode(String entryCode) {
        this.entryCode = entryCode == null ? null : entryCode.trim();
    }

    /**
     * 获取货代名称
     *
     * @return forwarding_name - 货代名称
     */
    public String getForwardingName() {
        return forwardingName;
    }

    /**
     * 设置货代名称
     *
     * @param forwardingName 货代名称
     */
    public void setForwardingName(String forwardingName) {
        this.forwardingName = forwardingName == null ? null : forwardingName.trim();
    }

    /**
     * 获取对应外销合同号
     *
     * @return export_contract_number - 对应外销合同号
     */
    public String getExportContractNumber() {
        return exportContractNumber;
    }

    /**
     * 设置对应外销合同号
     *
     * @param exportContractNumber 对应外销合同号
     */
    public void setExportContractNumber(String exportContractNumber) {
        this.exportContractNumber = exportContractNumber == null ? null : exportContractNumber.trim();
    }


    /**
     * 获取出运金额
     *
     * @return shipment_amount - 出运金额
     */
    public BigDecimal getShipmentAmount() {
        return shipmentAmount;
    }

    /**
     * 设置出运金额
     *
     * @param shipmentAmount 出运金额
     */
    public void setShipmentAmount(BigDecimal shipmentAmount) {
        this.shipmentAmount = shipmentAmount;
    }

    /**
     * 获取出运数量
     *
     * @return shipment_quantity - 出运数量
     */
    public BigDecimal getShipmentQuantity() {
        return shipmentQuantity;
    }

    /**
     * 设置出运数量
     *
     * @param shipmentQuantity 出运数量
     */
    public void setShipmentQuantity(BigDecimal shipmentQuantity) {
        this.shipmentQuantity = shipmentQuantity;
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

    public Integer getIsDangers() {
        return isDangers;
    }

    public void setIsDangers(Integer isDangers) {
        this.isDangers = isDangers;
    }
}