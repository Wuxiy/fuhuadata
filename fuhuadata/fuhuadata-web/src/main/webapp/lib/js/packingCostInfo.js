/**
 * Created by young on 2017/3/7.
 */

    var id = $('#id').val();
    var bid = $('#bid').val();
    var sid = $('#sid').val();

    var table = document.getElementById('packing_relate_table');
    var imgGroup = document.getElementById('imgGroup');


    if(bid != 1){
        $('.relate').hide();
    }

$(document).ready(function(){
    $('.imagesbtn').hide();
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
                $('#packName').val(ifEmpty(pack.packName));
                $('#spec').val(ifEmpty(pack.spec));
                $('#size').val(ifEmpty(pack.size));
                $('#quality').val(ifEmpty(pack.quality));
                $('#qualityIndex').val(ifEmpty(pack.qualityIndex));
                $('#qualityTargetValue').val(ifEmpty(pack.qualityTargetValue));
                $('#unitPrice').val(ifEmpty(pack.unitPrice));
                $('#consumption').val(ifEmpty(pack.consumption));
                $('#priceEndDate').val(ifEmpty(pack.priceEndDate));
                $('#status').val(ifEmpty(pack.status));
                $('#bRemarks').val(ifEmpty(pack.bRemarks));

                $('#packpackingId').text(ifEmpty(pack.packingId));
                $('#packpackName').text(ifEmpty(pack.packName));
                $('#packspec').text(ifEmpty(pack.spec));
                $('#packsize').text(ifEmpty(pack.size));
                $('#packquality').text(ifEmpty(pack.quality));
                $('#packunitPrice').text(ifEmpty(pack.unitPrice));
                $('#packconsumption').text(ifEmpty(pack.consumption));
                $('#packstatus').text(ifEmpty(pack.status));
            }

            if(ResultData.nodes){
                var node = ResultData.nodes;
                for(var i=0;i<node.length;i++){
                    table.innerHTML += '<tr>'+
                        '<td class="text-center"><input type="checkbox" name="cellcheckbox" value="'+node[i].packingId+'" /></td>'+
                        '<td class="col-xs-2 text-center text-middle">'+ifEmpty(node[i].packingId)+'</td>'+
                        '<td class="col-xs-2 text-center text-middle">'+ifEmpty(node[i].packName)+'</td>'+
                        '<td class="col-xs-1 text-center text-middle">'+ifEmpty(node[i].spec)+'</td>'+
                        '<td class="col-xs-1 text-center text-middle">'+ifEmpty(node[i].size)+'</td>'+
                        '<td class="col-xs-2 text-center text-middle">'+ifEmpty(node[i].quality)+'</td>'+
                        '<td class="col-xs-1 text-center text-middle">'+ifEmpty(node[i].unitPrice)+'</td>'+
                        '<td class="col-xs-1 text-center text-middle">'+ifEmpty(node[i].consumption)+'</td>'+
                        '<td class="col-xs-1 text-center text-middle">'+ifEmpty(node[i].status)+'</td>'
                    '</tr>';
                }
            }

            if(ResultData.imagePath){
                var reData = eval(ResultData.imagePath);
                console.log(reData);
                for(var j=0;j<reData.length;j++){
                    imgGroup.innerHTML += '<div class="col-xs-3">'+
                        '<button type="button" class="close" name="close" style="position: absolute;top:3px;left:0;" disabled>×</button>'+
                        '<div class="col-xs-12 thumbnail">'+
                        '<img style="height: 240px;" data-toggle="modal" data-target="#imgModal" data-name="" src="'+basePath + reData[j].path+'" alt="请点击添加图片" class="imgpath">'+
                        '<div class="input-group col-xs-10 col-xs-offset-1" style="padding-top: 5px">'+
                        '<input class="form-control text-center filename" data-url="'+reData[j].path+'" style="" value="'+reData[j].name+'" disabled/>'+
                        '<div class="input-group-btn"><button data-btn="modification" class="btn btn-xs btn-default modifyimg" type="button" disabled>图片修改</button></div>'+
                        '</div>'+
                        '</div>'+
                        '</div>';
                }
            }

        }
    })
})

//图片上传

var thisThumbnail = null;

// 点击图片添加或者查看大图
$('#imgGroup').on('click.select','img',function (e) {

    // 阻止默认行为
    e.preventDefault();

    var el       = $(e.target).parents('.thumbnail').length!==0 ? $(e.target).parents('.thumbnail') : $(e.target),
        file     = $('#openFile'),
        imgModal = $('#imgModal'),
        img      = $(e.target),
        src      = img.attr('src');

    thisThumbnail = el; // 取得当前缩略图框

    if (!(src == '' || src == '/lib/img/placeholder.png')) {

        imgModal.find('img').attr('src',src); // 打开模态
    }else {

        e.stopPropagation(); // 阻止打开模态
        file.trigger('click'); // 打开file
    }
});

// monBtn绑定事件
$('#imgGroup').on('click.mon','[data-btn="modification"]',function (e) {
    e.stopPropagation();
    var el   = $(e.target).parents('.thumbnail').length!==0 ? $(e.target).parents('.thumbnail') : $(e.target),
        file = $('#openFile');
    thisThumbnail = el; //取得当前缩略图框
    file.trigger('click'); // 打开file
});

// file绑定change事件
$('#openFile').on('change.file',function (e) {
//            console.log(thisThumbnail);
    var img    = thisThumbnail.find('img'),
        input  = thisThumbnail.find('input'),
        fileF  = $('#fileForm')[0], // 转化为DOM对象
        monBtn = thisThumbnail.find('[data-btn="modification"]'),
        data   = new FormData(fileF);
    data.append("classifyPath","packingAchive");

    console.log(data);
    CRM.ajaxCall({
        url         : '/upload/uploadFileAll',
        type        : 'POST',
        data        : data,
        dataType: 'JSON',
        cache: false,
        processData: false,
        contentType: false,
        callback    :  function (data) {
            img.attr('src',(basePath==""?("/"+basePath):basePath)+data);
            input.attr('data-url',(basePath==""?("/"+basePath):basePath)+data);
            fileF.reset(); // 重置file的值
            monBtn.removeClass('hidden'); // 显示修改按钮
        }
    });
});

/*function fsubmit(){
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
}*/

//图片JSON
function imgArr(){
    var arr=[];
    $('.filename').each(function(){
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
    $('[name="close"]').attr('disabled',false);
    $('.modifyimg').attr('disabled',false);
    $('.imagesbtn').show();
});
//baocai信息取消提交
$(document).on('click.cancel','#cancel',function(){
});

//编辑完成保存
    $('#finish').on('click',function(){

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

        var url = basePath+'/packingArchives/doModify';
        var data = {
            "packingId":jQuery('#id').val(),
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
            var url = basePath + '/packingArchives/deleteRelation?id=' + id;
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
            var url = basePath + '/packingArchives/addRelation?id=' + id;
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

                }
            })
        }
    }else{
        alert('还未选择要添加的关联');
    }
})

function ifEmpty(data) {
    return data==undefined?'':data;
}







