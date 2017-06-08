package com.fuhuadata.service.mybatis.doc;

import com.fuhuadata.domain.doc.BankType;
import com.fuhuadata.service.mybatis.BaseService;

import java.util.List;
import java.util.Optional;

/**
 * <p>User: wangjie
 * <p>Date: 5/25/2017
 */
public interface BankTypeService extends BaseService<BankType, Integer> {

    /**
     * 查找银行类别
     * @param query
     * @return
     */
    List<BankType> listBankTypes(BankType query);

    BankType getByCode(String code);

    Optional<BankType> getOptByCode(String code);
}
