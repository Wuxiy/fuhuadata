/**
 * Created by Huxiangyang on 2017/4/14.
 */

CRM.enc = window.CRM.enc || {};

// 页面状态
CRM.enc.status = '';

// url
CRM.enc.INFO_LOOK_GET = '/customerEncyclopedia/getById';
CRM.enc.UP_DATA_POST = '/customerEncyclopedia/doModify';
CRM.enc.ADD_DATA_POST = '/customerEncyclopedia/doAddCustomerEncyclopedia';

// 隐藏域
CRM.enc.nature     = $('#nature');
CRM.enc.encyId     = $('#encyId');
CRM.enc.customerId = $('#customerId');

// script容器
CRM.enc.cumC = 'cumC';

// tree 数据
CRM.enc.areaTree = null;

// 表单控件
CRM.enc.fullName              = $('#fullName');
CRM.enc.shortName             = $('#shortName');
CRM.enc.companyType           = $('#companyType');
CRM.enc.customerArea          = $('#areaId');
// CRM.enc.customerAreaId        = $('#areaId');
// CRM.enc.country               = $('#country');
// CRM.enc.countryId             = $('#countryId');
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
        url:page.INFO_LOOK_GET + '?encyId=' + page.encyId.val(),
        type:'GET',
        callback:function (data) {
            page.renderInfo(data);
            page.isView();
        }
    })
};



// 编辑状态，用custoemrId初始化
CRM.enc.editInitByCus = function () {
    var page = CRM.enc;

    CRM.ajaxCall({
        url:'/customerBaseInfo/getCustomerInfoEncy?customerId='+ page.customerId.val(),
        type:'POST',
        contentType:'application/json',
        callback : function (data) {

            page.renderInfo(data);
            // page.isView(); // 根据表单的值显示或隐藏元素
        }
    });
};

// 编辑状态，用encyId初始化
CRM.enc.editInitByEncy = function (id) {
    var page = CRM.enc;

    CRM.ajaxCall({
        url  : page.INFO_LOOK_GET + '?encyId=' + page.encyId.val(),
        type : 'GET',
        callback : function (data) {

            page.renderInfo(data);
            // page.isView(); // 根据表单的值显示或隐藏元素
        }
    });

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

    // page.customerId.val(data.customerId);
    // page.customerArea.data('val',data.customerArea); // 地区id
    // page.country.val(data.country); // 国家
    // page.customerAreaId.val(data.customerAreaId); // 地区id
    // page.countryId.val(data.countryId); // 国家id

    page.customerArea.val(data.customerArea); // 地区name
    page.fullName.val(data.fullName);
    page.shortName.val(data.shortName);
    page.companyType.val(data.companyType);

    if (data.enterpriseNature) {

        page.enterpriseNature.val(data.enterpriseNature.split(',')); // checkbox
    }
    page.registeredFund.val(data.registeredFunds);
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

// 表单重置
CRM.enc.resetMyForm = function() {
    $('textarea, input, select','#myForm').val('');
    $('input[type="checkbox"]','#myForm').val([]);
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
            // var isNot = page.isRenderTree();
            // if (isNot) {
            //
            //     page.renderEditPageHandler(page.encyId.val());
            // }else {
            //
            //     page.renderTree(page.encyId.val());
            // }
            $('#skipM').modal('show');
            $('#skip').attr('href', function (i,old) {
                return old + page.encyId.val();
            })
        }
    });
};

