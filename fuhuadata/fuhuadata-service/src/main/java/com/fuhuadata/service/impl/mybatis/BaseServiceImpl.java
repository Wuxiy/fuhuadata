package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.dao.mapper.BaseMapper;
import com.fuhuadata.domain.mybatis.BaseEntity;
import com.fuhuadata.service.mybatis.BaseService;
import com.fuhuadata.util.ReflectUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.Serializable;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 3/23/2017
 */
public abstract class BaseServiceImpl<E extends BaseEntity<ID>, ID extends Serializable>
        implements BaseService<E, ID> {

    protected BaseMapper<E, ID> baseMapper;

    protected SqlSession sqlSessionBatch;

    @Autowired
    public void setBaseMapper(BaseMapper<E, ID> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Autowired
    @Qualifier("sqlSessionBatch")
    public void setSqlSession(SqlSession sqlSessionBatch) {
        this.sqlSessionBatch = sqlSessionBatch;
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
        System.out.println("baseMapper 类型：" + baseMapper.getClass());
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

    @Override
    public int update(List<E> entices) {
        int count = 0;

        for (E entity : entices) {
            count += update(entity);
        }
        return count;
    }

    public int updateSelective(E entity) {
        return baseMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int updateBatch(List<E> entices) {
        int count = 0;

        BaseMapper<E, ID> mapperBatch = sqlSessionBatch.getMapper(baseMapper.getClass());
        for (E entity : entices) {
            count += mapperBatch.updateByPrimaryKey(entity);
        }
        return count;
    }

    public int delete(ID id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    public int delete(E entity) {
        return baseMapper.delete(entity);
    }
}
