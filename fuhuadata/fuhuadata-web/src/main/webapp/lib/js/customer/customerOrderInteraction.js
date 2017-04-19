/**
 * Created by Huxiangyang on 2017/3/30.
 */

var pageSize = 3;//分页步长
var treeData = null;
$(function(){

    //搜索按钮绑定事件
    $("#oSubmit").click(function(){
        // serach();
        getListCount(serach);
    });

    // 默认查询数据
    getListCount(serach);

    // 点击弹出modal，并渲染树
    $('#popupMd').on('click.tree',function () {

        $('#treeModal').modal('show');
        if (treeData==null) {
            $.ajax({
                url:basePath+'/customerBaseInfoOrder/initSaleOrganizationTree',
                type:'GET'
            }).done(function (result) {
                var data = result.data;
                renderTree(data);
            })
        }
    })
});


