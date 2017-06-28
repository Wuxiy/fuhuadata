package com.fuhuadata.service.mybatis.customs;

import com.fuhuadata.domain.customs.CustomsProductRule;
import com.fuhuadata.service.mybatis.BaseService;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/23/2017
 */
public interface CustomsProductRuleService extends BaseService<CustomsProductRule, Integer> {

    /**
     * 获取所有的产品规则列表，包含正则pattern
     * @return
     */
    List<CustomsProductRule> listProductRules();
}
