package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * 通用同步服务
 * <p>User: wangjie
 * <p>Date: 4/20/2017
 */
public interface BaseSyncService<E extends BaseEntity<ID>, ID extends Serializable>
        extends BaseService<E, ID> {

    int saveDocs(List<E> docs);

    int deleteAll();
}
