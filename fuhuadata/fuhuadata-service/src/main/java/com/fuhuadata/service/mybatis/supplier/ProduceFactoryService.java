package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.common.BankAccBas;
import com.fuhuadata.domain.mybatis.supplier.SupplierLinkman;
import com.fuhuadata.domain.supplier.ProduceFactory;
import com.fuhuadata.domain.supplier.ProduceFactoryInfo;
import com.fuhuadata.domain.supplier.ProduceFactoryQuery;
import com.fuhuadata.service.mybatis.BaseService;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/23/2017
 */
public interface ProduceFactoryService extends BaseService<ProduceFactory, Integer> {

    PageInfo<ProduceFactory> listFactories(ProduceFactoryQuery query);

    List<BankAccBas> listBankAccOfFactory(Integer factoryId);

    List<SupplierLinkman> listLinkmenOfFactory(Integer factoryId);

    ProduceFactory getFactory(Integer factoryId);

    ProduceFactory saveFactory(ProduceFactoryInfo factoryInfo);

    ProduceFactory updateFactory(ProduceFactoryInfo factoryInfo);
}
