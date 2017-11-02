package com.fuhuadata.dao.oracle;

import com.fuhuadata.dao.mapper.BaseMapper;
import com.fuhuadata.domain.oracle.PortDoc;

import java.util.List;

public interface NcPortDocMapper extends BaseMapper<PortDoc, String> {
    List<PortDoc> getPortDoc();
}