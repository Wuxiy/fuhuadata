package com.fuhuadata.service.oracle;

import com.fuhuadata.domain.mybatis.Portdoc;
import com.fuhuadata.domain.oracle.PortDoc;
import org.springframework.stereotype.Service;

/**
 * <p>User: wangjie
 * <p>Date: 4/20/2017
 */
@Service
public class PortDocService extends BaseNcSyncService<PortDoc, String, Portdoc, String> {

    public PortDocService() {
        this.syncName = "港口档案";
    }

}
