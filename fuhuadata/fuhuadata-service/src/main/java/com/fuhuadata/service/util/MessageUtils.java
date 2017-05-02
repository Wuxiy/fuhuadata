package com.fuhuadata.service.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

/**
 * <p>User: wangjie
 * <p>Date: 4/28/2017
 */
public class MessageUtils {

    private static Logger logger = LoggerFactory.getLogger(MessageUtils.class);

    private static MessageSource messageSource;

    /**
     * 根据消息键和参数 获取消息
     * 委托给spring messageSource
     *
     * @param code 消息键
     * @param args 参数
     * @return
     */
    public static String message(String code, Object... args) {
        ensureMessageSource();

        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, args, "", locale);
    }

    public static String message(MessageSourceResolvable resolvable) {
        ensureMessageSource();

        return messageSource.getMessage(resolvable, LocaleContextHolder.getLocale());
    }

    private static void ensureMessageSource() {
        if (messageSource == null) {
            messageSource = SpringUtils.getBean(MessageSource.class);
        }
    }

}
