package com.fuhuadata.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author wangbo
 * @date 2017-01-13 16:10:56
 */
public class CustomerLinkman{

    /**客户联系人ID**/
	private String linkmanId;
	
    /**客户id**/
    @NotBlank
	private String customerId;
	
    /**姓名**/
    @NotBlank
	private String name;
	
    /**联系电话1**/
	private String linkPhone1;
	
    /**联系电话2**/
	private String linkPhone2;
	
    /**邮箱**/
	private String lemail;
	
    /**岗位**/
	private String posts;
	
    /**负责区域**/
	private String responseArea;
	
    /**是否在职,0在职，1离职**/
    @NotNull
	private Integer onJob;
	
    /**性别**/
    @NotBlank
	private String sex;
	
    /**生日**/
	private Date birthday;
	
    /**国籍**/
	private String nationality;
	
    /**影响力情况**/
	private String influence;
	
    /**展会情况**/
	private String exhibitionHabits;
	
    /**喜好**/
	private String fancy;
	
    /**饮食习惯**/
	private String eatingHabits;
	
    /**宗教信仰**/
	private String faith;
	
    /**是否默认，0否，1是，只有一个是默认**/
    @NotNull
	private Integer isDefault;
	
    /**备注**/
	private String remarks;
	
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
	
	
	public CustomerLinkman() {
	}
	
	public String getLinkmanId() {
		return linkmanId;
	}
	
	public void setLinkmanId(String linkmanId) {
		this.linkmanId = linkmanId;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLinkPhone1() {
		return linkPhone1;
	}
	
	public void setLinkPhone1(String linkPhone1) {
		this.linkPhone1 = linkPhone1;
	}
	
	public String getLinkPhone2() {
		return linkPhone2;
	}
	
	public void setLinkPhone2(String linkPhone2) {
		this.linkPhone2 = linkPhone2;
	}
	
	public String getLemail() {
		return lemail;
	}
	
	public void setLemail(String lemail) {
		this.lemail = lemail;
	}
	
	public String getPosts() {
		return posts;
	}
	
	public void setPosts(String posts) {
		this.posts = posts;
	}
	
	public String getResponseArea() {
		return responseArea;
	}
	
	public void setResponseArea(String responseArea) {
		this.responseArea = responseArea;
	}
	
	public Integer getOnJob() {
		return onJob;
	}
	
	public void setOnJob(Integer onJob) {
		this.onJob = onJob;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public String getInfluence() {
		return influence;
	}
	
	public void setInfluence(String influence) {
		this.influence = influence;
	}
	
	public String getExhibitionHabits() {
		return exhibitionHabits;
	}
	
	public void setExhibitionHabits(String exhibitionHabits) {
		this.exhibitionHabits = exhibitionHabits;
	}
	
	public String getFancy() {
		return fancy;
	}
	
	public void setFancy(String fancy) {
		this.fancy = fancy;
	}
	
	public String getEatingHabits() {
		return eatingHabits;
	}
	
	public void setEatingHabits(String eatingHabits) {
		this.eatingHabits = eatingHabits;
	}
	
	public String getFaith() {
		return faith;
	}
	
	public void setFaith(String faith) {
		this.faith = faith;
	}
	
	public Integer getIsDefault() {
		return isDefault;
	}
	
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	
	public String getRemarks() {
		return remarks;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	

}