package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.LinkmanType;
import com.fuhuadata.domain.mybatis.supplier.SupplierLinkman;
import com.fuhuadata.service.mybatis.BaseService;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/27/2017
 */
public interface SupplierLinkmanService extends BaseService<SupplierLinkman, Integer> {

    /**
     * 获取供应商联系人
     * @param type
     * @param supplierId
     * @return
     */
    List<SupplierLinkman> listLinkmen(LinkmanType type, Integer supplierId);

    /**
     * 保存或更新联系人
     * @param linkmen
     * @return
     */
    int saveOrUpdateLinkmen(List<SupplierLinkman> linkmen);

    /**
     * 删除联系人
     * @param type
     * @param manIds
     * @return
     */
    int deleteLinkmen(LinkmanType type, List<Integer> manIds);
}