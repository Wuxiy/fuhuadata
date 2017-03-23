/**
 * Created by huxiangyang on 2017/3/22.
 */

/**
 *获取数据
 */
function customerOrderHis(result) {
    var getData = result;
    var tbody = $('#oTbody');
    $.each(getData,function (n,item) {
        var tr = '';
        tr += '<tr>';
        tr += '<td></td>';
        tr += '<td></td>';
        tr += '<td><a href=""></a></td>';
        tr += '<td><a href=""></a></td>';
        tr += '<td></td>';
        tr += '<td></td>';
        tr += '<td></td>';
        tr += '<td></td>';
        tr += '<td></td>';
        tr += '<td></td>';
        tr += '<td></td>';
        tr += '</tr>';
        tbody.append(tr);
    })
}