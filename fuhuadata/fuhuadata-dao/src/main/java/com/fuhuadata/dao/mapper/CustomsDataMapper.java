package com.fuhuadata.dao.mapper;

import com.fuhuadata.domain.customs.CustomsData;

public interface CustomsDataMapper extends BaseMapper<CustomsData, Long> {

    void saveCustomsData(CustomsData customsData);
}