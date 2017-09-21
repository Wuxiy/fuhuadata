/**
 * Created by young on 2017/3/1.
 */
var Adeexpense1 = document.getElementById("adEexpense1");
var Adeexpense2 = document.getElementById("adEexpense2");
var Freight = document.getElementById("freight1");
var Cost = document.getElementById("cost1");
var Portsurcharge = document.getElementById("portSurcharge1");
var Rate1 = document.getElementById("rate1");
var Rate2 = document.getElementById("rate2");
var Rate3 = document.getElementById("rate3");
var modal = document.getElementById("modal");
var test = $('#test');

var ComponentCost = ComponentCost || {};

(function (obj) {

    obj.refreshTable = function () {
        jQuery.ajax({
            url: basePath+'/componentCost/queryComponentCostList',
            type: 'GET',
            data: 'json',
            success: function (result) {
                $('#cost1').html('');
                if(result.data!=undefined){
                    var ResultData = result.data,
                        costHtml = '';
                    for (var i = 0; i < ResultData.length; i++) {
                        if(ResultData[i].componentName){
                            costHtml += '<tr data-component-id="' + ResultData[i].componentId + '">' +
                                '<td><a class="componnentId" style="cursor: pointer;" data_url="'+basePath+'/componentCost/getComponentCostById?id=' + ResultData[i].componentId + '&&productCategoryId='+ResultData[i].productCategoryId+'">' + ifEmpty(ResultData[i].componentName) + '</a></td>' +
                                '<td>' + ifEmpty(ResultData[i].consumption) + '</td>' +
                                '<td>' + ifEmpty(ResultData[i].unitCost) + '</td>' +
                                '<td>' + ifEmpty(ResultData[i].priceEnd) + '</td>' +
                                '<td>' + ifEmpty(ResultData[i].suitableProduct) + '</td>' +
                                '<td>' + ifEmpty(ResultData[i].remarks) + '</td>' +
                                '<td>' +
                                '<div class="checkbox">' +
                                '<label><input type="checkbox" value="' + ResultData[i].costId + '" class="j-delete"></label>' +
                                '</div>' +
                                '</td>' +
                                '</tr>';
                        }
                        $('#cost1').html(costHtml);
                    }
                }
            }
        })
    }
})(ComponentCost);

