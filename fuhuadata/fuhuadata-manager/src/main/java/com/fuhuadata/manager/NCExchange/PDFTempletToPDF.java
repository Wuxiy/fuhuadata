package com.fuhuadata.manager.NCExchange;

import com.fuhuadata.domain.BusinessOrderProduct;

import java.util.List;

/**
 * Created by zhangxiang on 2017/5/11.
 */
public interface PDFTempletToPDF {
    String PDFTempletToPDFmanager(List<BusinessOrderProduct> orderProducts);
}
