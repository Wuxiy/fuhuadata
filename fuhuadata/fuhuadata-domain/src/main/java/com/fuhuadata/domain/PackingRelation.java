package com.fuhuadata.domain;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by intanswer on 2017/5/5.
 */
public class PackingRelation {
    private int id;

    /**主材id**/
    @NotNull
    private int  mainPackingId;

    /**1:主材 2:外包装,3:辅材**/
    @NotNull
    private int categoryId;

    /**关联id**/
    @NotNull
    private int associatedPackingId;

    /**辅材或外包装单耗**/
    private BigDecimal consumption;

    /**单耗是否和外包装相等 0:不相等 1：相等**/
    private int isEqualOuter;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMainPackingId() {
        return mainPackingId;
    }

    public void setMainPackingId(int mainPackingId) {
        this.mainPackingId = mainPackingId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getAssociatedPackingId() {
        return associatedPackingId;
    }

    public void setAssociatedPackingId(int associatedPackingId) {
        this.associatedPackingId = associatedPackingId;
    }

    public BigDecimal getConsumption() {
        return consumption;
    }

    public void setConsumption(BigDecimal consumption) {
        this.consumption = consumption;
    }

    public int getIsEqualOuter() {
        return isEqualOuter;
    }

    public void setIsEqualOuter(int isEqualOuter) {
        this.isEqualOuter = isEqualOuter;
    }
}
