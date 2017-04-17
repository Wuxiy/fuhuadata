/**
 * Created by Huxiangyang on 2017/4/6.
 */

CRM.productArchivesList   = window.CRM.productArchivesList || {};
CRM.productArchivesList.PRODUCT_INFO_LOOK_GET = basePath + '/productInfo/getProductInfoById'; // 产品信息查看
CRM.productArchivesList.PRODUCT_INFO_POST     = basePath + '/productInfo/doModify'; // 产品信息编辑

CRM.productArchivesList.editView     = null; // 编辑状态下显示的标签
CRM.productArchivesList.editHide     = null; // 编辑状态下隐藏的标签
CRM.productArchivesList.elOff        = null; // 编辑状态下开启的控件
CRM.productArchivesList.mainPanel    = $('#productInfo'); // 主面板
CRM.productArchivesList.asidePanel   = $('#aside'); // 侧面板
CRM.productArchivesList.asideTree    = $('#asideTree'); // 侧边树
CRM.productArchivesList.form         = $('#myForm'); // 表单容器
// CRM.productArchivesList.form         = $('#form'); // 表单内容
CRM.productArchivesList.editITable   = null; // 可编辑表格(理化)
CRM.productArchivesList.editPTable   = null; // 可编辑表格(加工)
CRM.productArchivesList.wTbody       = 'waresContent'; // 规格型号表格内容
CRM.productArchivesList.iTbody       = 'physicalProperitiesContent'; // 理化指标表格内容
CRM.productArchivesList.pTbody       = 'processingComponentsContent'; // 加工成份表格内容

// 按钮
CRM.productArchivesList.edit        = $('#edit');
CRM.productArchivesList.save        = $('#save');
CRM.productArchivesList.cancel      = $('#cancel');

// 树数据
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
CRM.productArchivesList.wares                = $('#wares'); // 产品规格(table)
CRM.productArchivesList.processingComponents = $('#processingComponents'); // 加工成分(table)
CRM.productArchivesList.physicalProperities  = $('#physicalProperities'); // 理化指标(table)
CRM.productArchivesList.pcCheckboxs          = null; // 选中的加工成分(checkbox)
CRM.productArchivesList.lastmodifyUserId     = $('#lastmodifyUserId'); // 最后编辑人id
CRM.productArchivesList.lastmodifyUserName   = $('#lastmodifyUserName'); // 最后编辑人name
CRM.productArchivesList.modifyTime           = $('#modifyTime'); // 最后修改时间

// 收集数据
CRM.productArchivesList.collectData = function () {
    var page = CRM.productArchivesList,
        obj = {
            productInfo:{
                productId            : page.productId.val(),
                concentration        : page.concentration.val(),
                saltType             : page.saltType.filter(':checked').val(),
                otherSaltName        : page.saltType.filter('.else').prop('checked') ? page.otherSaltName.val() : '',// 判断其他是否选中
                executeStandard      : page.executeStandard.val(),
                executeNumer         : page.executeNumer.val(),
                productFeature       : page.productFeature.val(),
                lastmodifyUserId     : 123,
                modifyTime           : CRM.getTime()
            }

        };

    // 判断是否是水剂
    if (page.processingComponents.children('table').length===1) { // 加工成分

        obj.productComponents = page.getTableData('#processingComponents'); // 加工成分表格数据
    } else {

        obj.productInfo.processingComponents = page.processingComponents.find('textarea').val(); // 加工成分文本域数据
    }
    if (page.physicalProperities.children('table').length===1) { // 理化指标

        obj.productInfo.physicalProperities  = page.getTableData('#physicalProperities'); // 理化指标表格数据
    } else {

        obj.productInfo.physicalProperities = page.physicalProperities.find('textarea').val(); // 理化指标文本域数据
    }
    return JSON.stringify(obj);
};

