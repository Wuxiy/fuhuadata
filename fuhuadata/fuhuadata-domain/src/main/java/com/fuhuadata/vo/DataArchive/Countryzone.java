package com.fuhuadata.vo.DataArchive;

/**
 * 贸易国别
 * Created by intanswer on 2017/4/15.
 */
public class Countryzone {
    private String pkCountry;

    /**名称**/
    private String name;

    /**编码**/
    private String code;

    /**电话代码*/
    private String phonecode;

    /**数据格式**/
    private String pkFormat;

    /**语种**/
    private String pkLang;


    /**时区**/
    private String pkTimezone;

    /**全称**/
    private String wholename;

    public String getPkCountry() {
        return pkCountry;
    }

    public void setPkCountry(String pkCountry) {
        this.pkCountry = pkCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhonecode() {
        return phonecode;
    }

    public void setPhonecode(String phonecode) {
        this.phonecode = phonecode;
    }

    public String getPkFormat() {
        return pkFormat;
    }

    public void setPkFormat(String pkFormat) {
        this.pkFormat = pkFormat;
    }

    public String getPkLang() {
        return pkLang;
    }

    public void setPkLang(String pkLang) {
        this.pkLang = pkLang;
    }

    public String getPkTimezone() {
        return pkTimezone;
    }

    public void setPkTimezone(String pkTimezone) {
        this.pkTimezone = pkTimezone;
    }

    public String getWholename() {
        return wholename;
    }

    public void setWholename(String wholename) {
        this.wholename = wholename;
    }
}
