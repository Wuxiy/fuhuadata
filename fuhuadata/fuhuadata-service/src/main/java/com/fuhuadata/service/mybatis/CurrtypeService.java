package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.Currtype;

/**
 * <p>User: wangjie
 * <p>Date: 4/20/2017
 */
public interface CurrtypeService extends BaseSyncService<Currtype, String> {

    /**
     * 根据币种 code 获取币种信息
     * @param code
     * @return
     */
    Currtype getByCode(String code);

}