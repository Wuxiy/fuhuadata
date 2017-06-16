package com.fuhuadata.web.springmvc.supplier;

import com.fuhuadata.domain.common.BankAccBas;
import com.fuhuadata.domain.mybatis.supplier.SupplierLinkman;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.domain.supplier.ProduceFactory;
import com.fuhuadata.domain.supplier.ProduceFactoryInfo;
import com.fuhuadata.domain.supplier.ProduceFactoryQuery;
import com.fuhuadata.service.mybatis.supplier.ProduceFactoryService;
import com.fuhuadata.web.springmvc.mybatis.BaseController;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 加工厂
 * <p>User: wangjie
 * <p>Date: 5/22/2017
 */
@RequestMapping("/supplier/factories")
@Controller
public class FactoryAction extends BaseController<ProduceFactory, Integer> {

    private ProduceFactoryService factoryService;

    @Resource
    public void setFactoryService(ProduceFactoryService factoryService) {
        this.factoryService = factoryService;
    }

    /**
     * 加工厂列表
     * @return
     */
    @RequestMapping(value = "/vm", method = RequestMethod.GET)
    public String index() {
        return "supplierInformation/factoryList";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo listFactories(ProduceFactoryQuery query) {
        Result<PageInfo<ProduceFactory>> result = Result.newResult(false);

        PageInfo<ProduceFactory> factoryPageInfo = factoryService.listFactories(query);
        result.addDefaultModel(factoryPageInfo);
        result.setSuccess(true);

        return result.getResultPojo();
    }

    /**
     * 获取加工厂信息
     * @param factoryId
     * @return
     */
    @RequestMapping(value = "/{factoryId}", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo getFactory(@PathVariable Integer factoryId) {
        Result<ProduceFactory> result = Result.newResult(false);

        ProduceFactory factory = factoryService.getFactory(factoryId);
        result.addDefaultModel(factory);
        result.setSuccess(true);

        return result.getResultPojo();
    }

    /**
     * 加工厂银行账户
     * @param factoryId
     * @return
     */
    @RequestMapping(value = "{factoryId}/banks", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo listFactoryBanks(@PathVariable Integer factoryId) {

        Result<List<BankAccBas>> result = Result.newResult(false);

        List<BankAccBas> banks = factoryService.listBankAccOfFactory(factoryId);
        result.addDefaultModel(banks);
        result.setSuccess(true);

        return result.getResultPojo();
    }

    /**
     * 加工厂联系人
     * @param factoryId
     * @return
     */
    @RequestMapping(value = "{factoryId}/linkmen", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo listFactoryLinkmen(@PathVariable Integer factoryId) {

        Result<List<SupplierLinkman>> result = Result.newResult(false);

        List<SupplierLinkman> banks = factoryService.listLinkmenOfFactory(factoryId);
        result.addDefaultModel(banks);
        result.setSuccess(true);

        return result.getResultPojo();
    }

    /**
     * 加工厂新增
     * @return
     */
    @RequestMapping(value = "/add/vm")
    public String productAddVm() {
        return "supplierInformation/factoryBasic";
    }

    /**
     * 保存加工厂
     * @param factoryInfo
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ResultPojo saveFactory(@RequestBody ProduceFactoryInfo factoryInfo) {
        Result<ProduceFactory> result = Result.newResult(false);

        ProduceFactory factory = factoryService.saveFactory(factoryInfo);
        result.addDefaultModel(factory);
        result.setSuccess(true);

        return result.getResultPojo();
    }

    /**
     * 更新加工厂
     * @param factoryInfo
     * @return
     */
    @RequestMapping(value = "/{factoryId}", method = RequestMethod.PUT)
    @ResponseBody
    public ResultPojo updateFactory(@PathVariable String factoryId, @RequestBody ProduceFactoryInfo factoryInfo) {
        Result<ProduceFactory> result = Result.newResult(false);

        ProduceFactory factory = factoryService.updateFactory(factoryInfo);
        result.addDefaultModel(factory);
        result.setSuccess(true);

        return result.getResultPojo();
    }

    @RequestMapping(value = "{factoryId}/vm", method = RequestMethod.GET)
    public String baseInfo(@PathVariable("factoryId") String id, Model model) {

        model.addAttribute("factoryId", id);
        return "supplierInformation/factoryBasic";
    }

    @RequestMapping(value = "/{factoryId}/products/vm", method = RequestMethod.GET)
    public String product(@PathVariable("factoryId") String id) {
        return "supplierInformation/factoryProduct";
    }

    @RequestMapping(value = "/{factoryId}/order/vm")
    public String order(@PathVariable("factoryId") String id) {
        return "supplierInformation/factoryOrder";
    }

    // 采购合同
    @RequestMapping(value = "/{factoryId}/buy/contracts/vm")
    public String buyContracts(@PathVariable Integer factoryId, Model model) {

        ProduceFactory factory = factoryService.getFactory(factoryId);

        model.addAttribute("factory", factory);

        return "supplierInformation/factoryOrder";
    }

    // 原药合同
    @RequestMapping(value = "/{factoryId}/orgi/contracts/vm")
    public String listOrgiContracts(@PathVariable Integer factoryId, Model model) {

        ProduceFactory factory = factoryService.getFactory(factoryId);
        model.addAttribute("factory", factory);

        return "supplierInformation/factoryACOrder";
    }

    @RequestMapping(value = "/{factoryId}/complaint/vm")
    public String complaint(@PathVariable("factoryId") String factoryId) {
        return "supplierInformation/factoryComplaint";
    }

    @RequestMapping(value = "/{factoryId}/delivery/delay/vm")
    public String deliveryDelay(@PathVariable("factoryId") String factoryId) {
        return "supplierInformation/factoryBackOrder";
    }
}
