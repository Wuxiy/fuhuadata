package com.fuhuadata.service.oracle;

import com.fuhuadata.domain.mybatis.Income;
import com.fuhuadata.domain.oracle.InCome;
import org.springframework.stereotype.Service;

/**
 * <p>User: wangjie
 * <p>Date: 4/20/2017
 */
@Service
public class InComeService extends BaseNcSyncService<InCome, String, Income, String> {

    public InComeService() {
        this.syncName = "收款协议";
    }

    @Override
    protected void processNcDocToCrmDoc(InCome ncDoc, Income crmDoc) {
        super.processNcDocToCrmDoc(ncDoc, crmDoc);
        crmDoc.setPaymentday(Integer.valueOf(ncDoc.getFhzqdays()));
    }
}
