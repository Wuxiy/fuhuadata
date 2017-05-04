package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.CustomerPurchaseProduct;
import com.fuhuadata.service.CustomerPurchaseProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>User: wangjie
 * <p>Date: 5/4/2017
 */
@RequestMapping("/customer/market")
@Controller
public class CustomerMarketController extends BaseController<CustomerPurchaseProduct, Integer> {

    private CustomerPurchaseProductService purchaseProductService;

    @Autowired
    public void setPurchaseProductService(CustomerPurchaseProductService purchaseProductService) {
        this.purchaseProductService = purchaseProductService;
    }

}
