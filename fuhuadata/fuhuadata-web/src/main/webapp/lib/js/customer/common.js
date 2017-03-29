/**
 * Created by huxiangyang on 2017/3/13.
 */

/**
 * 给副导航href绑定参数
 */
$('#deputyNav,#asideNav').find('a').attr('href',function(i,val){
    // console.log(val+urlPar);
    return val+'?customer='+$('#customerId').val();
});
