package com.fuhuadata.service.oracle;

import com.fuhuadata.dao.oracle.NcInComeMapper;
import com.fuhuadata.domain.mybatis.Income;
import com.fuhuadata.domain.oracle.InCome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/20/2017
 */
@Service
public class InComeService extends BaseNcSyncService<InCome, String, Income, String> {
    @Autowired
    private NcInComeMapper ncInComeMapper;
    public InComeService() {
        super();
        this.syncName = "收款协议";
    }

    @Override
    protected void processNcDocToCrmDoc(InCome ncDoc, Income crmDoc) {
        super.processNcDocToCrmDoc(ncDoc, crmDoc);
        crmDoc.setPaymentday(Integer.valueOf(ncDoc.getFhzqdays()));
    }
    @Override
    protected List<InCome> getNcDocs(){
        return ncInComeMapper.getAllInCome();
    }
}