$(document).ready(function () {

    $('a[href="#adEexpense"]').tab('show');
    jQuery.ajax({
        type: "GET",
        url: basePath+"/preparationProcessCost/queryPreparationProcessCostList",
        success: function (result) {
            if(result.data!=undefined){
                var ResultData = eval(result.data);
                var ResultData1 = new Array();
                var ResultData2 = new Array();

                for (var i = 0; i < ResultData.length; i++) {
                    if (ResultData[i].type == 0) {
                        ResultData1.push(ResultData[i]);
                    } else {
                        ResultData2.push(ResultData[i]);
                    }
                }

                for (var j = 0; j < ResultData1.length; j++) {
                    if(ResultData1[j].costTerm){
                        Adeexpense1.innerHTML += '<tr>' +
                            '<td><a class="adEexpense1" style="cursor: pointer;" data_url="'+basePath+'/preparationProcessCost/getPreparationProcessCostById?id='+ResultData1[j].mcostId+'">' + ResultData1[j].costTerm + '</a></td>' +
                            '<td>' + ifEmpty(ResultData1[j].unitCost) + '</td>' +
                            '<td>' + ifEmpty(ResultData1[j].priceEnd) + '</td>' +
                            '<td>' + ifEmpty(ResultData1[j].remarks) + '</td>' +
                            '</tr>';
                    }
                }
                for (var k = 0; k < ResultData2.length; k++) {
                    Adeexpense2.innerHTML += '<tr>' +
                        '<td><a class="adEexpense2" style="cursor: pointer;" data_url="'+basePath+'/preparationProcessCost/getPreparationProcessCostById?id='+ResultData2[k].mcostId+'">' + ResultData2[k].processFactory + '</a></td>' +
                        '<td>' + ifEmpty(ResultData2[k].charges) + '</td>' +
                        '<td>' + ifEmpty(ResultData2[k].profit) + '</td>' +
                        '<td>' + ifEmpty(ResultData2[k].managementFee) + '</td>' +
                        '<td>' + ifEmpty(ResultData2[k].tax) + '</td>' +
                        '<td>' + ifEmpty(ResultData2[k].totalCost) + '</td>' +
                        '</tr>';
                }
            }

        }
    })

    $('a[href="#adEexpense"]').click(function () {
        $('a[href="#adEexpense"]').tab('show');
        jQuery.ajax({
            type: "GET",
            url: basePath+"/preparationProcessCost/queryPreparationProcessCostList",
            success: function (result) {
                Adeexpense1.innerHTML = '';
                Adeexpense2.innerHTML = '';
                if(result.data!=undefined){
                    var ResultData = eval(result.data);
                    var ResultData1 = new Array();
                    var ResultData2 = new Array();

                    for (var i = 0; i < ResultData.length; i++) {
                        if (ResultData[i].type == 0) {
                            ResultData1.push(ResultData[i]);
                        } else {
                            ResultData2.push(ResultData[i]);
                        }
                    }

                    for (var j = 0; j < ResultData1.length; j++) {
                        if(ResultData1[j].costTerm){
                            Adeexpense1.innerHTML += '<tr>' +
                                '<td><a class="adEexpense1" style="cursor: pointer;" data_url="'+basePath+'/preparationProcessCost/getPreparationProcessCostById?id='+ResultData1[j].mcostId+'">' + ResultData1[j].costTerm + '</a></td>' +
                                '<td>' + ifEmpty(ResultData1[j].unitCost) + '</td>' +
                                '<td>' + ifEmpty(ResultData1[j].priceEnd) + '</td>' +
                                '<td>' + ifEmpty(ResultData1[j].remarks) + '</td>' +
                                '</tr>';
                        }
                    }
                    for (var k = 0; k < ResultData2.length; k++) {
                        Adeexpense2.innerHTML += '<tr>' +
                            '<td><a class="adEexpense2" style="cursor: pointer;" data_url="'+basePath+'/preparationProcessCost/getPreparationProcessCostById?id='+ResultData2[k].mcostId+'">' + ResultData2[k].processFactory + '</a></td>' +
                            '<td>' + ifEmpty(ResultData2[k].charges) + '</td>' +
                            '<td>' + ifEmpty(ResultData2[k].profit) + '</td>' +
                            '<td>' + ifEmpty(ResultData2[k].managementFee) + '</td>' +
                            '<td>' + ifEmpty(ResultData2[k].tax) + '</td>' +
                            '<td>' + ifEmpty(ResultData2[k].totalCost) + '</td>' +
                            '</tr>';
                    }
                }
            }
        })
    });

    $('a[href="#freight"]').click(function () {
        $('a[href="#fright"]').tab('show');
        jQuery.ajax({
            url: basePath+'/freightCost/queryFreightCostList',
            type: 'GET',
            data: 'json',
            success: function (result) {
                Freight.innerHTML = '';
                if(result.data!=undefined){
                    var ResultData = eval(result.data);
                    for (var i = 0; i < ResultData.length; i++) {
                        Freight.innerHTML += '<tr>' +
                            '<td><a class="freight1" style="cursor: pointer;" data_url="'+basePath+'/freightCost/getFreightCostById?id='+ResultData[i].freightId+'">' + ifEmpty(ResultData[i].processFactory) + '</a></td>' +
                            '<td>' + ifEmpty(ResultData[i].departureCity) + '</td>' +
                            '<td>' + ifEmpty(ResultData[i].destinationCity) + '</td>' +
                            '<td>' + ifEmpty(ResultData[i].unitCost) + '</td>' +
                            '<td>' + ifEmpty(ResultData[i].remarks) + '</td>' +
                            '</tr>';
                    }
                }
            }
        })
    });

    $('a[href="#cost"]').click(function () {
        $('a[href="#cost"]').tab('show');
        ComponentCost.refreshTable();
    });

    $('a[href="#portSurcharge"]').click(function () {
        $('a[href="#portSurcharge"]').tab('show');
        jQuery.ajax({
            type: 'GET',
            url: basePath+'/portChargesCost/queryPortChargesCostList',

            success: function (result) {

                Portsurcharge.innerHTML = '';
                if(result.data!=undefined){
                    var ResultData = eval(result.data);
                    for(var i = 0;i<ResultData.length;i++) {
                        Portsurcharge.innerHTML += '<tr>' +
                            '<td name="item" data_id="'+ResultData[i].portId+'">'+ResultData[i].item+'</td>' +
                            '<td><input class="form-control text-center" value="'+ResultData[i].generalChemicals+'" name="generalChemicals" disabled/></td>' +
                            '<td><input class="form-control text-center" value="'+ResultData[i].dangerousProduct+'" name="dangerousProduct" disabled/></td>' +
                            '</tr>';
                    }
                }
            }
        })
    })

    $('a[href="#rate"]').click(function () {
        $('a[href="#rate"]').tab('show');
        jQuery.ajax({
            type: 'GET',
            url: basePath+'/Rate/queryRateList',
            success: function (result) {
                Rate1.innerHTML = '';
                Rate2.innerHTML = '';
                Rate3.innerHTML = '';
                if(result.data!=undefined){
                    var ResultData = eval(result.data);

                    var ResultData1 = new Array();
                    var ResultData2 = new Array();
                    var ResultData3 = new Array();

                    for (var i = 0; i < ResultData.length; i++) {

                        if (ResultData[i].type == 0) {
                            ResultData1.push(ResultData[i]);
                        } else if (ResultData[i].type == 1) {
                            ResultData2.push(ResultData[i]);
                        } else {
                            ResultData3.push(ResultData[i]);
                        }
                    }

                    for (var j = 0; j < ResultData1.length; j++) {
                        Rate1.innerHTML += '<tr>' +
                            '<td><a class="rate1" style="cursor: pointer;" data_url="'+basePath+'/Rate/getRateById?id='+ResultData1[j].rateId+'">' + ifEmpty(ResultData1[j].currency) + '</a></td>' +
                            '<td>' + ifEmpty(ResultData1[j].rate) + '</td>' +
                            '<td>' + ifEmpty(ResultData1[j].termofValidity) + '</td>' +
                            '<td>' + ifEmpty(ResultData1[j].remarks) + '</td>' +
                            '</tr>';
                    }

                    for (var k = 0; k < ResultData2.length; k++) {
                        Rate2.innerHTML += '<tr>' +
                            '<td><a class="rate2" style="cursor: pointer;" data_url="'+basePath+'/Rate/getRateById?id='+ResultData2[k].rateId+'">' + ifEmpty(ResultData2[k].kind) + '</a></td>' +
                            '<td>' + ifEmpty(ResultData2[k].grossMargin) + '</td>' +
                            '<td>' + ifEmpty(ResultData2[k].termofValidity) + '</td>' +
                            '<td>' + ifEmpty(ResultData2[k].remarks) + '</td>' +
                            '</tr>';
                    }

                    for (var l = 0; l < ResultData3.length; l++) {
                        Rate3.innerHTML += '<tr>' +
                            '<td><a class="rate3" style="cursor: pointer;" data_url="'+basePath+'/Rate/getRateById?id='+ResultData3[l].rateId+'">' + ifEmpty(ResultData3[l].other) + '</a></td>' +
                            '<td>' + ifEmpty(ResultData3[l].rateValue) + '</td>' +
                            '<td>' + ifEmpty(ResultData3[l].termofValidity) + '</td>' +
                            '<td>' + ifEmpty(ResultData3[l].remarks) + '</td>' +
                            '</tr>';
                    }
                }

            }
        })
    });

})

