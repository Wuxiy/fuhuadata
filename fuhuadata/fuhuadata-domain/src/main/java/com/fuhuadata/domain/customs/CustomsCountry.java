package com.fuhuadata.domain.customs;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "customs_country")
public class CustomsCountry extends BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 国家名称
     */
    private String name;

    /**
     * 国家别名
     */
    private String alias;

    /**
     * 上级国家id
     */
    private Integer pid;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取国家名称
     *
     * @return name - 国家名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置国家名称
     *
     * @param name 国家名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取国家别名
     *
     * @return alias - 国家别名
     */
    public String getAlias() {
        return alias;
    }

    /**
     * 设置国家别名
     *
     * @param alias 国家别名
     */
    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    /**
     * 获取上级国家id
     *
     * @return pid - 上级国家id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置上级国家id
     *
     * @param pid 上级国家id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }
}