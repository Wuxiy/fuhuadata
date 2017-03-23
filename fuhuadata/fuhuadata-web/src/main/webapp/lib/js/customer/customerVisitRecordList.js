/**
 * Created by Loyun on 2017/3/22.
 */

$(document).ready(function(){
    getData(basePath + '/customerVisitRecord/getCustomerVisitRecordByCustomerId','POST',GetRequest(),visitList);

    //新增提交
    $(document).on('click.up','#addVisit',function(){
        //提交数据
        upData(basePath+'/customerVisitRecord/addCustomerVisitRecord','POST',addVisit(),"application/json");

    });
})
var id = document.URL.split('?')[1];
var sid = id.split('=')[1];

$(document).on('click','#add',function () {
    console.log(id);
    var url = basePath + '/customerLinkman/getCustomerLinkmanByCustomerId';
    getData(url,'POST',id,modalContact);
})

//list
function visitList(result) {
    var visitList = document.getElementById('visitList');
    var ResultData = result;
    console.log(ResultData);

    for(var i=0;i<ResultData.length;i++){
        visitList.innerHTML += '<tr>'+
                                '<td>'+ResultData[i].startTime+'</td>'+
                                '<td>'+ResultData[i].endTime+'</td>'+
                                '<td>'+ResultData[i].activityType+'</td>'+
                                '<td>'+ResultData[i].activityAddress+'</td>'+
                                '<td>'+ResultData[i].activityExpens+'</td>'+
                                '<td>'+ResultData[i].name+'</td>'+
                                '<td>'+ResultData[i].activityGift+'</td>'+
                                '<td>'+ResultData[i].activitySummary+'</td>'+
                                '</tr>';
    }
}

function modalContact(result) {
    var modalContactList = document.getElementById('modalContactList');
    var ResultData = result;
    modalContactList.innerHTML = '';
    for(var i=0;i<ResultData.length;i++){
        modalContactList.innerHTML += '<tr>'+
                                        '<td><input type="checkbox" name="cellcheckbox"></td>'+
                                        '<td name="Lname" data-name="'+ResultData[i].name+'">'+ResultData[i].name+'</td>'+
                                        '<td><input type="text" name="gift" disabled></td>'+
                                        '</tr>';
    }
    $('#addField').modal('show');
}

//add function
function addVisit() {
    var data = {
        "customerVisitRecord":{
            "customerId":sid,
            "startTime":getDateTime($('#startTime').val()),
            "endTime":getDateTime($('#endTime').val()),
            "activityAddress":$('#activityAddress').val(),
            "activityExpense":$('#activityExpense').val(),
            "activityType":$('#activityType').val(),
            "activityRemarks":$('#activityRemarks').val(),
            "activitySummary":$('#activitySummary').val()
        },
        "recordLinkmen":recordLinkman()
    }
    console.log(data);
    return JSON.stringify(data);
}

//拜访记录
function recordLinkman() {
    var arr = [];
    $("input[name='cellcheckbox']:checked").each(function(){
        var obj = {
            "linkmanId":$(this).parents('tr').find('[name="Lname"]').attr('data-name'),
            "activityGift":$(this).parents('tr').find('[name="gift"]').val()
        }
        arr.push(obj);
    })
    console.log(arr);
    return JSON.stringify(arr);
}

$('#checkAll').on('click',function(){
    var checkAll = $('#checkAll'),
        allCheckbox = $("input[name='cellcheckbox']");

    //监听全选框变化
    checkAll.change(function(){
        if (checkAll.prop("checked")) {
            allCheckbox.each(function(){
                $(this).prop('checked',true);
                $(this).parents('tr').find('[name="gift"]').attr('disabled',false);
            });
        } else {
            allCheckbox.each(function(){
                $(this).prop('checked',false);
                $(this).parents('tr').find('[name="gift"]').attr('disabled',true);
            });
        }
    });
})

$(document).on('change','input[name="cellcheckbox"]',function(){
    if($(this).prop('checked')){
        $(this).parents('tr').find('[name="gift"]').attr('disabled',false);
    }else {
        $(this).parents('tr').find('[name="gift"]').attr('disabled',true);
    }
})

$(document).on('click','#activityType',function(){
    if($(this).val() == 5){
        $('#activityRemarks').attr('disabled',false);
    }else{
        $('#activityRemarks').attr('disabled',true);
    }
})

//获取datetime
function getDateTime(datetime){
    var date = datetime.split('T')[0];
    var time = datetime.split('T')[1] + ':59';
    console.log(date);
    console.log(time);
    var DateTime = date + ' ' + time;
    console.log(DateTime);
    return DateTime;
}