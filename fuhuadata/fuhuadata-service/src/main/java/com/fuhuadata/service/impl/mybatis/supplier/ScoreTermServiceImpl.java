package com.fuhuadata.service.impl.mybatis.supplier;

import com.fuhuadata.dao.mapper.supplier.ScoreTermMapper;
import com.fuhuadata.domain.mybatis.supplier.EvaluationValue;
import com.fuhuadata.domain.mybatis.supplier.ScoreTerm;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.fuhuadata.service.mybatis.supplier.EvaluationValueService;
import com.fuhuadata.service.mybatis.supplier.ScoreTermService;
import com.fuhuadata.vo.Supplier.ScoreTermsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by wuxiy on 2017/6/2.
 */
@Service
public class ScoreTermServiceImpl extends BaseServiceImpl<ScoreTerm,Integer> implements ScoreTermService {

    private ScoreTermMapper getScoreTermMapper() {
        return (ScoreTermMapper) baseMapper;
    }

    @Autowired
    private EvaluationValueService evaluationValueService;

    @Override
    public List<ScoreTermsVO> evaluationIndexItem(Integer type) {
        List<ScoreTerm> scoreTermsThree = getScoreTermMapper().ScoreItemThree(type);
        List<ScoreTerm> scoreTermsTwo = getScoreTermMapper().ScoreItemTwo(type);
        List<ScoreTerm> scoreTermsFirst = getScoreTermMapper().ScoreItemFirst(type);
        List<EvaluationValue> valueList = evaluationValueService.ListEvaluetionValueByType(type);
        List<ScoreTermsVO> listf = new ArrayList<>();
        List<ScoreTermsVO> listtw = new ArrayList<>();
        List<ScoreTermsVO> listth = new ArrayList<>();
        //底层分值
        for(ScoreTerm scoreTerm:scoreTermsThree){
            ScoreTermsVO scoreTermsVO = new ScoreTermsVO();
            scoreTermsVO.setItemName(scoreTerm.getThreeLevelIndex());
            scoreTermsVO.setItemParentName(scoreTerm.getTwoLevelIndex());
            scoreTermsVO.setItemId(scoreTerm.getId());
            scoreTermsVO.setItemFullMarks(scoreTerm.getItemFullMarks());
            scoreTermsVO.setItemOrder(scoreTerm.getItemOrder());
            for(EvaluationValue evaluationValue : valueList){
                if(evaluationValue.getEvaluationItemId()==scoreTerm.getId()){
                    scoreTermsVO.addValues(evaluationValue);
                }
            }
            listth.add(scoreTermsVO);
        }
        //二层分值
        for(ScoreTerm scoreTerm:scoreTermsTwo) {
            ScoreTermsVO scoreTermsVO = new ScoreTermsVO();
            scoreTermsVO.setItemName(scoreTerm.getTwoLevelIndex());
            scoreTermsVO.setItemParentName(scoreTerm.getFirstLevelIndex());

            for (ScoreTermsVO th : listth) {
                if (scoreTermsVO.getItemName().equals(th.getItemParentName())){
                    scoreTermsVO.addChildNode(th);
                }
            }
            listtw.add(scoreTermsVO);
        }
        //首层分值
        for(ScoreTerm scoreTerm:scoreTermsFirst) {
            ScoreTermsVO scoreTermsVO = new ScoreTermsVO();
            scoreTermsVO.setItemName(scoreTerm.getFirstLevelIndex());
            for (ScoreTermsVO tw : listtw) {
                if (scoreTermsVO.getItemName().equals(tw.getItemParentName())){
                    scoreTermsVO.addChildNode(tw);
                }
            }
            listf.add(scoreTermsVO);
        }
        return listf;
    }

}
