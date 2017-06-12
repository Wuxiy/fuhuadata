package com.fuhuadata.vo.Supplier;

import java.util.List;

/**
 * 评分详情表
 * Created by wuxiy on 2017/6/9.
 */
public class ScoreInfoVO<T> {
    /**评分分值**/
    private List<T> scoreList;
    /**评分项**/
    private List<ScoreTermsVO> terms;


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
}
