package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.dao.mapper.BaseMapper;
import com.fuhuadata.domain.mybatis.BaseEntity;
import com.fuhuadata.service.mybatis.BaseSyncService;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/20/2017
 */
public class BaseSyncServiceImpl<E extends BaseEntity<ID>, ID extends Serializable>
        extends BaseServiceImpl<E, ID> implements BaseSyncService<E, ID> {

    @Override
    public int saveDocs(List<E> docs) {
        deleteAll();
        List<ID> ids = saveBatch(docs);
        return ids.size();
    }

    @Override
    public int deleteAll() {
        BaseMapper<E, ID> batchMapper = getBatchMapper();

        Example example = new Example(entityClass);
        example.createCriteria().andCondition("1=1");
        return batchMapper.deleteByExample(example);
    }
}
