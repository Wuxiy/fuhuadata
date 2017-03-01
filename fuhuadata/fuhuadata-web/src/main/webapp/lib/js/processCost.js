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
                Portsurcharge.innerHTML += '<table class="table table-bordered table-condensed text-center">' +
                    '<thead>' +
                    '<tr>' +
                    '<th colspan="3" class="text-center col-xs-6">项目</th>' +
                    '<th class="text-center col-xs-3">一般化工品</th>' +
                    '<th class="text-center col-xs-3">危险品</th>' +
                    '</tr>' +
                    '</thead>' +
                    '<tbody>' +
                    '<tr><td colspan="2" rowspan="2">订舱费（元/柜）</td>' +
                    '<td class="text-left">20GP</td>' +
                    '<td>' + ResultData[0].generalChemicals + '</td>' +
                    '<td>' + ResultData[0].dangerousProduct + '</td>' + '</tr>' +
                    '<tr><td class="text-left">20GP&HQ</td>' +
                    '<td>' + ResultData[1].generalChemicals + '</td>' +
                    '<td>' + ResultData[1].dangerousProduct + '</td>' + '</tr>' +
                    '<tr><td rowspan="4">装箱费（元/柜）</td>' +
                    '<td rowspan="2">外港</td>' +
                    '<td class="text-left">20GP</td>' +
                    '<td>' + ResultData[2].generalChemicals + '</td>' +
                    '<td>' + ResultData[2].dangerousProduct + '</td>' + '</tr>' +
                    '<tr><td class="text-left">40GP&HQ</td>' +
                    '<td>' + ResultData[3].generalChemicals + '</td>' +
                    '<td>' + ResultData[3].dangerousProduct + '</td>' + '</tr>' +
                    '<tr><td rowspan="2">洋山港</td>' +
                    '<td class="text-left">20GP</td>' +
                    '<td>' + ResultData[4].generalChemicals + '</td>' +
                    '<td>' + ResultData[4].dangerousProduct + '</td>' + '</tr>' +
                    '<tr><td class="text-left">40GP&HQ</td>' +
                    '<td>' + ResultData[5].generalChemicals + '</td>' +
                    '<td>' + ResultData[5].dangerousProduct + '</td>' + '</tr>' +
                    '<tr><td colspan="3">文件费（元/票）</td>' +
                    '<td>' + ResultData[6].generalChemicals + '</td>' +
                    '<td>' + ResultData[6].dangerousProduct + '</td>' + '</tr>' +
                    '<tr><td colspan="3">电放费（元/票）</td>' +
                    '<td>' + ResultData[7].generalChemicals + '</td>' +
                    '<td>' + ResultData[7].dangerousProduct + '</td>' + '</tr>' +
                    '<tr><td colspan="3">改单费（元/票）' + '</td>' +
                    '<td>' + ResultData[8].generalChemicals + '</td>' +
                    '<td>' + ResultData[8].dangerousProduct + '</td>' + '</tr>' +
                    '<tr>' + '<td colspan="3">' + '快递费' + '</td>' +
                    '<td>' + ResultData[9].generalChemicals + '</td>' +
                    '<td>' + ResultData[9].dangerousProduct + '</td>' + '</tr>' +
                    '<tr>' + '<td colspan="3">' + '报关费（元/票）' + '</td>' +
                    '<td>' + ResultData[10].generalChemicals + '</td>' +
                    '<td>' + ResultData[10].dangerousProduct + '</td>' + '</tr>' +
                    '<tr>' + '<td colspan="3">' + '进仓费（卸货费）（元/吨）' + '</td>' +
                    '<td>' + ResultData[11].generalChemicals + '</td>' +
                    '<td>' + ResultData[11].dangerousProduct + '</td>' + '</tr>' +
                    '<tr>' + '<td colspan="2" rowspan="5">' + '打托费（托盘、打托、缠膜）（元/托）' + '</td>' +
                    '<td class="text-left">' + '普通托盘' + '</td>' +
                    '<td>' + ResultData[12].generalChemicals + '</td>' +
                    '<td>' + ResultData[12].dangerousProduct + '</td>' + '</tr>' +
                    '<tr>' + '<td class="text-left">' + '熏蒸托盘' + '</td>' +
                    '<td>' + ResultData[13].generalChemicals + '</td>' +
                    '<td>' + ResultData[13].dangerousProduct + '</td>' + '</tr>' +
                    '<tr>' + '<td class="text-left">' + '双面托' + '</td>' +
                    '<td>' + ResultData[14].generalChemicals + '</td>' +
                    '<td>' + ResultData[14].dangerousProduct + '</td>' + '</tr>' +
                    '<tr>' + '<td class="text-left">' + 'CP3托盘' + '</td>' +
                    '<td>' + ResultData[15].generalChemicals + '</td>' +
                    '<td>' + ResultData[15].dangerousProduct + '</td>' + '</tr>' +
                    '<tr>' + '<td class="text-left">' + '塑料托盘' + '</td>' +
                    '<td>' + ResultData[16].generalChemicals + '</td>' +
                    '<td>' + ResultData[16].dangerousProduct + '</td>' + '</tr>' +
                    '<tr>' + '<td colspan="3">' + '垫板费（元/张）' + '</td>' +
                    '<td>' + ResultData[17].generalChemicals + '</td>' +
                    '<td>' + ResultData[17].dangerousProduct + '</td>' + '</tr>' +
                    '<tr>' + '<td colspan="3">纸板费（元/个）</td>' +
                    '<td>' + ResultData[18].generalChemicals + '</td>' +
                    '<td>' + ResultData[18].dangerousProduct + '</td>' + '</tr>' +
                    '<tr> <td colspan="3">气囊费（元/个）</td>' +
                    '<td>' + ResultData[19].generalChemicals + '</td>' +
                    '<td>' + ResultData[19].dangerousProduct + '</td>' + '</tr>' +
                    '<tr> <td colspan="3">唛头（元/张）（黑白打印，A4纸一半）</td>' +
                    '<td>' + ResultData[20].generalChemicals + '</td>' +
                    '<td>' + ResultData[20].dangerousProduct + '</td>' + '</tr>' +
                    '<tr> <td colspan="3">拉网费（元/柜）</td>' +
                    '<td>' + ResultData[21].generalChemicals + '</td>' +
                    '<td>' + ResultData[21].dangerousProduct + '</td>' + '</tr>' +
                    '<tr> <td colspan="3">紧固带费（元/柜）</td>' +
                    '<td>' + ResultData[22].generalChemicals + '</td>' +
                    '<td>' + ResultData[22].dangerousProduct + '</td>' + '</tr>' +
                    '<tr> <td rowspan="2" colspan="2">抄条码费</td>' +
                    '<td class="text-left">600KG-1000KG包装（元/包）</td>' +
                    '<td>' + ResultData[23].generalChemicals + '</td>' +
                    '<td>' + ResultData[23].dangerousProduct + '</td>' + '</tr>' +
                    '<tr> <td class="text-left">25KG包装（元/柜）</td>' +
                    '<td>' + ResultData[24].generalChemicals + '</td>' +
                    '<td>' + ResultData[24].dangerousProduct + '</td>' + '</tr>' +
                    '<tr> <td colspan="3">封子费（元/柜）</td>' +
                    '<td>' + ResultData[25].generalChemicals + '</td>' +
                    '<td>' + ResultData[25].dangerousProduct + '</td>' + '</tr>' +
                    '<tr> <td colspan="3">检查费（元/柜）</td>' +
                    '<td>' + ResultData[26].generalChemicals + '</td>' +
                    '<td>' + ResultData[26].dangerousProduct + '</td>' + '</tr>' +
                    '<tr> <td colspan="3">美式门封（元/柜）</td>' +
                    '<td>' + ResultData[27].generalChemicals + '</td>' +
                    '<td>' + ResultData[27].dangerousProduct + '</td>' + '</tr>' +
                    '<tr> <td rowspan="2" colspan="2">FOB操作费（元/柜）</td>' +
                    '<td class="text-left">20GP</td>' +
                    '<td>' + ResultData[28].generalChemicals + '</td>' +
                    '<td>' + ResultData[28].dangerousProduct + '</td>' + '</tr>' +
                    '<tr> <td class="text-left">40GP&<hq></hq></td>' +
                    '<td>' + ResultData[29].generalChemicals + '</td>' +
                    '<td>' + ResultData[29].dangerousProduct + '</td>' + '</tr>' +
                    '<tr> <td colspan="3">护条（元/个）</td>' +
                    '<td>' + ResultData[30].generalChemicals + '</td>' +
                    '<td>' + ResultData[30].dangerousProduct + '</td>' + '</tr>' +
                    '<tr> <td colspan="3">护角（元/个）</td>' +
                    '<td>' + ResultData[31].generalChemicals + '</td>' +
                    '<td>' + ResultData[31].dangerousProduct + '</td>' + '</tr>' +
                    '<tr> <td colspan="3">仓储费</td>' +
                    '<td>' + ResultData[32].generalChemicals + '</td>' +
                    '<td>' + ResultData[32].dangerousProduct + '</td>' + '</tr>' +
                    '<tr> <td colspan="3">商检换单（元/票）</td>' +
                    '<td>' + ResultData[33].generalChemicals + '</td>' +
                    '<td>' + ResultData[33].dangerousProduct + '</td>' + '</tr>' +
                    '</tbody>';
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
    console.log(url);
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
            html +='<input class="form-control" type="text" value="'+ResultData.costTerm+'">';
            html +='</div></div>';
            html +='<div class="form-group">';
            html +='<label class="col-lg-2 control-label">单价</label>';
            html +='<div class="col-lg-3">';
            html +='<div class="input-group">';
            html +='<input class="form-control" type="text" value="'+ResultData.unitCost+'">';
            html +='<div class="input-group-btn">';
            html +='<botton class="btn btn-xs btn-primary">(元/kg)</botton></div></div></div>';
            html +='<label class="col-lg-2 control-label">价格有效期</label>';
            html +='<div class="col-lg-3">';
            html +='<input class="form-control" type="text" value="'+ResultData.priceEnd+'">';
            html +='</div></div>';
            html +='<div class="form-group">';
            html +='<label class="col-xs-2 control-label">备注</label>';
            html +='<div class="col-xs-8">';
            html +='<textarea id="fqlElse" class="form-control"  rows="4">'+ResultData.remarks+'</textarea>';
            html +='</div>';
            html +='</div>';
            html +='</form>';
            html += '</div>';
            html +='<div class="modal-footer">';
            html +='<div class="row">';
            html +='<div class="col-xs-3 col-xs-offset-3">';
            html +='<button type="button" class="btn btn-primary btn-block"> 完成 </button>';
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
            html +='<input class="form-control" type="text" value="'+ResultData.processFactory+'">';
            html +='</div></div>';
            html +='<div class="form-group">';
            html +='<label class="col-lg-2 control-label">水、电、气费</label>';
            html +='<div class="col-lg-3">';
            html +='<div class="input-group">';
            html +='<input class="form-control" type="text" value="'+ResultData.charges+'">';
            html +='<div class="input-group-btn">';
            html +='<botton class="btn btn-xs btn-primary">(元/吨)</botton></div></div></div>';
            html +='<label class="col-lg-2 control-label">利润</label>';
            html +='<div class="col-lg-3">';
            html +='<div class="input-group">';
            html +='<input class="form-control" type="text" value="'+ResultData.profit+'">';
            html +='<div class="input-group-btn">';
            html +='<botton class="btn btn-xs btn-primary">(元/吨)</botton>';
            html +='</div></div></div></div>';
            html +='<div class="form-group">';
            html +='<label class="col-lg-2 control-label">管理费</label>';
            html +='<div class="col-lg-3">';
            html +='<div class="input-group">';
            html +='<input class="form-control" type="text" value="'+ResultData.managementFee+'">';
            html +='<div class="input-group-btn">';
            html +='<botton class="btn btn-xs btn-primary">(元/吨)</botton></div></div></div>';
            html +='<label class="col-lg-2 control-label">税金</label>';
            html +='<div class="col-lg-3">';
            html +='<div class="input-group">';
            html +='<input class="form-control" type="text" value="'+ResultData.tax+'">';
            html +='<div class="input-group-btn">';
            html +='<botton class="btn btn-xs btn-primary">(元/吨)</botton>';
            html +='</div></div></div></div>';
            html +='<div class="form-group">';
            html +='<label class="col-xs-2 control-label">费用合计</label>';
            html +='<div class="col-xs-8">';
            html +='<textarea id="fqlElse" class="form-control"  rows="4">'+ResultData.totalCost+'</textarea>';
            html +='</div>';
            html +='</div>';
            html +='</form>';
            html += '</div>';
            html +='<div class="modal-footer">';
            html +='<div class="row">';
            html +='<div class="col-xs-3 col-xs-offset-3">';
            html +='<button type="button" class="btn btn-primary btn-block"> 完成 </button>';
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
            html += '<input class="form-control" type="text" value="' + ResuleData.processFactory + '">';
            html += '</div></div>';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">单价</label>';
            html += '<div class="col-lg-3">';
            html += '<div class="input-group">';
            html += '<input class="form-control" type="text" value="' + ResuleData.unitCost + '">';
            html += '<div class="input-group-btn">';
            html += '<botton class="btn btn-xs btn-primary">(元/T)</botton></div></div></div>';
            html += '</div>';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">起运城市</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ResuleData.departureCity + '">';
            html += '</div>';
            html += '<label class="col-lg-2 control-label">目的城市</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ResuleData.destinationCity + '">';
            html += '</div>';
            html += '</div>';
            html += '<div class="form-group">';
            html += '<label class="col-xs-2 control-label">备注</label>';
            html += '<div class="col-xs-8">';
            html += '<textarea id="fqlElse" class="form-control"  rows="4">' + ResuleData.remarks + '</textarea>';
            html += '</div>';
            html += '</div>';
            html += '</form>';
            html += '</div>';
            html += '<div class="modal-footer">';
            html += '<div class="row">';
            html += '<div class="col-xs-3 col-xs-offset-3">';
            html += '<button type="button" class="btn btn-primary btn-block"> 完成 </button>';
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
            html += '<label class="col-lg-2 control-label">成分名称</label>';
            html += '<div class="col-lg-6">';
            html += '<input class="form-control" type="text" value="' + ResuleData.componentName + '" id="componentName">';
            html += '</div></div>';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">单耗</label>';
            html += '<div class="col-lg-3">';
            html += '<div class="input-group">';
            html += '<input class="form-control" type="text" value="' + ResuleData.consumption + '" id="consumption">';
            html += '<div class="input-group-btn">';
            html += '<botton class="btn btn-xs btn-primary">(元/kg)</botton></div></div></div>';
            html += '<label class="col-lg-2 control-label">单价</label>';
            html += '<div class="col-lg-3">';
            html += '<div class="input-group">';
            html += '<input class="form-control" type="text" value="' + ResuleData.unitCost + '" id="unitCost">';
            html += '<div class="input-group-btn">';
            html += '<botton class="btn btn-xs btn-primary">(元/kg)</botton>';
            html += '</div></div></div></div>';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">价格有效期</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ResuleData.priceEnd + '" id="priceEnd">';
            html += '</div>';
            html += '<label class="col-lg-2 control-label">适合产品</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ResuleData.suitableProduct + '" id="suitableProduct">';
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
            html += '<button type="button" class="btn btn-primary btn-block" onclick="updateCost()"> 完成 </button>';
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
            html += '<input class="form-control" type="text" value="' + ResuleData.currency + '">';
            html += '</div></div>';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">汇率</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ResuleData.rate + '">';
            html += '</div>';
            html += '<label class="col-lg-2 control-label">有效期</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ResuleData. termofValidity+ '">';
            html += '</div>';
            html += '</div>';
            html += '<div class="form-group">';
            html += '<label class="col-xs-2 control-label">备注</label>';
            html += '<div class="col-xs-8">';
            html += '<textarea id="fqlElse" class="form-control"  rows="4">' + ResuleData.remarks + '</textarea>';
            html += '</div>';
            html += '</div>';
            html += '</form>';
            html += '</div>';
            html += '<div class="modal-footer">';
            html += '<div class="row">';
            html += '<div class="col-xs-3 col-xs-offset-3">';
            html += '<button type="button" class="btn btn-primary btn-block"> 完成 </button>';
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
            html += '<input class="form-control" type="text" value="' + ResuleData.kind + '">';
            html += '</div></div>';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">毛利率</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ResuleData.grossMargin + '">';
            html += '</div>';
            html += '<label class="col-lg-2 control-label">有效期</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ResuleData. termofValidity+ '">';
            html += '</div>';
            html += '</div>';
            html += '<div class="form-group">';
            html += '<label class="col-xs-2 control-label">备注</label>';
            html += '<div class="col-xs-8">';
            html += '<textarea id="fqlElse" class="form-control"  rows="4">' + ResuleData.remarks + '</textarea>';
            html += '</div>';
            html += '</div>';
            html += '</form>';
            html += '</div>';
            html += '<div class="modal-footer">';
            html += '<div class="row">';
            html += '<div class="col-xs-3 col-xs-offset-3">';
            html += '<button type="button" class="btn btn-primary btn-block"> 完成 </button>';
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
            html += '<input class="form-control" type="text" value="' + ResuleData.other + '">';
            html += '</div></div>';
            html += '<div class="form-group">';
            html += '<label class="col-lg-2 control-label">汇率</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ResuleData.rateValue + '">';
            html += '</div>';
            html += '<label class="col-lg-2 control-label">有效期</label>';
            html += '<div class="col-lg-3">';
            html += '<input class="form-control" type="text" value="' + ResuleData. termofValidity+ '">';
            html += '</div>';
            html += '</div>';
            html += '<div class="form-group">';
            html += '<label class="col-xs-2 control-label">备注</label>';
            html += '<div class="col-xs-8">';
            html += '<textarea id="fqlElse" class="form-control"  rows="4">' + ResuleData.remarks + '</textarea>';
            html += '</div>';
            html += '</div>';
            html += '</form>';
            html += '</div>';
            html += '<div class="modal-footer">';
            html += '<div class="row">';
            html += '<div class="col-xs-3 col-xs-offset-3">';
            html += '<button type="button" class="btn btn-primary btn-block"> 完成 </button>';
            html += '</div>';
            html += '<div class="col-xs-3">';
            html += '<button type="button" class="btn btn-default btn-block" data-dismiss="modal">取消 </button>';
            html += '</div></div></div></div></div>';

            $('#modal').html(html);
            $('#modal').modal('show');
        }
    })
})

function updateCost(){
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
        data:JSON.stringify(data),
        success:function(result){
            alert('修改成功');
            $('#modal').modal('hide');
        }
    })
}