/**
 * Created by young on 2017/3/6.
 */

$(function () {
    var thisURL = document.URL;
    var ni = thisURL.split('?')[1];
    var names = ni.split('&')[0];
    var bids = ni.split('&')[1];
    var name = decodeURI(names.split('=')[1]);
    var bid = bids.split('=')[1];
    var names = document.getElementById('packName');
    names.value = name;

    if(bid != 1){
        $('.relate').hide();
    }

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
});

$("img[class='file-preview-image']").each(function(){
    var url = $(this).attr('src');
    console.log(url);
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


