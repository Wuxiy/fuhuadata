package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.AreaCode;
import com.fuhuadata.vo.MixNodeVO;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/14/2017
 */
public interface AreaCodeService extends BaseService<AreaCode, String> {

    /**
     * 获取用户关联地区
     * @param userId
     * @return
     */
    List<AreaCode> listAreaCodesByUserId(Integer userId);

    /**
     * 获取用户关联地区的树节点
     * @param userId
     * @return
     */
    List<MixNodeVO> listAreaCodeNodesByUserId(Integer userId);

    /**
     * 获取用户完整的地区树
     * @param userId
     * @return
     */
    List<MixNodeVO> getAreaTreeArraysByUserId(Integer userId);
}
