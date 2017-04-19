/**
 * Created by huxiangyang on 2017/3/22.
 */

/*分页插件参数
 参数名	描述	参数值
 maxentries	总条目数	必选参数，整数
 items_per_page	每页显示的条目数	可选参数，默认是10
 num_display_entries	连续分页主体部分显示的分页条目数	可选参数，默认是10
 current_page	当前选中的页面	可选参数，默认是0，表示第1页
 num_edge_entries	两侧显示的首尾分页的条目数	可选参数，默认是0
 link_to	分页的链接	字符串，可选参数，默认是"#"
 prev_text	“前一页”分页按钮上显示的文字	字符串参数，可选，默认是"Prev"
 next_text	“下一页”分页按钮上显示的文字	字符串参数，可选，默认是"Next"
 ellipse_text	省略的页数用什么文字表示	可选字符串参数，默认是"..."
 prev_show_always	是否显示“前一页”分页按钮	布尔型，可选参数，默认为true，即显示“前一页”按钮
 next_show_always	是否显示“下一页”分页按钮	布尔型，可选参数，默认为true，即显示“下一页”按钮
 callback	回调函数	默认无执行效果*/

/**
 * 获取列表数据总条目数
 */
function getListCount(callback){
    var total = 0;
    jQuery.ajax({
        url:basePath+'/customerBaseInfoOrder/count',
        dataType:'JSON',
        data:{
            saleOrganizationId:$('#oSaleOrganizationId').val(),
            ncOrderId:$('#oNcOrderId').val(),
            startTime:$('#oStartTime').val(),
            endTime:$('#oEndTime').val()
        },
        async:true,//同步加载
        method:'POST',
        success:function(data){
            total = data.data;
            callback(total);
        }
    });
    // return total;
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
        id = $('#tree').attr('id'),
        treeObj = null;
    treeData = CRM.toArr(data);

    $.fn.zTree.init($('#tree'), setting, treeData);
    treeObj = $.fn.zTree.getZTreeObj(id);
    treeObj.expandAll(true); // 默认展开
}

/**
 * 树点击事件
 * @param event
 * @param modLeftId
 * @param treeNode
 */

function ablclickTree(event, modLeftId, treeNode) {

    $('#oSaleOrganizationId').val(treeNode.id);
    $('#oSaleOrganizationName').val(treeNode.name);

    $('#treeModal').modal('hide');
}

/**
 *获取数据
 */
function customerOrderHis(result,pn,pz) {
    var tbody = $('#oTbody');
    tbody.html('');
    if(result && result!='' && result!=null){
        var getData = result;
        // var count = 0;
        var  countItem = (pn)*pz;
        var arr = ['否','是'];
        $.each(getData,function (n,item) {
            var tr = '';
            tr += '<tr>';
            tr += '<td>'+ (++countItem) +'</td>';
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

/**
 * 查询提交数据
 * @param total
 */
function serach(total){
    // var total = getListCount();
    getDataList(0);
    $("#oPagination").pagination(total,{
        items_per_page : pageSize,
        num_edge_entries : 3,
        num_display_entries : 10,
        callback:getDataList
    });
}

/**
 * 根据页码获取列表数据
 * @param pageNum
 * @param jq
 */
function getDataList(pageNum,jq){
    jQuery.ajax({
        url:basePath+'/customerBaseInfoOrder/getListByPage',
        dataType:'json',
        data:{
            saleOrganizationId:$('#oSaleOrganizationId').val(),
            ncOrderId:$('#oNcOrderId').val(),
            startTime:$('#oStartTime').val(),
            endTime:$('#oEndTime').val(),
            startRow:pageNum*pageSize,
            pageSize:pageSize
        },
        async:true,
        type:'POST'
    }).done(function (result) {
        var data = result.data;
        customerOrderHis(data,pageNum,pageSize);
    });
}