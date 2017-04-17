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
    // jQuery.ajax({
    //     url:basePath+'/customerBaseInfoOrderRequire/getBillRequireList',
    //     type:'POST',
    //     data:GetRequest(),
    //     async:false
    // }).done(function (result) {
    //     orderData = result.data;
    // }).fail(function(result){
    //     console.log('error:'+result.status);
    // });
    //console.log(orderData);


    // //单据要求对象
    // private DocumentaryVo documentaryVo;
    //
    // /**其他单据要求**/
    // private String otherDocumentaryRequire;

    // /**对船公司要求**/
    // private String shippingAgentRequire;
    //
    // /**装箱要求**/
    // private String packageRequire;
    // /**装箱要求对象**/
    // private PackingRequireVo packingRequireVo;
    //
    // /**出运货物货物类型，0普通，1危险品**/
    // private Integer goodsType;
    //
    // /**免用箱期**/
    // private Integer mianxiangqi;
    //
    // /**免推期**/
    // private Integer miantuiqi;
    //
    // /**柜子规格**/
    // private Integer cupboardType;
    //
    // /**整柜数量**/
    // private Integer cupboardPerNumber;
    //
    // /**柜数**/
    // private Integer cupboardNumber;

    // 数据重构
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

});

