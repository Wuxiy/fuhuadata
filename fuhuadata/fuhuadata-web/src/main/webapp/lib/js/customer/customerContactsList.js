/**
 * Created by Loyun on 2017/3/20.
 */

$(document).ready(function(){

    //创建面包屑导航
    $('#location').append(createCrumbsD());

    //设置title标题
    var title = $('#pTitle').text()+'——'+$('#sTitle').text();
    $('#hTitle').text(iGetInnerText(title));

    getData(basePath + '/customerLinkman/getCustomerLinkmanByCustomerId','POST',GetRequest(),customerContactsList);

    //联系人数据列表
    function customerContactsList(result){
        var ResultData = result;
        var ContactsList = document.getElementById('contactsList');
        console.log(ResultData);

        if(ResultData){
            for(var i=0;i<ResultData.length;i++)
                ContactsList.innerHTML += '<tr>'+
                    '<td>'+ResultData[i].linkmanId+'</td>'+
                    '<td><a href="'+basePath+'/customerLinkman/intoCustomerLinkmanInfo?linkmanId='+ResultData[i].linkmanId+'">'+ResultData[i].name+'</a></td>'+
                    '<td>'+ResultData[i].posts+'</td>'+
                    '<td>'+(ResultData[i].onJob==0?'否':'是')+'</td>'+
                    '<td>'+ResultData[i].responseArea+'</td>'+
                    '<td>'+(ResultData[i].sex==0?'男':'女')+'</td>'+
                    '<td>'+ResultData[i].nationality+'</td>'+
                    '<td>'+ResultData[i].linkPhone1+'</td>'+
                    '<td>'+ResultData[i].lemail+'</td>'+
                    '<td>'+(ResultData[i].isDefault==0?'否':'是') +'</td>'+
                    '<td>'+ResultData[i].remarks+'</td>'+
                    '</tr>';
        }
    }
})