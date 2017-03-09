/**
 * Created by young on 2017/3/6.
 */

    var thisURL = document.URL;
    var ni = thisURL.split('?')[1];
    var names = ni.split('&')[0];
    var bids = ni.split('&')[1];
    var name = decodeURI(names.split('=')[1]);
    var bid = bids.split('=')[1];
    var names = document.getElementById('packName');
    names.value = name;


    var checkboxarr = '';
    var imgpath;
    var ids = new Array();

    //根据包材类型获取关联包材的展示
    if(bid != 1){
        $('.relate').hide();
    }



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

$("input[name='check']").each(function(index,element){
    checkboxarr += $(this).val() + ",";
})

$('#add_relate').on('click',function(){
    $("input[name='modal_cellcheckbox']:checked").each(function(){
        ids.push($(this).val());
    });
    $('#addField').modal('hide');
})

$('.packingAdd').on('click',function(){
    var url = "/packingArchives/addPackingArchives"
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
        "suitableType": checkboxarr,
        "imgpath":imgpath,
        "ids":ids,
        "bremarks": jQuery('#bremarks').val(),
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


