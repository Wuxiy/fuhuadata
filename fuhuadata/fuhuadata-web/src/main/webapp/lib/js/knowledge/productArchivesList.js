/**
 * Created by Huxiangyang on 2017/4/6.
 */

CRM.productArchivesList   = window.CRM.productArchivesList || {};
CRM.productArchivesList.PRODUCT_INFO_LOOK_GET= '/productInfo/getProductInfoById'; // 产品信息查看
CRM.url.PRODUCT_INFO_POST   = '/productInfo/doModify'; // 产品信息编辑

CRM.productArchivesList.editView     = $(CRM.el.EDIT_VIEW); // 编辑状态下显示的标签
CRM.productArchivesList.editHide     = $(CRM.el.EDIT_HIDE); // 编辑状态下隐藏的标签
CRM.productArchivesList.elOff        = $(CRM.el.OFF_CONTROL); // 编辑状态下开启的控件
CRM.productArchivesList.mainPanel    = $('#productInfo'); // 主面板
CRM.productArchivesList.asidePanel   = $('#asidePanel'); // 侧面板
CRM.productArchivesList.asideTree    = $('#asideTree'); // 侧边树
CRM.productArchivesList.formVessel   = $('#formVessel'); // 表单容器
CRM.productArchivesList.form         = $('#form'); // 表单内容

// 按钮
CRM.productArchivesList.edit        = $('edit');
CRM.productArchivesList.save        = $('save');
CRM.productArchivesList.cancel      = $('cancel');
CRM.productArchivesList.proTreeData = null;

// 表单控件
CRM.productArchivesList.productId            = $('#productId'); // 产品id
CRM.productArchivesList.categoryName         = $('#categoryName'); // 品类
CRM.productArchivesList.name                 = $('#name'); // 品名
CRM.productArchivesList.measurement          = $('#measurement'); // 主计量单位
CRM.productArchivesList.concentration        = $('#concentration'); // 含量
CRM.productArchivesList.saltType             = $('[name="saltType"]'); // 盐类(checkbox)
CRM.productArchivesList.otherSaltName        = $('#otherSaltName'); // 其他盐类
CRM.productArchivesList.executeStandard      = $('#executeStandard'); // 执行标准
CRM.productArchivesList.executeNumer         = $('#executeNumer'); // 执行标准号
CRM.productArchivesList.productFeature       = $('#productFeature'); // 产品特点
CRM.productArchivesList.productFeature       = $('#wares'); // 产品规格(table)
CRM.productArchivesList.processingComponents = $('#processingComponents'); // 加工成份(table)
CRM.productArchivesList.physicalProperities  = $('#physicalProperities'); // 理化指标(table)
CRM.productArchivesList.lastmodifyUserId     = $('#lastmodifyUserId'); // 最后编辑人id
CRM.productArchivesList.lastmodifyUserName   = $('#lastmodifyUserName'); // 最后编辑人name
CRM.productArchivesList.modifyTime           = $('#modifyTime'); // 最后修改时间

// 收集数据
CRM.productArchivesList.collectData = function () {
    var page = CRM.systemRoleManage,
        obj = {
            productId            : page.productId.val(),
            concentration        : page.concentration.val(),
            saltType             : page.saltType.val(),
            otherSaltName        : page.otherSaltName.val(),
            executeStandard      : page.executeStandard.val(),
            executeNumer         : page.executeNumer.val(),
            productFeature       : page.productFeature.val(),
            processingComponents : page.getTableData('#processingComponents'), // 加工成分table特殊处理
            physicalProperities  : page.getTableData('#physicalProperities'),// 理化指标table特殊处理
            lastmodifyUserId     : page.lastmodifyUserId.val(),
            modifyTime           : page.modifyTime.val()
        };
    return obj;
};

// 获得表格数据
CRM.productArchivesList.getTableData = function (id) {
    var page = this;
    if (id === '#processingComponents') {

        page.getProcessingComponentsDataDataHandler();
    }else if (id === '#physicalProperities') {

        page.getPhysicalProperitiesDataHandler();
    }
};

// 渲染页面
CRM.productArchivesList.renderPage = function (id) {
    var page =CRM.productArchivesList;
    CRM.ajaxCall({
        url      : page.PRODUCT_INFO_LOOK_GET,
        data     : {id:id},
        type     : 'POST',
        callback : page.renderPageHandler
    })
};

// 渲染页面处理程序
CRM.productArchivesList.renderPageHandler = function (res) {
    var page  = CRM.productArchivesList,
        data  = {
            data: res
        },
        html0 = bt('form',data); // 返回渲染过后的模板

    // 将模板插入页面
    page.formVessel.html(html0);
};

// 获得理化指标处理程序
CRM.productArchivesList.getPhysicalProperitiesDataHandler = function () {


};

// 获得加工成分处理程序
CRM.productArchivesList.getProcessingComponentsDataDataHandler = function () {


};

// 产品树转换成普通数组
CRM.productArchivesList.toArr = function (data) {
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

// 侧栏角色树的点击事件
CRM.productArchivesList.asideTreeOnClick = function(event, modLeftId, treeNode) {
    var page = CRM.productArchivesList;

    // 渲染表单
    page.renderPage(treeNode.id);

    // 渲染第用户表格
    page.table.html('');
    CRM.addOnlyClass(t,'li',page.tab,'active');
    page.renderUserTable(treeNode.id);
};

// 渲染产品树到侧边栏
CRM.productArchivesList.renderProTreeToAside = function () {
    var page    = CRM.productArchivesList,
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
        id       = page.asideTree.attr('id'),
        treeObj  = null;

    page.proTreeData = page.toArr(data); // 将角色树的数据保存到page对象属性
    $.fn.zTree.init(page.asideTree, setting, page.proTreeData);
    treeObj = $.fn.zTree.getZTreeObj(id);
    treeObj.expandAll(true); // 默认展开
};


// 初始化页面
CRM.productArchivesList.init = function () {
    var page = this;

    // 禁用和隐藏的元素
    CRM.showOrHide(page.editView, page.editHide, false);
    CRM.onOrOff(page.elOff, false);

    // 新建Panel对象实例，绑定编辑、保存、取消事件
    var roleManage = new CRM.module.Panel('#productInfo');
    roleManage.startEdit();
    roleManage.startSave();
    roleManage.startCancel();

    // 渲染页面初始数据
    page.renderPage(1011001);

    // 渲染侧边栏的产品树
    CRM.ajaxCall({
        url      : CRM.url.PRODUCT_TREE_GET,
        type     : 'GET',
        callback : page.renderProTreeToAside
    });

};

$(function () {
    var page = CRM.productArchivesList;
    page.init();


});