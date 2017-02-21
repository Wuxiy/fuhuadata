package com.fuhuadata.domain.query;

import com.fuhuadata.domain.query.PageBase;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 营销培训
 * Created by intanswer on 2017/1/12.
 */
public class MarketTrainingQuery extends PageBase {
    private Integer tranId;//记录id

    private Integer productId;//培训产品id

    private String title;//标题

    private String productType;//产品类型

    private String userId;//用户id

    private String userName;//用户姓名

    private Timestamp uploadDate;//上传日期

    private String download;//下载操作

    private String searchKey;//查询


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
        this.productType = productType == null ? null : productType.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId ;
    }

    public Timestamp getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Timestamp uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
