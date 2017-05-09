package com.fuhua.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fuhuadata.domain.json.Views;
import com.fuhuadata.domain.mybatis.CustomerBaseInfo;
import com.fuhuadata.web.common.JsonMapper;
import org.junit.Test;

import java.util.Date;

/**
 * <p>User: wangjie
 * <p>Date: 5/9/2017
 */
public class JsonMapperTest {

    @Test
    public void testJsonView() throws JsonProcessingException {

        CustomerBaseInfo baseInfo = new CustomerBaseInfo();
        baseInfo.setCustomerId(2323);
        baseInfo.setNcId("1001D");
        baseInfo.setFullName("DJFI JFIEJ");
        baseInfo.setShortName("jfei");
        baseInfo.setPriceSensitivity("敏感");
        baseInfo.setLoyalty("老实");
        baseInfo.setCreateTime(new Date());

        JsonMapper instance = JsonMapper.getInstance();
        instance.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);

        String info = instance.writerWithView(Views.Viewable.class)
                .writeValueAsString(baseInfo);

        System.out.println(info);
    }
}
