package com.fuhuadata.web.util;

/**
 * <p>User: wangjie
 * <p>Date: 4/18/2017
 */
public class CustomerUtils {

    public static String getCustomerPermissonPrefix(String custType) {
        if ("1".equals(custType)) {
            return "client:coop";
        } else if ("2".equals(custType)) {
            return "client:pote";
        } else if ("3".equals(custType)) {
            return "client:go";
        }

        return "client:coop";
    }
}
