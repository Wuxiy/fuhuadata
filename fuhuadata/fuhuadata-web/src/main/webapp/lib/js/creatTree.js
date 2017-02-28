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
    $.fn.creatTree = function(url) {
        this.html('');
        var treeRoot = $('<ul class="tree-root"></ul>');
         $.get(url,function(data,status){
            if(status == 'success'){

                creatBranch(data.data,treeRoot);
                console.log(data.data);
            }
        });
        function creatBranch(getData,parent){
            $.each(getData,function(n,item){
                if(item.nodes.length > 0) {
                    var li = $("<li></li>");
                    $(li).append('<span class="branch-node" data-toggle="collapse" data-target="#t'+item.cid+'"></span><a href=""><span class="leaf"></span>'+item.cname+'</a>').append('<ul id="t'+item.pid+'" class="tree-branch collapse in"></ul>').appendTo(parent);
                    creatBranch(item.nodes, $(li).children("ul.tree-branch"));
                }else{
                    $("<li></li>").append('<span class="branch"></span><a href=""><span class="leaf"></span>'+item.cname+'</a>').appendTo(parent);
                }
            })
        }
    };
})( jQuery );