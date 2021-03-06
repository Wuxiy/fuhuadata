package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.dao.supplier.ProduceFactoryMapper;
import com.fuhuadata.domain.business.BusinessBuyContractQuery;
import com.fuhuadata.domain.common.BankAccBas;
import com.fuhuadata.domain.common.BankAccType;
import com.fuhuadata.domain.mybatis.Organization;
import com.fuhuadata.domain.mybatis.supplier.LinkmanType;
import com.fuhuadata.domain.mybatis.supplier.SupplierLinkman;
import com.fuhuadata.domain.supplier.FactoryOrder;
import com.fuhuadata.domain.supplier.ProduceFactory;
import com.fuhuadata.domain.supplier.ProduceFactoryInfo;
import com.fuhuadata.domain.supplier.ProduceFactoryQuery;
import com.fuhuadata.manager.NCExchange.FactoryInfoToNC;
import com.fuhuadata.service.exception.ServiceException;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.fuhuadata.service.mybatis.OrganizationService;
import com.fuhuadata.service.mybatis.common.BankAccBasService;
import com.fuhuadata.service.util.LoginUtils;
import com.fuhuadata.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

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

    @Resource
    private FactoryInfoToNC factoryInfoToNC;

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

    @Override
    public ProduceFactory getFactoryInfo(Integer factoryId) {

        ProduceFactory factory = this.getFactory(factoryId);
        List<BankAccBas> bankAccBas = bankAccService.listBankAccs(BankAccType.Factory.key, factoryId);
        List<SupplierLinkman> linkmen = linkmanService.listLinkmen(LinkmanType.Factory, factoryId);

        factory.setBanks(bankAccBas);
        factory.setLinkmen(linkmen);

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
        saveSelective(factory);

        // 取出更新后的加工厂
        ProduceFactory newFactory = get(factory);
        newFactory.setBanks(factory.getBanks());
        newFactory.setLinkmen(factory.getLinkmen());
        factoryInfo.setFactory(newFactory);

        return handleBanksAndLinkmenAndToNc(factoryInfo);
    }

    private ProduceFactory handleBanksAndLinkmenAndToNc(ProduceFactoryInfo factoryInfo) {

        ProduceFactory factory = factoryInfo.getFactory();

        Integer factoryId = factory.getId();

        // 包含新增和删除的银行账户，删除的银行账户通过 deletedStatus 标识
        List<BankAccBas> banks = saveOrUpdateBanks(factoryId, factory.getBanks(), factoryInfo.getDeletedBankIds());

        // 包含新增和删除的联系人，删除的联系人通过 deletedStatus 标识
        List<SupplierLinkman> linkmen = saveOrUpdateLinkmen(factoryId, factory.getLinkmen(), factoryInfo.getDeletedLinkmanIds());

        factory.setBanks(banks);
        factory.setLinkmen(linkmen);

        // 同步到 NC
//        Map<String,HashMap> mapMap= null;
//        try {
//            mapMap = factoryInfoToNC.sendFactoryInfo(factory);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new ServiceException("nc同步失败", e);
//        }
//        Map<Integer,String> factoryPK=mapMap.get("factory");
//        if (factoryPK!=null){
//            this.updateFactoryPk(factoryId,factoryPK.get(factoryId));
//        }
//        Map<Integer,String> bankaccPK=mapMap.get("bankacc");
//        if (bankaccPK!=null){
//            for (Integer id:bankaccPK.keySet()){
//                bankAccService.updateBankPk(id,bankaccPK.get(id));
//            }
//        }
        return factory;
    }

    private void fillLoginInfo(ProduceFactory factory) {
        factory.setModifyAccount(LoginUtils.getLoginAccount());
        factory.setModifyName(LoginUtils.getLoginName());
        factory.setModifyTime(new Date());
    }

    @Override
    public ProduceFactory updateFactory(ProduceFactoryInfo factoryInfo) {

        if (factoryInfo == null || factoryInfo.getFactory() == null) {
            return null;
        }

        ProduceFactory factory = factoryInfo.getFactory();
        fillLoginInfo(factory);

        updateSelective(factory);
        ProduceFactory newFactory = get(factory);
        newFactory.setBanks(factory.getBanks());
        newFactory.setLinkmen(factory.getLinkmen());
        factoryInfo.setFactory(newFactory);

        return handleBanksAndLinkmenAndToNc(factoryInfo);
    }

    @Override
    public Optional<ProduceFactory> getOptFactoryByPk(String pkSupplier) {

        if (StringUtils.isEmpty(pkSupplier)) {
            return Optional.empty();
        }

        ProduceFactory factory = newEntity();
        factory.setPkSupplier(pkSupplier);

        return this.getOpt(factory);
    }

    @Override
    public void updateFactoryEvaScore(String pkSupplier, Double totalScore) {

        if (StringUtils.isEmpty(pkSupplier) || totalScore == null) {
            throw new IllegalArgumentException("pkSupplier or totalScore can't be null");
        }

        this.getOptFactoryByPk(pkSupplier).ifPresent(factory -> {
            factory.setScore(new BigDecimal(totalScore));
            fillLoginInfo(factory);

            update(factory);
        });
    }

    @Override
    public List<FactoryOrder> listFactoryOrders(BusinessBuyContractQuery query) {

        PageHelper.startPage(query.getIndex(), query.getPageSize());
        return getFactoryMapper().listFactoryOrders(query);
    }

    @Override
    public ProduceFactory deleteFactoryInfo(Integer factoryId) {

        ProduceFactory factoryInfo = this.getFactoryInfo(factoryId);
        factoryInfo.getBanks()
                .forEach(bankAccService::delete);
        factoryInfo.getLinkmen()
                .forEach(linkmanService::delete);

        return factoryInfo;
    }

    @Override
    public ProduceFactory updateFactoryPk(Integer factoryId, String pkFactory) {

        ProduceFactory factory = this.get(factoryId);
        factory.setPkSupplier(pkFactory);
        this.update(factory);

        return factory;
    }

    /**
     * 保存、更新、删除银行账号
     *
     * @param factoryId
     * @param banks      新增、更新的银行账号
     * @param deletedIds 待删除的银行账号
     */
    private List<BankAccBas> saveOrUpdateBanks(Integer factoryId, List<BankAccBas> banks, List<Integer> deletedIds) {

        Optional.ofNullable(banks).ifPresent(bankAccs -> bankAccs.forEach(bank -> {
            bank.setAcctype(BankAccType.Factory.key);
            bank.setCustomerId(factoryId);
        }));

        // 保存、更新银行账号
        banks = bankAccService.saveOrUpdateBanks(banks);
        banks = new ArrayList<>(banks);

        // 删除银行账号
        List<BankAccBas> deleteBanks = bankAccService.deleteBanks(deletedIds);

        banks.addAll(deleteBanks);

        return banks;
    }

    /**
     * 保存、更新、删除联系人
     *
     * @param factoryId
     * @param linkmen   新增、更新的联系人
     * @param deleteIds 待删除的联系人
     */
    private List<SupplierLinkman> saveOrUpdateLinkmen(Integer factoryId, List<SupplierLinkman> linkmen, List<Integer> deleteIds) {

        Optional.ofNullable(linkmen).ifPresent(linkmans -> linkmans.forEach(linkman -> {
            linkman.setSupplierType(LinkmanType.Factory.key);
            linkman.setSupplierId(factoryId);
            linkman.setIsdefault(0);
        }));

        // 保存、更新联系人
        linkmen = linkmanService.saveOrUpdateLinkmen(linkmen);

        // 删除联系人
        List<SupplierLinkman> deleteLinkmen = linkmanService.deleteLinkmen(LinkmanType.Factory, deleteIds);

        linkmen.addAll(deleteLinkmen);

        return linkmen;
    }
}
