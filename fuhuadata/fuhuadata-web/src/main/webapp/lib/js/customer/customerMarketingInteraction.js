/**
 * Created by huxiangyang on 2017/3/13.
 */

//
// // 指定文本框
// var selectedPName = null;
// var treeData = null;
// $(function () {
//
//     // init();
//
//     // 获取数据
//     CRM.ajaxCall({
//         url:basePath + '/customerMarketInfo/init',
//         type:'POST',
//         data:{
//             customerId:$('#customerId').val(),
//             customerType:$('#customerType').val(),
//             year:new Date().getFullYear()
//         },
//         callback:pop
//     });
//
//     // 构造下拉选择框
//     $('#cpps_year,#csps_year,#year').html(function (n,old) {
//         old = '<option value="">全部</option>';
//         var nowDate = new Date();
//         var nowYear = nowDate.getFullYear();
//         console.log(typeof nowYear);
//         var options = '';
//         for(var i=nowYear;i>=2014;i--){
//             options += '<option value="'+i+'">'+i+'</option>';
//         }
//         return old + options;
//     }).val(new Date().getFullYear());// 默认为今年
//
//     // 筛选客户采购产品
//     $(document).on('change.year','#cpps_year',function (e) {
//         var year = $(e.target).val(),
//             data = {
//                 year:year,
//                 customerId:$('#customerId').val(),
//                 customerType:$('#customerType').val()
//             };
//         CRM.ajaxCall({
//             url:basePath + '/customerMarketInfo/getCPPListByCidAndYear',
//             type:'POST',
//             data:data,
//             callback:cpps
//         });
//     });
//
//     // 筛选客户销售产品
//     $(document).on('change.year','#csps_year',function (e) {
//         var year = $(e.target).val(),
//             data = {
//                 year:year,
//                 customerId:$('#customerId').val(),
//                 customerType:$('#customerType').val()
//         };
//         CRM.ajaxCall({
//             url:basePath + '/customerMarketInfo/getSaleProductListByCidAndYear',
//             type:'POST',
//             data:data,
//             callback:csps
//         });
//     });
//
//     // 构造客户采购模态
//     $(document).on('click.addCpps','#add_cpps',function(){
//         var comBtn = $('[data-form-btn="complete"]');
//         $('#year').val($('#cpps_year').val()); // 重新选择year的值
//         $('#table').html(''); // 清空表格
//         $('#table').append(cppsTable()); // 重新填充表格
//         comBtn.attr('id','cpps_up'); // 变更完成按钮
//     });
//
//     // 构造客户销售模态
//     $(document).on('click.addCsps','#add_csps',function(){
//         var comBtn = $('[data-form-btn="complete"]');
//         $('#year').val($('#cpps_year').val()); // 重新选择year的值
//         $('#table').html(''); // 清空表格
//         $('#table').append(cspsTable()); // 重新填充表格
//         comBtn.attr('id','csps_up'); // 变更完成按钮
//     });
//
//     // 继续添加按钮
//     $(document).on('click.add','#addMore',function(){
//         var table = $('#table');
//         var colspanN = table.find('tr').first().find('th').length;
//         var comBtn = $('[data-form-btn="complete"]');
//         var tbody;
//         var delBtn = "";// 删除按钮
//         delBtn += '<tr>';
//         delBtn += '<td colspan="'+colspanN+'">';
//         delBtn += '<button class="btn btn-default btn-xs btn-block" data-form-btn="del" data-form-target="tbody">删除';
//         delBtn += '</button></td></tr>';
//         // 判断完成按钮的id
//         if(comBtn.attr('id')=='cpps_up'){
//             tbody = cppsTable();// 构造tbody
//             console.log(delBtn);
//             $(tbody).append(delBtn).appendTo(table);//插入到表格
//         }else{
//             tbody = cspsTable();
//             $(tbody).append(delBtn).appendTo(table);
//         }
//     });
//
//     // 客户采购产品批量提交
//     $(document).on('click.up','#cpps_up',function(e) {
//         var isUp=true;
//         var notNull = $(e.target).parents('.modal').find('input[required ]');
//         notNull.each(function () {
//             var thisVal = $(this).val();
//             if(thisVal==''|| thisVal==null){
//                 $('#errorM').modal('show');
//                 isUp = false;
//                 return false;
//             }
//         });
//         if(isUp){
//             CRM.ajaxCall({
//                 url:basePath + '/customerMarketInfo/addCPPList',
//                 type:'POST',
//                 data:cppsObj(),
//                 contentType:'application/json',
//                 callback: function () {
//                     // 刷新客户采购产品
//                     CRM.ajaxCall({
//                         url:basePath + '/customerMarketInfo/getCPPListByCidAndYear',
//                         type:'POST',
//                         data:{
//                             customerId:$('#customerId').val(),
//                             customerType:$('#customerType').val(),
//                             year:$('#cpps_year').val($('#year').val()).val()
//                         },
//                         callback:cpps
//                     });
//                     // 关闭模态
//                     $('#cusPro').modal('hide');
//                 }
//             });
//         }
//     });
//
//     // 客户销售产品批量提交
//     $(document).on('click.up','#csps_up',function(e) {
//         var isUp=true;
//         var notNull = $(e.target).parents('.modal').find('input[required ]');
//         notNull.each(function () {
//             var thisVal = $(this).val();
//             if(thisVal==''|| thisVal==null){
//                 $('#errorM').modal('show');
//                 isUp = false;
//                 return false;
//             }
//         });
//         if(isUp){
//             CRM.ajaxCall({
//                 url:basePath + '/customerMarketInfo/addCSPList',
//                 type:'POST',
//                 data:cspsObj(),
//                 contentType:'application/json',
//                 callback: function () {
//                     // 刷新客户销售产品
//                     CRM.ajaxCall({
//                         url:basePath + '/customerMarketInfo/getSaleProductListByCidAndYear',
//                         type:'POST',
//                         data:{
//                             customerId:$('#customerId').val(),
//                             customerType:$('#customerType').val(),
//                             year:$('#csps_year').val($('#year').val()).val()
//                         },
//                         callback:csps
//                     });
//
//                     // 关闭模态
//                     $('#cusPro').modal('hide');
//                 }
//             });
//         }
//     });
//
//     // 客户合作情况提交
//     $(document).on('click.up','#cooperation_up',function() {
//         CRM.ajaxCall({
//             url:basePath + '/customerMarketInfo/updateCooperationInfo',
//             type:'POST',
//             data:cooperationObj(),
//             contentType:'application/x-www-form-urlencoded; charset=UTF-8',
//             callback:function () {
//                 CRM.ajaxCall({
//                     url:basePath + '/customerMarketInfo/init',
//                     type:'POST',
//                     data:{
//                         customerId:$('#customerId').val(),
//                         customerType:$('#customerType').val(),
//                         year:new Date().getFullYear()
//                     },
//                     callback:pop
//                 });
//             }
//         });
//         // upData(basePath+'/customerMarketInfo/updateCooperationInfo','POST',cooperationObj(),'application/x-www-form-urlencoded; charset=UTF-8');
//     });
//
//     //客户合作情况取消
//     $(document).on('click','#cooperation_cl',function () {
//         //刷新
//         CRM.ajaxCall({
//             url:basePath + '/customerMarketInfo/init',
//             type:'POST',
//             data:{
//                 customerId:$('#customerId').val(),
//                 customerType:$('#customerType').val(),
//                 year:new Date().getFullYear()
//             },
//             callback:pop
//         });
//         // getData(basePath+'/customerMarketInfo/init','POST',GetRequest(),pop);
//     });
//
//
//     $(document).on('click','button[name="popupMd"]', function (e) {
//
//         $('#treeModal').modal('show');
//         selectedPName = $(e.target).parents('.input-group').find('input');
//
//         if (treeData==null) {
//
//             CRM.ajaxCall({
//                 url:basePath + '/productCategory/CategoryTree?fourNode=0',
//                 type:'GET',
//                 callback:renderTree
//             })
//         }
//     });
//
// });

