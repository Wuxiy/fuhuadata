package com.fuhuadata.vo;

import com.fuhuadata.domain.ComponentCost;
import com.fuhuadata.domain.KProductComponent;

import javax.validation.Valid;

/**
 * 成分价格新增更新view
 * Created by intanswer on 2017/3/31.
 */
public class ComponentCostVO {

    @Valid
    private ComponentCost componentCost;//成分价格

    @Valid
    private KProductComponent[] kProductComponents;//适用产品分类

    public ComponentCostVO(){
    }

    public ComponentCost getComponentCost() {
        return componentCost;
    }

    public void setComponentCost(ComponentCost componentCost) {
        this.componentCost = componentCost;
    }


    public KProductComponent[] getkProductComponents() {
        return kProductComponents;
    }

    public void setkProductComponents(KProductComponent[] kProductComponents) {
        this.kProductComponents = kProductComponents;
    }
}
