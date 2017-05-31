package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.dao.supplier.ProduceFactoryMapper;
import com.fuhuadata.domain.common.BankAccBas;
import com.fuhuadata.domain.common.BankAccType;
import com.fuhuadata.domain.mybatis.Organization;
import com.fuhuadata.domain.mybatis.supplier.LinkmanType;
import com.fuhuadata.domain.mybatis.supplier.SupplierLinkman;
import com.fuhuadata.domain.supplier.ProduceFactory;
import com.fuhuadata.domain.supplier.ProduceFactoryInfo;
import com.fuhuadata.domain.supplier.ProduceFactoryQuery;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.fuhuadata.service.mybatis.OrganizationService;
import com.fuhuadata.service.mybatis.common.BankAccBasService;
import com.fuhuadata.service.util.LoginUtils;
import com.fuhuadata.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
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

    private SupplierLinkmanService linkmanService;

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

    @Resource
    public void setLinkmanService(SupplierLinkmanService linkmanService) {
        this.linkmanService = linkmanService;
    }

    @Override
    public PageInfo<ProduceFactory> listFactories(ProduceFactoryQuery query) {

        PageHelper.startPage(query.getIndex(), query.getPageSize());
        List<ProduceFactory> factories = getFactoryMapper().listFactories();

        factories.forEach(this::fillFactory);

        return new PageInfo<>(factories);
    }

    @Override
    public List<BankAccBas> listBankAccOfFactory(Integer factoryId) {

        return bankAccService.listBankAccs(BankAccType.Factory.key, factoryId);
    }

    @Override
    public List<SupplierLinkman> listLinkmenOfFactory(Integer factoryId) {

        return linkmanService.listLinkmen(LinkmanType.Factory, factoryId);
    }

    @Override
    public ProduceFactory getFactory(Integer factoryId) {

        ProduceFactory factory = get(factoryId);
        fillFactory(factory);

        return factory;
    }

    private void fillFactory(ProduceFactory factory) {

        // 设置组织名称
        Optional.ofNullable(factory).ifPresent(factoryConsumer -> {
            String orgName = Optional.ofNullable(organizationService.getByNcId(factoryConsumer.getPkOrg()))
                    .map(Organization::getName)
                    .orElse(null);
            factoryConsumer.setOrgName(orgName);
        });

        // 设置合作时间（月份）
        Date cooperateTime = factory.getCooperateTime();
        Optional.ofNullable(cooperateTime).ifPresent(date -> {
            LocalDate localDate = TimeUtils.dateToLocalDate(date);
            LocalDate now = LocalDate.now();

            long between = ChronoUnit.MONTHS.between(localDate, now);
            factory.setCoopMonths((int) between);
        });
    }

    @Override
    public ProduceFactory saveFactory(ProduceFactoryInfo factoryInfo) {
        if (factoryInfo == null || factoryInfo.getFactory() == null) {
            return null;
        }

        ProduceFactory factory = factoryInfo.getFactory();
        factory.setCreateAccount(LoginUtils.getLoginAccount());
        factory.setCreateName(LoginUtils.getLoginName());
        fillLoginInfo(factory);
        save(factory);

        Integer factoryId = factory.getId();

        saveOrUpdateBanks(factoryId, factory.getBanks(), factoryInfo.getDeletedBankIds());

        saveOrUpdateLinkmen(factoryId, factory.getLinkmen(), factoryInfo.getDeletedLinkmanIds());
        return factory;
    }

    private void fillLoginInfo(ProduceFactory factory) {
        factory.setModifyAccount(LoginUtils.getLoginAccount());
        factory.setModifyName(LoginUtils.getLoginName());
    }

    @Override
    public ProduceFactory updateFactory(ProduceFactoryInfo factoryInfo) {

        if (factoryInfo == null || factoryInfo.getFactory() == null) {
            return null;
        }

        ProduceFactory factory = factoryInfo.getFactory();
        fillLoginInfo(factory);
        updateSelective(factory);

        Integer factoryId = factory.getId();

        saveOrUpdateBanks(factoryId, factory.getBanks(), factoryInfo.getDeletedBankIds());

        saveOrUpdateLinkmen(factoryId, factory.getLinkmen(), factoryInfo.getDeletedLinkmanIds());
        return factory;
    }

    /**
     * 保存、更新、删除银行账号
     * @param factoryId
     * @param banks 新增、更新的银行账号
     * @param deletedIds 待删除的银行账号
     */
    private void saveOrUpdateBanks(Integer factoryId, List<BankAccBas> banks, List<Integer> deletedIds) {

        Optional.ofNullable(banks).ifPresent(bankAccs -> bankAccs.forEach(bank -> {
            bank.setAcctype(BankAccType.Factory.key);
            bank.setCustomerId(factoryId);
        }));

        // 保存、更新银行账号
        bankAccService.saveOrUpdateBanks(banks);

        // 删除银行账号
        bankAccService.deleteBanks(deletedIds);
    }

    /**
     * 保存、更新、删除联系人
     * @param factoryId
     * @param linkmen 新增、更新的联系人
     * @param deleteIds 待删除的联系人
     */
    private void saveOrUpdateLinkmen(Integer factoryId, List<SupplierLinkman> linkmen, List<Integer> deleteIds) {

        Optional.ofNullable(linkmen).ifPresent(linkmans -> linkmans.forEach(linkman -> {
            linkman.setSupplierType(LinkmanType.Factory.key);
            linkman.setSuppierId(factoryId);
        }));

        // 保存、更新联系人
        linkmanService.saveOrUpdateLinkmen(linkmen);

        // 删除联系人
        linkmanService.deleteLinkmen(LinkmanType.Factory, deleteIds);
    }
}
