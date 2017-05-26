/**
 * Created by huxiangyang on 2017/3/27.
 */


// 获取请求参数
function ajaxParam() {

    var obj = {
        customerId:$('#customerId').val(),
        customerType:$('#customerType').val(),
    };

    return obj;
}

// 重构单据数组数据
function reconstructionData(data) {

    var arr = [];

    if (data!=null) {

        $.each(data,function (n,item) {

            var obj = {
                name : item.name,
                wareId : item.wareId
            };

            if (item.otherDocumentaryRequire) {obj.otherDocumentaryRequire=item.otherDocumentaryRequire}

            if (item.documentaryRequire) {

                var d = JSON.parse(item.documentaryRequire);

                if (d.oceanBillOfLading) {obj.oceanBillOfLading=d.oceanBillOfLading} // 海运提单
                if (d.freightForwardingBill) {obj.freightForwardingBill=d.freightForwardingBill} // 货代提单
                if (d.invoice) {obj.invoice=d.invoice} // 是否需要发票
                if (d.packingList) {obj.packingList=d.packingList} // 是否需要箱单
                if (d.qualityTestingReport) {obj.qualityTestingReport=d.qualityTestingReport} //质检单

                if (d.reportCompanyTitle) {obj.reportCompanyTitle=d.reportCompanyTitle} // 质检单公司抬头
                if (d.guaranteeSlip) {obj.guaranteeSlip=d.guaranteeSlip} // 是否需要保单
                if (d.coo) {obj.coo=d.coo} // 是否出具产地证
                if (d.cooContent) {obj.cooContent=d.cooContent} // coo 具体选项
                if (d.dangerousCertificate) {obj.dangerousCertificate=d.dangerousCertificate} // 危包证

                if (d.beneficiaryCertification) {obj.beneficiaryCertification=d.beneficiaryCertification} // 受益人证明
                if (d.fumigationCertificate) {obj.fumigationCertificate=d.fumigationCertificate} // 熏蒸证书
                if (d.msds) {obj.msds=d.msds} // 是否需要MSDS
                if (d.billOfLading) {obj.telexRelease=d.billOfLading} // 提单签单方式
                if (d.otherBillOfLading) {obj.releaseDestination=d.otherBillOfLading} // 其他提单签单方式

                if (d.documentPresentation) {obj.bankBill=d.documentPresentation} // 交单方式
                if (d.examiningReport) {obj.examiningReport=d.examiningReport} // 是否需要做第三方检测
                if (d.packingDeclaration) {obj.packingDeclaration=d.packingDeclaration} // 是否需要Packing Declaration
                if (d.importContainerWeightDeclaration) {obj.importContainerWeightDeclaration=d.importContainerWeightDeclaration} // 是否需要IMPORT CONTAINER WEIGHT DECLARATION
                if (d.manufacturerCertificate) {obj.manufacturerCertificate=d.manufacturerCertificate} // 是否需要Manufacturer's Certificate

                if (d.needTDS) {obj.needTDS=d.needTDS} // 是否需要TDS
                if (d.needPriceCertificate) {obj.needPriceCertificate=d.needPriceCertificate} // 是否需要Price Certificate

            }

            arr.push(obj);

        });
    }

    return arr;
}

// 重构订舱出运数据
function reconstructionTraData(data) {

    var arr = [];

    if (data!=null) {

        $.each(data,function (n,item) {

            var obj = {
                name : item.name,
                wareId : item.wareId
            };

            if (item.shippingAgentRequire) {obj.shippingAgentRequire=item.shippingAgentRequire}
            if (item.goodsType) {obj.goodsType=item.goodsType}
            if (item.mianxiangqi) {obj.mianxiangqi=item.mianxiangqi}
            if (item.miantuiqi) {obj.miantuiqi=item.miantuiqi}

            if (item.packageRequire) {

                var d = JSON.parse(item.packageRequire);

                if (d.tray) {obj.tray=d.tray} //
                if (d.postLabel) {obj.postLabel=d.postLabel} //
                if (d.basePlate) {obj.basePlate=d.basePlate}
                if (d.paperBoard) {obj.paperBoard=d.paperBoard} //
                if (d.gasbag) {obj.gasbag=d.gasbag} //

                if (d.dragNet) {obj.dragNet=d.dragNet} //
                if (d.fastenBelt) {obj.fastenBelt=d.fastenBelt} //
                if (d.barcCode) {obj.barcCode=d.barcCode} //
                if (d.americanDoorseal) {obj.americanDoorseal=d.americanDoorseal} //
                if (d.bead) {obj.bead=d.bead} //

                if (d.cornerProtection) {obj.cornerProtection=d.cornerProtection} //
                if (d.inspectionOfLoading) {obj.inspectionOfLoading=d.inspectionOfLoading} //
                if (d.inspectionInstitution) {obj.inspectionInstitution=d.inspectionInstitution} //
                if (d.wireFixed) {obj.wireFixed=d.wireFixed} //
            }

            arr.push(obj);

        });
    }

    return arr;
}

