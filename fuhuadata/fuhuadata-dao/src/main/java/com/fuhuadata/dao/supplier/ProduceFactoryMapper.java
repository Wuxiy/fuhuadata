package com.fuhuadata.dao.supplier;

import com.fuhuadata.dao.mapper.BaseMapper;
import com.fuhuadata.domain.supplier.ProduceFactory;

import java.util.List;

public interface ProduceFactoryMapper extends BaseMapper<ProduceFactory, Integer> {

    List<ProduceFactory> listFactories()
}