package com.fuhuadata.domain.doc;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * 银行类别
 */
@Table(name = "t_banktype")
public class BankType extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * nc银行类别主键, bd_banktype.pk_banktype
     */
    @Column(name = "pk_banktype")
    private String pkBanktype;

    /**
     * 集团主键
     */
    @Column(name = "pk_group")
    private String pkGroup;

    /**
     * 组织外键
     */
    @Column(name = "pk_org")
    private String pkOrg;

    /**
     * 名称, nc.name
     */
    private String name;

    private String name2;

    private String name3;

    private String name4;

    private String name5;

    private String name6;

    /**
     * nc.code
     */
    private String code;

    /**
     * 助记码, nc.mnecode
     */
    private String mnecode;

    @Column(name = "creation_time")
    private Date creationTime;

    /**
     * 创建人, p_user_account.id
     */
    private String creator;

    @Column(name = "modified_time")
    private Date modifiedTime;

    /**
     * 修改人, p_user_account.id
     */
    private String modifier;

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
     * 获取nc银行类别主键, bd_banktype.pk_banktype
     *
     * @return pk_banktype - nc银行类别主键, bd_banktype.pk_banktype
     */
    public String getPkBanktype() {
        return pkBanktype;
    }

    /**
     * 设置nc银行类别主键, bd_banktype.pk_banktype
     *
     * @param pkBanktype nc银行类别主键, bd_banktype.pk_banktype
     */
    public void setPkBanktype(String pkBanktype) {
        this.pkBanktype = pkBanktype == null ? null : pkBanktype.trim();
    }

    /**
     * 获取集团主键
     *
     * @return pk_group - 集团主键
     */
    public String getPkGroup() {
        return pkGroup;
    }

    /**
     * 设置集团主键
     *
     * @param pkGroup 集团主键
     */
    public void setPkGroup(String pkGroup) {
        this.pkGroup = pkGroup == null ? null : pkGroup.trim();
    }

    /**
     * 获取组织外键
     *
     * @return pk_org - 组织外键
     */
    public String getPkOrg() {
        return pkOrg;
    }

    /**
     * 设置组织外键
     *
     * @param pkOrg 组织外键
     */
    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg == null ? null : pkOrg.trim();
    }

    /**
     * 获取名称, nc.name
     *
     * @return name - 名称, nc.name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称, nc.name
     *
     * @param name 名称, nc.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return name2
     */
    public String getName2() {
        return name2;
    }

    /**
     * @param name2
     */
    public void setName2(String name2) {
        this.name2 = name2 == null ? null : name2.trim();
    }

    /**
     * @return name3
     */
    public String getName3() {
        return name3;
    }

    /**
     * @param name3
     */
    public void setName3(String name3) {
        this.name3 = name3 == null ? null : name3.trim();
    }

    /**
     * @return name4
     */
    public String getName4() {
        return name4;
    }

    /**
     * @param name4
     */
    public void setName4(String name4) {
        this.name4 = name4 == null ? null : name4.trim();
    }

    /**
     * @return name5
     */
    public String getName5() {
        return name5;
    }

    /**
     * @param name5
     */
    public void setName5(String name5) {
        this.name5 = name5 == null ? null : name5.trim();
    }

    /**
     * @return name6
     */
    public String getName6() {
        return name6;
    }

    /**
     * @param name6
     */
    public void setName6(String name6) {
        this.name6 = name6 == null ? null : name6.trim();
    }

    /**
     * 获取nc.code
     *
     * @return code - nc.code
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置nc.code
     *
     * @param code nc.code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取助记码, nc.mnecode
     *
     * @return mnecode - 助记码, nc.mnecode
     */
    public String getMnecode() {
        return mnecode;
    }

    /**
     * 设置助记码, nc.mnecode
     *
     * @param mnecode 助记码, nc.mnecode
     */
    public void setMnecode(String mnecode) {
        this.mnecode = mnecode == null ? null : mnecode.trim();
    }

    /**
     * @return creation_time
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     * @param creationTime
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * 获取创建人, p_user_account.id
     *
     * @return creator - 创建人, p_user_account.id
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人, p_user_account.id
     *
     * @param creator 创建人, p_user_account.id
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * @return modified_time
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * @param modifiedTime
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     * 获取修改人, p_user_account.id
     *
     * @return modifier - 修改人, p_user_account.id
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置修改人, p_user_account.id
     *
     * @param modifier 修改人, p_user_account.id
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }
}