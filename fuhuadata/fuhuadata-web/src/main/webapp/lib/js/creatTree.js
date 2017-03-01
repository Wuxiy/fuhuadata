// + function ($) {
// 	'use strict';
// 	var menulist = {
//         "menulist": [
//              { "MID": "M001", "MName": "首页", "Url": "#", "menulist": "" },
//             { "MID": "M002", "MName": "车辆买卖", "Url": "#", "menulist":
//                  [
//                       { "MID": "M003", "MName": "新车", "Url": "#", "menulist":
//                          [
//                              { "MID": "M006", "MName": "奥迪", "Url": "#", "menulist": "" },
//                              { "MID": "M007", "MName": "别克", "Url": "#", "menulist": "" }
//                          ]
//                       },
//                       { "MID": "M004", "MName": "二手车", "Url": "#", "menulist": "" },
//                       { "MID": "M005", "MName": "改装车", "Url": "#", "menulist": "" }
//                  ]
//              },
//              { "MID": "M006", "MName": "宠物", "Url": "#", "menulist": "" }
//        ]
//      };
//
// 	var treeData = menulist.menulist;
// 	var $tree = $("#characterTree");
// 	var treeRoot = $('<ul class="tree-root"></ul>');
// 	$tree.html("");
// 	creatTree(treeData,treeRoot);
//     $tree.append(treeRoot);
//     function creatTree(obj,parent) {
//         $.each(obj, function(n,item){
// 	     	if(item.menulist.length>0) {
//                  var li = $("<li></li>");
//                  $(li).append('<span class="branch-node" data-toggle="collapse" data-target="#'+item.MID+'"></span><a href=""><span class="leaf"></span>'+item.MName+'</a>').append('<ul id="'+item.MID+'" class="tree-branch collapse in"></ul>').appendTo(parent);
//                  creatTree(item.menulist, $(li).children("ul.tree-branch"));
// 	     	}else{
//                 $("<li></li>").append('<span class="branch"></span><a href=""><span class="leaf"></span>'+item.MName+'</a>').appendTo(parent);
// 	     	}
//         });
//      };
// }(jQuery);

(function( $ ) {
    //动态生成树形菜单
    $.fn.creatTree = function(url) {
        var tree = this;
        tree.html('');
        var treeRoot = $('<ul class="tree-root"></ul>');
         $.get(url,function(data,status){
            if(status == 'success'){
                creatBranch(data.data,treeRoot);
                tree.append(treeRoot);
            }
        });
        function creatBranch(getData,parent){
            $.each(getData,function(n,item){
                var li = $('<li id="'+item.cid+'"></li>');
                if(item.nodes.length > 0) {
                    $(li).append('<span class="branch-node" data-toggle="collapse" data-target="#t'+item.cid+'"></span><a href=""><span class="leaf"></span>'+item.cname+'</a>').append('<ul id="t'+item.cid+'" class="tree-branch collapse in"></ul>').appendTo(parent);
                    creatBranch(item.nodes, $(li).children("ul.tree-branch"));
                }else{
                    $(li).append('<span class="branch"></span><a href=""><span class="leaf"></span>'+item.cname+'</a>').appendTo(parent);
                }
            })
        }
    };
    //给树形菜单动态添加点击事件，并且获取数据，将数据渲染到表格或者表单
    $.fn.filtrateData = function(url,containerId,method){

        var $container = $('#'+containerId);
        this.on('click','li[id]>a',function(e){
            e.preventDefault();
            var id = $(e.target).parent('li').attr('id');
            console.log(id);
            $.post(url,{id:id},function(data,status){
                console.log(data);
                $container.html('');
                //调用不同的渲染方法
                methods[method](data.data,$container);
            })
            return false;
        });
        var methods={
            //包材成本列表渲染方法
            packingArchivesList : function(getData,parent){
                $.each(getData,function(n,item){
                    var tr = $('<tr></tr>');
                    $(tr).append('<td><a href="">'+item.packingId+'</a></td><td>'+item.packName+'</td><td>'+item.spec+'</td><td>'+item.quality+'</td><td>'+item.qualityIndex+'</td><td>'+item.qualityTargetValue+'</td><td>'+item.unitPrice+'</td><td>'+item.priceEndDate+'</td><td>'+item.suitableType+'</td><td>'+item.bRemarks+'</td><td>'+item.status+'</td>').appendTo(parent);
                })
        }
        }
    };
})( jQuery );