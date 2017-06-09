package com.fuhuadata.service.impl.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.WarehouseEvaluationScoreRelation;
import com.fuhuadata.domain.mybatis.supplier.WarehouseScore;
import com.fuhuadata.domain.query.QueryWarehouseScore;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.fuhuadata.service.mybatis.supplier.WarehouseEvaluationScoreRelationService;
import com.fuhuadata.service.mybatis.supplier.WarehouseScoreService;
import com.fuhuadata.vo.Supplier.ScoreVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.persistence.Transient;
import java.util.List;

/**
 *   仓库评分 service
 * Created by wuxiy on 2017/5/23.
 */
@Service
public class WarehouseScoreServiceImpl extends BaseServiceImpl<WarehouseScore,Integer>
        implements WarehouseScoreService {

    @Autowired
     private  WarehouseEvaluationScoreRelationService warehouseEvaluationScoreRelationService;
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

    @Override
    @Transient
    public int saveScore(ScoreVO<WarehouseScore, WarehouseEvaluationScoreRelation> scoreVO) {
        Integer scoreId=null;
        //保存月度表
        if(scoreVO.getScore()!=null){
            scoreId = saveOrUpdateSelective(scoreVO.getScore());
        }
        //评分详情制月度表id
        for(WarehouseEvaluationScoreRelation fesr : scoreVO.getList()){
            fesr.setWarehouseScoreId(scoreId);
        }
        if(scoreVO.getList().get(0).getId()!=null){
            return warehouseEvaluationScoreRelationService.updateBatchSelective(scoreVO.getList());
        }
        else return warehouseEvaluationScoreRelationService.saveList(scoreVO.getList());
    }
}
