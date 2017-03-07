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

$(document).ready(function () {

    $('a[href="#adEexpense"]').tab('show');
    jQuery.ajax({
        type: "GET",
        url: "/preparationProcessCost/queryPreparationProcessCostList",
        success: function (result) {
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
                Adeexpense1.innerHTML += '<tr>' +
                    '<td><a class="adEexpense1" data_url="/preparationProcessCost/getPreparationProcessCostById?id='+ResultData1[j].mcostId+'">' + ResultData1[j].costTerm + '</a></td>' +
                    '<td>' + ResultData1[j].unitCost + '</td>' +
                    '<td>' + ResultData1[j].priceEnd + '</td>' +
                    '<td>' + ResultData1[j].remarks + '</td>' +
                    '</tr>';
            }
            for (var k = 0; k < ResultData2.length; k++) {
                Adeexpense2.innerHTML += '<tr>' +
                    '<td><a class="adEexpense2" data_url="/preparationProcessCost/getPreparationProcessCostById?id='+ResultData2[k].mcostId+'">' + ResultData2[k].processFactory + '</a></td>' +
                    '<td>' + ResultData2[k].charges + '</td>' +
                    '<td>' + ResultData2[k].profit + '</td>' +
                    '<td>' + ResultData2[k].managementFee + '</td>' +
                    '<td>' + ResultData2[k].tax + '</td>' +
                    '<td>' + ResultData2[k].totalCost + '</td>' +
                    '</tr>';
            }
        }
    })

    $('a[href="#adEexpense"]').click(function () {
        $('a[href="#adEexpense"]').tab('show');
        jQuery.ajax({
            type: "GET",
            url: "/preparationProcessCost/queryPreparationProcessCostList",
            success: function (result) {
                Adeexpense1.innerHTML = '';
                Adeexpense2.innerHTML = '';
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
                    Adeexpense1.innerHTML += '<tr>' +
                        '<td><a class="adEexpense1" data_url="/preparationProcessCost/getPreparationProcessCostById?id='+ResultData1[j].mcostId+'">' + ResultData1[j].costTerm + '</a></td>' +
                        '<td>' + ResultData1[j].unitCost + '</td>' +
                        '<td>' + ResultData1[j].priceEnd + '</td>' +
                        '<td>' + ResultData1[j].remarks + '</td>' +
                        '</tr>';
                }
                for (var k = 0; k < ResultData2.length; k++) {
                    Adeexpense2.innerHTML += '<tr>' +
                        '<td><a class="adEexpense2" data_url="/preparationProcessCost/getPreparationProcessCostById?id='+ResultData2[k].mcostId+'">' + ResultData2[k].processFactory + '</a></td>' +
                        '<td>' + ResultData2[k].charges + '</td>' +
                        '<td>' + ResultData2[k].profit + '</td>' +
                        '<td>' + ResultData2[k].managementFee + '</td>' +
                        '<td>' + ResultData2[k].tax + '</td>' +
                        '<td>' + ResultData2[k].totalCost + '</td>' +
                        '</tr>';
                }
            }
        })
    });

    $('a[href="#freight"]').click(function () {
        $('a[href="#fright"]').tab('show');
        jQuery.ajax({
            url: '/freightCost/queryFreightCostList',
            type: 'GET',
            data: 'json',
            success: function (result) {
                Freight.innerHTML = '';
                var ResultData = eval(result.data);
                for (var i = 0; i < ResultData.length; i++) {
                    Freight.innerHTML += '<tr>' +
                        '<td><a class="freight1" data_url="/freightCost/getFreightCostById?id='+ResultData[i].freightId+'">' + ResultData[i].processFactory + '</a></td>' +
                        '<td>' + ResultData[i].unitCost + '</td>' +
                        '<td>' + ResultData[i].departureCity + '</td>' +
                        '<td>' + ResultData[i].destinationCity + '</td>' +
                        '<td>' + ResultData[i].remarks + '</td>' +
                        '</tr>';
                }
            }
        })
    });

    $('a[href="#cost"]').click(function () {
        $('a[href="#cost"]').tab('show');
        jQuery.ajax({
            url: '/componentCost/queryComponentCostList',
            type: 'GET',
            success: function (result) {
                Cost.innerHTML = '';
                var ResultData = eval(result.data);
                for (var i = 0; i < ResultData.length; i++) {
                    Cost.innerHTML += '<tr>' +
                        '<td><a class="componnentId" data_url="/componentCost/getComponentCostById?id=' + ResultData[i].componentId + '">' + ResultData[i].componentName + '</a></td>' +
                        '<td>' + ResultData[i].consumption + '</td>' +
                        '<td>' + ResultData[i].unitCost + '</td>' +
                        '<td>' + ResultData[i].priceEnd + '</td>' +
                        '<td>' + ResultData[i].suitableProduct + '</td>' +
                        '<td>' + ResultData[i].remarks + '</td>' +
                        '</tr>';
                }
            }
        })
    });

    $('a[href="#portSurcharge"]').click(function () {
        $('a[href="#portSurcharge"]').tab('show');
        jQuery.ajax({
            type: 'GET',
            url: '/portChargesCost/queryPortChargesCostList',

            success: function (result) {

                Portsurcharge.innerHTML = '';
                var ResultData = eval(result.data);
                for(var i = 0;i<ResultData.length;i++) {
                    Portsurcharge.innerHTML += '<tr>' +
                        '<td>' + ResultData[i].item + '</td>' +
                        '<td>' + ResultData[i].generalChemicals + '</td>' +
                        '<td>' + ResultData[i].dangerousProduct + '</td>' +
                    '</tr>';
                }
            }
        })
    })

    $('a[href="#rate"]').click(function () {
        $('a[href="#rate"]').tab('show');
        jQuery.ajax({
            type: 'GET',
            url: '/Rate/queryRateList',
            success: function (result) {
                Rate1.innerHTML = '';
                Rate2.innerHTML = '';
                Rate3.innerHTML = '';
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
                        '<td><a class="rate1" data_url="/Rate/getRateById?id='+ResultData1[j].rateId+'">' + ResultData1[j].currency + '</a></td>' +
                        '<td>' + ResultData1[j].rate + '</td>' +
                        '<td>' + ResultData1[j].termofValidity + '</td>' +
                        '<td>' + ResultData1[j].remarks + '</td>' +
                        '</tr>';
                }

                for (var k = 0; k < ResultData2.length; k++) {
                    Rate2.innerHTML += '<tr>' +
                        '<td><a class="rate2" data_url="/Rate/getRateById?id='+ResultData2[k].rateId+'">' + ResultData2[k].kind + '</a></td>' +
                        '<td>' + ResultData2[k].grossMargin + '</td>' +
                        '<td>' + ResultData2[k].termofValidity + '</td>' +
                        '<td>' + ResultData2[k].remarks + '</td>' +
                        '</tr>';
                }

                for (var l = 0; l < ResultData2.length; l++) {
                    Rate3.innerHTML += '<tr>' +
                        '<td><a class="rate3" data_url="/Rate/getRateById?id='+ResultData3[l].rateId+'">' + ResultData3[l].other + '</a></td>' +
                        '<td>' + ResultData3[l].rateValue + '</td>' +
                        '<td>' + ResultData3[l].termofValidity + '</td>' +
                        '<td>' + ResultData3[l].remarks + '</td>' +
                        '</tr>';
                }
            }
        })
    });

})

