/**
 * Created by huxiangyang on 2017/3/13.
 */

$(function () {
    //获取初始数据
    getData(basePath+'/customerBaseInfo/showCustomerBaseInfoDetails','POST',GetRequest(),customerBasicInfo);
    //添加产品
    $(document).on('click.add','#addPro',function () {
        var row = '';
        row += '<div name="customerMakeProduct" class="form-group" style="position:relative;">';
        row += '<label class="col-xs-1 control-label" style="position: relative">生产产品</label>';
        row += '<div class="col-xs-2"><input class="form-control" type="text" value=""></div>';
        row += '<label class="col-xs-1  control-label">产能</label>';
        row += '<div class="col-xs-2"><input class="form-control" type="text" value=""></div>';
        row += '</div>';
        $('#addPro').parents('.form-group').before(row);
        reorderPro();
    });

    //选择其他选项，切换显示(需修改)
    $(document).on('change.view','[name="enterpriseNature"]',function () {
        var thiEl = this;
        // var thisEl = $(e.target);
        // thisEl.focus().blur();
        // radioChecked(thisEl);
    });

    //编辑客户基本信息
    $(document).on('click.edit','editCustomerBasic',function () {
        //生产产品重排序
        reorderPro();
    });
    //客户基本信息提交
    $(document).on('click.up','#saveCustomerBasic',function(){
        //提交数据
        upData(basePath+'/customerBaseInfo/updateCustomerBaseInfo','POST',customerBasicFormObj(),"application/json");
    });
    //客户基本信息取消提交
    $(document).on('click.cancel','#cancelCustomerBasic',function(){
        //重新获取数据
        getData(basePath+'/customerBaseInfo/showCustomerBaseInfoDetails','POST',GetRequest(),customerBasicInfo);
    });
    //客户百科提交
    $(document).on('click.up','#addEncyclopedia',function(){
        //提交数据
        upData(basePath+'/customerEncyclopedia/doModify','POST',customerEncyclopediaObj(),"application/json");
    });
});

/**
 * 对客户生产产品添加删除按钮，并且排序
 */
function reorderPro(){
    $('[name="customerMakeProduct"]').find('label:first-child').html(function (n,old) {
        if(n!=0){
            return '<button type="button" class="close" data-form-btn="del" data-form-target="form-group" style="position: absolute;top: 3px;left: 24px;">×</button>生产产品' + parseInt(n+1);
        }
    });
}