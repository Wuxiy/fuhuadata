package com.fuhuadata.domain.query;
import java.util.Date;
import java.math.BigDecimal;

/**
 *  货代
 * @author wangbo
 * @date 2017-01-16 15:25:40
 */
public class QueryFreightforwarding extends PageBase {

    /**货代id**/
	private String id;
	
    /**类型，0常规，1非常规，2自定**/
	private Integer supprop;

    /**办公地址**/
	private String officeAddress;
	
    /**联系人**/
	private String linkMan;
	
    /**联系电话**/
	private String linkPhone;
	
    /**邮箱**/
	private String email;


	public String getOfficeAddress() {
		return officeAddress;
	}
	
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	public String getLinkMan() {
		return linkMan;
	}
	
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	
	public String getLinkPhone() {
		return linkPhone;
	}
	
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getSupprop() {
		return supprop;
	}

	public void setSupprop(Integer supprop) {
		this.supprop = supprop;
	}
}