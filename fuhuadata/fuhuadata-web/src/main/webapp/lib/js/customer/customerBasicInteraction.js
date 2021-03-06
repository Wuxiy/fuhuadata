/**
 * Created by huxiangyang on 2017/3/13.
 */


CRM.cbInfo   = window.CRM.cbInfo || {};
CRM.cbInfo.LOOK_POST    = basePath + '/customerBaseInfo/showCustomerBaseInfoDetails'; // 客户基本信息查看
CRM.cbInfo.EDIT_POST    = basePath + '/customerBaseInfo/updateCustomerBaseInfo'; // 客户基本信息编辑
CRM.cbInfo.ADD_POST     = basePath + '/customerBaseInfo/doAddCustomerBaseInfo'; // 客户信息新增
// CRM.cbInfo.ENCY_SKIP    = '' // 百科编辑
CRM.cbInfo.encyUrl      = basePath + '/customerEncyclopedia/addCustomerEncyclopedia'; // 百科编辑

CRM.cbInfo.editView     = null; // 编辑状态下显示的标签
CRM.cbInfo.editHide     = null; // 编辑状态下隐藏的标签
CRM.cbInfo.elOff        = null; // 编辑状态下开启的控件
CRM.cbInfo.mainPanel    = $('#cbInfo'); // 主面板
CRM.cbInfo.form         = $('#myForm'); // 表单容器
CRM.cbInfo.factor       = $('#factory'); //工厂部分
CRM.cbInfo.mcg          = $('#majorCompetitorsGroup'); // 竞争对手部分
CRM.cbInfo.oppo         = $('#opportunity'); // 机会部分
CRM.cbInfo.cmp          = 'cmp'; // 生产产品(循环加载)
CRM.cbInfo.encyC        = 'encyC'; // 百科
CRM.cbInfo.status       = null; // 页面状态
CRM.cbInfo.isEdit       = false; // 页面是否可编辑 (默认不能编辑)

// 字典
CRM.cbInfo.cusTypes    = [{name:'潜在客户',val:'2'},{name:'合作客户',val:'1'},{name:'流失客户',val:'3'}];

// url接收的参数
CRM.cbInfo.cid = $('#cid').val(); // 客户id
CRM.cbInfo.ctp = $('#ctp').val(); // 客户状态
CRM.cbInfo.fname = $('#fname').val(); // 客户全称

// 按钮
CRM.cbInfo.edit        = null;
CRM.cbInfo.save        = null;
CRM.cbInfo.cancel      = null;
CRM.cbInfo.upFile      = $('#up');
CRM.cbInfo.addPro      = $('#add');

// 数据
CRM.cbInfo.areaTree = null;

