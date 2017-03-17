/**
 * Created by Think on 2017/3/16.
 */




/**
 *获取数据
 */
function getData(url,type,data,callBack){
    $.ajax({
        url:url,
        type:type,
        data:data
    }).done(function (data) {
        callBack(data);
    }).fail(function(){
        console.log('没有获取到数据');
    });
    // console.log(data);
}

/**
 * 提交数据
 */
function upData(url,type,data,contentType){
    console.log(data);
    $.ajax({
        url:url,
        type:type,
        data:data,
        contentType:contentType
    }).done(function () {
        alert('提交成功');
    });
}

/**
 *customerBasicInfo deal with
 */
function customerBasicInfo(result){
    var getData = result.data;
    $('#country').val(getData.country);
    $('#fullName').val(getData.fullName);
    $('#areaId').val(getData.areaId);
    $('#shortName').val(getData.shortName);
    $('#managementScope').val(getData.managementScope);
    $('#enterpriseNature').val(getData.enterpriseNature);
    $('#opportunityDescrible').val(getData.opportunityDescrible);
    $('#otherOpportunity').val(getData.otherOpportunity);
    $('#majorCompetitors').val(getData.majorCompetitors);
    $('#hasChiPurchase').val(getData.hasChiPurchase);
    $('#zhongxinbaoLevel').val(getData.zhongxinbaoLevel);
    $('#enterpriseEmaill').val(getData.enterpriseEmaill);
    $('#opportunitySource').val(getData.opportunitySource);
    $('#customerMakeProduct').val(getData.customerMakeProduct);
    $('#qualificationsFileUrl').val(getData.qualificationsFileUrl);
    $('#factoryLocation');
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
    $('#createUserId').val(getData.createUserId);
    $('#isFull').val(getData.isFull);
    $('#companyInfo').val(getData.companyInfo),
    $('#developHis').val(getData.developHis),
    $('#sellNetwork').val(getData.sellNetwork),
    $('#customField').val(getData.customField),
    $('#lastmodifyUserIdEn').val(getData.lastmodifyUserIdEn);
    $('#modifyTimeEn').val(getData.modifyTimeEn);
    // jQuery.each(getData,function(key,item){
    //     var formControl=$('["#'+ key +'"]');
    //     if(key!='customerMakeProduct'){
    //         // console.log(key);
    //         if(formControl.attr('type')=='radio'||formControl.attr('type')=='checkbox'){
    //             var arr=[item];
    //             formControl.val(arr);
    //         }else {
    //             formControl.val(item);
    //         }
    //         if(key=='enterpriseNature'){
    //             var elseSelected = formControl.filter('.else');
    //             var targetEl = formControl.parents('.form-group').find('.elseInput');
    //             console.log(elseSelected.prop('checked'));
    //             if(elseSelected.prop('checked')){
    //                 targetEl.removeClass('hidden');
    //             }else{
    //                 targetEl.addClass('hidden');
    //             }
    //         }
    //     }else{
    //         jQuery.each(item,function (n,item) {
    //             var row = '';
    //             console.log(item.productName);
    //             if(n==0){
    //                 formControl.attr('id',item.id).find('input')
    //                     .eq(0).val(item.productName).end()
    //                     .eq(1).val(item.production);
    //             }else{
    //                 row += '<div id="'+item.id+'" name="customerMakeProduct" class="form-group">';
    //                 row += '<label class="col-xs-1 control-label" style="position: relative"><button type="button" class="close hidden" data-form-btn="del" data-form-target="form-group" style="position: absolute;top: 3px;left: 24px;">×</button>生产产品'+ parseInt(n+1) +'</label>';
    //                 row += '<div class="col-xs-2"><input class="form-control" type="text" disabled value="'+item.productName+'"></div>';
    //                 row += '<label class="col-xs-1  control-label">产能</label>';
    //                 row += '<div class="col-xs-2"><input class="form-control" type="text" disabled value="'+item.production+'"></div>';
    //                 row += '</div>';
    //                 $('#addPro').parents('.form-group').before(row);
    //             }
    //         })
    //     }

    // });
}

/**
 *customerBasicInfo get
 */
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
            "customerMakeProduct": customerMakeProductData(),
            "customerStatus": $('#customerMakeProduct').val(),
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
            "companyType": $('#createUserId').val(),
            "isFull": $('#isFull').val()
        },
        customerMakeProducts:[ ]
    };
    function customerMakeProductData() {
        
    }
    return data;
}

function customerEncyclopediaObj(){
    var data = {
        "companyInfo": $('[name="companyInfo"]').val(),
        "developHis": $('[name="developHis"]').val(),
        "sellNetwork": $('[name="sellNetwork"]').val(),
        "customField": $('[name="customField"]').val(),
        // "lastmodifyUserIdEn": ,
        "modifyTimeEn": getTime()//最后编辑时间
    };
}

function getTime(){
    var time = new Date();
    var year = time.getFullYear();
    var month = parseInt(time.getMonth())+1;
    var day = time.getDate();
    var hours = parseInt(time.getHours());
    var minutes = parseInt(time.getMinutes());
    var seconds = parseInt(time.getSeconds());
    var newTime ;
    return newTime = year+'-'+month+'-'+day+' '+hours+':'+minutes+':'+seconds;
};