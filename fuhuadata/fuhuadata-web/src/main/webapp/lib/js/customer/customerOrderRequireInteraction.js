/**
 * Created by huxiangyang on 2017/3/30.
 */

$(function () {

    //创建面包屑导航
    $('#location').append(createCrumbsD());

    //设置title标题
    var title = $('#pTitle').text()+'——'+$('#sTitle').text();
    $('#hTitle').text(iGetInnerText(title));

    init();
    var orderData;                                 //定义获取的数据
    var optionNames = '';                          //定义产品种类集合
    var newData = [];                              //定义新数据
    var name = $('#name');                         //定义产品种类select控件
    var documentaryType = $('documentaryType');    //定义单据类型select控件
    //为获取的数据赋值
    jQuery.ajax({
        url:basePath+'/customerBaseInfoOrderRequire/getBillRequireList',
        type:'POST',
        data:GetRequest(),
        async:false
    }).done(function (result) {
        orderData = result.data;
    }).fail(function(result){
        console.log('error:'+result.status);
    });
    //console.log(orderData);

    //为新数据、产品种类、单据类型赋值
    jQuery.each(orderData,function (n,item) {
        var obj = {};
        obj.name = item.name;
        obj.productId = item.productId;
        obj.documentaryRequire = item.documentaryRequire;
        obj.otherDocumentaryRequire = item.otherDocumentaryRequire;
        obj.shippingAgentRequire = item.shippingAgentRequire;
        obj.packageRequire = item.packageRequire;
        obj.goodsType = obj.goodsType;
        obj.mianxiangqi = obj.mianxiangqi;
        obj.miantuiqi = obj.miantuiqi;
        optionNames += '<option value="'+item.productId+'">'+item.name+'</option>';
        newData.push(obj);
    });

    //渲染产品种类select
    name.append(optionNames);

    //渲染单据类型select
    var obj = {};
    obj.productId = name.val();
    screenData(obj,newData,customerBillRequire);
    $(document).on('change.screen','#name',function () {
        var obj = {};
        obj.productId = name.val();
        screenData(obj,newData,customerBillRequire);
    });

})