var pageSize = 1; // 分页步长
var currentPageCpps = 0; // 采购表格当前页码
var currentPageCsps = 0; // 销售表格当前页码
var pdtTreeData = null; // 保存树的数据
var currentInput = null; // 当前文本框
var supplierId = []; // 待删除的供应商id
var countryId = []; // 待删除的目的国id

$(function(){

    /**
     * 公共
     */
    // 点击搜索按钮，弹出模态，并渲染产品树
    $(document).on('click.pop', '[name="searchPdt"]', function () {
        currentInput = $(this).closest('.input-group').find('[name="productName"]');

        $('#treeModal').modal('show');

        if(!pdtTreeData){ // 如果数据不存在，渲染产品树

            jQuery.ajax({
                url:basePath+'/productCategory/CategoryTree',
                type:'GET'
            }).done(function (res) {

                renderAreaTree(res.data,pdtTreeDblHandler,$('#tree'));
            });
        }
    });

    // 渲染年份下拉框
    $('[name="year"]').html(function (n,old) {

        var nowDate = new Date(),
            nowYear = nowDate.getFullYear(),
            options = '';

        for(var i=nowYear;i>=2014;i--){
            options += '<option value="'+i+'">'+i+'</option>';
        }
        return old + options;
    });

    // 点击删除供应商
    $('#add_modal, #edit_modal').on('click', 'button[data-btn="del"]' ,function () {

        if (confirm("您确定要删除吗？")) {

            var tarEl = $(this).closest($(this).data('target'));
            supplierId.push(tarEl.find('[name="name"]').data('id'));
            countryId.push(tarEl.find('[name="destinationCountry"]').data('id'));
            tarEl.remove();
        }
    });

    /**
     * 采购产品
     */
    // 初始化分页插件并渲染第一页数据
    serachCpps();

    // 搜索按钮绑定事件
    $("#searchCpps").click(function(){
        currentPageCpps = 0;
        serachCpps();
    });

    // 点击查看，弹出模态，并显示详情
    $('#cpps').on('click','[name="lookCppsDetails"]',function (e) {
        e.preventDefault();

        // 重置要删除的供应商id
        supplierId = [];

        // 渲染modal
        CRM.insertHtml('#cpps_modal_ct',$('#add_modal_content'));

        // 渲染年份
        $('#cpps_modal_year').html(function (n,old) {

            var nowDate = new Date(),
                nowYear = nowDate.getFullYear(),
                options = '';

            for(var i=nowYear;i>=2014;i--){
                options += '<option value="'+i+'">'+i+'</option>';
            }
            return old + options;
        });

        // 替换按钮
        $('#add_more_cpps').attr('id', 'del_pdt').text('删除产品');
        $('#cpps_up').attr('id', 'cpps_save').text('保存');

        $('#add_modal').modal('show');

        $.ajax({
            url:basePath + '/customer/market/purchase/products/' + $(this).data('id'),
            type:'POST'
        }).done(function (res) {
            var data = res.data;
            $('#cpps_modal_name').val(data.productName)
                .data('id', data.id)
                .data('val', data.productId);
            $('#primary_unit').val(data.measurement);
            $('#cpps_modal_year').val([data.year]);
            $('[name="annualDemands"]', $('#cpps_pdt_t')).val(data.annualDemands);
            $('[name="averagePrice"]', $('#cpps_pdt_t')).val(data.averagePrice);

            var firstItem = data.suppliers.shift(); // 供应商数组的第一项
            $('[name="supplier"]', $('#cpps_spr_t')).find('[name="name"]').val(firstItem.name).data('id', firstItem.id);
            $('[name="supplier"]', $('#cpps_spr_t')).find('[name="primaryUnit"]').val(firstItem.measurement);
            $('[name="supplier"]', $('#cpps_spr_t')).find('[name="amount"]').val(firstItem.amount);
            $('[name="supplier"]', $('#cpps_spr_t')).find('[name="priceAverage"]').val(firstItem.priceAverage);

            if (data.suppliers instanceof Array && data.suppliers.length > 0) {

                var res = {
                    data:data.suppliers
                },
                _html = bt('spr_bt',res);

                $('tbody', $('#cpps_spr_t')).append(_html);
            }
        });
    });

    // 点击页面删除
    $('#del_cpps').on('click', function () {
        var els = $('tbody', '#cpps').find('input').filter(':checked'),
            arr = [];

        els.each(function () {
            arr.push($(this).val());
        });

        delItem(arr, '/customer/market/purchase/products/delete', currentPageCpps, serachCpps);
    });

    // 点击重置
    $('#resetCpps').click(function () {
        currentPageCpps = 0;
        // serachCpps();
    });

    // 点击新增
    $('#add_cpps').click(function () {

        // 重置要删除的供应商id
        supplierId = [];

        $('#add_modal').modal('show');

        // 渲染modal
        CRM.insertHtml('#cpps_modal_ct',$('#add_modal_content'));

        // 渲染年份
        $('#cpps_modal_year').html(function (n,old) {

            var nowDate = new Date(),
                nowYear = nowDate.getFullYear(),
                options = '';

            for(var i=nowYear;i>=2014;i--){
                options += '<option value="'+i+'">'+i+'</option>';
            }
            return old + options;
        });

    });

    // 点击添加供应商
    $('#add_modal').on('click', '#add_spr', function () {

        var _html = $('#spr_ct').html();
        $('tbody', '#cpps_spr_t').append(_html);

        // 使增加的项，主单位和产品的住单位一致
        $('[name="primaryUnit"]','#add_modal').val($('#primary_unit').val());
    });

    // 点击保存并继续添加产品
    $('#add_modal').on('click', '#add_more_cpps', function () {

        $.ajax({
            url:basePath + '/customer/market/purchase/products',
            type:'POST',
            data:JSON.stringify(cppsUpData()),
            contentType:'application/json'
        }).done(function () {
            alert('添加成功!');

            // 刷新列表
            serachCpps();

            // 渲染modal
            CRM.insertHtml('#cpps_modal_ct', $('#add_modal_content'));

            // 渲染年份
            $('#cpps_modal_year').html(function (n, old) {

                var nowDate = new Date(),
                    nowYear = nowDate.getFullYear(),
                    options = '';

                for(var i=nowYear;i>=2014;i--){
                    options += '<option value="'+i+'">'+i+'</option>';
                }
                return old + options;
            });
        });

    });

    // 点击完成
    $('#add_modal').on('click', '#cpps_up' , function () {

        $.ajax({
            url:basePath + '/customer/market/purchase/products',
            type:'POST',
            data:JSON.stringify(cppsUpData()),
            contentType:'application/json'
        }).done(function () {
            alert('添加成功!');

            // 刷新列表
            serachCpps();

            // 关闭modal
            $('#add_modal').modal('hide');
        });
    });

    // 点击保存
    $('#add_modal').on('click', '#cpps_save' , function () {

        $.ajax({
            url:basePath + '/customer/market/purchase/products',
            type:'POST',
            data:JSON.stringify(cppsUpData()),
            contentType:'application/json'
        }).done(function () {
            alert('更改成功!');

            // 刷新列表
            serachCpps();

            // 关闭modal
            $('#add_modal').modal('hide');
        });
    });

    // 点击modal删除
    $('#add_modal').on('click', '#del_pdt', function () {
       var arr = [];

       arr.push($('#cpps_modal_name').data('id'));
       delItem(arr, '/customer/market/purchase/products/delete', currentPageCpps, serachCpps);
       $('#add_modal').modal('hide');
    });

    // 点击全选
    $('input[name="checkedAll"]', $('#cpps')).on('click', function () {
        var $this = $(this);
        if ($this.prop('checked')) {

            $('input[type="checkbox"]', $('#cpps')).prop('checked', true);
        }else {
            $('input[type="checkbox"]', $('#cpps')).prop('checked', false);
        }
    });

    /**
     * 销售产品
     */

    // 初始化分页插件并渲染第一页数据
    serachCsps();

    // 搜索按钮绑定事件
    $("#searchCsps").click(function(){
        currentPageCsps = 0;
        serachCsps();
    });

    // 点击查看，弹出模态，并显示详情
    $('#csps').on('click','[name="lookCspsDetails"]',function (e) {
        e.preventDefault();

        // 重置要删除的供应商id
        countryId = [];

        // 渲染modal
        CRM.insertHtml('#csps_modal_ct',$('#add_modal_content'));

        // 渲染年份
        $('#csps_modal_year').html(function (n,old) {

            var nowDate = new Date(),
                nowYear = nowDate.getFullYear(),
                options = '';

            for(var i=nowYear;i>=2014;i--){
                options += '<option value="'+i+'">'+i+'</option>';
            }
            return old + options;
        });

        // 替换按钮
        $('#add_more_csps').attr('id', 'del_pdt_o').text('删除产品');
        $('#csps_up').attr('id', 'csps_save_o').text('保存');

        $('#add_modal').modal('show');

        $.ajax({
            url:basePath + '/customer/market/sale/products/' + $(this).data('id'),
            type:'GET'
        }).done(function (res) {
            var data = res.data;
            $('#csps_modal_name').val(data.productName)
                .data('val', data.productId)
                .data('id', data.id);
            $('#primary_unit').val(data.measurement);
            $('#csps_modal_year').val([data.year]);
            $('[name="brand"]', $('#csps_pdt_t')).val(data.brand);
            $('[name="yearSalesTotal"]', $('#csps_pdt_t')).val(data.yearSalesTotal);
            $('[name="marketingMethod"]', $('#csps_pdt_t')).val(data.marketingMethod);

            var firstItem = data.countries.shift(); // 供应商数组的第一项
            $('[name="country"]', $('#csps_cty_t')).find('[name="destinationCountry"]').val(firstItem.destinationCountry).data('id', firstItem.id);
            $('[name="country"]', $('#csps_cty_t')).find('[name="primaryUnit"]').val(firstItem.measurement);
            $('[name="country"]', $('#csps_cty_t')).find('[name="amount"]').val(firstItem.yearSales);
            $('[name="country"]', $('#csps_cty_t')).find('[name="marketShare"]').val(firstItem.marketShare);

            if (data.countries instanceof Array && data.countries.length > 0) {

                var res = {
                        data:data.countries
                    },
                    _html = bt('cty_bt',res);

                $('tbody', $('#csps_cty_t')).append(_html);
            }
        });
    });

    // 点击页面删除
    $('#del_csps').on('click', function () {
        var els = $('tbody', '#csps').find('input').filter(':checked'),
            arr = [];

        els.each(function () {
            arr.push($(this).val());
        });

        delItem(arr, '/customer/market/sale/products/delete', currentPageCsps, serachCsps);
    });

    // 点击重置
    $('#resetCsps').click(function () {
        currentPageCsps = 0;
        // serachCpps();
    });

    // 点击新增
    $('#add_csps').click(function () {

        // 重置要删除的目的国id
        countryId = [];

        $('#add_modal').modal('show');

        // 渲染modal
        CRM.insertHtml('#csps_modal_ct',$('#add_modal_content'));

        // 渲染年份
        $('#csps_modal_year').html(function (n,old) {

            var nowDate = new Date(),
                nowYear = nowDate.getFullYear(),
                options = '';

            for(var i=nowYear;i>=2014;i--){
                options += '<option value="'+i+'">'+i+'</option>';
            }
            return old + options;
        });

    });

    // 点击添加目的国
    $('#add_modal').on('click', '#add_cty', function () {

        var _html = $('#cty_ct').html();
        $('tbody', '#csps_cty_t').append(_html);

        // 使增加的项，主单位和产品的住单位一致
        $('[name="primaryUnit"]','#add_modal').val($('#primary_unit').val());
    });

    // 点击保存并继续添加产品
    $('#add_modal').on('click', '#add_more_csps', function () {

        $.ajax({
            url:basePath + '/customer/market/sale/products',
            type:'POST',
            data:JSON.stringify(cspsUpData()),
            contentType:'application/json'
        }).done(function () {
            alert('添加成功!');

            // 刷新列表
            serachCsps();

            // 渲染modal
            CRM.insertHtml('#csps_modal_ct', $('#add_modal_content'));

            // 渲染年份
            $('#csps_modal_year').html(function (n, old) {

                var nowDate = new Date(),
                    nowYear = nowDate.getFullYear(),
                    options = '';

                for(var i=nowYear;i>=2014;i--){
                    options += '<option value="'+i+'">'+i+'</option>';
                }
                return old + options;
            });
        });

    });

    // 点击完成
    $('#add_modal').on('click', '#csps_up' , function () {

        $.ajax({
            url:basePath + '/customer/market/sale/products',
            type:'POST',
            data:JSON.stringify(cspsUpData()),
            contentType:'application/json'
        }).done(function () {
            alert('添加成功!');

            // 刷新列表
            serachCsps();

            // 关闭modal
            $('#add_modal').modal('hide');
        });
    });

    // 点击保存
    $('#add_modal').on('click', '#csps_save_o' , function () {

        $.ajax({
            url:basePath + '/customer/market/sale/products',
            type:'POST',
            data:JSON.stringify(cspsUpData()),
            contentType:'application/json'
        }).done(function () {
            alert('更改成功!');

            // 刷新列表
            serachCsps();

            // 关闭modal
            $('#add_modal').modal('hide');
        });
    });

    // 点击modal删除
    $('#add_modal').on('click', '#del_pdt_o', function () {
        var arr = [];

        arr.push($('#csps_modal_name').data('id'));
        delItem(arr, '/customer/market/sale/products/delete', currentPageCsps, serachCsps);
        $('#add_modal').modal('hide');

    });

    // 点击全选
    $('input[name="checkedAll"]', $('#csps')).on('click', function () {
        var $this = $(this);
        if ($this.prop('checked')) {

            $('input[type="checkbox"]', $('#csps')).prop('checked', true);
        }else {
            $('input[type="checkbox"]', $('#csps')).prop('checked', false);
        }
    });

    /**
     * 合作情况
     */
    getCoo($(customerId).val());

    // 编辑
    $('#cooperation').on('click', 'button[data-btn="edit"]', function () {
        $('.form-control', $('#cooperation')).attr('disabled',false);
        $('button[data-btn="edit"]', $('#cooperation')).addClass('hidden');
        $('button[data-btn="save"]', $('#cooperation')).removeClass('hidden');
        $('button[data-btn="cancel"]', $('#cooperation')).removeClass('hidden');
    });

    // 保存
    $('#cooperation').on('click', 'button[data-btn="save"]', function () {
        if (confirm('确定要保存吗？')) {
            $('.form-control', $('#cooperation')).attr('disabled', true);
            $('button[data-btn="edit"]', $('#cooperation')).removeClass('hidden');
            $('button[data-btn="save"]', $('#cooperation')).addClass('hidden');
            $('button[data-btn="cancel"]', $('#cooperation')).addClass('hidden');
            $.ajax({
                url:basePath + '/customer/market/coop/' + $('#customerId').val(),
                type:'POST',
                data:JSON.stringify(cooUpData()),
                contentType:'application/json'
            }).done(function (res) {
                if (res.code === 1) {
                    alert('保存成功!');
                    resetCoo();
                    getCoo($(customerId).val());
                }
            })
        }
    });

    // 删除
    $('#cooperation').on('click', 'button[data-btn="cancel"]', function () {
        if (confirm('确定要取消保存吗？')) {
            $('.form-control', $('#cooperation')).attr('disabled', true);
            $('button[data-btn="edit"]', $('#cooperation')).removeClass('hidden');
            $('button[data-btn="save"]', $('#cooperation')).addClass('hidden');
            $('button[data-btn="cancel"]', $('#cooperation')).addClass('hidden');
            resetCoo();
            getCoo($(customerId).val());
        }
    });
});



