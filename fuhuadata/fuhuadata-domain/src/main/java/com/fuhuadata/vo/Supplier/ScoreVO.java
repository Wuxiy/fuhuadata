package com.fuhuadata.vo.Supplier;


import java.util.List;

/**
 * 评分保存项VO
 * Created by wuxiy on 2017/6/9.
 **/
public class ScoreVO<T,E> {

    /**月度评分**/
    private T score ;
    /**评分项详情**/
    private List<E> List;

    public T getScore() {
        return score;
    }

    public void setScore(T score) {
        this.score = score;
    }

    public java.util.List<E> getList() {
        return List;
    }

    public void setList(java.util.List<E> list) {
        List = list;
    }
}