//模态查看详情
$(document).on("click",".adEexpense1",function(){
    var url = $(this).attr("data_url");
    console.log(url);
    modal.innerHTML = '';
    jQuery.ajax({
        type:'GET',
        url:url,
        success:function(result){
            console.log(result);
            var ResultData = eval(result.data);
            var html = [];
            html += '<div class="modal-dialog">';
            html +='<div class="modal-content">';
            html +='<div class="modal-header">';
            html +='<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>';
            html +='<h2 class="modal-title" >人工费</h2></div>';
            html +='<div class="modal-body">';
            html +='<form class="form-horizontal" action="">';
            html +='<div class="form-group">';
            html +='<label class="col-lg-2 control-label">主材规格</label>';
            html +='<div class="col-lg-6">';
            html +='<input class="form-control" type="text" value="'+ifEmpty(ResultData.costTerm)+'" id="costTerm" disabled>';
            html +='</div></div>';
            html +='<div class="form-group">';
            html +='<label class="col-lg-2 control-label">单价</label>';
            html +='<div class="col-lg-3">';
            html +='<div class="input-group">';
            html +='<input class="form-control" type="text" value="'+ifEmpty(ResultData.unitCost)+'" id="unitCost">';
            html +='<div class="input-group-btn">';
            html +='<botton class="btn btn-xs btn-primary">(元/kg)</botton></div></div></div>';
            html +='<label class="col-lg-2 control-label">价格有效期</label>';
            html +='<div class="col-lg-4">';
            html +='<input class="form-control" type="date" value="'+ifEmpty(ResultData.priceEnd)+'" id="priceEnd">';
            html +='</div></div>';
            html +='<div class="form-group">';
            html +='<label class="col-xs-2 control-label">备注</label>';
            html +='<div class="col-xs-9">';
            html +='<textarea class="form-control"  rows="4" id="remarks">'+ifEmpty(ResultData.remarks)+'</textarea>';
            html +='</div>';
            html +='</div>';
            html +='</form>';
            html += '</div>';
            html +='<div class="modal-footer">';
            html +='<div class="row">';
            html +='<div class="col-xs-3 col-xs-offset-3">';
            html +='<button type="button" class="btn btn-primary btn-block updateadEexpense1" data_url="'+basePath+'/preparationProcessCost/doModify?id='+ResultData.mcostId+'" data_id="'+ResultData.mcostId+'" data_type="'+ResultData.type+'"> 完成 </button>';
            html +='</div>';
            html +='<div class="col-xs-3">';
            html +='<button type="button" class="btn btn-default btn-block" data-dismiss="modal">取消 </button>';
            html +='</div></div></div></div></div>';

            $('#modal').html(html);
            $('#modal').modal('show');
        }
    })
})

