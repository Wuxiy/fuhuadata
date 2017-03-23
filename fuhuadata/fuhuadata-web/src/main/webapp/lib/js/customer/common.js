/**
 * Created by huxiangyang on 2017/3/13.
 */

/**
 * 给副导航href绑定参数
 */
var urlPar = location.search;
$('#deputyNav').find('a').attr('href',function(i,val){
    // console.log(val+urlPar);
    return val+urlPar;
});
