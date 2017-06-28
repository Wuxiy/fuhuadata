package com.fuhuadata.service.mybatis.customs.matcher;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fuhuadata.domain.customs.CustomsProductRule;
import com.fuhuadata.service.mybatis.customs.exception.DuplicateProductMatchException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/27/2017
 */
public class RegexProductMatcher implements ProductMatcher {

    Logger logger = LoggerFactory.getLogger(getClass());

    private List<CustomsProductRule> rules;

    public JSONArray duplicateData = new JSONArray();

    public RegexProductMatcher(List<CustomsProductRule> rules) {
        this.rules = rules;
    }

    @Override
    public Integer matchProductId(String productName, String specification) {

        if (StringUtils.isEmpty(productName)) {
            return null;
        }

        Integer productId = null;
        CustomsProductRule matchRule = null;

        for (CustomsProductRule rule : this.rules) {

            Byte nameType = rule.getNameType();
            String ruleName = rule.getName();
            if (nameType == 1) {
                if (!ruleName.equals(productName)) {
                    continue;
                }
            } else if (nameType == 2) {
                if (!rule.getNamePattern().matcher(productName).matches()) {
                    continue;
                }
            }

            String ruleSpec = rule.getSpec();
            Byte specType = rule.getSpecType();
            if (StringUtils.isNotEmpty(ruleSpec)) {

                if (StringUtils.isEmpty(specification)) {// 如果规格未空，则继续匹配
                    continue;
                }
                if (specType == 1) {// 精确匹配
                    if (!ruleSpec.equals(specification)) {
                        continue;
                    }
                } else if (specType == 2) {// 模糊匹配
                    if (!rule.getSpecPattern().matcher(specification).matches()) {
                        continue;
                    }
                }
            }

            // 产品规则匹配重复
            if (matchRule != null && !matchRule.getProductId().equals(rule.getProductId())) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("产品名称", productName);
                jsonObject.put("规格", specification);

                JSONArray ruleArray = new JSONArray();
                ruleArray.add(matchRule);
                ruleArray.add(rule);

                jsonObject.put("匹配的规则", ruleArray);

                logger.error(jsonObject.toJSONString());
                duplicateData.add(jsonObject);
                throw new DuplicateProductMatchException("产品名称：[" + productName + "]，规格：[" + specification + "]匹配多个产品规格，" +
                        "匹配的规则IDS：[" + matchRule.getId() + "、" + rule.getId() + "]");
            }

            matchRule = rule;
            productId = matchRule.getProductId();
        }

        logger.debug("ProductName: [{}], Specification: [{}] = ProductId: [{}]",
                new Object[]{productName, specification, productId});

        return productId;
    }

}
