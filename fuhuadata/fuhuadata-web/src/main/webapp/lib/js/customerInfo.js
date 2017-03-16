/**
 * Created by Think on 2017/3/16.
 */

/**
 * 获取数据并渲染
 */
$(function () {
    //获取初始数据
    getData('/customerBaseInfo/showCustomerBaseInfoDetails','POST',GetRequest(),customerBasicInfo);

})

/**
 *获取数据
 */
function getData(url,type,data,callBack){
    $.ajax({
        url:url,
        type:type,
        data:data
    }).done(function (data) {
        callBack(data);
    }).fail(function(){
        console.log('没有获取到数据');
    });
    console.log(GetRequest());
}

/**
 *customerBasicInfo deal with
 */
function customerBasicInfo(result){
    var getData = result.data;
    jQuery.each(getData,function(key,item){
        if(key!='customerMakeProduct'){
            var formControl=$('[name="'+ key +'"]');
            // console.log(key);
            if(formControl.attr('type')=='radio'||formControl.attr('type')=='checkbox'){
                var arr=[item];
                formControl.val(arr);
            }else {
                formControl.val(item);
            }
            if(key=='enterpriseNature'){
                var elseSelected = formControl.filter('.else');
                var targetEl = formControl.parents('.form-group').find('.elseInput');
                if(elseSelected.prop('checked')){
                    console.log(formControl.prop('checked'));
                    targetEl.removeClass('hidden');
                }else{
                    targetEl.addClass('hidden');
                }
            }
        }

    });
}