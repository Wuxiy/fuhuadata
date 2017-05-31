package com.fuhuadata.service.impl.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.ForwardingScore;
import com.fuhuadata.domain.mybatis.supplier.WarehouseScore;
import com.fuhuadata.domain.query.QueryWarehouseScore;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.fuhuadata.service.mybatis.supplier.WarehouseScoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 *   仓库评分 service
 * Created by wuxiy on 2017/5/23.
 */
@Service
public class WarehouseScoreServiceImpl extends BaseServiceImpl<WarehouseScore,Integer>
        implements WarehouseScoreService {

    @Override
    public PageInfo<WarehouseScore> getWarehouseScoreList(QueryWarehouseScore query) {
        if(query == null) return null;
        Example example = newExample();
        Example.Criteria criteria = example.createCriteria().andEqualTo("warehouseId", query.getWarehouseId());
        example.orderBy("evaluate_time desc");
        PageHelper.startPage(query.getIndex(),query.getPageSize());
        List<WarehouseScore> list = listByExample(example);
        return new PageInfo<>(list);
    }
}
