package com.fuhuadata.cache.interceptor;

import com.fuhuadata.domain.mybatis.BaseEntity;
import com.fuhuadata.domain.mybatis.Dept;
import com.fuhuadata.domain.mybatis.Organization;
import com.fuhuadata.service.mybatis.DeptService;
import com.fuhuadata.service.mybatis.OrganizationService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * <p>User: wangjie
 * <p>Date: 6/9/2017
 */
@Aspect
@Component
public class OrgDepCacheAspect extends BaseCacheAspect {

    private String orgListKeyPrefix = "orgs-";
    private String orgIdKeyPrefix = "orgId-";
    private String orgPkKeyPrefix = "orgPk-";
    private String orgCodeKeyPrefix = "orgCode-";

    private String depListKeyPrefix = "deps-";
    private String depIdKeyPrefix = "depId-";
    private String depPkKeyPrefix = "depPk-";
    private String depCodeKeyPrefix = "depCode-";

    @Resource
    OrganizationService organizationService;

    @Resource
    DeptService deptService;

    public OrgDepCacheAspect() {
        setCacheName("sys-orgDepCache");
    }

    // 切入点
    // 组织OrganizationService
    @Pointcut(value = "target(com.fuhuadata.service.mybatis.OrganizationService)")
    private void orgService() {
    }

    // 匹配部门 DeptService
    @Pointcut(value = "target(com.fuhuadata.service.mybatis.DeptService)")
    private void depService() {
    }

    @Pointcut(value = "execution(* get(*)) " +
            "|| execution(* getByNcId(*)) " +
            "|| execution(* getByCode(*))")
    private void cacheable() {
    }

    @Pointcut(value = "execution(* list())")
    private void listCacheable() {
    }

    @Pointcut(value = "execution(* getOrgOrDepPNode(String)) && args(pid)", argNames = "pid")
    private void pNodeCacheable(String pid) {
    }

    // 增强实现
    @Around(value = "orgService() && cacheable()")
    public Object orgCacheableAdvice(ProceedingJoinPoint pjp) throws Throwable {

        String methodName = pjp.getSignature().getName();
        Object arg = pjp.getArgs().length >= 1 ? pjp.getArgs()[0] : null;

        String key = "";
        boolean isIdKey = false;
        if ("get".equals(methodName) && !(arg instanceof BaseEntity)) {
            key = orgIdKey(String.valueOf(arg));
            isIdKey = true;
        } else if ("getByNcId".equals(methodName)) {
            key = orgPkKey(String.valueOf(arg));
        } else if ("getByCode".equals(methodName)) {
            key = orgCodeKey(String.valueOf(arg));
        }

        Organization org = null;
        if (StringUtils.isNotEmpty(key)) {
            if (isIdKey) {
                org = get(key);
            } else {
                Object orgId = get(key);
                if (orgId != null) {
                    String idKey = orgIdKey(String.valueOf(orgId));
                    org = get(idKey);
                }
            }
        }

        // cache hit
        if (org != null) {
            logger.debug("cacheName:{}, hit key:{}", cacheName, key);
            return org;
        }
        logger.debug("cacheName:{}, miss key:{}", cacheName, key);

        // cache miss
        org = (Organization) pjp.proceed();

        put(org);
        return org;
    }

    @Around(value = "orgService() && listCacheable()")
    public Object orgListCacheable(ProceedingJoinPoint pjp) throws Throwable {

        List<Organization> orgs = new ArrayList<>();

        List<Integer> orgIds = get(orgListKey());
        if (CollectionUtils.isNotEmpty(orgIds)) {
            logger.debug("cacheName:{}, hit key:{}", cacheName, orgListKey());
            boolean useCache = true;
            for (Integer orgId : orgIds) {
                Organization org = get(orgIdKey(String.valueOf(orgId)));
                if (org == null) {
                    useCache = false;
                    break;
                }
                orgs.add(org);
            }

            // 如果不是所有的组织都在缓存中找到，则返回数据库查找
            if (useCache) {
                return orgs;
            }
        }

        logger.debug("cacheName:{}, miss key:{}", cacheName, orgListKey());
        List<Organization> organizations = (List<Organization>) pjp.proceed();

        orgIds = organizations.stream()
                .peek(this::put)
                .map(Organization::getId)
                .collect(toList());
        put(orgListKey(), orgIds);

        return organizations;
    }