/**
 *以下是逻辑处理和数据处理函数
 */
// 渲染产品树
function renderAreaTree (data,callback,el) {

    var setting = {
            data: {
                simpleData: {
                    enable: true,
                    idKey: "id",
                    pIdKey: "pId",
                    rootPId: 0
                }
            },
            edit: {
                enable: false
            },
            callback: {
                onDblClick: callback
            }
        },
        treeObj = null;
    pdtTreeData = CRM.toArr(data);

    $.fn.zTree.init(el, setting, pdtTreeData);
    treeObj = $.fn.zTree.getZTreeObj('tree');
    treeObj.expandNode(treeObj.getNodes()[0],true);
}

// 产品树添加单击事件
function pdtTreeDblHandler (event, modLeftId, treeNode) {

    if (!/^c_/.test(treeNode.id)) {

        currentInput.val(treeNode.name);

        if (currentInput.attr('id')==='cpps_modal_name' || currentInput.attr('id')==='csps_modal_name') {

            currentInput.data('val', treeNode.id);

            // 获取主单位
            $.ajax({
                url:basePath+'/productInfo/getProductInfoById',
                type:'POST',
                data:{
                    id:treeNode.id
                }
            }).done(function (res) {
                var data = res.data.productInfo;
                $('#add_modal').find('[name="primaryUnit"]').val(data.measurement);
            });
        }

        $('#treeModal').modal('hide');
    }
    // console.log(/^c_/.test(treeNode.id));
}

