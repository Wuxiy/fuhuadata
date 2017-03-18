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
        var objt ={
            "name":$(this).val(),
            "imgpath":$(this).attr('data-url')
        };
        arr.push(objt);
    })
    return JSON.stringify(arr);
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
    var url = basePath+'/packingArchives/doAddPackingArchives';
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
        "suitableType": JSON.stringify(checkboxArr()),
        "imagePath":imgArr(),
        "associatedPackingId":JSON.stringify(ids),
        "bRemarks": jQuery('#bremarks').val(),
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


