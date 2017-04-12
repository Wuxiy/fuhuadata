package com.fuhuadata.vo;

/**
 * 单据要求Vo
 * Created by hexingfu on 2017/4/12.
 */
public class documentaryVo {
    //海运提单 0：不需要 1：需要
    private Integer oceanBillOfLading;
    //货代提单 0：不需要 1：需要
    private Integer freightForwardingBill;
    //是否需要发票 0：不需要 1：需要
    private Integer invoice;
    //是否需要箱单 0：不需要 1：需要
    private Integer packingList;
    //质检单 0：不需要 1：需要
    private Integer qualityTestingReport;
    //是否需要保单  0：不需要 1：需要
    private Integer guaranteeSlip;
    //coo 类型  1：商检局 2：贸促会 3：普通
    private Integer coo;
    //coo 具体选项
    private String cooContent;


}
