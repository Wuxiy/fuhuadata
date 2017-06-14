/**
 * Created by 胡向阳 on 2017/6/2.
 */

$(function () {

    // 加工厂id
    var id = $('#forwardingId').val();

    // 基本信息组件
    var basicPanel = {
        panel:$('#panel'),
        form:$('#factory_info'),
        editBtn:'[name="edit"]',
        saveBtn:'[name="save"]',
        cancelBtn:'[name="cancel"]',
        editView:'[data-view="editView"]',
        editHide:'[data-view="editHide"]',
        editOn:'[data-control="editOn"]',
        editOff:'[data-control="editOff"]',
        bindEl:'[data-bind="localData"]',
        checkbox:'[name="transportationMethods"]',
        paramGet:{
            url:basePath+'/supplier/forwarding/forwardingInfo',
            data:{
              id:id
            },
            type:'GET'
        },
        paramPut:{
            url:basePath+'/supplier/forwarding/updateForwardingInfo',
            type:'POST',
            contentType:'application/json;charset=UTF-8'
        },
        data:{},
        ectype:null,
        formConfig:[
            {
                name:'code'
            },
            {
                name:'pkSupplierclass'
            },
            {
                name:'name'
            },
            {
                name:'shortname'
            },
            {
                name:'supprop'
            },
            {
                name:'creditCode'
            },
            {
                name:'registerfund'
            },
            {
                name:'officeAddress'
            },
            {
                name:'tel1'
            },
            {
                name:'corpaddress'
            },
            {
                name:'transportationMethods',
                type:'checkbox'
            },
            {
                name:'memo'
            },
            {
                name:'linkmen',
                type:'list',
                field:{
                    name:'联系人,text',
                    phone:'联系电话,tel',
                    email:'邮箱,email'
                },
                place:'linkmens'
            },
            {
                name:'startCooperateTime'
            },
            {
                name:'cooperateTime'
            },
            {
                name:'businessLicence'
            },
            {
                name:'nvocc',
            },
            {
                name:'combinedScoring',
            },
            {
                name:'lastmodifyUserName'
            },
            {
                name:'modifiedtime'
            }
        ],
        /*verify:(function () {
            return $('#factory_info').validate({
                rules: {
                    orgName: 'required',
                    name: 'required',
                    productionLicenses: 'required',
                    pesticideRegistration: 'required',
                    dischargePermit: 'required',
                    supstate: 'required',
                    managerOrgName: 'required',
                    managerDepName: 'required',
                    manager: 'required'
                },
                messages: {
                    orgName: {
                        required:em('必填','top:-29px','right:0')
                    },
                    name:{
                        required:em('必填','top:-29px','right:0')
                    },
                    productionLicenses:{
                        required:em('请添加图片','top:-29px','right:80px')
                    },
                    pesticideRegistration:{
                        required:em('请添加图片','top:-29px','right:80px')
                    },
                    dischargePermit:{
                        required:em('请添加图片','top:-29px','right:80px')
                    },
                    supstate:{
                        required:em('请选择一个值','top:-29px','right:0')
                    },
                    managerOrgName:{
                        required:em('请选择一个值','top:-29px','right:0')
                    },
                    managerDepName:{
                        required:em('请选择一个值','top:-29px','right:0')
                    },
                    manager:{
                        required:em('请选择一个值','top:-29px','right:0')
                    }
                }
            });
        })(),*/
        init:function (item) {

            this.viewForm();
            $.ajax(this.paramGet).done(function (res) {

                if (res.code===1) {

                    basicPanel.data = res.data;
                    basicPanel.ectype = $.extend(true, {}, basicPanel.data);
                    basicPanel.render(basicPanel.data);
                }

            });
            this.addEvent('click.edit', this.editBtn, this.editHandler);
            this.addEvent('click.cancel', this.cancelBtn, this.cancelHandler);
            this.addEvent('click.save', this.saveBtn, this.saveHandler);
            this.addEvent('change.putLocalData', this.bindEl, this.putLocalData);
            this.addEvent('click.checkbox', this.checkbox, this.putCheckHandler);
        },
        render:function (data) {
            /*{
             name:'code',
             type:'normal/select/list/other',
             place:'存储位置',
             listTpl:'list模板',
             field:'对应字段'
             }*/
            $.each(basicPanel.formConfig, function (i, item) {

                var field = item.field || item.name;

                if (item.type==='normal' || typeof item.type==='undefined') {

                    if (typeof item.place==='object') {

                        $('[name="'+item.name+'"]', basicPanel.form)
                            .data(item.place.name, data[item.place.field])
                            .val(data[field])
                            .attr('title', data[item.place.field]);
                    }else {
                        $('[name="'+item.name+'"]', basicPanel.form)
                            .val(data[field])
                            .attr('title', data[field.name]);
                    }

                }else if (item.type==='list') {

                    var arr = Object.keys(item.field), // 取的fied中的字段名称
                        p = $('#'+item.place), // 渲染位置
                        n = item.name,
                        _html = '';

                    if (Array.isArray(arr)) {

                        $.each(data[n], function (j, o) {
                            _html += '<div class="form-group" name="'+n+'">';
                            $.each(arr, function (k, key) {

                                _html +=
                                    '<label class="control-label col-xs-1" for="'+key+'" lang="zh">'
                                    +item.field[key].split(',')[0]+
                                    '</label>'+
                                    '<div class="col-xs-2">' +
                                    '<input class="form-control" name="'+key+'"' +
                                    'type="'+item.field[key].split(',')[1]+'" value="'+o[key]+'" disabled>'+
                                    '</div>';
                            });
                            _html += '</div>';
                        });
                        p.html(_html);
                    }

                }else if (item.type==='checkbox') {

                    $('[name="'+item.name+'"]', basicPanel.form)
                        .val(data[field].split(','));
                }
                /*else if (item.type==='select') {

                 if (typeof filed==='object') {

                 $('[name="'+item.name+'"]', form).html('<option value="'+data[field.name]+'">'+data[field.value]+'</option>');
                 }else {

                 $('[name="'+item.name+'"]', form).val(data[field]);
                 }
                 }*/
            })
        },
        empty:function () {
            basicPanel.form[0].reset();
        },
        editForm:function () {
            $(basicPanel.editOn, basicPanel.panel).attr('disabled', false);
            $(basicPanel.editOff, basicPanel.panel).attr('disabled', true);
            $(basicPanel.editView, basicPanel.panel).removeClass('hidden');
            $(basicPanel.editHide, basicPanel.panel).addClass('hidden');
        },
        viewForm:function () {
            $(basicPanel.editOn, basicPanel.panel).attr('disabled', true);
            $(basicPanel.editOff, basicPanel.panel).attr('disabled', false);
            $(basicPanel.editView, basicPanel.panel).addClass('hidden');
            $(basicPanel.editHide, basicPanel.panel).removeClass('hidden');
        },
        addEvent:function (eType, el, handler) {
            this.panel.off(eType).on(eType, el, handler);
        },
        editHandler:function () {
            basicPanel.editForm();
        },
        cancelHandler:function () {

            if (confirm('确定取消保存吗？')) {

                if (id!=='') {

                    basicPanel.data = $.extend(true, {}, basicPanel.ectype); // 重置data数据
                    basicPanel.empty();
                    basicPanel.render(basicPanel.data); // 重新渲染
                    basicPanel.viewForm();

                }else {
                    self.location = basePath+'/supplier/factories/vm';
                }
            }

        },
        saveHandler:function () {

            /*if (!basicPanel.isPass()) return;*/

            if (!confirm('确定要保存吗？')) return;

            basicPanel.putData();
            basicPanel.viewForm();
        },
        putLocalData:function () {
            var name = $(this).attr('name'),
                val = $(this).val();
            basicPanel.data[name] = val;
            basicPanel.render(basicPanel.data);
        },
        putCheckHandler:function () {
            var name = $(this).attr('name'),
                val = $(this).val(),
                arr = basicPanel.data[name].split(','),
                hasVal = $(this).prop('checked');
            console.log(hasVal);

            if (hasVal) {
                arr.push(val);
            }else {
                arr.splice(arr.indexOf(val), 1);
            }

            basicPanel.data[name]=arr.join(",");
        },
        putData:function () {
            basicPanel.paramPut.data = JSON.stringify(basicPanel.data);
            $.ajax(basicPanel.paramPut).done(function (res) {

                if (res.code===1) {

                    alert('更新成功！');
                    // 重新请求获取数据
                    $.ajax(basicPanel.paramGet).done(function (res) {

                        if (res.code===1) {

                            basicPanel.data = res.data;
                            basicPanel.ectype = $.extend(true, {}, basicPanel.data);
                            basicPanel.render(basicPanel.data);
                        }

                    });
                }
            })
        },
        /*isPass:function () {
            return basicPanel.verify.form();
        }*/
    };

    // 图片路径展示组件
    var imgGroup = {
        inputGroups:$('#business_licence,#nvocc'),
        modal:$('#show_img'),
        editBtn:'[name="edit"]',
        showBtn:'[name="show"]',
        container:$('[name="showImg"]','#show_img'),
        thePath:null,
        theName:null,
        init:function () {
            this.addEvent('click.show', this.showBtn, this.showHandler); // 点击展示图片
            this.addEvent('click.edit', this.editBtn, this.editHandler); // 点击弹出编辑modal
        },
        addEvent:function (eType, el, handler) {
            this.inputGroups.off(eType).on(eType, el, handler);
        },
        showHandler:function () {
            imgGroup.thePath = $(this).closest('.input-group').find('input').val();
            if (imgGroup.thePath) {

                imgGroup.container.attr('src',basePath+imgGroup.thePath);
                imgGroup.modal.modal('show');
            }else {
                alert('当前没有图片，请添加！');
            }
        },
        editHandler:function () {
            imgGroup.theName = $(this).closest('.input-group').find('input').attr('name');
            upImgModal.form[0].reset();
            upImgModal.modal.modal('show');
        }
    };

    // 图片上传组件
    var upImgModal = {
        modal:$('#set_img'),
        form:$('[name="imgForm"]','#set_img'),
        save:'[name="save"]',
        fileInput:$('[name="file"]','#set_img'),
        init:function () {
            this.addEvent('click.save', this.save, this.saveHandler);
        },
        addEvent:function (eType, el, handler) {
            this.modal.off(eType).on(eType, el, handler);
        },
        saveHandler:function () {
            if (!upImgModal.fileInput.val()) return alert('请选择图片！');
            var img = new FormData(upImgModal.form[0]);
            /*img.append("classifyPath","oederRequire");*/
            $.ajax({
                url:basePath+'/upload/uploadFileAll',
                type:'POST',
                data:img,
                dataType:'JSON',
                cache:false,
                processData:false,
                contentType:false
            }).done(function (res) {

                if (res.code===1) {

                    basicPanel.data[imgGroup.theName] = (basePath==""?("\\"+basePath):basePath)+"\\"+res.data[0];
                    basicPanel.render(basicPanel.data);
                }
            });
            upImgModal.modal.modal('hide');
        }
    };

    // 时间联动组件
    var timeLinkage = {
        group:$('#time'),
        start:'[name="startCooperateTime"]',
        init:function () {
            this.addEvent('change.calculate', this.start, this.calculateHandler);
        },
        addEvent:function (eType, el, handler) {
            this.group.off(eType).on(eType, el, handler);
        },
        calculateHandler:function () {
            var nowDate = new Date(),
                nowYear = nowDate.getFullYear(),
                nowMonth = nowDate.getMonth(),
                nowDay = nowDate.getDate(),
                oldDate = new Date($(this).val()),
                oldYear = oldDate.getFullYear(),
                oldMonth = oldDate.getMonth(),
                oldDay = oldDate.getDate(),
                res = (nowYear-oldYear)*12+(nowMonth-oldMonth);
            res = parseInt(oldDay)<=parseInt(nowDay)?res:res-1;
            basicPanel.data.cooperateTime = (res&&res>0)?res:0;
            basicPanel.data.startCooperateTime = $(this).val();
            basicPanel.render(basicPanel.data);
        }
    };

    // 自定义字段
    var addCustomField = {
        addBtn:$('#add_customField'),
        container:$('#customFields'),
        tpl:'<>',
        init:function () {

        },
        clickHandler:function () {

        }
    };

    basicPanel.init();
    imgGroup.init();
    upImgModal.init();
    timeLinkage.init();
});