// 搜索采购产品列表并渲染
function serachCpps(){

    // 获取参数
    /*var data = {
        customerId:$('#customerId').val(),
        name:$('#cpps_name').val(),
        year:$('#cpps_year').val(),
        startRow:currentPageCpps*pageSize,
        pageSize:pageSize
    };*/

    getCppsDataList(currentPageCpps, rederCppsLiset); // 初始化第一页数据

}

// 搜索销售产品列表并渲染
function serachCsps(){

    getCspsDataList(currentPageCsps, rederCspsLiset); // 初始化第一页数据

}

// 渲染分页插件
function renderPaging(el, total, currentPage, callback) {

    el.pagination(total,{
        items_per_page : pageSize,
        num_edge_entries : 3,
        num_display_entries : 5,
        current_page:currentPage,
        callback:callback
    });
}

// 根据页码获取采购列表数据
function getCppsDataList(pageNum, callback) {
    currentPageCpps = pageNum;
    jQuery.ajax({
        url:basePath + '/customer/market/purchase/products',
        type:'GET',
        data: {
            customerId:$('#customerId').val(),
            index:currentPageCpps,
            pageSize:pageSize,
            year:$('#cpps_year').val(),
            productName:$('#cpps_name').val()
        }
    }).done(function (res) {

        if (res.code === 1) {

            var data = res.data;

            // 渲染列表
            rederCppsLiset(data.list);

            // 渲染分页
            renderPaging($('#cpps_pagination'), data.total, currentPageCpps, function (pageNum,jq) {

                // 获取列表数据
                getCppsDataList(pageNum, rederCppsLiset);
            })
        }
    });
}