// 重置页面
CRM.productArchivesList.resetPage = function(){
    var page = this;

    page.productId.val('');
    page.categoryName.val('');
    page.name.val('');
    page.measurement.val('');
    page.saltType.val([]); // checkbox
    page.otherSaltName.val('');
    page.executeStandard.val('-1'); // select
    page.concentration.val('');
    page.executeNumer.val('');
    page.productFeature.val('');
    page.lastmodifyUserName.val('');
    page.modifyTime.val('');
    page.wares.html('');
    page.processingComponents.html('');
    page.physicalProperities.html('');
};

// 获得表格数据
CRM.productArchivesList.getTableData = function (id) {
    var page = this;
    if (id === '#processingComponents') {

       return page.getProcessingComponentsDataHandler();
    }else if (id === '#physicalProperities') {

        return page.getPhysicalProperitiesDataHandler();
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

// 百度渲染模板处理程序
CRM.productArchivesList.tplHandler = function (id,data,tar) {
    var res  = {
            data:data
        },
        html0 = bt(id,res);

    tar.html(html0);
};

// 查看状态时，执行的程序，隐藏和禁用元素
CRM.productArchivesList.viewPage = function () {
    var page = CRM.productArchivesList;

    // 等页面渲染完了再赋值
    page.editView = $(CRM.el.EDIT_VIEW);
    page.editHide = $(CRM.el.EDIT_HIDE);
    page.elOff    = $(CRM.el.OFF_CONTROL);

    // 禁用和隐藏的元素
    CRM.showOrHide(page.editView, page.editHide, false);
    CRM.onOrOff(page.elOff, false);
};

// 渲染页面处理程序
CRM.productArchivesList.renderPageHandler = function (data) {
    var page  = CRM.productArchivesList,
        p     = null,
        index = null,
        apcs  = null,
        arr   = [];

        page.resetPage();

    // 如果productInfo存在,则渲染
    if (data && data.productInfo) {

        p = data.productInfo;
        page.productId.val(p.productId);
        page.categoryName.val(p.categoryName);
        page.name.val(p.name);
        page.measurement.val(p.measurement);
        page.saltType.val([p.saltType]); // checkbox
        page.otherSaltName.val(p.otherSaltName);

        CRM.showOrHide(page.otherSaltName, null, page.saltType.filter('.else').prop('checked')); // 选中

        page.executeStandard.val(p.executeStandard);
        page.concentration.val(p.concentration);
        page.executeNumer.val(p.executeNumer);
        page.productFeature.val(p.productFeature);
        page.lastmodifyUserName.val(p.lastmodifyUserName);
        page.modifyTime.val(p.modifyTime);
    }

    if (data) {

        page.tplHandler(page.wTbody,data.wares,page.wares); // table规格型号
    }

    // 判断理化和加工的数据类型
    if (data) {

        index = data.index == null ? p.physicalProperities : data.index;
        apcs  = data.processingComponents == null ? p.processingComponents : data.allProcessingComponents;
        page.tplHandler(page.iTbody, index, page.physicalProperities); // table理化指标
        page.tplHandler(page.pTbody, apcs, page.processingComponents); // table加工成份

        // 创建可编辑表格实例
        page.editITable = new CRM.ETable({id:'#iTable',inverse:true});
        page.editPTable = new CRM.ETable({id:'#pTable',inverse:true});
    }

    // 取得该产品具有的加工成份
    if (data.processingComponents instanceof Array) {
        // 不能提前赋值$('[name="pc"]'),因为百度模板还未插入页面，查找时会得到空数组
        page.pcCheckboxs = $('[name="pc"]');
        $.each(data.processingComponents, function (i,item) {
            var val = item.componentId,
                td = page.pcCheckboxs.filter('[value="'+ val +'"]').parents('tr').find('td');
            // td.eq(1).text(item.componentName);
            td.eq(2).text(item.consumption);
            td.eq(3).text(item.remark);
            arr.push(val);
        });

    }

    page.pcCheckboxs.val(arr);

    // 未选中的tr隐藏
    CRM.getNoSelectedTr($('#pTable')).addClass('hidden');

    // 页面进入查看状态
    page.viewPage();
};

// 获得加工成分处理程序
CRM.productArchivesList.getProcessingComponentsDataHandler = function () {
    var page = CRM.productArchivesList,
        arr  = [],
        tr   = page.processingComponents.find('tbody>tr').filter(function () {
            if($(this).find('td').eq(0).find('input').prop('checked')){
                return $(this);
            }
        });

    tr.each(function () {
        var item = $(this),
            obj = {
                productId   : page.productId.val(),
                componentId : item.find('td').eq(0).find('input').val(),
                consumption : item.find('td').eq(2).text(),
                remark      : item.find('td').eq(3).text()
        };
        arr.push(obj);
    });

    return arr;
};

// 获得理化指标处理程序
CRM.productArchivesList.getPhysicalProperitiesDataHandler = function () {
    var page = CRM.productArchivesList,
        arr  = [],
        tr   = page.physicalProperities.find('tbody>tr');

    tr.each(function () {
        var item = $(this),
            obj = {
                index   : item.find('td').eq(0).text(),
                value   : item.find('td').eq(1).text(),
                remarks : item.find('td').eq(2).text()
            };
        arr.push(obj);
    });

    return JSON.stringify(arr);
};

// 侧栏角色树的点击事件
CRM.productArchivesList.asideTreeOnClick = function(event, modLeftId, treeNode) {
    var page = CRM.productArchivesList;

    // 渲染表单
    page.renderPage(treeNode.id);
};

// 渲染产品树到侧边栏
CRM.productArchivesList.renderProTreeToAside = function (data) {
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

    page.proTreeData = CRM.toArr(data); // 将角色树的数据保存到page对象属性
    $.fn.zTree.init(page.asideTree, setting, page.proTreeData);
    treeObj = $.fn.zTree.getZTreeObj(id);
    treeObj.expandAll(true); // 默认展开
};

// 初始化页面
CRM.productArchivesList.init = function () {
    var page = this;

    // 渲染页面初始数据
    page.renderPage(1011001);

    // 渲染侧边栏的产品树
    CRM.ajaxCall({
        url      : CRM.url.PRODUCT_TREE_GET,
        type     : 'GET',
        callback : page.renderProTreeToAside
    });

    // 新建Panel对象实例，绑定编辑、保存、取消事件
    var roleManage = new CRM.module.Panel('#productInfo');
    roleManage.startEdit();
    roleManage.startSave();
    roleManage.startCancel();

};

$(function () {
    var page = CRM.productArchivesList;

    // 初始化
    page.init();

    // 编辑
    page.edit.on('click.e',function () {

        page.asidePanel.fadeOut();

        $('#pTable').find('tr').removeClass('hidden');

        // 开启表格编辑功能
        page.editITable.status = true;
        page.editPTable.status = true;
        page.editITable.toggle();
        page.editPTable.toggle();
    });

    // 保存
    page.save.on('click.s',function () {

        page.asidePanel.fadeIn();

        CRM.ajaxCall({
            url  : page.PRODUCT_INFO_POST,
            data : page.collectData(),
            type : 'POST',
            contentType:"application/json",
            callback : function(data){
                page.renderPage(page.productId.val());
            }
    });

        // 关闭表格编辑功能
        page.editITable.status = false;
        page.editPTable.status = false;
        page.editITable.toggle();
        page.editPTable.toggle();
    });

    // 取消
    page.cancel.on('click.c',function () {

        page.asidePanel.fadeIn();

        page.renderPage(page.productId.val());

        // 关闭表格编辑功能
        page.editITable.status = false;
        page.editPTable.status = false;
        page.editITable.toggle();
        page.editPTable.toggle();
    });

    // 盐类的change事件
    page.saltType.on('change.salt',function () {
        var thisEl = $(this).filter('.else');
        CRM.showOrHide(page.otherSaltName,null,thisEl.prop('checked'));

        if (!thisEl.prop('checked')) {

            page.otherSaltName.val(''); // 如果没选中清除该文本框
        }
    });

});