/**
 * Created by Loyun on 2017/3/22.
 */

$(document).ready(function(){
    getData(basePath + '/customerVisitRecord/getCustomerVisitRecordByCustomerId','POST',GetRequest(),visitList);
})

function visitList(result) {
    var visitList = document.getElementById('visitList');
    var ResultData = result;
    console.log(ResultData);

    for(var i=0;i<ResultData.length;i++){
        visitList.innerHTML += '<tr>'+
                                '<td>'+ResultData.startTime+'</td>'+
                                '<td>'+ResultData.endTime+'</td>'+
                                '<td>'+ResultData.activityType+'</td>'+
                                '<td>'+ResultData.activityAddress+'</td>'+
                                '<td>'+ResultData.activityExpens+'</td>'+
                                '<td>'+ResultData.name+'</td>'+
                                '<td>'+ResultData.activityGift+'</td>'+
                                '<td>'+ResultData.activitySummary+'</td>'+
                                '</tr>';
    }
}