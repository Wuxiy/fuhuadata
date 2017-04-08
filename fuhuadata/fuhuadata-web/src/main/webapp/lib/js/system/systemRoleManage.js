/**
 * Created by Huxiangyang on 2017/4/6.
 */
// CRM                      = window.CRM || {};
CRM.url                  = window.CRM.url || {};
CRM.systemRoleManage     = window.CRM.systemRoleManage || {};
CRM.url.SYSTEM_ROLE_DOWN = 'xxxxx-xxx-xxx';
CRM.url.SYSTEM_ROLE_UP   = 'xxxxx-xxx-xxx';
CRM.url.AREA_TREE        = '/customerBaseInfo/initAreaCategoryTree';
CRM.systemRoleManage.url = CRM.url.SYSTEM_ROLE_DOWN;

//渲染数据
CRM.systemRoleManage.renderData = function (res) {

};

//收集数据
CRM.systemRoleManage.collectData = function (res) {

};

//初始化页面
CRM.systemRoleManage.init = function () {
    var page     = this,
        elView   = $(CRM.el.EDIT_VIEW),
        elHide   = $(CRM.el.EDIT_HIDE),
        elOff    = $(CRM.el.OFF_CONTROL),
        treeData = null,
        res      = {
            type: 'POST',
            // upUrl: CRM.url.SYSTEM_ROLE_DOWN,
            // downUrl: CRM.url.SYSTEM_ROLE_UP,
            upData: page.collectData,
            down: page.renderData
        };

    CRM.showOrHide(elView, elHide, false);
    CRM.onOrOff(elOff, false);

    //初始化数据
    // CRM.ajaxCall('POST', page.url, page.data, null, page.renderData);

    //新建Panel对象实例，绑定编辑、保存、取消事件
    var roleManage = new CRM.module.Panel('#roleManage', res);
    roleManage.panel.on('click.panel.edit',roleManage.edit,function (e) {
        roleManage.handleEdit(e);
    });
    roleManage.panel.on('click.panel.save',roleManage.save,function (e) {
        roleManage.handleSave(e);
    });
    roleManage.panel.on('click.panel.cancel',roleManage.cancel,function (e) {
        roleManage.handleCancel(e);
    });

    //获取树的数据
    treeData = CRM.getData('GET',CRM.url.AREA_TREE,null,null);
    var asideTree = new CRM.module.Tree('#left');
    asideTree.createTree(treeData,asideTree.parent);
    asideTree.startClick();
};

CRM.systemRoleManage.init();