$(document).on("click",".adEexpense2",function(){
    var url = $(this).attr("data_url");
    console.log(url);
    modal.innerHTML = '';
    jQuery.ajax({
        type:'GET',
        url:url,
        success:function(result){
            var ResultData = eval(result.data);
            console.log(ResultData);
            var html = [];
            html += '<div class="modal-dialog">';
            html +='<div class="modal-content">';
            html +='<div class="modal-header">';
            html +='<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>';
            html +='<h2 class="modal-title" >杂费</h2></div>';
            html +='<div class="modal-body">';
            html +='<form class="form-horizontal" action="">';
            html +='<div class="form-group">';
            html += '<label class="col-lg-2 control-label">加工厂</label>';
            html +='<div class="col-lg-6">';
            html +='<input class="form-control" type="text" value="'+ifEmpty(ResultData.processFactory)+'" id="processFactory" disabled>';
            html +='</div></div>';
            html +='<div class="form-group">';
            html +='<label class="col-lg-2 control-label">水、电、气费</label>';
            html +='<div class="col-lg-3">';
            html +='<div class="input-group">';
            html +='<input class="form-control total" type="text" value="'+ifEmpty(ResultData.charges)+'" id="charges">';
            html +='<div class="input-group-btn">';
            html +='<botton class="btn btn-xs btn-primary">(元/吨)</botton></div></div></div>';
            html +='<label class="col-lg-2 control-label">利润</label>';
            html +='<div class="col-lg-3">';
            html +='<div class="input-group">';
            html +='<input class="form-control total" type="text" value="'+ifEmpty(ResultData.profit)+'" id="profit">';
            html +='<div class="input-group-btn">';
            html +='<botton class="btn btn-xs btn-primary">(元/吨)</botton>';
            html +='</div></div></div></div>';
            html +='<div class="form-group">';
            html +='<label class="col-lg-2 control-label">管理费</label>';
            html +='<div class="col-lg-3">';
            html +='<div class="input-group">';
            html +='<input class="form-control total" type="text" value="'+ifEmpty(ResultData.managementFee)+'" id="managementFee">';
            html +='<div class="input-group-btn">';
            html +='<botton class="btn btn-xs btn-primary">(元/吨)</botton></div></div></div>';
            html +='<label class="col-lg-2 control-label">税金</label>';
            html +='<div class="col-lg-3">';
            html +='<div class="input-group">';
            html +='<input class="form-control total" type="text" value="'+ifEmpty(ResultData.tax)+'" id="tax">';
            html +='<div class="input-group-btn">';
            html +='<botton class="btn btn-xs btn-primary">(元/吨)</botton>';
            html +='</div></div></div></div>';
            html +='<div class="form-group">';
            html +='<label class="col-xs-2 control-label">费用合计</label>';
            html +='<div class="col-xs-8">';
            html +='<textarea class="form-control"  rows="4" id="totalCost">'+ifEmpty(ResultData.totalCost)+'</textarea>';
            html +='</div>';
            html +='</div>';
            html +='</form>';
            html += '</div>';
            html +='<div class="modal-footer">';
            html +='<div class="row">';
            html +='<div class="col-xs-3 col-xs-offset-3">';
            html +='<button type="button" class="btn btn-primary btn-block updateadEexpense2" data_url="'+basePath+'/preparationProcessCost/doModify?id='+ResultData.mcostId+'" data_type="'+ResultData.type+'"> 完成 </button>';
            html +='</div>';
            html +='<div class="col-xs-3">';
            html +='<button type="button" class="btn btn-default btn-block" data-dismiss="modal">取消 </button>';
            html +='</div></div></div></div></div>';

            $('#modal').html(html);
            $('#modal').modal('show');
        }
    })
})

