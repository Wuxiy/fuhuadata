/**
 * Created by young on 2017/3/6.
 */

$(document).ready(function(){

    var btn = '';
    if(a){
        btn = '<a class="btn btn-xs btn-primary pull-right panel-heading-btn packingAdd" href="">完成</a>';
    }else{
        btn = '<a class="btn btn-xs btn-primary pull-right panel-heading-btn" href="">编辑</a>'
    }
    return btn;
    $('#btn').append(btn);

    $(".file").fileinput({
        uploadUrl: '#', // you must set a valid URL here else you will get an error
        allowedFileExtensions : ['jpg', 'png','gif'],
        overwriteInitial: false,
        showPreview : true, //是否显示预览
        maxFileSize: 1000,
        maxFilesNum: 10,
        maxImageWidth: 280,//图片的最大宽度
        maxImageHeight: 280,//图片的最大高度
        //allowedFileTypes: ['image', 'video', 'flash'],
        slugCallback: function(filename) {
            return filename.replace('(', '_').replace(']', '_');
        }
    });

    $('.packingAdd').on('click',function(){
        var url = "/packingArchives/addPackingArchives"
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
})



