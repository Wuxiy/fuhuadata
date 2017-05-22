package com.fuhuadata.web.springmvc.supplier;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>User: wangjie
 * <p>Date: 5/22/2017
 */
@RequestMapping("/supplier/factory")
@Controller
public class FactoryAction {

    @RequestMapping(value = {"", "index"})
    public String index() {
        return "supplierInformation/factoryList";
    }

    @RequestMapping(value = "{factoryId}")
    public String baseInfo(@PathVariable("factoryId") String id) {
        return "supplierInformation/factoryBasic";
    }

    @RequestMapping(value = "/product/{factoryId}")
    public String product(@PathVariable("factoryId") String id) {
        return "supplierInformation/factoryProduct";
    }

    @RequestMapping(value = "/order/{factoryId}")
    public String order(@PathVariable("factoryId") String id) {
        return "supplierInformation/factoryOrder";
    }

    @RequestMapping(value = "/complaint/{factoryId}")
    public String complaint(@PathVariable("factoryId") String factoryId) {
        return "supplierInformation/factoryComplaint";
    }

    @RequestMapping(value = "/delivery/delay/{factoryId}")
    public String deliveryDelay(@PathVariable("factoryId") String factoryId) {
        return "supplierInformation/factoryBackOrder";
    }

}
