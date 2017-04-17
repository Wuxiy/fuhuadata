package com.fuhuadata.domain.mybatis;

import javax.persistence.*;

@Table(name = "p_job")
public class Job extends BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * nc主键
     */
    @Column(name = "pk_psnjob")
    private String pkPsnjob;

    /**
     * 人员编码
     */
    private String psncode;

    /**
     * 所属部门
     */
    @Column(name = "pk_dept")
    private String pkDept;

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
     * 获取nc主键
     *
     * @return pk_psnjob - nc主键
     */
    public String getPkPsnjob() {
        return pkPsnjob;
    }

    /**
     * 设置nc主键
     *
     * @param pkPsnjob nc主键
     */
    public void setPkPsnjob(String pkPsnjob) {
        this.pkPsnjob = pkPsnjob == null ? null : pkPsnjob.trim();
    }

    /**
     * 获取人员编码
     *
     * @return psncode - 人员编码
     */
    public String getPsncode() {
        return psncode;
    }

    /**
     * 设置人员编码
     *
     * @param psncode 人员编码
     */
    public void setPsncode(String psncode) {
        this.psncode = psncode == null ? null : psncode.trim();
    }

    /**
     * 获取所属部门
     *
     * @return pk_dept - 所属部门
     */
    public String getPkDept() {
        return pkDept;
    }

    /**
     * 设置所属部门
     *
     * @param pkDept 所属部门
     */
    public void setPkDept(String pkDept) {
        this.pkDept = pkDept == null ? null : pkDept.trim();
    }
}