/**
 * Created by Huxiangyang on 2017/3/30.
 */

var pageSize = 2;//分页步长

$(function(){

    //创建面包屑导航
    $('#location').append(createCrumbsD());

    //设置title标题
    var title = $('#pTitle').text()+'——'+$('#sTitle').text();
    $('#hTitle').text(iGetInnerText(title));

    //生成地区目录树
    $('#tree').creatTree(basePath+'/customerBaseInfoOrder/initSaleOrganizationTree');

    //搜索按钮绑定事件
    $("#oSubmit").click(function(){
        serach();
    });

    //双击文本添加到指定文本框
    $(document).on('click','#tree a',function (e) {
        e.preventDefault();
    });
    $(document).on('dblclick','#tree a',function (e) {
        var close = $(e.target).parents('.modal').find('.close');
        var txt = $(e.target).text();
        var id = $(e.target).parent('li').attr('id');
        $('#oSaleOrganizationId').val(id);
        $('#oSaleOrganizationName').val(txt);
        close.click();
    });

    // 默认查询数据
    serach();
});

//查询按钮提交数据
function serach(){
    var total = getListCount();
    getDataList(0);
    $("#oPagination").pagination(total,{
        items_per_page : pageSize,
        num_edge_entries : 3,
        num_display_entries : 10,
        callback:getDataList
    });
}

//根据页码获取列表数据
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
        customerOrderHis(data);
    });
}

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
function getListCount(){
    var total = 0;
    jQuery.ajax({
        url:basePath+'/customerBaseInfoOrder/count',
        dataType:'JSON',
        data:{
            saleOrganizationId:$('#oSaleOrganizationId').val(),
            ncOrderId:$('#oNcOrderId').val(),
            startTime:$('#oStartTime').val(),
            endTime:$('#oEndTime').val(),
        },
        async:false,//同步加载
        method:'POST',
        success:function(data){
            total = data.data;
        }
    });
    return total;
}

