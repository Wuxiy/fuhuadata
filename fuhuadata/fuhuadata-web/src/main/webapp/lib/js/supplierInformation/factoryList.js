/**
 * Created by huxiangyang on 2017/6/13.
 */

$(function(){
    var table = {
        pageSize:1,
        pageNum:0,
        pagination:$('#pagination'),
        container:$('#factory_list'),
        setPagination:{
            num_edge_entries:3,
            num_display_entries:3,
            callback:function (pageNum,jq) {
                $.ajax({
                    url:basePath + '/supplier/factories',
                    dataType:'json',
                    contentType:'application/json',
                    data:{
                        pageSize:table.pageSize,
                        index:pageNum+1
                    },
                    async:true,
                    type:'GET'
                }).done(function(res){

                    if (res.code===1) { // 请求是否成功

                        table.renderList(res.data.list, (res.data.pageNum-1)*res.data.pageSize);
                    }
                });

            }
        },
        init:function () {
            $.ajax({
                url:basePath + '/supplier/factories',
                dataType:'json',
                contentType:'application/json',
                data:{
                    pageSize:table.pageSize,
                    index:1
                },
                async:true,
                type:'GET'
            }).done(function (res) {
                if (res.code===1) { // 请求是否成功

                    if(!table.total){ // 是否需要渲染分页

                        table.total = res.data.total;
                        table.renderPagination();
                    }
                    table.renderList(res.data.list, (res.data.pageNum-1)*res.data.pageSize);
                }
            });
        },
        renderList:function (list, count) {
            var tpl = '',
                count = count;

            if (Array.isArray(list)) {

                $.each(list, function(i, item){
                    tpl +=
                        '<tr>' +
                        '<td>'+(++count)+'</td>'+
                        '<td>'+table.hasField(item.code)+'</td>'+
                        '<td><a href="'+basePath+'/supplier/factories/'+table.hasField(item.id)+'/vm">'+table.hasField(item.name)+'</a></td>'+
                        '<td>'+table.hasField(item.abbr)+'</td>'+
                        '<td></td>'+
                        '<td>'+table.hasField(item.cooperateTime)+'</td>'+
                        '<td></td>'+
                        '<td>'+table.hasField(item.score)+'</td>'+
                        '<td>'+table.hasField(item.manager)+'</td>'+
                        '<td>'+table.hasField(item.remark)+'</td>'+
                        '</tr>';
                });
            }else {

                tpl += '<tr><td colspan="10">暂无数据</td></tr>';
            }
            this.container.html(tpl);
        },
        renderPagination:function () {
            this.setPagination.items_per_page = this.pageSize;
            this.pagination.pagination(this.total,this.setPagination);
        },
        hasField:function (field) {

            if (field===null||field===undefined){
                return '';
            }else {
                return field;
            }
        }
    };
    table.init();
});