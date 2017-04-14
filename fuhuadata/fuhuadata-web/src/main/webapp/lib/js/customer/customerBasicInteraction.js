/**
 * Created by huxiangyang on 2017/3/13.
 */


CRM.cbInfo   = window.CRM.cbInfo || {};
CRM.cbInfo.LOOK_POST     = '/customerBaseInfo/showCustomerBaseInfoDetails'; // 客户基本信息查看
CRM.cbInfo.EDIT_POST    = '/productInfo/doModify'; // 客户基本信息编辑

CRM.cbInfo.editView     = null; // 编辑状态下显示的标签
CRM.cbInfo.editHide     = null; // 编辑状态下隐藏的标签
CRM.cbInfo.elOff        = null; // 编辑状态下开启的控件
CRM.cbInfo.mainPanel    = $('#cbInfo'); // 主面板
CRM.cbInfo.form         = $('#myForm'); // 表单容器
CRM.cbInfo.factor       = $('#factory'); //工厂部分
CRM.cbInfo.mcg          = $('#majorCompetitorsGroup'); // 竞争对手部分
CRM.cbInfo.oppo         = $('#opportunity'); // 机会部分
CRM.cbInfo.cmp          = 'cmp'; // 生产产品(循环加载)
CRM.cbInfo.status       = null; // 页面状态
CRM.cbInfo.isEdit       = false; // 页面是否可编辑 (默认不能编辑)

// 字典
CRM.cbInfo.cusTypes    = [{name:'潜在客户',val:'2'},{name:'合作客户',val:'1'},{name:'流失客户',val:'3'}];

// url接收的参数
CRM.cbInfo.cid = $('#cid').val(); // 客户id
CRM.cbInfo.ctp = $('#ctp').val(); // 客户状态
CRM.cbInfo.fname = $('#fname').val(); // 客户全称

// 按钮
CRM.cbInfo.edit        = $('#edit');
CRM.cbInfo.save        = $('#save');
CRM.cbInfo.cancel      = $('#cancel');
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
CRM.cbInfo.customerMakeProduct  = $('[name="customerMakeProduct"]'); // 客户生产产品 list
CRM.cbInfo.customerLevel        = $('#customerLevel'); // 客户等级
// CRM.cbInfo.customerStatus       = $('#customerStatus'); // 客户状态 0流失 1正常

