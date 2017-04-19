/**
 * huxiangyang
 */
//市场信息页面所有数据
function pop(result){

    // console.log(result);
    var data = result;

    //获取采购产品
    cpps(data);

    //获取销售产品
    csps(data);

    //获取合作情况
    var coop = data.cooperation;

    $('#priceSensitivity').val(coop.priceSensitivity);//价格敏感度
    $('#purchasingSeason').val(coop.purchasingSeason);//采购季节
    $('#isFuhuaExclusive').val(coop.isFuhuaExclusive);//合作紧密度
    $('#cooperationRemark').val(coop.cooperationRemark);//备注
    $('#startCooperationTime').val(coop.startCooperationTime);//开始合作时间
    $('#loyalty').val(coop.loyalty);//忠诚度
    $('#activePeriod').val(coop.activePeriod);//活跃周期
    $('#cooperationDuration').val(coop.cooperationDuration);//合作时间
}

//客户采购产品
function cpps(result){
    var data=[];

    //对data的层级进行判断
    if (result) {

        if(result instanceof Array && result.length>0){

            data = result;//取第一层
        }else if (result.cpps instanceof Array && result.cpps.length>0) {

            data = result.cpps;//取第二层
        }
    }
    var cpps = $('#cpps');
    cpps.html('');
    $.each(data,function(n,item){
        var tbody = '';
        tbody += '<tbody>';
        tbody += '<tr><th class="text-center">采购产品</th>';
        tbody += '<td class="text-center">'+(item.productName!=undefined?item.productName:'')+'</td>';
        tbody += '<th class="text-center">年需求量</th>';
        tbody += '<td class="text-center">'+(item.annualDemands!=undefined?item.annualDemands:'')+'</td>';
        tbody += '<th class="text-center">平均单价(美元)</th>';
        tbody += '<td class="text-center">'+(item.averagePrice!=undefined?item.averagePrice:'')+'</td></tr>';
        tbody += '<tr><td>供应商1</td>';
        tbody += '<td>'+(item.supplier1!=undefined?item.supplier1:'')+'</td>';
        tbody += '<td>年采购量</td>';
        tbody += '<td>'+(item.purchaseAmount1!=undefined?item.purchaseAmount1:'')+'</td>';
        tbody += '<td>平均单价</td>';
        tbody += '<td>'+(item.averagePrice1!=undefined?item.averagePrice1:'')+'</td></tr>';
        tbody += '<tr><td>供应商2</td>';
        tbody += '<td>'+(item.supplier2!=undefined?item.supplier2:'')+'</td>';
        tbody += '<td>年采购量</td>';
        tbody += '<td>'+(item.purchaseAmount2!=undefined?item.purchaseAmount2:'')+'</td>';
        tbody += '<td>平均单价</td>';
        tbody += '<td>'+(item.averagePrice2!=undefined?item.averagePrice2:'')+'</td></tr>';
        tbody += '<tr><td>供应商3</td>';
        tbody += '<td>'+(item.supplier3!=undefined?item.supplier3:'')+'</td>';
        tbody += '<td>年采购量</td>';
        tbody += '<td>'+(item.purchaseAmount3!=undefined?item.purchaseAmount3:'')+'</td>';
        tbody += '<td>平均单价</td>';
        tbody += '<td>'+(item.averagePrice3!=undefined?item.averagePrice3:'')+'</td></tr></tbody>';
        $('#cpps_year').val(item.year);
        cpps.append(tbody);
    });
}

