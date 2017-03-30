/**
 * Created by Ynagyang on 2017/3/30.
 */

$(document).ready(function () {

    //创建面包屑导航
    $('#location').append(createCrumbsD());

    //设置title标题
    var title = $('#pTitle').text()+'——'+$('#sTitle').text();
    $('#hTitle').text(iGetInnerText(title));

    getData(basePath + '/customerProductPacking/getCustomerProductInfoById','GET',GetRequest(),ProductRequestList);
});

function ProductRequestList(result) {
    var ResultData = result;
    console.log(ResultData);

    var productRequestList = document.getElementById('productRequestList');
    for(var i=0;i<ResultData.length;i++){
        productRequestList.innerHTML += '<tr>'+
            '<td><a href="">'+ResultData[i].customerProductName+'</a></td>'+
            '<td>'+ResultData[i].categorySerialNumber+'</td>'+
            '<td>'+ResultData[i].categoryName+'</td>'+
            '<td>'+ResultData[i].productName+'</td>'+
            '<td>'+ResultData[i].brand+'</td>'+
            '<td>'+ResultData[i].specification+'</td>'+
            '<td>'+ResultData[i].model+'</td>'+
            '<td>'+ResultData[i].mainUnit+'</td>'+
            '<td>'+ResultData[i].factoryName+'</td>'+
            '</tr>';
    }
}