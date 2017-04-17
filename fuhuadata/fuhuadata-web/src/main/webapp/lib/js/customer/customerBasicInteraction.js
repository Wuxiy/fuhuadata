/**
 * Created by huxiangyang on 2017/3/13.
 */


CRM.cbInfo   = window.CRM.cbInfo || {};
CRM.cbInfo.LOOK_POST    = '/customerBaseInfo/showCustomerBaseInfoDetails'; // 客户基本信息查看
CRM.cbInfo.EDIT_POST    = '/customerBaseInfo/updateCustomerBaseInfo'; // 客户基本信息编辑
CRM.cbInfo.ADD_POST     = '/customerBaseInfo/doAddCustomerBaseInfo'; // 客户信息新增
CRM.cbInfo.encyUrl      = '/customerEncyclopedia/addCustomerEncyclopedia'; // 百科编辑

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
CRM.cbInfo.country              = $('#country'); // 国家
CRM.cbInfo.countryId            = $('#countryId'); // 国家id
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
CRM.cbInfo.formatdoc            = $('#dataFormat');
CRM.cbInfo.custclass            = $('#customerBasicTypes');
CRM.cbInfo.timezone             = $('#timeZone');
CRM.cbInfo.countryzone          = $('#commerceCountry');

// 收集数据
CRM.cbInfo.collectData = function () {
    var page = CRM.cbInfo,
        obj = {
            customerBaseInfo:{
                areaId               : page.areaId.val(),
                countryId            : page.countryId.val(),
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
                registeredFunds      : page.registeredFunds.val(),
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
                area                 : page.areaId.find(':selected').text(),
                country              : page.areaId.find(':selected').text(),
                formatdoc            : page.formatdoc.val(),
                custclass            : page.custclass.data('val'),
                timezone             : page.timezone.data('val'),
                countryzone          : page.countryzone.data('val'),
                lossReason           : $('#reason').val()
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
CRM.cbInfo.renderPage = function (id) {
    var page = CRM.cbInfo;

    // 有数据，先渲染下拉框，再请求渲染页面
    if (page.areaTree) {

        page.renderTree(page.areaTree, 'areaId', '——请选择地区——');
        page.renderPageHandler(id);
    }else {

        // 没有数据，先请求渲染下拉框，再请求渲染页面
        CRM.ajaxCall({
            url:CRM.url.AREA_TREE_GET,
            type:'GET',
            callback:function (res) {
                page.areaTree = res[0].nodes; // 将取到的树数据赋值给对象属性，下次有的话就不用再发请求了
                page.renderTree(page.areaTree, 'areaId', '——请选择地区——');
                page.renderPageHandler(id);
            }
        })
    }

};

// 渲染国家树，渲染表单
CRM.cbInfo.renderPageHandler = function (id) {
    var page = CRM.cbInfo;

    // 重置表单
    page.resetForm('#myForm');

    CRM.ajaxCall({
        url:page.LOOK_POST,
        type:'POST',
        data:{
            customerId:id
        },
        callback:function (data) {
            var counTree = page.getCounData(page.areaTree,data.areaId); // 获取国家树的数据
            page.renderTree(counTree, 'countryId', '——请优先选择地区——'); // 创建国家树

            // 渲染数据格式下拉框
            CRM.ajaxCall({
                url:'/customerBaseInfo/getFormatdoc',
                type:'POST',
                callback:function (dataF) {
                    if (dataF) {

                        CRM.tplHandler('dataFormatC',dataF,$('#dataFormat')); // 插入数据格式下拉框
                        page.renderForm(data); // 渲染页面表单
                        page.isView(); // 根据表单的值显示或隐藏元素
                        page.togglePage(page.isEdit); // 禁用和隐藏开关
                    }
                }
            });

        }
    });
};

// 渲染表单处理程序
CRM.cbInfo.renderForm = function(data){
    var page = CRM.cbInfo,
        encyData = {};

    if (data.areaId) { page.areaId.val(data.areaId);}
    if (data.countryId) { page.countryId.val(data.countryId);}
    if (data.companyType) { page.companyType.val(data.companyType);}
    if (data.customerType) { page.customerType.val(data.customerType);}
    if (data.customerId) { page.customerId.val(data.customerId);}
    if (data.customerLevel) { page.customerLevel.val(data.customerLevel);}
    if (data.enterpriseEmail) {  page.enterpriseEmail.val(data.enterpriseEmail);}
    if (data.enterpriseNature) { page.enterpriseNature.val(data.enterpriseNature.split(','));} // checkbox
    if (data.enterprisePhone) { page.enterprisePhone.val(data.enterprisePhone);}
    if (data.fullName) { page.fullName.val(data.fullName);}
    if (data.hasChiCompany) { page.hasChiCompany.val(data.hasChiCompany);}
    if (data.hasChiPurchase) { page.hasChiPurchase.val(data.hasChiPurchase);}
    if (data.lastmodifyUserId) { page.lastmodifyUserId.val(data.lastmodifyUserId);}
    if (data.majorCompetitors) { page.majorCompetitors.val(data.majorCompetitors);}
    if (data.modifyTime) { page.modifyTime.val(data.modifyTime);} // time
    if (data.opportunitySource) { page.opportunitySource.val(data.opportunitySource)} // 机会来源
    if (data.opportunityDescrible) { page.opportunityDescrible.val(data.opportunityDescrible);}
    if (data.otherOpportunity) { page.otherOpportunity.val(data.otherOpportunity);}
    if (data.productLine) { page.productLine.val(data.productLine);}
    if (data.registeredAddress) { page.registeredAddress.val(data.registeredAddress);}
    if (data.registeredFunds) { page.registeredFunds.val(data.registeredFunds);}
    if (data.shortName) { page.shortName.val(data.shortName);}
    if (data.zhongxinbaoLevel) { page.zhongxinbaoLevel.val(data.zhongxinbaoLevel);}
    if (data.zhongxinbaoNumber) { page.zhongxinbaoNumber.val(data.zhongxinbaoNumber);}
    // if (data.customerLevel) { page.customerLevel.val(data.customerLevel);}
    if (data.remark) { page.remark.val(data.remark);}
    if (data.factoryLocation) { page.factoryLocation.val(data.factoryLocation);}
    if (data.managementScope) { page.managementScope.val(data.managementScope);}

    // 新加字段
    if (data.formatdoc) { page.formatdoc.val(data.formatdoc);} // 数据格式
    // if (data.formatdocName) { page.formatdoc.val(data.formatdocName);}
    if (data.custclass) { page.custclass.data('val',data.custclass);} // 客户基本分类
    if (data.custclassName) { page.custclass.val(data.custclassName);}
    if (data.timezone) { page.timezone.data('val',data.timezone);} // 时区
    if (data.timezoneName) { page.timezone.val(data.timezoneName);}
    if (data.countryzone) { page.countryzone.data('val',data.countryzone);} // 贸易国别
    if (data.countryzoneName) { page.countryzone.val(data.countryzoneName);}

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
    page.encyUrl += '?customerId=' + data.customerId + (data.encyId!=undefined? '&encyId=' + data.encyId : '');
};

// 重置表单
CRM.cbInfo.resetForm = function (id) {
    $('input,textarea,select',$(id)).val('');
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


        CRM.insertHtml('#crlBtn',$('#funBtn')); // 渲染功能按钮 非新增

        if (page.status==='l') { // 潜在

            CRM.cbInfo.lInitHandler();
        }else if (page.status==='c') { // 合作

            CRM.cbInfo.cInitHandler();
        }else if (page.status==='r') { // 流失

            CRM.cbInfo.rInitHandler();
        }

        page.renderPage(page.cid); // 渲染页面

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

    // 渲染地区树
    CRM.ajaxCall({
        url:CRM.url.AREA_TREE_GET,
        type:'GET',
        callback:function (res) {
            page.areaTree = res[0].nodes; // 将取到的树数据赋值给对象属性，下次有的话就不用再发请求了
            page.renderTree(page.areaTree, 'areaId', '——请选择地区——');
        }
    });
    // 渲染数据格式下拉框
    CRM.ajaxCall({
        url:'/customerBaseInfo/getFormatdoc',
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
CRM.cbInfo.vDeploy= function () {

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
};

// 返回对象
CRM.cbInfo.pVerify = function (em) {

    // 配置验证规格和显示消息
    var mainForm=$('#myForm').validate({
        onfocusout: function(element) {
            $(element).valid();
        },
        rules: {
            fullName: "required",
            areaId: 'required',
            countryId: 'required',
            "enterpriseNature": {
                required : true
            },
            enterprisePhone:'digits',
            enterpriseEmail:'email',
            showFactory: 'required',
            showMajorCompetitorsGroup: {
                required: "#aa:checked"
            },
            customerLevel:'required',
            opportunitySource:{
                required:'#showOpportunity:checked'
            },
            opportunityDescrible:{
                required:'#showOpportunity:checked'
            }

        },
        messages: {
            fullName: {
                required:em('必填','top:-29px','right:0')
            },
            areaId: {
                required:em('请选择一个值','top:-29px','right:0')
            },
            countryId: {
                required:em('请选择一个值','top:-29px','right:0')
            },
            showFactory: {
                required:em('必填','top:-29px','right:0')
            },
            showMajorCompetitorsGroup: {
                required:em('必填','top:-29px','right:0')
            },
            enterpriseNature:{
                required:em('请选择一个值','top:-29px','left:-60px')
            },
            hasChiCompany:{
                required:em('请选择一个值','top:-29px','right:0')
            },
            hasChiPurchase:{
                required:em('请选择一个值','top:-29px','right:0')
            },
            customerLevel:{
                required:em('请选择一个值','top:-29px','right:0')
            },
            enterprisePhone:em('请输入有效的电话','top:-29px','right:0'),
            enterpriseEmail:em('请输入有效的邮箱','top:-29px','right:0'),
            opportunitySource:em('请选择一个值','top:-29px','right:0'),
            opportunityDescrible:em('请填写机会描述','top:-29px','right:0')
        }
    });

    return mainForm;
};

// 返回对象
CRM.cbInfo.mVerify = function (em) {

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
    var page = CRM.systemRoleManage;

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
                onClick: page.cbtTreeClick
            }
        },
        id = $('#cbtTree').attr('id'),
        treeObj = null,
        treeData = CRM.toArr(data);

    $.fn.zTree.init($('#cbtTree'), setting, treeData);
    treeObj = $.fn.zTree.getZTreeObj(id);
    treeObj.expandAll(true); // 默认展开
};

$().ready(function() {
    var page  = CRM.cbInfo,
        pForm = null,
        mForm = null;

    // 初始化
    page.init();
    pForm = page.pVerify(page.vDeploy());
    mForm = page.mVerify(page.vDeploy());

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
        page.renderPage(page.cid);
        pForm.form();
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

    // 根据选择的地区渲染国家下拉框
    $('#areaId').on('change.area',function () {
        var val = $(this).val(),
            counTree = page.getCounData(page.areaTree,val); // 获取国家树的数据

        page.renderTree(counTree, 'countryId', '——请优先选择地区——'); // 创建国家树
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

        if (page.status!='a') {

            CRM.ajaxCall({
                url:page.EDIT_POST,
                data:page.collectData(),
                contentType:"application/json",
                method:'POST',
                callback:function () {

                    page.renderPageHandler(page.cid);
                }
            });

        }else if (page.status=='a') {

            CRM.ajaxCall({
                url:page.ADD_POST,
                data:page.collectData(),
                contentType:"application/json",
                method:'POST',
                callback:function (data) {

                    self.location = basePath+'/customerBaseInfo/intoCustomerBaseInfoDetails?' +
                        'customerType=2&customerId='+ data.customerId;
                }
            });
        }

    });

    // 跳转百科编辑
    $('#encyEdit').on('click.ency',function () {

        window.open(basePath + page.encyUrl);
        return false;
    });

    // 时区下拉搜索框
    // $('#timeZone').on('input.tz',function () {
    //
    //
    // });

    $('#timeZone').on('input.tz',function () {

        if ($(this).val()!='') {
            var obj = {
                name: $(this).val()
            };
        }else {
            var obj = {
                name:'UTC'
            };
        }

        $('#tz').html('');
        CRM.ajaxCall({
            url:'/customerBaseInfo/getTimezone',
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

    // 贸易国别下拉搜索框
    $('#commerceCountry').on('input.cc',function () {

        if ($(this).val()!='') {
            var obj = {
                name:$(this).val()
            };
            $('#cc').html('');
            CRM.ajaxCall({
                url:'/customerBaseInfo/getCountryzone',
                type:'POST',
                contentType:'application/json',
                data:JSON.stringify(obj),
                callback:function (data) {
                    if (data) {
                        CRM.tplHandler('tzC',data,$('#cc'));
                    }
                }
            });
        }
    });

    // 点击国别下拉菜单，将值添加到文本框
    $('#cc').on('click.cc','a',function (e) {
        var val = $(e.target).data('val'),
            txt = $(e.target).text(),
            tarInput = $('#commerceCountry');

        tarInput.val(txt);
        tarInput.data('val',val);
        return false;
    });

    // 点击时区下拉菜单，将值添加到文本框
    $('#tz').on('click.cc','a',function (e) {
        var val = $(e.target).data('val'),
            txt = $(e.target).text(),
            tarInput = $('#timeZone');

        tarInput.val(txt);
        tarInput.data('val',val);
        return false;
    });

    // 点击客户基本分类查找按钮，弹出树形菜单
    $('#cbtSearch').on('click.tree',function () {
        CRM.ajaxCall({
            url:'/customerBaseInfo/getCustclass',
            type:'GET',
            callback:page.renderCBTTree
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

                    page.renderPageHandler(page.cid);
                }
            });

        }
    });

});




































// $(function () {
//
//     //创建面包屑导航
//     $('#location').append(createCrumbsD());
//
//     //设置title标题
//     var title = $('#pTitle').text()+'——'+$('#sTitle').text();
//     $('#hTitle').text(iGetInnerText(title));
//
//     //创建地区下拉框
//     var areaData = getAreaData();
//     creatAreaSelected(areaData,$('#areaId'));
//     $(document).on('change.screen','#areaId',function () {
//         var areaId = $('#areaId');
//         var countryId = $('#countryId');
//
//         //根据地区下拉框赋值创建国家下拉框
//         var areaIdVal = areaId.val();
//         creatCountrySelected(areaData,areaIdVal,countryId);
//     });
//
//     //新增页面——customerId为空字符串说明是新增页面
//     if($('#customerId').val()==''){
//         $('[name="customerType"]').val('2').attr('disabled','disabled');
//         $('button').filter(editBtn).remove();
//         $('.editHide').addClass('hidden');
//         $('.editView').removeClass('hidden');
//         var finishBtn = '';
//         finishBtn += '<div class="form-group">';
//         finishBtn += '<div class="col-xs-2 col-xs-offset-4">';
//         finishBtn += '<button id="resetForm" class="btn btn-block btn-default">重置</button></div>'
//         finishBtn += '<div class="col-xs-2">';
//         finishBtn += '<button id="upData" class="btn btn-block btn-primary" type="button">完成</button></div>';
//         finishBtn += '</div>';
//         $('.form-horizontal').append(finishBtn);
//         $(document).on('click.up','#upData',function () {
//             $.ajax({
//                 url:basePath+'/customerBaseInfo/doAddCustomerBaseInfo',
//                 type:'POST',
//                 contentType:"application/json",
//                 data: customerBasicFormObj()
//             }).done(function (result) {
//                 console.log(result.data);
//                 var customerId = result.data.customerId;
//                 $('#linkPot').attr('href','/customerBaseInfo/intoCustomerBaseInfoDetails?customerType=2&customerId='+ result.data.customerId);
//                 document.getElementById('linkPot').click();
//             })
//         });
//         $(document).on('click.reset','#resetForm',function () {
//            location.reload();
//         });
//     }else if($('#customerId').val()!=''){
//         init();
//         //获取初始数据
//         getData(basePath+'/customerBaseInfo/showCustomerBaseInfoDetails','POST',GetRequest(),customerBasicInfo);
//         //编辑客户基本信息
//         $(document).on('click.edit','editCustomerBasic',function () {
//             addDelBtn('customerMakeProduct','form-group');
//         });
//         //客户基本信息提交
//         $(document).on('click.up','#saveCustomerBasic',function(){
//             upData(basePath+'/customerBaseInfo/updateCustomerBaseInfo','POST',customerBasicFormObj(),"application/json");
//             delDelBtn();
//         });
//         //客户基本信息取消提交
//         $(document).on('click.cancel','#cancelCustomerBasic',function(){
//             //重新获取数据
//             location.reload();
//         });
//         $(document).on('click.edit','#editEncyclopedia',function () {
//             //添加删除按钮
//             addDelBtn('customField','form-group');
//         });
//         $(document).on('click.create','#addFiled',function () {
//             var container = $('#filedContainer');
//             container.html('');
//             var form = '';
//             form += '<div class="form-horizontal">';
//             form += '<div class="form-group">';
//             form += '<label for="" class="control-label col-xs-2">名称</label>';
//             form += '<div class="col-xs-4">';
//             form += '<input type="text" class="form-control" value=""></div></div>';
//             form += '<div class="form-group">';
//             form += '<label for="" class="control-label col-xs-2">内容</label>';
//             form += '<div class="col-xs-9">';
//             form += '<textarea class="form-control" name="" rows="8" value=""></textarea></div></div>';
//             form += '</div>';
//             container.append(form);
//         });
//         $(document).on('click.append','#up_cf',function () {
//             var place = $('#addFiled').parents('.form-group');
//             var container = $('#filedContainer');
//             var name = $('input',container).val();
//             var content = $('textarea',container).val();
//             var row = '';
//             row += '<div name="customField" class="form-group">';
//             row += '<label name="name" class="control-label col-xs-1" lang="zh">'+ name +'</label>';
//             row += '<div class="col-xs-8"><textarea name="value" class="form-control" rows="4">'+ content +'</textarea>';
//             row += '</div>';
//             place.before(row);
//             delDelBtn();
//             addDelBtn('customField','form-group');
//         });
//         $(document).on('click.up','#addEncyclopedia',function(){
//             //提交数据
//             upData(basePath+'/customerEncyclopedia/doModify','POST',customerEncyclopediaObj(),"application/json");
//             delDelBtn();
//         });
//         $(document).on('change','#customerType',function () {
//             var $this = $(this);
//             if($this.val()==3){
//                 $('#showReasons').click();
//                 var container = $('#reasons').find('.modal-body .form-group');
//                 var content = '';
//                 content += '<label class="control-label col-xs-2">流失原因分析</label>';
//                 content += '<div class="col-xs-9"><textarea class="form-control" rows="8"></textarea></div>';
//                 container.html('').append(content);
//             }
//         })
//     }
//
//     //button——添加产品
//     $(document).on('click.add','#addPro',function () {
//         var row = '';
//         row += '<div name="customerMakeProduct" class="form-group" style="position:relative;">';
//         row += '<label class="col-xs-1 control-label" style="position: relative">生产产品</label>';
//         row += '<div class="col-xs-2"><input name="productName" class="form-control" type="text" value=""></div>';
//         row += '<label class="col-xs-1  control-label">产能</label>';
//         row += '<div class="col-xs-2"><input name="production" class="form-control" type="text" value=""></div>';
//         row += '</div>';
//         $('#addPro').parents('.form-group').before(row);
//         delDelBtn();
//         addDelBtn('customerMakeProduct','form-group');
//         $('[name="customerMakeProduct"]').eq(0).find('button').remove();
//         $('[name="customerMakeProduct"]').each(function (n) {
//             var $this = $(this);
//             $this.find('label').eq(0).text(function () {
//                 return '生产产品'+parseInt(n+1);
//             })
//         })
//     });
//
//     //select||checkbox控制显示与隐藏
//     controlSOrH('#showOpportunity');
//     controlSOrH('#showOtherOpportunity');
//     controlSOrH('#showFactory');
//     controlSOrH('#showMajorCompetitorsGroup');
//     controlSOrH('#showOtherEnterpriceNature');
//
//     $(document).on('change.view','[name="customerType"]',function () {
//         controlSOrH('#showOpportunity');
//     });
//     $(document).on('change.view','#opportunitySource',function () {
//         controlSOrH('#showOtherOpportunity');
//     });
//     $(document).on('change.view','[name="enterpriseNature"]',function () {
//         controlSOrH('#showFactory');
//         controlSOrH('#showMajorCompetitorsGroup');
//         controlSOrH('#showOtherEnterpriceNature');
//     });
//
// });
//
// /**
//  * 删除按钮的添加和删除
//  */
// // function reorderPro(){
// //     $('[name="customerMakeProduct"]').find('label:first-child').html(function (n,old) {
// //         if(n!=0){
// //             return '<button type="button" class="close" data-form-btn="del" data-form-target="form-group" style="position: absolute;top: 3px;left: 24px;">×</button>生产产品' + parseInt(n+1);
// //         }
// //     });
// // }
// function addDelBtn(name,tar) {
//     var delBtn = '<button type="button" class="close" data-form-btn="del" data-form-target="'+tar+'" style="position:absolute;top:3px;left:25px;z-index:100;">×</button>';
//     $('[name="'+name+'"]').css('position','relative').prepend(delBtn);
// }
// function delDelBtn() {
//     $('button').filter('[data-form-btn="del"]').remove();
// }