//客户销售产品
function csps(result) {
    var data = [];

    if (result) {

        //对data的层级进行判断
        if (result instanceof Array && result.length>0) {

            data = result;//取第一层
        }else if (result.csps instanceof Array && result.csps.length>0) {

            data = result.csps;//取第二层
        }
    }
    var csps = $('#csps');
    csps.html('');
    $.each(data,function(n,item){
        var tbody = '';
        tbody += '<tbody>';
        tbody += '<tr><th class="text-center">销售产品</th>';
        tbody += '<td class="text-center">'+(item.productName!=undefined?item.productName:'')+'</td>';
        tbody += '<th class="text-center">年销售量</th>';
        tbody += '<td class="text-center">'+(item.yearSalesTotal!=undefined?item.yearSalesTotal:'')+'</td>';
        tbody += '<th class="text-center">品牌</th>';
        tbody += '<td class="text-center">'+(item.brand!=undefined?item.brand:'')+'</td>';
        tbody += '<th class="text-center">营销手段</th>';
        tbody += '<td class="text-center">'+(item.marketingMethod!=undefined?item.marketingMethod:'')+'</td></tr>';
        tbody += '<tr><td>销售目的国1</td>';
        tbody += '<td>'+(item.destinationCountry1!=undefined?item.destinationCountry1:'')+'</td>';
        tbody += '<td>年销售量</td>';
        tbody += '<td>'+(item.yearSales1!=undefined?item.yearSales1:'')+'</td>';
        tbody += '<td colspan="2">所占市场份额</td>';
        tbody += '<td colspan="2">'+(item.marketShare1!=undefined?item.marketShare1:'')+'</td></tr>';
        tbody += '<tr><td>销售目的国2</td>';
        tbody += '<td>'+(item.destinationCountry2!=undefined?item.destinationCountry2:'')+'</td>';
        tbody += '<td>年销售量</td>';
        tbody += '<td>'+(item.yearSales2!=undefined?item.yearSales2:'')+'</td>';
        tbody += '<td colspan="2">所占市场份额</td>';
        tbody += '<td colspan="2">'+(item.marketShare2!=undefined?item.marketShare2:'')+'</td></tr>';
        tbody += '<tr><td>销售目的国3</td>';
        tbody += '<td>'+(item.destinationCountry3!=undefined?item.destinationCountry3:'')+'</td>';
        tbody += '<td>年销售量</td>';
        tbody += '<td>'+(item.yearSales3!=undefined?item.yearSales3:'')+'</td>';
        tbody += '<td colspan="2">所占市场份额</td>';
        tbody += '<td colspan="2">'+(item.marketShare3!=undefined?item.marketShare3:'')+'</td></tr></tbody>';
        $('#csps_year').val(item.year);
        csps.append(tbody);
    });
}

/**
 * 上传数据
 */
//客户采购产品批量上传
function cppsObj() {
    var table = $('#table');
    var cpps = [];
    table.find('[name="cppsTbody"]').each(function(){
        var $this = $(this);
        // console.log($this);
        var obj = {};
        obj.year = $('#year').val();
        obj.customerId = $('#customerId').val();
        obj.customerType = $('#customerType').val();
        obj.productName = $this.find('[name="productName"]').val();
        obj.annualDemands = $this.find('[name="annualDemands"]').val();
        obj.averagePrice = $this.find('[name="averagePrice"]').val();
        obj.supplier1 = $this.find('[name="supplier1"]').val();
        obj.purchaseAmount1 = $this.find('[name="purchaseAmount1"]').val();
        obj.averagePrice1 = $this.find('[name="averagePrice1"]').val();
        obj.supplier2 = $this.find('[name="supplier2"]').val();
        obj.purchaseAmount2 = $this.find('[name="purchaseAmount2"]').val();
        obj.averagePrice2 = $this.find('[name="averagePrice2"]').val();
        obj.supplier3 = $this.find('[name="supplier3"]').val();
        obj.purchaseAmount3 = $this.find('[name="purchaseAmount3"]').val();
        obj.averagePrice3 = $this.find('[name="averagePrice3"]').val();
        cpps.push(obj);
    });
    console.log(JSON.stringify(cpps));
    return JSON.stringify(cpps);
}

//客户销售产品批量上传
function cspsObj() {
    var table = $('#table');
    var csps = [];
    table.find('[name="cspsTbody"]').each(function(){
        var $this = $(this);
        var obj = {};
        obj.year = $('#year').val();
        obj.customerId = $('#customerId').val();
        obj.customerType = $('#customerType').val();
        obj.productName = $this.find('[name="productName"]').val();
        obj.yearSalesTotal = $this.find('[name="yearSalesTotal"]').val();
        obj.brand = $this.find('[name="brand"]').val();
        obj.marketingMethod = $this.find('[name="marketingMethod"]').val();
        obj.destinationCountry1 = $this.find('[name="destinationCountry1"]').val();
        obj.yearSales1 = $this.find('[name="yearSales1"]').val();
        obj.marketShare1 = $this.find('[name="marketShare1"]').val();
        obj.destinationCountry2 = $this.find('[name="destinationCountry2"]').val();
        obj.yearSales2 = $this.find('[name="yearSales2"]').val();
        obj.marketShare2 = $this.find('[name="marketShare2"]').val();
        obj.destinationCountry3 = $this.find('[name="destinationCountry3"]').val();
        obj.yearSales3 = $this.find('[name="yearSales3"]').val();
        obj.marketShare3 = $this.find('[name="marketShare3"]').val();
        csps.push(obj);
        console.log(csps);
    });
    return JSON.stringify(csps);
}

