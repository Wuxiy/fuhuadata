package com.fuhuadata.service.mybatis.doc;

import com.fuhuadata.domain.doc.BankDoc;
import com.fuhuadata.domain.doc.BankDocQuery;
import com.fuhuadata.service.mybatis.BaseService;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/25/2017
 */
public interface BankDocService extends BaseService<BankDoc, Integer> {

    /**
     * 查询银行档案
     * @param query
     * @return
     */
    List<BankDoc> listDocs(BankDocQuery query);
}
