package com.fuhuadata.service.mybatis.customs;

import com.fuhuadata.domain.customs.CustomsProductRule;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

/**
 * <p>User: wangjie
 * <p>Date: 6/23/2017
 */
@Service
public class CustomsProductRuleServiceImpl extends BaseServiceImpl<CustomsProductRule, Integer>
        implements CustomsProductRuleService {

    @Override
    public List<CustomsProductRule> listProductRules() {

        List<CustomsProductRule> rules = getBatchMapper().selectAll();
        for (CustomsProductRule rule : rules) {

            if (StringUtils.isNotEmpty(rule.getName())) {
                Pattern namePattern = Pattern.compile(getRegexString(rule.getName()));
                rule.setNamePattern(namePattern);
            }

            if (StringUtils.isNotEmpty(rule.getSpec())) {
                Pattern specPattern = Pattern.compile(getRegexString(rule.getSpec()));
                rule.setSpecPattern(specPattern);
            }
        }

        return rules;
    }

    private String getRegexString(String ruleName) {

        StringBuilder builder = new StringBuilder();
        builder.append(".*");
        String names = ruleName.replaceAll(",", ".*");
        builder.append(names);
        builder.append(".*");
        return builder.toString();
    }
}
