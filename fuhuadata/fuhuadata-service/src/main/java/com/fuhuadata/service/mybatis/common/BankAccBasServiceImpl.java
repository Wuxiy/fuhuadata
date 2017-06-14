package com.fuhuadata.service.mybatis.common;

import com.fuhuadata.dao.mapper.BankAccBasMapper;
import com.fuhuadata.domain.common.BankAccBas;
import com.fuhuadata.domain.common.BankAccType;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
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
    public int deleteBanks(List<Integer> bankIds) {

        if (CollectionUtils.isEmpty(bankIds)) {
            return 0;
        }

        Example example = newExample();
        example.createCriteria().andIn("id", bankIds);

        return delete(example);
    }

    @Override
    public int saveOrUpdateBanks(List<BankAccBas> banks) {

        if (CollectionUtils.isEmpty(banks)) {
            return 0;
        }

        banks.forEach(bank -> {
            if (bank.getId() != null) {
                updateSelective(bank);
            } else {
                saveSelective(bank);
            }
        });

        return banks.size();
    }
}
