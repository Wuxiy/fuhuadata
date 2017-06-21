package com.fuhuadata.service.mybatis.customs;

import com.fuhuadata.domain.customs.CustomsData;
import com.fuhuadata.service.mybatis.BaseService;

import java.io.InputStream;

/**
 * <p>User: wangjie
 * <p>Date: 6/20/2017
 */
public interface CustomsDataService extends BaseService<CustomsData, Long> {

    void importCustomsData(InputStream inputStream);
}
