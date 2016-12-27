package com.fuhuadata.domain.query;

import java.sql.Timestamp;

/**
 * 用户账号信息demo
 * @author wangbo
 */
public class UserAccountQuery extends PageBase{
	private Integer id;
    private String name;
    private Timestamp createTime;
    private Timestamp modifyTime;
	private String searchKey;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
}
