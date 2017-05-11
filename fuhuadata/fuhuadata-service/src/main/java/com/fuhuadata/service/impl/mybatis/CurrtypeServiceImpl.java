package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.domain.mybatis.Currtype;
import com.fuhuadata.service.mybatis.CurrtypeService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/20/2017
 */
@Service
public class CurrtypeServiceImpl extends BaseSyncServiceImpl<Currtype, String>
        implements CurrtypeService {

    @Override
    public Currtype getByCode(String code) {
        Example example = newExample();
        example.createCriteria().andEqualTo("code", code);

        List<Currtype> currtypes = listByExample(example);
        if (currtypes.size() == 1) {
            return currtypes.get(0);
        }
        return null;
    }
}