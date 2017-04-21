package com.fuhuadata.service.oracle;

import com.fuhuadata.domain.mybatis.Formatdoc;
import com.fuhuadata.domain.oracle.FormatDoc;
import org.springframework.stereotype.Service;

/**
 * <p>User: wangjie
 * <p>Date: 4/20/2017
 */
@Service
public class FormatDocService extends BaseNcSyncService<FormatDoc, String, Formatdoc, String> {

    public FormatDocService() {
        this.syncName = "数据格式";
    }

}
