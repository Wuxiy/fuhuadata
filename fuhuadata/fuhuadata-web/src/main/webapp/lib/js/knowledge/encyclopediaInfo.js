/**
 * Created by Huxiangyang on 2017/4/14.
 */

CRM.enc = window.CRM.enc || {};

// 页面状态
CRM.enc.status = '';

// url
CRM.enc.INFO_LOOK_GET = '/customerEncyclopedia/getById?encyId=';
CRM.enc.UP_DATA_POST = '/customerEncyclopedia/doModify';
CRM.enc.ADD_DATA_POST = '/customerEncyclopedia/doAddCustomerEncyclopedia';

// 隐藏域
CRM.enc.nature     = $('#nature');
CRM.enc.encyId     = $('#encyId');

// script容器
CRM.enc.cumC = 'cumC';


// 表单控件
CRM.enc.fullName              = $('#fullName');
CRM.enc.shortName             = $('#shortName');
CRM.enc.companyType           = $('#companyType');
CRM.enc.customerArea          = $('#customerArea');
CRM.enc.country               = $('#country');
CRM.enc.enterpriseNature      = $('[name="enterpriseNature"]'); // checkbox
CRM.enc.otherEnterpriceNature = $('#otherEnterpriceNature');
CRM.enc.registeredFund        = $('#registeredFund');
CRM.enc.registeredAddr        = $('#registeredAddr');
CRM.enc.managementScope       = $('#managementScope');
CRM.enc.companyInfo           = $('#companyInfo');
CRM.enc.developHis            = $('#developHis');
CRM.enc.sellNetwork           = $('#sellNetwork');
CRM.enc.customField           = $('[name="customField"]'); // list-group
CRM.enc.lastmodifyUserName    = $('#lastmodifyUserName');
CRM.enc.modifyTime            = $('#modifyTime');

// 详情初始化
CRM.enc.infoInit = function () {
 var page = CRM.enc;

    CRM.ajaxCall({
        url:page.INFO_LOOK_GET + page.encyId.val(),
        type:'GET',
        callback:function (data) {
            page.renderInfo(data);
            page.isView();
        }
    })
};

// 编辑初始化
CRM.enc.editInit = function () {
    var page = CRM.enc;

    CRM.ajaxCall({
        url:page.INFO_LOOK_GET + page.encyId.val(),
        type:'GET',
        callback:function (data) {
            page.renderInfo(data);
            page.offEl();
        }
    })
};

// 新增初始化
CRM.enc.addInit = function () {

};

// 渲染详情页面
CRM.enc.renderInfo = function (data) {
    var page = CRM.enc;

    page.fullName.val(data.fullName);
    page.shortName.val(data.shortName);
    page.companyType.val(data.companyType);
    page.customerArea.val(data.customerArea);
    page.country.val(data.country);
    page.enterpriseNature.val(data.enterpriseNature.split(',')); // checkbox
    page.registeredFund.val(data.registeredFund);
    page.registeredAddr.val(data.registeredAddr);
    page.managementScope.val(data.managementScope);
    page.companyInfo.val(data.companyInfo);
    page.developHis.val(data.developHis);
    page.sellNetwork.val(data.sellNetwork);
    page.lastmodifyUserName.val(data.lastmodifyUserName);
    page.modifyTime.val(data.modifyTime);

    if (data.customField) {

        CRM.tplHandler(page.cumC,JSON.parse(data.customField),$('#cum')); // list用百度模板处理
    }

    if (data.otherEnterpriceNature) {

        page.otherEnterpriceNature.val(data.otherEnterpriceNature);
    }

};

// 提交数据
CRM.enc.upData = function () {
    var page = CRM.enc;
  CRM.ajaxCall({

  })
};

// 收集编辑提交的数据
CRM.enc.collectEData = function () {
    var page = CRM.enc,
        obj = {
            encyId:page.encyId.val(),
            companyInfo:page.companyInfo.val(),
            developHis:page.developHis.val(),
            sellNetwork:page.sellNetwork.val(),
            lastmodifyUserName:CRM.getTime(),
            modifyTime:page.modifyTime.val(),
            customField:page.getCusFieList()
        };
    return JSON.stringify(obj);
};

// 获取自定义列表的数据
CRM.enc.getCusFieList = function () {
    var page = CRM.enc,
        arr  = [];
    $('#cum').find(page.customField).each(function () {
        var thisEl = $(this),
            obj = {
                name : thisEl.find('[name="na"]').text(),
                value: thisEl.find('[name="va"]').val()
            };
        arr.push(obj);
    });
    return JSON.stringify(arr);
};

// 禁用页面元素
CRM.enc.offEl = function () {
    var page = CRM.enc;
    page.editEl  = $(CRM.el.ON_CONTROL);
    CRM.onOrOff(page.editEl,false);
};

// 是否隐藏其他性质
CRM.enc.isView = function () {
    var page = CRM.enc;

    if (page.otherEnterpriceNature.val()==='') {

        page.otherEnterpriceNature.addClass('hidden');
    }else {

        page.otherEnterpriceNature.removeClass('hidden');
    }
};

// 返回当前页面的状态
CRM.enc.getStatus = function () {
    var page = CRM.enc;

    if (page.nature.val()==='info' && page.encyId.val()!=='') {

        page.status = 'info';
    }else if (page.nature.val()==='edit' && page.encyId.val()!=='') {

        page.status = 'edit';
    }else if (page.nature.val()==='edit' && page.encyId.val()==='') {

        page.status = 'add';
    }
};


$(function () {
    var page = CRM.enc;

    page.getStatus(); // 判断页面的状态

    if (page.status==='info') {

        page.infoInit();

    }else if(page.status==='edit') {

        page.editInit()

        $('#cplBtn').on('click.edit',function () {
            page.upData();
        });
    }


});