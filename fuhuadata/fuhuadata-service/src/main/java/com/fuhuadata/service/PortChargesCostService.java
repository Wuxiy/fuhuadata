package com.fuhuadata.service;

import com.fuhuadata.domain.PortChargesCost;
import com.fuhuadata.domain.query.PortChargesCostQuery;
import com.fuhuadata.domain.query.Result;

import java.util.List;

/**
 * 港杂费service
 * Created by intanswer on 2017/1/17.
 */
public interface PortChargesCostService {

    public Result<PortChargesCost> addPortChargesCost(PortChargesCost portChargesCost);

    public Result<List<PortChargesCost>> getPortChargesCostsByPage(PortChargesCostQuery portChargesCostQuery);

    public Result<Integer> count(PortChargesCostQuery portChargesCostQuery);
}