// 收集数据
CRM.cbInfo.collectData = function () {
    var page = CRM.cbInfo,
        obj = {
            areaId               : page.areaId.val(),
            countryId            : page.countryId.val(),
            companyType          : page.companyType.val(),
            customerId           : page.customerId.val(),
            customerLevel        : page.customerLevel.val(),
            customerType         : page.customerType.val(),
            enterpriseEmail      : page.enterpriseEmail.val(),
            enterpriseNature     : page.enterpriseNature.val(),
            enterprisePhone      : page.enterprisePhone.val(),
            fullName             : page.fullName.val(),
            hasChiCompany        : page.hasChiCompany.val(),
            hasChiPurchase       : page.hasChiPurchase.val(),
            lastmodifyUserId     : page.lastmodifyUserId.val(),
            majorCompetitors     : page.majorCompetitors.val(),
            modifyTime           : page.modifyTime.val(),
            opportunityDescrible : page.opportunityDescrible.val(),
            otherOpportunity     : page.otherOpportunity.val(),
            productLine          : page.productLine.val(),
            registeredAddress    : page.registeredAddress.val(),
            registeredFunds      : page.registeredFunds.val(),
            shortName            : page.shortName.val(),
            zhongxinbaoLevel     : page.zhongxinbaoLevel.val(),
            zhongxinbaoNumber    : page.zhongxinbaoNumber.val(),
            customerMakeProduct  : page.customerMakeProduct.val(),
            customerLevel        : page.customerLevel.val()
        };

    return JSON.stringify(obj);
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

// 页面渲染程序
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

// 渲染页面逻辑处理程序
CRM.cbInfo.renderPageHandler = function (id) {
    var page = CRM.cbInfo;

    CRM.ajaxCall({
        url:page.LOOK_POST,
        type:'POST',
        data:{
            customerId:id
        },
        callback:function (data) {
            var counTree = page.getCounData(page.areaTree,data.areaId); // 获取国家树的数据
            page.renderTree(counTree, 'countryId', '——请优先选择地区——'); // 创建国家树
            page.renderForm(data); // 渲染页面表单
            page.isView(); // 根据表单的值显示或隐藏元素
            page.togglePage(page.isEdit); // 禁用和隐藏开关
        }
    });
};

// 渲染表单处理程序
CRM.cbInfo.renderForm = function(data){
    var page = CRM.cbInfo;

    page.areaId.val(data.areaId);
    page.countryId.val(data.countryId);
    page.companyType.val(data.companyType);
    page.customerId.val(data.customerId);
    page.customerLevel.val(data.customerLevel);
    page.customerType.val(data.customerType);
    page.enterpriseEmail.val(data.enterpriseEmail);
    page.enterpriseNature.val(data.enterpriseNature.split(',')); // checkbox
    page.enterprisePhone.val(data.enterprisePhone);
    page.fullName.val(data.fullName);
    page.hasChiCompany.val(data.hasChiCompany);
    page.hasChiPurchase.val(data.hasChiPurchase);
    page.lastmodifyUserId.val(data.lastmodifyUserId);
    page.majorCompetitors.val(data.majorCompetitors);
    page.modifyTime.val(data.modifyTime.split(/\s/)[0]); // time
    page.opportunityDescrible.val(data.opportunityDescrible);
    page.otherOpportunity.val(data.otherOpportunity);
    page.productLine.val(data.productLine);
    page.registeredAddress.val(data.registeredAddress);
    page.registeredFunds.val(data.registeredFunds);
    page.shortName.val(data.shortName);
    page.zhongxinbaoLevel.val(data.zhongxinbaoLevel);
    page.zhongxinbaoNumber.val(data.zhongxinbaoNumber);
    page.customerMakeProduct.val(data.customerMakeProduct);
    page.customerLevel.val(data.customerLevel);

    CRM.tplHandler('cmp',data.customerMakeProduct,$('#cmpC'));
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

// 判断是否隐藏
CRM.cbInfo.isView = function () {
    var page = CRM.cbInfo;

    CRM.showOrHide(page.factor, null, $('#showFactory').prop('checked'));
    CRM.showOrHide(page.mcg, null, $('#showMajorCompetitorsGroup').prop('checked'));
    CRM.showOrHide(page.oppo, null, $('#showOpportunity').prop('checked'));
    CRM.showOrHide(page.otherEnterpriceNature, null, $('#showOtherEnterpriceNature').prop('checked'));
    CRM.showOrHide(page.otherOpportunity, null, $('#showOtherOpportunity').prop('checked'));
};

// 转换页面状态
CRM.cbInfo.togglePage = function (isE) {
    var page = CRM.cbInfo;

    // 等页面渲染完了再赋值
    page.editView = $(CRM.el.EDIT_VIEW);
    page.editHide = $(CRM.el.EDIT_HIDE);
    page.elOff    = $(CRM.el.OFF_CONTROL);

    // 禁用和隐藏的元素
    CRM.showOrHide(page.editView, page.editHide, isE);
    CRM.onOrOff(page.elOff, isE);

    if (isE === true) {

        isE = false;
    }else {

        isE = true;
    };
};

// 初始化页面
CRM.cbInfo.init = function () {
    var page   = this,
        status = null;

    page.returnStatus(); // 返回页面状态
    // status = page.status;

    if (page.status!=='a') {


        CRM.insertHtml('#crlBtn',$('#funBtn')); // 渲染功能按钮 非新增

        if (page.status==='l') {

            CRM.cbInfo.lInitHandler();
        }else if (page.status==='c') {

            CRM.cbInfo.cInitHandler();
        }else if (page.status==='r') {

            CRM.cbInfo.rInitHandler();
        }

        page.renderPage(page.cid); // 渲染页面

    }else {

        CRM.cbInfo.aInitHandler();
    }

};


// 新增客户初始化程序
CRM.cbInfo.aInitHandler = function () {
    var page = CRM.cbInfo;
    CRM.insertHtml('#al',page.customerType); // 渲染cusotmerType表单控件
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

    // 配置错误信息容器
    $.validator.setDefaults({
        errorElement: 'div'
    });

    // 配置错误信息
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
            otherEnterpriceNature:{
                required:'#showOtherEnterpriceNature:checked'
            },
            opportunitySource:{
                required:'#showOpportunity:checked'
            },
            opportunityDescrible:{
                required:'#showOpportunity:checked'
            },
            otherOpportunity:{
                required:'#showOtherOpportunity:checked'
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
            otherEnterpriceNature:em('请填写其他企业性质','top:-29px','left:400px'),
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
            reason: em('其输入流失原因','top:-29px','right:0')
        }
    });

    return rea;
};

$().ready(function() {
    var page  = CRM.cbInfo,
        pForm = null,
        mForm = null;

    page.init();
    pForm = page.pVerify(page.vDeploy());
    mForm = page.mVerify(page.vDeploy());











    // 编辑
   /* page.edit.on('click.e',function () {

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
    });*/

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