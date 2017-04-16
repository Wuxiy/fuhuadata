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

// tree 数据
CRM.enc.areaTree = null;

// 表单控件
CRM.enc.fullName              = $('#fullName');
CRM.enc.shortName             = $('#shortName');
CRM.enc.companyType           = $('#companyType');
CRM.enc.customerArea          = $('#customerArea');
CRM.enc.customerAreaId        = $('#areaId');
CRM.enc.country               = $('#country');
CRM.enc.countryId             = $('#countryId');
CRM.enc.enterpriseNature      = $('[name="enterpriseNature"]'); // checkbox
CRM.enc.otherEnterpriceNature = $('#otherEnterpriceNature');
CRM.enc.registeredFund        = $('#registeredFund');
CRM.enc.registeredAddr        = $('#registeredAddr');
CRM.enc.managementScope       = $('#managementScope');
CRM.enc.companyInfo           = $('#companyInfo');
CRM.enc.developHis            = $('#developHis');
CRM.enc.sellNetwork           = $('#sellNetwork');
CRM.enc.customField           = null; // list-group
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

    page.renderTree(page.encyId.val());
};

// 新增初始化
CRM.enc.addInit = function () {
    var page = CRM.enc;

    page.renderTree();
    page.onEl();
    $(CRM.el.EDIT_VIEW).removeClass('hidden');
};

