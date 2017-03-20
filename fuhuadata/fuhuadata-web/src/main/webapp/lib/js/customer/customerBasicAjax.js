/**
 *数据加载
 */
 //基本信息页
function customerBasicInfo(result){
    var getData = result;
    $('#country').val(getData.country);//国家
    $('#fullName').val(getData.fullName);//客户全称
    $('#areaId').val(getData.areaId);//地区分类
    $('#shortName').val(getData.shortName);//客户简称
    $('#managementScope').val(getData.managementScope);//经营范围
    $('#enterpriseNature').val(getData.enterpriseNature);//企业性质
    $('#opportunityDescrible').val(getData.opportunityDescrible);//机会描述
    $('#otherOpportunity').val(getData.otherOpportunity);//其他机会来源
    $('#majorCompetitors').val(getData.majorCompetitors);//分销主要竞争对手
    $('#hasChiPurchase').val(getData.hasChiPurchase);
    $('#zhongxinbaoLevel').val(getData.zhongxinbaoLevel);
    $('#enterpriseEmaill').val(getData.enterpriseEmaill);
    $('#opportunitySource').val(getData.opportunitySource);
    $('#qualificationsFileUrl').val(getData.qualificationsFileUrl);
    $('#factoryLocation').val(getData.factoryLocation);
    $('#lastmodifyUserNameEn').val(getData.lastmodifyUserNameEn);
    $('#enterprisePhone').val(getData.enterprisePhone);
    $('#zhongxinbaoNumber').val(getData.zhongxinbaoNumber);
    $('#customerCompletion').val(getData.customerCompletion);
    $('#enterpriseEmail').val(getData.enterpriseEmail);
    $('#registeredAddress').val(getData.registeredAddress);
    $('#registeredFunds').val(getData.registeredFunds);
    $('#customerType').val(getData.customerType);
    $('#createTime').val(getData.createTime);
    $('#customerLevel').val(getData.customerLevel);
    $('#area').val(getData.area);
    $('#countryId').val(getData.countryId);
    $('#remark').val(getData.remark);
    $('#hasChiCompany').val(getData.hasChiCompany);
    $('#productLine').val(getData.productLine);
    $('#encyId').val(getData.encyId);
    $('#customerId').val(getData.customerId);
    $('#createUserId').val(getData.createUserId);
    $('#isFull').val(getData.isFull);
    $('#companyInfo').val(getData.companyInfo);
    $('#developHis').val(getData.developHis);
    $('#sellNetwork').val(getData.sellNetwork);
    $('#customField').val(getData.customField);
    $('#modifyTimeEn').val(getData.modifyTimeEn);

    //获取企业性质
    $('[name="enterpriseNature"]').val([getData.enterpriseNature]);

    //获取客户生产产品
    customerMakeProductData(getData.customerMakeProducts);

    //获取自定义字段
    customFieldData(getData.customField);
    console.log(getData);
}
//客户生产产品
function customerMakeProductData(getData){

    $.each(getData,function (n,item) {
        var location = $('#addPro').parents('.form-group');
        var row = '';
        row += '<div id="'+item.id+'" name="customerMakeProduct" class="form-group">';
        row += '<label class="col-xs-1 control-label">生产产品'+item.id+'</label>';
        row += '<div class="col-xs-2"><input class="form-control" type="text" disabled value="'+item.productName+'"></div>';
        row += '<label class="col-xs-1 control-label">产能</label>';
        row += '<div class="col-xs-2"><input class="form-control" type="text" disabled value="'+item.production+'"></div>';
        row += '</div>';
        location.before(row);
    });

}
//自定义字段
function customFieldData(getData){
    if(getData instanceof Array){
        $.each(getData, function (n,item) {
            var location = $('#addCustomField').parents('.form-group');
            var row = '';
            row += '<div name="customField" class="form-group">';
            row += '<label name="name" class="control-label col-xs-1" lang="zh">'+item.name+'</label>';
            row += '<div class="col-xs-8"><textarea  name="content" class="form-control" rows="4" value="'+item.content+'"></textarea></div>';
            row += '</div>';
            location.before(row);
        });
    }
}

/**
 * 上传数据
 */
//用户基本信息
function customerBasicFormObj() {
    var data = {
        customerBaseInfo:{
            "country": $('#country').val(),
            "fullName": $('#fullName').val(),
            "areaId": $('#areaId').val(),
            "shortName": $('#shortName').val(),
            "managementScope": $('#managementScope').val(),
            "enterpriseNature": $('#enterpriseNature').val(),
            "opportunityDescrible": $('#opportunityDescrible').val(),
            "otherOpportunity": $('#otherOpportunity').val(),
            "majorCompetitors": $('#majorCompetitors').val(),
            "hasChiPurchase": $('#hasChiPurchase').val(),
            "zhongxinbaoLevel": $('#zhongxinbaoLevel').val(),
            "enterpriseEmaill": $('#enterpriseEmaill').val(),
            "opportunitySource": $('#opportunitySource').val(),
            "customerStatus": $('#customerStatus').val(),
            "qualificationsFileUrl": $('#qualificationsFileUrl').val(),
            "factoryLocation": $('#factoryLocation').val(),
            "lastmodifyUserNameEn": $('#lastmodifyUserNameEn').val(),
            "enterprisePhone": $('#enterprisePhone').val(),
            "zhongxinbaoNumber": $('#zhongxinbaoNumber').val(),
            "customerCompletion": $('#customerCompletion').val(),
            "enterpriseEmail": $('#enterpriseEmail').val(),
            "registeredAddress": $('#registeredAddress').val(),
            "registeredFunds": $('#registeredFunds').val(),
            "customerType": $('#customerType').val(),
            "customerLevel": $('#customerLevel').val(),
            "area": $('#area').val(),
            "countryId": $('#countryId').val(),
            "remark": $('#remark').val(),
            "hasChiCompany": $('#hasChiCompany').val(),
            "productLine": $('#productLine').val(),
            "encyId": $('#encyId').val(),
            "customerId": $('#customerId').val(),
            "createUserId": $('#createUserId').val(),
            "companyType": $('#companyType').val(),
            "isFull": $('#isFull').val()
        },
        customerMakeProducts:customerMakeProductObj()
    };
    return JSON.stringify(data);
}
//客户生产产品
function customerMakeProductObj() {
    var arr = [];
    $('[name="customerMakeProducts"]').each(function () {
        var $this = $(this);
        var obj = {};
        obj.id = $this.attr('id');
        obj.production = $this.find('[name="production"]').val();
        obj.productName = $this.find('[name="productName"]').val();
        arr.push(obj);
    });
    return arr;
}
//客户百科
function customerEncyclopediaObj(){
    var data = {
        "companyInfo": $('[name="companyInfo"]').val(),
        "developHis": $('[name="developHis"]').val(),
        "sellNetwork": $('[name="sellNetwork"]').val(),
        "customField": customFieldObj(),
        // "lastmodifyUserIdEn": ,
        "modifyTimeEn": getTime()
    };
    return JSON.stringify(data);
}
//客户百科自定义字段
function customFieldObj(){
    var arr = [];
    $('[name="customField"]').each(function () {
        var $this = $(this);
        var obj = {};
        obj.production = $this.find('[name="name"]').text();
        obj.productName = $this.find('[name="productName"]').val();
        arr.push(obj);
    });
    return arr;
}