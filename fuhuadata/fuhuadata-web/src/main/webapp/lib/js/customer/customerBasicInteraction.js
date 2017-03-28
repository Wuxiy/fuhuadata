/**
 * Created by huxiangyang on 2017/3/13.
 */

$(function () {
    //select——国家&地区联动下拉框
    $.ajax({
        url:basePath+'/customerBaseInfo/initAreaCategoryTree',
        type:'GET'
    }).done(function (result) {
        var data = result.data[0].nodes;
        var areaId = $('#areaId');
        var countryId = $('#countryId');
        var options = '';
        $.each(data,function (n,area) {
            options += '<option value="'+area.cid+'">'+area.cname+'</option>';
        });
        areaId.append(options);
        $(document).on('change.screen','#areaId',function () {
            var val = $(this).val();
            $.each(data,function (n,area) {
                var options = '';
                if(val!=0 && val==area.cid){
                    options += '<option value="0" selected lang="zh">——请选择国家——</option>';
                    $.each(area.nodes,function (n,state) {
                        options += '<option value="'+state.cid+'">'+state.cname+'</option>';
                    });
                    countryId.html(options);
                    return false;
                }else if(val=='-1'){
                    options += '<option value="0" selected lang="zh">——请优先选择地区——</option>';
                    countryId.html(options);
                    return false;
                }else {
                    return true;
                }
            });
        });
    });

    //新增页面——customerId为空字符串说明是新增页面
    if($('#customerId').val()==''){
        $('#customerType').val('2').attr('disabled','disabled');
        $('button').filter(editBtn).remove();
        $('.editHide').addClass('hidden');
        $('#deputyNav').children('li').slice(4).remove();
        $('.editView').removeClass('hidden');
        var finishBtn = '';
        finishBtn += '<div class="form-group">';
        finishBtn += '<div class="col-xs-2 col-xs-offset-4">';
        finishBtn += '<button id="resetForm" class="btn btn-block btn-default">重置</button></div>'
        finishBtn += '<div class="col-xs-2">';
        finishBtn += '<button id="upData" class="btn btn-block btn-primary" type="button">完成</button></div>';
        finishBtn += '</div>';
        $('.form-horizontal').append(finishBtn);
        $(document).on('click.up','#upData',function () {
            $.ajax({
                url:'',
                type:'POST',
                data: customerBasicFormObj()
            }).done(function (result) {
                console.log(result.message);
            })
        });
        $(document).on('click.reset','#resetForm',function () {
           location.reload();
        })

    }else if($('#customerId').val()!=''){
        init();
        //获取初始数据
        getData(basePath+'/customerBaseInfo/showCustomerBaseInfoDetails','POST',GetRequest(),customerBasicInfo);
        //编辑客户基本信息
        $(document).on('click.edit','editCustomerBasic',function () {
            addDelBtn('customerMakeProduct','form-group');
        });
        //客户基本信息提交
        $(document).on('click.up','#saveCustomerBasic',function(){
            //提交数据
            upData(basePath+'/customerBaseInfo/updateCustomerBaseInfo','POST',customerBasicFormObj(),"application/json");
            delDelBtn();
        });
        //客户基本信息取消提交
        $(document).on('click.cancel','#cancelCustomerBasic',function(){
            //重新获取数据
            location.reload();
        });
        $(document).on('click.edit','#editEncyclopedia',function () {
            //添加删除按钮
            addDelBtn('customField','form-group');
        });
        $(document).on('click.create','#addFiled',function () {
            var container = $('#filedContainer');
            container.html('');
            var form = '';
            form += '<div class="form-horizontal">';
            form += '<div class="form-group">';
            form += '<label for="" class="control-label col-xs-2">名称</label>';
            form += '<div class="col-xs-4">';
            form += '<input type="text" class="form-control" value=""></div></div>';
            form += '<div class="form-group">';
            form += '<label for="" class="control-label col-xs-2">内容</label>';
            form += '<div class="col-xs-9">';
            form += '<textarea class="form-control" name="" rows="8" value=""></textarea></div></div>';
            form += '</div>';
            container.append(form);
        });
        $(document).on('click.append','#up_cf',function () {
            var place = $('#addFiled').parents('.form-group');
            var container = $('#filedContainer');
            var name = $('input',container).val();
            var content = $('textarea',container).val();
            var row = '';
            row += '<div name="customField" class="form-group">';
            row += '<label name="name" class="control-label col-xs-1" lang="zh">'+ name +'</label>';
            row += '<div class="col-xs-8"><textarea name="value" class="form-control" rows="4">'+ content +'</textarea>';
            row += '</div>';
            place.before(row);
            delDelBtn();
            addDelBtn('customField','form-group');
        });
        $(document).on('click.up','#addEncyclopedia',function(){
            //提交数据
            upData(basePath+'/customerEncyclopedia/doModify','POST',customerEncyclopediaObj(),"application/json");
            delDelBtn();
        });
        $(document).on('change','#customerType',function () {
            var $this = $(this);
            if($this.val()==3){
                $('#showReasons').click();
                var container = $('#reasons').find('.modal-body .form-group');
                var content = '';
                content += '<label class="control-label col-xs-2">流失原因分析</label>';
                content += '<div class="col-xs-9"><textarea class="form-control" rows="8"></textarea></div>';
                container.html('').append(content);
            }
        })
    }

    //button——添加产品
    $(document).on('click.add','#addPro',function () {
        var row = '';
        row += '<div name="customerMakeProduct" class="form-group" style="position:relative;">';
        row += '<label class="col-xs-1 control-label" style="position: relative">生产产品</label>';
        row += '<div class="col-xs-2"><input name="productName" class="form-control" type="text" value=""></div>';
        row += '<label class="col-xs-1  control-label">产能</label>';
        row += '<div class="col-xs-2"><input name="production" class="form-control" type="text" value=""></div>';
        row += '</div>';
        $('#addPro').parents('.form-group').before(row);
        delDelBtn();
        addDelBtn('customerMakeProduct','form-group');
        $('[name="customerMakeProduct"]').eq(0).find('button').remove();
        $('[name="customerMakeProduct"]').each(function (n) {
            var $this = $(this);
            $this.find('label').eq(0).text(function () {
                return '生产产品'+parseInt(n+1);
            })
        })
    });

    //select||checkbox控制显示与隐藏
    controlSOrH('#showOpportunity');
    controlSOrH('#showOtherOpportunity');
    controlSOrH('#showFactory');
    controlSOrH('#showMajorCompetitorsGroup');
    controlSOrH('#showOtherEnterpriceNature');

    $(document).on('change.view','#customerType',function () {
        controlSOrH('#showOpportunity');
    });
    $(document).on('change.view','#opportunitySource',function () {
        controlSOrH('#showOtherOpportunity');
    });
    $(document).on('change.view','[name="enterpriseNature"]',function () {
        controlSOrH('#showFactory');
        controlSOrH('#showMajorCompetitorsGroup');
        controlSOrH('#showOtherEnterpriceNature');
    });

});

/**
 * 删除按钮的添加和删除
 */
// function reorderPro(){
//     $('[name="customerMakeProduct"]').find('label:first-child').html(function (n,old) {
//         if(n!=0){
//             return '<button type="button" class="close" data-form-btn="del" data-form-target="form-group" style="position: absolute;top: 3px;left: 24px;">×</button>生产产品' + parseInt(n+1);
//         }
//     });
// }
function addDelBtn(name,tar) {
    var delBtn = '<button type="button" class="close" data-form-btn="del" data-form-target="'+tar+'" style="position:absolute;top:3px;left:25px;z-index:100;">×</button>';
    $('[name="'+name+'"]').css('position','relative').prepend(delBtn);
}
function delDelBtn() {
    $('button').filter('[data-form-btn="del"]').remove();
}