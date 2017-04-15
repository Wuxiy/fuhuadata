package com.fuhuadata.constant;

/**
 * 大区或地区标识
 * <p>User: wangjie
 * <p>Date: 4/14/2017
 */
public enum AreaType {

    CLASS(1, "大区"), CODE(2, "地区");

    public final int key;

    public final String value;

    AreaType(int key, String value) {
        this.key = key;
        this.value = value;
    }
}
