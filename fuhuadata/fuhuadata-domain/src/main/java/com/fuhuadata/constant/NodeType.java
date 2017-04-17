package com.fuhuadata.constant;

/**
 * <p>User: wangjie
 * <p>Date: 4/12/2017
 */
public enum NodeType {

    ORG(1, "组织"), DEPT(2, "部门"), USER(3, "用户");

    public final int key;

    public final String value;

    private NodeType(int key, String value) {
        this.key = key;
        this.value = value;
    }
}
