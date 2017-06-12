/**
 * Created by 胡向阳 on 2017/6/2.
 */

$(function () {

    // 加工厂id
    var id = $('#factoryId').val();

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
        paramGet:{
            url:basePath+'/supplier/factories/'+id,
            type:'GET'
        },
        paramPost:{
            url:basePath+'/supplier/factories',
            type:'POST',
            contentType:'application/json;charset=UTF-8'
        },
        data:{},
        ectype:null,
        formConfig:[
            {
                name:'code'
            },
            /*{
                name:'pkSupplierclass',
                place:{
                    name:'id',
                    field:'pkSupplierclass'
                }
            },*/
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
                name:'transportationMethods'
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
        verify:(function () {
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
        })(),
        init:function (item) {

            if (id!=='') { // 如果有id初始化为查看状态，并获取数据

                this.viewForm();
                $.ajax(this.paramGet).done(function (res) {

                    if (res.code===1) {

                        basicPanel.data = res.data;
                        basicPanel.ectype = $.extend(true, {}, basicPanel.data);
                        basicPanel.render(basicPanel.data);
                    }

                });
                this.addEvent('click.edit', this.editBtn, this.editHandler);
            }else { // 或者初始化为新增状态

                this.editForm();
            }

            this.addEvent('click.cancel', this.cancelBtn, this.cancelHandler);
            this.addEvent('click.save', this.saveBtn, this.saveHandler);
            this.addEvent('change.putLocalData', this.bindEl, this.putLocalData);
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

                        $.each(data[n], function (i, o) {
                            _html += '<div class="form-group" name="'+n+'">';
                            $.each(arr, function (i, key) {

                                _html +=
                                    '<label class="control-label col-xs-1" for="'+key+'" lang="zh">'
                                    +item.field[key].split(',')[0]+
                                    '</label>'+
                                    '<div class="col-xs-2">' +
                                    '<input class="form-control" name="'+key+'"' +
                                    'data-control="editOn" type="'+item.field[key].split(',')[1]+'" value="'+o[key]+'" disabled>'+
                                    '</div>';
                            });
                            _html += '</div>';
                        });
                        p.html(_html);
                    }
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
                    bankTable.data = $.extend(true, [], bankTable.ectype);
                    contactTable.data = $.extend(true, [], contactTable.ectype);
                    basicPanel.empty();
                    basicPanel.render(basicPanel.data); // 重新渲染
                    bankTable.container.html(bankTable.render(bankTable.data)); // 刷新列表
                    contactTable.container.html(contactTable.render(contactTable.data)); // 刷新列表
                    basicPanel.verify.form();
                    basicPanel.viewForm();

                }else {
                    self.location = basePath+'/supplier/factories/vm';
                }
            }

        },
        saveHandler:function () {

            if (!basicPanel.isPass()) return;

            if (!confirm('确定要保存吗？')) return;

            basicPanel.data.banks = bankTable.data;
            basicPanel.data.deletedBankIds = bankTable.argsIds;
            basicPanel.paramPut.data = JSON.stringify(basicPanel.data);

            if (id!=='') { // 更新

                basicPanel.putData();
                basicPanel.viewForm();
            }else {

                basicPanel.postData();
            }
        },
        putLocalData:function () {
            var name = $(this).attr('name'),
                val = $(this).val();
            basicPanel.data[name] = val;
            basicPanel.render(basicPanel.data);
        },
        putData:function () {
            basicPanel.data.banks = bankTable.data;
            basicPanel.data.linkmen = contactTable.data;
            basicPanel.paramPut.data = JSON.stringify(
                {
                    factory:basicPanel.data,
                    deletedBankIds:bankTable.argsIds,
                    deletedLinkmanIds:contactTable.argsIds
                });
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
                    bankTable.refresh();
                    contactTable.refresh();
                    bankTable.argsIds = [];
                    contactTable.argsIds = [];
                }
            })
        },
        postData:function () {
            basicPanel.data.banks = bankTable.data;
            basicPanel.data.linkmen = contactTable.data;
            basicPanel.paramPost.data = JSON.stringify({factory:basicPanel.data});
            $.ajax(basicPanel.paramPost).done(function (res) {

                if (res.code===1) {
                    alert('新增成功！');

                    if (confirm('是否留在当前页面？')) {

                        self.location = basePath+'/supplier/factories/'+res.data.id+'/vm';
                    }else {

                        self.location = basePath+'/supplier/factories/vm';
                    }
                }
            })
        },
        isPass:function () {
            return basicPanel.verify.form();
        }
    };

    // 树形菜单modal组件
    var treeModal = {
        modal:$('#tree_modal'),
        inputGroups:$('#org_name, #manager_org, #manager_dep'), // 关联的input控件
        searchBtn:'button',
        theId:null,
        orgContainer:$('#org_tree'),
        depContainer:$('#dep_tree'),
        init:function () {
            this.addEvent('click.popmodal', this.searchBtn, this.popHandler);

            $.ajax({
                url:basePath+'/customerBaseInfoOrder/initSaleOrganizationTree',
                type:'GET'
            }).done(function (res) {
                treeModal.orgInit(res.data);
            });
        },
        addEvent:function (eType, el, handler) {
            this.inputGroups.off(eType).on(eType, el, handler);
        },
        orgInit:function (data) {
            var ablclickTree = function (event, modLeftId, treeNode) {

                    if (treeModal.theId==='org_name'){

                        basicPanel.data.pkOrg = treeNode.cid;
                        basicPanel.data.orgName = treeNode.cname;
                        basicPanel.render(basicPanel.data);
                    }else if(treeModal.theId==='manager_org') {

                        if (basicPanel.data.managerOrgCode!==treeNode.cid) { // 判断选择的id是否和以前的一致

                            basicPanel.data.managerOrgCode = treeNode.cid;
                            basicPanel.data.managerOrgName = treeNode.cname;
                            basicPanel.data.managerDepCode = '';
                            basicPanel.data.managerDepName = '';
                            basicPanel.data.managerCode = '';
                            basicPanel.data.manager = '';
                            basicPanel.render(basicPanel.data);
                        }

                    }

                    treeModal.modal.modal('hide');
                    treeModal.theId = null;
                },
                setting =
                    {
                        data: {
                            simpleData: {
                                enable: false
                            },
                            key:{
                                children:"nodes",
                                name:"cname"
                            }
                        },
                        callback: {
                            onDblClick: ablclickTree
                        }
                    },
                treeObj;
            $.fn.zTree.init(treeModal.orgContainer, setting, data);
            treeObj = $.fn.zTree.getZTreeObj(treeModal.orgContainer.attr('id'));
            treeObj.expandAll(true); // 默认展开
        },
        depInit:function (data) {
            var ablclickTree = function (event, modLeftId, treeNode) {

                    if (basicPanel.data.managerDepCode!==treeNode.id) {

                        basicPanel.data.managerDepCode = treeNode.code;
                        basicPanel.data.managerDepName = treeNode.cname;
                        basicPanel.data.managerCode = '';
                        basicPanel.data.manager = '';
                        basicPanel.render(basicPanel.data);
                    }
                    treeModal.modal.modal('hide');
                    treeModal.theId = null;
                },
                setting =
                    {
                        data:{
                            simpleData: {
                                enable: false,
                            },
                            key:{
                                children:"nodes",
                                name:"cname"
                            }
                        },
                        callback: {
                            onDblClick: ablclickTree
                        }
                    },
                treeObj;
            $.fn.zTree.init(treeModal.depContainer, setting, data);
            treeObj = $.fn.zTree.getZTreeObj(treeModal.depContainer.attr('id'));
            treeObj.expandAll(true); // 默认展开
        },
        popHandler:function () {
            treeModal.theId = $(this).closest('.input-group').attr('id'); // 取得当前组件的id

            if (treeModal.theId==='org_name'||treeModal.theId==='manager_org') {

                treeModal.orgContainer.removeClass('hidden');
                treeModal.depContainer.addClass('hidden');
                treeModal.modal.modal('show');
            }else if(treeModal.theId==='manager_dep') {

                treeModal.depContainer.html('');

                if (basicPanel.data.managerOrgCode) {

                    $.ajax({
                        url:basePath+'/sys/dept/tree/org',
                        type:'GET',
                        data:{
                            code:basicPanel.data.managerOrgCode
                        }
                    }).done(function (res) {
                        treeModal.depInit(res.data);
                    });

                    treeModal.orgContainer.addClass('hidden');
                    treeModal.depContainer.removeClass('hidden');
                    treeModal.modal.modal('show');
                }else {
                    alert('请先选择管理员组织！');
                }
            }
        }
    };

    // 下拉选择框组件
    var searchSelect = {
        select:$('#manager'),
        searchBtn:'button',
        container:$('ul','#manager'),
        options:'a',
        init:function () {
            this.addEvent('click.pop', this.searchBtn, this.searchHandler);
            this.addEvent('click.select', this.options, this.selectHandler);
        },
        addEvent:function (eType, el, handler) {
            this.select.off(eType).on(eType, el, handler);
        },
        searchHandler:function () {
            searchSelect.container.html('');

            if (basicPanel.data.managerDepCode) {

                $.ajax({
                    url:basePath+'/sys/user/dept/users/pojo',
                    type:'GET',
                    data:{
                        code:basicPanel.data.managerDepCode
                    }
                }).done(function (res) {

                    if (res.code===1) {

                        var tpl = searchSelect.render(res.data);
                        searchSelect.container.html(tpl);
                    }
                })
            }else {
                alert('请先选择组织和部门！');
            }

        },
        selectHandler:function (e) {
            e.preventDefault();

            if ($(this).data('id') && basicPanel.data.managerCode!==$(this).data('id')) {

                basicPanel.data.managerCode = $(this).data('id').trim();
                basicPanel.data.manager = $(this).data('name').trim();
                basicPanel.render(basicPanel.data);
            }
            /*searchSelect.searchBtn.dropdown('toggle');*/
        },
        render:function (list) {

            if (!(list instanceof Array) || list.length===0) return '<li><a href="#" style="padding-left: 6px">暂无数据</a></li>';

            var tpl = '';
            $.each(list, function (i, item) {
                tpl += '<li><a href="#" data-id="'+item.code+'" data-name="'+item.cname+'" style="padding-left: 6px">'+item.cname+'</a></li>';
            });
            return tpl;
        }
    };

    // 图片路径展示组件
    var imgGroup = {
        inputGroups:$('#production_licenses,#pesticide_registration,#discharge_permit'),
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
        start:'[name="cooperateTime"]',
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
            basicPanel.data.coopMonths = res?res:0;
            basicPanel.data.cooperateTime = $(this).val();
            basicPanel.render(basicPanel.data);
        }
    };


    basicPanel.init();
    /*treeModal.init();
    searchSelect.init();
    imgGroup.init();
    upImgModal.init();
    timeLinkage.init();*/
});