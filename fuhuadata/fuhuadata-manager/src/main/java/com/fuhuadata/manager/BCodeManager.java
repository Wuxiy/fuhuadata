package com.fuhuadata.manager;

/**
 * Created by hexingfu on 2017/3/28.
 */
public interface BCodeManager {
    /**
     *
     * @return 下一个商机编码后缀序号
     */
    public  int  getNextBusinessCode();

    /**
     *
     * @return 下一个订单编码后缀序号
     */
    public int getNextOrderCode();

    /**
     *
     * @return 下一个标准产品后缀序号
     */
    public int getNextStandardProductCode();

    /**
     *
     * @return 下一个包材后缀序号
     */
    public int getNextPackagingMaterialCode();

}
