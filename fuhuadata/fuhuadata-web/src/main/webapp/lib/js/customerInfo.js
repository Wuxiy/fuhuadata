/**
 * Created by Think on 2017/3/16.
 */

/**
 * 全局变量
 */
//url参数
var urlArg = location.search;

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
        data:JSON.stringify(data),
        contentType:contentType
    }).done(function () {
        alert('提交成功');
    });
}

/**
 *基本信息页处理数据
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
 * 基本信息页上传数据
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



/**
 * 市场信心页处理数据
 */
function pop(result){
    var data = result.data;
    var cpps = $('#cpps');
    var csps = $('#csps');
    cpps.html('');
    csps.html('');
    //采购产品
    $.each(data.cpps,function(n,item){
        var tbody = '';
        tbody += '<tbody>';
        tbody += '<tr><th>采购产品</th>';
        tbody += '<th>'+item.productName+'</th>';
        tbody += '<th>年需求量</th>';
        tbody += '<th>'+item.annualDemands+'</th>';
        tbody += '<th>平均单价(美元)</th>';
        tbody += '<th>'+item.averagePrice+'</th></tr>';
        tbody += '<tr><td>供应商1</td>'
        tbody += '<td>'+item.supplier1+'</td>';
        tbody += '<td>年采购量</td>'
        tbody += '<td>'+item.purchaseAmount1+'</td>';
        tbody += '<td>平均单价</td>';
        tbody += '<td>'+item.averagePrice1+'</td></tr>';
        tbody += '<tr><td>供应商2</td>'
        tbody += '<td>'+item.supplier2+'</td>';
        tbody += '<td>年采购量</td>'
        tbody += '<td>'+item.purchaseAmount2+'</td>';
        tbody += '<td>平均单价</td>';
        tbody += '<td>'+item.averagePrice2+'</td></tr>';
        tbody += '<tr><td>供应商3</td>'
        tbody += '<td>'+item.supplier3+'</td>';
        tbody += '<td>年采购量</td>'
        tbody += '<td>'+item.purchaseAmount3+'</td>';
        tbody += '<td>平均单价</td>';
        tbody += '<td>'+item.averagePrice3+'</td></tr></tbody>';
        cpps.append(tbody);
    });
    //销售产品
    $.each(data.csps,function(n,item){
        var tbody = '';
        tbody += '<tbody>';
        tbody += '<tr><th>销售产品</th>';
        tbody += '<th>'+item.productName+'</th>';
        tbody += '<th>年销售量</th>';
        tbody += '<th>'+item.yearSales+'</th>';
        tbody += '<th>品牌</th>';
        tbody += '<th>'+item.brand+'</th>';
        tbody += '<th>营销手段</th>';
        tbody += '<th>'+item.marketingMethod+'</th></tr>';
        tbody += '<tr><td>销售目的国1</td>'
        tbody += '<td>'+item.destinationCountry+'</td>';
        tbody += '<td>年销售量</td>'
        tbody += '<td>'+item.purchaseAmount1+'</td>';
        tbody += '<td>所占市场份额</td>';
        tbody += '<td>'+item.averagePrice1+'</td></tr>';
        tbody += '<tr><td>销售目的国2</td>'
        tbody += '<td>'+item.supplier2+'</td>';
        tbody += '<td>年销售量</td>'
        tbody += '<td>'+item.purchaseAmount2+'</td>';
        tbody += '<td>所占市场份额</td>';
        tbody += '<td>'+item.averagePrice2+'</td></tr>';
        tbody += '<tr><td>销售目的国3</td>'
        tbody += '<td>'+item.supplier3+'</td>';
        tbody += '<td>年销售量</td>'
        tbody += '<td>'+item.purchaseAmount3+'</td>';
        tbody += '<td>所占市场份额</td>';
        tbody += '<td>'+item.averagePrice3+'</td></tr></tbody>';
        cpps.append(tbody);
    });
    //合作情况
    var coop = data.cooperation;

}
/**
 * 基本信息页百科上传数据
 */
function customerEncyclopediaObj(){
    var data = {
        "companyInfo": $('[name="companyInfo"]').val(),
        "developHis": $('[name="developHis"]').val(),
        "sellNetwork": $('[name="sellNetwork"]').val(),
        "customField": $('[name="customField"]').val(),
        // "lastmodifyUserIdEn": ,
        "modifyTimeEn": getTime()//最后编辑时间
    };
    return data;
}

/**
 *获取当前时间
 */
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

/**
 * 处理数组对象
 */
function arr() {

}