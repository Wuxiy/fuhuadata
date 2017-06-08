package com.fuhuadata.service.mybatis.doc;

import com.fuhuadata.domain.doc.BankType;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Optional;

/**
 * <p>User: wangjie
 * <p>Date: 5/25/2017
 */
@Service
public class BankTypeServiceImpl extends BaseServiceImpl<BankType, Integer>
        implements BankTypeService {

    @Override
    public List<BankType> listBankTypes(BankType query) {

        Example example = newExample();

        return listByExample(example);
    }

    @Override
    public BankType getByCode(String code) {

        if (StringUtils.isBlank(code)) {
            return null;
        }

        BankType query = newEntity();
        query.setCode(code);

        return get(query);
    }

    @Override
    public Optional<BankType> getOptByCode(String code) {

        return Optional.ofNullable(getByCode(code));
    }
}
