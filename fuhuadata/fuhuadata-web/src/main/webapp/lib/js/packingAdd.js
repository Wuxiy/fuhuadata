/**
 * Created by young on 2017/3/6.
 */

    var id = $('#id').val();
    var img = $("input[name='file']");

    var addTbody = document.getElementById('add_tbody');

    //根据包材类型获取关联包材的展示
    var bid = $('#bid').val();
    console.log(bid);

    if(bid != 1){
        $('.relate').hide();
        $('.danhao').hide();
    }



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

    if (!(src == '' || src == basePath+'/lib/img/placeholder.png')) {

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
        url         : basePath + '/upload/uploadFileAll',
        type        : 'POST',
        data        : data,
        dataType: 'JSON',
        cache: false,
        processData: false,
        contentType: false,
        callback    :  function (data) {
            img.attr('src',data);
            input.attr('data-url',data);
            fileF.reset(); // 重置file的值
            monBtn.removeClass('hidden'); // 显示修改按钮
        }
    });
});

/*
function fsubmit(){
    var data = new FormData($('#form1')[0]);
    data.append("classifyPath","packingAchive");
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
                $('.fileimg').eq(i).attr('src',(basePath==""?("/"+basePath):basePath)+item);
            })
        }
    });
    return false;
}
*/

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

//新增关联
var cellcheckboxlists;//关联id数组
$('#addrelate').on('click',function(){
    if(id == ''||id == undefined){
        alert('请先保存基本信息！');
        return false;
    }
    var cellcheckbox = $('[name="cellcheckbox"]');
    var cellcheckboxlist = [];
    cellcheckbox.each(function(){
        cellcheckboxlist.push($(this).val());
    })
    cellcheckboxlists = cellcheckboxlist.join(',');

    $('#tree').creatTree(basePath + '/packingCategory/CategoryTree?parentIds=2,3');
    /*$('#tree').filtrateData(basePath + '/packingArchives/getPackingArchivesByPId',"modal_relate_table","packingInfoModal");*/
    jQuery.ajax({
        url:basePath + '/packingArchives/getPackingArchivesByPId',
        type:'POST',
        data:{id:0}
    }).done(packingInfoModalList);

    /**
     *packingInfoModalList
     */
    function packingInfoModalList(data){
        var ResultData = data.data;
        var tr;
        if(ResultData!=undefined){
            modalrelatetable.html('');
            jQuery.each(ResultData,function(n,item){
                if(contains(cellcheckboxlist,item.packingId) == true){
                    tr += '<tr data-categoryId="'+item.bigCategoryId+'" data-smallCategoryId="'+item.smallCategoryId+'"><td><input type="checkbox" value="'+item.packingId+'" data-categoryId="'+item.bigCategoryId+'" data-smallCategoryId="'+item.smallCategoryId+'" name="modal_cellcheckbox" checked/></td>';
                }else{
                    tr += '<tr data-categoryId="'+item.bigCategoryId+'" data-smallCategoryId="'+item.smallCategoryId+'"><td><input type="checkbox" value="'+item.packingId+'" data-categoryId="'+item.bigCategoryId+'" data-smallCategoryId="'+item.smallCategoryId+'" name="modal_cellcheckbox"/></td>';
                }
                tr += '<td>'+ifEmpty(item.packingId)+'</td><td>'+ifEmpty(item.packName)+'</td>';
                tr += '<td>'+ifEmpty(item.spec)+'</td><td>'+ifEmpty(item.size)+'</td>';
                tr += '<td>'+ifEmpty(item.quality)+'</td><td>'+ifEmpty(item.unitPrice)+'</td>';
                if((','+cellcheckboxlists+",").indexOf(item.packingId)>-1){
                    tr += '<td><input class="form-control" value="'+ifEmpty(item.associatedConsumption)+'" name="modal_consumption"></td>';
                }else{
                    tr += '<td><input class="form-control" value="'+ifEmpty(item.associatedConsumption)+'" name="modal_consumption" disabled></td>';
                }
                tr += '<td class="text-center"><input type="checkbox" name="modal_isEqualOuter" disabled/></td>';
                tr += '<td>'+(ifEmpty(item.status)==1?'启用':'禁用')+'</td></tr>';

            });
            $(tr).appendTo(modalrelatetable);
        }
    }

    $('#addField').modal('show');
})

