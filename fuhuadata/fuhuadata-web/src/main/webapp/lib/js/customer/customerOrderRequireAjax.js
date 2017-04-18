/**
 * Created by huxiangyang on 2017/3/27.
 */


// 获取请求参数
function ajaxParam() {

    var obj = {
        customerId:$('#customerId').val(),
        customerType:$('#customerType').val()
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
                productId : item.productId
            };

            if (item.otherDocumentaryRequire) {obj.otherDocumentaryRequire=item.otherDocumentaryRequire}

            if (item.documentaryVo) {

                var d = JSON.parse(item.documentaryVo);

                if (d.oceanBillOfLading) {obj.oceanBillOfLading=d.oceanBillOfLading}
                if (d.freightForwardingBill) {obj.freightForwardingBill=d.freightForwardingBill}
                if (d.invoice) {obj.invoice=d.invoice}
                if (d.packingList) {obj.packingList=d.packingList}
                if (d.qualityTestingReport) {obj.qualityTestingReport=d.qualityTestingReport}

                if (d.reportCompanyTitle) {obj.reportCompanyTitle=d.reportCompanyTitle}
                if (d.guaranteeSlip) {obj.guaranteeSlip=d.guaranteeSlip}
                if (d.coo) {obj.coo=d.coo}
                if (d.cooContent) {obj.cooContent=d.cooContent}
                if (d.dangerousCertificate) {obj.dangerousCertificate=d.dangerousCertificate}

                if (d.beneficiaryCertification) {obj.beneficiaryCertification=d.beneficiaryCertification}
                if (d.fumigationCertificate) {obj.fumigationCertificate=d.fumigationCertificate}
                if (d.msds) {obj.msds=d.msds}
                if (d.telexRelease) {obj.telexRelease=d.telexRelease}
                if (d.releaseDestination) {obj.releaseDestination=d.releaseDestination}

                if (d.bankBill) {obj.bankBill=d.bankBill}
                if (d.examiningReport) {obj.examiningReport=d.examiningReport}
                if (d.packingDeclaration) {obj.packingDeclaration=d.packingDeclaration}
                if (d.importContainerWeightDeclaration) {obj.importContainerWeightDeclaration=d.importContainerWeightDeclaration}
                if (d.manufacturerCertificate) {obj.manufacturerCertificate=d.manufacturerCertificate}
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
                productId : item.productId
            };

            if (item.shippingAgentRequire) {obj.shippingAgentRequire=item.shippingAgentRequire}
            if (item.goodsType) {obj.goodsType=item.goodsType}
            if (item.mianxiangqi) {obj.mianxiangqi=item.mianxiangqi}
            if (item.miantuiqi) {obj.miantuiqi=item.miantuiqi}

            if (item.packingRequireVo) {

                var d = JSON.parse(item.packingRequireVo);

                if (d.tray) {obj.tray=d.tray}
                if (d.postLabel) {obj.postLabel=d.postLabel}
                if (d.basePlate) {obj.basePlate=d.basePlate}
                if (d.paperBoard) {obj.paperBoard=d.paperBoard}
                if (d.gasbag) {obj.gasbag=d.gasbag}

                if (d.dragNet) {obj.dragNet=d.dragNet}
                if (d.fastenBelt) {obj.fastenBelt=d.fastenBelt}
                if (d.barcCode) {obj.barcCode=d.barcCode}
                if (d.americanDoorseal) {obj.americanDoorseal=d.americanDoorseal}
                if (d.bead) {obj.bead=d.bead}

                if (d.cornerProtection) {obj.cornerProtection=d.cornerProtection}
                if (d.inspectionOfLoading) {obj.inspectionOfLoading=d.inspectionOfLoading}
                if (d.inspectionInstitution) {obj.inspectionInstitution=d.inspectionInstitution}
                if (d.wireFixed) {obj.wireFixed=d.wireFixed}
            }

            arr.push(obj);

        });
    }

    return arr;
}

// 筛选
function screenData(obj,data,callBack){
    jQuery.each(data,function (n,item) {
        if(obj.val == item.productId){
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

    if (data.oceanBillOfLading) {$('#oceanBillOfLading').val(data.oceanBillOfLading);}
    if (data.freightForwardingBill) {$('#freightForwardingBill').val(data.freightForwardingBill);}
    if (data.invoice) {$('#invoice').val(data.invoice);}
    if (data.packingList) {$('#packingList').val(data.packingList);}
    if (data.qualityTestingReport) {$('#qualityTestingReport').val(data.qualityTestingReport);}

    if (data.reportCompanyTitle) {$('#reportCompanyTitle').val(data.reportCompanyTitle);}
    if (data.guaranteeSlip) {$('#guaranteeSlip').val(data.guaranteeSlip);}
    if (data.coo.length==1) {$('[name="coo"]').val([data.coo]);}
    if (data.cooContent) {
        if (data.coo==='1') {

            $('[name="cooContent"][type="checkbox"]').val([data.cooContent]);
        }else if (data.coo==='3') {

            $('[name="cooContent"][type="text"]').val(data.cooContent);
        }

    }
    if (data.dangerousCertificate) {$('#dangerousCertificate').val([data.dangerousCertificate]);}

    if (data.beneficiaryCertification) {$('#beneficiaryCertification').val([data.beneficiaryCertification]);}
    if (data.fumigationCertificate) {$('#fumigationCertificate').val([data.fumigationCertificate]);}
    if (data.msds) {$('#msds').val([data.msds]);}
    if (data.telexRelease) {$('[name="telexRelease"]').val([data.telexRelease]);}
    if (data.releaseDestination && data.telexRelease!='0') {$('#releaseDestination').val(data.releaseDestination);} // 放单目的港 text

    if (data.bankBill) {$('#bankBill').val([data.bankBill]);}
    if (data.examiningReport) {$('#bankBill').val([data.examiningReport]);}
    if (data.packingDeclaration) {$('#bankBill').val([data.packingDeclaration]);}
    if (data.importContainerWeightDeclaration) {$('#bankBill').val([data.importContainerWeightDeclaration]);}
    if (data.bankBill) {$('#manufacturerCertificate').val([data.manufacturerCertificate]);}

    if (data.otherDocumentaryRequire) {$('#otherDocumentaryRequire').val(data.otherDocumentaryRequire);} // 其他单据要求 text
}

// 渲染产品种类下拉框
function renderSelect(data,id,el) {

    var arr = [];

    $.each(data,function (i,item) {

       var obj = {
           name : item.name,
           val : item.productId,
       };

       arr.push[obj];
    });

    CRM.tplHandler(id,arr,el);
}

// 渲染订舱出运要求
function customerTransportRequire(data) {

    if (data.shippingAgentRequire) {$('#shippingAgentRequire').val([data.shippingAgentRequire]);}
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
    if (data.inspectionInstitution && data.inspectionOfLoading) {$('#inspectionInstitution').val([data.inspectionInstitution]);}
    if (data.wireFixed) {$('#wireFixed').val([data.wireFixed]);}

    if (data.goodsType) {$('[name="goodsType"]').val([data.goodsType]);}
    if (data.mianxiangqi) {$('#mianxiangqi').val(data.mianxiangqi);}
    if (data.miantuiqi) {$('#miantuiqi').val(data.miantuiqi);}
}