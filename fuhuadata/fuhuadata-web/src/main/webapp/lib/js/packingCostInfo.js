/**
 * Created by young on 2017/3/7.
 */

$(document).ready(function(){
    //分割url，获取上个页面传过来的id
    var thisURL = document.URL;
    var trans = thisURL.split('?')[1];
    var trans2 = trans.split('&')[0];
    var id = trans2.split('=')[1];
    var bid = trans.split('=')[2];
    var table = document.getElementById('packing_relate_table');

    if(bid != 1){
        $('.relate').hide();
    }

    $('#packName').val("233");
    var url = '/packingArchives/getPackingArchivesById?id='+id;
    jQuery.ajax({
    	type:'GET',
    	url:url,
    	success:function(result){
    		var ResultData = result.data;
    		var node = ResultData.nodes;

            var arr = [ResultData.pack.suitableType];
            $('#packName').val(ResultData.pack.packName);
            $('#spec').val(ResultData.pack.spec);
            $('#size').val(ResultData.pack.size);
            $('#quality').val(ResultData.pack.quality);
            $('#qualityIndex').val(ResultData.pack.qualityIndex);
            $('#qualityTargetValue').val(ResultData.pack.qualityTargetValue);
            $('#unitPrice').val(ResultData.pack.unitPrice);
            $('#consumption').val(ResultData.pack.consumption);
            $('#priceEndDate').val(ResultData.pack.priceEndDate);
            $('#status').val(ResultData.pack.status);
            $('#bRemarks').val(ResultData.pack.bRemarks);
            $('.suitableType').val(arr);

            for(var i=0;i<node.length;i++){
                table.innerHTML += '<tr>'+
                        '<td class="text-center"><input type="checkbox"></td>'+
                        '<td class="col-xs-2 text-center text-middle">'+node[i].packingId+'</td>'+
                        '<td class="col-xs-2 text-center text-middle">'+node[i].packName+'</td>'+
                        '<td class="col-xs-1 text-center text-middle">'+node[i].spec+'</td>'+
                        '<td class="col-xs-1 text-center text-middle">'+node[i].size+'</td>'+
                        '<td class="col-xs-2 text-center text-middle">'+node[i].quality+'</td>'+
                        '<td class="col-xs-1 text-center text-middle">'+node[i].unitPrice+'</td>'+
                        '<td class="col-xs-1 text-center text-middle">'+node[i].consumption+'</td>'+
                        '<td class="col-xs-1 text-center text-middle">'+node[i].status+'</td>'
                        '</tr>';
            }
    	}
    })
})