$(document).on("click",".freight1",function(){
    var url = $(this).attr("data_url");
    console.log(url);
    modal.innerHTML = '';
    jQuery.ajax({
        type: 'GET',
        url: url,
        success: function (result) {
            var ResuleData = eval(result.data);
            var html = [];
            html += '<div class="modal-dialog">';
            html += '<div class="modal-content">';
            html += '<div class="modal-header">';
            html += '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>';
            html += '<h2 class="modal-title" >运费维护</h2></div>';
            html += '<div class="modal-body">';
            html += '<form class="form-horizontal" action="">';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">加工厂</label>';
            html += '<div class="col-lg-6">';
            html += '<input class="form-control" type="text" value="' + ifEmpty(ResuleData.processFactory) + '" id="processFactory" disabled>';
            html += '</div></div>';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">单价</label>';
            html += '<div class="col-lg-3">';
            html += '<div class="input-group">';
            html += '<input class="form-control" type="text" value="' + ifEmpty(ResuleData.unitCost) + '" id="unitCost">';
            html += '<div class="input-group-btn">';
            html += '<botton class="btn btn-xs btn-primary">(元/T)</botton></div></div></div>';
            html += '</div>';
            html += '<div class="form-group">';
                html += '<label class="col-lg-2 control-label">起运城市</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ifEmpty(ResuleData.departureCity) + '" id="departureCity">';
            html += '</div>';
            html += '<label class="col-lg-2 control-label">目的城市</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ifEmpty(ResuleData.destinationCity) + '" id="destinationCity">';
            html += '</div>';
            html += '</div>';
            html += '<div class="form-group">';
            html += '<label class="col-xs-2 control-label">备注</label>';
            html += '<div class="col-xs-8">';
            html += '<textarea class="form-control"  rows="4" id="remarks">' + ifEmpty(ResuleData.remarks) + '</textarea>';
            html += '</div>';
            html += '</div>';
            html += '</form>';
            html += '</div>';
            html += '<div class="modal-footer">';
            html += '<div class="row">';
            html += '<div class="col-xs-3 col-xs-offset-3">';
            html += '<button type="button" class="btn btn-primary btn-block updateFreight" data_url="'+basePath+'/freightCost/doModify?id='+ResuleData.freightId+'"> 完成 </button>';
            html += '</div>';
            html += '<div class="col-xs-3">';
            html += '<button type="button" class="btn btn-default btn-block" data-dismiss="modal">取消 </button>';
            html += '</div></div></div></div></div>';

            $('#modal').html(html);
            $('#modal').modal('show');
        }
    })
})

$(document).on("click",".componnentId",function(){
    var url = $(this).attr("data_url");
    test.html('');
    jQuery.ajax({
        type: 'GET',
        url: url,
        success: function (result) {
            var ComponentCost = result.data.componentCost;
            var ProductComponents = eval(result.data.kProductComponents);

            $('#componentName').attr('data-id',ComponentCost.componentId);
            $('#componentName').val(ifEmpty(ComponentCost.componentName));
            $('#unitCost').val(ifEmpty(ComponentCost.unitCost));
            $('#priceEnd').val(ifEmpty(ComponentCost.priceEnd));
            $('#remarks').val(ifEmpty(ComponentCost.remarks));

            for(var i=0;i<ProductComponents.length;i++){
                var Ps = ProductComponents[i];

                var div = $('<div class="form-group" name="ProductSuitableAdd"><label class="col-lg-2 control-label">适合产品</label><div class="col-xs-3"><div class="input-group"><input class="form-control suitableProduct" name="suitableProduct" type="text" data-id="'+Ps.productCategoryId+'" value="'+Ps.categoryFullName+'" disabled><div class="input-group-btn"><button class="btn btn-xs btn-default" type="button" data-toggle="modal" data-target="#treeModal"><span class="glyphicon glyphicon-search"></span></button></div></div></div><label class="col-lg-2 control-label">单耗</label><div class="col-lg-3"><div class="input-group"><input class="form-control" type="text" name="consumption" value="'+Ps.consumption+'"><div class="input-group-btn"><botton class="btn btn-xs btn-primary">(元/kg)</botton></div></div><button type="button" class="close" data-form-btn="del" data-form-target="form-group" style="position: absolute;top:5px;">×</button></div>');
                div.appendTo(test);
            }
            $('#costmodal').modal('show');
        }
    })
})

