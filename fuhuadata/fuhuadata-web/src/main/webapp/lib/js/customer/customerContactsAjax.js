/**
 * Created by Loyun on 2017/3/20.
 */

//联系人数据列表
function customerContactsList(result){
    var ResultData = result;
    var ContactsList = document.getElementById('contactsList');
    console.log(ResultData);

    if(ResultData){
        for(var i=0;i<ResultData.length;i++)
        ContactsList.innerHTML += '<tr><td>000002</td>'+
            '<td><a href="'+ResultData[i].linkmanId+'" target="_blank">'+ResultData[i].linkmanId+'</a></td>'+
            '<td>'+ResultData[i].name+'</td>'+
            '<td>'+ResultData[i].posts+'</td>'+
            '<td>'+ResultData[i].onJob+'</td>'+
            '<td>'+ResultData[i].responseArea+'</td>'+
            '<td>'+ResultData[i].sex+'</td>'+
            '<td>'+ResultData[i].nationality+'</td>'+
            '<td>'+ResultData[i].linkPhone1+'</td>'+
            '<td>'+ResultData[i].lemail+'</td>'+
            '<td>'+ResultData[i].remarks+'</td>'+
            '</tr>';
    }
}
