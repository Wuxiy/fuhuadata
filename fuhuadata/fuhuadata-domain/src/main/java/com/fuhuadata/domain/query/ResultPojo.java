package com.fuhuadata.domain.query;

public class ResultPojo {
	public int code;
	public String message;
	public Object defaultObject;
	public Object getDefaultObject() {
		return defaultObject;
	}
	public void setDefaultObject(Object defaultObject) {
		this.defaultObject = defaultObject;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