// 表单控件
CRM.cbInfo.area                 = $('#area'); // 地区
CRM.cbInfo.areaId               = $('#areaId'); // 地区id
CRM.cbInfo.companyType          = $('#companyType'); // 公司类型
CRM.cbInfo.customerId           = $('#customerId'); // 客户id 自动生成
CRM.cbInfo.customerType         = $('#customerType'); // 客户状态 [1,2,3] 1合作客户 2潜在客户 3流失客户
CRM.cbInfo.enterpriseEmail      = $('#enterpriseEmail'); // 企业邮箱
CRM.cbInfo.enterpriseNature     = $('[name="enterpriseNature"]'); // 企业性质 checkbox
CRM.cbInfo.enterprisePhone      = $('#enterprisePhone'); // 企业电话
CRM.cbInfo.fullName             = $('#fullName'); // 客户全称
CRM.cbInfo.hasChiCompany        = $('#hasChiCompany'); // 是否有中国分公司
CRM.cbInfo.hasChiPurchase       = $('#hasChiPurchase'); // 是否有中方采购
CRM.cbInfo.lastmodifyUserId     = $('#lastmodifyUserId'); // 最后编辑人id
CRM.cbInfo.majorCompetitors     = $('#majorCompetitors'); // 主要竞争对手
CRM.cbInfo.modifyTime           = $('#modifyTime'); // 最后编辑时间
CRM.cbInfo.opportunityDescrible = $('#opportunityDescrible'); // 机会描述
CRM.cbInfo.otherOpportunity     = $('#otherOpportunity'); // 其他机会
CRM.cbInfo.productLine          = $('#productLine'); // 生产线
CRM.cbInfo.registeredAddress    = $('#registeredAddress'); // 注册地址
CRM.cbInfo.registeredFunds      = $('#registeredFunds'); // 注册资金
CRM.cbInfo.remark               = $('#remark'); // 备注
CRM.cbInfo.shortName            = $('#shortName'); // 简称
CRM.cbInfo.zhongxinbaoLevel     = $('#zhongxinbaoLevel'); // 中信保等级 必填
CRM.cbInfo.zhongxinbaoNumber    = $('#zhongxinbaoNumber'); // 中信保编号
CRM.cbInfo.customerMakeProduct  = null; // 客户生产产品 list 动态内容，不能在这里赋值，不然为undefined
CRM.cbInfo.customerLevel        = $('#customerLevel'); // 客户等级
CRM.cbInfo.factoryLocation      = $('#factoryLocation'); // 工厂位置
CRM.cbInfo.managementScope      = $('#managementScope'); // 经营范围
CRM.cbInfo.opportunitySource    = $('#opportunitySource');
CRM.cbInfo.otherEnterpriceNature= $('#otherEnterpriceNature');
// CRM.cbInfo.customerStatus       = $('#customerStatus'); // 客户状态 0流失 1正常
CRM.cbInfo.formatdoc            = $('#dataFormat'); // 数据格式
CRM.cbInfo.custclass            = $('#customerBasicTypes'); // 客户基本分类
CRM.cbInfo.timezone             = $('#timeZone'); // 时区
CRM.cbInfo.countryzone          = $('#commerceCountry'); // 贸易国别
CRM.cbInfo.customerDutyParagraph= $('#customerDutyParagraph'); // 客户税号
CRM.cbInfo.saleOrganizationName = $('#saleOrganizationName'); // 所属组织
CRM.cbInfo.lastmodifyUserName = $('#lastmodifyUserName'); // 最后修改人

// 收集数据
CRM.cbInfo.collectData = function () {
    var page = CRM.cbInfo,
        obj = {
            customerBaseInfo:{
                areaId               : page.areaId.data('val'), // 地区分类id
                area                 : page.areaId.val(), // 地区分类name
                companyType          : page.companyType.val(),
                customerId           : page.cid,
                customerLevel        : page.customerLevel.val(),
                customerType         : page.customerType.val(),
                enterpriseEmail      : page.enterpriseEmail.val(),
                enterprisePhone      : page.enterprisePhone.val(),
                fullName             : page.fullName.val(),
                hasChiCompany        : page.hasChiCompany.val(),
                hasChiPurchase       : page.hasChiPurchase.val(),
                lastmodifyUserId     : page.lastmodifyUserId.val(),
                majorCompetitors     : page.majorCompetitors.val(),
                modifyTime           : CRM.getTime(),
                opportunityDescrible : page.opportunityDescrible.val(),
                otherOpportunity     : page.otherOpportunity.val(),
                // productLine          : page.productLine.val(),
                registeredAddress    : page.registeredAddress.val(),
                registeredFunds      : ($('#fundType').data('val')+':'+page.registeredFunds.val()), // 注册资金
                shortName            : page.shortName.val(),
                zhongxinbaoLevel     : page.zhongxinbaoLevel.val(),
                zhongxinbaoNumber    : page.zhongxinbaoNumber.val(),
                // customerMakeProduct  : page.customerMakeProduct.val(),
                otherEnterpriceNature: page.otherEnterpriceNature.val(),
                managementScope      : page.managementScope.val(),
                factoryLocation      : page.factoryLocation.val(),
                productionLine       : page.productLine.val(),
                remark               : page.remark.val(),
                opportunitySource    : page.opportunitySource.val(),
                fullEnterpriseNature : page.sCustomerEnterpriceNature(),
                // area                 : page.areaId.find(':selected').text(),
                // country              : page.areaId.find(':selected').text(),
                formatdoc            : page.formatdoc.val(),
                custclass            : page.custclass.data('val'),
                timezone             : page.timezone.data('val'),
                countryzone          : page.countryzone.data('val'),
                lossReason           : $('#reason').val(),
                saleOrganizationId   : page.saleOrganizationName.data('val'),
                saleOrganizationName : page.saleOrganizationName.val(),
                customerDutyParagraph: page.customerDutyParagraph.val()
            },
            customerEnterpriceNatures : page.customerEnterpriceNatureObj(),
            customerMakeProducts : page.customerMakeProductObj()

        };

    return JSON.stringify(obj);
};

