package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.dao.supplier.FactoryEvaItemMapper;
import com.fuhuadata.domain.supplier.FactoryEvaItem;
import com.fuhuadata.domain.supplier.FactoryEvaScore;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * <p>User: wangjie
 * <p>Date: 6/5/2017
 */
@Service
public class FactoryEvaItemServiceImpl extends BaseServiceImpl<FactoryEvaItem, Integer>
        implements FactoryEvaItemService {

    private FactoryEvaScoreService evaScoreService;

    private FactoryEvaItemMapper getEvaItemMapper() {
        return (FactoryEvaItemMapper) baseMapper;
    }

    @Resource
    public void setEvaScoreService(FactoryEvaScoreService evaScoreService) {
        this.evaScoreService = evaScoreService;
    }

    @Override
    public List<FactoryEvaItem> listItemAndScoreByOrderId(Integer orderId) {

        if (null == orderId) {
            return Collections.emptyList();
        }

        return getEvaItemMapper().listItemAndScoreByOrderId(orderId);
    }

    @Override
    public List<FactoryEvaItem> saveOrUpdate(Integer orderId, List<FactoryEvaItem> items) {

        if (null == orderId || CollectionUtils.isEmpty(items)) {
            return Collections.emptyList();
        }

        List<FactoryEvaScore> evaScores = evaScoreService.listByOrderId(orderId);

        List<FactoryEvaItem> oldItems = listItemAndScoreByOrderId(orderId);
        List<FactoryEvaScore> newScores = oldItems.stream()
                .map(FactoryEvaItem::getId)
                .map(evaItemId -> {
                    FactoryEvaScore newScore = evaScores.stream()
                            .filter(evaScore -> evaItemId.equals(evaScore.getItemId()))
                            .findAny()
                            .orElseGet(FactoryEvaScore::new);

                    items.stream()
                            .filter(newItem -> evaItemId.equals(newItem.getId()))
                            .findAny()
                            .ifPresent(newItem -> {
                                newScore.setOrderId(orderId);
                                newScore.setItemId(evaItemId);
                                newScore.setScore(newItem.getEvaScore());
                                newScore.setRemark(newItem.getEvaRemark());
                            });

                    return newScore;
                })
                .collect(toList());

        evaScoreService.saveOrUpdateScores(newScores);

        return items;
    }
}
