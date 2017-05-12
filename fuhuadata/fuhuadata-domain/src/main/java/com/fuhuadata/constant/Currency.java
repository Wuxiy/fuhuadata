package com.fuhuadata.constant;

/**
 * 币种缩写 code
 * <p>User: wangjie
 * <p>Date: 5/10/2017
 */
public enum Currency {

    CNY("CNY"), USD("USD");

    public final String code;

    Currency(String code) {
        this.code = code;
    }
}