// 渲染详情页面
CRM.enc.renderInfo = function (data) {
    var page = CRM.enc;

    page.customerArea.val(data.customerArea); // 地区
    page.country.val(data.country); // 国家
    page.customerAreaId.val(data.customerAreaId); // 地区id
    page.countryId.val(data.countryId); // 国家id
    page.fullName.val(data.fullName);
    page.shortName.val(data.shortName);
    page.companyType.val(data.companyType);
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
CRM.enc.upEData = function () {
    var page = CRM.enc;
  CRM.ajaxCall({
      url  : page.UP_DATA_POST,
      data : page.collectEData(),
      type : 'POST',
      contentType:'application/json',
      callback: function (data) {
          var isNot = page.isRenderTree();
          if (isNot) {

              page.renderEditPageHandler(page.encyId.val());
          }else {

              page.renderTree(page.encyId.val());
          }
          $('#skipM').modal('show');
          $('#skip').attr('href', function (i,old) {
              return old + page.encyId.val();
          })
      }
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
            lastmodifyUserId:page.lastmodifyUserName.val(),
            modifyTime:CRM.getTime(),
            customField:page.getCusFieList()
        };
    return JSON.stringify(obj);
};

// 获取自定义列表的数据
CRM.enc.getCusFieList = function () {
    var page = CRM.enc,
        arr  = [];

    $('#cum').find('[name="customField"]').each(function () {
        var thisEl = $(this),
            obj = {
                name : thisEl.find('[name="na"]').text(),
                value: thisEl.find('[name="va"]').val()
            };
        arr.push(obj);
    });
    return JSON.stringify(arr);
};

// 启用页面元素
CRM.enc.onEl = function () {
    var page = CRM.enc;
    page.editEl  = $(CRM.el.ON_CONTROL);
    CRM.onOrOff(page.editEl,true);
};

// 是否隐藏其他文本框
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

// 渲染编辑页面处理程序
CRM.enc.renderEditPageHandler = function (id) {
    var page = CRM.enc;

    CRM.ajaxCall({
            url  : page.INFO_LOOK_GET + page.encyId.val(),
            type : 'GET',
        callback : function (data) {
            // data.customerAreaId
            var counTree = page.getCounData(page.areaTree,data.customerAreaId); // 获取国家树的数据

            page.renderTreeHandler(counTree, 'countryId', '——请优先选择地区——'); // 创建国家树
            page.renderInfo(data);
            page.isView(); // 根据表单的值显示或隐藏元素
        }
    });
};

// 是否有树的数据，有的话直接渲染，然后返回true，没有返回false
CRM.enc.isRenderTree = function (id) {
    var page = CRM.enc;

    if (page.areaTree) {

        return true;
    }else {

        return false;
    }
};

// 先获取数据再，渲染下拉框
CRM.enc.renderTree = function (id) {
    var page = CRM.enc;

    // 没有数据，先请求渲染下拉框，再请求渲染页面
    CRM.ajaxCall({
        url:CRM.url.AREA_TREE_GET,
        type:'GET',
        callback:function (res) {
            page.areaTree = res[0].nodes; // 将取到的树数据赋值给对象属性，下次有的话就不用再发请求了
            page.renderTreeHandler(page.areaTree, 'areaId', '——请选择地区——');

            if (id) {
                page.renderEditPageHandler(id);
            }
        }
    });
};

// 返回下拉框内容
CRM.enc.getOption = function(data){
    var options = '';
    $.each(data,function (n,area) {
        options += '<option value="'+area.cid+'">'+area.cname+'</option>';
    });
    return options;
};

// 渲染树下拉框处理程序
CRM.enc.renderTreeHandler = function (data, el, fitem) {
    var page    = CRM.enc,
        fOptons = '<option value="">' + fitem + '</option>',
        options = fOptons + page.getOption(data);

    $('#'+el).html(options);
};

// 根据地区id取得国家树的数据
CRM.enc.getCounData = function (data,id) {
    var res = null;

    if (id) {

        $.each(data,function (i,item) {

            if (item.cid==id) {

                res = item.nodes;
                return false;
            }else {

                return true;
            }
        });

    }else {
        res = [];
    }

    return res;
};

CRM.enc.verify = function () {
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

    // 配置验证规格和显示消息
    var mainForm=$('#myForm').validate({
        onfocusout: function(element) {
            $(element).valid();
        },
        rules: {
            fullName: "required",
            shortName: "required",
            companyType: 'required',
            areaId: 'required',
            countryId: 'required',
            enterpriseNature: {
                required : true
            },
            registeredFund:'required',
            registeredAddr:'required',
            managementScope: 'required',
            companyInfo: 'required'
        },
        messages: {
            fullName: {
                required:em('必填','top:-29px','right:0')
            },
            shortName: {
                required:em('必填','top:-29px','right:0')
            },
            companyType: {
                required:em('请选择一个值','top:-29px','right:0')
            },
            areaId: {
                required:em('请选择一个值','top:-29px','right:0')
            },
            countryId: {
                required:em('请选择一个值','top:-29px','right:0')
            },
            enterpriseNature:{
                required:em('至少选择一个','top:-29px','left:-60px')
            },
            registeredFund:{
                required:em('必填','top:-29px','right:0')
            },
            registeredAddr:{
                required:em('必填','top:-29px','right:0')
            },
            managementScope:{
                required:em('必填','top:-29px','right:0')
            },
            companyInfo:em('必填','top:-29px','right:0')
        }
    });

    return mainForm;
};


$(function () {
    var page = CRM.enc;

    page.getStatus(); // 判断页面的状态

    if (page.status==='info') {

        page.infoInit();

    }else if (page.status==='edit') {

        page.editInit();

        $('#upBtn').on('click.edit',function () {
            page.upEData();
        });

        $('#resetBtn').on('click.edit',function () {

            $('textarea','#editTextarea').val('');
        })
    }else if (page.status==='add') {

        page.addInit();
    }

    $('#submit').on('click.addItem',function () {
        var arr  = [],
            data = {
            name:$('input','#addField').val(),
            value:$('textarea','#addField').val()
        };
        arr.push(data);

        CRM.tplHandler(page.cumC,arr,$('#transit'));
        $('#cum').append($('#transit').html());
        // $('#addfield').modal('hide');
        $('input','#addField').val('');
        $('textarea','#addField').val('');
    });

    $(document).on('click.del','[data-btn="del"]',function () {
        var $this = $(this),
            tar   = $this.data('target');

        $(this).closest(tar).remove();
    });

    $(document).on('change','[name="enterpriseNature"]',function () {

        if ($('#showOtherNature').prop('checked')) {
            $('#otherEnterpriceNature').removeClass('hidden');
        }else {
            $('#otherEnterpriceNature').addClass('hidden');
        }
    });

    $('#areaId').on('change.area',function () {
        var val = $(this).val(),
            isRender = page.isRenderTree();
        if (isRender) {

            var counTree = page.getCounData(page.areaTree,val); // 获取国家树的数据
            page.renderTreeHandler(counTree, 'countryId', '——请优先选择地区——'); // 创建国家树
        }else {

            page.renderTree();
            var counTree = page.getCounData(page.areaTree,val); // 获取国家树的数据
            page.renderTreeHandler(counTree, 'countryId', '——请优先选择地区——'); // 创建国家树
        }

    });

    $('#fullName').on('input.fname',function () {

        if ($(this).val()!='') {
            var obj = {
                fullName:$(this).val()
            };
            $('#cName').html('');
            CRM.ajaxCall({
                url:'/customerBaseInfo/getCustomerBaseInfoByQuery',
                type:'POST',
                contentType:'application/json',
                data:JSON.stringify(obj),
                callback:function (data) {
                    if (data) {
                        CRM.tplHandler('cNameC',data,$('#cName'));
                        $('#cName').parent('div').addClass('open');
                    }else {
                        $('#cName').html('');
                        $('#cName').parent('div').removeClass('open');
                    }
                }
            });
        }else {
            $('#cName').html('');
            $('#cName').parent('div').removeClass('open');
        }
    });
    // $('#fullName').on('focusout.fname',function () {
    //     $('#cName').parent('div').removeClass('open');
    // });

    $('#cName').on('click','a',function (e) {
        var thisId = $(e.target).data('id');
        CRM.ajaxCall({
            url:'/customerBaseInfo/getCustomerInfoEncy',
            type:'POST',
            data:JSON.stringify({
                customerId:thisId
            }),
            contentType:'application/json',
            callback:function (data) {
                var counTree = page.getCounData(page.areaTree,data.customerAreaId); // 获取国家树的数据
                page.renderTreeHandler(counTree, 'countryId', '——请优先选择地区——'); // 创建国家树
                page.renderInfo(data);
                page.isView(); // 根据表单的值显示或隐藏元素
            }
        });
        // e.preventDefault();
    });
    page.verify();
});