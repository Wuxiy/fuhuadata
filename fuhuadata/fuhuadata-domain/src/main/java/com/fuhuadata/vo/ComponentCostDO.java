package com.fuhuadata.vo;

import com.fuhuadata.domain.ComponentCost;
import com.fuhuadata.domain.KProductComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库返回成分价格详情实体
 * Created by intanswer on 2017/4/1.
 */
public class ComponentCostDO {

    private ComponentCost componentCost;
    private List<KProductComponent> kProductComponents;

    public ComponentCost getComponentCost() {
        return componentCost;
    }

    public void setComponentCost(ComponentCost componentCost) {
        this.componentCost = componentCost;
    }

    public List<KProductComponent> getkProductComponents() {
        return kProductComponents;
    }

    public void setkProductComponents(List<KProductComponent> kProductComponents) {
        this.kProductComponents = kProductComponents;
    }

    public void addKProductComponent(KProductComponent kProductComponent){
        if(kProductComponents==null){
            kProductComponents = new ArrayList<KProductComponent>();
        }
        kProductComponents.add(kProductComponent);
    }
}
