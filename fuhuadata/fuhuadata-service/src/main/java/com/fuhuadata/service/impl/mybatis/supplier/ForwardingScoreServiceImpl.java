package com.fuhuadata.service.impl.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.ForwardingEvaluationScoreRelation;
import com.fuhuadata.domain.mybatis.supplier.ForwardingScore;
import com.fuhuadata.domain.query.QueryForwardingScore;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.fuhuadata.service.mybatis.supplier.ForwardingEvaluationScoreRelationService;
import com.fuhuadata.service.mybatis.supplier.ForwardingScoreService;
import com.fuhuadata.vo.Supplier.ScoreVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.persistence.Transient;
import java.util.List;

/**
 *  货代评分 service
 * Created by wuxiy on 2017/5/23.
 */
@Service
public class ForwardingScoreServiceImpl extends BaseServiceImpl<ForwardingScore,Integer>
        implements ForwardingScoreService{
    @Autowired
    private ForwardingEvaluationScoreRelationService forwardingEvaluationScoreRelationService;
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

    @Override
    @Transient
    public int saveScore(ScoreVO<ForwardingScore, ForwardingEvaluationScoreRelation> scoreVO) {
        Integer scoreId=null;
        //保存月度表
        if(scoreVO.getScore()!=null){
            scoreId = saveOrUpdateSelective(scoreVO.getScore());
        }
        //评分详情制月度表id
        for(ForwardingEvaluationScoreRelation fesr : scoreVO.getList()){
            fesr.setForwardingScoreId(scoreId);
        }
        if(scoreVO.getList().get(0).getId()!=null){
            return forwardingEvaluationScoreRelationService.updateBatchSelective(scoreVO.getList());
        }
        else return forwardingEvaluationScoreRelationService.saveList(scoreVO.getList());
    }

}
