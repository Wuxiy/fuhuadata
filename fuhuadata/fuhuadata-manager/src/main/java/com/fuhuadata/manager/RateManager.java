package com.fuhuadata.manager;

import com.fuhuadata.domain.Rate;
import com.fuhuadata.domain.query.RateQuery;
import com.fuhuadata.domain.query.Result;
import org.apache.cxf.ws.rm.soap.RetransmissionQueueImpl;

import java.util.List;

/**
 * 费率Manager
 * Created by young on 2017/2/9.
 */
public interface RateManager {

    public Rate addRate(Rate rate);

    public boolean updateRateById(int id,Rate rate);

    public boolean deleteRateById(int id);

    public List<Rate> getRateByQuery(RateQuery rateQuery);

    public Result<List<Rate>> getRatesByPage(RateQuery rateQuery);

    public int count(RateQuery rateQuery);
}
