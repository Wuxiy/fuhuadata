/**
 * Created by Loyun on 2017/3/22.
 */


$(document).ready(function(){
    var customerId = $('#customerId').val();

    getData(basePath + '/customerVisitRecord/getCustomerVisitRecordByCustomerId','POST',GetRequest(),visitList);

    //新增提交
    $(document).on('click.up','#addVisit',function(){
        //提交数据
        var startTime = $('#startTime').val();
        var activityExpense = $('#activityExpense').val();
        var activityType = $('#activityType').val();
        var activityRemarks = $('#activityRemarks').val();
        if(startTime == ''||activityExpense == ''||activityType == ''){
            alert('请完善表单必填项');
            return false;
        }else if(activityType == 5 && activityRemarks == ''){
            alert('请填写其他活动类型备注');
            return false;
        }else{
            upData(basePath+'/customerVisitRecord/addCustomerVisitRecord','POST',addVisit(),"application/json");
            // location.reload();
        }

    });

    var id = document.URL.split('?')[1];
    var sid = id.split('=')[1];

    var url = basePath + '/customerLinkman/getCustomerLinkmanByCustomerId';
    getData(url,'POST',id,modalContact);

    $(document).on('click','#add',function () {
        $('#addField').modal('show');
    });

//list
    function visitList(result) {
        var visitList = document.getElementById('visitList');
        var ResultData = result;
        console.log(ResultData);
        if(ResultData) {
            for (var i = 0; i < ResultData.length; i++) {
                visitList.innerHTML += '<tr>' +
                    '<td>' + (ResultData[i].startTime!=undefined?ResultData[i].startTime:'') + '</td>' +
                    '<td>' + (ResultData[i].endTime!=undefined?ResultData[i].endTime:'') + '</td>' +
                    '<td>' + replace(ResultData[i].activityType, ResultData[i].activityRemarks) + '</td>' +
                    '<td>' + (ResultData[i].activityAddress!=undefined?ResultData[i].activityAddress:'') + '</td>' +
                    '<td>' + (ResultData[i].activityExpens!=undefined?ResultData[i].activityExpens:'') + '</td>' +
                    '<td>' + (ResultData[i].name!=undefined?ResultData[i].name:'') + '</td>' +
                    /*'<td>' + (ResultData[i].activityGift!=undefined?ResultData[i].activityGift:'') + '</td>' +*/
                    '<td>' + (ResultData[i].activitySummary!=undefined?ResultData[i].activitySummary:'') + '</td>' +
                    '<td><a href="#" name="editItem" data-id="' + ResultData[i].visitRecordId + '">查看</a></td>' +
                    '</tr>';
            }
        }
    }

    function replace(arr1,arr2){
        switch (arr1){
            case 0:
                arr1 ='远程沟通';
                break;
            case 1:
                arr1 = '出差拜访';
                break;
            case 2:
                arr1 = '展会邀请';
                break;
            case 3:
                arr1 = '工厂参观';
                break;
            case 4:
                arr1 = '商务宴请';
                break;
            case 5:
                arr1 = arr2;
                break;
        }
        return arr1;
    }

//modal list
    function modalContact(result) {
        var modalContactList = $('[name="modalContactList"]');
        var ResultData = result;
        var _html = '';
        modalContactList.innerHTML = '';
        for(var i=0;i<ResultData.length;i++){
            _html += '<tr>';
            _html += '<td><input type="checkbox" name="cellcheckbox" data-control="on" value="'+ ResultData[i].linkmanId +'"></td>';
            _html += '<td name="Lname" data-name="'+ ResultData[i].linkmanId +'">'+ ResultData[i].name+'</td>';
            _html += '<td><input class="form-control" type="text" name="gift" disabled></td>';
            _html += '<td><input class="form-control" type="text" name="remarks" disabled></td>';
            _html += '</tr>';
        }
        modalContactList.html(_html);
    }

//add function
    function addVisit() {
        var data = {
            "customerVisitRecord":{
                "customerId":$('#customerId').val(),
                "startTime":$('#startTime').val(),
                "endTime":$('#endTime').val(),
                "activityAddress":$('#activityAddress').val(),
                "activityExpense":$('#activityExpense').val(),
                "activityType":$('#activityType').val(),
                "activityRemarks":$('#activityRemarks').val(),
                "activitySummary":$('#activitySummary').val()
            },
            "recordLinkmen":recordLinkman()
        };
        console.log(data);
        return JSON.stringify(data);
    }

    //拜访记录
    function recordLinkman() {
        var arr = [];
        $("input[name='cellcheckbox']:checked").each(function(){
            var obj = {
                "linkmanId":$(this).parents('tr').find('[name="Lname"]').attr('data-name'),
                "activityGift":$(this).parents('tr').find('[name="gift"]').val(),
                "remarks":$(this).parents('tr').find('[name="remarks"]').val()
            };
            arr.push(obj);
        });
        return arr;
    }

    $('[name="checkAll"]').on('click',function(){
        var checkAll = $(this),
            allCheckbox = $("input[name='cellcheckbox']",checkAll.closest('table'));

        //监听全选框变化
        checkAll.change(function(){
            if (checkAll.prop("checked")) {
                allCheckbox.each(function(){
                    $(this).prop('checked',true);
                    $(this).parents('tr').find('[name="gift"],[name="remarks"]').attr('disabled',false);
                });
            } else {
                allCheckbox.each(function(){
                    $(this).prop('checked',false);
                    $(this).parents('tr').find('[name="gift"],[name="remarks"]').attr('disabled',true);
                });
            }
        });
    });

    $(document).on('change','input[name="cellcheckbox"]',function(){
        if($(this).prop('checked')){
            $(this).parents('tr').find('[name="gift"],[name="remarks"]').attr('disabled',false);
        }else {
            $(this).parents('tr').find('[name="gift"],[name="remarks"]').attr('disabled',true);
        }
    });

    $(document).on('click','#activityType,[name="activityType"]',function(){
        if($(this).val() == 5){
            $(this).closest('.form-group').find('[name="activityRemarks"]').removeClass('hidden');
        }else{
            // $('#activityRemarks').attr('disabled',true).addClass('hidden');
            $(this).closest('.form-group').find('[name="activityRemarks"]').addClass('hidden');
        }
    });

    // 更新
    $(document).on('click', '#editVisit', function () {
        if (confirm('确定保存吗？')) {
            $.ajax({
                url:basePath + '/customerVisitRecord/doModify',
                data:editVisit($('#editForm')),
                type:'POST',
                contentType:'application/json'
            }).done(function (res) {
                if(res.code===1){
                    alert('更新成功！');
                    window.location.reload();
                }else {
                    alert('更新失败，请重试！');
                }
            });
        }
    });

    // 查看详情
    $(document).on('click', '[name="editItem"]', function (e) {
        e.preventDefault();
        $('#editForm')[0].reset(); // 重置表单
        $('#editField').modal('show');
        $.ajax({
            url:basePath + '/customerVisitRecord/getCustomerVisitRecordById',
            method:'GET',
            data:{
                visirecordId:$(this).data('id')
            }
        }).done(function (res) {
            var linkman = res.data.recordLinkmanList,
                visit = res.data.customerVisitRecord;
            renderVisitRecord(visit, $('#editForm'));
            renderLinkman(linkman, $('[name="modalContactList"]',$('#editForm')).find('tr'));
            // isDisEl($('[name="modalContactList"]',$('#editForm')));
            $('input[name="cellcheckbox"]',$('#editForm')).attr('disabled',true);
            if(visit.activityType===5){
                $('[name="activityRemarks"]', $('#editForm')).removeClass('hidden');
            }else {
                $('[name="activityRemarks"]', $('#editForm')).addClass('hidden');
            }
        })
    });

    var editField = new CRM.module.Panel('#editField');
    editField.startEdit();

    $('#editField').on('click', '[data-btn="edit"]', function () {
        isDisEl($('[name="modalContactList"]',$('#editForm')));
    });

    $('#editField').on('click', '[data-btn="cancel"]', function () {
        if(confirm('确定要取消保存吗？')){
            window.location.reload();
        }
    });

    function renderVisitRecord(data,formObj) {
        if(data.visitrecordId)$('[name="visitrecordId"]',formObj).val(data.visitrecordId);
        if(data.startTime)$('[name="startTime"]',formObj).val(data.startTime);
        if(data.endTime)$('[name="endTime"]',formObj).val(data.endTime);
        if(data.activityAddress)$('[name="activityAddress"]',formObj).val(data.activityAddress);
        if(data.activityExpense)$('[name="activityExpense"]',formObj).val(data.activityExpense);
        if(data.activityType!==undefined)$('[name="activityType"]',formObj).val([data.activityType]);
        if(data.activitySummary)$('[name="activitySummary"]',formObj).val(data.activitySummary);
        if(data.activityRemarks)$('[name="activityRemarks"]',formObj).val(data.activityRemarks);
    }

    function renderLinkman(data,trObj) {
        trObj.each(function (i, item) {
            var el = $(this);
            $.each(data, function(i, item){
                if(el.find('[name="cellcheckbox"]').val() === item.linkmanId){
                    el.find('[name="cellcheckbox"]').val([item.linkmanId]).data('id', item.id);
                    el.find('[name="gift"]').val(item.activityGift);
                    el.find('[name="remarks"]').val(item.remarks);
                }else {
                    return true;
                }
            })
        });
    }

    function editVisit(formObj) {
        var data = {
            "customerVisitRecord":{
                "customerId":$('#customerId').val(),
                "visitrecordId":$('[name="visitrecordId"]',formObj).val(),
                "startTime":$('[name="startTime"]',formObj).val(),
                "endTime":$('[name="endTime"]',formObj).val(),
                "activityAddress":$('[name="activityAddress"]',formObj).val(),
                "activityExpense":$('[name="activityExpense"]',formObj).val(),
                "activityType":$('[name="activityType"]',formObj).val(),
                "activityRemarks":$('[name="activityRemarks"]',formObj).val(),
                "activitySummary":$('[name="activitySummary"]',formObj).val()
            },
            "recordLinkmen":recordLinkman()
        };

        function recordLinkman() {
            var arr = [];
            $("input[name='cellcheckbox']:checked", formObj).each(function(){
                var obj = {
                    "linkmanId":$(this).parents('tr').find('[name="Lname"]').attr('data-name'),
                    "activityGift":$(this).parents('tr').find('[name="gift"]').val(),
                    "remarks":$(this).parents('tr').find('[name="remarks"]').val(),
                    "id":$(this).parents('tr').find('[name="cellcheckbox"]').data('id')
                };
                arr.push(obj);
            });
            return arr;
        }
        return JSON.stringify(data);
    }

    function isDisEl(trObj) {
        trObj.find('tr').each(function () {
            if($(this).find('[name="cellcheckbox"]').prop('checked')){
                $(this).find('input[type="text"]').attr('disabled', false);
            }else {
                $(this).find('input[type="text"]').attr('disabled', true);
            }
        })
    }
});


