package com.fuhuadata.vo;

import com.fuhuadata.domain.ProductInfo;
import com.fuhuadata.domain.ProductWare;
import com.fuhuadata.util.JsonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *  productInfo view
 * Created by intanswer on 2017/3/4.
 */
public class ProductInfoVO {

    private ProductInfo productInfo;

    private List<ProductWare> wares;

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

    public void addWare(ProductWare productWare){
        if(wares ==null){
            this.wares = new ArrayList<ProductWare>();
        }
        this.wares.add(productWare);
    }

}
