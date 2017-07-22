package com.fuhuadata.manager.NCExchange;

import com.fuhuadata.domain.supplier.ProduceFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangxiang on 2017/5/27.
 */
public interface FactoryInfoToNC {
    Map<String,HashMap> sendFactoryInfo(ProduceFactory factoryInfo) throws Exception;
}
