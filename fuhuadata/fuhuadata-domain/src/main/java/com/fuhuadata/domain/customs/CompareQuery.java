package com.fuhuadata.domain.customs;

import java.time.LocalDate;

/**
 * <p>User: wangjie
 * <p>Date: 7/5/2017
 */
public class CompareQuery extends CustomsDataQuery {

    private LocalDate firstStartDate;

    private LocalDate firstEndDate;

    private LocalDate secondStartDate;

    private LocalDate secondEndDate;

    public LocalDate getFirstStartDate() {
        return firstStartDate;
    }

    public void setFirstStartDate(LocalDate firstStartDate) {
        this.firstStartDate = firstStartDate;
    }

    public LocalDate getFirstEndDate() {
        return firstEndDate;
    }

    public void setFirstEndDate(LocalDate firstEndDate) {
        this.firstEndDate = firstEndDate;
    }

    public LocalDate getSecondStartDate() {
        return secondStartDate;
    }

    public void setSecondStartDate(LocalDate secondStartDate) {
        this.secondStartDate = secondStartDate;
    }

    public LocalDate getSecondEndDate() {
        return secondEndDate;
    }

    public void setSecondEndDate(LocalDate secondEndDate) {
        this.secondEndDate = secondEndDate;
    }
}