//企业性质
CRM.cbInfo.customerEnterpriceNatureObj = function () {
    var page  =  CRM.cbInfo,
        arr = [];
    page.enterpriseNature.filter(':checked').each(function () {
        var obj = {
            customerId : page.cid,
            type : 1,
            nature : $(this).val()
        };
        arr.push(obj);
    });
    return arr;
};

//企业性质字符传
CRM.cbInfo.sCustomerEnterpriceNature = function () {
    var page  =  CRM.cbInfo,
        sName = '';

    page.enterpriseNature.filter(':checked').each(function () {
        var $this = $(this);
        sName += $this.next('span').text() +',';
    });

    return sName.slice('0','-1');
};

//客户生产产品
CRM.cbInfo.customerMakeProductObj = function () {
    var page  =  CRM.cbInfo,
        arr = [];

    page.customerMakeProduct = $('[name="customerMakeProduct"]');
    page.customerMakeProduct.each(function () {
        var $this = $(this),
            obj   = {};

        if($this.data('id') && $this.data('id')!='' && $this.data('id')!=null){
            obj.id = $this.data('id');
        }
        obj.customerId = page.cid;
        obj.production = $this.find('[name="production"]').val();
        obj.productName = $this.find('[name="productName"]').val();
        arr.push(obj);
    });
    return arr;
};

// 渲染下拉框
CRM.cbInfo.renderTree = function (data, el, fitem) {
    var page    = CRM.cbInfo,
        fOptons = '<option value="">' + fitem + '</option>',
        options = fOptons + page.getOption(data);

    page[el].html(options);
};

// 返回下拉框内容
CRM.cbInfo.getOption = function(data){
    var options = '';
    $.each(data,function (n,area) {
        options += '<option value="'+area.cid+'">'+area.cname+'</option>';
    });
    return options;
};

// 根据地区id取得国家树的数据
CRM.cbInfo.getCounData = function (data,id) {
    var page = CRM.cbInfo,
        res = null;

    $.each(data,function (i,item) {

        if (item.cid===id.toString()) {

            res = item.nodes;
            return false;
        }else {

            return true;
        }
    });

    return res;
};

// 渲染表单
CRM.cbInfo.renderPage = function () {
    var page = CRM.cbInfo;

    $.ajax({
        url:page.LOOK_POST,
        type:'POST',
        data:{
            customerId:page.cid
        }
    }).done(function (res) {
        var data = res.data;
        page.renderForm(data); // 渲染页面表单
        page.isView(); // 根据表单的值显示或隐藏元素
        page.togglePage(page.isEdit); // 禁用和隐藏开关
    });

};

