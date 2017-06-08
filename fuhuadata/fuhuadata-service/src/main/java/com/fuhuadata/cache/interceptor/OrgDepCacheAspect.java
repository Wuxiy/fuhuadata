package com.fuhuadata.cache.interceptor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <p>User: wangjie
 * <p>Date: 6/9/2017
 */
@Aspect
@Component
public class OrgDepCacheAspect extends BaseCacheAspect {

    public OrgDepCacheAspect() {
        setCacheName("sys-orgDepCache");
    }

    private String orgListKeyPrefix = "orgs-";
    private String orgIdKeyPrefix = "orgId-";
    private String orgPkKeyPrefix = "orgPk-";
    private String orgCodeKeyPrefix = "orgCode-";

    private String depListKeyPrefix = "deps-";
    private String depIdKeyPrefix = "depId-";
    private String depPkKeyPrefix = "depPk-";
    private String depCodeKeyPrefix = "depCode-";

    // 切入点
    // 组织OrganizationService
    @Pointcut(value = "target(com.fuhuadata.service.mybatis.OrganizationService)")
    private void orgService() {
    }

    // 匹配部门 DeptService
    @Pointcut(value = "target(com.fuhuadata.service.mybatis.DeptService)")
    private void depService() {
    }

    @Pointcut(value = "execution(* get())")
    private void cacheable() {}
}
