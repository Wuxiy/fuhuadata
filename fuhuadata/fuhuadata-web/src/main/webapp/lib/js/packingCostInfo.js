/**
 * Created by young on 2017/3/7.
 */

$(document).ready(function(){
    //分割url，获取上个页面传过来的id
    var thisURL = document.URL;
    var trans = thisURL.split('?')[1];
    var id = trans.split('=')[1];

    var url = '/packingArchives/getPackingArchivesById?id='+id;
    console.log(url);
    jQuery.ajax({
    	type:'GET',
    	url:url,
    	success:function(result){
    		var ResultData = eval(result.data);

    		$('#packName').innerHTML = ResultData.packName;
    		$('#spec').innerHTML = ResultData.spec;
    		$('#packName').innerHTML = ResultData.packName;
    		$('#size').innerHTML = ResultData.size;
    		$('#quality').innerHTML = ResultData.quality;
    		$('#qualityIndex').innerHTML = ResultData.qualityIndex;
    		$('#qualityTargetValue').innerHTML = ResultData.qualityTargetValue;
    		$('#unitPrice').innerHTML = ResultData.unitPrice;
    		$('#consumption').innerHTML = ResultData.consumption;
    		$('#priceEndDate').innerHTML = ResultData.priceEndDate;
    		$('#status').innerHTML = ResultData.status;
    		/*$('#suitableType').innerHTML = ResultData.suitableType;*/
    		$('#bremarks').innerHTML = ResultData.bremarks;
    	}
    })
})