package com.fuhuadata.domain.doc;

import com.fuhuadata.domain.query.PageBase;

/**
 * <p>User: wangjie
 * <p>Date: 5/25/2017
 */
public class BankDocQuery extends PageBase {

    private String pkBanktype;

    private String name;

    public String getPkBanktype() {
        return pkBanktype;
    }

    public void setPkBanktype(String pkBanktype) {
        this.pkBanktype = pkBanktype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