// 新增数据
CRM.enc.addData = function () {
    var page = CRM.enc;
    CRM.ajaxCall({
        url  : page.ADD_DATA_POST,
        data : page.collectAData(),
        type : 'POST',
        contentType:'application/json',
        callback: function (data) {
            // var isNot = page.isRenderTree();
            // if (isNot) {
            //
            //     page.renderEditPageHandler(page.encyId.val());
            // }else {
            //
            //     page.renderTree(page.encyId.val());
            // }
            $('#skipM').modal('show');
            // $('#skip').attr('href', function (i,old) {
            //     return old + data.encyId;
            // })
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

// 收集新增提交的数据
CRM.enc.collectAData = function () {
    var page = CRM.enc,
        obj = {
            customerId:page.customerId.val(),
            fullName:page.fullName.val(),
            shortName:page.shortName.val(),
            companyType:page.companyType.val(),
            customerAreaId:page.customerAreaId.val(),
            countryId:page.countryId.val(),
            registeredFund:page.registeredFund.val(),
            registeredAddr:page.registeredAddr.val(),
            managementScope:page.managementScope.val(),
            enterpriceNatures:page.getNature(),
            companyInfo:page.companyInfo.val(),
            developHis:page.developHis.val(),
            sellNetwork:page.sellNetwork.val(),
            lastmodifyUserId:page.lastmodifyUserName.val(),
            createTime:CRM.getTime(),
            modifyTime:CRM.getTime(),
            customField:page.getCusFieList()
        };
    return JSON.stringify(obj);
};

// 获取企业性质的数据
CRM.enc.getNature = function () {
    var page = CRM.enc,
        arr  = [];
    page.enterpriseNature.filter(':checked').each(function () {
        var obj = {
            nature:1,
            type:$(this).val()
        };
        arr.push(obj);
    });
    return arr;
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
CRM.enc.getStatus = function (status) {
    var page = CRM.enc;

    if (page.nature.val()==='info' && page.encyId.val()!=='') {

        return status = 'info';
    }else if (page.nature.val()==='edit' && page.encyId.val()!=='') {

        return status = 'edit';
    }else if (page.nature.val()==='edit' && page.encyId.val()==='' ) {

        return status = 'add';
    }
};

// 渲染编辑页面处理程序（两种情况）
// CRM.enc.renderEditPageHandler = function (id) {
//     var page = CRM.enc;
//
//     if (page.status==='edit' && page.encyId.val()!=='') {
//
//         CRM.ajaxCall({
//             url  : page.INFO_LOOK_GET + '?encyId=' + id,
//             type : 'GET',
//             callback : function (data) {
//                 // data.customerAreaId
//                 var counTree = page.getCounData(page.areaTree,data.customerAreaId); // 获取国家树的数据
//
//                 page.renderTreeHandler(counTree, 'countryId', '——请优先选择地区——'); // 创建国家树
//                 page.renderInfo(data);
//                 page.isView(); // 根据表单的值显示或隐藏元素
//             }
//         });
//
//     }else if (page.status==='edit' && page.customerId.val()!=='' && page.encyId.val()==='') {
//
//         CRM.ajaxCall({
//             url:'/customerBaseInfo/getCustomerInfoEncy?customerId='+ id,
//             type:'POST',
//             contentType:'application/json',
//             callback:function (data) {
//                 var counTree = page.getCounData(page.areaTree,data.customerAreaId); // 获取国家树的数据
//
//                 page.renderTreeHandler(counTree, 'countryId', '——请优先选择地区——'); // 创建国家树
//                 page.renderInfo(data);
//                 page.isView(); // 根据表单的值显示或隐藏元素
//             }
//         });
//
//     }
//
// };

// 是否有树的数据，有的话直接渲染，然后返回true，没有返回false
// CRM.enc.isRenderTree = function (id) {
//     var page = CRM.enc;
//
//     if (page.areaTree) {
//
//         return true;
//     }else {
//
//         return false;
//     }
// };

// 先获取数据再，渲染下拉框
// CRM.enc.renderTree = function (id) {
//     var page = CRM.enc;
//
//     // 没有数据，先请求渲染下拉框，再请求渲染页面
//     CRM.ajaxCall({
//         url:CRM.url.AREA_TREE_GET,
//         type:'GET',
//         callback:function (res) {
//             page.areaTree = res[0].nodes; // 将取到的树数据赋值给对象属性，下次有的话就不用再发请求了
//             page.renderTreeHandler(page.areaTree, 'areaId', '——请选择地区——');
//
//             if (id) {
//                 page.renderEditPageHandler(id);
//             }
//         }
//     });
// };

// 返回下拉框内容
// CRM.enc.getOption = function(data){
//     var options = '';
//     $.each(data,function (n,area) {
//         options += '<option value="'+area.cid+'">'+area.cname+'</option>';
//     });
//     return options;
// };

// 渲染树下拉框处理程序
// CRM.enc.renderTreeHandler = function (data, el, fitem) {
//     var page    = CRM.enc,
//         fOptons = '<option value="">' + fitem + '</option>',
//         options = fOptons + page.getOption(data);
//
//     $('#'+el).html(options);
// };

// 根据地区id取得国家树的数据
// CRM.enc.getCounData = function (data,id) {
//     var res = null;
//
//     if (id) {
//
//         $.each(data,function (i,item) {
//
//             if (item.cid==id) {
//
//                 res = item.nodes;
//                 return false;
//             }else {
//
//                 return true;
//             }
//         });
//
//     }else {
//         res = [];
//     }
//
//     return res;
// };

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


    if (page.encyId.val()!=='' && page.customerId.val()===''){ // 有百科id的

        CRM.ajaxCall({
            url  : page.INFO_LOOK_GET + '?encyId=' + page.encyId.val(),
            type : 'GET',
            callback : function (data) {

                page.renderInfo(data);
                page.isView(); // 根据表单的值显示或隐藏元素
            }
        });
    }else if (page.encyId.val()==='' && page.customerId.val()!=='') {


    }else {



    }







    var status = page.getStatus(page.status); // 判断页面的状态

    if (status==='info') { // 查看状态

        page.infoInit();

    }else if (status==='edit') { // 编辑状态

        page.editInitByEncy();

        // 点击完成按钮
        $('#upBtn').on('click.edit',function () {

            page.upEData();

            // if (page.encyId.val()!=='') { // 有百科id做编辑处理
            //
            //     page.upEData();
            // }else { // 没有百科id做新增处理
            //
            //     page.addData();
            // }

        });

        // 点击重置按钮
        $('#resetBtn').on('click.edit',function () {

            $('textarea','#editTextarea').val('');
        });

    }else if (status==='add') { // 新增状态

        page.addInit();

        // 选中其他显示文本框
        // $(document).on('change','[name="enterpriseNature"]',function () {
        //
        //     if ($('#showOtherNature').prop('checked')) {
        //         $('#otherEnterpriceNature').removeClass('hidden');
        //     }else {
        //         $('#otherEnterpriceNature').addClass('hidden');
        //     }
        // });

        // 选中地区，切换国家
        // $('#areaId').on('change.area',function () {
        //     var val = $(this).val(),
        //         isRender = page.isRenderTree();
        //     if (isRender) {
        //
        //         var counTree = page.getCounData(page.areaTree,val); // 获取国家树的数据
        //         page.renderTreeHandler(counTree, 'countryId', '——请优先选择地区——'); // 创建国家树
        //     }else {
        //
        //         page.renderTree();
        //         var counTree = page.getCounData(page.areaTree,val); // 获取国家树的数据
        //         page.renderTreeHandler(counTree, 'countryId', '——请优先选择地区——'); // 创建国家树
        //     }
        //
        // });

        // 企业全称搜索框,值改变时渲染下拉菜单
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
                        }
                    }
                });
            }
        });

        // 点击下拉菜单渲染数据
        $('#cName').on('click','a',function (e) {
            var page = CRM.enc,
                thisId = $(e.target).data('id');
                page.customerId.val(thisId);

            CRM.ajaxCall({
                url:'/customerBaseInfo/getCustomerInfoEncy?customerId='+thisId,
                type:'POST',
                contentType:'application/json',
                callback:function (data) {
                    // 如果有encyId则跳转到详情页面，没有则渲染本页面数据
                    if (data.encyId) {

                        self.location = basePath+'/customerEncyclopedia/modify?encyId='+ data.encyId;
                    }else {
                        page.resetMyForm(); // 渲染前先重置

                        page.renderInfo(data);
                        page.isView(); // 根据表单的值显示或隐藏元素
                    }
                }
            });
        });

        // 表单验证
        var myForm = page.verify();

        // 点击完成，提交
        $('#upBtn').on('click.add',function () {

            if (myForm.form()) {

                page.addData();
            }

        });

        $('#resetBtn').on('click.edit',function () {

            $('textarea, input, select','#myForm').val('');
            $('input[type="checkbox"]','#myForm').val([]);
        });

    }// 新增处理完


    // 添加自定义内容
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

    // 删除自定义
    $(document).on('click.del','[data-btn="del"]',function () {
        var $this = $(this),
            tar   = $this.data('target');

        $(this).closest(tar).remove();
    });
    
    // 返回
    $('#backPage').on('click.back',function () {

        window.history.back(-1);
    });

    // 跳转
    $('#skip').on('click.back',function () {
        window.history.back(-1);
        return false;
    });

    // 点击地区分类查找按钮，弹出树形菜单
    $('#aISearch').on('click.tree',function () {

        if (treeData==null) {

            CRM.ajaxCall({
                url:'/customerBaseInfo/initAreaCategoryTree',
                type:'GET',
                callback:renderAreaTree
            });
        }
    });


    // 国家搜索框，获取焦点时渲染下拉菜单
    // $('#countryS').on('focus.cc',function () {
    //
    //
    //     CRM.ajaxCall({
    //         url:'/customerBaseInfo/getCountryzone',
    //         type:'POST',
    //         contentType:'application/json',
    //         data:JSON.stringify({
    //             name:''
    //         }),
    //         callback:function (data) {
    //             if (data) {
    //                 CRM.tplHandler('tzC',data,$('#cc'));
    //             }
    //         }
    //     });
    // });

    // 国家搜索框，改变值时，渲染下拉框
    // $('#countryS').on('input.cc',function () {
    //
    //     var obj = {
    //         name:$(this).val()
    //     };
    //     $('#cc').html('');
    //     CRM.ajaxCall({
    //         url:'/customerBaseInfo/getCountryzone',
    //         type:'POST',
    //         contentType:'application/json',
    //         data:JSON.stringify(obj),
    //         callback:function (data) {
    //             if (data) {
    //                 CRM.tplHandler('tzC',data,$('#cc'));
    //             }
    //         }
    //     });
    // });

    // 国家搜索框，失去焦点清空搜索框
    // $('#countryS').on('blur.cc',function () {
    //
    //     $(this).val('');
    // });

    // 点击国家下拉菜单，将值添加到文本框
    // $('#cc').on('click.cc','a',function (e) {
    //     var elVal = $(e.target).data('val'),
    //         txt = $(e.target).text(),
    //         tarInput = $('#country');
    //
    //     tarInput.val(txt);
    //     tarInput.data('val',elVal);
    //     return false;
    // });

    // 点击地区搜索按钮，弹出树形菜单
    // $('#regSearch').on('click.tree',function () {
    //     if (treeData == null) {
    //
    //         CRM.ajaxCall({
    //             url:'/customerBaseInfo/initAreaCategoryTree',
    //             type:'GET',
    //             callback: renderAreaTree
    //         })
    //     }
    // });
});


/**
 *逻辑处理程序
 */
var treeData = null; // 保存树的数据

// 给地区树添加点击事件
function areTreeClick(event, modLeftId, treeNode) {
    var treeObj = $.fn.zTree.getZTreeObj('cbtTree'),
        node = treeObj.getSelectedNodes()[0];

    if (!node.isParent) {

        $('#areaId').val(treeNode.name);
        $('#areaId').data('val',treeNode.pkAreacl);
        $('#cbtModal').modal('hide');

    }else {
        alert('请选择子节点');
    }
}

// 渲染地区分类树
function renderAreaTree(data) {
    var setting = {
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
                onDblClick: areTreeClick
            }
        },
        treeData = data;

    $.fn.zTree.init($('#cbtTree'), setting, treeData);
}