// 根据页码获取销售列表数据
function getCspsDataList(pageNum, callback) {
    currentPageCsps = pageNum;
    jQuery.ajax({
        url:basePath + '/customer/market/sale/products',
        type:'GET',
        data: {
            customerId:$('#customerId').val(),
            index:currentPageCsps,
            pageSize:pageSize,
            year:$('#csps_year').val(),
            productName:$('#csps_name').val()
        }
    }).done(function (res) {

        if (res.code === 1) {

            var data = res.data;

            // 渲染列表
            rederCspsLiset(data.list);

            // 渲染分页
            renderPaging($('#csps_pagination'), data.total, currentPageCsps, function (pageNum,jq) {

                // 获取列表数据
                getCspsDataList(pageNum, rederCspsLiset);
            })
        }
    });
}

// 渲染采购产品列表
function rederCppsLiset(list){
    var _html = '',
        count = currentPageCpps*pageSize;
    if(list instanceof Array){
        $.each(list,function (i,item) {
            _html += '<tr>';
            _html += '<td><div class="checkbox"><label for="item_cpps"><input name="item_cpps" type="checkbox" value="' + item.id + '"></label></div></td>';
            _html += '<td>' + (++count) + '</td>';
            _html += '<td>' + (typeof item.productName === 'string'?item.productName:'') + '</td>';
            _html += '<td>' + (typeof item.measurement === 'string'?item.measurement:'') + '</td>';
            _html += '<td>' + (typeof item.annualDemands === 'string'?item.annualDemands:'') + '</td>';
            _html += '<td>' + (typeof item.averagePrice === 'string'?item.averagePrice:'') + '</td>';
            _html += '<td>' + (typeof item.year === 'string'?item.year:'') + '</td>';
            _html += '<td><a href="#" name="lookCppsDetails" data-id="' + item.id + '">查看</a></td>';
            _html += '</tr>';
        });
    }
    $('tbody', $('#cpps')).html(_html);
}

