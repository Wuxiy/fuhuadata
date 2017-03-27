/**
 * Created by Loyun on 2017/3/22.
 */

$(document).ready(function(){
    getData(basePath + '/customerVisitRecord/getCustomerVisitRecordByCustomerId','POST',GetRequest(),visitList);

    //新增提交
    $(document).on('click.up','#addVisit',function(){
        //提交数据
        var startTime = $('#startTime').val();
        var activityExpense = $('#activityExpense').val();
        var activityType = $('#activityType').val();
        var activityRemarks = $('#activityRemarks').val();
        if(startTime == ''||activityExpense == ''||activityType == ''){
            alert('请完善表单必填项');
            return false;
        }else if(activityType == 5 && activityRemarks == ''){
            alert('请填写其他活动类型备注');
            return false;
        }else{
            upData(basePath+'/customerVisitRecord/addCustomerVisitRecord','POST',addVisit(),"application/json");
            location.reload();
        }

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
                                '<td>'+replace(ResultData[i].activityType,ResultData[i].activityRemarks)+'</td>'+
                                '<td>'+ResultData[i].activityAddress+'</td>'+
                                '<td>'+ResultData[i].activityExpens+'</td>'+
                                '<td>'+ResultData[i].name+'</td>'+
                                '<td>'+ResultData[i].activityGift+'</td>'+
                                '<td>'+ResultData[i].activitySummary+'</td>'+
                                '</tr>';
    }
}

function replace(arr1,arr2){
        switch (arr1){
            case 0:
                arr1 ='远程沟通';
                break;
            case 1:
                arr1 = '出差拜访';
                break;
            case 2:
                arr1 = '展会邀请';
                break;
            case 3:
                arr1 = '工厂参观';
                break;
            case 4:
                arr1 = '商务宴请';
                break;
            case 5:
                arr1 = arr2;
                break;
        }
    return arr1;
}

//modal list
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