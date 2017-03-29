/**
 * Created by huxiangyang on 2017/3/13.
 */

/**
 *数据加载
 */
 //基本信息页
function customerBasicInfo(result){
    var getData = result;
    // console.log(getData);
    //客户基本信息
    $('[name="customerId"]').val(getData.customerId);
    $('#fullName').val(getData.fullName);
    $('#shortName').val(getData.shortName);
    $('#areaId').val((getData.areaId ? -1 : getData.areaId));
    $('#countryId').val((getData.countryId ? -1 : getData.countryId));

    $('#zhongxinbaoNumber').val(getData.zhongxinbaoNumber);
    $('#zhongxinbaoLevel').val(getData.zhongxinbaoLevel);
    if(getData.enterpriseNature && getData.enterpriseNature!='' && getData.enterpriseNature!=null){
        $('[name="enterpriseNature"]').val(getData.enterpriseNature.split(','));//企业性质
    }
    $('#otherEnterpriceNature').val(getData.otherEnterpriceNature);
    $('#registeredFunds').val(getData.registeredFunds);

    $('#enterprisePhone').val(getData.enterprisePhone);
    $('#enterpriseEmail').val(getData.enterpriseEmail);
    $('#registeredAddress').val(getData.registeredAddress);
    $('#managementScope').val(getData.managementScope);
    $('#hasChiCompany').val(getData.hasChiCompany);

    $('#hasChiPurchase').val(getData.hasChiPurchase);
    $('#customerLevel').val(getData.customerLevel);
    $('[name="customerType"]').val(getData.customerType);
    $('#factoryLocation').val(getData.factoryLocation);
    $('#productLine').val(getData.productLine);

    $('#majorCompetitors').val(getData.majorCompetitors);
    $('#remark').val(getData.remark);
    $('#opportunitySource').val(getData.opportunitySource);
    $('#otherOpportunity').val(getData.otherOpportunity);
    $('#opportunityDescrible').val(getData.opportunityDescrible);

    $('#lastmodifyUserName').val(getData.lastmodifyUserName);
    $('#modifyTime').val(getData.modifyTime);
    customerMakeProductData(getData.customerMakeProduct);//客户生产产品

    //百科信息
    $('#encyId').val(getData.encyId);
    $('#companyInfo').val(getData.companyInfo);
    $('#developHis').val(getData.developHis);
    $('#sellNetwork').val(getData.sellNetwork);
    $('#lastmodifyUserNameEn').val(getData.lastmodifyUserNameEn);
    $('#modifyTimeEn').val(getData.modifyTimeEn);
    if(getData.customField && getData.customField!='' && getData.customField!=null){
        customFieldData(getData.customField);//百科自定义字段
    }

    controlSOrH('#showOpportunity');
    controlSOrH('#showOtherOpportunity');
    controlSOrH('#showFactory');
    controlSOrH('#showMajorCompetitorsGroup');
    controlSOrH('#showOtherEnterpriceNature');
}
//客户生产产品
function customerMakeProductData(getData){
    // console.log(getData);
    //每次添加前，先删除页面上旧的数据
    $('[name="customerMakeProduct"]').remove();
    $.each(getData,function (n,item) {
        var location = $('#addPro').parents('.form-group');
        var row = '';
        row += '<div id="'+item.id+'" name="customerMakeProduct" class="form-group">';
        row += '<label class="col-xs-1 control-label">生产产品</label>';
        row += '<div class="col-xs-2"><input name="productName" class="form-control" type="text" disabled value="'+item.productName+'"></div>';
        row += '<label class="col-xs-1 control-label">产能</label>';
        row += '<div class="col-xs-2"><input name="production" class="form-control" type="text" disabled value="'+item.production+'"></div>';
        row += '</div>';
        location.before(row);
    });

}
//自定义字段
function customFieldData(getData){
    $('[name="customField"]').remove();
    var getData = $.parseJSON(getData);
    // console.log(getData);
    $.each(getData, function (n,item) {
        var location = $('#addFiled').parents('.form-group');
        var row = '';
        row += '<div name="customField" class="form-group">';
        row += '<label name="name" class="control-label col-xs-1" lang="zh">'+item.name+'</label>';
        row += '<div class="col-xs-8"><textarea disabled name="value" class="form-control" rows="4">'+item.value+'</textarea></div>';
        row += '</div>';
        location.before(row);
    });
}