// 渲染表单处理程序
CRM.cbInfo.renderForm = function(data){
    var page = CRM.cbInfo,
        encyData = {};

    if (data.area) { page.areaId.val(data.area);}
    if (data.areaId) { page.areaId.data('val',data.areaId);}
    if (data.companyType) { page.companyType.val(data.companyType);}
    if (data.customerType) { page.customerType.val(data.customerType);}
    if (data.ncId) { page.customerId.val(data.ncId);}
    if (data.customerLevel) { page.customerLevel.val(data.customerLevel);}
    if (data.enterpriseEmail) {  page.enterpriseEmail.val(data.enterpriseEmail);}
    if (data.enterpriseNature) { page.enterpriseNature.val(data.enterpriseNature.split(','));} // checkbox
    if (data.enterprisePhone) { page.enterprisePhone.val(data.enterprisePhone);}
    if (data.fullName) { page.fullName.val(data.fullName);}
    if (data.hasChiCompany!=null && data.hasChiCompany!=undefined) { page.hasChiCompany.val(data.hasChiCompany);}
    if (data.hasChiPurchase!=null && data.hasChiPurchase!=undefined) { page.hasChiPurchase.val(data.hasChiPurchase);}
    if (data.lastmodifyUserId) { page.lastmodifyUserId.val(data.lastmodifyUserId);}
    if (data.majorCompetitors) { page.majorCompetitors.val(data.majorCompetitors);}
    if (data.modifyTime) { page.modifyTime.val(data.modifyTime);} // time
    if (data.opportunitySource) { page.opportunitySource.val(data.opportunitySource)} // 机会来源
    if (data.opportunityDescrible) { page.opportunityDescrible.val(data.opportunityDescrible);}
    if (data.otherOpportunity) { page.otherOpportunity.val(data.otherOpportunity);}
    if (data.productLine) { page.productLine.val(data.productLine);}
    if (data.registeredAddress) { page.registeredAddress.val(data.registeredAddress);}
    if (data.registeredFunds) {
        if(data.registeredFunds.split(':').length==2){
            $('#fundType').text(data.registeredFunds.split(':')[0]).data('val',data.registeredFunds.split(':')[0]);
            page.registeredFunds.val(data.registeredFunds.split(':')[1]);
        }else {
            page.registeredFunds.val(data.registeredFunds.split(':')[0]);
        }
    } // 注册资金
    if (data.shortName) { page.shortName.val(data.shortName);}
    if (data.zhongxinbaoLevel) { page.zhongxinbaoLevel.val(data.zhongxinbaoLevel);}
    if (data.zhongxinbaoNumber) { page.zhongxinbaoNumber.val(data.zhongxinbaoNumber);}
    // if (data.customerLevel) { page.customerLevel.val(data.customerLevel);}
    if (data.remark) { page.remark.val(data.remark);}
    if (data.factoryLocation) { page.factoryLocation.val(data.factoryLocation);}
    if (data.managementScope) { page.managementScope.val(data.managementScope);}
    if (data.lastmodifyUserName) { page.lastmodifyUserName.val(data.lastmodifyUserName);}

    // 新加字段
    if (data.formatdoc) { page.formatdoc.val(data.formatdoc);} // 数据格式
    if (data.custclass) { page.custclass.data('val',data.custclass);} // 客户基本分类
    if (data.custclassName) { page.custclass.val(data.custclassName);}
    if (data.timezone) { page.timezone.data('val',data.timezone);} // 时区
    if (data.timezoneName) { page.timezone.val(data.timezoneName);}
    if (data.countryzone) { page.countryzone.data('val',data.countryzone);} // 贸易国别
    if (data.countryzoneName) { page.countryzone.val(data.countryzoneName);}
    if (data.saleOrganizationName) { page.saleOrganizationName.val(data.saleOrganizationName);}  // 所属组织
    if (data.saleOrganizationId) { page.saleOrganizationName.data('val',data.saleOrganizationId);}
    if (data.customerDutyParagraph) {page.customerDutyParagraph.val(data.customerDutyParagraph)} // 客户税号


    // 百科
    if (data.companyInfo) { encyData.companyInfo = data.companyInfo;}
    if (data.developHis) { encyData.developHis  = data.developHis;}
    if (data.sellNetwork) { encyData.sellNetwork = data.sellNetwork;}
    if (data.modifyTimeEn) { encyData.modifyTimeEn = data.modifyTimeEn;}
    if (data.lastmodifyUserNameEn) { encyData.lastmodifyUserNameEn = data.lastmodifyUserNameEn;}
    if (data.modifyTimeEn) { encyData.modifyTimeEn = data.modifyTimeEn;}
    if (data.customField) { encyData.customField = JSON.parse(data.customField);}
    var isEncyData = false;
    $.each(encyData,function (k,v) { // encyData是否有数据
        if(encyData[k]!=undefined){
            isEncyData = true;
            return false;
        }else {
            return true;
        }
    });
    if (isEncyData) { CRM.tplHandler('encyC',encyData,$('#ency'));} // 百科

    // 产品
    if (data.customerMakeProduct) { CRM.tplHandler('cmp',data.customerMakeProduct,$('#cmpC'));}

    // 构造百科url
    page.ENCY_SKIP = page.encyUrl + '?customerId=' + data.customerId + (data.encyId!=undefined? '&encyId=' + data.encyId : '');
};

// 重置表单
CRM.cbInfo.resetForm = function (id) {
    $('input:not([type="checkbox"]),textarea,select',$(id)).val('');
    $('input[type="checkbox"]',$(id)).val([]);
    $('#customerBasicTypes,#timeZone,#commerceCountry').data('val','');
};

// 返回页面状态，c合作客户页，l潜在客户页，r流失客户页，a潜在客户新增
CRM.cbInfo.returnStatus = function () {
    var page = CRM.cbInfo;

    if (page.cid) {

        if (page.ctp ==='1') {

            page.status = 'c';
        }else if (page.ctp ==='2') {

            page.status = 'l';
        }else {

            page.status = 'r';
        }
    }else {

        page.status = 'a';
    }
};

