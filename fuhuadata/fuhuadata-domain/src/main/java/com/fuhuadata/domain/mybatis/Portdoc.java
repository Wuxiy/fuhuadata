package com.fuhuadata.domain.mybatis;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_portdoc")
public class Portdoc extends BaseEntity<String> {
    /**
     * 主键
     */
    @Id
    @Column(name = "pk_portdoc")
    private String pkPortdoc;

    /**
     * 名称
     */
    private String vname;

    /**
     * 英文名称
     */
    private String venname;

    /**
     * 编码 
     */
    private String vcode;

    /**
     * 获取主键
     *
     * @return pk_portdoc - 主键
     */
    public String getPkPortdoc() {
        return pkPortdoc;
    }

    /**
     * 设置主键
     *
     * @param pkPortdoc 主键
     */
    public void setPkPortdoc(String pkPortdoc) {
        this.pkPortdoc = pkPortdoc == null ? null : pkPortdoc.trim();
    }

    /**
     * 获取名称
     *
     * @return vname - 名称
     */
    public String getVname() {
        return vname;
    }

    /**
     * 设置名称
     *
     * @param vname 名称
     */
    public void setVname(String vname) {
        this.vname = vname == null ? null : vname.trim();
    }

    /**
     * 获取英文名称
     *
     * @return venname - 英文名称
     */
    public String getVenname() {
        return venname;
    }

    /**
     * 设置英文名称
     *
     * @param venname 英文名称
     */
    public void setVenname(String venname) {
        this.venname = venname == null ? null : venname.trim();
    }

    /**
     * 获取编码 
     *
     * @return vcode - 编码 
     */
    public String getVcode() {
        return vcode;
    }

    /**
     * 设置编码 
     *
     * @param vcode 编码 
     */
    public void setVcode(String vcode) {
        this.vcode = vcode == null ? null : vcode.trim();
    }

    @Override
    public void setId(String s) {
        this.pkPortdoc = s;
    }

    @Override
    public String getId() {
        return this.pkPortdoc;
    }
}