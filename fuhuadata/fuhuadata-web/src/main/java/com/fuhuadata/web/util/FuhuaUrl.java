package com.fuhuadata.web.util;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FuhuaUrl implements Cloneable {
	private final static Log log = LogFactory.getLog(FuhuaUrl.class);
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 协议
	 */
	private String protocol = "http";
	/**
	 * 主机
	 */
	private String host;
	/**
	 * 端口
	 */
	private int port = -1;

	/**
	 * 路径
	 */
	private String path;
	/**
	 * 
	 */
	private String contextPath;

	private boolean reset;
	/**
	 * 
	 */
	private boolean filter = true;
	/**
	 * 
	 */
	private Map<String, Object> query = new LinkedHashMap<String, Object>();

	/**
	 * 
	 */
	private FuhuaUrl fuhuaUrl;
	/**
	 *
	 */
	private FuhuaIntercept intercept;
	private String charsetName = "gbk";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public FuhuaUrl addQueryData(String name, String value) {
		query.put(name, value);
		return this;
	}

	/**
	 * @param name
	 * @param value
	 * @return
	 */
	public FuhuaUrl addQueryData(String name, Object value) {
		query.put(name, value);
		return this;
	}

	public FuhuaUrl addQueryData(String name, int value) {
		query.put(name, value);
		return this;
	}

	public FuhuaUrl addQueryData(String name, long value) {
		query.put(name, value);
		return this;
	}

	public FuhuaUrl addQueryData(String name, float value) {
		query.put(name, value);
		return this;
	}

	public FuhuaUrl getTarget(String target) {
		this.path = target;
		return this;
	}

	/**
	 * @return
	 */
	public String render() {
		FuhuaUrl url = null;
		try {
			if (intercept != null) {
				url = new FuhuaUrl();
				url.query = new LinkedHashMap<String, Object>();
				url.query.putAll(this.query);
				setJdUrlValue(url, this);
			}
			return doIt();
		} finally {
			if (intercept != null && url != null) {
				setJdUrlValue(this, url);
				this.query.putAll(url.query);
			}
		}
	}

	private String doIt() {
		String str;
		URL url;
		try {
			if (intercept != null) {
				intercept.doIntercept(this);
			}
			String path = prefixPath(this.contextPath, this.path);
			// path = this.path == null ? "/" : this.path;
			url = new URL(protocol, host, port, path);
			if (url.getDefaultPort() == url.getPort()) {
				url = new URL(protocol, host, -1, path);
			}
			str = url.toString();
		} catch (Exception e) {
			str = "/";
		}

		StringBuilder builder = new StringBuilder(str);
		if (!query.isEmpty()) {
			for (String key : query.keySet()) {
				Object obj = query.get(key);
				if (obj instanceof List) {
					List list = (List) obj;
					for (Object o : list) {
						setValue(builder, key, o);
					}
				} else if (obj instanceof Map) {
					Map map = (Map) obj;
					for (Object o : map.keySet()) {
						setValue(builder, o == null ? "" : o.toString(), map.get(o));
					}
				} else {
					if (obj != null && obj.getClass().isArray()) {
						Object[] arrays = (Object[]) obj;
						for (Object o : arrays) {
							setValue(builder, key, o);
						}
					} else {
						setValue(builder, key, obj);
					}
				}
			}
			return builder.replace(str.length(), str.length() + 1, "?").toString();
		} else {
			return str;
		}
		// return builder.toString();
	}

	/**
	 * @param contextPath
	 * @param path
	 * @return
	 */
	public String prefixPath(String contextPath, String path) {
		String returnPath;
		if (path == null || contextPath == null) {
			if (path == null && contextPath == null) {
				returnPath = "/";
			} else if (contextPath == null) {
				returnPath = path;
			} else {
				returnPath = contextPath;
			}
		} else {
			if (contextPath.endsWith("/") && path.startsWith("/")) {
				returnPath = contextPath + path.substring(1);
			} else {
				returnPath = contextPath + path;
			}
		}
		return returnPath;
	}

	public void setValue(StringBuilder builder, String key, Object o) {
		String value = o == null ? "" : o.toString();
		if (value.length() > 0) {
			String str1;
			str1 = encodeUrl(value);
			builder.append("&").append(key).append("=").append(str1);
		} else {
			if (!filter) {
				builder.append("&").append(key).append("=");
			}
		}
	}

	/**
	 * @param value
	 * @return ֵ
	 */
	public String encodeUrl(String value) {
		String str1;
		if (StringUtils.isNotBlank(charsetName)) {
			try {
				str1 = URLEncoder.encode(value, charsetName);
			} catch (UnsupportedEncodingException e) {
				str1 = value;
			}
		} else {
			str1 = URLEncoder.encode(value);
		}
		return str1;
	}

	/**
	 * @return
	 */
	public String toString() {
		String s = render();
		if (!reset) {
			reset = true;
			reset();
		}
		reset = false;
		return s;
	}

	/**
	 *
	 */
	public void reset() {
		try {
			reset = true;
			query.clear();
			query.putAll(fuhuaUrl.query);
			fuhuaUrl.setJdUrlValue(this, fuhuaUrl);

		} catch (Exception e) {
			log.error("copyProperties error!", e);
		}
	}

	/**
	 *
	 * @param url
	 * @throws MalformedURLException
	 */
	public void setUrl(String url) throws MalformedURLException {
		URL a = new URL(url);
		this.protocol = a.getProtocol();
		this.host = a.getHost();
		this.port = a.getPort();
		this.contextPath = a.getPath();
		String queryString = a.getQuery();
		if (!StringUtils.isEmpty(queryString)) {
			query.putAll(getQueryMap(queryString));
		}
	}

	private Map<String, Object> getQueryMap(String query) {
		String[] params = query.split("&");
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		for (String param : params) {
			String[] strings = param.split("=");
			String name = strings[0];
			String value = null;
			if (strings.length > 1) {
				value = strings[1];
			}
			map.put(name, value);
		}
		return map;
	}

	public FuhuaUrl clone() {
		FuhuaUrl clone = new FuhuaUrl();
		setJdUrlValue(clone, this);
		clone.query = new LinkedHashMap<String, Object>();
		clone.query.putAll(query);
		return clone;
	}

	private void setJdUrlValue(FuhuaUrl dest, FuhuaUrl src) {
		dest.username = src.username;
		dest.password = src.password;
		dest.protocol = src.protocol;
		dest.host = src.host;
		dest.port = src.port;
		dest.contextPath = src.contextPath;
		dest.path = src.path;
		dest.intercept = src.intercept;

	}

	public void cleanQueryMap() {
		if (this.query != null && !this.query.isEmpty()) {
			this.query.clear();
		}
	}

	public void setCharsetName(String charsetName) {
		this.charsetName = charsetName;
	}

	public String getCharsetName() {
		return charsetName;
	}

	public boolean isFilter() {
		return filter;
	}

	public void setFilter(boolean filter) {
		this.filter = filter;
	}

	public void setFuhuaUrl(FuhuaUrl fuhuaUrl) {
		this.fuhuaUrl = fuhuaUrl;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public void setIntercept(FuhuaIntercept intercept) {
		this.intercept = intercept;
	}

	public void setQuery(Map<String, Object> query) {
		this.query = query;
	}

	public Map<String, Object> getQuery() {
		return query;
	}
}
