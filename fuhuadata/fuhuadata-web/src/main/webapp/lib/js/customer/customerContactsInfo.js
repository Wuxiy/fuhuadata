/**
 * Created by Loyun on 2017/3/20.
 */
$(document).ready(function(){
    getData(basePath + '/customerLinkman/getCustomerLinkmanDetailsById','POST',GetRequest(),customerContactsInfo);

    //编辑联系人基本信息
    $(document).on('click.edit','#edit',function () {
    });
    //联系人基本信息提交
    $(document).on('click.up','#save',function(){
        //提交数据
        upData(basePath+'/customerLinkman/updateById','POST',updateContactsInfo(),"application/json");
        location.reload();
    });
    //客户基本信息取消提交
    $(document).on('click.cancel','#cancel',function(){
        location.reload();
    });
})

//详情列表
function customerContactsInfo(result) {
    console.log(result);
    var customerLinkman = result.customerLinkman;
    var customerVisitRecords = result.linkmanVisitRecordVOS;
    var visitRecordsTable = document.getElementById('visitRecordsTable');
    if(customerLinkman){
        $('#name').attr('data-id',customerLinkman.linkmanId);
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
        $('#remarks').val(customerLinkman.remarks);
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
    var data = {
        "linkmanId":$('#name').attr('data-id'),
        "name":$('#name').val(),
        "posts":$('#posts').val(),
        "responseArea":$('#responseArea').val(),
        "onJob":$('#onJob').val(),
        "sex":$('#sex').val(),
        "birthday":$('#birthday').val(),
        "nationality":$('#nationality').val(),
        "influence":$('#influence').val(),
        "exhibitionHabits":$('#exhibitionHabits').val(),
        "fancy":$('#fancy').val(),
        "linkPhone1":$('#linkPhone1').val(),
        "linkPhone2":$('#linkPhone2').val(),
        "lemail":$('#lemail').val(),
        "eatingHabits":$('#eatingHabits').val(),
        "faith":$('#faith').val(),
        "isDefault":$('#isDefault').val(),
        "remarks":$('#remarks').val()
    }
    console.log(data);
    return JSON.stringify(data);
}