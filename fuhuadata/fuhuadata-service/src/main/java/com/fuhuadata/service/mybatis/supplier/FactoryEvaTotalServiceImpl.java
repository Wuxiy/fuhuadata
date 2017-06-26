package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.dao.mapper.FactoryEvaTotalMapper;
import com.fuhuadata.domain.business.BusinessBuyContract;
import com.fuhuadata.domain.supplier.FactoryEvaTotal;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.fuhuadata.service.mybatis.business.BusinessBuyContractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * <p>User: wangjie
 * <p>Date: 6/5/2017
 */
@Service
public class FactoryEvaTotalServiceImpl extends BaseServiceImpl<FactoryEvaTotal, Integer>
        implements FactoryEvaTotalService {

    private FactoryEvaItemService evaItemService;

    @Resource
    private BusinessBuyContractService buyContractService;

    @Resource
    private ProduceFactoryService factoryService;

    @Resource
    public void setEvaItemService(FactoryEvaItemService evaItemService) {
        this.evaItemService = evaItemService;
    }

    private FactoryEvaTotalMapper getEvaTotalMapper() {
        return (FactoryEvaTotalMapper) baseMapper;
    }

    @Override
    public FactoryEvaTotal getTotalAndItemsByOrderId(Integer orderId) {

        if (null == orderId) {
            return null;
        }

        return getOptByOrderId(orderId)
                .map(total -> {
                    total.setItems(evaItemService.listItemAndScoreByOrderId(orderId));
                    return total;
                })
                .orElse(null);
    }

    @Override
    public FactoryEvaTotal getByOrderId(Integer orderId) {

        if (null == orderId) {
            return null;
        }

        FactoryEvaTotal total = newEntity();
        total.setOrderId(orderId);

        return get(total);
    }

    @Override
    public Optional<FactoryEvaTotal> getOptByOrderId(Integer orderId) {

        return Optional.ofNullable(getByOrderId(orderId));
    }

    @Override
    public FactoryEvaTotal saveOrUpdate(FactoryEvaTotal evaTotal) {

        if (null == evaTotal || evaTotal.getOrderId() == null) {
            return null;
        }

        Integer orderId = evaTotal.getOrderId();

        Integer totalId = getOptByOrderId(orderId).map(FactoryEvaTotal::getId).orElse(null);

        evaTotal.setId(totalId);

        saveOrUpdateSelective(evaTotal);// 更新概览信息

        evaItemService.saveOrUpdate(orderId, evaTotal.getItems());// 更新评分明细

        caculateSupplierTotalScore(evaTotal.getOrderId());// 计算加工厂的综合评分并保存

        return evaTotal;
    }

    private void caculateSupplierTotalScore(Integer orderId) {

        if (null == orderId) {
            return;
        }

        buyContractService.getOpt(orderId)
                .map(BusinessBuyContract::getCvendorid)
                .ifPresent(pkSupplier -> {
                    Double totalScore = Optional.ofNullable(getTotalScoreByPkSupplier(pkSupplier)).orElse(0.0);
                    factoryService.updateFactoryEvaScore(pkSupplier, totalScore);
                });
    }

    @Override
    public Double getTotalScoreByPkSupplier(String pkSupplier) {

        if (StringUtils.isEmpty(pkSupplier)) {
            return 0.0;
        }

        return getEvaTotalMapper().getTotalScoreByPkSupplier(pkSupplier);
    }
}
