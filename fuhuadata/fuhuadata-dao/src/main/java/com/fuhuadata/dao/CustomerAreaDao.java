package com.fuhuadata.dao;

import com.fuhuadata.domain.CustomerArea;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Think on 2017/3/9.
 */
public interface CustomerAreaDao {

    /**
     * 查询数据库中所有最下级地区及其大区信息
     * @return
     */
    public List<CustomerArea> getAllCustomerAreaList();
}
