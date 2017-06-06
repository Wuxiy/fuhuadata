package com.fuhua.supplier.factory.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fuhua.test.BaseIT;
import com.fuhuadata.domain.supplier.FactoryEvaItem;
import com.fuhuadata.domain.supplier.FactoryEvaTotal;
import com.fuhuadata.service.mybatis.supplier.FactoryEvaItemService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/5/2017
 */
public class FactoryEvaTotalServiceIT extends BaseIT {

    @Resource
    private FactoryEvaItemService evaItemService;

    @Test
    public void testEvaItems() throws JsonProcessingException {

        List<FactoryEvaItem> factoryEvaItems = evaItemService.listItemAndScoreByOrderId(0);

        FactoryEvaTotal total = new FactoryEvaTotal();
        total.setItems(factoryEvaItems);

        System.out.println(jsonMapper.writeValueAsString(total));
    }
}
