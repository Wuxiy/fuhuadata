package com.fuhuadata.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fuhuadata.util.DateJsonDeserializer;
import com.fuhuadata.util.DateJsonSerializer;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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

    private Integer userId;//用户id

    private String userName;//用户姓名

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName(){ return userName; }

    public void setUserName(String userName){ this.userName = userName; }

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