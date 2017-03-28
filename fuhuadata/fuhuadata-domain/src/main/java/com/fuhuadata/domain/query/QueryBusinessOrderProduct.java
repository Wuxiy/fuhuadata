package com.fuhuadata.domain.query;

/**
 * Created by intanswer on 2017/3/28.
 */
public class QueryBusinessOrderProduct {
    private int startRow;
    private int pageSize;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }
}
