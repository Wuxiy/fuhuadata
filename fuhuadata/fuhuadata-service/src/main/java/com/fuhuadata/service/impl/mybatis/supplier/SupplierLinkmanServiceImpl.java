package com.fuhuadata.service.impl.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.LinkmanType;
import com.fuhuadata.domain.mybatis.supplier.SupplierLinkman;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.fuhuadata.service.mybatis.supplier.SupplierLinkmanService;
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
                .andEqualTo("suppierId", supplierId);


        return listByExample(example);
    }

    @Override
    public List<SupplierLinkman> listLinkmen(LinkmanType type) {
        Example example=newExample();
        example.createCriteria().andEqualTo("supplierType",type.key);

        return null;
    }

    @Override
    public int saveOrUpdateLinkmen(List<SupplierLinkman> linkmen) {

        if (CollectionUtils.isEmpty(linkmen)) {
            return 0;
        }

        linkmen.forEach(this::saveOrUpdateSelective);

        return linkmen.size();
    }

    @Override
    public int deleteLinkmen(LinkmanType type, List<Integer> manIds) {

        if (CollectionUtils.isEmpty(manIds)) {
            return 0;
        }

        Example example = newExample();
        example.createCriteria()
                .andEqualTo("supplierType", type.key)
                .andIn("id", manIds);

        return delete(example);
    }
}
