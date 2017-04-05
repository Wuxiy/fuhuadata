package com.fuhuadata.vo;

import com.fuhuadata.domain.ComponentCost;
import com.fuhuadata.domain.ProductComponent;
import com.fuhuadata.domain.ProductInfo;
import com.fuhuadata.domain.ProductWare;

import java.util.ArrayList;
import java.util.List;

/**
 *  productInfo view
 * Created by intanswer on 2017/3/4.
 */
public class ProductInfoVO {

    private ProductInfo productInfo;

    private List<ProductWare> wares;//规格型号

    private List<PhysicalProperities> index;//理化指标json

    private List<ProductComponent> processingComponents;//加工成分


    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public List<ProductWare> getWares() {
        return wares;
    }

    public void setWares(List<ProductWare> wares) {
        this.wares = wares;
    }

    public List<PhysicalProperities> getIndex() {
        return index;
    }

    public void setIndex(List<PhysicalProperities> index) {
        this.index = index;
    }

    public void addWare(ProductWare productWare){
        if(wares ==null){
            this.wares = new ArrayList<ProductWare>();
        }
        this.wares.add(productWare);
    }


    public void addIndex(PhysicalProperities physicalProperities){
        if(index == null){
            this.index=new ArrayList<PhysicalProperities>();
        }
        this.index.add(physicalProperities);
    }

    public List<ProductComponent> getProcessingComponents() {
        return processingComponents;
    }

    public void setProcessingComponents(List<ProductComponent> processingComponents) {
        this.processingComponents = processingComponents;
    }

    public void addProcessingComponents(ProductComponent productComponent){
        if(processingComponents == null){
            this.processingComponents=new ArrayList<ProductComponent>();
        }
        this.processingComponents.add(productComponent);
    }

}
