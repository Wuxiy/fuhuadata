package com.fuhuadata.service.mybatis.common;

import com.fuhuadata.domain.common.BankAccBas;
import com.fuhuadata.domain.common.BankAccType;
import com.fuhuadata.service.mybatis.BaseService;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/25/2017
 */
public interface BankAccBasService extends BaseService<BankAccBas, Integer> {

    /**
     * 获取银行账号
     * @param accType 账户类型
     * @param customerId
     * @return
     */
    List<BankAccBas> listBankAccs(short accType, Integer customerId);

    /**
     * 获取银行账号
     * @param accType 银行账号类别
     * @return
     */
    List<BankAccBas> listBankAccs(BankAccType accType);

    /**
     * 批量删除银行账号
     * @param bankIds
     * @return
     */
    List<BankAccBas> deleteBanks(List<Integer> bankIds);

    /**
     * 新增 or 更新银行账号
     * @param banks
     * @return
     */
    List<BankAccBas> saveOrUpdateBanks(List<BankAccBas> banks);
}