$(document).on("click",".rate1",function(){
    var url = $(this).attr('data_url');
    console.log(url);
    modal.innerHTML = '';
    jQuery.ajax({
        type:'GET',
        url:url,
        success: function (result) {
            var ResultData = eval(result.data);
            var html = [];
            html += '<div class="modal-dialog">';
            html += '<div class="modal-content">';
            html += '<div class="modal-header">';
            html += '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>';
            html += '<h2 class="modal-title" >币种&汇率</h2></div>';
            html += '<div class="modal-body">';
            html += '<form class="form-horizontal" action="">';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">币种</label>';
            html += '<div class="col-lg-6">';
            html += '<input class="form-control" type="text" value="' + ifEmpty(ResultData.currency) + '" id="currency" disabled>';
            html += '</div></div>';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">汇率</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ifEmpty(ResultData.rate) + '" id="rate">';
            html += '</div>';
            html += '<label class="col-lg-2 control-label">有效期</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="date" value="' + ifEmpty(ResultData.termofValidity)+ '" id="termofValidity">';
            html += '</div>';
            html += '</div>';
            html += '<div class="form-group">';
            html += '<label class="col-xs-2 control-label">备注</label>';
            html += '<div class="col-xs-8">';
            html += '<textarea class="form-control"  rows="4" id="remarks">' + ifEmpty(ResultData.remarks) + '</textarea>';
            html += '</div>';
            html += '</div>';
            html += '</form>';
            html += '</div>';
            html += '<div class="modal-footer">';
            html += '<div class="row">';
            html += '<div class="col-xs-3 col-xs-offset-3">';
            html += '<button type="button" class="btn btn-primary btn-block updaterate1" data_url="'+basePath+'/Rate/doModify?id='+ResultData.rateId+'" data_type="'+ResultData.type+'"> 完成 </button>';
            html += '</div>';
            html += '<div class="col-xs-3">';
            html += '<button type="button" class="btn btn-default btn-block" data-dismiss="modal">取消 </button>';
            html += '</div></div></div></div></div>';

            $('#modal').html(html);
            $('#modal').modal('show');
        }
    })
})

$(document).on("click",".rate2",function(){
    var url = $(this).attr('data_url');
    console.log(url);
    modal.innerHTML = '';
    jQuery.ajax({
        type:'GET',
        url:url,
        success: function (result) {
            var ResultData = eval(result.data);
            var html = [];
            html += '<div class="modal-dialog">';
            html += '<div class="modal-content">';
            html += '<div class="modal-header">';
            html += '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>';
            html += '<h2 class="modal-title" >毛利率</h2></div>';
            html += '<div class="modal-body">';
            html += '<form class="form-horizontal" action="">';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">产品种类</label>';
            html += '<div class="col-lg-6">';
            html += '<input class="form-control" type="text" value="' + ifEmpty(ResultData.kind) + '" id="kind" disabled>';
            html += '</div></div>';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">毛利率</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ifEmpty(ResultData.grossMargin) + '" id="grossMargin">';
            html += '</div>';
            html += '<label class="col-lg-2 control-label">有效期</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="date" value="' + ifEmpty(ResultData. termofValidity)+ '" id="termofValidity">';
            html += '</div>';
            html += '</div>';
            html += '<div class="form-group">';
            html += '<label class="col-xs-2 control-label">备注</label>';
            html += '<div class="col-xs-8">';
            html += '<textarea class="form-control"  rows="4" id="remarks">' + ifEmpty(ResultData.remarks) + '</textarea>';
            html += '</div>';
            html += '</div>';
            html += '</form>';
            html += '</div>';
            html += '<div class="modal-footer">';
            html += '<div class="row">';
            html += '<div class="col-xs-3 col-xs-offset-3">';
            html += '<button type="button" class="btn btn-primary btn-block updaterate2" data_url="'+basePath+'/Rate/doModify?id='+ResultData.rateId+'" data_type="'+ResultData.type+'"> 完成 </button>';
            html += '</div>';
            html += '<div class="col-xs-3">';
            html += '<button type="button" class="btn btn-default btn-block" data-dismiss="modal">取消 </button>';
            html += '</div></div></div></div></div>';

            $('#modal').html(html);
            $('#modal').modal('show');
        }
    })
})

