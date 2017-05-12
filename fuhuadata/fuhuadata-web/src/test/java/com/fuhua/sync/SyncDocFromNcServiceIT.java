package com.fuhua.sync;

import com.fuhua.test.BaseIT;
import com.fuhuadata.service.oracle.ReCeiptService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * <p>User: wangjie
 * <p>Date: 5/11/2017
 */
public class SyncDocFromNcServiceIT extends BaseIT {

    @Resource
    ReCeiptService reCeiptService;

    @Test
    public void testReceiptSync() {
        reCeiptService.ncToCrm();
    }
}
