/**
 * Created by Loyun on 2017/3/23.
 */

$(document).ready(function(){
    getData(basePath + '/customerSubcompanyInfo/getCustomerSubcompanyInfosByCustomerId','POST',GetRequest(),anotherNamerList);
})

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

$(document).on('click','.otherNameinfo',function(){
    var url = $(this).attr('data_url');

    jQuery.ajax({
        type:'POST',
        url:url,
        success:function(result){
            var ResultData = result;
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
            $('#packName').val(ResultData.fullName);
            $('#spec').val(ResultData.shortName);
            $('#size').val(ResultData.zhongxinbaoNumber);
            $('#quality').val(ResultData.zhongxinbaoLevel);
            $('#qualityIndex').val(ResultData.customerSubRemarks);

            $('#addFieldinfo').modal('show');
        }
    })
})