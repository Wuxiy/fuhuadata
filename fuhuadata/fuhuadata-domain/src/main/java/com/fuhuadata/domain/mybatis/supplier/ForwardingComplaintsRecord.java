package com.fuhuadata.domain.mybatis.supplier;

import com.fuhuadata.domain.mybatis.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 货代投诉记录
 */
@Table(name = "s_forwarding_complaints_record")
public class ForwardingComplaintsRecord extends BaseEntity<Integer> {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 货代订单id
     */
    @Column(name = "order_id")
    private Integer orderId;

    /**
     * 投诉日期
     */
    @Column(name = "complaint_date")
    private Date complaintDate;

    /**
     * 生产日期
     */
    @Column(name = "production_date")
    private Date productionDate;

    /**
     * 包装
     */
    private String packing;

    /**
     * 国家id
     */
    @Column(name = "country_id")
    private String countryId;

    /**
     * 客户id
     */
    @Column(name = "customer_id")
    private String customerId;

    /**
     * 国家
     */
    private String country;

    /**
     * 客户
     */
    @Column(name = "customer_name")
    private String customerName;

    /**
     * 产品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 受损数量
     */
    @Column(name = "damaged_quantity")
    private Integer damagedQuantity;

    /**
     * 问题
     */
    private String problem;

    /**
     * 赔偿损失金额
     */
    @Column(name = "USD")
    private BigDecimal usd;

    /**
     * 问题处理情况
     */
    @Column(name = "problem_handling")
    private String problemHandling;

    /**
     * 经办人
     */
    private String agent;

    /**
     * 组别
     */
    private String groups;

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
     * 获取货代订单id
     *
     * @return order_id - 货代订单id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置货代订单id
     *
     * @param orderId 货代订单id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取投诉日期
     *
     * @return complaint_date - 投诉日期
     */
    public Date getComplaintDate() {
        return complaintDate;
    }

    /**
     * 设置投诉日期
     *
     * @param complaintDate 投诉日期
     */
    public void setComplaintDate(Date complaintDate) {
        this.complaintDate = complaintDate;
    }

    /**
     * 获取生产日期
     *
     * @return production_date - 生产日期
     */
    public Date getProductionDate() {
        return productionDate;
    }

    /**
     * 设置生产日期
     *
     * @param productionDate 生产日期
     */
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    /**
     * 获取包装
     *
     * @return packing - 包装
     */
    public String getPacking() {
        return packing;
    }

    /**
     * 设置包装
     *
     * @param packing 包装
     */
    public void setPacking(String packing) {
        this.packing = packing == null ? null : packing.trim();
    }

    /**
     * 获取国家id
     *
     * @return country_id - 国家id
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * 设置国家id
     *
     * @param countryId 国家id
     */
    public void setCountryId(String countryId) {
        this.countryId = countryId == null ? null : countryId.trim();
    }

    /**
     * 获取客户id
     *
     * @return customer_id - 客户id
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * 设置客户id
     *
     * @param customerId 客户id
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    /**
     * 获取国家
     *
     * @return country - 国家
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国家
     *
     * @param country 国家
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * 获取客户
     *
     * @return customer_name - 客户
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 设置客户
     *
     * @param customerName 客户
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
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
     * 获取受损数量
     *
     * @return damaged_quantity - 受损数量
     */
    public Integer getDamagedQuantity() {
        return damagedQuantity;
    }

    /**
     * 设置受损数量
     *
     * @param damagedQuantity 受损数量
     */
    public void setDamagedQuantity(Integer damagedQuantity) {
        this.damagedQuantity = damagedQuantity;
    }

    /**
     * 获取问题
     *
     * @return problem - 问题
     */
    public String getProblem() {
        return problem;
    }

    /**
     * 设置问题
     *
     * @param problem 问题
     */
    public void setProblem(String problem) {
        this.problem = problem == null ? null : problem.trim();
    }

    /**
     * 获取赔偿损失金额
     *
     * @return USD - 赔偿损失金额
     */
    public BigDecimal getUsd() {
        return usd;
    }

    /**
     * 设置赔偿损失金额
     *
     * @param usd 赔偿损失金额
     */
    public void setUsd(BigDecimal usd) {
        this.usd = usd;
    }

    /**
     * 获取问题处理情况
     *
     * @return problem_handling - 问题处理情况
     */
    public String getProblemHandling() {
        return problemHandling;
    }

    /**
     * 设置问题处理情况
     *
     * @param problemHandling 问题处理情况
     */
    public void setProblemHandling(String problemHandling) {
        this.problemHandling = problemHandling == null ? null : problemHandling.trim();
    }

    /**
     * 获取经办人
     *
     * @return agent - 经办人
     */
    public String getAgent() {
        return agent;
    }

    /**
     * 设置经办人
     *
     * @param agent 经办人
     */
    public void setAgent(String agent) {
        this.agent = agent == null ? null : agent.trim();
    }

    /**
     * 获取组别
     *
     * @return groups - 组别
     */
    public String getGroups() {
        return groups;
    }

    /**
     * 设置组别
     *
     * @param groups 组别
     */
    public void setGroups(String groups) {
        this.groups = groups == null ? null : groups.trim();
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