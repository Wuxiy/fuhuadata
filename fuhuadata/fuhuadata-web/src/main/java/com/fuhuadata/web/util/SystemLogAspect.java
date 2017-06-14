package com.fuhuadata.web.util;

import java.lang.reflect.Method;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.fuhuadata.domain.SystemLog;
import com.fuhuadata.service.SystemLogService;
import com.fuhuadata.service.util.LoginUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * 切面用于监控action每一个方法
 * Created by wuxi on 2017/1/9.
 */
@Aspect
public class SystemLogAspect {
    //注入service,用来将日志信息保存在数据库
    @Resource
    private SystemLogService systemLogService;

    //配置接入点,监控springMVC下的all action
    @Pointcut("execution(* com.fuhuadata.web.springmvc.BusinessOrderAction.*(..))")
    private void controllerAspect(){
        System.out.print("进入切面环绕通知");
    }//定义一个切入点

    @Around("controllerAspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //系统日志实体对象
        System.out.println("进入切面处理");
         SystemLog log = new SystemLog();
        //获取登录用户账户
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.setUserId(LoginUtils.getLoginId());
        log.setUserName(LoginUtils.getLoginName());
        ////获取系统时间
        //String time = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
        //SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //Date date = sdf.parse(time);
        //log.setDate(DateUtil.getDateTimeFormat());//执行时间

        //获取客户端ip
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if(StringUtils.isNotBlank(ip)&&ip.indexOf(",")>0){
            String[] ips = ip.split(",");
            ip=ips[0];
        }
        if(StringUtils.isNotBlank(ip)&&ip.indexOf("，")>0){
            String[] ips = ip.split("，");
            ip=ips[0];
        }
        log.setIp(ip);
        //方法通知前获取时间
        long start = System.currentTimeMillis();
        // 拦截的实体类，就是当前正在执行的controller
        Object target = pjp.getTarget();
        // 拦截的方法名称,当前正在执行的方法
        String methodName = pjp.getSignature().getName();
        // 拦截的方法参数
        Object[] args = pjp.getArgs();
        //存放的方法参数
        log.setParementers(args.toString());
        // 拦截的放参数类型
        Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Class[] parameterTypes = msig.getMethod().getParameterTypes();

        Object object = null;
        // 获得被拦截的方法
        Method method = null;
        try {
            method = target.getClass().getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e1) {
            e1.printStackTrace();
        } catch (SecurityException e1) {
            e1.printStackTrace();
        }
        if (null != method) {
            // 判断是否包含自定义的注解SystemLogAnnotation，
            if (method.isAnnotationPresent(SystemLogAnnotation.class)) {
                SystemLogAnnotation systemlog = method.getAnnotation(SystemLogAnnotation.class);
                log.setModule(systemlog.module());
                log.setMethod(systemlog.methods());
                try {
                    object = pjp.proceed();
                    long end = System.currentTimeMillis();
                    //将计算好的时间保存在实体中
                    log.setResponseDate((int) (end-start));
                    log.setCommit("执行成功！");
                    //保存进数据库
                    systemLogService.addSystemLog(log);
                } catch (Throwable e) {
                    long end = System.currentTimeMillis();
                    log.setResponseDate((int) (end-start));
                    log.setCommit("执行失败");
                    systemLogService.addSystemLog(log);
                }
            } else {//没有包含注解
                object = pjp.proceed();
            }
        } else { //不需要拦截直接执行
            object = pjp.proceed();
        }
        return object;
    }
}
