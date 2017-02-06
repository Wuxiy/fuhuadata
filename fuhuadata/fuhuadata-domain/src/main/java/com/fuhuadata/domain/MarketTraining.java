package com.fuhuadata.domain;


import java.util.Date;

/**
 * 营销培训
 *
 */
public class MarketTraining {
    private Integer tranId;//记录id

    private Integer productId;//培训产品id

    private String title;//标题

    private String productType;//产品类型

    private String userId;//用户id

    private Date uploadDate;//上传日期

    private String download;//下载操作

    public Integer getTranId() {
        return tranId;
    }

    public void setTranId(Integer tranId) {
        this.tranId = tranId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download ;
    }
}