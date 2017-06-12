/**
 * Created by Huxiangyang on 2017/6/12.
 */

$(function(){
    var supprops=['常规','非常规','自定'],
        tms=['汽运','船运','铁路','航空','其他'],
        table = {
            total:0,
            pageSize:1,
            pageNum:0,
            pagination:$('#pagination'),
            container:$('#forwarding_list'),
            setPagination:{
                num_edge_entries:3,
                num_display_entries:5,
                callback:function (pageNum,jq) {
                    $.ajax({
                        url:basePath + '/supplier/forwarding/forwardingList',
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

                            table.renderList(res.data.list);
                        }
                    });

                }
            },
            init:function () {
                $.ajax({
                    url:basePath + '/supplier/forwarding/forwardingList',
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
                        table.renderList(res.data.list);
                    }
                });
            },
            renderList:function (list) {
                var tpl = '';
                $.each(list, function(i, item){
                    tpl +=
                        '<tr>' +
                        '<td>'+table.hasField(item.code)+'</td>'+
                        '<td><a href="'+basePath+'/supplier/forwarding/intoForwardingBasic?id='+table.hasField(item.id)+'">'+table.hasField(item.name)+'</a></td>'+
                        '<td>'+table.hasField(item.shortname)+'</td>'+
                        '<td>'+supprops[table.hasField(item.supprop)]+'</td>'+
                        '<td>'+tms.filter(function (e,i) {
                            return this.indexOf(i+'')!==-1;
                        },item.transportationMethods.split(',')).join('、')+'</td>'+
                        '<td>'+table.hasField(item.startCooperateTime)+'</td>'+
                        '<td>'+table.hasField(item.cooperateTime)+'</td>'+
                        '<td>'+table.hasField(item.combinedScoring)+'</td>'+
                        '<td>'+table.hasField()+'</td>'+
                        '<td>'+table.hasField()+'</td>'+
                        '<td>'+table.hasField()+'</td>'+
                        '</tr>';
                });
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