// 渲染销售产品列表
function rederCspsLiset(list){
    var _html = '',
        count = currentPageCsps*pageSize;
    if(list instanceof Array){
        $.each(list,function (i,item) {
            _html += '<tr>';
            _html += '<td><div class="checkbox"><label for="item_cpps"><input name="item_cpps" type="checkbox" value="' + item.id + '"></label></div></td>';
            _html += '<td>' + (++count) + '</td>';
            _html += '<td>' + (typeof item.productName === 'string'?item.productName:'') + '</td>';
            _html += '<td>' + (typeof item.measurement === 'string'?item.measurement:'') + '</td>';
            _html += '<td>' + (typeof item.yearSalesTotal === 'string'?item.yearSalesTotal:'') + '</td>';
            _html += '<td>' + (typeof item.brand === 'string'?item.brand:'') + '</td>';
            _html += '<td>' + (typeof item.marketingMethod === 'string'?item.marketingMethod:'') + '</td>';
            _html += '<td>' + (typeof item.year === 'string'?item.year:'') + '</td>';
            _html += '<td><a href="#" name="lookCspsDetails" data-id="' + item.id + '">查看</a></td>';
            _html += '</tr>';
        });
    }
    $('tbody', $('#csps')).html(_html);
}

// 采购产品上传数据
function cppsUpData() {
    var obj = {
        purchaseProduct:{
            customerId:$('#customerId').val(),
            productId:$('#cpps_modal_name').data('val'),
            measurement:$('#primary_unit').val(),
            productName:$('#cpps_modal_name').val(),
            annualDemands:$('#cpps_pdt_t').find('[name="annualDemands"]').val(),
            averagePrice:$('#cpps_pdt_t').find('[name="averagePrice"]').val(),
            year:$('#cpps_pdt_t').find('[name="year"]').val()
        }
    };

    if (typeof $('#cpps_modal_name').data('id') === 'number') {
        obj.purchaseProduct.id = $('#cpps_modal_name').data('id');
    }

    obj.purchaseProduct.suppliers = [];


    $('#cpps_spr_t').find('[name="supplier"]').each(function () {
        var item = {
            name:$(this).find('[name="name"]').val(),
            amount:$(this).find('[name="amount"]').val(),
            priceAverage:$(this).find('[name="priceAverage"]').val(),
            measurement: $('#primary_unit').val()
        };

        if (typeof $(this).find('[name="name"]').data('id')==='number') {
            item.id = $(this).find('[name="name"]').data('id');
        }
            obj.purchaseProduct.suppliers.push(item);
    });

    if (supplierId.length > 0) {

        obj.deletedSupplierIds = supplierId;
    }

    return obj;
}

