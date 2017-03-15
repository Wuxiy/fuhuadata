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
                    $(li).append('<span class="branch"></span><a class="cNode" href=""><span class="leaf"></span>'+item.cname+'</a>').appendTo(parent);
                }
            })
        }
    };
    $.fn.bindClickForCusArea = function(obj){
        //给树形菜单添加点击事件
        this.on('click','li[id]>a',function(e){
            //阻止a的默认事件
            e.preventDefault();
            var id = $(e.target).parent('li').attr('id');
            //取得被点击节点的id
            if(id=='0'){
                //点击的是全部
                obj.oneLevelId = 0;
                obj.twoLevelId = 0;
            }else if ($(e.target).parent('li').parent('ul').parent('ul').hasClass('tree-root')){
                //说明当前点击的是二级目录
                obj.oneLevelId = id;
                obj.twoLevelId = 0;
            }else{
                //当前点击的是子目录，需要查出父id
                obj.twoLevelId = id;
                obj.oneLevelId = $(e.target).parent('li').parent('ul').parent('li').attr('id');
            }
            obj.serach();
        });
    };
    //给树形菜单动态添加点击事件，并且获取数据，将数据渲染到表格或者表单
    $.fn.filtrateData = function(url,containerId,method){
        //取得html容器
        var $container = $('#'+containerId);
        //给树形菜单添加点击事件
        this.on('click.getData','li[id]>a',function(e){
            //阻止a的默认事件
            e.preventDefault();
            var id = $(e.target).parent('li').attr('id');
            $.post(url,{id:id},function(data,status){
                if(method=='packingArchivesList'){
                    $container.html('');
                    //调用不同的渲染方法
                    methods[method](data.data,$container);
                }else if(method=='productArchivesList'){
                    methods[method](data.data);
                }else if(method=='packingInfoModal'){
                    $container.html('');
                    methods[method](data.data,$container);
                }

            });
            return false;
        });
        var methods={
            //渲染包材成本列表
            packingArchivesList : function(getData,parent){
                $.each(getData,function(n,item){
                    var tr = $('<tr></tr>');
                    var arr = item.suitableType;
                    var arr2 = arr.split(',');
                    console.log(item);

                    $(tr).append('<td>'+item.packingId+'</td><td><a href="${request.contextPath}/packingArchives/getDetails?id='+item.packingId+'&bid='+item.bigCategoryId+'&sid='+item.smallCategoryId+'" class="packName">'+item.packName+'</a></td><td>'+item.spec+'</td><td>'+item.quality+'</td><td>'+item.qualityIndex+'</td><td>'+item.qualityTargetValue+'</td><td>'+item.unitPrice+'</td><td>'+item.priceEndDate+'</td><td>'+arr2+'</td><td>'+item.bRemarks+'</td><td>'+item.status+'</td>').appendTo(parent);
                })
             },
            //渲染包材详情modal列表
            packingInfoModal : function(getData,parent){
                $.each(getData,function(n,item){
                    var tr = $('<tr></tr>');
                    console.log(item);
                    $(tr).append('<td><input type="checkbox" value="'+item.packingId+'" name="modal_cellcheckbox"/></td><td>'+item.packingId+'</td><td>'+item.packName+'</td><td>'+item.spec+'</td><td>'+item.size+'</td><td>'+item.quality+'</td><td>'+item.unitPrice+'</td><td>'+item.consumption+'</td><td>'+item.status+'</td>').appendTo(parent);
                })
            },
            //渲染标准产品档案
            productArchivesList : function(getData){
                $.each(getData,function(n,total){
                    $.each(total,function(key,item){
                        var $formControl=$('[name="'+ key +'"]');
                        if($formControl.attr('type')=='radio'||$formControl.attr('type')=='checkbox'){
                            var arr=[item];
                            $formControl.val(arr);
                        }else{
                            $formControl.val(item);
                        }
                    })
                });

                $.each(getData.productInfo,function(key,item){
                    console.log(item);
                    var formControl=$('[name="'+ key +'"]');
                    if(formControl.attr('type')=='radio'||formControl.attr('type')=='checkbox'){
                        var arr=[item];
                        formControl.val(arr);
                    }else {
                        formControl.val(item);
                    }
                });
                var wTbody = $('[name="wares"]');
                wTbody.html('');
                $.each(getData.wares,function(key,item){
                    var tr = $("<tr></tr>");
                    tr.append('<td>'+item.specification+'</td><td>'+item.model+'</td>').appendTo(wTbody);
                });
                var iTbody = $('[name="physicalProperities"]');
                iTbody.html('');
                jQuery.each(getData.index,function(key,item){
                    var tr = $("<tr></tr>");
                    tr.append('<td><input class="form-control" type="text" disabled value="'+item.index+'"></td><td><input class="form-control" type="text" disabled value="'+item.value+'"></td><td style="position: relative"><input class="form-control" type="text" disabled value="'+item.remarks+'"/><button type="button" class="close hidden" data-form-btn="del" data-form-target="tr" style="position: absolute;top:6px;right:-15px;">×</button></td>').appendTo(iTbody);
                });
                var pTbody = $('[name="processingComponents"]');
                pTbody.html('');
                jQuery.each(getData.processingComponents,function(key,item){
                    var tr = $("<tr></tr>");
                    tr.append('<td><input class="form-control" type="text" disabled value="'+item.componentName+'"></td><td><input class="form-control" type="text" disabled value="'+item.consumption+'"></td><td style="position: relative"><input class="form-control" type="text" disabled value="'+item.remarks+'"/><button type="button" class="close hidden" data-form-btn="del" data-form-target="tr" style="position: absolute;top:6px;right:-15px;">×</button></td>').appendTo(pTbody);
                });
             }
        }
    };
})( jQuery );

