package com.fuhuadata.dao.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.text.MessageFormat;

/**
 * <p>User: wangjie
 * <p>Date: 4/19/2017
 */
@Aspect
@Order(1)//请注意：这里order一定要小于tx:annotation-driven的order，即先执行DataSourceAspect切面，再执行事务切面，才能获取到最终的数据源
@Component
public class DataSourceAspect {

    static Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    /**
     * 切入点 service包及子孙包下的所有类
     */
    @Pointcut("execution(* com.fuhuadata.service..*(..))")
    public void aspect() {
    }

    /**
     * 配置前置通知,使用在方法aspect()上注册的切入点
     */
    @Before("aspect()")
    public void before(JoinPoint point) {
        Class<?> target = point.getTarget().getClass();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DataSource dataSource = null;
        //从类初始化
        dataSource = this.getDataSource(target, method);
        //从接口初始化
        if (dataSource == null) {
            for (Class<?> clazz : target.getInterfaces()) {
                dataSource = getDataSource(clazz, method);
                if (dataSource != null) {
                    break;//从某个接口中一旦发现注解，不再循环
                }
            }
        }

        if (dataSource != null && !StringUtils.isEmpty(dataSource.value())) {
            // 如果发现注解，则设置相应的数据源，否则使用默认数据源
            logger.debug("使用数据源[{}]", dataSource.value());
            HandleDataSource.setDataSource(dataSource.value());
        }
    }

    @After("aspect()")
    public void after(JoinPoint point) {
        //使用完记得清空
        HandleDataSource.setDataSource(null);
    }


    /**
     * 获取方法或类的注解对象DataSource
     *
     * @param target 类class
     * @param method 方法
     * @return DataSource
     */
    public DataSource getDataSource(Class<?> target, Method method) {
        try {
            //1.优先方法注解
            Method m = target.getMethod(method.getName(), method.getParameterTypes());
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                return m.getAnnotation(DataSource.class);
            }
            //2.其次类注解
            if (target.isAnnotationPresent(DataSource.class)) {
                return target.getAnnotation(DataSource.class);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(MessageFormat.format("通过注解切换数据源时发生异常[class={0},method={1}]："
                    , target.getName(), method.getName()), e);
        }
        return null;
    }
}