// 工厂信息，竞争对手等，是否隐藏
CRM.cbInfo.isView = function () {
    var page = CRM.cbInfo;

    CRM.showOrHide(page.factor, null, $('#showFactory').prop('checked')); // 工厂
    CRM.showOrHide(page.mcg, null, $('#showMajorCompetitorsGroup').prop('checked')); // 主要竞对
    CRM.showOrHide(page.oppo, null, $('#showOpportunity').prop('selected')); // 机会来源
    CRM.showOrHide(page.otherEnterpriceNature, null, $('#showOtherEnterpriceNature').prop('checked')); // 其他企业性质
    CRM.showOrHide(page.otherOpportunity, null, $('#showOtherOpportunity').prop('selected')); // 其他机会
};

// 切换 隐藏/显示 和 禁用/启用
CRM.cbInfo.togglePage = function (isE) {
    var page = CRM.cbInfo;

    // 等页面渲染完了再赋值
    page.editView = $(CRM.el.EDIT_VIEW);
    page.editHide = $(CRM.el.EDIT_HIDE);
    page.elOff    = $(CRM.el.OFF_CONTROL);

    // 禁用和隐藏的元素
    CRM.showOrHide(page.editView, page.editHide, isE);
    CRM.onOrOff(page.elOff, isE);
};

// 初始化页面
CRM.cbInfo.init = function () {
    var page   = this,
        status = null;

    page.returnStatus(); // 返回页面状态
    // status = page.status;

    if (page.status!=='a') {


        CRM.insertHtml('#crlBtn',$('#funBtn')); // 渲染功能按钮 非新增状态

        if (page.status==='l') { // 潜在

            CRM.cbInfo.lInitHandler();
        }else if (page.status==='c') { // 合作

            CRM.cbInfo.cInitHandler();
        }else if (page.status==='r') { // 流失

            CRM.cbInfo.rInitHandler();
        }

        page.renderPage(); // 渲染页面

    }else {

        CRM.cbInfo.aInitHandler(); // 新增
    }

};


// 新增客户初始化程序
CRM.cbInfo.aInitHandler = function () {
    var page = CRM.cbInfo;
    CRM.insertHtml('#al',page.customerType); // 渲染cusotmerType表单控件
    CRM.insertHtml('#funBtnA',$('#aBtn')); // 渲染功能按钮 新增
    CRM.insertHtml('#backBtn',$('#funBtn')); // 返回

    // 渲染数据格式下拉框
    CRM.ajaxCall({
        url: basePath + '/customerBaseInfo/getFormatdoc',
        type:'POST',
        callback:function (dataF) {
            if (dataF) {

                CRM.tplHandler('dataFormatC',dataF,$('#dataFormat')); // 插入数据格式下拉框
            }
        }
    });
    page.togglePage(true);
    page.isView();
};

// 潜在客户初始化程序
CRM.cbInfo.lInitHandler = function () {
    var page = CRM.cbInfo;
    CRM.insertHtml('#al',page.customerType); // 渲染cusotmerType表单控件
};

// 合作客户初始化程序
CRM.cbInfo.cInitHandler = function () {
    var page = CRM.cbInfo;
    CRM.insertHtml('#cr',page.customerType); // 渲染cusotmerType表单控件
    CRM.insertHtml('rm',$('#rModal')); // 渲染流失原因模态
};

// 流失客户初始化程序
CRM.cbInfo.rInitHandler = function () {
    var page = CRM.cbInfo;
    CRM.insertHtml('#cr',page.customerType); // 渲染cusotmerType表单控件
};

// 表单验证配置
/*CRM.cbInfo.vDeploy= function () {

    // 错误信息容器
    $.validator.setDefaults({
        errorElement: 'div'
    });

    // 错误信息提示工具
    var em = function (txt, t, l) {
        return '<div class="tooltip top in"' +
            ' style="'+t+'; '+l+'; display: block; min-width: 50px;">' +
            '<div class="tooltip-arrow" style="left: 50%; border-top-color: #ff524f"></div>' +
            '<div class="tooltip-inner" style="background-color: #ff524f">'+txt+'</div>' +
            '</div>';
    };
    return em;
};*/

