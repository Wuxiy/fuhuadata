package com.fuhuadata.service;

import com.fuhuadata.domain.PackingArchives;
import com.fuhuadata.domain.ProductInfo;

public interface BCodeService {
    /**
     *
     * @return 下一个商机编号
     */
    public  String  getNextBusinessCode();

    /**
     *
     * @return 下一个订单编号
     */
    public String getNextOrderCode();

    /**
     *
     * @return 下一个标准产品编号
     */
    public String getNextStandardProductCode(ProductInfo productInfo);

    /**
     *
     * @return 下一个包材后缀序号
     */
    public String getNextPackagingMaterialCode(PackingArchives packingArchives);


}