$(document).on('click','li[id]>a',function(e){
    modalrelatetable.find('tr').hide();

    e.preventDefault();
    var a = $(e.target);
    var classid = a.parent('li').attr('id');
    if(classid == 2||classid == 3){
        modalrelatetable.find('tr[data-categoryId="'+classid+'"]').show();
    }else{
        modalrelatetable.find('tr[data-smallCategoryId="'+classid+'"]').show();
    }

})

//确认数组
function contains(arr, obj) {
    var i = arr.length;
    while (i--) {
        if (arr[i] == obj.toString()) {
            return true;
        }
    }
    return false;
}

//互斥处理
$(document).on('change','[name="modal_cellcheckbox"]',function(){
    if($(this).attr('checked')){
        $(this).parents('tr').find('td').eq(7).find('input[name="modal_consumption"]').attr('disabled',false);
        $(this).parents('tr').find('td').eq(8).find('input[name="modal_isEqualOuter"]').attr('disabled',false);
    }else{
        $(this).parents('tr').find('td').eq(7).find('input[name="modal_consumption"]').attr('disabled',true);
        $(this).parents('tr').find('td').eq(8).find('input[name="modal_isEqualOuter"]').attr('disabled',true);
        $(this).parents('tr').find('td').eq(8).find('input[name="modal_isEqualOuter"]').attr('checked',false);
    }
})
$(document).on('change','[name="modal_isEqualOuter"]',function(){
    if($(this).attr('checked')){
        $(this).parents('tr').find('td').eq(7).find('input[name="modal_consumption"]').attr('disabled',true);
        $(this).parents('tr').find('td').eq(7).find('input[name="modal_consumption"]').val('');
    }else{
        $(this).parents('tr').find('td').eq(7).find('input[name="modal_consumption"]').attr('disabled',false);
    }
})

//新增添加关联完成
$('#add_relate').on('click',function(){
    var ids = new Array();
    $("input[name='modal_cellcheckbox']:checked").each(function(){
        ids.push($(this).val());
    })

    if(ids.length > 0){
        var msg = "确认要为主材添加这些关联吗？";
        if(confirm(msg)){
            var url = basePath + '/packingArchives/addRelation?id=' + id;
            var data = ids;
            console.log(ids);
            jQuery.ajax({
                url:url,
                type:'POST',
                dataType:"json",
                contentType:"application/json",
                data:getdata(),
                success:function(){
                    alert("添加关联成功！");
                    $('#addField').modal('hide');

                    $('.imagesbtn').hide();
                    jQuery.ajax({
                        type:'GET',
                        url:basePath+'/packingArchives/getPackingArchivesById?id='+id,
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
                                var table_html = '';
                                table.html('');
                                for(var i=0;i<node.length;i++){
                                    table_html += '<tr><td class="text-center"><input type="checkbox" name="cellcheckbox" value="'+node[i].packingId+'" /></td>';
                                    table_html += '<td class="col-xs-1 text-center text-middle">'+ifEmpty(node[i].packingId)+'</td>';
                                    table_html += '<td class="col-xs-2 text-center text-middle">'+ifEmpty(node[i].packName)+'</td>';
                                    table_html += '<td class="col-xs-1 text-center text-middle">'+ifEmpty(node[i].spec)+'</td>';
                                    table_html += '<td class="col-xs-1 text-center text-middle">'+ifEmpty(node[i].size)+'</td>';
                                    table_html += '<td class="col-xs-2 text-center text-middle">'+ifEmpty(node[i].quality)+'</td>';
                                    table_html += '<td class="col-xs-1 text-center text-middle">'+ifEmpty(node[i].unitPrice)+'</td>';
                                    table_html += '<td class="col-xs-1 text-center text-middle">'+ifEmpty(node[i].consumption)+'</td>';
                                    table_html += '<td class="text-center"><input type="checkbox" name="isEqualOuter"/></td>';
                                    table_html += '<td class="col-xs-1 text-center text-middle">'+ifEmpty(node[i].status)+'</td></tr>';

                                }
                                $(table_html).appendTo(table);
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
                    });
                    $('a[href="#Packrelate"]').tab('show');
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
    jQuery.ajax({
        type:"POST",
        url:url,
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(data),
        success:function(){
            alert("添加成功");
            window.location.href = basePath + '/packingArchives/packingArchivesList';
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

function ifEmpty(data) {
    return data==undefined?'':data;
}






