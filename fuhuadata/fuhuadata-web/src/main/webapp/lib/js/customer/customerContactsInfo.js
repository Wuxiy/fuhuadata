/**
 * Created by Loyun on 2017/3/20.
 */


$(document).ready(function(){

    //联系人基本信息提交
    $(document).on('click.up','#save',function(){
        var notnull = $('.notnull');
        notnull.each(function(){
            var val = $(this).val();
            if(val == ''||val == null){
                alert('请完善表单必填项');
                return false;
            }else{
                upData(basePath+'/customerLinkman/updateById','POST',updateContactsInfo(),"application/json");
                return false;
            }
        })
    });

    //联系人基本信息取消提交
    $(document).on('click.cancel','#cancel',function(){
        location.reload();
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

    $('#isDefault').change(function(){
        var newName = $('#name').val();
        var id = $(this).attr('data-id');
        var url = basePath + '/customerLinkman/getCustomerLinkmanDefaultByCustomerId?customerId=' + id;

        if($(this).val() == 1){
            jQuery.ajax({
                type:"POST",
                url:url,
                success:function(result){
                    var name = result.data.name;
                    var msg = '当前默认联系人是' + name + '，更改后的联系人为' + newName;
                    alert(msg);
                }
            })
        }
    });

    var editField = new CRM.module.Panel('#editField');
    editField.startEdit();

    $('#editField').on('click', '[data-btn="edit"]', function () {
        /*isDisEl($('[name="modalContactList"]',$('#editForm')));*/
        $('[name="cellcheckbox"]', $('#editForm')).each(function () {
            if ($(this).val()===$('#name').attr('data-id')){
                $(this).prop('checked',true).attr('disabled',true);
            }else {
                $(this).attr('disabled',false);
            }
            isUsableText($(this).prop('checked'), $(this));
        });
    });

    $('#editField').on('click', '.close', function () {
        window.location.reload();
    });

    $('#editField').on('click', '[data-btn="cancel"]', function () {
        if(confirm('确定要取消保存吗？')){
            window.location.reload();
        }
    });

    // 新建Panel对象实例，绑定编辑、保存、取消事件
    var bInfo = new CRM.module.Panel('#basicInfo');
    bInfo.startEdit();
    bInfo.startSave();
    bInfo.startCancel();

    // 返回
    $('#back').on('click.back',function () {
        window.history.back(-1);
    });

    // 重置
    $('#resetBtn').on('click.reset',function () {
        $('input,textarea',$('#myForm')).val('');
    });

    // 渲染联系人列表，并默认选中当前联系人
    $.ajax({
        url:basePath + '/customerLinkman/getCustomerLinkmanByCustomerId',
        type:'POST',
        data:{
            customerId:$('#customerId').val(),
            customerType:$('#customerId').val()
        }
    }).done(function (res) {
        var list = res.data,
            _html = '';
        $.each(list, function (i, item) {
            _html += '<tr name="linkmanItem">';
            _html += '<td><input type="checkbox" name="cellcheckbox" value="'+item.linkmanId+'"></td>';
            _html += '<td>'+ item.name+'</td>';
            _html += '<td><input class="form-control" type="text" name="gift" disabled></td>';
            _html += '<td><input class="form-control" type="text" name="remarks" disabled></td>';
            _html += '</tr>';
        });
        $('[name="modalContactList"]').html(_html);

    });

    // 全选
    $('[name="checkAll"]').on('click', function () {
        var cellcheckbox = $(this).closest('table').find('input[name="cellcheckbox"]').not('[disabled]');
        if ($(this).prop('checked')) {
            cellcheckbox.prop('checked', true);
        }else {
            cellcheckbox.prop('checked', false);
        }
        cellcheckbox.each(function () {
            isUsableText($(this).prop('checked'), $(this));
        })
    });

    $(document).on('click','#activityType,[name="activityType"]',function(){
        if($(this).val() == 5){
            $(this).closest('.form-group').find('[name="activityRemarks"]').removeClass('hidden');
        }else{
            $(this).closest('.form-group').find('[name="activityRemarks"]').addClass('hidden');
        }
    });

    // 单个checkbox
    $('[name="modalContactList"]').on('click', 'input[name="cellcheckbox"]', function () {
        var el = $(this).closest('tr').find('input[type="text"]');
        if ($(this).prop('checked')) {
            el.attr('disabled', false);
        }else {
            el.attr('disabled', true);
        }

    });

    // 选中其他活动类型，显示备注框
    $('#activityType').change(function () {
        if ($(this).val() === "5") {
            $('#activityRemarks').removeClass('hidden');
        }else {
            $('#activityRemarks').val('').addClass('hidden');
        }
    });

    // 新增联系人提交
    $('#addVisit').click(function () {

        if (confirm('确认提交吗？')) {
            $.ajax({
                url:basePath + '/customerVisitRecord/addCustomerVisitRecord',
                data:addVisit(),
                contentType:'application/json',
                type:'POST'
            }).done(function (res) {
                if (res.code === 1) {
                    alert('添加成功！');
                    location.reload();
                }
            })
        }
    });

    // 渲染页面
    getData(basePath + '/customerLinkman/getCustomerLinkmanDetailsById','POST',GetRequest(),customerContactsInfo);

    // 是否禁用该联系人的赠送礼物和备注字段
    function isUsableText(b, el) {
        if (b) {
            el.closest('[name="linkmanItem"]').find('[name="gift"],[name="remarks"]').attr('disabled', false);
        }else{
            el.closest('[name="linkmanItem"]').find('[name="gift"],[name="remarks"]')
                .val('')
                .attr('disabled', true);
        }
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
                "linkmanId":$(this).val(),
                "activityGift":$(this).parents('tr').find('[name="gift"]').val(),
                "remarks":$(this).parents('tr').find('[name="remarks"]').val()
            };
            arr.push(obj);
        });
        return arr;
    }

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
                    "linkmanId":$(this).val(),
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

    //详情列表
    function customerContactsInfo(result) {
        var customerLinkman = result.customerLinkman;
        var customerVisitRecords = result.visitRecordVOS;
        var visitRecordsTable = document.getElementById('visitRecordsTable');
        if(customerLinkman){
            $('#name').attr('data-id',customerLinkman.linkmanId);
            $('#name').val(customerLinkman.name);
            $('#posts').val(customerLinkman.posts);
            $('#responseArea').val(customerLinkman.responseArea);
            $('#onJob').val(customerLinkman.onJob);
            $('#sex').val(customerLinkman.sex);
            $('#birthday').val(customerLinkman.birthday);
            $('#nationality').val(customerLinkman.nationality);
            $('#influence').val(customerLinkman.influence);
            $('#exhibitionHabits').val(customerLinkman.exhibitionHabits);
            $('#fancy').val(customerLinkman.fancy);
            $('#linkPhone1').val(customerLinkman.linkPhone1);
            $('#linkPhone2').val(customerLinkman.linkPhone2);
            $('#lemail').val(customerLinkman.lemail);
            $('#eatingHabits').val(customerLinkman.eatingHabits);
            $('#faith').val(customerLinkman.faith);
            $('#isDefault').val(customerLinkman.isDefault);
            $('#isDefault').attr('data-id',customerLinkman.customerId);
            $('#remarks').val(customerLinkman.remarks);
        }
        if(customerVisitRecords){
            for(var i=0;i<customerVisitRecords.length;i++){
                visitRecordsTable.innerHTML += '<tr><td>'+customerVisitRecords[i].startTime+'</td>'+
                    '<td>'+(customerVisitRecords[i].endTime!=undefined?customerVisitRecords[i].endTime:'')+'</td>'+
                    '<td>' + replace(customerVisitRecords[i].activityType, customerVisitRecords[i].activityRemarks) + '</td>' +
                    '<td>'+(customerVisitRecords[i].activityAddress!=undefined?customerVisitRecords[i].activityAddress:'')+'</td>'+
                    '<td>'+(customerVisitRecords[i].activitySummary!=undefined?customerVisitRecords[i].activitySummary:'')+'</td>'+
                    '<td>'+(customerVisitRecords[i].activityGift!=undefined?customerVisitRecords[i].activityGift:'')+'</td>'+
                    '<td>'+(customerVisitRecords[i].remarks!=undefined?customerVisitRecords[i].remarks:'')+'</td>'+
                    '<td><a href="#" name="editItem" data-id="'+ customerVisitRecords[i].visitRecordId +'">查看</a></td>'+
                    '</tr>';
            }
        }
        $('[name="cellcheckbox"]', $('#addField')).each(function () {
            if ($(this).val()===$('#name').attr('data-id')){
                $(this).prop('checked',true).attr('disabled',true);
            }
            isUsableText($(this).prop('checked'), $(this));
        });
    }

    //提交上传
    function updateContactsInfo() {
        var data = {
            "customerId":$('#isDefault').attr('data-id'),
            "linkmanId":$('#name').attr('data-id'),
            "name":$('#name').val(),
            "posts":$('#posts').val(),
            "responseArea":$('#responseArea').val(),
            "onJob":$('#onJob').val(),
            "sex":$('#sex').val(),
            "birthday":$('#birthday').val(),
            "nationality":$('#nationality').val(),
            "influence":$('#influence').val(),
            "exhibitionHabits":$('#exhibitionHabits').val(),
            "fancy":$('#fancy').val(),
            "linkPhone1":$('#linkPhone1').val(),
            "linkPhone2":$('#linkPhone2').val(),
            "lemail":$('#lemail').val(),
            "eatingHabits":$('#eatingHabits').val(),
            "faith":$('#faith').val(),
            "isDefault":$('#isDefault').val(),
            "remarks":$('#remarks').val()
        };
        return JSON.stringify(data);
    }
});

