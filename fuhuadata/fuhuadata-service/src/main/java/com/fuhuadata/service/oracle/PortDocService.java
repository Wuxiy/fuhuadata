package com.fuhuadata.service.oracle;

import com.fuhuadata.dao.oracle.NcPortDocMapper;
import com.fuhuadata.domain.mybatis.Portdoc;
import com.fuhuadata.domain.oracle.PortDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/20/2017
 */
@Service
public class PortDocService extends BaseNcSyncService<PortDoc, String, Portdoc, String> {
    @Autowired
    protected NcPortDocMapper ncPortDocMapper;

    public PortDocService() {
        super();
        this.syncName = "港口档案";
    }

    @Override
    protected List<PortDoc> getNcDocs() {
        return ncPortDocMapper.getPortDoc();
    }
}
