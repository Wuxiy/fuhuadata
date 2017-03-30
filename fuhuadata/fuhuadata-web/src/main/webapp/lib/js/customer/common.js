/**
 * Created by huxiangyang on 2017/3/13.
 */


//去除空格和换行符
function iGetInnerText(testStr) {
    var resultStr = testStr.replace(/\ +/g, "").replace(/[ ]/g, "").replace(/[\r\n]/g, "");
    return resultStr;
}

//构造面包屑导航栏
function createCrumbsD() {
    var f = '<li><a href="/customerBaseInfo/customerListPageInit?customerType=1">客户信息</a></li>';
    var s = '';
    if($('#customerType').val()==1){
        s = '<li><a href="/customerBaseInfo/customerListPageInit?customerType=1">合作客户</a></li>';
    }else if($('#customerType').val()==2){
        s = '<li><a href="/customerBaseInfo/customerListPageInit?customerType=2">潜在客户</a></li>';
    }else{
        s = '<li><a href="/customerBaseInfo/customerListPageInit?customerType=3">流失客户</a></li>';
    }
    var t = '<li id="pTitle" class="active">'+$('#fullName').val()+'</li>';
    return f+s+t;
}
function createCrumbsAnother() {
    var f = '<li><a href="/customerBaseInfo/customerListPageInit?customerType=1">客户信息</a></li>';
    var s = '';
    if($('#customerType').val()==1){
        s = '<li><a href="/customerBaseInfo/customerListPageInit?customerType=1">合作客户</a></li>';
    }else if($('#customerType').val()==2){
        s = '<li><a href="/customerBaseInfo/customerListPageInit?customerType=2">潜在客户</a></li>';
    }else{
        s = '<li><a href="/customerBaseInfo/customerListPageInit?customerType=3">流失客户</a></li>';
    }
    var t = '<li id="pTitle" class="active">'+$('#fullNameTitle').val()+'</li>';
    return f+s+t;
}
function createCrumbsL(){
    var f = '<li><a href="/customerBaseInfo/customerListPageInit?customerType=1">客户信息</a></li>';
    var s = '';
    if($('#customerType').val()==1){
        s = '<li class="active">合作客户列表</li>';
    }else if($('#customerType').val()==2){
        s = '<li class="active">潜在客户列表</li>';
    }else{
        s = '<li class="active">流失客户列表</li>';
    }
    return f+s;
}
