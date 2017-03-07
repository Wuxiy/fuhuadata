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
        //取得html容器
        var $container = $('#'+containerId);
        //给树形菜单添加点击事件
        this.on('click','li[id]>a',function(e){
            //阻止a的默认事件
            e.preventDefault();
            var id = $(e.target).parent('li').attr('id');
            console.log(id);
            $.post(url,{id:id},function(data,status){
                if(method=='packingArchivesList'){
                    $container.html('');
                    //调用不同的渲染方法
                    methods[method](data.data,$container);
                }else if(method=='productArchivesList'){
                    methods[method](data.data);
                }

            });
            return false;
        });
        var methods={
            //渲染包材成本列表
            packingArchivesList : function(getData,parent){
                $.each(getData,function(n,item){
                    var tr = $('<tr></tr>');
                    $(tr).append('<td>'+item.packingId+'</a></td><td><a href="/packingArchives/getDetails?id='+item.packingId+'">'+item.packName+'</a></td><td>'+item.spec+'</td><td>'+item.quality+'</td><td>'+item.qualityIndex+'</td><td>'+item.qualityTargetValue+'</td><td>'+item.unitPrice+'</td><td>'+item.priceEndDate+'</td><td>'+item.suitableType+'</td><td>'+item.bRemarks+'</td><td>'+item.status+'</td>').appendTo(parent);
                })
             },
            //渲染标准产品档案
            productArchivesList : function(getData){
                $.each(getData,function(n,total){
                    console.log(total);
                    $.each(total,function(key,item){
                        var $formControl=$('[name="'+ key +'"]');
                        if($formControl.attr('type')=='radio'||$formControl.attr('type')=='checkbox'){
                            var arr=[item];
                            $formControl.val(arr);
                        }else{
                            $formControl.val(item);
                        }
                        // if($formControl[0].tagName=='INPUT'){
                        //
                        // }else if($formControl[0].tagName=='TBODY'){
                        //     $.each(item,function(name,value){
                        //         var $tr = $('<tr></tr>');
                        //         $tr.append('<td name="'+name+'"></td>')
                        //     })
                        // }
                    })
                })
             }
        }
    };
})( jQuery );

