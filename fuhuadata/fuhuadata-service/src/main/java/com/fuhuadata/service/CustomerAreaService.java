package com.fuhuadata.service;

import com.fuhuadata.domain.CustomerArea;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.vo.CategoryTree;

import java.util.List;

/**
 * Created by hexingfu on 2017/3/9.
 */
public interface CustomerAreaService {
    /**
     * 根据主键加载子节点
     * @param id
     * @return
     */
    public Result<List<CustomerArea>> getAllCustomerAreaList(String id);
}
