/**
 *获取数据
 */
function getData(url,type,data,callBack){
    // console.log(data);
    $.ajax({
        url:url,
        type:type,
        data:data
    }).done(function (result) {
        var data = result.data;
        callBack(data);
    }).fail(function(result){
        console.log('error:'+result.status);
    });
}

/**
 * 提交数据
 */
function upData(url,type,data,contentType){
    $.ajax({
        url:url,
        type:type,
        data:data,
        contentType:contentType
    }).done(function (result) {
        if(result.status==200){
            alert('提交成功');
        }
    }).fail(function (result) {
        alert('请重新提交');
        console.log('error:'+result.status);
    });
}

/**
 *获取当前时间
 */
function getTime(){
    var time = new Date();
    var year = time.getFullYear();
    var month = parseInt(time.getMonth())+1;
    var day = time.getDate();
    var hours = parseInt(time.getHours());
    var minutes = parseInt(time.getMinutes());
    var seconds = parseInt(time.getSeconds());
    var newTime ;
    return newTime = year+'-'+month+'-'+day+' '+hours+':'+minutes+':'+seconds;
}

