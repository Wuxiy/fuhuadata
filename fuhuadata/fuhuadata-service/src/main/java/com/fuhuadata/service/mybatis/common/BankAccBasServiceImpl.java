package com.fuhuadata.service.mybatis.common;

import com.fuhuadata.dao.mapper.BankAccBasMapper;
import com.fuhuadata.domain.common.BankAccBas;
import com.fuhuadata.domain.common.BankAccType;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/25/2017
 */
@Service
public class BankAccBasServiceImpl extends BaseServiceImpl<BankAccBas, Integer>
        implements BankAccBasService {

    private BankAccBasMapper getBankAccMapper() {
        return (BankAccBasMapper) baseMapper;
    }

    @Override
    public List<BankAccBas> listBankAccs(short accType, Integer customerId) {

        if (null == customerId) {
            return Collections.emptyList();
        }

        return getBankAccMapper().listBankAccs(accType, customerId);
    }

    @Override
    public List<BankAccBas> listBankAccs(BankAccType accType) {

        Example example = newExample();
        example.createCriteria().andEqualTo("acctype", accType.key);

        return listByExample(example);
    }

    @Override
    public List<BankAccBas> deleteBanks(List<Integer> bankIds) {

        if (CollectionUtils.isEmpty(bankIds)) {
            return Collections.emptyList();
        }

        Example example = newExample();
        example.createCriteria().andIn("id", bankIds);

        List<BankAccBas> banks = listByExample(example);
        banks.forEach((entity) -> {
            delete(entity);
            entity.setDeletedStatus(0);
        });

        return banks;
    }

    @Override
    public List<BankAccBas> saveOrUpdateBanks(List<BankAccBas> banks) {

        if (CollectionUtils.isEmpty(banks)) {
            return Collections.emptyList();
        }

        List<BankAccBas> bdBanks = Lists.newArrayList();

        banks.forEach(bank -> {
            if (bank.getId() != null) {
                updateSelective(bank);
            } else {
                saveSelective(bank);
            }

            bdBanks.add(get(bank));
        });

        return bdBanks;
    }

    @Override
    public BankAccBas updateBankPk(Integer bankId, String pkBank) {

        BankAccBas bank = this.get(bankId);
        bank.setPkBankaccbas(pkBank);
        this.update(bank);

        return bank;
    }
}
