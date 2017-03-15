/**
 * Created by Think on 2017/3/13.
 */

//定义全局变量
var editBtn = '[data-form-btn="edit"]';
var saveBtn = '[data-form-btn="save"]';
var cancelBtn = '[data-form-btn="cancel"]';
var delBtn = '[data-form-btn="del"]';
var saltType = '[name="saltType"]';


//初始化
init();
//启用功能按钮
$(document).on('click.edit',editBtn,saveEdit);
$(document).on('click.save',saveBtn,saveEdit);
$(document).on('click.cancel',cancelBtn,saveEdit);
$(document).on('click.del',delBtn,delEl);

//单选按钮的其他选项
function radioChecked(e){
    var el = $(e.target);
    var radioGroup = $('[name="'+el.attr("name")+'"]');
    var elseSelected = radioGroup.filter('.else');
    var targetEl = el.parents('.form-group').find('.elseInput');
    if(elseSelected.prop('checked')){
        console.log(el.prop('checked'));
        targetEl.removeClass('hidden');
    }else{
        targetEl.addClass('hidden');
    }
}
// function radioChecked(e){
//     var el = $(e.target);
//     var radioGroup = $('[name="'+el.attr("name")+'"]');
//     var val = radioGroup.filter('.else').val();
//     var selectedVal = radioGroup.filter(':checked');
//     var targetEl = el.parents('.form-group').find('.elseInput');
//     if(selectedVal.val()==val){
//         console.log(el.prop('checked'));
//         targetEl.removeClass('hidden');
//     }else if(selectedVal.val()!=val){
//         targetEl.addClass('hidden');
//     }
// }


/**
 * 初始化
 */
function init(){
    var formEl=$('.panel-edit .form-control, .panel-edit input[type="checkbox"], .panel-edit input[type="radio"]');//表单控件
    var formBtn=$('.panel-edit .panel-body [data-form-btn]');//操作按钮
    formEl.attr('disabled','disabled');//表单控件禁用
    formBtn.addClass('hidden');//操作按钮隐藏
}

/**
 *input通用渲染
 */
function rendererData(result){
    //循环数据取值，并将值赋给有相同name的标签
    var data = result;
}

/**
 *编辑&保存&删除
 */
function saveEdit(e){
    var el = $(e.target);
    var pBody = el.parents('.panel').find('.panel-body');
    var pHeader = el.parents('.panel').find('.panel-heading');
    var formEl = pBody.find('input,.form-control').not('.noEdit');//编辑的标签
    var formBtn = pBody.find('[data-form-btn]');//操作按钮
    var editHide = pBody.find('.editHide');//编辑状态需要隐藏的标签
    var editView = pBody.find('.editView');//编辑状态需要显示的标签
    var saveBtnGroup = pHeader.find('[data-form-btn="save"]').parent('.btn-group');//当前保存&取消按钮组
    var edit = pHeader.find('[data-form-btn="edit"]');//当前编辑按钮
    var panelTree = $('#tree').parents('.panel');

    if(el.data('form-btn')=="edit"){//编辑按钮执行的操作
        formBtn.add(editView).add(saveBtnGroup).removeClass('hidden');
        el.add(editHide).addClass('hidden');
        formEl.removeAttr('disabled');
        panelTree.fadeOut();
    }else if(el.data('form-btn')=="save"||el.data('form-btn')=="cancel"){//保存&取消按钮执行操作
        formBtn.add(editView).add(saveBtnGroup).addClass('hidden');
        edit.add(editHide).removeClass('hidden');
        formEl.attr('disabled','disabled');
        panelTree.fadeIn();
    }
}

// function addEl(e){
//     var el = $(e.target);
//     elName= el.data('form-target');
//     el = $('[data-name="'+elName+'"]').slice(0,1);
//     pl = $('[data-place="'+elName+'"]');
//     //添加不同元素的特殊处理
//     var newEl,formTar,delBtn;
//     delBtn= $('<button type="button" class="close" data-form-btn="del">&times;</button>').css('fontSize','24px');
//     newEl = el.clone().removeAttr('data-name');
//     var addFromGroup = function(){
//         formTar = 'form-group';
//         delBtn.data('form-target',formTar);
//         newEl.find('input').val('');
//         newEl.append('<div class="pull-left"></div>').find('.pull-left').append(delBtn);
//         pl.before(newEl);
//     }
//     var addTr = function(){
//         formTar = 'tr';
//         delBtn.css({
//             'position':'absolute',
//             'right':'-25px',
//             'top':'3px'
//         }).data('form-target',formTar);
//         newEl.find('input').val('');
//         newEl.find('td').last().css('position','relative').append(delBtn);
//         pl.before(newEl);
//     }
//     var addTbody = function(){
//         var count = 0;
//         count++;
//         formTar = 'tbody';
//         delBtn.css({
//             'position':'absolute',
//             'left':'-25px'
//         }).data('form-target',formTar);
//         newEl.find('tr').slice(2,-1).remove().find('input').val('');
//         var newBtn = newEl.find('[data-form-target]').data('form-target')+count;
//         console.log(newBtn);
//         newEl.find('tr').first().find('th').first().css('position','relative').append(delBtn);
//         newEl.find('[data-name]').attr('data-name',newBtn);
//         newEl.find('[data-place]').attr('data-place',newBtn);
//         newEl.find('[data-form-target]').attr('data-form-target',newBtn);
//         pl.before(newEl);
//     }
//     if(el.is('.form-group')){
//         addFromGroup();
//     }else if(el.is('tr')){
//         addTr();
//     }else if(el.is('tbody')){
//         addTbody();
//     }
//
// }

/**
 * 删除
 */
function delEl(e){
    var el = $(e.target);
    var tar = el.data('form-target');//取得data-form-target属性值
    var tarEl = el.parents('.'+tar)[0]||el.parents(tar)[0];//删除class等于该属性值的第一个祖先元素
    $(tarEl).remove();
}

    //渲染标准产品档案列表
    // function productInfo (data) {
    //     var getData = data.data;
    //     jQuery.each(getData,function(n,total){
    //         jQuery.each(total,function(key,item){
    //             var $formControl=$('[name="'+ key +'"]');
    //             if($formControl.attr('type')=='radio'||$formControl.attr('type')=='checkbox'){
    //                 var arr=[item];
    //                 $formControl.val(arr);
    //             }else{
    //                 $formControl.val(item);
    //             }
    //         })
    //     });
    //     jQuery.each(getData.productInfo,function(key,item){
    //         console.log(item);
    //         var formControl=$('[name="'+ key +'"]');
    //         if(formControl.attr('type')=='radio'||formControl.attr('type')=='checkbox'){
    //             var arr=[item];
    //             formControl.val(arr);
    //         }else {
    //             formControl.val(item);
    //         }
    //     });
    //     var wTbody = $('[name="wares"]');
    //     wTbody.html('');
    //     jQuery.each(getData.wares,function(key,item){
    //         var tr = $("<tr></tr>");
    //         tr.append('<td>'+item.specification+'</td><td>'+item.model+'</td>').appendTo(wTbody);
    //     });
    //     var iTbody = $('[name="physicalProperities"]');
    //     iTbody.html('');
    //     jQuery.each(getData.index,function(key,item){
    //         var tr = $("<tr></tr>");
    //         tr.append('<td><input class="form-control" type="text" disabled value="'+item.index+'"></td><td><input class="form-control" type="text" disabled value="'+item.value+'"></td><td><input class="form-control" type="text" disabled value="'+item.remarks+'"/></td>').appendTo(iTbody);
    //     });
    // }