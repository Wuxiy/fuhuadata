package com.fuhuadata.vo.DataArchive;

/**
 * 目的港起运港口档案
 * Created by intanswer on 2017/4/18.
 */
public class Portdoc {

    private String pkPortdoc;

    private String vname;

    private String venname;

    private String vcode;

    private String country;

    private String ecountry;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEcountry() {
        return ecountry;
    }

    public void setEcountry(String ecountry) {
        this.ecountry = ecountry;
    }

    public String getPkPortdoc() {
        return pkPortdoc;
    }

    public void setPkPortdoc(String pkPortdoc) {
        this.pkPortdoc = pkPortdoc;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVenname() {
        return venname;
    }

    public void setVenname(String venname) {
        this.venname = venname;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }
}
