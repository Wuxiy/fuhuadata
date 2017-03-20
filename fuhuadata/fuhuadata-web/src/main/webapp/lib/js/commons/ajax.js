/**
 *获取数据
 */
function getData(url,type,data,callBack){
    $.ajax({
        url:url,
        type:type,
        data:data
    }).done(function (result) {
        var data = result.data;
        callBack(data);
    }).fail(function(){
        console.log('没有获取到数据');
    });
    // console.log(data);
}

/**
 * 提交数据
 */
function upData(url,type,data,contentType){
    $.ajax({
        url:url,
        type:type,
        dataType:"json",
        data:JSON.stringify(data),
        contentType:contentType
    }).done(function () {
        alert('提交成功');
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

