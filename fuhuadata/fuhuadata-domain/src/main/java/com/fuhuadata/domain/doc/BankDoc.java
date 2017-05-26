package com.fuhuadata.domain.doc;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 银行档案
 */
@Table(name = "t_bankdoc")
public class BankDoc extends BaseEntity<Integer> {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * nc主键id
     */
    @Column(name = "pk_bankdoc")
    private String pkBankdoc;

    /**
     * nc银行类别, t_backtype.pk_banktype
     */
    @Column(name = "pk_banktype")
    private String pkBanktype;

    /**
     * 人行联行信息, nc.bd_asslinenum.pk_asslinenum
     */
    @Column(name = "pk_combine")
    private String pkCombine;

    /**
     * 国家地区, t_contryzone.pk_country
     */
    @Column(name = "pk_country")
    private String pkCountry;

    /**
     * 上级银行, t_backdoc.pk_bankdoc
     */
    @Column(name = "pk_fatherbank")
    private String pkFatherbank;

    /**
     * 对应资金组织, nc.org_fundorg.pk_fundorg
     */
    @Column(name = "pk_fundorg")
    private String pkFundorg;

    /**
     * 集团
     */
    @Column(name = "pk_group")
    private String pkGroup;

    /**
     * 组织, p_organization.nc_id
     */
    @Column(name = "pk_org")
    private String pkOrg;

    /**
     * 工作日历, nc.bd_workcalendar.pk_workcalendar
     */
    @Column(name = "pk_workcalendar")
    private String pkWorkcalendar;

    /**
     * 银行名称
     */
    private String name;

    /**
     * 简称
     */
    private String shortname;

    /**
     * 银行编码
     */
    private String code;

    /**
     * 内部码
     */
    private String innercode;

    /**
     * 助记码
     */
    private String mnecode;

    /**
     * 启用状态
     */
    private BigDecimal enablestate;

    /**
     * 人行联行名称
     */
    private String pcombinename;

    /**
     * 人行联行号码
     */
    private String pcombinenum;

    /**
     * 创建时间
     */
    private Date creationtime;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改时间
     */
    private Date modifiedtime;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取nc主键id
     *
     * @return pk_bankdoc - nc主键id
     */
    public String getPkBankdoc() {
        return pkBankdoc;
    }

    /**
     * 设置nc主键id
     *
     * @param pkBankdoc nc主键id
     */
    public void setPkBankdoc(String pkBankdoc) {
        this.pkBankdoc = pkBankdoc == null ? null : pkBankdoc.trim();
    }

    /**
     * 获取nc银行类别, t_backtype.pk_banktype
     *
     * @return pk_banktype - nc银行类别, t_backtype.pk_banktype
     */
    public String getPkBanktype() {
        return pkBanktype;
    }

    /**
     * 设置nc银行类别, t_backtype.pk_banktype
     *
     * @param pkBanktype nc银行类别, t_backtype.pk_banktype
     */
    public void setPkBanktype(String pkBanktype) {
        this.pkBanktype = pkBanktype == null ? null : pkBanktype.trim();
    }

    /**
     * 获取人行联行信息, nc.bd_asslinenum.pk_asslinenum
     *
     * @return pk_combine - 人行联行信息, nc.bd_asslinenum.pk_asslinenum
     */
    public String getPkCombine() {
        return pkCombine;
    }

    /**
     * 设置人行联行信息, nc.bd_asslinenum.pk_asslinenum
     *
     * @param pkCombine 人行联行信息, nc.bd_asslinenum.pk_asslinenum
     */
    public void setPkCombine(String pkCombine) {
        this.pkCombine = pkCombine == null ? null : pkCombine.trim();
    }

    /**
     * 获取国家地区, t_contryzone.pk_country
     *
     * @return pk_country - 国家地区, t_contryzone.pk_country
     */
    public String getPkCountry() {
        return pkCountry;
    }

    /**
     * 设置国家地区, t_contryzone.pk_country
     *
     * @param pkCountry 国家地区, t_contryzone.pk_country
     */
    public void setPkCountry(String pkCountry) {
        this.pkCountry = pkCountry == null ? null : pkCountry.trim();
    }

    /**
     * 获取上级银行, t_backdoc.pk_bankdoc
     *
     * @return pk_fatherbank - 上级银行, t_backdoc.pk_bankdoc
     */
    public String getPkFatherbank() {
        return pkFatherbank;
    }

    /**
     * 设置上级银行, t_backdoc.pk_bankdoc
     *
     * @param pkFatherbank 上级银行, t_backdoc.pk_bankdoc
     */
    public void setPkFatherbank(String pkFatherbank) {
        this.pkFatherbank = pkFatherbank == null ? null : pkFatherbank.trim();
    }

