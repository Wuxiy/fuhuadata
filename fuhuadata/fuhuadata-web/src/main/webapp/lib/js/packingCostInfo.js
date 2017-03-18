/**
 * Created by young on 2017/3/7.
 */

    $('.form-btn').hide();
    $('#finish').hide();
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
    var url = '/packingArchives/getPackingArchivesById?id='+id;
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
                        '<input type="file" name="file" style="margin-bottom:2%"><div>'+
                        '<input type="text" name="file" class="filename" style="margin-bottom:2%" value="'+reData[j].name+'">'+
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
                $('.fileimg').eq(i).attr('src',"../"+basePath+item);
            })

        }
    });
    return false;
}

//图片JSON
function imgArr(){
    var arr=[];
    $('.filename').each(function(){
        var objt ={
            "name":$(this).val(),
            "imgpath":$(this).attr('data-url')
        };
        arr.push(objt);
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
    return checkboxarr;
}

//编辑
    $('#edit').on('click',function(){
        var celledit = $(".cell_edit");
        console.log(celledit.length);

        celledit.each(function(){
            $(this).prop('disabled',false);
        })
        if($('#finish').hide()){
            $('#finish').show();
        }

    })

//编辑完成保存
    $('#finish').on('click',function(){
        var url = basePath+'/packingArchives/doModify';
        var data = {
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
            "suitableType": JSON.stringify(checkboxArr()),
            "imagePath":imgArr(),
            "associatedPackingId":Ids(),
            "bremarks": jQuery('#bRemarks').val(),
        }

        console.log(data);
        jQuery.ajax({
            type:"POST",
            url:url,
            dataType:"json",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(){
                alert("添加成功");
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
            var url = 'deleteRelation?id=' + id;
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
            var url = 'addRelation?id=' + id;
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


/*$('#testlogo').fileinput({
    uploadUrl: '/eim/upload/uploadFile.do',
    uploadAsync:true,
    showCaption: true,
    showUpload: true,//是否显示上传按钮
    showRemove: false,//是否显示删除按钮
    showCaption: true,//是否显示输入框
    showPreview:true,
    showCancel:true,
    dropZoneEnabled: false,
    maxFileCount: 10,
    initialPreviewShowDelete:true,
    msgFilesTooMany: "选择上传的文件数量 超过允许的最大数值！",
    initialPreview: previewJson,
    previewFileIcon: '<i class="fa fa-file"></i>',
    allowedPreviewTypes: ['image'],
    previewFileIconSettings: {
        'docx': '<i class="fa fa-file-word-o text-primary"></i>',
        'xlsx': '<i class="fa fa-file-excel-o text-success"></i>',
        'pptx': '<i class="fa fa-file-powerpoint-o text-danger"></i>',
        'pdf': '<i class="fa fa-file-pdf-o text-danger"></i>',
        'zip': '<i class="fa fa-file-archive-o text-muted"></i>',
        'sql': '<i class="fa fa-file-word-o text-primary"></i>',
    },
    initialPreviewConfig: preConfigList
}).off('filepreupload').on('filepreupload', function() {
// alert(data.url);
}).on("fileuploaded", function(event, outData) {
//文件上传成功后返回的数据， 此处我只保存返回文件的id
    var result = outData.response.id;
// 对应的input 赋值
    $('#htestlogo').val(result).change();
});*/

