(function( $ ) {
    //动态生成树形菜单
    $.fn.creatTree = function(url) {
        var tree = this;
        tree.html('');
        var treeRoot = $('<ul class="tree-root"></ul>');
         $.ajax({
             url:url,
             type:'GET',
             async:false    //这里是同步请求
         }).done(function(result){
             creatBranch(result.data,treeRoot);
             tree.append(treeRoot);
         });
        function creatBranch(getData,parent){
            if(getData instanceof Array && getData.length>0){
                $.each(getData,function(n,item){
                    var li = $('<li id="'+item.cid+'"></li>');
                    if( item.nodes!=null && item.nodes.length > 0) {
                        $(li).append('<span class="branch-node" data-toggle="collapse" data-target="#t'+item.cid+'"></span><a><span class="leaf"></span>'+item.cname+'</a>').append('<ul id="t'+item.cid+'" class="tree-branch collapse in"></ul>').appendTo(parent);
                        creatBranch(item.nodes, $(li).children("ul.tree-branch"));
                    }else{
                        $(li).append('<span class="branch"></span><a class="cNode"><span class="leaf"></span>'+item.cname+'</a>').appendTo(parent);
                    }
                })
            }
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
            }else if ($(e.target).parent('li').parent('ul').parent('li').attr("id")=='0'){
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

            var p = $(e.target).parents('.tree-root');
            p.find('.active').removeClass('active');
            var nowEl = $(e.target).parent('li');
            nowEl.addClass('active');
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
                }else if(method=='packingorderlist'){
                    $container.html('');
                    methods[method](data.data,$container);
                }
            });
            return false;
        });
        var methods={
            //渲染包材成本列表
            packingArchivesList : function(getData,parent){
                if(getData!=undefined){
                    $.each(getData,function(n,item){
                        var tr = $('<tr></tr>');
                        var arr = item.suitableType;
                        var arr2 = arr.split(',');
                        /*console.log(item);*/
                        $(tr).append('<td>'+item.packingId+'</td><td><a href="'+basePath+'/packingArchives/getDetails?id='+item.packingId+'&bid='+item.bigCategoryId+'&sid='+item.smallCategoryId+'" class="packName">'+ifEmpty(item.packName)+'</a></td><td>'+ifEmpty(item.spec)+'</td><td>'+ifEmpty(item.quality)+'</td><td>'+ifEmpty(item.qualityIndex)+'</td><td>'+ifEmpty(item.qualityTargetValue)+'</td><td>'+ifEmpty(item.unitPrice)+'</td><td>'+ifEmpty(item.priceEndDate)+'</td><td>'+replace(ifEmpty(item.suitableType))+'</td><td>'+ifEmpty(item.bRemarks)+'</td><td>'+ifEmpty(item.status)+'</td>').appendTo(parent);
                    })
                }
             },
            //渲染包装要求包材列表
            packingorderlist:function (getData,parent) {
                if(getData!=undefined){
                    $.each(getData,function(n,item){
                        var tr = $('<tr></tr>');
                        $(tr).append('<td><input type="checkbox" value="'+item.packingId+'" name="cellcheckbox"/></td><td>'+item.packingId+'</td><td>'+item.packName+'</td><td>'+item.spec+'</td><td>'+item.size+'</td><td>'+item.quality+'</td><td>'+item.unitPrice+'</td><td>'+item.status+'</td>').appendTo(parent);
                    })
                }

            },
            //渲染包材详情modal列表
            packingInfoModal : function(getData,parent){
                if(getData!=undefined){
                    $.each(getData,function(n,item){
                        var tr = $('<tr></tr>');
                        /*console.log(item);*/
                        $(tr).append('<td><input type="checkbox" value="'+item.packingId+'" name="modal_cellcheckbox"/></td><td>'+item.packingId+'</td><td>'+item.packName+'</td><td>'+item.spec+'</td><td>'+item.size+'</td><td>'+item.quality+'</td><td>'+item.unitPrice+'</td><td>'+item.consumption+'</td><td>'+item.status+'</td>').appendTo(parent);
                    })
                }
            },
            //渲染标准产品档案
            productArchivesList : function(getData){
                //表单处理
                jQuery.each(getData.productInfo,function(key,item){
                    if(key!='physicalProperities'&& key!='processingComponents'){
                        var formControl=$('[name="'+ key +'"]');
                        // console.log(key);
                        if(formControl.attr('type')=='radio'||formControl.attr('type')=='checkbox'){
                            var arr=[item];
                            formControl.val(arr);
                        }else {
                            formControl.val(item);
                        }
                        if(key=='saltType'){
                            var elseSelected = formControl.filter('.else');
                            var targetEl = formControl.parents('.form-group').find('.elseInput');
                            if(elseSelected.prop('checked')){
                                /*console.log(formControl.prop('checked'));*/
                                targetEl.removeClass('hidden');
                            }else{
                                targetEl.addClass('hidden');
                            }
                        }
                    }
                });
                //表格处理
                var wTbody = $('[name="wares"]');
                var iTbody = $('[name="physicalProperities"]');
                var pTbody = $('[name="processingComponents"]');
                var iThead = $('<thead><tr><th class="text-center col-xs-4" lang="zh">指标</th><th class="text-center col-xs-4" lang="zh">值</th><th class="text-center col-xs-4" lang="zh">备注</th></tr></thead>');
                var iTfoot = $('<tfoot class="editView hidden"><tr><td colspan="3"><button id="addIndexItem" data-form-btn="add" class="btn btn-xs btn-link hidden" type="button" lang="zh">继续添加</button></td></tr></tfoot>');
                var pThead = $('<thead><tr><th class="text-center col-xs-4" lang="zh">原料</th><th class="text-center col-xs-4" lang="zh">单耗（kg/KL）</th><th class="text-center col-xs-4" lang="zh">备注</th></tr></thead>');
                var pTfoot = $('<tfoot class="editView hidden"><tr><td colspan="3"><button id="addProItem" data-form-btn="add" class="btn btn-xs btn-link hidden" type="button" lang="zh">继续添加</button></td></tr></tfoot>');

                wTbody.add(iTbody).add(pTbody).html('');
                if(getData.productInfo.midCategoryId==8){
                    var textIndex = getData.productInfo.physicalProperities;
                    var textProcessingComponents = getData.productInfo.processingComponents;
                    var iTextarea = $('<tr><td colspan="3"><textarea class="form-control" rows="3" disabled></textarea></td></tr>');
                    var pTextarea = $('<tr><td colspan="3"><textarea class="form-control" rows="3" disabled></textarea></td></tr>');
                     iTextarea.find('textarea').val(textIndex).end().appendTo(iTbody);
                    pTextarea.find('textarea').val(textProcessingComponents).end().appendTo(pTbody);
                    iTbody.siblings().add(pTbody.siblings()).remove();
                }else{
                    iTbody.siblings().add(pTbody.siblings()).remove();
                    if(getData.wares!=null){
                        jQuery.each(getData.wares,function(key,item){
                            var tr = $("<tr></tr>");
                            tr.append('<td>'+item.specification+'</td><td>'+item.model+'</td>').appendTo(wTbody);
                        });
                    }
                    if(getData.index!=null){
                        iTbody.siblings().remove();
                        jQuery.each(getData.index,function(key,item){
                            var tr = $("<tr></tr>");
                            tr.append('<td><input class="form-control" type="text" disabled value="'+item.index+'"></td><td><input class="form-control" type="text" disabled value="'+item.value+'"></td><td style="position: relative"><input class="form-control" type="text" disabled value="'+item.remarks+'"/><button type="button" class="close hidden" data-form-btn="del" data-form-target="tr" style="position: absolute;top:6px;right:-15px;">×</button></td>').appendTo(iTbody);
                        });
                    }
                    if(getData.processingComponents!=null){
                        pTbody.siblings().remove();
                        jQuery.each(getData.processingComponents,function(key,item){
                            var tr = $("<tr></tr>");
                            tr.append('<td><input class="form-control" type="text" disabled value="'+item.componentName+'"></td><td><input class="form-control" type="text" disabled value="'+item.consumption+'"></td><td style="position: relative"><input class="form-control" type="text" disabled value="'+item.remarks+'"/><button type="button" class="close hidden" data-form-btn="del" data-form-target="tr" style="position: absolute;top:6px;right:-15px;">×</button></td>').appendTo(pTbody);
                        });
                    }
                    iThead.insertBefore(iTbody);
                    iTfoot.insertAfter(iTbody);
                    pThead.insertBefore(pTbody);
                    pTfoot.insertAfter(pTbody);
                }
             }
        }
    };
})( jQuery );

