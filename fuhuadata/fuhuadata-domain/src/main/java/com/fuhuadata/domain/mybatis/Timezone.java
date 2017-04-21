package com.fuhuadata.domain.mybatis;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_timezone")
public class Timezone extends BaseEntity<String> {
    /**
     * 主键
     */
    @Id
    @Column(name = "pk_timezone")
    private String pkTimezone;

    /**
     * 名称
     */
    private String name;

    /**
     * 编码
     */
    private String code;

    /**
     * 描述
     */
    private String description;

    /**
     * 获取主键
     *
     * @return pk_timezone - 主键
     */
    public String getPkTimezone() {
        return pkTimezone;
    }

    /**
     * 设置主键
     *
     * @param pkTimezone 主键
     */
    public void setPkTimezone(String pkTimezone) {
        this.pkTimezone = pkTimezone == null ? null : pkTimezone.trim();
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取编码
     *
     * @return code - 编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置编码
     *
     * @param code 编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public void setId(String s) {
        this.pkTimezone = s;
    }

    @Override
    public String getId() {
        return pkTimezone;
    }
}