$(document).on("click",".rate3",function(){
    var url = $(this).attr('data_url');
    console.log(url);
    modal.innerHTML = '';
    jQuery.ajax({
        type:'GET',
        url:url,
        success: function (result) {
            var ResultData = eval(result.data);
            var html = [];
            html += '<div class="modal-dialog">';
            html += '<div class="modal-content">';
            html += '<div class="modal-header">';
            html += '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>';
            html += '<h2 class="modal-title" >其他费率</h2></div>';
            html += '<div class="modal-body">';
            html += '<form class="form-horizontal" action="">';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">币种</label>';
            html += '<div class="col-lg-6">';
            html += '<input class="form-control" type="text" value="' + ifEmpty(ResultData.other) + '" id="other" disabled>';
            html += '</div></div>';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">汇率</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ifEmpty(ResultData.rateValue) + '" id="rateValue">';
            html += '</div>';
            html += '<label class="col-lg-2 control-label">有效期</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="date" value="' + ifEmpty(ResultData. termofValidity)+ '" id="termofValidity">';
            html += '</div>';
            html += '</div>';
            html += '<div class="form-group">';
            html += '<label class="col-xs-2 control-label">备注</label>';
            html += '<div class="col-xs-8">';
            html += '<textarea class="form-control"  rows="4" id="remarks">' + ifEmpty(ResultData.remarks) + '</textarea>';
            html += '</div>';
            html += '</div>';
            html += '</form>';
            html += '</div>';
            html += '<div class="modal-footer">';
            html += '<div class="row">';
            html += '<div class="col-xs-3 col-xs-offset-3">';
            html += '<button type="button" class="btn btn-primary btn-block updaterate3" data_url="'+basePath+'/Rate/doModify?id='+ResultData.rateId+'" data_type="'+ResultData.type+'"> 完成 </button>';
            html += '</div>';
            html += '<div class="col-xs-3">';
            html += '<button type="button" class="btn btn-default btn-block" data-dismiss="modal">取消 </button>';
            html += '</div></div></div></div></div>';

            $('#modal').html(html);
            $('#modal').modal('show');
        }
    })
})

//更新

$(document).on("click",".updateadEexpense1",function(){
    var url = $(this).attr("data_url");
    var type = $(this).attr("data_type");
    var data = {
        "type":type,
        "costTerm":$('#costTerm').val(),
        "unitCost":$('#unitCost').val(),
        "priceEnd":$('#priceEnd').val(),
        "remarks":$('#remarks').val()
    }

    console.log(data);

    jQuery.ajax({
        type:'POST',
        url:url,
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(data),
        success:function(result){
            alert('修改成功');
            $('#modal').modal('hide');
            $('a[href="#adEexpense"]').click();
        }
    })
})

$(document).on("click",".updateadEexpense2",function(){
    var url = $(this).attr('data_url');
    var type = $(this).attr('data_type');
    var data = {
        "type":type,
        "processFactory":$('#processFactory').val(),
        "charges":$('#charges').val(),
        "profit":$('#profit').val(),
        "managementFee":$('#managementFee').val(),
        "tax":$('#tax').val(),
        "totalCost":$('#totalCost').val()
    }
    console.log(data);

    jQuery.ajax({
        type:'POST',
        url:url,
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(data),
        success:function(result){
            alert('修改成功');
            $('#modal').modal('hide');
            $('a[href="#adEexpense"]').click();
        }
    })
})

$(document).on("click",".updateCost",function(){
    var ComponentName = $('#componentName').val();
    var UnitCost = $('#unitCost').val();
    var CategoryFullNames = [];
    $('[name="ProductSuitableAdd"]').each(function(){
        var cs = $(this).find('[name=suitableProduct]').val();
        CategoryFullNames.push(cs);
    })
    if(ComponentName == ''||UnitCost == ''||CategoryFullNames == ''){
        alert("请完善表单！");
        return false;
    }else {
        var data = {
            "componentCost":{
                "componentId":$('#componentName').attr('data-id'),
                "componentName":$('#componentName').val(),
                "priceEnd":$('#priceEnd').val(),
                "unitCost":$('#unitCost').val(),
                "remarks":$('#remarks').val()
            },
            "kProductComponents":ProductComponents()
        }
        console.log(data);
        jQuery.ajax({
            type:'POST',
            url:basePath + '/componentCost/doModify',
            dataType:"json",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(result){
                alert('修改成功');
                $('#costmodal').modal('hide');
                $('a[href="#cost"]').click();
            }
        })
    }
})

