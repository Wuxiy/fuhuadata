    package com.fuhuadata.domain.query;


import java.sql.Date;


/**
 * 后台用户操作监控日志
 * Created by intanswer on 2017/1/10.
 */
public class SystemLogQuery extends PageBase {
    private Integer userId;//账号id
    private String userName;//账号姓名
    private String ip;//操作ip
    private String module;//执行的模块
    private String method;//执行的方法
    private Date date;//执行时间
    private Integer responseDate;//响应时间
    private String commit;//执行描述
    private String parementers;//执行参数
    private String remarks;//备注
    private String searchKey;//搜索按钮

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getIp() {
        return ip;
    }

    public String getModule() {
        return module;
    }

    public String getMethod() {
        return method;
    }

    public Date getDate() {
        return date;
    }

    public Integer getResponseDate() {
        return responseDate;
    }

    public String getCommit() {
        return commit;
    }

    public String getParementers() {
        return parementers;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setModule(String module) {
        module = module;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setResponseDate(Integer responseDate) {
        this.responseDate = responseDate;
    }

    public void setCommit(String commit) {
        this.commit = commit;
    }

    public void setParementers(String parementers) {
        this.parementers = parementers;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
