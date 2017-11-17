package com.fuhuadata.dao.oracle;

import com.fuhuadata.dao.mapper.BaseMapper;
import com.fuhuadata.domain.oracle.InCome;

import java.util.List;

public interface NcInComeMapper extends BaseMapper<InCome, String> {
    List<InCome> getAllInCome();
}