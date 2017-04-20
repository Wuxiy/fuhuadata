package com.fuhuadata.service.oracle;

import com.fuhuadata.dao.mapper.BaseMapper;
import com.fuhuadata.domain.mybatis.BaseEntity;
import com.fuhuadata.util.ReflectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/20/2017
 */
public class BaseNcService<E extends BaseEntity<ID>, ID extends Serializable> implements DataSourceOracle {

    Logger logger = LoggerFactory.getLogger(getClass());

    protected BaseMapper<E, ID> baseMapper;

    @Autowired
    public void setBaseMapper(BaseMapper<E, ID> baseMapper) {
        this.baseMapper = baseMapper;
    }

    protected final Class<E> entityClass;

    public BaseNcService() {
        this.entityClass = ReflectUtils.findParameterizedType(getClass(), 0);
    }

    List<E> list() {
        return baseMapper.selectAll();
    }

}
