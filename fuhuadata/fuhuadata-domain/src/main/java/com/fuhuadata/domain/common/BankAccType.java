package com.fuhuadata.domain.common;

/**
 * <p>User: wangjie
 * <p>Date: 5/26/2017
 */
public enum BankAccType {

    Factory((short) 0, "加工厂");

    public final short key;

    public final String value;

    BankAccType(short key, String value) {
        this.key = key;
        this.value = value;
    }
}
