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
 *获取单据要求
 */
function customerBillRequire(data) {
    $('#otherDocumentaryRequire').val(data.otherDocumentaryRequire);
    var require = jQuery.parseJSON(data.documentaryRequire);

    $('#oceanBillOfLading').prop('checked',require.oceanBillOfLading);
    $('#freightBillOfLading').prop('checked',require.freightBillOfLading);
    $('#invoice').prop('checked',require.invoice);
    $('#packingLise').prop('checked',require.packingLise);
    $('#qualityPolicy').prop('checked',require.qualityPolicy);
    $('#qualityPolicyTxt').val(require.qualityPolicyTxt);
    $('#warranty').prop('checked',require.warranty);
    $('#dangerousPackage').prop('checked',require.dangerousPackage);
    $('#favoree').prop('checked',require.favoree);
    $('#fumigation').prop('checked',require.fumigation);
    $('#MSDS').prop('checked',require.MSDS);
    $('#tenderDocument').prop('checked',require.tenderDocument);
    $('#examiningReport').prop('checked',require.examiningReport);
    $('#packingDeclaration').prop('checked',require.packingDeclaration);
    $('#ICWD').prop('checked',require.ICWD);
    $('#MC').prop('checked',require.MC);

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
 *获取订舱出运要求
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