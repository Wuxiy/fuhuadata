package com.fuhuadata.service;

import com.fuhuadata.domain.PackingArchives;
import com.fuhuadata.domain.ProductInfo;

public interface BCodeService {
    /**
     *
     * @return 下一个商机编号
     */
    public  String  genNextBusinessCode();

    /**
     *
     * @return 下一个订单编号
     */
    public String genNextOrderCode();


    /**
     *
     * @return 下一个标准产品编号
     */
    public String genNextStandardProductCode(ProductInfo productInfo);

    /**
     *
     * @return 下一个包材后缀编号
     */
    public String genNextPackagingMaterialCode(PackingArchives packingArchives);


}