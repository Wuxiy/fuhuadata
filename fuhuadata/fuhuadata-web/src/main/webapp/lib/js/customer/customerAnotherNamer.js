/**
 * Created by Loyun on 2017/3/23.
 */

$(document).ready(function(){
    getData(basePath + '/customerSubcompanyInfo/getCustomerSubcompanyInfosByCustomerId','POST',GetRequest(),anotherNamerList);

    //新增提交
    $(document).on('click.up','#addanothername',function(){
        //提交数据
        upData(basePath+'/customerSubcompanyInfo/addCustomerSubcompanyInfo','POST',addAnotherName(),"application/json");
        location.reload();
    });
    //更新提交
    $(document).on('click.up','#updateinfo',function(){
        //提交数据
        upData(basePath+'/customerSubcompanyInfo/updateCustomerSubcompanyInfoById','POST',updateInfo(),"application/json");
        /*location.reload();*/
    });
})

var id = document.URL.split('?')[1];
var sid = id.split('=')[1];

//渲染List
function anotherNamerList(result) {
    var ResultData = result;
    var AnotherNameList = document.getElementById('anotherNameList');
    console.log(ResultData);
    AnotherNameList.innerHTML = '';
    var arr1 = [{"id":0,"value":"工厂"},{"id":1,"value":"经销商"},{"id":2,"value":"分销商"},{"id":3,"value":"终端客户"}]
    for(var i=0;i<ResultData.length;i++){
        AnotherNameList.innerHTML += '<tr>'+
                                        '<td>'+ResultData[i].customerSubId+'</td>'+
                                        '<td><a class="otherNameinfo" data_url="'+basePath+'/customerSubcompanyInfo/getCustomerSubcompanyInfoById?customerSubId='+ResultData[i].customerSubId+'">'+ResultData[i].fullName+'</a></td>'+
                                        '<td>'+ResultData[i].shortName+'</td>'+
                                        '<td>'+ResultData[i].property+'</td>'+
                                        '<td>'+ResultData[i].zhongxinbaoNumber+'</td>'+
                                        '<td>'+ResultData[i].zhongxinbaoLevel+'</td>'+
                                        '<td>'+ResultData[i].customerSubRemarks+'</td>'+
                                        '</tr>';
    }
}

//详情
$(document).on('click','.otherNameinfo',function(){
    var url = $(this).attr('data_url');
    jQuery.ajax({
        type:'POST',
        url:url,
        success:function(result){
            var ResultData = result.data;

            var arr = ResultData.property.split(',');
            $.each(arr,function(index,suitname){
                $("input[name='check']").each(function(){
                        if($(this).val() == suitname){
                            $(this).attr('checked',true);
                            if(suitname == 4){
                                $('#propertyRemarks').val(ResultData.propertyRemarks);
                            }
                        }
                })
            })
            $('#fullName').attr('data-id',ResultData.customerSubId),
            $('#fullName').val(ResultData.fullName);
            $('#shortName').val(ResultData.shortName);
            $('#zhongxinbaoNumber').val(ResultData.zhongxinbaoNumber);
            $('#zhongxinbaoLevel').val(ResultData.zhongxinbaoLevel);
            $('#customerSubRemarks').val(ResultData.customerSubRemarks);

            $('#addFieldinfo').modal('show');
        }
    })
})


//Add function
function addAnotherName() {
    var data = {
        "customerSubcompanyInfo":{
            "customerId":sid,
            "fullName":$('#fullNameAdd').val(),
            "shortName":$('#shortNameAdd').val(),
            "zhongxinbaoNumber":$('#zhongxinbaoNumberAdd').val(),
            "zhongxinbaoLevel":$('#zhongxinbaoLevelAdd').val(),
            "customerSubRemarks":$('#customerSubRemarksAdd').val(),
            "propertyRemarks":$('#propertyRemarks').val(),
            "createTime": getTime(),
            "property":checkboxAddtext(),
            "createUserId": 2,
            "createUserName":"杨洋",
            "modifyTime":"2017-03-02 11:44:49",
            "lastmodifyUserId": 1,
            "lastmodifyUserName": "胡向阳"
        },
        "customerEnterpriceNatures":checkboxAdd()
    }
    console.log(data);
    return JSON.stringify(data);
}

function checkboxAddtext(){
    var arr = "";
    $("input[name='checkAdd']:checked").each(function(){
        var a = $(this).attr('data-text');
        arr += a;
    })
    console.log(arr);
    return JSON.stringify(arr);
}

function checkboxAdd() {
    var a = [];
    var b;
    $("input[name='checkAdd']:checked").each(function(){
        a.push($(this).attr('data-text'));
    })
    b = a.join(',');
    console.log(b);
    return b;
}

$(document).on('click','#otherAdd',function(){
    if($(this).prop('checked')){
        $('#propertyRemarksAdd').attr('disabled',false);
    }else{
        $('#propertyRemarksAdd').attr('disabled',true);
    }
})


//edit function
function updateInfo() {
    var data = {
        "customerSubcompanyInfo":{
            "customerSubId":$('#fullName').attr('data-id'),
            "fullName":$('#fullName').val(),
            "shortName":$('#shortName').val(),
            "zhongxinbaoNumber":$('#zhongxinbaoNumber').val(),
            "zhongxinbaoLevel":$('#zhongxinbaoLevel').val(),
            "customerSubRemarks":$('#customerSubRemarks').val(),
            "property":checkboxtext(),
            "propertyRemarks":$('#propertyRemarks').val()
        },
        "customerEnterpriceNatures":checkboxArr()
    }
    console.log(data);
    return JSON.stringify(data);
}

function checkboxtext(){
    var a = [];
    var b;
    $("input[name='check']:checked").each(function(){
       a.push($(this).attr('data-text'));
    })
    b = a.join(',');
    console.log(b);
    return b;
}

function checkboxArr() {
    var checkboxarr = [];
    var obj;
    $("input[name='check']:checked").each(function(){
        obj = {
            "customerId": "fh104",
            "type": "2",
            "nature": $(this).val()
        }
        checkboxarr.push(obj);
    })
    return JSON.stringify(checkboxarr);
}

$(document).on('change','#other',function(){
    if($(this).prop('checked')){
        $('#propertyRemarks').attr('disabled',false);
    }else{
        $('#propertyRemarks').attr('disabled',true);
    }
})