    /**
     * 获取对应资金组织, nc.org_fundorg.pk_fundorg
     *
     * @return pk_fundorg - 对应资金组织, nc.org_fundorg.pk_fundorg
     */
    public String getPkFundorg() {
        return pkFundorg;
    }

    /**
     * 设置对应资金组织, nc.org_fundorg.pk_fundorg
     *
     * @param pkFundorg 对应资金组织, nc.org_fundorg.pk_fundorg
     */
    public void setPkFundorg(String pkFundorg) {
        this.pkFundorg = pkFundorg == null ? null : pkFundorg.trim();
    }

    /**
     * 获取集团
     *
     * @return pk_group - 集团
     */
    public String getPkGroup() {
        return pkGroup;
    }

    /**
     * 设置集团
     *
     * @param pkGroup 集团
     */
    public void setPkGroup(String pkGroup) {
        this.pkGroup = pkGroup == null ? null : pkGroup.trim();
    }

    /**
     * 获取组织, p_organization.nc_id
     *
     * @return pk_org - 组织, p_organization.nc_id
     */
    public String getPkOrg() {
        return pkOrg;
    }

    /**
     * 设置组织, p_organization.nc_id
     *
     * @param pkOrg 组织, p_organization.nc_id
     */
    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg == null ? null : pkOrg.trim();
    }

    /**
     * 获取工作日历, nc.bd_workcalendar.pk_workcalendar
     *
     * @return pk_workcalendar - 工作日历, nc.bd_workcalendar.pk_workcalendar
     */
    public String getPkWorkcalendar() {
        return pkWorkcalendar;
    }

    /**
     * 设置工作日历, nc.bd_workcalendar.pk_workcalendar
     *
     * @param pkWorkcalendar 工作日历, nc.bd_workcalendar.pk_workcalendar
     */
    public void setPkWorkcalendar(String pkWorkcalendar) {
        this.pkWorkcalendar = pkWorkcalendar == null ? null : pkWorkcalendar.trim();
    }

    /**
     * 获取银行名称
     *
     * @return name - 银行名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置银行名称
     *
     * @param name 银行名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取简称
     *
     * @return shortname - 简称
     */
    public String getShortname() {
        return shortname;
    }

    /**
     * 设置简称
     *
     * @param shortname 简称
     */
    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }

    /**
     * 获取银行编码
     *
     * @return code - 银行编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置银行编码
     *
     * @param code 银行编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取内部码
     *
     * @return innercode - 内部码
     */
    public String getInnercode() {
        return innercode;
    }

    /**
     * 设置内部码
     *
     * @param innercode 内部码
     */
    public void setInnercode(String innercode) {
        this.innercode = innercode == null ? null : innercode.trim();
    }

    /**
     * 获取助记码
     *
     * @return mnecode - 助记码
     */
    public String getMnecode() {
        return mnecode;
    }

    /**
     * 设置助记码
     *
     * @param mnecode 助记码
     */
    public void setMnecode(String mnecode) {
        this.mnecode = mnecode == null ? null : mnecode.trim();
    }

    /**
     * 获取启用状态
     *
     * @return enablestate - 启用状态
     */
    public BigDecimal getEnablestate() {
        return enablestate;
    }

    /**
     * 设置启用状态
     *
     * @param enablestate 启用状态
     */
    public void setEnablestate(BigDecimal enablestate) {
        this.enablestate = enablestate;
    }

    /**
     * 获取人行联行名称
     *
     * @return pcombinename - 人行联行名称
     */
    public String getPcombinename() {
        return pcombinename;
    }

    /**
     * 设置人行联行名称
     *
     * @param pcombinename 人行联行名称
     */
    public void setPcombinename(String pcombinename) {
        this.pcombinename = pcombinename == null ? null : pcombinename.trim();
    }

    /**
     * 获取人行联行号码
     *
     * @return pcombinenum - 人行联行号码
     */
    public String getPcombinenum() {
        return pcombinenum;
    }

    /**
     * 设置人行联行号码
     *
     * @param pcombinenum 人行联行号码
     */
    public void setPcombinenum(String pcombinenum) {
        this.pcombinenum = pcombinenum == null ? null : pcombinenum.trim();
    }

    /**
     * 获取创建时间
     *
     * @return creationtime - 创建时间
     */
    public Date getCreationtime() {
        return creationtime;
    }

    /**
     * 设置创建时间
     *
     * @param creationtime 创建时间
     */
    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 获取修改时间
     *
     * @return modifiedtime - 修改时间
     */
    public Date getModifiedtime() {
        return modifiedtime;
    }

    /**
     * 设置修改时间
     *
     * @param modifiedtime 修改时间
     */
    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    /**
     * 获取修改人
     *
     * @return modifier - 修改人
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置修改人
     *
     * @param modifier 修改人
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }
}