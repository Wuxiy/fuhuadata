package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.supplier.FactoryEvaTotal;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
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
    public void setEvaItemService(FactoryEvaItemService evaItemService) {
        this.evaItemService = evaItemService;
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

        getOptByOrderId(orderId).ifPresent(oldTotal -> {

            evaTotal.setId(oldTotal.getId());

            saveOrUpdateSelective(evaTotal);// 更新概览信息

            evaItemService.saveOrUpdate(orderId, evaTotal.getItems());// 更新评分明细
        });

        return evaTotal;
    }
}
