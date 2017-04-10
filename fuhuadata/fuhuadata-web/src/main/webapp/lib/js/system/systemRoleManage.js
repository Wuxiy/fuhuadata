/**
 * Created by Huxiangyang on 2017/4/6.
 */


CRM.systemRoleManage = window.CRM.systemRoleManage || {};

CRM.systemRoleManage.ROLE_DETAILS_GET               = '/sys/role/ajax/'; // 角色详情
CRM.systemRoleManage.ROLE_ADD_POST                  = '/sys/role/ajax/add'; // 角色添加or更新
CRM.systemRoleManage.ROLE_RELEVANCE_MENU_POST       = '/sys/roleauth/save'; // 角色关联菜单
CRM.systemRoleManage.ROLE_RELEVANCE_MENU_LOOK_GET   = '/sys/roleauth/menu?roleId='; // 角色菜单查看
CRM.systemRoleManage.MENU_RELEVANCE_LIMITS_POST     = '/sys/roleauth/permission'; // 菜单关联权限
CRM.systemRoleManage.MENU_RELEVANCE_LIMITS_LOOK_GET = '/sys/roleauth/permission?roleId='; // 菜单权限查看
CRM.systemRoleManage.USER_RELEVANCE_AREA_POST       = '/sys/user/area/save'; // 用户关联地区
CRM.systemRoleManage.ROLE_RELEVANCE_USER_POST       = '/sys/role/users'; // 角色关联用户
CRM.systemRoleManage.ROLE_RELEVANCE_USER_LOOK_GET   = '/sys/role/users?roleId='; // 角色关联用户查看

// 保存树的数据
CRM.systemRoleManage.areaTreeData = null;
CRM.systemRoleManage.roleTreeData = null;
CRM.systemRoleManage.orgTreeData  = null;
CRM.systemRoleManage.menuTreeData = null;

CRM.systemRoleManage.editView     = $(CRM.el.EDIT_VIEW); // 编辑状态下显示的标签
CRM.systemRoleManage.editHide     = $(CRM.el.EDIT_HIDE); // 编辑状态下隐藏的标签
CRM.systemRoleManage.elOff        = $(CRM.el.OFF_CONTROL); // 编辑状态下开启的控件
CRM.systemRoleManage.fModCnt      = $('#treeModal'); // 第一个模态框
CRM.systemRoleManage.sModL        = $('#left'); // 第二个模态框左边
CRM.systemRoleManage.sModR        = $('#right'); // 第二个模态框右边
CRM.systemRoleManage.fMod         = $('#fModal'); // 第一个模态框的树容器
CRM.systemRoleManage.aside        = $('#roleTree'); // 侧边栏
CRM.systemRoleManage.asidePanel   = $('#asidePanel'); // 左边面板
CRM.systemRoleManage.tab          = $('#myTab'); // tab页
CRM.systemRoleManage.table        = $('#table'); // 表格

// 按钮
CRM.systemRoleManage.editBelOrg   = $('#editBelOrg'); // 所属组织查找按钮
CRM.systemRoleManage.editSperUser = $('#editSperUser'); // 上级角色查找按钮
CRM.systemRoleManage.editUserTree = $('#userTree'); // 已关联用户编辑按钮
CRM.systemRoleManage.editOrgTree  = $('#orgTree'); // 已分配组织编辑按钮
CRM.systemRoleManage.userTable    = $('#userTable'); // 已关联用户表
CRM.systemRoleManage.add          = $('#add'); // 新增按钮
CRM.systemRoleManage.cancel       = $('#cancel'); // 取消按钮
CRM.systemRoleManage.save         = $('#save'); // 保存按钮

// 表单控件
CRM.systemRoleManage.roleId     = $('#roleId');
CRM.systemRoleManage.orgId      = $('#orgId');
CRM.systemRoleManage.orgName    = $('#orgName');
CRM.systemRoleManage.parentId   = $('#parentId');
CRM.systemRoleManage.parentName = $('#parentName');
CRM.systemRoleManage.parentIds  = $('#parentIds');
CRM.systemRoleManage.enable     = $('#enable');
CRM.systemRoleManage.name       = $('#name');


// 渲染数据
CRM.systemRoleManage.renderData = function (res) {
    var page = CRM.systemRoleManage;
    // console.log(res);
    if (res!==null) {
        page.roleId.val(res.roleId);
        page.orgId.val(res.orgId);
        page.orgName.val(res.orgName);
        page.parentId.val(res.parentId);
        page.parentName.val(res.parentName);
        page.parentIds.val(res.parentIds);
        page.name.val(res.name);
        page.enable.val([res.enable]);
    }
};

