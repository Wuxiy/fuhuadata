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

CRM.url.AREA_TREE_GET = '/customerBaseInfo/initAreaCategoryTree'; // 地区树
CRM.url.ROLE_TREE_GET = '/sys/role/ajax/load?async=false'; // 角色树
CRM.url.ORG_TREE_GET  = '/customerBaseInfoOrder/initSaleOrganizationTree'; // 组织树
CRM.url.MENU_TREE_GET = '/sys/menu/ajax/load?async=false'; // 菜单树

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
    $.extend({
        type        : 'POST',
        contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
        url         : '',
        data        : {},
        async       : true
    },res||{});

    $.ajax({
        url         : basePath + res.url,
        type        : res.type,
        data        : res.data,
        async       : res.async,
        contentType : res.contentType
    }).done(function (result){
        var data = result.data;
        console.log(data);
        res.callback(data);
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

<<<<<<< HEAD
//面板组件，有编辑、保存、取消
CRM.module.Panel = function (el) {
=======
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
>>>>>>> 6591119033eb3da09386a18be16b7ee3c9a7ac15

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

<<<<<<< HEAD
    // if (typeof res.url === String && res.url.length > 0) {
    //
    //     CRM.ajaxCall(res);
    // }
=======
    if (typeof res.downUrl === String && res.downUrl.length > 0) {

        CRM.ajaxCall(res.type,res.downUrl,res.downData,res.contentType,res.down,res.async);
    }
>>>>>>> 6591119033eb3da09386a18be16b7ee3c9a7ac15

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


<<<<<<< HEAD
    // if (typeof res.url === String && res.url.length > 0) {
    //
    //     CRM.ajaxCall(res);
    // }
=======
    if (typeof res.upUrl === String && res.upUrl.length > 0) {

        CRM.ajaxCall(res.type,res.upUrl,res.upData,res.contentType,res.up,res.async);
    }
>>>>>>> 6591119033eb3da09386a18be16b7ee3c9a7ac15
};

//取消处理程序
CRM.module.Panel.prototype.handleCancel = function (e) {
    var panel       = this.panel,
        isEditState = this.isEditState,
        elShow      = panel.find(this.editView),
        elHide      = panel.find(this.editHide),
        elOn        = panel.find(this.editOn);
        // res         = this.down;

    isEditState = false;
    CRM.onOrOff(elOn,isEditState);
    CRM.showOrHide(elShow,elHide,isEditState);

<<<<<<< HEAD
    // if (typeof res.url === String && res.url.length > 0) {
    //
    //     CRM.ajaxCall(res);
    // }
=======
    if (typeof res.downUrl === String && res.downUrl.length > 0) {

        CRM.ajaxCall(res.type,res.downUrl,res.downData,res.contentType,res.down,res.async);
    }
>>>>>>> 6591119033eb3da09386a18be16b7ee3c9a7ac15

};

//编辑
CRM.module.Panel.prototype.startEdit = function () {
<<<<<<< HEAD
    // console.log('执行了startEdit');
    var panel = this;
    this.panel.on('click.panel.edit','button' + this.edit,function (e) {
        // console.log('有毛病');
        panel.handleEdit(e);
    })
=======
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
>>>>>>> 6591119033eb3da09386a18be16b7ee3c9a7ac15
};

//保存
CRM.module.Panel.prototype.startSave = function () {
    var panel = this;
    this.panel.on('click.panel.save','button'+ this.save,function (e) {
        panel.handleSave(e);
    });
};

//取消
CRM.module.Panel.prototype.startCancel = function () {
    var panel = this;
    this.panel.on('click.panel.cancel','button'+ this.cancel,function (e) {
        panel.handleCancel(e);
    })
};

//多选框
// CRM.module.Mulbox = function (el,data) {
//     this.Mulbox      = $(el);
//     this.data        = data;
//     this.otherData   = [];
//     this.right       = '[data-mulbox="left"]';
//     this.left        = '[data-mulbox="right"]';
//     this.leftBut     = '[data-btn="moveLeft"]';
//     this.rightBut    = '[data-but="moveRight"]';
//     this.leftAllBut  = '[data-but="moveAllLeft"]';
//     this.rightAllBut = '[data-but="moveAllRight"]';
// };
//
// CRM.module.Mulbox.prototype.moveArea = function (e) {
//     var btn       = $(e.target),
//         tranData  = null, // 在两个树之间传递数据
//         leftBox   = $(this.left,this.Mulbox),
//         rightBox  = $(this.right,this.Mulbox),
//         leftData  = this.data,
//         rightData = this.otherData,
//         el        = null,
//         cid       = 0;
//
//     if (btn.data('but')==='moveLeft') {
//
//         el = rightBox.find('.active');
//         cid = el.data('id');
//
//         //根节点
//         if (cid===0) {
//
//             $.each(leftData,function (n,item) {
//
//                 if (item.cid==cid) {
//
//                     tranData =  leftData.splice(n);
//                 }
//             });
//
//             rightData.push(tranData.split(0));
//         }
//
//         //二级节点
//         else if (cid.toString().length===3) {
//
//             $.each(leftData[0].nodes,function (n,item) {
//
//                 if (item.cid==cid) {
//
//                     tranData =  leftData[0].nodes.splice(n);
//                 }
//             });
//
//             rightData[0].nodes.push(tranData.split(0));
//
//         }
//
//         //三级节点
//         else if (cid.toString().length===20) {
//             var pid;
//             $.each(leftData[0].nodes,function (n,itemArea) {
//
//                 $.each(itemArea,function (i,itemCountry) {
//
//                     if (itemCountry.cid==cid) {
//
//                         tranData = leftData[0].nodes[n].splice(i);
//                         pid      = leftData[0].nodes[n].splice(i).pid;
//                     }
//                 })
//             });
//
//             $.each(rightData[0].nodes,function (n,itemArea) {
//
//                 if (itemArea.cid = pid) {
//
//                     tranData[0].nodes[n].nodes.push(tranData.split(0));
//                 }
//             })
//         }
//
//
//         // leftBox.find('.active').appendTo(rightBox);
//     }
// };


// CRM.module.Tree = function (el) {
//     this.tree   = $(el);
//     this.parent = $('<ul class="tree-root"></ul>');
// };
//
// //创建树
// CRM.module.Tree.prototype.createTree = function (data,parent) {
//     var Tree = this;
//     if (data instanceof Array && data.length > 0) {
//         var html = '';
//         $.each(data,function(n,item){
//             var li = $('<li data-id="'+item.cid+'"></li>');//还未搞明白
//             html = '';
//
//             if (item.nodes instanceof Array && item.nodes.length > 0) {
//
//                 html += '<span class="branch-node" data-toggle="collapse" data-target="#t'+item.cid+'"></span>';
//                 html += '<a><span class="leaf"></span>'+item.cname+'</a>';
//                 html += '<ul id="t'+item.cid+'" class="tree-branch collapse in"></ul>';
//                 $(li).append(html).appendTo(parent);
//
//                 Tree.createTree(item.nodes,$(li).children("ul.tree-branch"));
//             }else{
//
//                 html += '<span class="branch"></span><a class="cNode"><span class="leaf"></span>'+item.cname+'</a>';
//                 $(li).append(html).appendTo(parent);
//             }
//         })
//     }
//     Tree.tree.append(Tree.parent);
// };
//
// CRM.module.Tree.prototype.createCheckboxTree = function (data,parent) {
//     var Tree = this;
//     if (data instanceof Array && data.length > 0) {
//         var html = '';
//         $.each(data,function(n,item){
//             var li = $('<li data-id=""></li>');//还未搞明白
//             html = '';
//
//             if (item.nodes instanceof Array && item.nodes.length > 0) {
//
//                 html += '<span class="branch-node" data-toggle="collapse" data-target="#t'+item.cid+'"></span>';
//                 html += '<a><span class="leaf"></span>'+item.cname+'</a>';
//                 html += '<ul id="t'+item.cid+'" class="tree-branch collapse in"></ul>';
//                 $(li).append(html).appendTo(parent);
//
//                 Tree.createTree(item.nodes,$(li).children("ul.tree-branch"));
//             }else{
//
//                 html += '<span class="branch"></span><a class="cNode"><span class="leaf"></span><input name="'+item.pid+'" type="checkbox" value="'+item.cid+'">'+item.cname+'</a>';
//                 $(li).append(html).appendTo(parent);
//             }
//         })
//     }
//     Tree.tree.html('').append(Tree.parent);
// };
//
// CRM.module.Tree.prototype.handleEvent = function (e) {
//     var el     = $(e.target).parent('li'),
//         parent = this.tree;
//
//     CRM.addOnlyClass(el,'li',parent,'active');
// };
//
// CRM.module.Tree.prototype.startClick = function () {
//     var Tree = this;
//     this.tree.on('click.tree.addClass','a',function (e) {
//        Tree.handleEvent(e);
//     })
// };
//
// CRM.SaveBtn = function (id) {
//   this.target = $('#'+id).data('target');
// };
//
// CRM.SaveBtn.prototype.save = function (obj) { // obj.data;obj.callback
//     var btn = this;
//     this.on('click.save',obj,function (e) {
//       btn.handle(e.data);
//   })
// };
//
// CRM.Form = function (id) {
//     this.status = $('#'+id).data('status'); //edit or noEdit
//     this.data = null;
// };
// CRM.