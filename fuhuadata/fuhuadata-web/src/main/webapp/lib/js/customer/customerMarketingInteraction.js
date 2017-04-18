/**
 * Created by huxiangyang on 2017/3/13.
 */

$(function () {

    //创建面包屑导航
    $('#location').append(createCrumbsD());

    //设置title标题
    var title = $('#pTitle').text()+'——'+$('#sTitle').text();
    $('#hTitle').text(iGetInnerText(title));

    init();

    //获取数据
    CRM.ajaxCall({
        url:'/customerMarketInfo/init',
        type:'POST',
        data:{
            customerId:$('#customerId').val(),
            customerType:$('#customerType').val(),
            year:new Date().getFullYear()
        },
        callback:pop
    });
    // getData(basePath+'/customerMarketInfo/init','POST',GetRequest(),pop);

    //创建树形菜单
    $('#tree').creatTree(basePath+'/productCategory/CategoryTree?fourNode=0');

    //构造下拉选择框
    $('#cpps_year,#csps_year,#year').html(function (n,old) {
        old = '';
        var nowDate = new Date();
        var nowYear = nowDate.getFullYear();
        console.log(typeof nowYear);
        var options = '';
        for(var i=nowYear;i>=2014;i--){
            options += '<option value="'+i+'">'+i+'</option>';
        }
        return options;
    }).val(new Date().getFullYear());//默认为今年

    //筛选客户采购产品
    $(document).on('change.year','#cpps_year',function (e) {
        var year = $(e.target).val(),
            data = {
                year:year,
                customerId:$('#customerId').val(),
                customerType:$('#customerType').val()
            };
        CRM.ajaxCall({
            url:'/customerMarketInfo/getCPPListByCidAndYear',
            type:'POST',
            data:data,
            callback:cpps
        });
    });

    //筛选客户销售产品
    $(document).on('change.year','#csps_year',function (e) {
        var year = $(e.target).val(),
            data = {
                year:year,
                customerId:$('#customerId').val(),
                customerType:$('#customerType').val()
        };
        CRM.ajaxCall({
            url:'/customerMarketInfo/getSaleProductListByCidAndYear',
            type:'POST',
            data:data,
            callback:csps
        });
    });

    // 构造客户采购模态
    $(document).on('click.addCpps','#add_cpps',function(){
        var comBtn = $('[data-form-btn="complete"]');
        $('#year').val($('#cpps_year').val()); // 重新选择year的值
        $('#table').html(''); // 清空表格
        $('#table').append(cppsTable()); // 重新填充表格
        comBtn.attr('id','cpps_up'); // 变更完成按钮
    });

    // 构造客户销售模态
    $(document).on('click.addCsps','#add_csps',function(){
        var comBtn = $('[data-form-btn="complete"]');
        $('#year').val($('#cpps_year').val()); // 重新选择year的值
        $('#table').html(''); // 清空表格
        $('#table').append(cspsTable()); // 重新填充表格
        comBtn.attr('id','csps_up'); // 变更完成按钮
    });

    // 继续添加按钮
    $(document).on('click.add','#addMore',function(){
        var table = $('#table');
        var colspanN = table.find('tr').first().find('th').length;
        var comBtn = $('[data-form-btn="complete"]');
        var tbody;
        var delBtn = "";//删除按钮
        delBtn += '<tr>';
        delBtn += '<td colspan="'+colspanN+'">';
        delBtn += '<button class="btn btn-default btn-xs btn-block" data-form-btn="del" data-form-target="tbody">删除';
        delBtn += '</button></td></tr>';
        //判断完成按钮的id
        if(comBtn.attr('id')=='cpps_up'){
            tbody = cppsTable();//构造tbody
            console.log(delBtn);
            $(tbody).append(delBtn).appendTo(table);//插入到表格
        }else{
            tbody = cspsTable();
            $(tbody).append(delBtn).appendTo(table);
        }
    });

    //客户采购产品批量提交
    $(document).on('click.up','#cpps_up',function(e) {
        var isUp=true;
        var notNull = $(e.target).parents('.modal').find('input[required ]');
        notNull.each(function () {
            var thisVal = $(this).val();
            if(thisVal==''|| thisVal==null){
                $('#errorM').modal('show');
                isUp = false;
                return false;
            }
        });
        if(isUp){
            CRM.ajaxCall({
                url:'/customerMarketInfo/addCPPList',
                type:'POST',
                data:cppsObj(),
                contentType:'application/json',
                callback: function () {
                    // 刷新客户采购产品
                    CRM.ajaxCall({
                        url:'/customerMarketInfo/getCPPListByCidAndYear',
                        type:'POST',
                        data:{
                            customerId:$('#customerId').val(),
                            customerType:$('#customerType').val(),
                            year:$('#cpps_year').val($('#year').val()).val()
                        },
                        callback:cpps
                    });
                    // 关闭模态
                    $('#cusPro').modal('hide');
                }
            });
        }
    });

    //客户销售产品批量提交
    $(document).on('click.up','#csps_up',function(e) {
        var isUp=true;
        var notNull = $(e.target).parents('.modal').find('input[required ]');
        notNull.each(function () {
            var thisVal = $(this).val();
            if(thisVal==''|| thisVal==null){
                $('#errorM').modal('show');
                isUp = false;
                return false;
            }
        });
        if(isUp){
            CRM.ajaxCall({
                url:'/customerMarketInfo/addCSPList',
                type:'POST',
                data:cspsObj(),
                contentType:'application/json',
                callback: function () {
                    // 刷新客户销售产品
                    CRM.ajaxCall({
                        url:'/customerMarketInfo/getSaleProductListByCidAndYear',
                        type:'POST',
                        data:{
                            customerId:$('#customerId').val(),
                            customerType:$('#customerType').val(),
                            year:$('#csps_year').val($('#year').val()).val()
                        },
                        callback:csps
                    });

                    // 关闭模态
                    $('#cusPro').modal('hide');
                }
            });
        }
    });

    //客户合作情况提交
    $(document).on('click.up','#cooperation_up',function() {
        CRM.ajaxCall({
            url:'/customerMarketInfo/updateCooperationInfo',
            type:'POST',
            data:cooperationObj(),
            contentType:'application/x-www-form-urlencoded; charset=UTF-8',
            callback:function () {
                CRM.ajaxCall({
                    url:'/customerMarketInfo/init',
                    type:'POST',
                    data:{
                        customerId:$('#customerId').val(),
                        customerType:$('#customerType').val(),
                        year:new Date().getFullYear()
                    },
                    callback:pop
                });
            }
        });
        // upData(basePath+'/customerMarketInfo/updateCooperationInfo','POST',cooperationObj(),'application/x-www-form-urlencoded; charset=UTF-8');
    });

    //客户合作情况取消
    $(document).on('click','#cooperation_cl',function () {
        //刷新
        CRM.ajaxCall({
            url:'/customerMarketInfo/init',
            type:'POST',
            data:{
                customerId:$('#customerId').val(),
                customerType:$('#customerType').val(),
                year:new Date().getFullYear()
            },
            callback:pop
        });
        // getData(basePath+'/customerMarketInfo/init','POST',GetRequest(),pop);
    });

    //双击文本添加到指定文本框
    var selectedPName;
    $(document).on('click','[data-target="#treeModal"]',function (e) {
        selectedPName = $(e.target).parents('.input-group').find('input');
    });

    // 单击树节点阻止冒泡
    $(document).on('click','#tree a',function (e) {
        e.preventDefault();
    });

    // 双击树节点，将文本添加到选择框
    $(document).on('dblclick','#tree a.cNode',function (e) {
        var close = $(e.target).parents('.modal').find('.close');
        var txt = $(e.target).text();
        selectedPName.val(txt);
        close.click();
    });

});