// 返回验证的表单对象
CRM.cbInfo.pVerify = function () {

    // 配置验证规格和显示消息
    var mainForm=$('#myForm').validate({
        rules: {
            fullName: 'required',
            saleOrganizationName: 'required',
            enterpriseNature: 'required',
            dataFormat: 'required',
            customerBasicTypes: 'required',
            timeZone: 'required',
            commerceCountry: 'required',
            opportunitySource:{
                required:'#showOpportunity:checked'
            },
            opportunityDescrible:{
                required:'#showOpportunity:checked'
            },
            enterpriseEmail:'email'
        },
        messages: {
            fullName: {
                required:em('必填','top:-29px','right:0')
            },
            saleOrganizationName:{
                required:em('请选择一个值','top:-29px','right:0')
            },
            enterpriseNature:{
                required:em('请选择一个值','top:-29px','left:-60px')
            },
            dataFormat:{
                required:em('请选择一个值','top:-29px','right:0')
            },
            customerBasicTypes:{
                required:em('请选择一个值','top:-29px','right:0')
            },
            timeZone:{
                required:em('请选择一个值','top:-29px','right:0')
            },
            commerceCountry:{
                required:em('请选择一个值','top:-29px','right:0')
            },
            enterpriseEmail:em('请输入有效的邮箱','top:-29px','right:0'),
            opportunitySource:em('请选择一个值','top:-29px','right:0'),
            opportunityDescrible:em('请填写机会描述','top:-29px','right:0')
        }
    });

    return mainForm;
};

// 返回验证的表单对象
CRM.cbInfo.mVerify = function () {

    // 流失原因表单配置
    var rea = $("#rForm").validate({
        rules: {
            reason:{
                required:'#showRModal:checked'
            }
        },
        messages: {
            reason: em('请输入流失原因','top:-29px','right:0')
        }
    });

    return rea;
};

// 给客户基本分类树添加点击事件
CRM.cbInfo.cbtTreeClick = function (event, modLeftId, treeNode) {

    $('#customerBasicTypes').val(treeNode.name);
    $('#customerBasicTypes').data('val',treeNode.id);
    $('#cbtModal').modal('hide');
};

// 渲染客户基本分类树
CRM.cbInfo.renderCBTTree = function (data) {
    var page = CRM.cbInfo,
        setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            edit: {
                enable: false
            },
            callback: {
                onDblClick: page.cbtTreeClick
            }
        },
        id = $('#cbtTree').attr('id'),
        treeObj = null,
        treeData = CRM.toArr(data);

    $.fn.zTree.init($('#cbtTree'), setting, treeData);
    treeObj = $.fn.zTree.getZTreeObj(id);
    treeObj.expandAll(true); // 默认展开
};


// 给地区树添加点击事件
CRM.cbInfo.areTreeClick = function (event, modLeftId, treeNode) {
    var treeObj = $.fn.zTree.getZTreeObj('cbtTree'),
        node = treeObj.getSelectedNodes()[0];

    if (!node.isParent) {

        $('#areaId').val(treeNode.name);
        $('#areaId').data('val',treeNode.pkAreacl);
        $('#cbtModal').modal('hide');

    }else {
        alert('请选择子节点');
    }
};

// 渲染地区分类树
CRM.cbInfo.renderAreaTree = function (data) {
    var page = CRM.cbInfo;
    setting = {
        data: {
            simpleData: {
                enable: true,
                idKey: "pkAreacl",
                pIdKey: "pkFatherarea"
            }
        },
        edit: {
            enable: false
        },
        callback: {
            onDblClick: page.areTreeClick
        }
    };

    $.fn.zTree.init($('#cbtTree'), setting, data);
};

/**
 * 以下是实现
 */