//客户合作情况上传
function cooperationObj(){
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

//构造销售产品表格
function cspsTable(){
    var tbody = '';
    tbody += '<tbody name="cspsTbody">';
    tbody += '<tr><th>销售产品<sup class="not-null">*</sup></th>';
    tbody += '<th><div class="input-group"><input name="productName" class="form-control" type="text" value="" disabled required>';
    tbody += '<span class="input-group-btn"><button name="popupMd" class="btn btn-xs btn-default" type="button">';
    tbody += '<span class="glyphicon glyphicon-search"></span>';
    tbody += '</button></span></div></th>';
    tbody += '<th>年销售量<sup class="not-null">*</sup></th>';
    tbody += '<th><input name="yearSalesTotal" class="form-control" type="text" value="" required></th>';
    tbody += '<th>品牌</th>';
    tbody += '<th><input name="brand" class="form-control" type="text" value=""></th>';
    tbody += '<th>营销手段</th>';
    tbody += '<th><input name="marketingMethod" class="form-control" type="text" value=""></th></tr>';
    tbody += '<tr><td>销售目的国1</td>';
    tbody += '<td><input name="destinationCountry1" class="form-control" type="text" value=""></td>';
    tbody += '<td>年销售量</td>';
    tbody += '<td><input name="yearSales1" class="form-control" type="text" value=""></td>';
    tbody += '<td colspan="2">所占市场份额</td>';
    tbody += '<td colspan="2"><input name="marketShare1" class="form-control" type="text" value=""></td></tr>';
    tbody += '<tr><td>销售目的国2</td>';
    tbody += '<td><input name="destinationCountry2" class="form-control" type="text" value=""></td>';
    tbody += '<td>年销售量</td>';
    tbody += '<td><input name="yearSales2" class="form-control" type="text" value=""></td>';
    tbody += '<td colspan="2">所占市场份额</td>';
    tbody += '<td colspan="2"><input name="marketShare2" class="form-control" type="text" value=""></td></tr>';
    tbody += '<tr><td>销售目的国3</td>';
    tbody += '<td><input name="destinationCountry3" class="form-control" type="text" value=""></td>';
    tbody += '<td>年销售量</td>';
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
    tbody += '<span class="input-group-btn"><button name="popupMd" class="btn btn-xs btn-default" type="button">';
    tbody += '<span class="glyphicon glyphicon-search"></span>';
    tbody += '</button></span></div></th>';
    tbody += '<th>年需求量<sup class="not-null">*</sup></th>';
    tbody += '<th><input name="annualDemands" class="form-control" type="text" value="" required></th>';
    tbody += '<th>平均单价(美元)<sup class="not-null">*</sup></th>';
    tbody += '<th><input name="averagePrice" class="form-control" type="text" value="" required></th></tr>';
    tbody += '<tr><td>供应商1<sup class="not-null">*</sup></td>';
    tbody += '<td><input name="supplier1" class="form-control" type="text" value="" required></td>';
    tbody += '<td>年采购量<sup class="not-null">*</sup></td>';
    tbody += '<td><input name="purchaseAmount1" class="form-control" type="text" value="" required></td>';
    tbody += '<td>平均单价<sup class="not-null">*</sup></td>';
    tbody += '<td><input name="averagePrice1" class="form-control" type="text" value="" required></td></tr>';
    tbody += '<tr><td>供应商2</td>';
    tbody += '<td><input name="supplier2" class="form-control" type="text" value=""></td>';
    tbody += '<td>年采购量</td>';
    tbody += '<td><input name="purchaseAmount2" class="form-control" type="text" value=""></td>';
    tbody += '<td>平均单价</td>';
    tbody += '<td><input name="averagePrice2" class="form-control" type="text" value=""></td></tr>';
    tbody += '<tr><td>供应商3</td>';
    tbody += '<td><input name="supplier3" class="form-control" type="text" value=""></td>';
    tbody += '<td>年采购量</td>';
    tbody += '<td><input name="purchaseAmount3" class="form-control" type="text" value=""></td>';
    tbody += '<td>平均单价</td>';
    tbody += '<td><input name="averagePrice3" class="form-control" type="text" value=""></td></tr></tbody>';
    return tbody;
}

/**
 * 渲染树菜单
 * @param data
 */
function renderTree(data) {
    var setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            edit: {
                enable: false
            },
            callback: {
                onDblClick: ablclickTree
            }
        },
        id = $('#tree').attr('id');
    treeData = CRM.toArr(data);

    $.fn.zTree.init($('#tree'), setting, treeData);
}

/**
 * 树点击事件
 * @param event
 * @param modLeftId
 * @param treeNode
 */

function ablclickTree(event, modLeftId, treeNode) {

    selectedPName.val(treeNode.name);
    $('#treeModal').modal('hide');
}