package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.dao.mapper.BaseMapper;
import com.fuhuadata.domain.mybatis.BaseEntity;
import com.fuhuadata.service.mybatis.BaseService;
import com.fuhuadata.util.ReflectUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 3/23/2017
 */
public abstract class BaseServiceImpl<E extends BaseEntity<ID>, ID extends Serializable>
        implements BaseService<E, ID> {

    protected BaseMapper<E, ID> baseMapper;

    @Autowired
    public void setBaseMapper(BaseMapper<E, ID> baseMapper) {
        this.baseMapper = baseMapper;
    }

    /**
     * 实体类型
     */
    protected final Class<E> entityClass;

    public BaseServiceImpl() {
        this.entityClass = ReflectUtils.findParameterizedType(getClass(), 0);
    }

    @Override
    public E get(ID id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    public E get(E entity) {
        return baseMapper.selectOne(entity);
    }

    public List<E> list(E entity) {
        return baseMapper.select(entity);
    }

    public List<E> list() {
        return baseMapper.selectAll();
    }

    public List<E> listByExample(Object example) {
        return baseMapper.selectByExample(example);
    }

    public int save(E entity) {
        return baseMapper.insert(entity);
    }

    public int saveSelective(E entity) {
        return baseMapper.insertSelective(entity);
    }

    public int update(E entity) {
        return baseMapper.updateByPrimaryKey(entity);
    }

    public int updateSelective(E entity) {
        return baseMapper.updateByPrimaryKeySelective(entity);
    }

    public int delete(ID id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    public int delete(E entity) {
        return baseMapper.delete(entity);
    }
}
