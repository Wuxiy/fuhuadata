/**
 * Created by Loyun on 2017/3/22.
 */

$(document).ready(function(){
    getData(basePath + '/customerVisitRecord/getCustomerVisitRecordByCustomerId','POST',GetRequest(),visitList);
})

function visitList(result) {
    var ResultData = result;
    console.log(ResultData);
}