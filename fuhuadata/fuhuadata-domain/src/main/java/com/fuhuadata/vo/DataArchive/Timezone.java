package com.fuhuadata.vo.DataArchive;

/**
 * 时 区
 * Created by intanswer on 2017/4/15.
 */
public class Timezone {

    /**主键**/
    private String pkTimezone;

    /****/
    private String name;

    private String code;

    private String description;

    public String getPkTimezone() {
        return pkTimezone;
    }

    public void setPkTimezone(String pkTimezone) {
        this.pkTimezone = pkTimezone;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