    // Dept 增强实现
    @Around(value = "depService() && cacheable()")
    public Object depCacheableAdvice(ProceedingJoinPoint pjp) throws Throwable {

        String methodName = pjp.getSignature().getName();
        Object arg = pjp.getArgs().length >= 1 ? pjp.getArgs()[0] : null;

        String key = "";
        boolean isIdKey = false;
        if ("get".equals(methodName) && !(arg instanceof BaseEntity)) {
            key = depIdKey(String.valueOf(arg));
            isIdKey = true;
        } else if ("getByNcId".equals(methodName)) {
            key = depPkKey(String.valueOf(arg));
        } else if ("getByCode".equals(methodName)) {
            key = depCodeKey(String.valueOf(arg));
        }

        Dept dep = null;
        if (StringUtils.isNotEmpty(key)) {
            if (isIdKey) {
                dep = get(key);
            } else {
                Object orgId = get(key);
                if (orgId != null) {
                    String idKey = orgIdKey(String.valueOf(orgId));
                    dep = get(idKey);
                }
            }
        }

        // cache hit
        if (dep != null) {
            logger.debug("cacheName:{}, hit key:{}", cacheName, key);
            return dep;
        }
        logger.debug("cacheName:{}, miss key:{}", cacheName, key);

        // cache miss
        dep = (Dept) pjp.proceed();

        put(dep);
        return dep;
    }

    @Around(value = "depService() && listCacheable()")
    public Object depListCacheable(ProceedingJoinPoint pjp) throws Throwable {

        List<Dept> depts = new ArrayList<>();

        List<Integer> depIds = get(depListKey());
        if (CollectionUtils.isNotEmpty(depIds)) {
            logger.debug("cacheName:{}, hit key:{}", cacheName, orgListKey());
            boolean useCache = true;
            for (Integer depId : depIds) {
                Dept dept = get(depIdKey(String.valueOf(depId)));
                if (dept == null) {
                    useCache = false;
                    break;
                }
                depts.add(dept);
            }

            // 如果出现缓存中未找到的情况，则到数据库查找
            if (useCache) {
                return depts;
            }
        }

        logger.debug("cacheName:{}, miss key:{}", cacheName, orgListKey());
        List<Dept> deps = (List<Dept>) pjp.proceed();

        depIds = deps.stream()
                .peek(this::put)
                .map(Dept::getId)
                .collect(toList());
        put(depListKey(), depIds);

        return deps;
    }

    @Around(value = "pNodeCacheable(pid)", argNames = "pjp,pid")
    public Object getOrgOrDepPNodeCacheable(ProceedingJoinPoint pjp, String pid) throws Throwable {

        // 在组织 cache 中查找
        String key = orgPkKey(pid);
        Object orgId = get(key);
        if (orgId != null) {
            Organization org = get(orgIdKey(String.valueOf(orgId)));
            return organizationService.convertToNode(org);
        }

        key = depPkKey(pid);
        Object depId = get(key);
        if (depId != null) {
            Dept dept = get(depIdKey(String.valueOf(depId)));
            return deptService.convertToNode(dept);
        }

        return pjp.proceed();
    }

    public void put(Organization org) {

        if (org == null) {
            return;
        }

        Integer orgId = org.getId();
        // pk, code -> orgId
        put(orgPkKey(org.getNcId()), orgId);
        put(orgCodeKey(org.getCode()), orgId);
        // orgId -> org
        put(orgIdKey(String.valueOf(orgId)), org);
    }

    public void put(Dept dept) {

        if (dept == null) {
            return;
        }

        Integer deptId = dept.getId();
        // pk, code = deptId
        put(depPkKey(dept.getPkDept()), deptId);
        put(depCodeKey(dept.getCode()), deptId);
        // deptId -> dept
        put(depIdKey(String.valueOf(deptId)), dept);
    }

    private String orgListKey() {
        return orgListKeyPrefix + "list";
    }

    private String orgIdKey(String id) {
        return orgIdKeyPrefix + id;
    }

    private String orgPkKey(String pk) {
        return orgPkKeyPrefix + pk;
    }

    private String orgCodeKey(String code) {
        return orgCodeKeyPrefix + code;
    }

    private String depListKey() {
        return depListKeyPrefix + "list";
    }

    private String depIdKey(String id) {
        return depIdKeyPrefix + id;
    }

    private String depPkKey(String pk) {
        return depPkKeyPrefix + pk;
    }

    private String depCodeKey(String code) {
        return depCodeKeyPrefix + code;
    }
}
