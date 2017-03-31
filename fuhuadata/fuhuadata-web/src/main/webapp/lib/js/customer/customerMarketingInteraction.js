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
    getData(basePath+'/customerMarketInfo/init','POST',GetRequest(),pop);
    //创建树形菜单
    $('#tree').creatTree(basePath+'/productCategory/CategoryTree');
    /**
     * 功能按钮
     */
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
        var year = $(e.target).val();
        var cusId = $('#customerId').customerId;
        var data = {
            year:year,
            customerId:cusId
        };
        getData(basePath+'/customerMarketInfo/getCPPListByCidAndYear','POST',data,cpps);
    });
    //筛选客户销售产品
    $(document).on('change.year','#csps_year',function (e) {
        var year = $(e.target).val();
        var cusId = GetRequest().customerId;
        var data = {
            year:year,
            customerId:cusId
        };
        getData(basePath+'/customerMarketInfo/getSaleProductListByCidAndYear','POST',data,csps);
    });
    //构造客户采购模态
    $(document).on('click.addCpps','#add_cpps',function(){
        var comBtn = $('[data-form-btn="complete"]');
        $('#table').html('');//清空表格
        $('#table').append(cppsTable());//重新填充表格
        comBtn.attr('id','cpps_up');//变更完成按钮
    });
    //构造客户销售模态
    $(document).on('click.addCsps','#add_csps',function(){
        var comBtn = $('[data-form-btn="complete"]');
        $('#table').html('');//清空表格
        $('#table').append(cspsTable());//重新填充表格
        comBtn.attr('id','csps_up');//变更完成按钮
    });
    //继续添加采购产品或者销售产品
    $(document).on('click.add','#addMore',function(){
        var table = $('#table');
        var colspanN = table.find('tr').first().find('th').length;
//            alert(colspanN);
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
            thisVal = $(this).val();
            if(thisVal==''|| thisVal==null){
                alert('请完善表单');
                isUp = false;
                return false;
            }
        });
        if(isUp){
            upData(basePath+'/customerMarketInfo/addCPPList','POST',cppsObj(),'application/json');
        };
    });
    //客户销售产品批量提交
    $(document).on('click.up','#csps_up',function(e) {
        var isUp=true;
        var notNull = $(e.target).parents('.modal').find('input[required ]');
        notNull.each(function () {
            thisVal = $(this).val();
            if(thisVal==''|| thisVal==null){
                alert('请完善表单');
                isUp = false;
                return false;
            }
        });
        if(isUp){
            upData(basePath+'/customerMarketInfo/addCSPList','POST',cspsObj(),'application/json');
        };
    });
    //客户合作情况提交
    $(document).on('click.up','#cooperation_up',function() {
        upData(basePath+'/customerMarketInfo/updateCooperationInfo','POST',cooperationObj(),'application/x-www-form-urlencoded; charset=UTF-8');
    });
    //客户合作情况取消
    $(document).on('click','#cooperation_cl',function () {
        //刷新
        getData(basePath+'/customerMarketInfo/init','POST',GetRequest(),pop);
    })
    //双击文本添加到指定文本框
    var selectedPName;
    $(document).on('click','[data-target="#treeModal"]',function (e) {
        selectedPName = $(e.target).parents('.input-group').find('input');
//            console.log(selectedPName);
    })
    $(document).on('click','#tree a',function (e) {
        e.preventDefault();
    })
    $(document).on('dblclick','#tree a.cNode',function (e) {
        var close = $(e.target).parents('.modal').find('.close');
        var txt = $(e.target).text();
        selectedPName.val(txt);
        close.click();
    })


    //构造销售产品表格
    function cspsTable(){
        var tbody = '';
        tbody += '<tbody name="cspsTbody">';
        tbody += '<tr><th>销售产品<sup class="not-null">*</sup></th>';
        tbody += '<th><div class="input-group"><input name="productName" class="form-control" type="text" value="" disabled required>';
        tbody += '<span class="input-group-btn"><button class="btn btn-xs btn-default" type="button" data-toggle="modal" data-target="#treeModal">';
        tbody += '<span class="glyphicon glyphicon-search"></span>';
        tbody += '</button></span></div></th>';
        tbody += '<th>年销售量<sup class="not-null">*</sup></th>';
        tbody += '<th><input name="yearSalesTotal" class="form-control" type="text" value="" required></th>';
        tbody += '<th>品牌</th>';
        tbody += '<th><input name="brand" class="form-control" type="text" value=""></th>';
        tbody += '<th>营销手段</th>';
        tbody += '<th><input name="marketingMethod" class="form-control" type="text" value=""></th></tr>';
        tbody += '<tr><td>销售目的国1</td>'
        tbody += '<td><input name="destinationCountry1" class="form-control" type="text" value=""></td>';
        tbody += '<td>年销售量</td>'
        tbody += '<td><input name="yearSales1" class="form-control" type="text" value=""></td>';
        tbody += '<td colspan="2">所占市场份额</td>';
        tbody += '<td colspan="2"><input name="marketShare1" class="form-control" type="text" value=""></td></tr>';
        tbody += '<tr><td>销售目的国2</td>'
        tbody += '<td><input name="destinationCountry2" class="form-control" type="text" value=""></td>';
        tbody += '<td>年销售量</td>'
        tbody += '<td><input name="yearSales2" class="form-control" type="text" value=""></td>';
        tbody += '<td colspan="2">所占市场份额</td>';
        tbody += '<td colspan="2"><input name="marketShare2" class="form-control" type="text" value=""></td></tr>';
        tbody += '<tr><td>销售目的国3</td>'
        tbody += '<td><input name="destinationCountry3" class="form-control" type="text" value=""></td>';
        tbody += '<td>年销售量</td>'
        tbody += '<td><input name="yearSales3" class="form-control" type="text" value=""></td>';
        tbody += '<td colspan="2">所占市场份额</td>';
        tbody += '<td colspan="2"><input name="marketShare3" class="form-control" type="text" value=""></td></tr></tbody>';
        return tbody;
    }
    //构造采购产品表格
    function cppsTable() {
        var tbody = '';
        tbody += '<tbody name="cppsTbody">';
        tbody += '<tr><th>采购产品<sup class="not-null">*</sup></th>';
        tbody += '<th><div class="input-group"><input name="productName" class="form-control" type="text" value="" disabled required>';
        tbody += '<span class="input-group-btn"><button class="btn btn-xs btn-default" type="button" data-toggle="modal" data-target="#treeModal">';
        tbody += '<span class="glyphicon glyphicon-search"></span>';
        tbody += '</button></span></div></th>';
        tbody += '<th>年需求量<sup class="not-null">*</sup></th>';
        tbody += '<th><input name="annualDemands" class="form-control" type="text" value="" required></th>';
        tbody += '<th>平均单价(美元)<sup class="not-null">*</sup></th>';
        tbody += '<th><input name="averagePrice" class="form-control" type="text" value="" required></th></tr>';
        tbody += '<tr><td>供应商1<sup class="not-null">*</sup></td>'
        tbody += '<td><input name="supplier1" class="form-control" type="text" value="" required></td>';
        tbody += '<td>年采购量<sup class="not-null">*</sup></td>'
        tbody += '<td><input name="purchaseAmount1" class="form-control" type="text" value="" required></td>';
        tbody += '<td>平均单价<sup class="not-null">*</sup></td>';
        tbody += '<td><input name="averagePrice1" class="form-control" type="text" value="" required></td></tr>';
        tbody += '<tr><td>供应商2</td>'
        tbody += '<td><input name="supplier2" class="form-control" type="text" value=""></td>';
        tbody += '<td>年采购量</td>'
        tbody += '<td><input name="purchaseAmount2" class="form-control" type="text" value=""></td>';
        tbody += '<td>平均单价</td>';
        tbody += '<td><input name="averagePrice2" class="form-control" type="text" value=""></td></tr>';
        tbody += '<tr><td>供应商3</td>'
        tbody += '<td><input name="supplier3" class="form-control" type="text" value=""></td>';
        tbody += '<td>年采购量</td>'
        tbody += '<td><input name="purchaseAmount3" class="form-control" type="text" value=""></td>';
        tbody += '<td>平均单价</td>';
        tbody += '<td><input name="averagePrice3" class="form-control" type="text" value=""></td></tr></tbody>';
        return tbody;
    }
})