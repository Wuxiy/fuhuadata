/**
 * Created by Loyun on 2017/3/23.
 */

$(document).ready(function(){
    getData(basePath + '/customerSubcompanyInfo/getCustomerSubcompanyInfosByCustomerId','POST',GetRequest(),anotherNamerList);

    //新增提交
    $(document).on('click.up','#addanothername',function(){
        //提交数据
        upData(basePath+'/customerSubcompanyInfo/addCustomerSubcompanyInfo','POST',addAnotherName(),"application/json");
        /*location.reload();*/
    });
    //更新提交
    $(document).on('click.up','#updateinfo',function(){
        //提交数据
        upData(basePath+'/customerSubcompanyInfo/addCustomerSubcompanyInfo','POST',updateInfo(),"application/json");
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
        "customerId":sid,
        "fullName":getDateTime($('#fullNameAdd').val()),
        "shortName":getDateTime($('#shortNameAdd').val()),
        "zhongxinbaoNumber":$('#zhongxinbaoNumberAdd').val(),
        "zhongxinbaoLevel":$('#zhongxinbaoLevelAdd').val(),
        "customerSubRemarks":$('#customerSubRemarksAdd').val(),
        "property":checkboxAdd(),
        "propertyRemarks":$('#propertyRemarks').val()
    }
    console.log(data);
    return JSON.stringify(data);
}

function checkboxAdd() {
    var checkboxarr = [];
    var a;
    $("input[name='checkAdd']:checked").each(function(){
        a =  $(this).val();
        checkboxarr.push(a);
    })
    return JSON.stringify(checkboxarr);
}

$(document).on('click','input[name="checkAdd"]',function(){
    if($(this).val() == 4){
        $('#propertyRemarksAdd').attr('disabled',false);
    }else{
        $('#propertyRemarksAdd').attr('disabled',true);
    }
})


//edit function
function updateInfo() {
    var data = {
        "customerId":sid,
        "fullName":getDateTime($('#fullName').val()),
        "shortName":getDateTime($('#shortName').val()),
        "zhongxinbaoNumber":$('#zhongxinbaoNumber').val(),
        "zhongxinbaoLevel":$('#zhongxinbaoLevel').val(),
        "customerSubRemarks":$('#customerSubRemarks').val(),
        "property":checkboxArr(),
        "propertyRemarks":$('#propertyRemarks').val()
    }
    console.log(data);
    return JSON.stringify(data);
}

function checkboxArr() {
    var checkboxarr = [];
    var a;
    $("input[name='check']:checked").each(function(){
        a =  $(this).val();
        checkboxarr.push(a);
    })
    return JSON.stringify(checkboxarr);
}

$(document).on('click','input[name="check"]',function(){
    if($(this).val() == 4){
        $('#propertyRemarks').attr('disabled',false);
    }else{
        $('#propertyRemarks').attr('disabled',true);
    }
})