// 销售产品上传数据
function cspsUpData() {
    var obj = {
        saleProduct:{
            customerId:$('#customerId').val(),
            productId:$('#csps_modal_name').data('val'),
            measurement:$('#primary_unit').val(),
            productName:$('#csps_modal_name').val(),
            brand:$('#csps_pdt_t').find('[name="brand"]').val(),
            yearSalesTotal:$('#csps_pdt_t').find('[name="yearSalesTotal"]').val(),
            marketingMethod:$('#csps_pdt_t').find('[name="marketingMethod"]').val(),
            year:$('#csps_pdt_t').find('[name="year"]').val()
        }
    };

    if (typeof $('#csps_modal_name').data('id') === 'number') {
        obj.saleProduct.id = $('#csps_modal_name').data('id');
    }

    obj.saleProduct.countries = [];


    $('#csps_cty_t').find('[name="country"]').each(function () {
        var item = {
            destinationCountry:$(this).find('[name="destinationCountry"]').val(),
            yearSales:$(this).find('[name="amount"]').val(),
            marketShare:$(this).find('[name="marketShare"]').val(),
            measurement: $('#primary_unit').val()
        };

        if (typeof $(this).find('[name="destinationCountry"]').data('id')==='number') {
            item.id = $(this).find('[name="destinationCountry"]').data('id');
        }
        obj.saleProduct.countries.push(item);
    });

    if (countryId.length > 0) {

        obj.deleteCountryIds = countryId;
    }

    return obj;
}

