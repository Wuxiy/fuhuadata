/**
 * Created by huxiangyang on 2017/3/30.
 */

$(function () {

    var orderData = null, // 获取的单据数据
        name = $('#name'); // 产品种类select控件

    // 获取数据并渲染表单
    CRM.ajaxCall({
        url:basePath + '/customerBaseInfoOrderRequire/getTransportRequireList',
        data:ajaxParam(),
        type:'POST',
        callback:function (data) {

            orderData = reconstructionTraData(data); // 将data赋给外部变量，闭包
            renderSelect(orderData,'nameC',name); // 渲染下拉菜单
            resetbillPanel(); // 重置表单
            screenData({wareId:name.val()},orderData,customerTransportRequire); // 根据下拉框的值渲染数据
        }
    });

    // 下拉框的值改变时渲染数据
    $(document).on('change.screen','#name',function () {
        var obj = {
            wareId:name.val()
        };
        resetbillPanel(); // 重置表单
        screenData(obj,orderData,customerTransportRequire);
    });

});