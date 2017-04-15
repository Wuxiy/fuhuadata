package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.AreaClass;
import com.fuhuadata.vo.MixNodeVO;

import java.util.List;
import java.util.Map;

/**
 * <p>User: wangjie
 * <p>Date: 4/14/2017
 */
public interface AreaClassService extends BaseService<AreaClass, Integer> {

    /**
     * 获取全部大区
     * @return
     */
    List<AreaClass> listAreaClass();

    List<MixNodeVO> listAllAreaClassNodes();

    Map<String, MixNodeVO> getAllAreaClassNodesMap();

}
