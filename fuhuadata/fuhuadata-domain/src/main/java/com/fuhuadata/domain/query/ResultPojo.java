package com.fuhuadata.domain.query;

public class ResultPojo {
	public int code;
	public String message;
	public Object preObject;
	public Object data;
	public Object getPreObject(){
		return preObject;
	}
	public void setPreObject(Object preObject){
		this.preObject=preObject;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
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
