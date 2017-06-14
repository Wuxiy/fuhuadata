package com.fuhuadata.dao.mapper.business;

import com.fuhuadata.dao.mapper.BaseMapper;
import com.fuhuadata.domain.business.BusinessBuyContractProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessBuyContractProductMapper extends BaseMapper<BusinessBuyContractProduct, Integer> {

    /**
     * 获取销售合同产品
     * @param pkContract
     * @return
     */
    List<BusinessBuyContractProduct> listProducts(@Param("pkContract") String pkContract);
}