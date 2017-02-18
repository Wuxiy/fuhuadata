package com.fuhuadata.manager;

import com.fuhuadata.domain.ExhibitionInfo;
import com.fuhuadata.domain.MarketTraining;
import com.fuhuadata.domain.query.ExhibitionInfoQuery;
import com.fuhuadata.domain.query.MarketTrainingQuery;
import com.fuhuadata.domain.query.Result;

import java.util.List;

/**
 * 营销培训manager
 * Created by intanswer on 2017/1/12.
 */
public interface MarketTrainingManager {

    public MarketTraining addMarketTraining(MarketTraining marketTraining);

    public boolean updateMarketTrainingById(int id,MarketTraining marketTraining);

    public boolean deleteMarketTrainingById(int id);

    public MarketTraining getMarketTrainingById(int id);

    public List<ExhibitionInfo> getAllMarketTrainings();

    public List<ExhibitionInfo> getMarketTrainingByQuery(ExhibitionInfoQuery exhibitionInfoQuery);

    public Result<List<MarketTraining>> getMarketTrainingsByPage(MarketTrainingQuery marketTrainingQuery);

    public int count(MarketTrainingQuery marketTrainingQuery);

}
