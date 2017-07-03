package com.fuhuadata.service.impl.mybatis.supplier;

import com.fuhuadata.dao.mapper.supplier.WarehouseScoreMapper;
import com.fuhuadata.domain.mybatis.supplier.WarehouseEvaluationScoreRelation;
import com.fuhuadata.domain.mybatis.supplier.WarehouseInfo;
import com.fuhuadata.domain.mybatis.supplier.WarehouseScore;
import com.fuhuadata.domain.query.QueryWarehouseScore;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.fuhuadata.service.mybatis.supplier.WarehouseEvaluationScoreRelationService;
import com.fuhuadata.service.mybatis.supplier.WarehouseInfoService;
import com.fuhuadata.service.mybatis.supplier.WarehouseScoreService;
import com.fuhuadata.service.util.LoginUtils;
import com.fuhuadata.vo.Supplier.ScoreVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 *   仓库评分 service
 * Created by wuxiy on 2017/5/23.
 */
@Service
public class WarehouseScoreServiceImpl extends BaseServiceImpl<WarehouseScore,Integer>
        implements WarehouseScoreService {
    private WarehouseScoreMapper getWarehouseScoreMapper(){
        return (WarehouseScoreMapper) baseMapper;
    }
    @Autowired
     private  WarehouseEvaluationScoreRelationService warehouseEvaluationScoreRelationService;
    @Autowired
    private WarehouseInfoService warehouseInfoService;
    @Override
    public PageInfo<WarehouseScore> getWarehouseScoreList(QueryWarehouseScore query) {
        if(query == null) return null;
        Example example = newExample();
        example.orderBy("monthTime").desc();
        example.createCriteria().andEqualTo("warehouseId", query.getWarehouseId());
        PageHelper.startPage(query.getIndex(),query.getPageSize());
        List<WarehouseScore> list = listByExample(example);
        return new PageInfo<>(list);
    }

    @Override
    @Transient
    public int saveScore(ScoreVO<WarehouseScore, WarehouseEvaluationScoreRelation> scoreVO,String month,String year) {
        Integer scoreId=null;
        if(scoreVO.getScore().getTotalScore()==null){
            scoreVO.getScore().setTotalScore(scoreVO.getScore().getWarehouseScore().add(scoreVO.getScore().getAccuracyScore()).add(scoreVO.getScore().getCheckStockScore().add(scoreVO.getScore().getPackageScore().add(scoreVO.getScore().getTimeScore()))));
        }
        if(scoreVO.getScore()!=null&&scoreVO.getScore().getId()!=null){
            scoreVO.getScore().setLastmodifyUserId(LoginUtils.getLoginId());
            scoreVO.getScore().setLastmodifyUserName(LoginUtils.getLoginName());
            scoreVO.getScore().setCreateUserId(LoginUtils.getLoginId());
            scoreVO.getScore().setCreateUserName(LoginUtils.getLoginName());
            scoreVO.getScore().setEvaluateUserId(LoginUtils.getLoginId());
            scoreVO.getScore().setEvaluateUserName(LoginUtils.getLoginName());
            scoreVO.getScore().setEvaluateTime(new Date());
            scoreVO.getScore().setModifyTime(new Date());
            updateSelective(scoreVO.getScore());
            scoreId = scoreVO.getScore().getId();
        }else if(scoreVO.getScore()!=null&&scoreVO.getScore().getId()==null){
            scoreVO.getScore().setCreateUserId(LoginUtils.getLoginId());
            scoreVO.getScore().setCreateUserName(LoginUtils.getLoginName());
            scoreVO.getScore().setLastmodifyUserId(LoginUtils.getLoginId());
            scoreVO.getScore().setLastmodifyUserName(LoginUtils.getLoginName());
            scoreId = saveOrUpdateSelective(scoreVO.getScore());
        }
        //评分详情月度表id
        for(WarehouseEvaluationScoreRelation wesr : scoreVO.getList()){
            wesr.setWarehouseScoreId(scoreId);
        }
        warehouseEvaluationScoreRelationService.deleteByScoreId(scoreId);
        //新增下个月评价时间记录
        int monthd = Integer.parseInt(month);
        String monthTime = year+"-"+monthd;
        WarehouseScore warehouseScoreSel = new WarehouseScore();
        warehouseScoreSel.setMonthTime(monthTime);
        Example example = newExample();
        Example.Criteria criteria = example.createCriteria().andEqualTo("monthTime",monthTime);
        criteria.andEqualTo("warehouseId",scoreVO.getScore().getWarehouseId());
        List<WarehouseScore> list = listByExample(example);
        if(list==null||list.size()==0){
            if(month.equals("12")){
                int y= Integer.parseInt(year)+1;
                monthTime = y+"-"+"1";
            }
            else  {
                int m = Integer.parseInt(month);
                monthTime = year+"-"+m;
            }
            warehouseScoreSel.setMonthTime(monthTime);
            warehouseScoreSel.setWarehouseId(scoreVO.getScore().getWarehouseId());
            save(warehouseScoreSel);
        }
        //更新仓库综合评分
        int warehouseId = scoreVO.getScore().getWarehouseId();
        WarehouseInfo warehouseInfo = new WarehouseInfo();
        warehouseInfo.setId(warehouseId);
        warehouseInfo.setCombinedScoring(getWarehouseScoreMapper().getCombinedScoringByWarehouseId(warehouseId));
        warehouseInfoService.updateSelective(warehouseInfo);
        return warehouseEvaluationScoreRelationService.saveList(scoreVO.getList());
    }
}
