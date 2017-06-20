package com.fuhuadata.vo.Supplier;

import com.fuhuadata.domain.mybatis.supplier.ForwardingScore;

import java.util.List;

/**
 * 评分详情表
 * Created by wuxiy on 2017/6/9.
 */
public class ScoreInfoVO<T,E> {
    /**评分分值**/
    private List<T> scoreList;
    /**评分项**/
    private List<ScoreTermsVO> terms;
    /**评分总情**/
    private E totalScore;


    public List<T> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<T> scoreList) {
        this.scoreList = scoreList;
    }

    public List<ScoreTermsVO> getTerms() {
        return terms;
    }

    public void setTerms(List<ScoreTermsVO> terms) {
        this.terms = terms;
    }


    public E getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(E totalScore) {
        this.totalScore = totalScore;
    }
}
