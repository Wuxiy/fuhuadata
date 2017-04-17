/**
 * Created by huxiangyang on 2017/3/27.
 */

/**
 *筛选
 */
function screenData(obj,data,callBack){
    jQuery.each(data,function (n,item) {
        if(obj.productId == item.productId){
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
/**
 *渲染单据要求
 */
function customerBillRequire(data) {

    if (data.oceanBillOfLading) {$('#oceanBillOfLading').val(data.oceanBillOfLading);}
    if (data.freightForwardingBill) {$('#freightForwardingBill').val(data.freightForwardingBill);}
    if (data.invoice) {$('#invoice').val(data.INVOICE);}
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

    // var require = jQuery.parseJSON(data.documentaryRequire);
    //
    // $('#oceanBillOfLading').prop('checked',require.oceanBillOfLading);
    // $('#freightBillOfLading').prop('checked',require.freightBillOfLading);
    // $('#invoice').prop('checked',require.invoice);
    // $('#packingLise').prop('checked',require.packingLise);
    // $('#qualityPolicy').prop('checked',require.qualityPolicy);
    // $('#qualityPolicyTxt').val(require.qualityPolicyTxt);
    // $('#warranty').prop('checked',require.warranty);
    // $('#dangerousPackage').prop('checked',require.dangerousPackage);
    // $('#favoree').prop('checked',require.favoree);
    // $('#fumigation').prop('checked',require.fumigation);
    // $('#MSDS').prop('checked',require.MSDS);
    // $('#tenderDocument').prop('checked',require.tenderDocument);
    // $('#examiningReport').prop('checked',require.examiningReport);
    // $('#packingDeclaration').prop('checked',require.packingDeclaration);
    // $('#ICWD').prop('checked',require.ICWD);
    // $('#MC').prop('checked',require.MC);

//    if(require.qualityPolicy && require.qualityPolicy!='' && require.qualityPolicy!=null){
//        var qua = jQuery.parseJSON(require.qualityPolicy);
//        $('#qualityPolicy').prop('checked',qua.selected);
//        $('#qualityPolicyTxt').val(qua.value);
//    }
    if(require.COO && require.COO!='' && require.COO!=null){
//        var coo = jQuery.parseJSON(require.COO);
        var coo = require.COO;
        $('input').filter('[name="coo"]').val([coo.selected]);//单选
        if(coo.selected=='general'){
            $('#'+coo.selected).val(coo.value);
        }else if(coo.selected=='CIATB'){
            $('[name="'+coo.selected+'"]').val([coo.value]);
        }

    }
    if(require.telexRelease && require.telexRelease!='' && require.telexRelease!=null){
//        var telex = jQuery.parseJSON(require.telexRelease);
        var telex = require.telexRelease;
        $('input').filter('[name="telexRelease"]').val([telex.selected]);//单选
        $('#telexReleaseTxt').val(telex.value);
    }
}
/**
 *渲染订舱出运要求
 */
function  customerTransportRequire(data) {
    $('#shippingAgentRequire').val(data.shippingAgentRequire);
    $('[name="goodsType"]').val([data.goodsType]);
    $('#mianxiangqi').val(data.mianxiangqi);
    $('#miantuiqi').val(data.miantuiqi);

    var require = jQuery.parseJSON(data.packageRequire);
    $('[name="fullyClose"]').val(require.fullyClose);
    $('#postLabel').prop('checked',require.postLabel);
    $('#basePlate').prop('checked',require.basePlate);
    $('#paperboard').prop('checked',require.paperboard);
    $('#airSac').prop('checked',require.airSac);
    $('#seine').prop('checked',require.seine);
    $('#fasteningWith').prop('checked',require.fasteningWith);
    $('#copyTheBarcode').prop('checked',require.copyTheBarcode);
    $('#theOrdinaryAmerican').prop('checked',require.theOrdinaryAmerican);
    $('#joint').prop('checked',require.joint);
    $('#bead').prop('checked',require.bead);
    $('#wireMeshFixedGuard').prop('checked',require.wireMeshFixedGuard);
    $('[name="inspectionOfStorage"]').val([require.inspectionOfStorage.selected]);
    $('#inspectionOfStorage').val(require.inspectionOfStorage.value);
}