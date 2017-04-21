package com.fuhuadata.service.oracle;

import com.fuhuadata.domain.mybatis.Currtype;
import com.fuhuadata.domain.oracle.CurrType;
import org.springframework.stereotype.Service;

/**
 * <p>User: wangjie
 * <p>Date: 4/20/2017
 */
@Service
public class CurrTypeService extends BaseNcSyncService<CurrType, String, Currtype, String> {

    public CurrTypeService() {
        this.syncName = "币种档案";
    }

}
