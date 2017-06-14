package com.fuhuadata.domain.mybatis.supplier;

/**
 * 联系人类型
 * <p>User: wangjie
 * <p>Date: 5/27/2017
 */
public enum LinkmanType {

    Factory(0, "加工厂"), Forwarding(1, "货代"), Warehouse(2, "仓库");

    public Integer key;

    public String value;

    LinkmanType(Integer key, String value) {
        this.key = key;
        this.value = value;
    }
}
