/**
 * 给副导航href绑定参数
 */
$('#deputyNav').find('a').attr('href',function(i,val){
    console.log($('#customerId').val());
    return val+'?customerId='+$('#customerId').val();
});
