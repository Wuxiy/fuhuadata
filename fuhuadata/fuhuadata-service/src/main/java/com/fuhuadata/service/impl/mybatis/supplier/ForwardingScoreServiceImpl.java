package com.fuhuadata.service.impl.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.ForwardingScore;
import com.fuhuadata.domain.query.QueryForwardingScore;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.fuhuadata.service.mybatis.supplier.ForwardingScoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 *  货代评分 service
 * Created by wuxiy on 2017/5/23.
 */
@Service
public class ForwardingScoreServiceImpl extends BaseServiceImpl<ForwardingScore,Integer>
        implements ForwardingScoreService{
    @Override
    public PageInfo<ForwardingScore> getForwardingScoreList(QueryForwardingScore query) {
        if(query == null) return null;
        Example example = newExample();
        Example.Criteria criteria = example.createCriteria().andEqualTo("forwardingId", query.getForwardingId());
        example.orderBy("evaluate_time desc");
        PageHelper.startPage(query.getIndex(),query.getPageSize());
        List<ForwardingScore> list = listByExample(example);
        return new PageInfo<>(list);
    }


}
