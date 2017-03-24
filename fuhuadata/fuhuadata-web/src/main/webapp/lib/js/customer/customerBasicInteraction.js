/**
 * Created by huxiangyang on 2017/3/13.
 */

$(function () {

    //获取初始数据
    getData(basePath+'/customerBaseInfo/showCustomerBaseInfoDetails','POST',GetRequest(),customerBasicInfo);
    //添加产品
    $(document).on('click.add','#addPro',function () {
        var row = '';
        row += '<div name="customerMakeProduct" class="form-group" style="position:relative;">';
        row += '<label class="col-xs-1 control-label" style="position: relative">生产产品</label>';
        row += '<div class="col-xs-2"><input name="productName" class="form-control" type="text" value=""></div>';
        row += '<label class="col-xs-1  control-label">产能</label>';
        row += '<div class="col-xs-2"><input name="production" class="form-control" type="text" value=""></div>';
        row += '</div>';
        $('#addPro').parents('.form-group').before(row);
        delDelBtn();
        addDelBtn('customerMakeProduct','form-group');
        $('[name="customerMakeProduct"]').eq(0).find('button').remove();
    });

    //选择其他选项，切换显示
    $(document).on('change.view','[name="enterpriseNature"]',function () {
        var thisEl = $('input').filter('.else[name="enterpriseNature"]');
        var isSelected = thisEl.prop('checked');
        var tarEl = $(thisEl.data('target'));
        if(isSelected){
            tarEl.removeClass('hidden');
        }else {
            tarEl.addClass('hidden');
        }
    });
    //潜在客户额外显示的数据
    viewElseInput('#customerType',2);
    viewElseInput('#opportunitySource',6);
    function viewElseInput(id,selectedVal) {
        $(document).on('change.view',id,function () {
            var thisEl = $(this);
            var isSelected = thisEl.val();
            var tarEl = $(thisEl.data('target'));
            if(isSelected==selectedVal){
                tarEl.removeClass('hidden');
            }else {
                tarEl.addClass('hidden');
            }
        });
    }


    //编辑客户基本信息
    $(document).on('click.edit','editCustomerBasic',function () {
        //生产产品重排序
        addDelBtn('customerMakeProduct','form-group');
    });
    //客户基本信息提交
    $(document).on('click.up','#saveCustomerBasic',function(){
        //提交数据
        upData(basePath+'/customerBaseInfo/updateCustomerBaseInfo','POST',customerBasicFormObj(),"application/json");
        delDelBtn();
    });
    //客户基本信息取消提交
    $(document).on('click.cancel','#cancelCustomerBasic',function(){
        //重新获取数据
        getData(basePath+'/customerBaseInfo/showCustomerBaseInfoDetails','POST',GetRequest(),customerBasicInfo);
    });
    $(document).on('click.edit','#editEncyclopedia',function () {
        //添加删除按钮
        addDelBtn('customField','form-group');
    });
    $(document).on('click.create','#addFiled',function () {
       var container = $('#filedContainer');
       container.html('');
       var form = '';
       form += '<div class="form-horizontal">';
       form += '<div class="form-group">';
       form += '<label for="" class="control-label col-xs-2">名称</label>';
       form += '<div class="col-xs-4">';
       form += '<input type="text" class="form-control" value=""></div></div>';
       form += '<div class="form-group">';
       form += '<label for="" class="control-label col-xs-2">内容</label>';
       form += '<div class="col-xs-9">';
       form += '<textarea class="form-control" name="" rows="8" value=""></textarea></div></div>';
       form += '</div>';
       container.append(form);
    });
    $(document).on('click.append','#up_cf',function () {
        var place = $('#addFiled').parents('.form-group');
        var container = $('#filedContainer');
        var name = $('input',container).val();
        var content = $('textarea',container).val();
        var row = '';
        row += '<div name="customField" class="form-group">';
        row += '<label name="name" class="control-label col-xs-1" lang="zh">'+ name +'</label>';
        row += '<div class="col-xs-8"><textarea name="value" class="form-control" rows="4">'+ content +'</textarea>';
        row += '</div>';
        place.before(row);
        delDelBtn();
        addDelBtn('customField','form-group');
    });
    $(document).on('click.up','#addEncyclopedia',function(){
        //提交数据
        upData(basePath+'/customerEncyclopedia/doModify','POST',customerEncyclopediaObj(),"application/json");
        delDelBtn();
    });

});

/**
 * 删除按钮的添加和删除
 */
// function reorderPro(){
//     $('[name="customerMakeProduct"]').find('label:first-child').html(function (n,old) {
//         if(n!=0){
//             return '<button type="button" class="close" data-form-btn="del" data-form-target="form-group" style="position: absolute;top: 3px;left: 24px;">×</button>生产产品' + parseInt(n+1);
//         }
//     });
// }
function addDelBtn(name,tar) {
    var delBtn = '<button type="button" class="close" data-form-btn="del" data-form-target="'+tar+'" style="position:absolute;top:3px;left:25px;z-index:100;">×</button>';
    $('[name="'+name+'"]').css('position','relative').prepend(delBtn);
}
function delDelBtn() {
    $('button').filter('[data-form-btn="del"]').remove();
}