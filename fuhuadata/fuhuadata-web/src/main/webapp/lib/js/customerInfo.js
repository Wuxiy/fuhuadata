/**
 * Created by Think on 2017/3/16.
 */

/**
 * link
 */
$(function () {
    //获取初始数据
    $.ajax({
        url:'/customerBaseInfo/showCustomerBaseInfoDetails',
        type:'POST',
        data:GetRequest()
    }).done().fail(function(){
        console.log('没有获取到数据');
    });
    console.log(GetRequest());
})
