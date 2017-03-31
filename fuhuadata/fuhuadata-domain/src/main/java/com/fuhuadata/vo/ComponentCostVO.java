package com.fuhuadata.vo;

import com.fuhuadata.domain.ComponentCost;
import com.fuhuadata.domain.ProductComponent;

/**
 * Created by intanswer on 2017/3/31.
 */
public class ComponentCostVO {

    private ComponentCost componentCost;

    private ProductComponent[] productComponents;

    public ComponentCost getComponentCost() {
        return componentCost;
    }

    public void setComponentCost(ComponentCost componentCost) {
        this.componentCost = componentCost;
    }

    public ProductComponent[] getProductComponents() {
        return productComponents;
    }

    public void setProductComponents(ProductComponent[] productComponents) {
        this.productComponents = productComponents;
    }
}
