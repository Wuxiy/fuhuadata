package com.fuhuadata.domain.supplier;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/26/2017
 */
public class ProduceFactoryInfo {

    private ProduceFactory factory;

    private List<Integer> deletedBankIds;

    private List<Integer> deletedLinkmanIds;

    public ProduceFactory getFactory() {
        return factory;
    }

    public void setFactory(ProduceFactory factory) {
        this.factory = factory;
    }

    public List<Integer> getDeletedBankIds() {
        return deletedBankIds;
    }

    public void setDeletedBankIds(List<Integer> deletedBankIds) {
        this.deletedBankIds = deletedBankIds;
    }

    public List<Integer> getDeletedLinkmanIds() {
        return deletedLinkmanIds;
    }

    public void setDeletedLinkmanIds(List<Integer> deletedLinkmanIds) {
        this.deletedLinkmanIds = deletedLinkmanIds;
    }
}
