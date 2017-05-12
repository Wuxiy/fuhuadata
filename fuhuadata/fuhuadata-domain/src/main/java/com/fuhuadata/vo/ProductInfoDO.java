package com.fuhuadata.vo;

import com.fuhuadata.domain.ProductComponent;
import com.fuhuadata.domain.ProductInfo;

import javax.validation.Valid;

/**
 * 标准产品新增和更新接受类
 * Created by intanswer on 2017/3/31.
 */
public class ProductInfoDO {

    @Valid
    private ProductInfo productInfo;

    private ProductComponent[] productComponents;//加工成分产品


    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public ProductComponent[] getProductComponents() {
        return productComponents;
    }

    public void setProductComponents(ProductComponent[] productComponents) {
        this.productComponents = productComponents;
    }
}