// 收集数据
CRM.systemRoleManage.collectData = function () {
    var page = CRM.systemRoleManage,
        obj = {
            orgId      : page.orgId.val(),
            parentId   : page.parentId.val(),
            enable     : page.enable.val(),
            name       : page.name.val()
        };
    return obj;
};

// 刷新页面数据
CRM.systemRoleManage.resetPage = function (id) {
    var page = CRM.systemRoleManage;
    CRM.ajaxCall({
        url      : page.ROLE_DETAILS_GET + id,
        type     : 'GET',
        callback : page.renderData
    })
};

// 处理用户表格渲染
CRM.systemRoleManage.dealRenderUserTable = function () {
    var page = CRM.systemRoleManage;
    CRM.ajaxCall({
        url      :page.ROLE_RELEVANCE_USER_LOOK_GET,
        type     : 'GET',
        callback : page.renderUserTable
    })
};

// 侧栏角色树的点击事件
CRM.systemRoleManage.asideTreeOnClick = function(event, modLeftId, treeNode) {
    var page = CRM.systemRoleManage,
        t    = $('#tabl').parent('li');

    // 渲染表单
    page.resetPage(treeNode.id);

    // 渲染第用户表格
    page.table.html('');
    CRM.addOnlyClass(t,'li',page.tab,'active');
    page.renderUserTable(treeNode.id);
};

CRM.systemRoleManage.fModOrgTreeOnDbClick = function(event, modLeftId, treeNode) {
    var page = CRM.systemRoleManage;
    page.orgName.val(treeNode.name);
    page.orgId.val(treeNode.id);
    page.fModCnt.find('button.close').click(); // 关闭模态
};

CRM.systemRoleManage.fModRoleTreeOnDbClick = function(event, modLeftId, treeNode) {
    var page = CRM.systemRoleManage;
    page.parentName.val(treeNode.name);
    page.parentId.val(treeNode.id);
    page.fModCnt.find('button.close').click(); // 关闭模态
};

// 新增处理
CRM.systemRoleManage.addRole = function () {
    var page = CRM.systemRoleManage;
    page.parentId.val(page.roleId.val());
    page.parentName.val(page.name.val());
    page.roleId.val('');
    page.name.val('');
};

// 渲染用户表格
CRM.systemRoleManage.renderUserTable = function(id){
    var page = CRM.systemRoleManage;
    CRM.ajaxCall({
        url: page.ROLE_RELEVANCE_USER_LOOK_GET+id,
        type: 'GET',
        callback: page.renderUserTableHandle
    })

};

// 渲染用户表格处理
CRM.systemRoleManage.renderUserTableHandle = function (res) {
    var page  = CRM.systemRoleManage,
        data  = {
            data: page.returnUserTableData(res)
        },
        html0 = bt('userTable',data);

    // 渲染到页面
    $('#table').html(html0);
};

// 返回处理过后的用户表格数据
CRM.systemRoleManage.returnUserTableData = function (data) {
    var arr = [];
    $.each(data,function (i,item) {
        var obj = {
            id           : item.id,
            name         : item.userName,
            beginTime    : item.beginTime.split(/\s/)[0],
            endTime      : item.endTime.split(/\s/)[0],
            areasId      : '',
            areasName    : '',
            certigier    : '',
            accreditTime : ''
        };
        if (item.user.areas instanceof Array && item.user.areas.length > 0) {
            $.each(item.user.areas,function (j,item) {
                obj.areasId   += item.areaid + ',';
                obj.areasName += item.areaName + '、';
            });
            obj.areasId   = obj.areasId.slice(0,-1);
            obj.areasName = obj.areasName.slice(0,-1);
        }
        arr.push(obj);
    });
    return arr;
};

// 渲染菜单表格
CRM.systemRoleManage.renderMenuTable = function(id){
    var page = CRM.systemRoleManage;
    CRM.ajaxCall({
        url: page.ROLE_RELEVANCE_MENU_LOOK_GET+id,
        type: 'GET',
        callback: page.renderMenuTableHandle
    })

};

// 渲染菜单表格处理
CRM.systemRoleManage.renderMenuTableHandle = function (res) {

    var page  = CRM.systemRoleManage,
        data  = {
            data: res
        },
        html0 = bt('menuTable',data);

    // 渲染到页面
    $('#table').html(html0);
};

