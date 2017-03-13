/**
 * Created by young on 2017/3/6.
 */

    var thisURL = document.URL;
    var ni = thisURL.split('?')[1];
    var names = ni.split('&')[0];
    var bids = ni.split('&')[1];
    var sids = ni.split('&')[2];
    var name = decodeURI(names.split('=')[1]);
    var bid = bids.split('=')[1];
    var sid = sids.split('=')[1];
    console.log(sid);
    var names = document.getElementById('packName');
    names.value = name;

    var img = $("input[name='file']");
    var imgnames =$("input[name='imagname']");

    var obj1 = {},obj2 = {},obj3 = {};
    var arr = [];
    var ids = new Array();


    //根据包材类型获取关联包材的展示
    if(bid != 1){
        $('.relate').hide();
    }



//图片上传

/*function imag(){
    img.each(function(){
        $("input[name='file']").fileinput({
            language: 'zh', //设置语言
            uploadUrl: '/upload/uploadFile', // you must set a valid URL here else you will get an error
            allowedFileExtensions : ['jpg', 'png','gif'],
            overwriteInitial: false,
            maxFileSize: 1000,
            maxFilesNum: 10,
            maxImageWidth: 100,//图片的最大宽度
            maxImageHeight: 100,//图片的最大高度
            //allowedFileTypes: ['image', 'video', 'flash'],
            enctype: 'multipart/form-data',
            slugCallback: function(filename) {
                console.log(filename);

                return filename.replace('(', '_').replace(']', '_');
            }
        }).on("filebatchselected", function(event, file) {
            console.log('233');

        }).on("fileuploaded", function(event, data) {

            if(data.response)
            {
                alert('处理成功');
            }
            obj.path = data.response.data;
            imgnames.each(function(){
               obj.name = $(this).val();
            });
            arr.push(obj);
            console.log(arr);
        });
    })

}*/

$("input[id='file-1']").fileinput({
    language: 'zh', //设置语言
    uploadUrl: '/upload/uploadFile', // you must set a valid URL here else you will get an error
    allowedFileExtensions : ['jpg', 'png','gif'],
    overwriteInitial: false,
    maxFileSize: 1000,
    maxFilesNum: 10,
    maxImageWidth: 100,//图片的最大宽度
    maxImageHeight: 100,//图片的最大高度
    //allowedFileTypes: ['image', 'video', 'flash'],
    enctype: 'multipart/form-data',
    slugCallback: function(filename) {
        console.log(filename);
        $('#imagname1').val(filename);
        return filename.replace('(', '_').replace(']', '_');
    }
}).on("filebatchselected", function(event, file) {
    console.log('233');

}).on("fileuploaded", function(event, data) {

        if(data.response)
        {
            alert('处理成功');
        }
        obj1.path = data.response.data;
        obj1.name = $('#imagname1').val();
        arr.push(obj1);
        console.log(arr);
    });

$("input[id='file-2']").fileinput({
    language: 'zh', //设置语言
    uploadUrl: '/upload/uploadFile', // you must set a valid URL here else you will get an error
    allowedFileExtensions : ['jpg', 'png','gif'],
    overwriteInitial: false,
    maxFileSize: 1000,
    maxFilesNum: 10,
    maxImageWidth: 100,//图片的最大宽度
    maxImageHeight: 100,//图片的最大高度
    //allowedFileTypes: ['image', 'video', 'flash'],
    enctype: 'multipart/form-data',
    slugCallback: function(filename) {
        console.log(filename);
        $('#imagname2').val(filename);
        return filename.replace('(', '_').replace(']', '_');
    }
}).on("filebatchselected", function(event, file) {
    console.log('233');

}).on("fileuploaded", function(event, data) {

    if(data.response)
    {
        alert('处理成功');
    }
    obj2.path = data.response.data;
    obj2.name = $('#imagname2').val();
    arr.push(obj2);
    console.log(arr);
});

$("input[id='file-3']").fileinput({
    language: 'zh', //设置语言
    uploadUrl: '/upload/uploadFile', // you must set a valid URL here else you will get an error
    allowedFileExtensions : ['jpg', 'png','gif'],
    overwriteInitial: false,
    maxFileSize: 1000,
    maxFilesNum: 10,
    maxImageWidth: 100,//图片的最大宽度
    maxImageHeight: 100,//图片的最大高度
    //allowedFileTypes: ['image', 'video', 'flash'],
    enctype: 'multipart/form-data',
    slugCallback: function(filename) {
        console.log(filename);
        $('#imagname3').val(filename);
        return filename.replace('(', '_').replace(']', '_');
    }
}).on("filebatchselected", function(event, file) {
    console.log('233');

}).on("fileuploaded", function(event, data) {

    if(data.response)
    {
        alert('处理成功');
    }
    obj3.path = data.response.data;
    obj3.name = $('#imagname3').val();
    arr.push(obj3);
});

//适用产品类型checkbox

function checkboxArr() {
    var checkboxarr = [];
    var a;
    $("input[name='check']:checked").each(function(){
        a =  $(this).val();
        checkboxarr.push(a);
    })
    JSON.stringify(checkboxarr);
    return checkboxarr;
}

//新增添加关联
$('#add_relate').on('click',function(){
    $("input[name='modal_cellcheckbox']:checked").each(function(){
        ids.push($(this).val());
    });

    if(ids.length > 0){
        var msg = "确认要为主材添加这些关联吗？";
        if(msg){
            var url = '';
            var data = ids;
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

//新增完成
$('.packingAdd').on('click',function(){
    var url = "/packingArchives/doAddPackingArchives"
    var data = {
        "bigCategoryId":bid,
        "smallCategoryId":sid,
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
        "suitableType": checkboxArr(),
        "image":JSON.stringify(arr),
        "ids":JSON.stringify(ids),
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


$('.update').hover(function(){

})


