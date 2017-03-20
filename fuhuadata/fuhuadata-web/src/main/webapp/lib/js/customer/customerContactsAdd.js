/**
 * Created by Loyun on 2017/3/20.
 */
$(document).ready(function(){
    getData(basePath + '','POST',GetRequest(),customerContactsAdd);
    
    function customerContactsAdd(result) {
        var ResultData = result;
        if(ResultData){
            $('#name').val(ResultData.name);
            $('#posts').val(ResultData.posts);
            $('#responseArea').val(ResultData.responseArea);
            $('#onJob').val(ResultData.onJob);
            $('#sex').val(ResultData.sex);
            $('#birthday').val(ResultData.birthday);
            $('#nationality').val(ResultData.nationality);
            $('#influence').val(ResultData.influence);
            $('#exhibitionHabits').val(ResultData.exhibitionHabits);
            $('#fancy').val(ResultData.fancy);
            $('#linkPhone1').val(ResultData.linkPhone1);
            $('#linkPhone2').val(ResultData.linkPhone2);
            $('#lemail').val(ResultData.lemail);
            $('#eatingHabits').val(ResultData.eatingHabits);
            $('#faith').val(ResultData.faith);
            $('#isDefault').val(ResultData.isDefault);
            $('#lemail').val(ResultData.remarks);
        }
    }
})