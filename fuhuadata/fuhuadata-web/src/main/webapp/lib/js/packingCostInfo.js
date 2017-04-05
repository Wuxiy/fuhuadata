/**
 * Created by young on 2017/3/7.
 */

    //分割url，获取上个页面传过来的id
    var thisURL = document.URL;
    var trans = thisURL.split('?')[1];
    var trans1 = trans.split('&')[0];
    var trans2 = trans.split('&')[1];
    var id = trans1.split('=')[1];
    var bid = trans2.split('=')[1];
    console.log(bid);
    var table = document.getElementById('packing_relate_table');
    var imgContent = document.getElementById('imgContent');

    if(bid != 1){
        $('.relate').hide();
    }

$(document).ready(function(){
    var url = basePath+'/packingArchives/getPackingArchivesById?id='+id;
    jQuery.ajax({
        type:'GET',
        url:url,
        success:function(result){
            var ResultData = result.data;

            if(ResultData.pack){
                var pack = ResultData.pack;
                var arr = pack.suitableType;
                var arr2 = arr.split(',');
                $.each(arr2,function(index,suitname){
                    $("input[name='check']").each(function(){
                        if($(this).val() == suitname){
                            $(this).attr('checked',true);
                        }
                    })
                })
                $('#packName').val(pack.packName);
                $('#spec').val(pack.spec);
                $('#size').val(pack.size);
                $('#quality').val(pack.quality);
                $('#qualityIndex').val(pack.qualityIndex);
                $('#qualityTargetValue').val(pack.qualityTargetValue);
                $('#unitPrice').val(pack.unitPrice);
                $('#consumption').val(pack.consumption);
                $('#priceEndDate').val(pack.priceEndDate);
                $('#status').val(pack.status);
                $('#bRemarks').val(pack.bRemarks);
            }

            if(ResultData.nodes){
                var node = ResultData.nodes;
                for(var i=0;i<node.length;i++){
                    table.innerHTML += '<tr>'+
                        '<td class="text-center"><input type="checkbox" name="cellcheckbox" value="'+node[i].packingId+'" /></td>'+
                        '<td class="col-xs-2 text-center text-middle">'+node[i].packingId+'</td>'+
                        '<td class="col-xs-2 text-center text-middle">'+node[i].packName+'</td>'+
                        '<td class="col-xs-1 text-center text-middle">'+node[i].spec+'</td>'+
                        '<td class="col-xs-1 text-center text-middle">'+node[i].size+'</td>'+
                        '<td class="col-xs-2 text-center text-middle">'+node[i].quality+'</td>'+
                        '<td class="col-xs-1 text-center text-middle">'+node[i].unitPrice+'</td>'+
                        '<td class="col-xs-1 text-center text-middle">'+node[i].consumption+'</td>'+
                        '<td class="col-xs-1 text-center text-middle">'+node[i].status+'</td>'
                    '</tr>';
                }
            }

            if(ResultData.imagePath){
                $('.form-btn').show();
                var reData = ResultData.imagePath;
                for(var j=0;j<reData.length;j++){
                    imgContent.innerHTML += '<div class="col-xs-3">'+
                        '<img src="../'+reData[j].path+'" class="fileimg" width="300px" height="200px" style="margin-bottom:2%">'+
                        '<input type="file" name="file" style="margin-bottom:2%" disabled><div>'+
                        '<input type="text" name="file" class="filename" data-url="'+reData[j].path+'" style="margin-bottom:2%" value="'+reData[j].name+'" disabled>'+
                        '</div>'+
                        '</div>';
                }
            }

        }
    })
})

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
                $('.fileimg').eq(i).attr('src',basePath+"/"+item);
            })

        }
    });
    return false;
}

//图片JSON
function imgArr(){
    var arr=[];
    $('.filename').each(function(){
        var names = $(this).val();
        var newnames = names.sort();
        for(var i=0;i<newnames.length;i++){
            if(newnames[i]==newnames[i+1]){
                alert('请输入不容的图片规格型号！');
                return false;
            }
        }
        var obj ={
            "name":$(this).val(),
            "path":$(this).attr('data-url')
        };
        arr.push(obj);
    })
    return JSON.stringify(arr);
}


//适用产品类型checkbox
function checkboxArr() {
    var checkboxarr = [];
    var a;
    $("input[name='check']:checked").each(function(){
        a =  $(this).val();
        checkboxarr.push(a);
    })
    return JSON.stringify(checkboxarr);
}

//baocai编辑
$(document).on('click.edit','#edit',function () {
});
//baocai信息取消提交
$(document).on('click.cancel','#cancel',function(){
});

//编辑完成保存
    $('#finish').on('click',function(){
        var url = basePath+'/packingArchives/doModify';
        var data = {
            "packingId":id,
            "packName": jQuery('#packName').val(),
            "spec": jQuery('#spec').val(),
            "size": jQuery('#size').val(),
            "quality": jQuery('#quality').val(),
            "qualityIndex": jQuery('#qualityIndex').val(),
            "qualityTargetValue": jQuery('#qualityTargetValue').val(),
            "unitPrice": jQuery('#unitPrice').val(),
            "consumption": jQuery('#consumption').val(),
            "priceEndDate": jQuery('#priceEndDate').val(),
            "status": jQuery('#status').val(),
            "suitableType": checkboxArr(),
            "imagePath":imgArr(),
            "associatedPackingId":Ids(),
            "bRemarks": jQuery('#bRemarks').val(),
        }

        console.log(data);
        jQuery.ajax({
            type:"POST",
            url:url,
            dataType:"json",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(){
                alert("保存成功");
                location.reload();
            }
        })
    })

function Ids() {
    var ids = new Array();
    $("input[name='cellcheckbox']").each(function(){
        ids.push($(this).val());
    });
    return JSON.stringify(ids);
}

//关联包材全选
$('#checkAll').on('click',function(){
    var checkAll = $('#checkAll'),
        allCheckbox = $("input[name='cellcheckbox']");

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

//批量删除
$('#delete').on('click',function(){
    var ids = new Array();
    $("input[name='cellcheckbox']:checked").each(function(){
        ids.push($(this).val());
    })

    if(ids.length > 0){
        var msg = "确定要删除这些关联吗？";
        if(confirm(msg)){
            var url = basePath + 'deleteRelation?id=' + id;
            var data = ids;

            jQuery.ajax({
                url:url,
                type:'POST',
                dataType:"json",
                contentType:"application/json",
                data:JSON.stringify(data),
                success:function(){
                    alert("批量删除成功");
                    location.reload();
                }
            })
        }
    }else{
        alert("还未选择需要删除的关联！");
    }
})

//添加关联
$('#finish_relate').on('click',function(){
    var ids = new Array();
    $("input[name='modal_cellcheckbox']:checked").each(function(){
        ids.push($(this).val());
    })

    if(ids.length > 0){
        var msg = "确认要为主材添加这些关联吗？";
        if(msg){
            var url = basePath + 'addRelation?id=' + id;
            var data = ids;
            console.log(ids);
            jQuery.ajax({
                url:url,
                type:'POST',
                dataType:"json",
                contentType:"application/json",
                data:JSON.stringify(data),
                success:function(){
                    alert("添加关联成功！");
                    location.reload();
                }
            })
        }
    }else{
        alert('还未选择要添加的关联');
    }
})




