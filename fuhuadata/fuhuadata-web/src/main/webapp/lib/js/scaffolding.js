/**
 * Created by Think on 2017/3/13.
 */
(function($){

    //初始化方法
    function initPage(){
        //禁用表单控件
        var formEl=$('.panel-edit .form-control, .panel-edit input[type="checkbox"], .panel-edit input[type="radio"]');
        formEl.attr('disabled','disabled');
        //隐藏表单操作按钮
        var formBtn=$('.panel-edit .panel-body [data-form-btn]');
        formBtn.addClass('hidden');
        //获取数据
        upDown(obj);
    }

    /**
     * 获取和提交数据
     */
    function upDown(obj){
        //参数：type,url,data,callBack
        var u,t,d,c;
        u = obj.u;
        t = obj.t;
        d = obj.d;
        c = obj.upCB;
//				console.log(u);

        $.ajax({
            url:u,
            type:t,
            data:d
        }).done(function(){
            //成功回调方法,一般是渲染页面数据
            c();
        }).fail(function(){
            //失败回调方法
            console.log('获取数据失败');
        });
    }

    //渲染
    function rendererData(result){
        //循环数据取值，并将值赋给有相同name的标签
        var data = result;
    }

    //事件监听
    function listenEv(obj){
        //参数：type,el,fn
        var t,e,c;
        t = obj.type;
        el = obj.el;
        c = obj.lisCB;
//				console.log(obj.upObj);
        $(document).on(t+'.listenEv',el,function(e){
            var el = $(e.target);
            //判断有无upObj参数，ouObj为upDown参数
            if(obj.upObj!=undefined){
                obj.el = el;
                c(obj);
            }else{
                c(el);
            }

        });
    }

    //--保存&&编辑功能
    //**一般作为事件监听的回调函数
    function saveEdit(obj){
        //参数：el,upObj
        var el,o;
        if(obj.upObj!=undefined){
            el = obj.el;
            o=obj.upObj;
        }else{
            el = obj;
        }
        var pBody = el.parents('.panel').find('.panel-body');
        var pHeader = el.parents('.panel').find('.panel-heading');
        var formEl = pBody.find('.form-control,[type="checkbox"]').not('.noEdit');//编辑的标签
        var formBtn = pBody.find('[data-form-btn]');//操作按钮
        var editHide = pBody.find('.editHide');//编辑状态需要隐藏的标签
        var editView = pBody.find('.editView');//编辑状态需要显示的标签
        var saveBtnGroup = pHeader.find('[data-form-btn="save"]').parent('.btn-group');//当前保存&取消按钮组
        var edit = pHeader.find('[data-form-btn="edit"]');//当前编辑按钮
        if(el.data('form-btn')=="edit"){//编辑按钮执行的操作
//				console.log(el.data('form-btn'));
            formEl.removeAttr('disabled');
            formBtn.removeClass('hidden');
            editHide.addClass('hidden');
            editView.removeClass('hidden');
            saveBtnGroup.removeClass('hidden');
            el.addClass('hidden');
        }else if(el.data('form-btn')=="save"||el.data('form-btn')=="cancel"){//保存&取消按钮执行操作

            if (el.data('form-btn')=="save"){
                //是否确认提交
                var r=confirm("是否确认提交!");
                if(r==true){
                    //提交数据
                    upDown(o);
                    formEl.attr('disabled','disabled');
                    formBtn.addClass('hidden');
                    editHide.removeClass('hidden');
                    editView.addClass('hidden');
                    edit.removeClass('hidden');
                    saveBtnGroup.addClass('hidden');
                    alert("提交成功!");
                }else{
                    console.log('取消提交');
                }
            }else{
                formEl.attr('disabled','disabled');
                formBtn.addClass('hidden');
                editHide.removeClass('hidden');
                editView.addClass('hidden');
                edit.removeClass('hidden');
                saveBtnGroup.addClass('hidden');
            }
        }
    }

    //--添加元素
    //**一般作为事件监听的回调函数
    function addEl(obj){
        //参数：el
        var btn = obj;
        elName= btn.data('form-target');
        el = $('[data-name="'+elName+'"]').slice(0,1);
        pl = $('[data-place="'+elName+'"]');
        //添加不同元素的特殊处理
        var newEl,formTar,delBtn;
        delBtn= $('<button type="button" class="close" data-form-btn="del">&times;</button>').css('fontSize','24px');
        newEl = el.clone().removeAttr('data-name');
        var addFromGroup = function(){
            formTar = 'form-group';
            delBtn.data('form-target',formTar);
            newEl.find('input').val('');
            newEl.append('<div class="pull-left"></div>').find('.pull-left').append(delBtn);
            pl.before(newEl);
        }
        var addTr = function(){
            formTar = 'tr';
            delBtn.css({
                'position':'absolute',
                'right':'-25px',
                'top':'3px'
            }).data('form-target',formTar);
            newEl.find('input').val('');
            newEl.find('td').last().css('position','relative').append(delBtn);
            pl.before(newEl);
        }
        var addTbody = function(){
            var count = 0;
            count++;
            formTar = 'tbody';
            delBtn.css({
                'position':'absolute',
                'left':'-25px'
            }).data('form-target',formTar);
            newEl.find('tr').slice(2,-1).remove().find('input').val('');
            var newBtn = newEl.find('[data-form-target]').data('form-target')+count;
            console.log(newBtn);
            newEl.find('tr').first().find('th').first().css('position','relative').append(delBtn);
            newEl.find('[data-name]').attr('data-name',newBtn);
            newEl.find('[data-place]').attr('data-place',newBtn);
            newEl.find('[data-form-target]').attr('data-form-target',newBtn);
            pl.before(newEl);
//					newEl.find('data-place').data('place',newBtn);
        }
        if(el.is('.form-group')){
            addFromGroup();
        }else if(el.is('tr')){
            addTr();
        }else if(el.is('tbody')){
            addTbody();
        }

    }

    //--删除元素
    //**一般作为事件监听的回调函数
    function delEl(el){
        var tar = el.data('form-target');//取得data-form-target属性值
        var tarEl = el.parents('.'+tar)[0]||el.parents(tar)[0];//删除class等于该属性值的第一个祖先元素
        $(tarEl).remove();
    }

    //渲染包材档案列表
    function packingAchivesList(getData){
        $.each(getData,function(n,item){
            var tr = $('<tr></tr>');
            console.log(item);
            $(tr).append('<td>'+item.packingId+'</td><td><a href="/packingArchives/getDetails?id='+item.packingId+'&bid='+item.bigCategoryId+'&sid='+item.smallCategoryId+'" class="packName">'+item.packName+'</a></td><td>'+item.spec+'</td><td>'+item.quality+'</td><td>'+item.qualityIndex+'</td><td>'+item.qualityTargetValue+'</td><td>'+item.unitPrice+'</td><td>'+item.priceEndDate+'</td><td>'+item.suitableType+'</td><td>'+item.bRemarks+'</td><td>'+item.status+'</td>').appendTo(parent);
        })
    }

})(jQuery);