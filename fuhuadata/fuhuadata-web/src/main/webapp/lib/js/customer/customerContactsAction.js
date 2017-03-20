/**
 * Created by Loyun on 2017/3/20.
 */

$(document).ready(function(){
    getData(basePath+'/customerLinkman/getCustomerLinkmanByCustomerId','POST',GetRequest(),customerContactsList);
})