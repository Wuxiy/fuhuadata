package com.fuhuadata.domain.task;

import java.io.Serializable;

/**
 * 同步product_info
 * Created by hexingfu on 2017/5/9.
 */
public class SyncProduct implements Serializable {
    //nc分类code
    private Integer nc_category_id;
    //产品名称
    private String name;
    //主计量单位
    private String measurement;


}
