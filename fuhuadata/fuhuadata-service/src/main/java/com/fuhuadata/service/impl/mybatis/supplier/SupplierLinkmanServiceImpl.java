package com.fuhuadata.service.impl.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.LinkmanType;
import com.fuhuadata.domain.mybatis.supplier.SupplierLinkman;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.fuhuadata.service.mybatis.supplier.SupplierLinkmanService;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/27/2017
 */
@Service
public class SupplierLinkmanServiceImpl extends BaseServiceImpl<SupplierLinkman, Integer>
        implements SupplierLinkmanService {

    @Override
    public List<SupplierLinkman> listLinkmen(LinkmanType type, Integer supplierId) {

        if (null == supplierId) {
            return Collections.emptyList();
        }

        Example example = newExample();
        example.createCriteria()
                .andEqualTo("supplierType", type.key)
                .andEqualTo("supplierId", supplierId);


        return listByExample(example);
    }

    @Override
    public List<SupplierLinkman> listLinkmen(LinkmanType type) {
        Example example=newExample();
        example.createCriteria().andEqualTo("supplierType",type.key);

        return null;
    }

    @Override
    public List<SupplierLinkman> saveOrUpdateLinkmen(List<SupplierLinkman> linkmen) {

        if (CollectionUtils.isEmpty(linkmen)) {
            return Collections.emptyList();
        }

        List<SupplierLinkman> bdMen = Lists.newArrayList();

        linkmen.forEach((entity) -> {
            saveOrUpdateSelective(entity);
            bdMen.add(get(entity));
        });

        return bdMen;
    }

    @Override
    public List<SupplierLinkman> deleteLinkmen(LinkmanType type, List<Integer> manIds) {

        if (CollectionUtils.isEmpty(manIds)) {
            return Collections.emptyList();
        }

        Example example = newExample();
        example.createCriteria()
                .andEqualTo("supplierType", type.key)
                .andIn("id", manIds);

        List<SupplierLinkman> linkmen = listByExample(example);
        linkmen.forEach(linkMan -> {
            delete(linkMan);
            linkMan.setDeletedStatus(0);
        });

        return linkmen;
    }
}