/**
 * 上传数据
 */
//用户基本信息
function customerBasicFormObj() {
    var data = {
        customerBaseInfo:{
            "customerId": $('#customerId').val(),
            "fullName": $('#fullName').val(),
            "shortName": $('#shortName').val(),
            "areaId": $('#areaId').val(),
            "countryId": $('#countryId').val(),

            "zhongxinbaoNumber": $('#zhongxinbaoNumber').val(),
            "zhongxinbaoLevel": $('#zhongxinbaoLevel').val(),
            "registeredFunds": $('#registeredFunds').val(),
            "enterprisePhone": $('#enterprisePhone').val(),
            "otherEnterpriceNature": $('#otherEnterpriceNature').val(),

            "enterpriseEmail": $('#enterpriseEmail').val(),
            "registeredAddress": $('#registeredAddress').val(),
            "managementScope": $('#managementScope').val(),
            "hasChiCompany": $('#hasChiCompany').val(),
            "hasChiPurchase": $('#hasChiPurchase').val(),

            "customerLevel": $('#customerLevel').val(),
            "customerType": $('#customerType').val(),
            "factoryLocation": $('#factoryLocation').val(),
            "productionLine": $('#productLine').val(),
            "majorCompetitors": $('#majorCompetitors').val(),

            "remark": $('#remark').val(),
            "opportunitySource": $('#opportunitySource').val(),
            "otherOpportunity": $('#otherOpportunity').val(),
            "opportunityDescrible": $('#opportunityDescrible').val(),
            "lastmodifyUserName": $('#lastmodifyUserName').val(),

            "modifyTime": getTime()

        },
        customerEnterpriceNatures:customerEnterpriceNatureObj(),
        customerMakeProducts:customerMakeProductObj()
    };
    console.log(JSON.stringify(data));
    return JSON.stringify(data);
}
//客户生产产品
function customerMakeProductObj() {
    var arr = [];
    $('[name="customerMakeProduct"]').each(function () {
        var $this = $(this);
        var obj = {};
        if($this.attr('id') && $this.attr('id')!='' && $this.attr('id')!=null){
            obj.id = $this.attr('id');
        }
        obj.production = $this.find('[name="production"]').val();
        obj.productName = $this.find('[name="productName"]').val();
        arr.push(obj);
    });
    return arr;
}
//企业性质
function customerEnterpriceNatureObj() {
    var arr = [];
    $('[name="enterpriseNature"]').filter(':checked').each(function () {
        var obj = {};
        obj.customerId = $('#customerId').val();
        obj.type = 3;
        obj.nature = $(this).val();
        arr.push(obj);
    });
    return arr;
}


//客户百科
function customerEncyclopediaObj(){
    var data = {
        "encyId":$('#encyId').val(),
        "customerId":$('#customerId').val(),
        "companyInfo": $('#companyInfo').val(),
        "developHis": $('#developHis').val(),
        "sellNetwork": $('#sellNetwork').val(),
        "customField": customFieldObj(),//客户自定义字段
        // "lastmodifyUserIdEn": ,
        "modifyTime": getTime()
    };
    // console.log(JSON.stringify(data))
    return JSON.stringify(data);
}
//客户百科自定义字段
function customFieldObj(){
    var arr = [];
    $('[name="customField"]').each(function () {
        var $this = $(this);
        var obj = {};
        obj.name = $this.find('[name="name"]').text();
        obj.value = $this.find('[name="value"]').val();
        arr.push(obj);
    });
    return JSON.stringify(arr);
}