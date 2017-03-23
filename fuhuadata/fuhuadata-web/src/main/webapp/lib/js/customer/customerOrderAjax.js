/**
 * Created by huxiangyang on 2017/3/22.
 */

/**
 *获取数据
 */
function customerOrderHis(result) {
    var tbody = $('#oTbody');
    tbody.html('');
    if(result && result!='' && result!=null){
        var getData = result;
        var count = 0;
        var arr = ['否','是'];
        $.each(getData,function (n,item) {
            var tr = '';
            tr += '<tr>';
            tr += '<td>'+ ++count +'</td>';
            tr += '<td>'+item.saleOrganizationName+'</td>';
            tr += '<td><a href="">'+item.orderId+'</a></td>';
            tr += '<td><a href="">'+item.ncOrderId+'</a></td>';
            tr += '<td>'+item.amountPayable+'</td>';
            tr += '<td>'+item.floorPrice+'</td>';
            tr += '<td>'+arr[item.isComplaint]+'</td>';//返回值所对应的字符串
            tr += '<td>'+arr[item.isModifyPrice]+'</td>';//返回值所对应的字符串
            tr += '<td>'+item.netProfit+'</td>';
            tr += '<td>'+arr[item.isPledge]+'</td>';//返回值所对应的字符串
            tr += '<td>'+item.dealTime.split(' ')[0]+'</td>';//只保留日期
            tr += '</tr>';
            tbody.append(tr);
        })
    }
}