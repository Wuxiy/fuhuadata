/**
 * 给副导航href绑定参数
 */
var urlArg = location.search;
$('#deputyNav').find('a').attr('href',function(i,val){
    console.log(val+urlArg);
    return val+urlArg;
});
