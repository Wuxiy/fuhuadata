/**
 * Created by Loyun on 2017/3/23.
 */

$(document).ready(function(){

    //创建面包屑导航
    // $('#location').append(createCrumbsAnother());

    //设置title标题
    // var title = $('#pTitle').text()+'——'+$('#sTitle').text();
    // $('#hTitle').text(iGetInnerText(title));

    getData(basePath + '/customerSubcompanyInfo/getCustomerSubcompanyInfosByCustomerId','POST',GetRequest(),anotherNamerList);

    //新增提交
    $(document).on('click.up','#addanothername',function(){
        //提交数据
        var fullNameAdd = $('#fullNameAdd').val();
        var xingzhiAdd = $("input[name='checkAdd']:checked");
        var propertyRemarksAdd = $('#propertyRemarksAdd').val();
        if(fullNameAdd == ''||xingzhiAdd.length<0){
            alert('请完善表单必填项');
            return false;
        }
        // else if($("#other:checked")&&propertyRemarksAdd == ''){
        //     alert('请输入企业性质备注');
        //     return false;
        // }
        else{
            upData(basePath+'/customerSubcompanyInfo/addCustomerSubcompanyInfo','POST',addAnotherName(),"application/json");
            // location.reload();
        }
    });
    //更新提交
    $(document).on('click.up','#updateinfo',function(){
        //提交数据
        var fullName = $('#fullName').val();
        var xingzhi = $("input[name='check']:checked");
        var propertyRemarks = $('#propertyRemarks').val();
        if(fullName == ''||xingzhi.length<0){
            alert('请完善表单必填项');
            return false;
        }
        // else if($("#otherAdd:checked")&&propertyRemarks == ''){
        //     alert('请输入企业性质必填项');
        //     return false;
        // }
        else{
            upData(basePath+'/customerSubcompanyInfo/updateCustomerSubcompanyInfoById','POST',updateInfo(),"application/json");
            /*location.reload();*/
        }

    });
});

//渲染List
function anotherNamerList(result) {
    var ResultData = result;
    var AnotherNameList = document.getElementById('anotherNameList');
    console.log(ResultData);
    AnotherNameList.innerHTML = '';
    if(ResultData) {
        for (var i = 0; i < ResultData.length; i++) {
            AnotherNameList.innerHTML += '<tr>' +
                '<td>' + ResultData[i].customerSubId + '</td>' +
                '<td><a class="otherNameinfo" data_url="' + basePath + '/customerSubcompanyInfo/getCustomerSubcompanyInfoById?customerSubId=' + ResultData[i].customerSubId + '">' + ResultData[i].fullName + '</a></td>' +
                '<td>' + ResultData[i].shortName + '</td>' +
                '<td>' + replace(ResultData[i].property, ResultData[i].propertyRemarks) + '</td>' +
                '<td>' + ResultData[i].zhongxinbaoNumber + '</td>' +
                '<td>' + replacelevel(ResultData[i].zhongxinbaoLevel) + '</td>' +
                '<td>' + ResultData[i].customerSubRemarks + '</td>' +
                '</tr>';
        }
    }
}

function replacelevel(arr) {
    switch (arr){
        case 1:
            arr = 'A';
            break;
        case 2:
            arr = 'AA';
            break;
        case 3:
            arr = 'AAA';
            break;
        case 4:
            arr = 'AAAA';
            break;
    }
    return arr;
}

function replace(arr1,arr2) {
    if(arr1.indexOf('其他')){
        arr1 = arr1.replace('其他',arr2);
    }
    return arr1;
    console.log(arr1);
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
            $("input[name='check']").val([]);
            $.each(arr,function(index,suitname){
                $("input[name='check']").each(function(){
                        if($(this).attr('data-text') == suitname){
                            $(this).prop('checked',true);
                            if(suitname == 4){
                                $('#propertyRemarks').val(ResultData.propertyRemarks);
                            }
                        }
                })
            })
            $('#fullName').attr('data-id',ResultData.customerSubId);
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
            "customerId":$('#customerId').val(),
            "fullName":$('#fullNameAdd').val(),
            "shortName":$('#shortNameAdd').val(),
            "zhongxinbaoNumber":$('#zhongxinbaoNumberAdd').val(),
            "zhongxinbaoLevel":$('#zhongxinbaoLevelAdd').val(),
            "customerSubRemarks":$('#customerSubRemarksAdd').val(),
            "propertyRemarks":$('#propertyRemarks').val(),
            "property":checkboxAddtext(),
            "createTime": getTime(),

        },
        "customerEnterpriceNatures":checkboxarrAdd()
    };
    console.log(data);
    return JSON.stringify(data);//封装JSON对象
}
/*
function checkboxAddtext(){
    var arr = "";
    $("input[name='checkAdd']:checked").each(function(){
        var a = $(this).attr('data-textAdd');
        arr += a;
    })
    console.log(arr);
    return JSON.stringify(arr);
}*/

function checkboxarrAdd() {
    var checkboxarrAdd= [];
    var obj;
    $("input[name='checkAdd']:checked").each(function(){
        obj = {
            "customerId":$('#customerId').val(),
            "type": "2",
            "nature": $(this).val()
        };
        checkboxarrAdd.push(obj);
    });
    return checkboxarrAdd;
}

function checkboxAddtext() {
    var a = [];
    var b;
    $("input[name='checkAdd']:checked").each(function(){
        a.push($(this).attr('data-textAdd'));
    });
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
});


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
    };
    console.log(data);
    return JSON.stringify(data);
}

function checkboxtext(){
    var a = [];
    var b;
    $("input[name='check']:checked").each(function(){
       a.push($(this).attr('data-text'));
    });
    b = a.join(',');
    console.log(b);
    return b;
}

function checkboxArr() {
    var checkboxarr = [];
    var obj;
    $("input[name='check']:checked").each(function(){
        obj = {
            "customerId":$('#fullName').attr('data-id'),
            "type": "2",
            "nature": $(this).val()
        };
        checkboxarr.push(obj);
    });
    return checkboxarr;
}

$(document).on('change','#other',function(){
    if($(this).prop('checked')){
        $('#propertyRemarks').attr('disabled',false);
    }else{
        $('#propertyRemarks').attr('disabled',true);
    }
});