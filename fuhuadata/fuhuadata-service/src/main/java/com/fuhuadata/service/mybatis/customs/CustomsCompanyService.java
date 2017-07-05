package com.fuhuadata.service.mybatis.customs;

import com.fuhuadata.domain.customs.CustomsCompany;
import com.fuhuadata.service.mybatis.BaseService;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/23/2017
 */
public interface CustomsCompanyService extends BaseService<CustomsCompany, Integer> {

    List<CustomsCompany> listBatch();

    List<CustomsCompany> listTopCompanies();

    List<CustomsCompany> listCompanies(List<Integer> companyIds);
}
