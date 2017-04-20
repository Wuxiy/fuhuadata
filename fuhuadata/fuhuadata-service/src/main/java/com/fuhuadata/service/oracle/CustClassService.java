package com.fuhuadata.service.oracle;

import com.fuhuadata.domain.mybatis.Custclass;
import com.fuhuadata.domain.oracle.CustClass;
import org.springframework.stereotype.Service;

/**
 * <p>User: wangjie
 * <p>Date: 4/20/2017
 */
@Service
public class CustClassService extends BaseNcSyncService<CustClass, String, Custclass, String> {

    public CustClassService() {
        this.syncName = "客户基本分类档案";
    }

}
