/**
 * Created by Huxiangyang on 2017/4/6.
 */

CRM.productArchivesList   = window.CRM.productArchivesList || {};
CRM.url                   = window.CRM.url || {};
CRM.url.PRODUCT_INFO_DOWN = basePath + '/productInfo/getProductInfoById';
CRM.url.PRODUCT_INFO_UP   = basePath + '/productInfo/doModify';

CRM.productArchivesList.url = CRM.url.PRODUCT_INFO_DOWN;
CRM.productArchivesList.data = {id: 1011001};
CRM.productArchivesList.init = function () {
    var page = this,
        elView = $(CRM.el.EDIT_VIEW),
        elHide = $(CRM.el.EDIT_HIDE),
        elOff = $(CRM.el.OFF_CONTROL),
        res = {
            type: 'POST',
            contentType: 'application/json',
            upUrl: CRM.url.PRODUCT_INFO_UP,
            downUrl: CRM.url.PRODUCT_INFO_DOWN,
            upData: page.upProductInfo,
            downData: page.data,
            down: page.productInfoForm
        };

    CRM.showOrHide(elView, elHide, false);
    CRM.onOrOff(elOff, false);
    CRM.ajaxCall('POST', page.url, page.data, null, page.productInfoForm);

    var productInfo = new CRM.module.Panel('#productInfo', res);

    productInfo.panel.on('click.panel.edit',productInfo.edit,function (e) {
        productInfo.handleEdit(e);
    })
};

//获取数据
CRM.productArchivesList.productInfoForm = function (res) {
    var data = res,
        productInfo = data.productInfo,
        wares = data.wares,
        allProcessingComponents = data.allProcessingComponents,
        processingComponents = data.processingComponents,
        index = data.index,
        tr = '',
        pcisArr = [];

    //表单处理
    $('#productId').val(productInfo.productId);
    $('#categoryName').val(productInfo.categoryName);
    $('#name').val(productInfo.name);
    $('#measurement').val(productInfo.measurement);
    $('#concentration').val(productInfo.concentration);
    $('[name="saltType"]').val([productInfo.saltType]);
    $('#otherSaltName').val(productInfo.otherSaltName);
    $('#executeStandard').val(productInfo.executeStandard);
    $('#executeNumer').val(productInfo.executeNumer);
    $('#executeRemarks').val(productInfo.executeRemarks);
    $('#productFeature').val(productInfo.productFeature);
    $('#lastmodifyUserName').val(productInfo.lastmodifyUserName);
    $('#modifyTime').val(productInfo.modifyTime);

    //规格型号
    jQuery.each(wares, function (n, item) {
        tr += '<tr><td>' + item.specification + '</td>';
        tr += '<td>' + item.model + '</td></tr>';
    });
    $('#wares').append(tr);

    //加工成分
    if (allProcessingComponents instanceof Array && processingComponents instanceof Array) {
        tr = '';
        tr += '<tr><th class="text-center">是否需要</th>';
        tr += '<th class="text-center">原料</th>';
        tr += '<th class="text-center">单耗（kg/KL）</th>';
        tr += '<th class="text-center">备注</th></tr>';
        jQuery.each(allProcessingComponents, function (n, item) {
            tr += '<tr><td><input name="pcis" type="checkbox" disabled value="' + item.componentId + '"></td>';
            tr += '<td>' + item.componentName + '</td>';
            tr += '<td><input class="form-control" type="text" disabled value="' + item.unitCost + '"></td>';
            tr += '<td><input class="form-control" type="text" disabled value="' + item.remarks + '"></td></tr>';
        });
        $('#allProcessingComponents').html('').append(tr);
        jQuery.each(processingComponents, function (n, item) {
            pcisArr.push(item.componentId);
        });
        $('[name="pcis"]').val(pcisArr);
    } else {
        tr = '';
        tr = '<tr><td><textarea class="form-control">' + allProcessingComponents + '</textarea></td></tr>';
        $('#allProcessingComponents').html('').append(tr);
    }

    //理化指标
    if (index instanceof Array) {
        tr = '';
        tr += '<tr><th class="text-center">指标</th>';
        tr += '<th class="text-center">值</th>';
        tr += '<th class="text-center">备注</th></tr>';
        jQuery.each(index, function (n, item) {
//                console.log(item);
            tr += '<tr><td><input class="form-control" type="text" disabled value="' + item.index + '"></td>';
            tr += '<td><input class="form-control" type="text" disabled value="' + item.value + '"></td>';
            tr += '<td><input class="form-control" type="text" disabled value="' + item.remarks + '">';
            tr += '<button type="button" class="close hidden" data-form-btn="del" data-form-target="tr"' +
                ' style="position: absolute;top:6px;right:-15px;">×</button></td></tr>';
        });
        $('#index').append(tr);
    } else {
        tr = '';
        tr = '<tr><td><textarea class="form-control">' + index + '</textarea></td></tr>';
        $('#index').html('').append(tr);
    }
};

//提交数据
CRM.productArchivesList.upProductInfo = function () {
//            e.stopPropagation();
    var upData = {
        'productInfo': {
            'productId': $('#productId').val(),
            'categoryName': $('#categoryName').val(),
            'name': $('#name').val(),
            'measurement': $('#measurement').val(),
            'concentration': $('#concentration').val(),
            'executeStandard': $('#executeStandard').val(),
            'executeNumer': $('#executeNumer').val(),
            'executeRemarks': $('#executeRemarks').val(),
            'productFeature': $('#productFeature').val(),
            'modifyTime': CRM.getTime(),
            'saltType': $('[name="saltType"]:checked').val(),
            'otherSaltName': $('#otherSaltName').val(),
            'physicalProperities': getPPTable(),
        },
        'productComponents': getPCTable()
    };

//            console.log(upData);
    function getPPTable() {
        var p = content.find('[name="physicalProperities"]').find('tr');
        console.log(p.find('textarea').length);
        if (p.find('textarea').length != 1) {
            var arr = [];
            p.each(function () {
                var obj = {};
                $(this).find('td').each(function (n, td) {
                    if (n == 0) {
                        obj.index = $(td).children('input').val();
                    } else if (n == 1) {
                        obj.value = $(td).children('input').val();
                    } else {
                        obj.remarks = $(td).children('input').val();
                    }
                });
                arr.push(obj);
            });
            return JSON.stringify(arr);
        } else {
            return p.find('textarea').val();
        }
    }

    function getPCTable() {
        var p = content.find('[name="processingComponents"]').find('tr');
        if (p.find('textarea').length != 1) {
            var arr = [];
            p.each(function () {
                var obj = {};
                $(this).find('td').each(function (n, td) {
                    if (n == 0) {
                        obj.componentName = $(td).children('input').val();
                    } else if (n == 1) {
                        obj.consumption = $(td).children('input').val();
                    } else {
                        obj.remarks = $(td).children('input').val();
                    }
                });
                arr.push(obj);
            });
            return arr;
        } else {
            return p.find('textarea').val();
        }
    }

};

CRM.productArchivesList.init();

$('#tree').creatTree(basePath + '/productCategory/CategoryTree');