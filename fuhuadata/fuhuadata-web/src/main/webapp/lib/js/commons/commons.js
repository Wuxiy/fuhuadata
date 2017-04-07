/**
 * Created by Huxiangyang on 2017/4/6.
 */

//唯一全局变量
var CRM = {};
CRM.module = window.CRM.module || {};
CRM.el     = window.CRM.el || {};

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
CRM.ajaxCall = function(type,url,data,contentType,callback,async){

    $.ajax({
        url:basePath + url,
        type:type,
        data:data,
        async:async!==false?true:false,
        contentType: contentType!==null?contentType:'application/x-www-form-urlencoded; charset=UTF-8'
    }).done(function (res) {
        var data = res.data;
        callback(data);
    }).fail(function(res){
        console.log('error:'+res.status);
    });
};

//返回数据
CRM.getData = function (type,url,data,contentType) {
  var getData;
  CRM.ajaxCall(type,url,data,contentType,callback,false);

  function callback(res) {
      getData = res;
  }

  return getData;
};

//返回当前时间，格式为yyyy-mm-dd
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

//添加激活样式
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
        elOff        = panel.find(this.viewOff),
        res         = this.res;
    isEditState = true;
    CRM.onOrOff(elOff,isEditState);
    CRM.showOrHide(elShow,elHide,isEditState);

    if (typeof res.downUrl === String && res.downUrl.length > 0) {

        CRM.ajaxCall(res.type,res.downUrl,res.downData,res.contentType,res.down);
    }

};

//保存处理程序
CRM.module.Panel.prototype.handleSave = function (e) {
    var panel       = this.panel,
        isEditState = this.isEditState,
        elShow      = panel.find(this.editView),
        elHide      = panel.find(this.editHide),
        elOn        = panel.find(this.editOn),
        res         = this.res;

    isEditState = false;
    CRM.onOrOff(elOn,isEditState);
    CRM.showOrHide(elShow,elHide,isEditState);


    if (typeof res.upUrl === String && res.upUrl.length > 0) {

        CRM.ajaxCall(res.type,res.upUrl,res.upData,res.contentType,res.up);
    }
};

//取消处理程序
CRM.module.Panel.prototype.handleCancel = function (e) {
    var panel       = this.panel,
        isEditState = this.isEditState,
        elShow      = panel.find(this.editView),
        elHide      = panel.find(this.editHide),
        elOn        = panel.find(this.editOn),
        res         = this.res;

    isEditState = false;
    CRM.onOrOff(elOn,isEditState);
    CRM.showOrHide(elShow,elHide,isEditState);

    if (typeof res.downUrl === String && res.downUrl.length > 0) {

        CRM.ajaxCall(res.type,res.downUrl,res.downData,res.contentType,res.down);
    }

};

// //编辑
// CRM.module.Panel.prototype.startEdit = function () {
//     console.log('执行了startEdit');
//     this.panel.on('click.panel.edit','button' + this.edit,function (e) {
//         console.log('有毛病');
//         // this.handleEdit(e);
//     })
// };
//
// //保存
// CRM.module.Panel.prototype.startSave = function () {
//     this.panel.on('click.panel.save','button'+ this.save,function (e) {
//         this.handleSave(e);
//     });
// };
//
// //取消
// CRM.module.Panel.prototype.startCancel = function () {
//     this.panel.on('click.panel.cancel','button'+ this.cancel,function (e) {
//         this.handleCancel(e);
//     })
// };

//多选框
CRM.module.Mulbox = function (el) {
    this.Mulbox = $(el);
    this.right       = '[data-mulbox="left"]';
    this.left        = '[data-mulbox="right"]';
    this.leftBut     = '[data-btn="moveLeft"]';
    this.rightBut    = '[data-but="moveRight"]';
    this.leftAllBut  = '[data-but="moveAllLeft"]';
    this.rightAllBut = '[data-but="moveAllRight"]';
};

CRM.module.Mulbox.prototype.move = function (el) {
    var leftBox  = $(this.left,this.Mulbox),
        rightBox = $(this.right,this.Mulbox);

    if (el.data('but')==='moveLeft') {

        leftBox.find('.active').appendTo(rightBox);
    }
};

CRM.module.Mulbox.prototype.handleMove = function (e) {
    var but      = $(e.target),
        el       = null,
        rPOne    = null,
        rPTwo    = null,
        lPOne    = null,
        lPTwo    = null,
        isPOne   = false,
        isPTwo   = false,
        leftBox  = $(this.left,this.Mulbox),
        rightBox = $(this.right,this.Mulbox);

    if (but.data('but')==='moveLeft') {

        el     = rightBox.find('.active');
        rPOne  = el.parent('ul').parent('li');
        rPTwo  = rPOne.parent('ul').parent('li');
        lPOne  = leftBox.find('[data-id="'+rPOne.data('id')+'"]');
        lPTwo  = leftBox.find('[data-id="'+rPTwo.data('id')+'"]');
        isPOne = lPOne.length===1 ;
        isPTwo = lPTwo.length===1 ;

        if (isPOne) {

            CRM.moveEl(el,lPOne);
        }else {
            if (isPTwo) {
                CRM.moveEl(rPOne.clone().find('li').not('.active').remove(),lPTwo);
            }
        }
    }
    this.move(el);

    CRM.moveEl(el,tar);
};

CRM.module.Mulbox.prototype.startMoveL = function () {

};

// CRM.module.Mulbox.prototype.moveRight = function () {
//
// };

CRM.module.Tree = function (el) {
    this.tree   = $(el);
    this.parent = $('<ul class="tree-root"></ul>');
};

//创建树
CRM.module.Tree.prototype.createTree = function (data,parent) {
    var Tree = this;
    if (data instanceof Array && data.length > 0) {
        var html = '';
        $.each(data,function(n,item){
            var li = $('<li data-id="'+item.cid+'"></li>');//还未搞明白
            html = '';

            if (item.nodes instanceof Array && item.nodes.length > 0) {

                html += '<span class="branch-node" data-toggle="collapse" data-target="#t'+item.cid+'"></span>';
                html += '<a><span class="leaf"></span>'+item.cname+'</a>';
                html += '<ul id="t'+item.cid+'" class="tree-branch collapse in"></ul>';
                $(li).append(html).appendTo(parent);

                Tree.createTree(item.nodes,$(li).children("ul.tree-branch"));
            }else{

                html += '<span class="branch"></span><a class="cNode"><span class="leaf"></span>'+item.cname+'</a>';
                $(li).append(html).appendTo(parent);
            }
        })
    }
    Tree.tree.append(Tree.parent);
};

CRM.module.Tree.prototype.handleEvent = function (e) {
    var el     = $(e.target).parent('li'),
        parent = this.tree;

    CRM.addOnlyClass(el,'li',parent,'active');
};

CRM.module.Tree.prototype.startClick = function () {
    var Tree = this;
    this.tree.on('click.tree.addClass','li',function (e) {
       Tree.handleEvent(e);
    })
};