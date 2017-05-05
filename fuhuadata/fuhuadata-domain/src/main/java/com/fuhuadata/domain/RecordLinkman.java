package com.fuhuadata.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author wangbo
 * @date 2017-01-13 16:26:04
 */
public class RecordLinkman implements Serializable{

    /**主键id**/
	private Integer id;
	
    /**拜访记录id**/
	private Integer visitRecordId;
	
    /**客户联系人ID**/
	private String linkmanId;

	/**客户联系人姓名**/
	private String linkmanName;
	
    /**单人费用，单位元**/
	private BigDecimal activityExpens;
	
    /**单人礼物**/
	private String activityGift;
	
    /**创建者id**/
	private Integer createUserId;
	
    /**创建者姓名**/
	private String createUserName;
	
    /**上一次修改者id**/
	private Integer lastmodifyUserId;
	
    /**上一次修改者姓名**/
	private String lastmodifyUserName;
	
    /**创建时间**/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	
    /**修改时间**/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifyTime;

	/**备注**/
	private String remarks;
	
	
	public RecordLinkman() {
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getLinkmanId() {
		return linkmanId;
	}
	
	public void setLinkmanId(String linkmanId) {
		this.linkmanId = linkmanId;
	}
	
	public BigDecimal getActivityExpens() {
		return activityExpens;
	}
	
	public void setActivityExpens(BigDecimal activityExpens) {
		this.activityExpens = activityExpens;
	}
	
	public String getActivityGift() {
		return activityGift;
	}
	
	public void setActivityGift(String activityGift) {
		this.activityGift = activityGift;
	}
	
	public Integer getCreateUserId() {
		return createUserId;
	}
	
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	
	public String getCreateUserName() {
		return createUserName;
	}
	
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	
	public Integer getLastmodifyUserId() {
		return lastmodifyUserId;
	}
	
	public void setLastmodifyUserId(Integer lastmodifyUserId) {
		this.lastmodifyUserId = lastmodifyUserId;
	}
	
	public String getLastmodifyUserName() {
		return lastmodifyUserName;
	}
	
	public void setLastmodifyUserName(String lastmodifyUserName) {
		this.lastmodifyUserName = lastmodifyUserName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}


	public Integer getVisitRecordId() {
		return visitRecordId;
	}

	public void setVisitRecordId(Integer visitRecordId) {
		this.visitRecordId = visitRecordId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getLinkmanName() {
		return linkmanName;
	}

	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}
}