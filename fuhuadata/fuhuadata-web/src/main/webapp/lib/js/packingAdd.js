/**
 * Created by young on 2017/3/6.
 */

    var img = $("input[name='file']");

    var addTbody = document.getElementById('add_tbody');

    //根据包材类型获取关联包材的展示
    if(bid != 1){
        $('.relate').hide();
    }



//图片上传

function fsubmit(){
    var data = new FormData($('#form1')[0]);
    console.log(data);
    jQuery.ajax({
        url: basePath+'/upload/uploadFileAll',
        type: 'POST',
        data: data,
        dataType: 'JSON',
        cache: false,
        processData: false,
        contentType: false,
        success:function (result) {
            console.log(result);
            $.each(result.data,function(i,item){
                console.log(item);
                $('.filename').eq(i).attr('data-url',item);
                $('.fileimg').eq(i).attr('src',"../"+basePath+item);
            })
        }
    });
    return false;
}

//适用产品类型checkbox

function checkboxArr() {
    var checkboxarr = [];
    var a;
    $("input[name='check']:checked").each(function(){
        a =  $(this).val();
        checkboxarr.push(a);
    })
    return checkboxarr;
}

//图片JSON
function imgArr(){
    var arr=[];
    $('.filename').each(function(){
        var obj ={
            "name":$(this).val(),
            "path":$(this).attr('data-url'),
        };
        arr.push(obj);
    })
    return JSON.stringify(arr);
}

//添加关联时比较数组，删除重复项
function mergeArray(arr1, arr2){
    var temp = []; //临时数组1
    var temparray = [];//临时数组2
    for (var i = 0; i < arr2.length; i++) {
        temp[arr2[i]] = true;
    };
    for (var i = 0; i < arr1.length; i++) {
        if (!temp[arr1[i]]) {
            temparray.push(arr1[i]);
        }
    }
    return temparray;
}

//新增添加关联
$('#add_relate').on('click',function(){
    var ids1 = new Array();
    var ids2 = new Array();
    var ids = new Array();
    $("input[name='modal_cellcheckbox']:checked").each(function(){
        ids1.push($(this).val());
    });
    $("input[name='cellcheckbox']").each(function(){
        ids2.push($(this).val());
    });

    ids = mergeArray(ids1,ids2);
    console.log(ids);
    $('#addField').modal('hide');
    if(ids.length > 0){
        var msg = "确认要为主材添加这些关联吗？";
        if(msg){
            var url = basePath+'/packingArchives/getByIds';
            jQuery.ajax({
                url:url,
                type:'POST',
                dataType:"json",
                contentType:"application/json",
                data:JSON.stringify(ids),
                success:function(result){
                    alert("添加关联成功！");
                    for(var i=0;i<result.data.length;i++){
                        addTbody.innerHTML += '<tr>'+
                            '<td class="text-center"><input type="checkbox" name="cellcheckbox" value="'+result.data[i].packingId+'" /></td>'+
                            '<td class="col-xs-2 text-center text-middle">'+result.data[i].packingId+'</td>'+
                            '<td class="col-xs-2 text-center text-middle">'+result.data[i].packName+'</td>'+
                            '<td class="col-xs-1 text-center text-middle">'+result.data[i].spec+'</td>'+
                            '<td class="col-xs-1 text-center text-middle">'+result.data[i].size+'</td>'+
                            '<td class="col-xs-2 text-center text-middle">'+result.data[i].quality+'</td>'+
                            '<td class="col-xs-1 text-center text-middle">'+result.data[i].unitPrice+'</td>'+
                            '<td class="col-xs-1 text-center text-middle">'+result.data[i].consumption+'</td>'+
                            '<td class="col-xs-1 text-center text-middle">'+result.data[i].status+'</td>'
                        '</tr>';
                    }

                }
            })
        }
    }else{
        alert('还未选择要添加的关联');
    }
})

function Ids() {
    var ids = new Array();
    $("input[name='cellcheckbox']").each(function(){
        ids.push($(this).val());
    });
    return JSON.stringify(ids);
}

//新增完成
$('.packingAdd').on('click',function(){

    var names = [];
    $('.filename').each(function(){
        names.push($(this).val());
    })
    var newnames = names.sort();
    console.log(newnames);
    for(var i=0;i<newnames.length;i++) {
        if (newnames[i] == newnames[i + 1]) {
            alert('请输入不容的图片规格型号！');
            return false;
        }
    }

    var url = basePath+'/packingArchives/doAddPackingArchives';
    var data = {
        "bigCategoryId":jQuery('#bid').val(),
        "smallCategoryId":jQuery('#sid').val(),
        "packName": jQuery('#packName').val(),
        "spec": jQuery('#spec').val(),
        "size": jQuery('#size').val(),
        "quality": jQuery('#quality').val(),
        "qualityIndex": jQuery('#qualityIndex').val(),
        "qualityTargetValue": jQuery('#qualityTargetValue').val(),
        "unitPrice": jQuery('#unitPrice').val().toString(),
        "consumption": jQuery('#consumption').val(),
        "priceEndDate": jQuery('#priceEndDate').val(),
        "status": jQuery('#status').val(),
        "suitableType": JSON.stringify(checkboxArr()),
        "imagePath":imgArr(),
        "associatedPackingId":Ids(),
        "bRemarks": jQuery('#bremarks').val(),
    }
    console.log(data);
    /*jQuery.ajax({
        type:"POST",
        url:url,
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(data),
        success:function(){
            alert("添加成功");
            location.reload();
        }
    })*/
})

//全选框
$('#modal_checkAll').on('click',function(){
    var checkAll = $('#modal_checkAll'),
        allCheckbox = $("input[name='modal_cellcheckbox']");

    //监听全选框变化
    checkAll.change(function(){
        if (checkAll.prop("checked")) {
            allCheckbox.each(function(){
                $(this).prop('checked',true);
            });
        } else {
            allCheckbox.each(function(){
                $(this).prop('checked',false);
            });
        }
    });
})




