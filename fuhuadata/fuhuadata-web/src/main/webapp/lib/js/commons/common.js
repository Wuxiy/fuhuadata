/**
 * Created by huxiangyang on 2017/3/13.
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
$(document).on('change.view',saltType,radioChecked);

// $('.else:checked').parents('.form-group').find('.elseInput').show();
// $('.else:not(:checked)').parents('.form-group').find('.elseInput').hide();
/**
 *checkbox其他选项
 */
function radioChecked(e){
    var radioGroup = $('[name="'+e.attr("name")+'"]');
    var elseSelected = radioGroup.filter('.else');
    var targetEl = e.parents('.form-group').find('.elseInput');
    console.log(elseSelected.prop('checked'));
    if(elseSelected.prop('checked')){

        targetEl.removeClass('hidden');
    }else{
        targetEl.addClass('hidden');
    }
}

/**
 *selected其他选项
 */
// function selectElse(e){
//     var el = $(e.target);
//     var elseSelected = el.find('.else');
//     var targetEl = el.parents('.form-group').find('.elseInput');
//     if(elseSelected.prop('selected')){
//         targetEl.removeClass('hidden');
//     }else{
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

/**
 * 删除
 */
function delEl(e){
    var el = $(e.target);
    var tar = el.data('form-target');//取得data-form-target属性值
    var tarEl = el.parents('.'+tar)[0]||el.parents(tar)[0];//删除class等于该属性值的第一个祖先元素
    $(tarEl).remove();
}

/**
 * 取得url中的参数
 */
function GetRequest() {
    //url例子：XXX.aspx?ID=" + ID + "&Name=" + Name；
    var url = location.search; //获取url中"?"符以及其后的字串
    var theRequest = new Object();
    if(url.indexOf("?") != -1)//url中存在问号，也就说有参数。
    {
        var str = url.substr(1);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = decodeURIComponent(strs[i].split("=")[1]);
        }
    }
    console.log(theRequest);
    return theRequest;
}

/**
 * 多modal处理
 */

// 通过该方法来为每次弹出的模态框设置最新的zIndex值，从而使最新的modal显示在最前面
$(document).on('show.bs.modal', '.modal', function (e) {
    var zIndex = 1040 + (10 * $('.modal:visible').length);
    $(this).css('z-index', zIndex);
});