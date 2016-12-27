package com.fuhuadata.domain.query;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 分页帮助类
 * wangbo
 */
public class Result<T> extends PageBase implements Serializable {
	/**
	 * 唯一序列号
	 */
	private static final long serialVersionUID = 6028636097083630372L;

	/**
	 * 是否成功
	 */
	private boolean success = true;

	/**
	 * service返回的对象
	 */
	private Map<String, Object> result = new HashMap<String, Object>();

	/**
	 * 默认的key
	 */
	public static final String DEFAULT_MODEL_KEY = "module";

	/**
	 * 当前的key
	 */
	private String modelKey = DEFAULT_MODEL_KEY;
	
	/**
	 * 结果码,-1需要登录，0消息错误，1正确
	 */
	private int code = 1;
	
	/**
	 * 错误信息
	 */
	private String message;
	
	/**
	 * 返回码和返回参数
	 */
	public String resultCode;
	
	public String resultCodeParams[];
	
	/**
	 * 带是否成功的构造方法
	 * @param success
	 */
	public Result(boolean success) {
		this.success = success;
	}
	
	/**
	 * 默认构造方法
	 */
	public Result() {
	}

	/**
	 * 新增一个返回结果
	 * @param obj
	 * @return
	 */
	public Object addDefaultModel(String key, T obj) {
		modelKey = key;
		return result.put(modelKey, obj);
	}
	
	public Object addDefaultModel(T obj) {
		return result.put(modelKey, obj);
	}
	
	/**
	 * 得到默认的模型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T getModel(){
		return (T) result.get(modelKey);
	}
	
	@SuppressWarnings("unchecked")
	public T getModel(String key){
		return (T) result.get(key);
	}
	
	/**
	 * 取出默认的值
	 * @return
	 */
	public Object get() {
		return result.get(modelKey);
	}

	/**
	 * 取出值
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		return result.get(key);
	}

	/**
	 * 新增一个带key的返回结果
	 * @param key
	 * @param obj
	 * @return
	 */
	public Object addModel(String key, Object obj) {
		return result.put(key, obj);
	}

	/**
	 * 取出所有的key 
	 * @return
	 */
	public Set<String> keySet() {
		return result.keySet();
	}

	/**
	 * 取出值集合
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Collection values() {
		return result.values();
	}

	/**
	 * 返回是否成功
	 * @return
	 */
	public boolean getSuccess() {
		return success;
	}

	public boolean isSuccess() {
		return success;
	}

	/**
	 * 设置返回是否成功
	 * @param success
	 */
	public void setSuccess(boolean success) {
		if(success){
			this.code = 1;
		}else{
			this.code = 0;
		}
		this.success = success;
	}

	/**
	 * 设置默认的消息信息
	 * @param code
	 * @param message
	 */
	public void setSimpleErrorMsg(int code, String message) {
		if(code == 1){
			this.success = true;
		}else{
			this.success = false;
		}
		this.code = code;
		this.message = message;
		result.put("message", message);
	}
	
	/**
	 * 返回标准pojo格式数据
	 * @return
	 */
	public ResultPojo getResultPojo(){
		ResultPojo resultPojo = new ResultPojo();
		resultPojo.code = this.code;
		resultPojo.message = this.message;
		//获取默认的对象
		resultPojo.defaultObject = this.get();
		return resultPojo;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		if(code == 1){
			this.success = true;
		}else{
			this.success = false;
		}
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String[] getResultCodeParams() {
		return resultCodeParams;
	}

	public void setResultCodeParams(String[] resultCodeParams) {
		this.resultCodeParams = resultCodeParams;
	}
}
