package com.fuhuadata.web.util;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.fuhuadata.domain.query.Result;
import com.fuhuadata.util.Constant;
import com.fuhuadata.util.JsonUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport implements ServletRequestAware , ServletResponseAware, SessionAware{
		private final static Log log = LogFactory.getLog(BaseAction.class);
		protected HttpServletResponse response;
		protected HttpServletRequest request;
		protected Map<String, Object> session;
//		private FormService formService;
		private boolean checkLoginFlag;
		
		/**
		 * 首页result
		 */
		public static final String MAIN_PAGE_RESULT = "mainIndexPage"; 
		
		protected ValueStack context;
		
		private boolean contestPageFlag;
		private String survey;


		public void setServletRequest(HttpServletRequest request) {
			this.request = request;
		}

		public void setServletResponse(HttpServletResponse response) {
			this.response = response;
		}
		
		/**
		 * 得到velocity上下文
		 * @return
		 */
		public ValueStack getContext() {
			return ActionContext.getContext().getValueStack();
		}
		
		/**
		 * 获取真实的IP地址
		 */
		public String getRemoteIP() {	
			String ip = request.getHeader("x-forwarded-for");
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("X-Real-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("X-Forwarded-For");
			}
			if(StringUtils.isNotBlank(ip)&&ip.indexOf(",")>0){
				String[] ips = ip.split(",");
				ip=ips[0];
			}
			if(StringUtils.isNotBlank(ip)&&ip.indexOf("，")>0){
				String[] ips = ip.split("，");
				ip=ips[0];
			}
			return ip;
		}
		

		/**
		 * 将result中的值写入值栈
		 * 会写入result变量，同时会把result里面map的内容写入。
		 * 对于消息。如果result返回成功，则写入message，否则写入error
		 *
		 * @param result 结果
		 */
		@SuppressWarnings({ "unchecked", "rawtypes" })
		protected void toVm(Result result) {
			ValueStack context = ActionContext.getContext().getValueStack();
			context.set("result", result);
			Set<String> set = result.keySet();
			for (String key : set) {
				context.set(key, result.get(key));
			}
			String resultCode = result.getResultCode();
			if (StringUtils.isNotBlank(resultCode)) {
				String text;
				String[] params = result.getResultCodeParams();
				if (params != null && params.length > 0) {
					text = getText(resultCode, params);
				} else {
					text = getText(resultCode);
				}
				if (result.getSuccess()) {
					addActionMessage(text);
				} else {
					addActionError(text);
				}
			}
		}

		public HttpServletResponse getResponse() {
			ServletActionContext.getResponse().setCharacterEncoding(Constant.ENCODING);
			return ServletActionContext.getResponse();
		}


		public HttpServletRequest getRequest() {
			return ServletActionContext.getRequest();
		} 

		public void setSession(Map<String, Object> arg0) {
			this.session = arg0;
		}
		
		/**
		 * 发送自定义ajax信息
		 * @param msg
		 */
		public void sendAjaxMsg(String msg){
			write(msg);
		}
		
		/**
		 * 发送通用标准化格式信息
		 * @param code
		 * @param message
		 */
		public void sendAjaxMsg(int code,String message){
			String result = String.format("{\"code\":%d,\"message\":%s}", code,message);
			write(result);
		}
		/**
		 * 向response中输入信息
		 * @param content
		 * @throws Exception
		 */
		public void write(Object content){
			response.setCharacterEncoding(Constant.ENCODING);
			try {
				response.getWriter().print(content);
			} catch (IOException e) {
				log.error("Failed to write response message!", e);
			}
		} 
		
		/**
		 * 发送对象，并进行了json序列化处理
		 * @param obj
		 */
		public void writeToJson(Object obj) {
			try {
				this.write(JsonUtils.toJson(obj));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		/**
		 * 重定向
		 * @param location
		 * @throws IOException
		 */
		public void redirect(String location) throws IOException {
			this.getResponse().sendRedirect(location);
		}

		/**
		 * 表单验证
		 * @param fieldsMap
		 * @param formName
		 * @return
		 */
//		public boolean validateForm(Map<String, String> fieldsMap, String formName) {
//			Form form = formService.getForms().get(formName);
//	        for(Map.Entry<String, String> entry : fieldsMap.entrySet()){     
//	            form.setField(entry.getKey(), entry.getValue());
//	        }
//	        return formService.isValid(form);
//		}
//		
//		public UserLoginContext getUserContext() {
//			return (UserLoginContext) UserLoginContext.getUserLoginContext();
//		}

		@Override
		public void addActionError(String anErrorMessage) {
	        if (anErrorMessage.startsWith("the request was rejected because its size") || anErrorMessage.startsWith("struts.messages.error.file.extension.not.allowed")) {
	            super.addActionError("文件大小大于800K");
	            getContext().set("error_picsize", "文件大小大于800K");
	        } else {
	            super.addActionError(anErrorMessage);
	        }
		}
		
		@SuppressWarnings("unchecked")
//		public String logDetail(){
//			StringBuffer sb = new StringBuffer();
//			Enumeration<String> em = request.getParameterNames();
//			String param="";
//			String value="";
//			sb.append("，参数列表：");
//			while(em.hasMoreElements()){
//				param = em.nextElement();
//				value = request.getParameter(param);
//				sb.append(param);
//				sb.append("=");
//				sb.append(value);
//				sb.append("&");
//			}
//			sb.append("，用户信息：");
//			SmyUserInfo userInfo = getUserContext().getSmyUser();
//			if(userInfo!=null){
//				sb.append(userInfo.getId());
//			}else{
//				sb.append("未登录！");
//			}
//			return sb.toString();
//		}
		
		/**
		 * 判断当前用户是否是管理员
		 * @return
		 */
//		public boolean checkAdmin(){
//			SmyUserInfo userInfo = getUserContext().getSmyUser();
//			if(userInfo != null && (userInfo.getType() == Constant.USER_TYPE_ADMIN || userInfo.getType() == Constant.USER_TYPE_SUPER)){
//				return true;
//			}
//			return false;
//		}
		
	/*	
		*//**
		 * 安全过滤，非法字符过滤
		 *//*
		 public String securityFilter(String str){
			 if(StringUtils.isNotBlank(str)){
			     str = WebXssScanUtil.filt(str);
				 String sc = systemConfigureManager.getSecurityFilter();
				 for(String excetion : sc.split(",")){
					 str = str.replace(excetion, "");
				 }
			 }
			 return str;
		 }
		 
		 
			*//**
			 * 安全过滤，非法字符过滤,非法
			 *//*
			 public String wordFilter(String str){
				 if(StringUtils.isNotBlank(str)){
				     str = WebXssScanUtil.filt(str);
					 String sc = systemConfigureManager.getSecurityFilter();
					 for(String excetion : sc.split(",")){
						 str = str.replace(excetion, "");
					 }
					 sc = systemConfigureManager.getWordFilter();
					 for(String excetion : sc.split(",")){
						 str = str.replace(excetion, "");
					 }
				 }
				 return str;
			 }*/
		
		 /**
		  * 判断是否是非法refer
		  * @return
		  */
		 public boolean isIllegalRefer(){
			 HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
			 String refer = request.getHeader("Referer");
				
			 if(StringUtils.isEmpty(refer)){
				return true;
			 }
			 return false;	
				
		 }
		 
		 /**
		  * 获取当前refer
		  * @return
		  */
		 public String fetchRefer(){
			 HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
			 return request.getHeader("Referer");
		 }		 
		 
		 /**
		  * 过滤可能引发xss攻击的非法字符
		  * @param targetStr
		  * @return
		  */
		 public String filtXssChars(String targetStr){
			 if(StringUtils.isBlank(targetStr)){
				 return targetStr;
			 }
			 return targetStr.replace("<","")
	 						.replace(">", "")
	 						.replace("script", "")
	 						.replace("/", "")
	 						.replace("'", "")
	 						.replace("\"", "");
		 }

	    /**
		 * 获取不重复的数字
		 * @return
		 */
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public  HashSet getRandomInt(int max,int selectNum){
			 
			Random r = new Random();
			HashSet hs = new HashSet();
			 
			if(selectNum < max){
				//总是随机选取小部分的数据
				if(selectNum>max/2){
					int dele = max - selectNum;
					HashSet tmp = new HashSet();
					while(true){
						tmp.add(r.nextInt(max));
						if(tmp.size()==dele)
							break;
					}
					for(int i=0;i<max;i++){
						if(!tmp.contains(i)){
							hs.add(i);
						}
					}
				}else{					
					while(true){
						hs.add(r.nextInt(max));
						if(hs.size()==selectNum)
							break;
					}
				}
			}else{
				for(int i=0;i<max;i++){
					hs.add(i);
				}
			}
			return hs;
		}
			
		/**
		 * 根据cookie名获取cookie值
		 * @param name
		 * @return
		 */
		public  String getCookieByName(String name)
		{
			String value= "";

			//取值
			Cookie allCookie[]= request.getCookies();
			if(allCookie!=null&&allCookie.length!=0)
			{
			    for(int i=0;i<allCookie.length;i++)
			    {
			        String keyname=  allCookie[i].getName();
			        if(name.equals(keyname))
			        {
			        	value=  allCookie[i].getValue();
			        	break;
			        }
			    }
			}
			return value;
		}
			
		/**
		 * 添加一个cookie
		 */
	    public void addCookie(String name,String value,Integer age) {  
	        Cookie cookie = new Cookie(name, value);  
	        
	        // cookie保存30天
	        if(age!=null)
	        	cookie.setMaxAge(age.intValue());
	        else
	        	cookie.setMaxAge(60 * 60 * 24 * 30);
	        cookie.setPath("/");
	        cookie.setDomain(".fuhua.com");
	        response.addCookie(cookie);
	    }  
			
		public boolean isCheckLoginFlag() {
			return checkLoginFlag;
		}

		public void setCheckLoginFlag(boolean checkLoginFlag) {
			this.checkLoginFlag = checkLoginFlag;
		}

		public boolean isContestPageFlag() {
			return contestPageFlag;
		}

		public void setContestPageFlag(boolean contestPageFlag) {
			this.contestPageFlag = contestPageFlag;
		}

	    public String getSurvey() {
	        return survey;
	    }

	    public void setSurvey(String survey) {
	        this.survey = survey;
	    }
}