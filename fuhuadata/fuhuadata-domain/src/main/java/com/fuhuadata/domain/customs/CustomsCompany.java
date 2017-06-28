package com.fuhuadata.domain.customs;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "customs_company")
public class CustomsCompany extends BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 上级公司id
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
     * 获取公司名称
     *
     * @return name - 公司名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置公司名称
     *
     * @param name 公司名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取上级公司id
     *
     * @return pid - 上级公司id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置上级公司id
     *
     * @param pid 上级公司id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }
}