// 删除数据
function delItem(arrData, url, currentPage, callback) {

    if (confirm("您确定要删除吗？")) {

        if(arrData instanceof Array && arrData.length>0){
            $.ajax({
                url:basePath + url,
                type:'POST',
                data:{
                    ids:arrData
                }
            }).done(function (res) {

                if (res.code === 1) {

                    alert('删除成功!');
                    currentPage = 0;
                    callback();
                }else {
                    alert('删除失败，请重试!');
                }
            });
        }else {
            alert('请选择要删除的项！');
        }
    }
}

// 合作情况获取数据
function getCoo(id) {
    $.ajax({
        url:basePath + '/customer/market/coop/' + id,
        type:'GET'
    }).done(function (res) {
        var data = res.data;
        renderCoo(data);
    })
}

// 合作情况表单渲染
function renderCoo(data) {

    $('#priceSensitivity').val(data.priceSensitivity);//价格敏感度
    $('#purchasingSeason').val(data.purchasingSeason);//采购季节
    $('#isFuhuaExclusive').val(data.isFuhuaExclusive);//合作紧密度
    $('#cooperationRemark').val(data.cooperationRemark);//备注
    $('#startCooperationTime').val(data.startCooperationTime);//开始合作时间
    $('#loyalty').val(data.loyalty);//忠诚度
    $('#activePeriod').val(data.activePeriod);//活跃周期
    $('#cooperationDuration').val(data.cooperationDuration);//合作时间
}

// 合作情况上传数据
function cooUpData() {

    var obj = {};
    obj.customerId = $('#customerId').val();
    obj.priceSensitivity=$('#priceSensitivity').val();
    obj.loyalty=$('#loyalty').val();
    obj.startCooperationTime=$('#startCooperationTime').val();
    obj.cooperationDuration=$('#cooperationDuration').val();
    obj.purchasingSeason=$('#purchasingSeason').val();
    obj.activePeriod=$('#activePeriod').val();
    obj.isFuhuaExclusive=$('#isFuhuaExclusive').val();
    obj.cooperationRemark=$('#cooperationRemark').val();
    console.log(obj);
    return obj;
}

// 重置合作情况数据
function resetCoo() {
    $('input,textarea,select',$('#cooperation')).val('');
}