/**
 * Created by Loyun on 2017/3/28.
 */

$(document).ready(function(){
    getData(basePath + '/businessInfo/updateBusinessInfoById','POST',GetRequest(),businessopportunityinfo);
})

function businessopportunityinfo(result) {
    var ResultData = result.data;
    console.log(ResultData);


}