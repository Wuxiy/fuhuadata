package com.fuhuadata.service.mybatis.doc;

import com.fuhuadata.domain.doc.BankDoc;
import com.fuhuadata.domain.doc.BankDocQuery;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/25/2017
 */
@Service
public class BankDocServiceImpl extends BaseServiceImpl<BankDoc, Integer>
        implements BankDocService {

    @Override
    public List<BankDoc> listDocs(BankDocQuery query) {

        Example example = newExample();
        Example.Criteria criteria = example.createCriteria();

        if (null != query) {
            if (StringUtils.isNotEmpty(query.getName())) {
                criteria.andLike("name", "%" + query.getName() + "%");
            }
            if (StringUtils.isNotEmpty(query.getPkBanktype())) {
                criteria.andEqualTo("pkBanktype", query.getPkBanktype());
            }
        }

        return listByExample(example);
    }
}
