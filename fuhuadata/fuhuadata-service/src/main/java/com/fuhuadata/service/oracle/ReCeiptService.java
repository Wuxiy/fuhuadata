package com.fuhuadata.service.oracle;

import com.fuhuadata.domain.mybatis.Receipt;
import com.fuhuadata.domain.oracle.ReCeipt;
import org.springframework.stereotype.Service;

/**
 * <p>User: wangjie
 * <p>Date: 5/11/2017
 */
@Service
public class ReCeiptService extends BaseNcSyncService<ReCeipt, String, Receipt, Integer> {

    public ReCeiptService() {
        super();
        this.syncName = "订单收款记录";
    }

}
