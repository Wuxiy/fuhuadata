/**
 * Created by huxiangyang on 2017/3/30.
 */

$(function () {

    var orderData = null, // 获取的单据数据
        name = $('#name'); // 产品种类select控件

    // var documentaryType = $('documentaryType');    //单据类型select控件

    //创建面包屑导航
    $('#location').append(createCrumbsD());

    //设置title标题
    var title = $('#pTitle').text()+'——'+$('#sTitle').text();
    $('#hTitle').text(iGetInnerText(title));

    init(); // 初始化

    // 获取数据并渲染表单
    CRM.ajaxCall({
        url:'/customerBaseInfoOrderRequire/getBillRequireList',
        data:ajaxParam(),
        type:'POST',
        callback:function (data) {

            orderData = reconstructionData(data); // 将data赋给外部变量，闭包
            renderSelect(orderData,'nameC',name); // 渲染下拉菜单
            screenData({productId:name.val()},orderData,customerBillRequire); // 根据下拉框的值渲染数据
        }
    });

    // 下拉框的值改变时渲染数据
    $(document).on('change.screen','#name',function () {
        var obj = {
            productId:name.val()
        };
        screenData(obj,orderData,customerBillRequire);
    });




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

});

