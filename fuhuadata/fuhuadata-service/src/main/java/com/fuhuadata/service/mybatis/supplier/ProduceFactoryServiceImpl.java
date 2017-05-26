package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.dao.supplier.ProduceFactoryMapper;
import com.fuhuadata.domain.common.BankAccBas;
import com.fuhuadata.domain.common.BankAccType;
import com.fuhuadata.domain.mybatis.Organization;
import com.fuhuadata.domain.supplier.ProduceFactory;
import com.fuhuadata.domain.supplier.ProduceFactoryInfo;
import com.fuhuadata.domain.supplier.ProduceFactoryQuery;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.fuhuadata.service.mybatis.OrganizationService;
import com.fuhuadata.service.mybatis.common.BankAccBasService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * <p>User: wangjie
 * <p>Date: 5/23/2017
 */
@Service
public class ProduceFactoryServiceImpl extends BaseServiceImpl<ProduceFactory, Integer>
        implements ProduceFactoryService {

    private BankAccBasService bankAccService;

    private OrganizationService organizationService;

    private ProduceFactoryMapper getFactoryMapper() {
        return (ProduceFactoryMapper) baseMapper;
    }

    @Resource
    public void setBankAccService(BankAccBasService bankAccService) {
        this.bankAccService = bankAccService;
    }

    @Resource
    public void setOrganizationService(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @Override
    public PageInfo<ProduceFactory> listFactories(ProduceFactoryQuery query) {

        PageHelper.startPage(query.getIndex(), query.getPageSize());
        List<ProduceFactory> factories = getFactoryMapper().listFactories();

        return new PageInfo<>(factories);
    }

    @Override
    public List<BankAccBas> listBankAccOfFactory(Integer factoryId) {

        return bankAccService.listBankAccs(BankAccType.Factory.key, factoryId);
    }

    @Override
    public ProduceFactory getFactory(Integer factoryId) {

        ProduceFactory factory = get(factoryId);
        Optional.ofNullable(factory).ifPresent(factoryConsumer -> {
            String orgName = Optional.ofNullable(organizationService.getByNcId(factoryConsumer.getPkOrg()))
                    .map(Organization::getName)
                    .orElse(null);
            factoryConsumer.setOrgName(orgName);
        });

        return factory;
    }

    @Override
    public ProduceFactory saveFactory(ProduceFactoryInfo factoryInfo) {
        if (factoryInfo == null || factoryInfo.getFactory() == null) {
            return null;
        }

        ProduceFactory factory = factoryInfo.getFactory();
        save(factory);

        List<BankAccBas> banks = Optional.ofNullable(factory.getBanks()).orElse(Collections.emptyList());
        banks.forEach(bank -> {
            bank.setAcctype(BankAccType.Factory.key);
            bank.setCustomerId(factory.getId());
        });

        bankAccService.saveList(banks);

        return factory;
    }

    @Override
    public ProduceFactory updateFactory(ProduceFactoryInfo factoryInfo) {
        if (factoryInfo == null || factoryInfo.getFactory() == null) {
            return null;
        }

        ProduceFactory factory = factoryInfo.getFactory();
        updateSelective(factory);

        List<BankAccBas> banks = Optional.ofNullable(factory.getBanks()).orElse(Collections.emptyList());
        banks.forEach(bank -> {
            bank.setAcctype(BankAccType.Factory.key);
            bank.setCustomerId(factory.getId());
        });

        bankAccService.saveOrUpdateBanks(banks);
        return null;
    }
}
