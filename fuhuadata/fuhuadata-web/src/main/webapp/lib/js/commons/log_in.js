/**
 * Created by zhangxiang on 2017/2/8.
 */
$(function () {
    /** 绑定登录事件*/
    $('#login').click(loginAction);
});
function loginAction() {
    var account=$('#account').val();
    var password=$('#password').val();

    var data={'account':account,'password':password};
    $.post(basePath+"/account/login.action",data,function(result) {
        if(result.code==1){
            location.href=basePath+"/productProblem/productProblemList.do";
        }else{
            $('#login').text(result.message);
        }
    })
};