// 筛选
function screenData(obj,data,callBack){
    jQuery.each(data,function (n,item) {
        if(obj.wareId == item.wareId){
            //渲染数据
            callBack(item);
            //退出循环
            return false;
        }else {
            //跳过，进行下一次循环
            return true;
        }
    })
}

// 渲染单据要求
function customerBillRequire(data) {

    if (data.oceanBillOfLading) {$('#oceanBillOfLading').val([data.oceanBillOfLading]);}
    if (data.freightForwardingBill) {$('#freightForwardingBill').val([data.freightForwardingBill]);}
    if (data.invoice) {$('#invoice').val([data.invoice]);}
    if (data.packingList) {$('#packingList').val([data.packingList]);}
    if (data.qualityTestingReport) {$('#qualityTestingReport').val([data.qualityTestingReport]);}

    if (data.reportCompanyTitle && data.qualityTestingReport!='0') {$('#reportCompanyTitle').val(data.reportCompanyTitle);}
    if (data.guaranteeSlip) {$('#guaranteeSlip').val([data.guaranteeSlip]);}
    if (data.coo) {$('[name="coo"]').val([data.coo]);}
    if (data.cooContent && data.coo!='0') {
        if (data.coo=='1') {

            $('[name="cooContent"][type="checkbox"]').val([data.cooContent]);
        }else if (data.coo=='3') {

            $('[name="cooContent"][type="text"]').val(data.cooContent);
        }

    }
    if (data.dangerousCertificate) {$('#dangerousCertificate').val([data.dangerousCertificate]);}

    if (data.beneficiaryCertification) {$('#beneficiaryCertification').val([data.beneficiaryCertification]);}
    if (data.fumigationCertificate) {$('#fumigationCertificate').val([data.fumigationCertificate]);}
    if (data.msds) {$('#msds').val([data.msds]);}
    if (data.telexRelease) {$('[name="telexRelease"]').val([data.telexRelease]);}
    if (data.releaseDestination && data.telexRelease!='0') {$('#releaseDestination').val(data.releaseDestination);} // 放单目的港 text

    if (data.bankBill) {$('[name="bankBill"]').val([data.bankBill]);}
    if (data.examiningReport) {$('#bankBill').val([data.examiningReport]);}
    if (data.packingDeclaration) {$('#bankBill').val([data.packingDeclaration]);}
    if (data.importContainerWeightDeclaration) {$('#bankBill').val([data.importContainerWeightDeclaration]);}
    if (data.bankBill) {$('#manufacturerCertificate').val([data.manufacturerCertificate]);}

    if (data.otherDocumentaryRequire) {$('#otherDocumentaryRequire').val(data.otherDocumentaryRequire);} // 其他单据要求 text
    if (data.needTDS) {$('#needTDS').val([data.needTDS]);} // 是否需要TDS
    if (data.needPriceCertificate) {$('#needPriceCertificate').val([data.needPriceCertificate]);} // 是否需要Price Certificate
}

// 渲染产品种类下拉框
function renderSelect(data,id,el) {

    var arr = [];

    $.each(data,function (i,item) {

       var obj = {
           name : item.name,
           wareId : item.wareId,
       };

       arr.push(obj);
    });

    CRM.tplHandler(id,arr,el);
}

// 渲染订舱出运要求
function customerTransportRequire(data) {

    if (data.shippingAgentRequire) {$('#shippingAgentRequire').val(data.shippingAgentRequire);} // 船运公司要求 text
    if (data.tray) {$('[name="tray"]').val([data.tray]);}
    if (data.postLabel) {$('#postLabel').val([data.postLabel]);}
    if (data.basePlate) {$('#basePlate').val([data.basePlate]);}
    if (data.paperBoard) {$('#paperBoard').val([data.paperBoard]);}

    if (data.gasbag) {$('#gasbag').val([data.gasbag]);}
    if (data.dragNet) {$('#dragNet').val([data.dragNet]);}
    if (data.fastenBelt) {$('#fastenBelt').val([data.fastenBelt]);}
    if (data.barcCode) {$('#barcCode').val([data.barcCode]);}
    if (data.americanDoorseal) {$('#americanDoorseal').val([data.americanDoorseal]);}

    if (data.bead) {$('#bead').val([data.bead]);}
    if (data.cornerProtection) {$('#cornerProtection').val([data.cornerProtection]);}
    if (data.inspectionOfLoading) {$('[name="inspectionOfLoading"]').val([data.inspectionOfLoading]);}
    if (data.inspectionInstitution && data.inspectionOfLoading!='0') {$('#inspectionInstitution').val(data.inspectionInstitution);}
    if (data.wireFixed) {$('#wireFixed').val([data.wireFixed]);}

    if (data.goodsType) {$('[name="goodsType"]').val([data.goodsType]);}
    if (data.mianxiangqi) {$('#mianxiangqi').val(data.mianxiangqi);}
    if (data.miantuiqi) {$('#miantuiqi').val(data.miantuiqi);}
}

// 重置
function resetbillPanel() {
    $('input[type="checkbox"]',$('#billPanel')).val([]);
    $('input[type="text"],textarea',$('#billPanel')).val('');
}