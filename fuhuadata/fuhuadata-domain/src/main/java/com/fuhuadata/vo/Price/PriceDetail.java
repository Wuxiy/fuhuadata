package com.fuhuadata.vo.Price;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hexingfu on 2017/4/10.
 */
public class PriceDetail implements Serializable {
    //费用名称
    private String costName;
    //单位
    private String unit;
    //单价
    private BigDecimal price;
    //数量
    private BigDecimal num;
    //金额
    private BigDecimal money;

}
