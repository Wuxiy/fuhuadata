package com.fuhuadata.domain.mybatis;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_countryzone")
public class Countryzone extends BaseEntity<String> {
    /**
     * 主键
     */
    @Id
    @Column(name = "pk_country")
    private String pkCountry;

    /**
     * 客户基本分类名称
     */
    private String name;

    /**
     * 客户基本分类编码
     */
    private String code;

    /**
     * 电话代码
     */
    private String phonecode;

    /**
     * 数据格式 
     */
    @Column(name = "pk_format")
    private String pkFormat;

    /**
     * 语种 
     */
    @Column(name = "pk_lang")
    private String pkLang;

    /**
     * 时区
     */
    @Column(name = "pk_timezone")
    private String pkTimezone;

    /**
     * 全称
     */
    private String wholename;

    /**
     * 获取主键
     *
     * @return pk_country - 主键
     */
    public String getPkCountry() {
        return pkCountry;
    }

    /**
     * 设置主键
     *
     * @param pkCountry 主键
     */
    public void setPkCountry(String pkCountry) {
        this.pkCountry = pkCountry == null ? null : pkCountry.trim();
    }

    /**
     * 获取客户基本分类名称
     *
     * @return name - 客户基本分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置客户基本分类名称
     *
     * @param name 客户基本分类名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取客户基本分类编码
     *
     * @return code - 客户基本分类编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置客户基本分类编码
     *
     * @param code 客户基本分类编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取电话代码
     *
     * @return phonecode - 电话代码
     */
    public String getPhonecode() {
        return phonecode;
    }

    /**
     * 设置电话代码
     *
     * @param phonecode 电话代码
     */
    public void setPhonecode(String phonecode) {
        this.phonecode = phonecode == null ? null : phonecode.trim();
    }

    /**
     * 获取数据格式 
     *
     * @return pk_format - 数据格式 
     */
    public String getPkFormat() {
        return pkFormat;
    }

    /**
     * 设置数据格式 
     *
     * @param pkFormat 数据格式 
     */
    public void setPkFormat(String pkFormat) {
        this.pkFormat = pkFormat == null ? null : pkFormat.trim();
    }

    /**
     * 获取语种 
     *
     * @return pk_lang - 语种 
     */
    public String getPkLang() {
        return pkLang;
    }

    /**
     * 设置语种 
     *
     * @param pkLang 语种 
     */
    public void setPkLang(String pkLang) {
        this.pkLang = pkLang == null ? null : pkLang.trim();
    }

    /**
     * 获取时区
     *
     * @return pk_timezone - 时区
     */
    public String getPkTimezone() {
        return pkTimezone;
    }

    /**
     * 设置时区
     *
     * @param pkTimezone 时区
     */
    public void setPkTimezone(String pkTimezone) {
        this.pkTimezone = pkTimezone == null ? null : pkTimezone.trim();
    }

    /**
     * 获取全称
     *
     * @return wholename - 全称
     */
    public String getWholename() {
        return wholename;
    }

    /**
     * 设置全称
     *
     * @param wholename 全称
     */
    public void setWholename(String wholename) {
        this.wholename = wholename == null ? null : wholename.trim();
    }

    @Override
    public void setId(String s) {
        this.pkCountry = s;
    }

    @Override
    public String getId() {
        return pkCountry;
    }
}