// 渲染按钮表格
CRM.systemRoleManage.renderBtnTable = function(id){
    var page = CRM.systemRoleManage;
    CRM.ajaxCall({
        url: page.MENU_RELEVANCE_LIMITS_LOOK_GET+id,
        type: 'GET',
        callback: page.renderBtnTableHandle
    })

};

// 渲染按钮表格处理
CRM.systemRoleManage.renderBtnTableHandle = function (res) {

    var page  = CRM.systemRoleManage,
        data  = {
            data: res
        },
        html0 = bt('btnTable',data);

    // 渲染到页面
    $('#table').html(html0);
};

// 渲染组织表格
CRM.systemRoleManage.renderOrgTable = function(id){
    var page = CRM.systemRoleManage;
    CRM.ajaxCall({
        url: page.MENU_RELEVANCE_LIMITS_LOOK_GET+id,
        type: 'GET',
        callback: page.renderOrgTableHandle
    })

};

// 渲染组织表格处理
CRM.systemRoleManage.renderOrgTableHandle = function (res) {

    var page  = CRM.systemRoleManage,
        data  = {
            data: res
        },
        html0 = bt('orgTable',data);

    // 渲染到页面
    $('#table').html(html0);
};

// 渲染角色树到侧边栏
CRM.systemRoleManage.renderRoleTreeToAside = function(data) {
    var page    = CRM.systemRoleManage,
        setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            edit: {
                enable: false
            },
            callback : {
                onClick : page.asideTreeOnClick
            }
        },
        id       = page.aside.attr('id'),
        treeObj  = null;

    page.roleTreeData = CRM.toArr(data); // 将角色树的数据保存到page对象属性
    $.fn.zTree.init(page.aside, setting, page.roleTreeData);
    treeObj = $.fn.zTree.getZTreeObj(id);
    treeObj.expandAll(true); // 默认展开
};

// 渲染地区树到模态的左边
CRM.systemRoleManage.renderAreaTreeToLeft = function(data) {
    var page     = CRM.systemRoleManage,
        setting  = {
            check: {
                enable: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            edit: {
                enable: false
            }
        },
        id       = page.sModL.attr('id'),
        treeObj  = null;

    page.areaTreeData = CRM.toArr(data);
    $.fn.zTree.init(page.sModL, setting, page.areaTreeData);
    treeObj = $.fn.zTree.getZTreeObj(id);
    treeObj.expandAll(true);
};

// 渲染组织树到模态的左边
CRM.systemRoleManage.renderOrgTreeToLeft = function(data) {
    var page     = CRM.systemRoleManage,
        setting  = {
            check: {
                enable: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            edit: {
                enable: false
            }
        },
        id       = page.sModL.attr('id'),
        treeObj  = null;

    page.orgTreeData= CRM.toArr(data);
    $.fn.zTree.init(page.sModL, setting, page.orgTreeData);
    treeObj = $.fn.zTree.getZTreeObj(id);
    treeObj.expandAll(true);
};

// 渲染组织树到第一模态
CRM.systemRoleManage.renderOrgTreeToFModal = function(data) {
    var page     = CRM.systemRoleManage,
        setting  = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            edit: {
                enable: false
            },
            callback: {
                onClick: page.fModOrgTreeOnDbClick
            }
        },
        id       = page.fMod.attr('id'),
        treeObj  = null;
    page.orgTreeData = CRM.toArr(data);
    $.fn.zTree.init(page.fMod, setting, page.orgTreeData);
    treeObj = $.fn.zTree.getZTreeObj(id);
    treeObj.expandAll(true);
};

// 渲染角色树到第一模态框
CRM.systemRoleManage.renderRoleTreeToFModal = function(data) {
    var page     = CRM.systemRoleManage,
        setting  = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            edit: {
                enable: false
            },
            callback: {
                onClick: page.fModRoleTreeOnDbClick
            }
        },
        id       = page.fMod.attr('id'),
        treeObj  = null;

    page.roleTreeData =  CRM.toArr(data);
    $.fn.zTree.init(page.fMod, setting, page.roleTreeData);
    treeObj = $.fn.zTree.getZTreeObj(id);
    treeObj.expandAll(true);
};

