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

    //true的时候显示
    if (isShow) {

        elView.removeClass('hidden');
        elHide.addClass('hidden');
    }else{
        elView.addClass('hidden');
        elHide.removeClass('hidden');
    }
};

//是否禁用
CRM.onOrOff = function (el,isOn) {

    if (isOn) {

        el.removeAttr('disabled')
            .attr('data-control','on');
    }else {
        el.attr('disabled','disabled')
            .attr('data-control','off');
    }
};

//ajax调用公共方法
CRM.ajaxCall = function(res){
    // $.extend({
    //     type        : 'POST',
    //     contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
    //     url         : '',
    //     data        : {},
    //     async       : true
    // },res||{});
    if (res.callback) {
        var callback = res.callback;
        delete res.callback;
    }
    $.ajax(res).done(function (result){
        var data = result.data;
        console.log(data);
        callback(data);
    }).fail(function(res){
        console.log('error:'+res.status);
    });
};

// 返回数据
// CRM.getData = function (type,url,data,contentType) {
//   var getData;
//   CRM.ajaxCall(type,url,data,contentType,callback,false);
//
//   function callback(res) {
//       getData = res;
//   }
//
//   return getData;
// };

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

    // this.up          = up;
    // this.down        = down;
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
        // res         = this.down;
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

