package com.fuhuadata.domain.supplier;

import com.fuhuadata.domain.business.BusinessBuyContract;

/**
 * <p>User: wangjie
 * <p>Date: 6/26/2017
 */
public class FactoryOrder extends BusinessBuyContract {

    /**
     * 订单综合评分
     */
    private Short totalScore;

    public Short getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Short totalScore) {
        this.totalScore = totalScore;
    }
}
