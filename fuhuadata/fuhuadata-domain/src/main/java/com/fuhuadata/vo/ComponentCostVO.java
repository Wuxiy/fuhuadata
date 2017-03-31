package com.fuhuadata.vo;

import com.fuhuadata.domain.ComponentCost;
import com.fuhuadata.domain.KProductComponent;

/**
 * Created by intanswer on 2017/3/31.
 */
public class ComponentCostVO {

    private ComponentCost componentCost;//成分价格

    private KProductComponent[] KProductComponents;//适用产品分类

    public ComponentCost getComponentCost() {
        return componentCost;
    }

    public void setComponentCost(ComponentCost componentCost) {
        this.componentCost = componentCost;
    }

    public KProductComponent[] getKProductComponents() {
        return KProductComponents;
    }

    public void setKProductComponents(KProductComponent[] KProductComponents) {
        this.KProductComponents = KProductComponents;
    }
}