$(document).on("click",".adEexpense1",function(){
    var url = $(this).attr("data_url");
    modal.innerHTML = '';
    jQuery.ajax({
        type:'GET',
        url:url,
        success:function(result){
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
            html +='<input class="form-control" type="text" value="'+ResultData.costTerm+'" id="costTerm">';
            html +='</div></div>';
            html +='<div class="form-group">';
            html +='<label class="col-lg-2 control-label">单价</label>';
            html +='<div class="col-lg-3">';
            html +='<div class="input-group">';
            html +='<input class="form-control" type="text" value="'+ResultData.unitCost+'" id="unitCost">';
            html +='<div class="input-group-btn">';
            html +='<botton class="btn btn-xs btn-primary">(元/kg)</botton></div></div></div>';
            html +='<label class="col-lg-2 control-label">价格有效期</label>';
            html +='<div class="col-lg-4">';
            html +='<input class="form-control" type="date" value="'+ResultData.priceEnd+'" id="priceEnd">';
            html +='</div></div>';
            html +='<div class="form-group">';
            html +='<label class="col-xs-2 control-label">备注</label>';
            html +='<div class="col-xs-9">';
            html +='<textarea class="form-control"  rows="4" id="remarks">'+ResultData.remarks+'</textarea>';
            html +='</div>';
            html +='</div>';
            html +='</form>';
            html += '</div>';
            html +='<div class="modal-footer">';
            html +='<div class="row">';
            html +='<div class="col-xs-3 col-xs-offset-3">';
            html +='<button type="button" class="btn btn-primary btn-block updateadEexpense1" data_url="/preparationProcessCost/doModify?id='+ResultData.mcostId+'" data_id="'+ResultData.mcostId+'" data_type="'+ResultData.type+'"> 完成 </button>';
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
            html +='<input class="form-control" type="text" value="'+ResultData.processFactory+'" id="processFactory">';
            html +='</div></div>';
            html +='<div class="form-group">';
            html +='<label class="col-lg-2 control-label">水、电、气费</label>';
            html +='<div class="col-lg-3">';
            html +='<div class="input-group">';
            html +='<input class="form-control" type="text" value="'+ResultData.charges+'" id="charges">';
            html +='<div class="input-group-btn">';
            html +='<botton class="btn btn-xs btn-primary">(元/吨)</botton></div></div></div>';
            html +='<label class="col-lg-2 control-label">利润</label>';
            html +='<div class="col-lg-3">';
            html +='<div class="input-group">';
            html +='<input class="form-control" type="text" value="'+ResultData.profit+'" id="profit">';
            html +='<div class="input-group-btn">';
            html +='<botton class="btn btn-xs btn-primary">(元/吨)</botton>';
            html +='</div></div></div></div>';
            html +='<div class="form-group">';
            html +='<label class="col-lg-2 control-label">管理费</label>';
            html +='<div class="col-lg-3">';
            html +='<div class="input-group">';
            html +='<input class="form-control" type="text" value="'+ResultData.managementFee+'" id="managementFee">';
            html +='<div class="input-group-btn">';
            html +='<botton class="btn btn-xs btn-primary">(元/吨)</botton></div></div></div>';
            html +='<label class="col-lg-2 control-label">税金</label>';
            html +='<div class="col-lg-3">';
            html +='<div class="input-group">';
            html +='<input class="form-control" type="text" value="'+ResultData.tax+'" id="tax">';
            html +='<div class="input-group-btn">';
            html +='<botton class="btn btn-xs btn-primary">(元/吨)</botton>';
            html +='</div></div></div></div>';
            html +='<div class="form-group">';
            html +='<label class="col-xs-2 control-label">费用合计</label>';
            html +='<div class="col-xs-8">';
            html +='<textarea class="form-control"  rows="4" id="totalCost">'+ResultData.totalCost+'</textarea>';
            html +='</div>';
            html +='</div>';
            html +='</form>';
            html += '</div>';
            html +='<div class="modal-footer">';
            html +='<div class="row">';
            html +='<div class="col-xs-3 col-xs-offset-3">';
            html +='<button type="button" class="btn btn-primary btn-block updateadEexpense2" data_url="/preparationProcessCost/doModify?id='+ResultData.mcostId+'" data_type="'+ResultData.type+'"> 完成 </button>';
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
            html += '<h2 class="modal-title" >成分价格</h2></div>';
            html += '<div class="modal-body">';
            html += '<form class="form-horizontal" action="">';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">国内运费维护</label>';
            html += '<div class="col-lg-6">';
            html += '<input class="form-control" type="text" value="' + ResuleData.processFactory + '" id="processFactory">';
            html += '</div></div>';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">单价</label>';
            html += '<div class="col-lg-3">';
            html += '<div class="input-group">';
            html += '<input class="form-control" type="text" value="' + ResuleData.unitCost + '" id="unitCost">';
            html += '<div class="input-group-btn">';
            html += '<botton class="btn btn-xs btn-primary">(元/T)</botton></div></div></div>';
            html += '</div>';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">起运城市</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ResuleData.departureCity + '" id="departureCity">';
            html += '</div>';
            html += '<label class="col-lg-2 control-label">目的城市</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ResuleData.destinationCity + '" id="destinationCity">';
            html += '</div>';
            html += '</div>';
            html += '<div class="form-group">';
            html += '<label class="col-xs-2 control-label">备注</label>';
            html += '<div class="col-xs-8">';
            html += '<textarea class="form-control"  rows="4" id="remarks">' + ResuleData.remarks + '</textarea>';
            html += '</div>';
            html += '</div>';
            html += '</form>';
            html += '</div>';
            html += '<div class="modal-footer">';
            html += '<div class="row">';
            html += '<div class="col-xs-3 col-xs-offset-3">';
            html += '<button type="button" class="btn btn-primary btn-block updateFreight" data_url="/freightCost/doModify?id='+ResuleData.freightId+'"> 完成 </button>';
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
    modal.innerHTML = '';
    jQuery.ajax({
        type: 'GET',
        url: url,
        success: function (result) {
            var ResultData = eval(result.data);
            var html = [];
            html += '<div class="modal-dialog">';
            html += '<div class="modal-content">';
            html += '<div class="modal-header">';
            html += '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>';
            html += '<h2 class="modal-title" >成分价格</h2></div>';
            html += '<div class="modal-body">';
            html += '<form class="form-horizontal" action="">';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">成分名称</label>';
            html += '<div class="col-lg-6">';
            html += '<input class="form-control" type="text" value="' + ResultData.componentName + '" id="componentName">';
            html += '</div></div>';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">单耗</label>';
            html += '<div class="col-lg-3">';
            html += '<div class="input-group">';
            html += '<input class="form-control" type="text" value="' + ResultData.consumption + '" id="consumption">';
            html += '<div class="input-group-btn">';
            html += '<botton class="btn btn-xs btn-primary">(元/kg)</botton></div></div></div>';
            html += '<label class="col-lg-2 control-label">单价</label>';
            html += '<div class="col-lg-3">';
            html += '<div class="input-group">';
            html += '<input class="form-control" type="text" value="' + ResultData.unitCost + '" id="unitCost">';
            html += '<div class="input-group-btn">';
            html += '<botton class="btn btn-xs btn-primary">(元/kg)</botton>';
            html += '</div></div></div></div>';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">价格有效期</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ResultData.priceEnd + '" id="priceEnd">';
            html += '</div>';
            html += '<label class="col-lg-2 control-label">适合产品</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ResultData.suitableProduct + '" id="suitableProduct">';
            html += '</div>';
            html += '</div>';
            html += '<div class="form-group">';
            html += '<label class="col-xs-2 control-label">备注</label>';
            html += '<div class="col-xs-8">';
            html += '<textarea class="form-control"  rows="4" id="remarks">' + ResultData.remarks + '</textarea>';
            html += '</div>';
            html += '</div>';
            html += '</form>';
            html += '</div>';
            html += '<div class="modal-footer">';
            html += '<div class="row">';
            html += '<div class="col-xs-3 col-xs-offset-3">';
            html += '<button type="button" class="btn btn-primary btn-block updateCost" data_url="/componentCost/doModify?id='+ResultData.componentId+'"> 完成 </button>';
            html += '</div>';
            html += '<div class="col-xs-3">';
            html += '<button type="button" class="btn btn-default btn-block" data-dismiss="modal">取消 </button>';
            html += '</div></div></div></div></div>';

            $('#modal').html(html);
            $('#modal').modal('show');
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
            var ResuleData = eval(result.data);
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
            html += '<input class="form-control" type="text" value="' + ResuleData.currency + '" id="currency">';
            html += '</div></div>';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">汇率</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ResuleData.rate + '" id="rate">';
            html += '</div>';
            html += '<label class="col-lg-2 control-label">有效期</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="date" value="' + ResuleData. termofValidity+ '" id="termofValidity">';
            html += '</div>';
            html += '</div>';
            html += '<div class="form-group">';
            html += '<label class="col-xs-2 control-label">备注</label>';
            html += '<div class="col-xs-8">';
            html += '<textarea class="form-control"  rows="4" id="remarks">' + ResuleData.remarks + '</textarea>';
            html += '</div>';
            html += '</div>';
            html += '</form>';
            html += '</div>';
            html += '<div class="modal-footer">';
            html += '<div class="row">';
            html += '<div class="col-xs-3 col-xs-offset-3">';
            html += '<button type="button" class="btn btn-primary btn-block updaterate1" data_url="/Rate/doModify?id='+ResuleData.rateId+'" data_type="'+ResultData.type+'"> 完成 </button>';
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
            var ResuleData = eval(result.data);
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
            html += '<input class="form-control" type="text" value="' + ResuleData.kind + '" id="kind">';
            html += '</div></div>';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">毛利率</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ResuleData.grossMargin + '" id="grossMargin">';
            html += '</div>';
            html += '<label class="col-lg-2 control-label">有效期</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ResuleData. termofValidity+ '" id="termofValidity">';
            html += '</div>';
            html += '</div>';
            html += '<div class="form-group">';
            html += '<label class="col-xs-2 control-label">备注</label>';
            html += '<div class="col-xs-8">';
            html += '<textarea class="form-control"  rows="4" id="remarks">' + ResuleData.remarks + '</textarea>';
            html += '</div>';
            html += '</div>';
            html += '</form>';
            html += '</div>';
            html += '<div class="modal-footer">';
            html += '<div class="row">';
            html += '<div class="col-xs-3 col-xs-offset-3">';
            html += '<button type="button" class="btn btn-primary btn-block updaterate2" data_url="/Rate/doModify?id='+ResuleData.rateId+'" data_type="'+ResultData.type+'"> 完成 </button>';
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
            var ResuleData = eval(result.data);
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
            html += '<input class="form-control" type="text" value="' + ResuleData.other + '" id="other">';
            html += '</div></div>';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">汇率</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ResuleData.rateValue + '" id="rateValue">';
            html += '</div>';
            html += '<label class="col-lg-2 control-label">有效期</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ResuleData. termofValidity+ '" id="termofValidity">';
            html += '</div>';
            html += '</div>';
            html += '<div class="form-group">';
            html += '<label class="col-xs-2 control-label">备注</label>';
            html += '<div class="col-xs-8">';
            html += '<textarea class="form-control"  rows="4" id="remarks">' + ResuleData.remarks + '</textarea>';
            html += '</div>';
            html += '</div>';
            html += '</form>';
            html += '</div>';
            html += '<div class="modal-footer">';
            html += '<div class="row">';
            html += '<div class="col-xs-3 col-xs-offset-3">';
            html += '<button type="button" class="btn btn-primary btn-block updaterate3" data_url="/Rate/doModify?id='+ResuleData.rateId+'" data_type="'+ResultData.type+'"> 完成 </button>';
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
        success:function(){
            alert('修改成功');
            location.reload();
            $('#modal').modal('hide');
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
        "tax":$('#tax').val()
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
        }
    })
})

$(document).on("click",".updateCost",function(){
    var url = $(this).attr('data_url');
    var data = {
        "componentName":$('#componentName').val(),
        "consumption":$('#consumption').val(),
        "unitCost":$('#unitCost').val(),
        "priceEnd":$('#priceEnd').val(),
        "suitableProduct":$('#suitableProduct').val(),
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
        }
    })
})

$(document).on("cilck",".updateFreight",function(){
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
            alert('修改成功');
            $('#modal').modal('hide');
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
            alert('修改成功');
            $('#modal').modal('hide');
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
            alert('修改成功');
            $('#modal').modal('hide');
        }
    })
})


function updateportSurcharge(){
    var url = $(this).attr('data_url');
    var data = {
        "item":$("#item").val(),
        "generalChemicals":$("#generalChemicals").val(),
        "dangerousProduct":$("#dangerousProduct").val()
    }
    console.log(data);

    jQuery.ajax({
        type:'POST',
        url:url,
        data:JSON.stringify(data),
        success:function(result){
            alert('修改成功');
            $('#modal').modal('hide');
        }
    })

}