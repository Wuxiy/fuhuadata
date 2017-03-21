/**
 * Created by Loyun on 2017/3/20.
 */
$(document).ready(function(){
    getData(basePath + '/customerLinkman/getCustomerLinkmanDetailsById','POST',GetRequest(),customerContactsInfo);

    //编辑联系人基本信息
    $(document).on('click.edit','editCustomerBasic',function () {
    });
    //联系人基本信息提交
    $(document).on('click.up','#saveCustomerBasic',function(){
        //提交数据
        upData(basePath+'/customerLinkman/','POST',updateContactsInfo(),"application/json");
        location.reload();
    });
    //客户基本信息取消提交
    $(document).on('click.cancel','#cancelCustomerBasic',function(){
        location.reload();
    });
})

//详情列表
function customerContactsInfo(result) {
    console.log(result);
    var customerLinkman = result.customerLinkman;
    var customerVisitRecords = result.linkmanVisitRecordVOS;
    console.log(customerVisitRecords.activityType)
    var visitRecordsTable = document.getElementById('visitRecordsTable');
    if(customerLinkman){
        $('#name').val(customerLinkman.name);
        $('#posts').val(customerLinkman.posts);
        $('#responseArea').val(customerLinkman.responseArea);
        $('#onJob').val(customerLinkman.onJob);
        $('#sex').val(customerLinkman.sex);
        $('#birthday').val(customerLinkman.birthday);
        $('#nationality').val(customerLinkman.nationality);
        $('#influence').val(customerLinkman.influence);
        $('#exhibitionHabits').val(customerLinkman.exhibitionHabits);
        $('#fancy').val(customerLinkman.fancy);
        $('#linkPhone1').val(customerLinkman.linkPhone1);
        $('#linkPhone2').val(customerLinkman.linkPhone2);
        $('#lemail').val(customerLinkman.lemail);
        $('#eatingHabits').val(customerLinkman.eatingHabits);
        $('#faith').val(customerLinkman.faith);
        $('#isDefault').val(customerLinkman.isDefault);
        $('#lemail').val(customerLinkman.remarks);
    }
    if(customerVisitRecords){
        for(var i=0;i<customerVisitRecords.length;i++){
            visitRecordsTable.innerHTML += '<tr><td>'+customerVisitRecords[i].startTime+'</td>'+
                '<td>'+customerVisitRecords[i].endTime+'</td>'+
                '<td>'+customerVisitRecords[i].activityType+'</td>'+
                '<td>'+customerVisitRecords[i].activityAddress+'</td>'+
                '<td>'+customerVisitRecords[i].activityExpense+'</td>'+
                '<td>'+customerVisitRecords[i].activityGift+'</td>'+
                '<td>'+customerVisitRecords[i].activitySummary+'</td>'+
                '</tr>';
        }
    }
}

//提交上传
function updateContactsInfo() {

}