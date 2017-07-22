package com.fuhuadata.service.mybatis.customs.matcher;

/**
 * <p>User: wangjie
 * <p>Date: 6/27/2017
 */
@FunctionalInterface
public interface ProductMatcher {

    /**
     * 根据产品名称和规格返回匹配的产品id
     * @param productName
     * @param specification
     * @return
     */
    Integer matchProductId(String productName, String specification);
}