function ProductComponents() {
    var arr = [];
    var obj = {};
    var ProductSuitable = $('#costmodal').find('[name="ProductSuitableAdd"]');
    ProductSuitable.each(function () {
        obj = {
            "productCategoryId":$(this).find('[name=suitableProduct]').attr('data-id'),
            "categoryFullName":$(this).find('[name=suitableProduct]').val(),
            "consumption":$(this).find('[name=consumption]').val()
        }
        arr.push(obj);
    })
    return arr;
}

$(document).on("click",".updateFreight",function(){
    var url = $(this).attr('data_url');
    var data = {
        "processFactory":$('#processFactory').val(),
        "unitCost":$('#unitCost').val(),
        "departureCity":$('#departureCity').val(),
        "destinationCity":$('#destinationCity').val(),
        "remarks":$('#remarks').val()
    }
    console.log(data);

    jQuery.ajax({
        type:'POST',
        url:url,
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(data),
        success:function(result){
            if(result.code == 1){
                alert('修改成功');
                $('#modal').modal('hide');
                $('a[href="#freight"]').click();
            }else{
                alert('修改失败');
            }
        }
    })
})

$(document).on("click",".updaterate1",function(){
    var url = $(this).attr('data_url');
    var type = $(this).attr('data_type');
    var data = {
        "type":type,
        "currency":$("#currency").val(),
        "rate":$("#rate").val(),
        "termofValidity":$("#termofValidity").val(),
        "remarks":$("#remarks").val()
    }
    console.log(data);


    jQuery.ajax({
        type:'POST',
        url:url,
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(data),
        success:function(result){
            if(result.code == 1){
                alert('修改成功');
                $('#modal').modal('hide');
                $('a[href="#rate"]').click();
            }else{
                alert('修改失败');
            }
        }
    })
})

$(document).on("click",".updaterate2",function(){
    var url = $(this).attr('data_url');
    var type = $(this).attr('data_type');
    var data = {
        "type":type,
        "termofValidity":$("#termofValidity").val(),
        "remarks":$("#remarks").val(),
        "kind":$("#kind").val(),
        "grossMargin":$("#grossMargin").val()
    }
    console.log(data);


    jQuery.ajax({
        type:'POST',
        url:url,
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(data),
        success:function(result){
            alert('修改成功');
            $('#modal').modal('hide');
            $('a[href="#rate"]').click();
        }
    })
})

$(document).on("click",".updaterate3",function(){
    var url = $(this).attr('data_url');
    var type = $(this).attr('data_type');
    var data = {
        "type":type,
        "termofValidity":$("#termofValidity").val(),
        "remarks":$("#remarks").val(),
        "other":$("#other").val(),
        "rateValue":$("#rateValue").val()
    }
    console.log(data);


    jQuery.ajax({
        type:'POST',
        url:url,
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(data),
        success:function(result){
            if(result.code == 1){
                alert('修改成功');
                $('#modal').modal('hide');
                $('a[href="#rate"]').click();
            }else{
                alert('修改失败');
            }
        }
    })
})

//港杂费edit-save-cancel
$(document).on('click.edit','#edit',function () {
});
//港杂费edit-save-cancel信息提交
$(document).on('click.up','#save',function(){
    upData(basePath+'/portChargesCost/doModifyPortChargesCost','POST',updateportSurcharge(),"application/json");
});
//港杂费edit-save-cancel信息取消提交
$(document).on('click.cancel','#cancel',function(){
});

function updateportSurcharge() {
    var arr = [];
    var p = $('#portSurcharge1').find('tr');
    console.log(p.length);
    p.each(function () {
        var obj = {};
        $(this).find('td').each(function(n,td){
            if(n==0){
                obj.portId = $(td).attr('data_id');
                obj.item = $(td).text();
            }else if (n==1){
                obj.generalChemicals = $(td).children('input').val();
            }else if (n==2){
                obj.dangerousProduct = $(td).children('input').val();
            }
        })
        arr.push(obj);
    })
    console.log(arr);
    return JSON.stringify(arr);

}

function ifEmpty(data) {
    return data==undefined?'':data;
}

//成分价格新增
$(document).on("click",".costAddmodal",function(){
    $('#componentNameAdd').val('');
    $('#unitCostAdd').val('');
    $('#priceEndAdd').val('');
    $('#consumptionAdd').val('');
    $('#remarksAdd').val('');
    $('.suitableProductAdd').val('');

    $('#costAddmodal').modal('show');
})

//成分价格费用合计
function gettotalCost() {

}

$(document).on('change','.total',function () {
    var text = $('.total');
    var total = 0;
    for(var i = 0;i < text.length;i ++){
        total += parseInt(text[i].value);
    }
    $('#totalCost').val(total);
})