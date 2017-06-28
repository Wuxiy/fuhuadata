package com.fuhuadata.service.mybatis.customs;

import com.fuhuadata.dao.mapper.customs.CustomsCompanyMapper;
import com.fuhuadata.domain.customs.CustomsCompany;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/23/2017
 */
@Service
public class CustomsCompanyServiceImpl extends BaseServiceImpl<CustomsCompany, Integer>
        implements CustomsCompanyService {

    private CustomsCompanyMapper getCompanyMapper() {
        return (CustomsCompanyMapper) baseMapper;
    }

    private CustomsCompanyMapper getCompanyMapperBatch() {
        return (CustomsCompanyMapper) getMapperBatch();
    }

    @Override
    public List<CustomsCompany> listBatch() {
        return getCompanyMapperBatch().selectAll();
    }
}
