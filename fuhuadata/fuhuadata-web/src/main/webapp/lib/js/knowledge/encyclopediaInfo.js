/**
 * Created by Huxiangyang on 2017/4/14.
 */

CRM.enc = window.CRM.enc || {};

// 页面状态
CRM.enc.status = '';

// url
CRM.enc.INFO_LOOK_GET = '/customerEncyclopedia/getById?encyId=';

// 隐藏域
CRM.enc.nature     = $('#nature');
CRM.enc.encyId     = $('#encyId');;

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

CRM.enc.isView = function () {
    var page = CRM.enc;

    if (page.otherEnterpriceNature.val()==='') {

        page.otherEnterpriceNature.addClass('hidden');
    }else {

        page.otherEnterpriceNature.removeClass('hidden');
    }
};

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
    }else {

    }


});