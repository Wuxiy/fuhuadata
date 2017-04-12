package com.fuhuadata.domain;

import java.io.Serializable;

/**
 * Created by hexingfu on 2017/4/12.
 */
public class ProductRequireBase implements Serializable {
    private BusinessOrderProduct businessOrderProduct;
    private BusinessOrderProductComponent[] businessOrderProductComponents;

    public BusinessOrderProduct getBusinessOrderProduct() {
        return businessOrderProduct;
    }

    public void setBusinessOrderProduct(BusinessOrderProduct businessOrderProduct) {
        this.businessOrderProduct = businessOrderProduct;
    }

    public BusinessOrderProductComponent[] getBusinessOrderProductComponents() {
        return businessOrderProductComponents;
    }

    public void setBusinessOrderProductComponents(BusinessOrderProductComponent[] businessOrderProductComponents) {
        this.businessOrderProductComponents = businessOrderProductComponents;
    }
}
