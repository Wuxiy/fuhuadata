package com.fuhuadata.domain.customs;

/**
 * <p>User: wangjie
 * <p>Date: 7/3/2017
 */
public enum StatCategory {

    COUNTRY, COMPANY;

    public static void main(String[] args) {

        System.out.println(COUNTRY.name());
        System.out.println(COMPANY.ordinal());
    }
}