//初始化页面
CRM.systemRoleManage.init = function () {
    var page = CRM.systemRoleManage;

    // 禁用和隐藏的元素
    CRM.showOrHide(page.editView, page.editHide, false);
    CRM.onOrOff(page.elOff, false);

    // 新建Panel对象实例，绑定编辑、保存、取消事件
    var roleManage = new CRM.module.Panel('#roleManage');
    roleManage.startEdit();
    roleManage.startSave();
    roleManage.startCancel();

    // 渲染侧边栏的角色树
    CRM.ajaxCall({
        url      : CRM.url.ROLE_TREE_GET,
        type     : 'GET',
        callback : page.renderRoleTreeToAside
    });

};

$(function () {
    var page = CRM.systemRoleManage;

    // 初始化页面
    page.init();

    // 新增
    page.add.on('click.add',function () {

        // 将上级角色的id和name替换为当前节点的，并清空当前节点的属性
        page.addRole();

        //清空table
        page.table.html('');

        // 隐藏侧栏和tab页
        page.asidePanel.fadeOut();
        page.tab.fadeOut();
    });

    //保存
    page.save.on('click.save',function () {

        // 提交数据，以返回的id刷新表单
        CRM.ajaxCall({
            url: page.ROLE_ADD_POST,
            data: page.collectData(),
            type:'POST',
            callback: page.resetPage
        });

        // 刷新侧边栏的角色树
        CRM.ajaxCall({
            url      : CRM.url.ROLE_TREE_GET,
            type     : 'GET',
            callback : page.renderRoleTreeToAside
        });

        // 显示侧栏和tab页
        page.asidePanel.fadeIn();
        page.tab.fadeIn();

        // 激活第一页tab页
        page.tab.find('li').removeClass('active');
        $('#tabl').parent('li').addClass('active');

    });

    // 取消
    page.cancel.on('click.cancel',function () {

        // 取得父id，并刷新表单和用户表格
        var id = page.parentId.val();
        page.resetPage(id);
        page.renderUserTable(id);

        // 显示侧栏和tab页
        page.asidePanel.fadeIn();
        page.tab.fadeIn();

        // 激活第一页tab页
        page.tab.find('li').removeClass('active');
        $('#tabl').parent('li').addClass('active');

    });

    // tab页点击
    page.tab.on('click.tab','a',function (e) {
        var el  = $(e.target),
            id  = el.attr('id'),
            par = el.parent('li'),
            val = page.roleId.val();

        // 清空table
        page.table.html('');

        // 根据点击的tab页不同渲染数据table
        if (val!=='') {
            if (id==='tabl') {

                // 渲染用户表格
                page.renderUserTable(val);
            }else if (id==='tab2') {

                // 渲染菜单表格
                page.renderMenuTable(val);
            }else if (id==='tab3') {

                // 渲染按钮表格
                page.renderBtnTable(val)
            }else if (id==='tab4') {

            }

            // 给当前tab页添加激活样式
            CRM.addOnlyClass(par,'li',page.tab,'active');
        }else {

            alert('请在侧栏选择角色');
        }

    });







    // 编辑关联用户
    page.editUserTree.on('click.user',function (e) {

        $('#multiple').find('[data-btn="finish"]').attr('id','saveUser');
    });

    // 编辑分配组织
    page.editOrgTree.on('click.org',function (e) {

        $('#multiple').find('[data-btn="finish"]').attr('id','saveOrg');
        page.sModL.html('');
        CRM.ajaxCall({
            url      : CRM.url.ORG_TREE_GET,
            type     : 'GET',
            callback : page.renderOrgTreeToLeft
        });
    });

    // 编辑分配地区
    page.userTable.on('click.area','[name="areaTree"]',function (e) {
        var id = $(e.target).parents('tr').find('td').first();
        $('#userId').val(id);
        $('#multiple').find('[data-btn="finish"]').attr('id','saveArea');
        page.sModL.html('');
        CRM.ajaxCall({
            url      : CRM.url.AREA_TREE_GET,
            type     : 'GET',
            callback : page.renderAreaTreeToLeft
        });
    });

    // 编辑所属组织
    page.editBelOrg.on('click.area',function (e) {

        page.fMod.html('');
        CRM.ajaxCall({
            url      : CRM.url.ORG_TREE_GET,
            type     : 'GET',
            callback : page.renderOrgTreeToFModal
        });
    });

    // 编辑上级角色
    page.editSperUser.on('click.area',function (e) {

        page.fMod.html('');
        CRM.ajaxCall({
            url      : CRM.url.ROLE_TREE_GET,
            type     : 'GET',
            callback : page.renderRoleTreeToFModal
        });
    });
});
