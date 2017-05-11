package com.fuhuadata.service.oracle;

import com.fuhuadata.domain.mybatis.Incoterm;
import com.fuhuadata.domain.oracle.IncoTerm;
import org.springframework.stereotype.Service;

/**
 * <p>User: wangjie
 * <p>Date: 4/20/2017
 */
@Service
public class IncoTermService extends BaseNcSyncService<IncoTerm, String, Incoterm, String> {

    public IncoTermService() {
        super();
        this.syncName = "贸易术语档案";
    }

}
