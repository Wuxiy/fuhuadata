/**
 * Created by Huxiangyang on 2017/4/6.
 */

// 自定义全局对象
var CRM = {};
CRM.module = window.CRM.module || {};
CRM.el     = window.CRM.el || {};
CRM.url    = window.CRM.url || {};

// 百度渲染引擎全局对象
var bt = baidu.template;

CRM.url.AREA_TREE_GET    = '/customerBaseInfo/initAreaCategoryTree'; // 地区树
CRM.url.ROLE_TREE_GET    = '/sys/role/ajax/load?async=false'; // 角色树
CRM.url.ORG_TREE_GET     = '/customerBaseInfoOrder/initSaleOrganizationTree'; // 组织树
CRM.url.MENU_TREE_GET    = '/sys/menu/ajax/load?async=false'; // 菜单树
CRM.url.PRODUCT_TREE_GET = '/productCategory/CategoryTree'; // 产品树

//功能性控件
CRM.el = {
    PANEL_CONTAINER : '[data-container="panel"]',
    EDIT_VIEW       : '[data-view="editView"]',
    EDIT_HIDE       : '[data-view="editHide"]',
    EDIT_BTN        : '[data-btn="edit"]',
    SAVE_BTN        : '[data-btn="save"]',
    CANCEL_BTN      : '[data-btn="cancel"]',
    ADD_BTN         : '[data-btn="add"]',
    DEL_BTN         : '[data-btn="del"]',
    ON_CONTROL      : '[data-control="on"]',
    OFF_CONTROL     : '[data-control="off"]'
};

//是否隐藏
CRM.showOrHide = function (elView,elHide,isShow) {

    if (isShow) { // 为true是编辑状态

        if (elView!=null) {

            elView.removeClass('hidden');
        }
        if (elHide!=null) {

            elHide.addClass('hidden');
        }
    }else{ // false 是查看状态

        if (elView!=null) {

            elView.addClass('hidden');
        }
        if (elHide!=null) {

            elHide.removeClass('hidden');
        }
    }
};

// 删除处理程序
CRM.delHandler = function(el){
    var tar = el.data('target'),//取得data-target属性值,selector
        tarEl = el.parents(tar)[0];//删除class等于该属性值的第一个祖先元素

    $(tarEl).remove();
};

// // 选中显示处理程序(用于radio、checkbox、selected)
// CRM.selectedView = function (bln,selctor) { // true 或者 false
//
//     if (bln) { // 为true时显示
//
//         $(selctor).removeClass('hidden');
//     }else {
//
//         $(selctor).addClass('hidden');
//     }
// };

// 百度渲染模板处理程序
CRM.tplHandler = function (id,data,tar) {
    var res  = {
            data:data
        },
        html0 = bt(id,res);

    tar.html(html0);
};

CRM.insertHtml = function (id,tar) {
    var htmlo = $(id).html();
    tar.html(htmlo);
};

//是否禁用
CRM.onOrOff = function (el,isOn) {

    if (el!=null) {

        if (isOn) {

            el.attr('disabled',false)
                .attr('data-control','on');
        }else {

            el.attr('disabled',true)
                .attr('data-control','off');
        }
    }

};

//ajax调用公共方法
CRM.ajaxCall = function(res){

    if (res.callback) {
        var callback = res.callback;
        delete res.callback;
    }

    $.ajax(res).done(function (result){
        var data = result.data;

        if (data) {
            console.log(data);
            callback(data);
        }else{
            callback();
        }
    }).fail(function(res){
        console.log('error:'+res.status);
    });
};

// 返回普通数组对象
CRM.toArr = function (data) {
    var arr = [];
    function recursionData(data) {

        if (data instanceof Array) {

            $.each(data,function (n,item) {
                var obj = {
                    id   : item.cid,
                    pId  : item.pid,
                    name : item.cname
                };
                arr.push(obj);

                recursionData(item.nodes);
            })
        }
    }

    recursionData(data);
    return arr;
};

// 返回当前时间，格式为yyyy-mm-dd
CRM.getTime = function(){
    var time = new Date();
    var year = time.getFullYear();
    var month = parseInt(time.getMonth())+1;
    var day = time.getDate();
    var hours = parseInt(time.getHours());
    var minutes = parseInt(time.getMinutes());
    var seconds = parseInt(time.getSeconds());
    var newTime;
    return newTime = year+'-'+month+'-'+day+' '+hours+':'+minutes+':'+seconds;
};

// 添加激活样式
CRM.addOnlyClass = function (el,allEL,par,cl) {
    par.find(allEL).removeClass(cl);
    el.addClass(cl);
};

// 返回没选中的tr
CRM.getNoSelectedTr = function (table) {

    return table.find('tbody').find('tr').filter(function(){

        if (!$(this).find('input').prop('checked')) {

            return $(this);
        }
    });
};

