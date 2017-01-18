package com.fuhuadata.web.util;

import java.lang.annotation.*;

/**
 * 模块和方法注解
 * Created by wuxi on 2017/1/9.
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLogAnnotation {
    String module() default "";
    String methods() default "";
}
