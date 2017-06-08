package com.fuhua.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fuhuadata.web.common.JsonMapper;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>User: wangjie
 * <p>Date: 5/10/2017
 */
@ContextConfiguration({"classpath:spring-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseIT {

    public static ObjectMapper jsonMapper = new JsonMapper(JsonInclude.Include.ALWAYS);

    static {
        jsonMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }
}