//移动
CRM.moveEl = function (el,tar) {
    el.appendTo(tar);
};

//面板组件，有编辑、保存、取消功能
CRM.module.Panel = function (el,res) {

    this.res = jQuery.extend({
        type        : 'POST',
        async       : true,
        contentType : '',
        upUrl       : '',
        downUrl     : '',
        upData      : {},
        downData    : {},
        up          : function(){return false;},
        down        : function(){return false;}
    },res||{});

    this.panel       = $(el);
    this.isEditState = false;
    this.edit        = CRM.el.EDIT_BTN;
    this.save        = CRM.el.SAVE_BTN;
    this.cancel      = CRM.el.CANCEL_BTN;
    this.editView    = CRM.el.EDIT_VIEW;
    this.editHide    = CRM.el.EDIT_HIDE;
    this.editOn      = CRM.el.ON_CONTROL;
    this.viewOff     = CRM.el.OFF_CONTROL;
};

//编辑处理程序
CRM.module.Panel.prototype.handleEdit = function (e) {
    var panel       = this.panel,
        isEditState = this.isEditState,
        elShow      = panel.find(this.editView),
        elHide      = panel.find(this.editHide),
        elOff       = panel.find(this.viewOff),
        // res         = this.down;F
    isEditState = true;
    CRM.onOrOff(elOff,isEditState);
    CRM.showOrHide(elShow,elHide,isEditState);

};

//保存处理程序
CRM.module.Panel.prototype.handleSave = function (e) {
    var panel       = this.panel,
        isEditState = this.isEditState,
        elShow      = panel.find(this.editView),
        elHide      = panel.find(this.editHide),
        elOn        = panel.find(this.editOn),
        res         = this.up;

    isEditState = false;
    CRM.onOrOff(elOn,isEditState);
    CRM.showOrHide(elShow,elHide,isEditState);

};

//取消处理程序
CRM.module.Panel.prototype.handleCancel = function (e) {
    var panel       = this.panel,
        isEditState = this.isEditState,
        elShow      = panel.find(this.editView),
        elHide      = panel.find(this.editHide),
        elOn        = panel.find(this.editOn);

    isEditState = false;
    CRM.onOrOff(elOn,isEditState);
    CRM.showOrHide(elShow,elHide,isEditState);

};

//编辑
CRM.module.Panel.prototype.startEdit = function () {

    console.log('执行了startEdit');
    var Panel = this;
    this.panel.on('click.panel.edit','button' + this.edit,function (e) {
        console.log('有毛病');
        Panel.handleEdit(e);
    })
};

//保存
CRM.module.Panel.prototype.startSave = function () {
    var Panel = this;
    this.panel.on('click.panel.save','button'+ this.save,function (e) {
        Panel.handleSave(e);
    });
};

//取消
CRM.module.Panel.prototype.startCancel = function () {
    var Panel = this;
    this.panel.on('click.panel.cancel','button'+ this.cancel,function (e) {
        Panel.handleCancel(e);
    })
};

// 可编辑的表格对象
CRM.ETable = function (opts) {
    opts = $.extend({
        id       : '',
        status   : false, // 为false关闭编辑功能，为true开启编辑功能
        inverse  : false, // 当为false时，开启[data-editTd="yes"]的编辑功能；为true时，禁用[data-editTd="no"]的编辑功能
        editTd   : '[data-editTd="yes"]',
        noEditTd : '[data-editTd="no"]'
    },opts||{});

    this.table    = $(opts.id);
    this.status   = opts.status;
    this.inverse  = opts.inverse;
    this.editTd   = opts.editTd;
    this.noEditTd = opts.noEditTd;
};
CRM.ETable.prototype.toggle = function () {
    var table = this;

    if (table.status) {

        table.openEdit(); // 开启编辑
    }else {
        table.closeEdit(); // 关闭编辑
    }
};
CRM.ETable.prototype.openEdit = function () {
    var table = this,
        td    = table.inverse ? ':not(' + table.noEditTd + ')' : table.editTd;

    table.table.on('click.table', 'td'+ td, function (e) {
        table.editHandler(e);
    });
};
CRM.ETable.prototype.closeEdit = function () {
    var table = this.table;
    table.off('.table');
};
CRM.ETable.prototype.editHandler = function (e) {
    var el = $(e.target);

    CRM.editEl(el);
};

// 编辑非表单元素
CRM.editEl = function (el) {
    if (el.find('span').length==1){

        el.find('span').html('<input type="text" class="form-control" id="editInput" value="' + el.find('span').text() + '" />');
    }else {

        el.html('<input type="text" class="form-control" id="editInput" value="' + el.text() + '" />');
    }

    el.find('input').focus();
    el.find('input').select();
    el.find('input').blur(function(){

        if (el.find('span').length==1){

            $(this).parent('span').html($(this).val());
        }else {

            $(this).parent('td').html($(this).val());
        }
    });
};



