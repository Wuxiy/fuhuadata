package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.WarehouseEvaluationScoreRelation;
import com.fuhuadata.domain.mybatis.supplier.WarehouseScore;
import com.fuhuadata.domain.query.QueryWarehouseScore;
import com.fuhuadata.service.mybatis.BaseService;
import com.fuhuadata.vo.Supplier.ScoreVO;
import com.github.pagehelper.PageInfo;

/**
 *   仓库评分 service
 * Created by wuxiy on 2017/5/23.
 */
public interface WarehouseScoreService extends BaseService<WarehouseScore,Integer> {
    PageInfo<WarehouseScore> getWarehouseScoreList(QueryWarehouseScore query);

    /**
     * 保存或更新
     * @param scoreVO
     * @return
     */
    int saveScore(ScoreVO<WarehouseScore,WarehouseEvaluationScoreRelation> scoreVO,String year,String month);
}
