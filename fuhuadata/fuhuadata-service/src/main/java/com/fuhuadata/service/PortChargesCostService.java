package com.fuhuadata.service;

import com.fuhuadata.domain.PortChargesCost;
import com.fuhuadata.domain.query.PortChargesCostQuery;
import com.fuhuadata.domain.query.Result;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sound.sampled.Port;
import java.util.List;

/**
 * 港杂费service
 * Created by intanswer on 2017/1/17.
 */
public interface PortChargesCostService {
    public Result<PortChargesCost> addPortChargesCost(PortChargesCost portChargesCost);

    public Result updatePortChargesCostById(int id,PortChargesCost portChargesCost);

    public Result deletePortChargesCostById(int id);

    public Result<PortChargesCost> getPortChargesCostById(int id);

    public List<PortChargesCost> getAllPortChargesCosts();

    public Result<List<PortChargesCost>> getPortChargesCostsByQuery(PortChargesCostQuery portChargesCostQuery);

    public Result<List<PortChargesCost>> getPortChargesCostsByPage(PortChargesCostQuery portChargesCostQuery);

    public Result<Integer> count(PortChargesCostQuery portChargesCostQuery);
}