$().ready(function() {


    var page  = CRM.cbInfo,
        pForm = null,
        mForm = null;

    // 初始化
    page.init();
    pForm = page.pVerify();
    mForm = page.mVerify();

    // 编辑
    page.edit = $('#edit');
    page.edit.on('click.edit',function () {

        page.togglePage(true);
    });

    // 保存
    page.save = $('#save');
    page.save.on('click.save',function () {

        if (pForm.form()) { //验证通过弹出提交框

            $('#upModal').modal('show'); // 弹出是否提交表单
        }

    });

    // 添加更多产品
    $('#add').on('click',function () {
        var item = $('#pro').clone();

        $('#cmpC').append(item.html());
    });

    // 取消
    page.cancel = $('#cancel');
    page.cancel.on('click.cancel',function () {
        page.togglePage(false);
        page.renderPage();
        // page.renderPage(page.cid);
        // pForm.form();
    });

    // 工厂选中，经销商选中，其他选中
    $(document).on('click.cbx','#showFactory,#showMajorCompetitorsGroup,#showOtherEnterpriceNature',function () {
        var $this = $(this);
            id = $this.data('target');
        if ($this.prop('checked')) {

            $(id).removeClass('hidden').val('');
            $('textarea,input',$(id)).val('');
        }else {

            $(id).addClass('hidden').val('');
            $('textarea,input',$(id)).val('');
        }
    });

    // 其他机会描述选中，显示文本框。流失客户选中，弹出模态框
    $(document).on('change.sel','#customerType,#opportunitySource',function () {
        var $this = $(this),
            slt = $('#showOtherOpportunity'),
            slo = $('#showRModal').prop('selected');

        if ($this.attr('id')=='customerType' && slo) { // 客户状态

            $('#rModal').modal('show');
            $('#upReasons').on('click.up',function () {
                // mForm.form();
                if (mForm.form()) {
                    // 提交表单
                } else {
                    return false
                }
            })
        }else {

            if (slt.prop('selected')) { // 其他机会描述

                $(slt.data('target')).removeClass('hidden');
                $(slt.data('target')).val('');
            }else {

                $(slt.data('target')).addClass('hidden');
                $(slt.data('target')).val('');
            }
        }
    });

    // 返回
    $('#backPage').on('click.back',function () {

        window.history.back(-1);
    });

    // 重置
    $('#resetB').on('click.reset',function () {

       $('input,textarea,select',$('#myForm')).val('');
       $('input[type="checkbox"]',$('#myForm')).val([]);
        // pForm.resetForm();
    });

    // 删除自己增加的产品
    $(document).on('click.del','[data-btn="del"]',function () {
        var $this = $(this),
            tar   = $this.data('target');

        $(this).closest(tar).remove();
    });

    // 点击提交表单
    $('#up').on('click.up',function () {

        if (page.status!='a') { // 非新增状态提交

            CRM.ajaxCall({
                url:page.EDIT_POST,
                data:page.collectData(),
                contentType:"application/json",
                method:'POST',
                callback:function () {
                    page.resetForm();
                    page.renderPage();
                    // page.renderPageHandler(page.cid);
                }
            });

        }else if (page.status=='a') { // 新增状态提交

            CRM.ajaxCall({
                url:page.ADD_POST,
                data:page.collectData(),
                contentType:"application/json",
                method:'POST',
                callback:function (data) {
                    window.history.back(-1);
                    /*self.location = basePath+'/customerBaseInfo/intoCustomerBaseInfoDetails?' +
                        'customerType=2&customerId='+ data.customerId;*/
                }
            });
        }

    });

    // 跳转百科编辑
    $('#encyEdit').on('click.ency',function () {

        sessionStorage.setItem('customerUrl',window.location.href);
        self.location = page.ENCY_SKIP;
        return false;
    });

    // 贸易国别，获取焦点时渲染下拉框
    $('#commerceCountryS').on('focus.cc',function () {


        CRM.ajaxCall({
            url:basePath + '/customerBaseInfo/getCountryzone',
            type:'POST',
            contentType:'application/json',
            data:JSON.stringify({
                name:''
            }),
            callback:function (data) {
                if (data) {
                    CRM.tplHandler('tzC',data,$('#cc'));
                }
            }
        });
    });

    // 贸易国别，改变值时，渲染下拉框
    $('#commerceCountryS').on('input.cc',function () {

        var obj = {
            name:$(this).val()
        };
        $('#cc').html('');
        CRM.ajaxCall({
            url:basePath + '/customerBaseInfo/getCountryzone',
            type:'POST',
            contentType:'application/json',
            data:JSON.stringify(obj),
            callback:function (data) {
                if (data) {
                    CRM.tplHandler('tzC',data,$('#cc'));
                }
            }
        });
    });

    // 贸易国别，失去焦点清空搜索框
    $('#commerceCountryS').on('blur.cc',function () {

        $(this).val('');
    });

    // 点击国别下拉菜单，将值添加到文本框
    $('#cc').on('click.cc','a',function (e) {
        var elVal = $(e.target).data('val'),
            txt = $(e.target).text(),
            tarInput = $('#commerceCountry');

        tarInput.val(txt);
        tarInput.data('val',elVal);
        return false;
    });

    // 时区下拉搜索框,获取焦点查询所有数据
    $('#timeZoneS').on('focus.tz',function () {

        $('#tz').html('');
        CRM.ajaxCall({
            url:basePath + '/customerBaseInfo/getTimezone',
            type:'POST',
            contentType:'application/json',
            data:JSON.stringify({
                name:''
            }),
            callback:function (data) {
                if (data) {

                    CRM.tplHandler('tzC',data,$('#tz'));
                }
            }
        });
    });

    // 时区下拉搜索框，根据值动态渲染数据
    $('#timeZoneS').on('input.tz',function () {

        var obj = {
            name: $(this).val()
        };

        $('#tz').html('');
        CRM.ajaxCall({
            url:basePath + '/customerBaseInfo/getTimezone',
            type:'POST',
            contentType:'application/json',
            data:JSON.stringify(obj),
            callback:function (data) {
                if (data) {

                    CRM.tplHandler('tzC',data,$('#tz'));
                }
            }
        });
    });

    // 点击时区下拉菜单，将值添加到文本框
    $('#tz').on('click.cc','a',function (e) {
        var elVal = $(e.target).data('val'),
            txt = $(e.target).text(),
            tarInput = $('#timeZone');

        tarInput.val(txt);
        tarInput.data('val',elVal);
        return false;
    });

    // 时区下拉菜单，失去焦点时隐藏
    $('#timeZoneS').on('blur.cc',function () {

        $(this).val('');
    });

    // 点击客户基本分类查找按钮，弹出树形菜单
    $('#cbtSearch').on('click.tree',function () {
        CRM.ajaxCall({
            url:basePath +'/customerBaseInfo/getCustclass',
            type:'GET',
            callback:page.renderCBTTree
        })
    });

    // 点击地区分类查找按钮，弹出树形菜单
    $('#aISearch').on('click.tree',function () {
        CRM.ajaxCall({
            url:basePath +'/customerBaseInfo/initAreaCategoryTree',
            type:'GET',
            callback:page.renderAreaTree
        })
    });

    // 提交流失原因
    $('#upReasons').on('click.upReason',function () {

        if (page.status!='a') {

            CRM.ajaxCall({
                url:page.EDIT_POST,
                data:page.collectData(),
                contentType:"application/json",
                method:'POST',
                callback:function () {
                    page.resetForm();
                    page.renderPage();
                }
            });

        }
    });

    // 点击选择所属组织
    var orgTreeData = null;
    $('#oNSearch').on('click.renderTree',function () {
        if (orgTreeData==null) {
            $.ajax({
                url:basePath+'/customerBaseInfoOrder/initSaleOrganizationTree',
                type:'GET'
            }).done(function (result) {
                orgTreeData = result.data;
                renderTree(orgTreeData);
            })
        }else {
            renderTree(orgTreeData);
        }
    });

    // 点击选择币种
    $('#sFundType').on('click','a',function (e) {
        e.preventDefault();
        var $this = $(this);
        $('#fundType').data('val',$this.data('val'));
        $('#fundType').text($this.data('val'));
    });

    // 失去焦点时验证客户全称是否有效
    $('[name="fullName"]').on('blur.verify', function(e) {

        var self = $(this),
            val = $(this).val();
        e.preventDefault();

        $.ajax({
            url: basePath+'/customerBaseInfo/checkCustByName',
            type: 'GET',
            data: {
                custName: val
            }
        }).done(function (result) {


            if (result.code===0) {


                alert(result.message);
                self.val('');

            }


        })

    });

    /**
     * 渲染树菜单
     * @param data
     */
    function renderTree(data) {
        var setting = {
                data: {
                    simpleData: {
                        enable: true
                    }
                },
                edit: {
                    enable: false
                },
                callback: {
                    onDblClick: ablclickTree
                }
            },
            id = $('#cbtTree').attr('id'),
            treeObj = null,

            treeData = CRM.toArr(data);

        $.fn.zTree.init($('#cbtTree'), setting, treeData);
        treeObj = $.fn.zTree.getZTreeObj(id);
        treeObj.expandAll(true); // 默认展开
    }

    /**
     * 树点击事件
     * @param event
     * @param modLeftId
     * @param treeNode
     */

    function ablclickTree(event, modLeftId, treeNode) {

        $('#saleOrganizationName').data('val',treeNode.id);
        $('#saleOrganizationName').val(treeNode.name);
        $('#cbtModal').modal('hide');
    }

});
