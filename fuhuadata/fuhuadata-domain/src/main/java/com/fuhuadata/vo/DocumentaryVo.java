package com.fuhuadata.vo;

import java.io.Serializable;

/**
 * 单据要求Vo
 * Created by hexingfu on 2017/4/12.
 */
public class DocumentaryVo implements Serializable{
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
    //质检单公司抬头
    private String reportCompanyTitle;
    //是否需要保单  0：不需要 1：需要
    private Integer guaranteeSlip;
    //是否出具产地证 类型  1：商检局 2：贸促会 3：普通
    private Integer coo;
    //coo 具体选项
    private String cooContent;
    //危包证 0：不需要 1：需要
    private Integer dangerousCertificate;
    //受益人证明 0：不需要 1：需要
    private Integer beneficiaryCertification;
    //熏蒸证书 0：不需要 1：需要
    private Integer fumigationCertificate;
    //是否需要MSDS 0：不需要 1：需要
    private Integer msds;
    //提单签单方式 1:sea waybill 2:目的港放单 3:hbl（货代提单）4:obl（海运提单）5:直接电放6:其他
    private Integer billOfLading;
    //其他提单签单方式
    private String otherBillOfLading;
    //交单方式 0：不需要 1银行交单，2信用证交单，3直接寄单
    private Integer documentPresentation;
    //是否需要做第三方检测，并出具检测报告 0：不需要 1：需要
    private Integer examiningReport;
    //是否需要Packing Declaration   0：不需要 1：需要
    private Integer packingDeclaration;
    //是否需要IMPORT CONTAINER WEIGHT DECLARATION 0：不需要 1：需要
    private Integer importContainerWeightDeclaration;
    //是否需要Manufacturer's Certificate 0：不需要 1：需要
    private Integer manufacturerCertificate;
    //是否需要TDS
    private Integer needTDS;
    //是否需要Price Certificate
    private Integer needPriceCertificate;

    public Integer getOceanBillOfLading() {
        return oceanBillOfLading;
    }

    public void setOceanBillOfLading(Integer oceanBillOfLading) {
        this.oceanBillOfLading = oceanBillOfLading;
    }

    public Integer getFreightForwardingBill() {
        return freightForwardingBill;
    }

    public void setFreightForwardingBill(Integer freightForwardingBill) {
        this.freightForwardingBill = freightForwardingBill;
    }

    public Integer getInvoice() {
        return invoice;
    }

    public void setInvoice(Integer invoice) {
        this.invoice = invoice;
    }

    public Integer getPackingList() {
        return packingList;
    }

    public void setPackingList(Integer packingList) {
        this.packingList = packingList;
    }

    public Integer getQualityTestingReport() {
        return qualityTestingReport;
    }

    public void setQualityTestingReport(Integer qualityTestingReport) {
        this.qualityTestingReport = qualityTestingReport;
    }

    public String getReportCompanyTitle() {
        return reportCompanyTitle;
    }

    public void setReportCompanyTitle(String reportCompanyTitle) {
        this.reportCompanyTitle = reportCompanyTitle;
    }

    public Integer getGuaranteeSlip() {
        return guaranteeSlip;
    }

    public void setGuaranteeSlip(Integer guaranteeSlip) {
        this.guaranteeSlip = guaranteeSlip;
    }

    public Integer getCoo() {
        return coo;
    }

    public void setCoo(Integer coo) {
        this.coo = coo;
    }

    public String getCooContent() {
        return cooContent;
    }

    public void setCooContent(String cooContent) {
        this.cooContent = cooContent;
    }

    public Integer getDangerousCertificate() {
        return dangerousCertificate;
    }

    public void setDangerousCertificate(Integer dangerousCertificate) {
        this.dangerousCertificate = dangerousCertificate;
    }

    public Integer getBeneficiaryCertification() {
        return beneficiaryCertification;
    }

    public void setBeneficiaryCertification(Integer beneficiaryCertification) {
        this.beneficiaryCertification = beneficiaryCertification;
    }

    public Integer getFumigationCertificate() {
        return fumigationCertificate;
    }

    public void setFumigationCertificate(Integer fumigationCertificate) {
        this.fumigationCertificate = fumigationCertificate;
    }

    public Integer getMsds() {
        return msds;
    }

    public void setMsds(Integer msds) {
        this.msds = msds;
    }

    public Integer getBillOfLading() {
        return billOfLading;
    }

    public void setBillOfLading(Integer billOfLading) {
        this.billOfLading = billOfLading;
    }

    public String getOtherBillOfLading() {
        return otherBillOfLading;
    }

    public void setOtherBillOfLading(String otherBillOfLading) {
        this.otherBillOfLading = otherBillOfLading;
    }

    public Integer getDocumentPresentation() {
        return documentPresentation;
    }

    public void setDocumentPresentation(Integer documentPresentation) {
        this.documentPresentation = documentPresentation;
    }

    public Integer getExaminingReport() {
        return examiningReport;
    }

    public void setExaminingReport(Integer examiningReport) {
        this.examiningReport = examiningReport;
    }

    public Integer getPackingDeclaration() {
        return packingDeclaration;
    }

    public void setPackingDeclaration(Integer packingDeclaration) {
        this.packingDeclaration = packingDeclaration;
    }

    public Integer getImportContainerWeightDeclaration() {
        return importContainerWeightDeclaration;
    }

    public void setImportContainerWeightDeclaration(Integer importContainerWeightDeclaration) {
        this.importContainerWeightDeclaration = importContainerWeightDeclaration;
    }

    public Integer getManufacturerCertificate() {
        return manufacturerCertificate;
    }

    public void setManufacturerCertificate(Integer manufacturerCertificate) {
        this.manufacturerCertificate = manufacturerCertificate;
    }

    public Integer getNeedTDS() {
        return needTDS;
    }

    public void setNeedTDS(Integer needTDS) {
        this.needTDS = needTDS;
    }

    public Integer getNeedPriceCertificate() {
        return needPriceCertificate;
    }

    public void setNeedPriceCertificate(Integer needPriceCertificate) {
        this.needPriceCertificate = needPriceCertificate;
    }
}
