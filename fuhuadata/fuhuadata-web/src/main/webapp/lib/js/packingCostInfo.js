/**
 * Created by young on 2017/3/7.
 */

    $('#finish').hide();
    //分割url，获取上个页面传过来的id
    var thisURL = document.URL;
    var trans = thisURL.split('?')[1];
    var trans2 = trans.split('&')[0];
    var id = trans2.split('=')[1];
    var bid = trans.split('=')[2];
    var table = document.getElementById('packing_relate_table');

    var checkboxarr = '';
    var imgpath;
    var Ids = new Array();

    if(bid != 1){
        $('.relate').hide();
    }

    var url = '/packingArchives/getPackingArchivesById?id='+id;
    jQuery.ajax({
    	type:'GET',
    	url:url,
    	success:function(result){
    		var ResultData = result.data;
    		var node = ResultData.nodes;

            var arr = [ResultData.pack.suitableType];
            $('#packName').val(ResultData.pack.packName);
            $('#spec').val(ResultData.pack.spec);
            $('#size').val(ResultData.pack.size);
            $('#quality').val(ResultData.pack.quality);
            $('#qualityIndex').val(ResultData.pack.qualityIndex);
            $('#qualityTargetValue').val(ResultData.pack.qualityTargetValue);
            $('#unitPrice').val(ResultData.pack.unitPrice);
            $('#consumption').val(ResultData.pack.consumption);
            $('#priceEndDate').val(ResultData.pack.priceEndDate);
            $('#status').val(ResultData.pack.status);
            $('#bRemarks').val(ResultData.pack.bRemarks);
            $('.suitableType').val(arr);

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
    })


//图片上传

$("#file").fileinput({
    language: 'zh', //设置语言
    uploadUrl: '/upload/uploadFile', // you must set a valid URL here else you will get an error
    allowedFileExtensions : ['jpg', 'png','gif'],
    overwriteInitial: false,
    maxFileSize: 1000,
    maxFilesNum: 10,
    maxImageWidth: 280,//图片的最大宽度
    maxImageHeight: 280,//图片的最大高度
    //allowedFileTypes: ['image', 'video', 'flash'],
    enctype: 'multipart/form-data',
    slugCallback: function(filename) {
        return filename.replace('(', '_').replace(']', '_');
    }
}).on("filebatchselected", function(event, file) {
    console.log('233');

}).on("fileuploaded", function(event, data) {
    console.log('233');
    if(data.response)
    {
        alert('处理成功');
    }
    imgpath = data.response.data;
});

//适用产品类型checkbox
$("input[name='check']").each(function(index,element){
    checkboxarr += $(this).val() + ",";
})

//关联数组Ids
$("input[name='cellcheckbox']").each(function(){
    Ids.push($(this).val());
});

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
        var url = 'packingArchives/doModify';
        var data = {
            "packName": jQuery('#packName').val(),
            "spec": jQuery('#spec').val(),
            "size": jQuery('#size').val(),
            "quality": jQuery('#quality').val(),
            "qualityIndex": jQuery('#qualityIndex').val(),
            "qualityTargetValue": jQuery('#exhibitionName').val(),
            "unitPrice": jQuery('#unitPrice').val(),
            "consumption": jQuery('#consumption').val(),
            "priceEndDate": jQuery('#priceEndDate').val(),
            "status": jQuery('#status').val(),
            "suitableType": "1",
            "bremarks": jQuery('#bremarks').val(),
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
    console.log(ids);

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
    console.log(ids);

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

