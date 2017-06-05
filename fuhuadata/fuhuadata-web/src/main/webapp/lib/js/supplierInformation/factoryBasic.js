/**
 * Created by 胡向阳 on 2017/6/2.
 */

$(function () {

    // 加工厂id
    var id = $('#factoryId').val();

    // 银行账户table组件
    var bankTable = {
        table:$('#bank_table'),
        addBtn:'[name="addBtn"]',
        delBtn:'[name="delBtn"]',
        dtlBtn:'[name="dtlBtn"]',
        chkAllBtn:$('[name="checkedAll"]', $('#bank_table')),
        container:$('[name="banks"]', $('#bank_table')),
        argsIds:[], // 删除的项目的id
        argsIndex:[], // 删除的对象在数组中的下标
        param:{
            url:basePath+'/supplier/factories/'+id+'/banks',
            type:'GET'
        },
        data:[], // 请求的数据对象
        ectype:null, // 数据对象副本
        item:null,
        init:function () {
            this.empty();
            if (id!=='') {
                this.refresh();
            }
            this.addEvent('click.checkedAll', '[name="checkedAll"]', this.checkedAllHandler);
            this.addEvent('click.delItem', '[name="delBtn"]', this.deleteHandler);
            this.addEvent('click.dtlBtn', '[name="dtlBtn"]', this.showModalHandler);
            this.addEvent('click.addBtn', '[name="addBtn"]', this.addHandler);
        },
        refresh:function () {
            var container = this.container;
            $.ajax(this.param).done(function (res) {

                if (res.code!==1) return;

                bankTable.data = res.data;
                bankTable.ectype = $.extend(true, [], bankTable.data); // 深拷贝一份数据对象的副本
                container.html(bankTable.render(bankTable.data));
            });
        },
        empty:function () {
            this.container.html('');
        },
        render:function (list) {

            if (!(list instanceof Array) || list.length===0) return '<tr><td colspan="6">暂无数据</td></tr>';

            var tpl = '';
            $.each(list, function(i, item){
                tpl +=
                    '<tr>' +
                    '<td class="hidden" data-view="editView"><div class="checkbox"><label for="checkedOne">' +
                    '<input name="checkedOne" type="checkbox" value="'+bankTable.hasField(item.id)+'">' +
                    '</label></div></td>'+
                    '<td class="hidden" data-view="editView"><a href="#" name="dtlBtn" title="'+bankTable.hasField(item.accnum)+'">'+bankTable.hasField(item.accnum)+'</a></td>'+
                    '<td data-view="editHide" title="'+bankTable.hasField(item.accnum)+'">'+bankTable.hasField(item.accnum)+'</td>'+
                    '<td title="'+bankTable.hasField(item.accname)+'">'+bankTable.hasField(item.accname)+'</td>'+
                    '<td title="'+bankTable.hasField(item.pkBankdoc)+'">'+bankTable.hasField(item.bankDocName)+'</td>'+
                    '<td title="'+bankTable.hasField(item.pkBanktype)+'">'+bankTable.hasField(item.bankTypeName)+'</td>'+
                    '<td title="'+bankTable.hasField(item.pkCurrtype)+'">'+bankTable.hasField(item.currtypeName)+'</td>'+
                    '</tr>';
            });
            return tpl;
        },
        hasField:function (field) {

            if (field===null||field===undefined){
                return '';
            }else {
                return field;
            }
        },
        addEvent:function (eType, el, handler) {
            this.table.off(eType).on(eType, el, handler);
        },
        checkedAllHandler:function () { // 全选

            if (bankTable.chkAllBtn.prop('checked')) {

                bankTable.container.find('input').prop('checked', true);
            }else {
                bankTable.container.find('input').prop('checked', false);
            }
        },
        deleteHandler:function () { // 删除
            var el = bankTable.container.find('input');

            if (el.filter(':checked').length>0) {

                if (!confirm('确定要删除这些项吗？')) return;

                el.each(function (i) {

                    if ($(this).prop('checked')) {

                        bankTable.argsIndex.push(i); // 取得选中项的下标数组
                        return true;
                    }else{
                        return true;
                    }
                });

                bankTable.data = bankTable.data.filter(function (v, i, args) {

                    if (bankTable.argsIndex.indexOf(i)>-1 && typeof args[i].id==='number') {

                        bankTable.argsIds.push(args[i].id); // 取得删除项的id数组
                    }
                    return bankTable.argsIndex.indexOf(i)===-1;
                });

                bankTable.container.html(bankTable.render(bankTable.data)); // 刷新列表
                bankTable.argsIndex = []; // 重置选中项的下标数组
                basicPanel.editForm();
            }else {
                alert('请选择要删除的项！');
            }
        },
        showModalHandler:function (e) {
            e.preventDefault();
            var i = $(this).closest('tr').index();
            bankTable.item = bankTable.data[i]; // 取得列表中的当前项
            bankModal.modal.modal('show');
            bankModal.init(bankTable.item);
        },
        addHandler:function () {
            bankTable.item = null; // 用来判断bankModal的保存操作是执行新增，还是编辑
            bankModal.init();
            bankLinkage.firstChangeHandler();
            bankModal.modal.modal('show');
        }
    };

    // 银行账户modal组件
    var bankModal = {
        modal:$('#bank_modal'),
        form:$('#back_form'),
        editBtn:'[name="edit"]',
        saveBtn:'[name="save"]',
        cancelBtn:'[name="cancel"]',
        editView:'[data-view="editView"]',
        editHide:'[data-view="editHide"]',
        editOn:'[data-control="editOn"]',
        editOff:'[data-control="editOff"]',
        verify:(function () {
            return $('#back_form').validate({
                rules: {
                    accnum: 'required',
                    accname: 'required',
                    currtypeName: 'required',
                    pkBanktype: 'required',
                    pkBankdoc: 'required'
                },
                messages: {
                    accnum:{
                        required:em('必填','top:-29px','right:0')
                    },
                    accname:{
                        required:em('必填','top:-29px','right:0')
                    },
                    currtypeName:{
                        required:em('请选择一个值','top:-29px','right:0')
                    },
                    pkBanktype:{
                        required:em('请选择一个值','top:-29px','right:0')
                    },
                    pkBankdoc:{
                        required:em('请选择一个值','top:-29px','right:0')
                    }
                }
            });
        })(),
        init:function (item) {
            bankModal.empty();

            if (item!==undefined && item!==null) {

                bankModal.render(item);
                /*bankModal.viewForm();*/
                /*this.addEvent('click.edit', '[name="edit"]', this.editHandler);*/
            }
            bankModal.editForm();
            this.addEvent('click.cancel', '[name="cancel"]', this.cancelHandler);
            this.addEvent('click.save', '[name="save"]', this.saveHandler);
        },
        render:function (data) {
            $('[name="accnum"]', bankModal.form).val(data.accnum); // 银行账号
            $('[name="accname"]', bankModal.form).val(data.accname); // 银行户名
            $('[name="currtypeName"]', bankModal.form).val(data.pkCountry); // 币种
            $('[name="pkBanktype"]', bankModal.form).val(data.pkBanktype); // 银行类别
            bankLinkage.firstChangeHandler(); // 根据银行类别渲染开户银行
            $('[name="pkBankdoc"]', bankModal.form).val(data.pkBankdoc); // 开户银行
        },
        empty:function () {
            bankModal.form[0].reset();
        },
        editForm:function () {
            $(bankModal.editOn, bankModal.form).attr('disabled', false);
            $(bankModal.editOff, bankModal.form).attr('disabled', true);
            $(bankModal.editView, bankModal.modal).removeClass('hidden');
            $(bankModal.editHide, bankModal.modal).addClass('hidden');
        },
        viewForm:function () {
            $(bankModal.editOn, bankModal.form).attr('disabled', true);
            $(bankModal.editOff, bankModal.form).attr('disabled', false);
            $(bankModal.editView, bankModal.modal).addClass('hidden');
            $(bankModal.editHide, bankModal.modal).removeClass('hidden');
        },
        addEvent:function (eType, el, handler) {
            this.modal.off(eType).on(eType, el, handler);
        },
        editHandler:function () {
            bankModal.editForm();
        },
        cancelHandler:function () {
            bankModal.modal.modal('hide');
        },
        saveHandler:function () {

            if (!bankModal.verify.form()) return;

            var isAdd = (bankTable.item === null);

            if (isAdd) bankTable.item = {};

            bankTable.item.accnum = $('[name="accnum"]', bankModal.form).val();
            bankTable.item.accname = $('[name="accname"]', bankModal.form).val();
            bankTable.item.pkCurrtype = $('[name="currtypeName"]', bankModal.form).val();
            bankTable.item.currtypeName = $('[name="currtypeName"]', bankModal.form).find('option').filter(':selected').text().trim();
            bankTable.item.pkBankdoc = $('[name="pkBankdoc"]', bankModal.form).val();
            bankTable.item.bankDocName = $('[name="pkBankdoc"]', bankModal.form).find('option').filter(':selected').text().trim();
            bankTable.item.pkBanktype = $('[name="pkBanktype"]', bankModal.form).val();
            bankTable.item.bankTypeName = $('[name="pkBanktype"]', bankModal.form).find('option').filter(':selected').text().trim();

            if (isAdd) bankTable.data.push(bankTable.item);

            bankTable.container.html(bankTable.render(bankTable.data)); // 刷新列表
            bankModal.modal.modal('hide');
            basicPanel.editForm();
        },
        isPass:function () {
            return bankModal.verify.form();
        }
    };

    // 银行联动选择框
    var bankLinkage = {
        firstSelect:$('#bank_first'),
        secondSelect:$('#bank_second'),
        firstParam:{
            url:basePath+'/bank/type',
            type:'GET'
        },
        secondParam:{
            url:basePath+'/bank/docs',
            type:'GET',
        },
        init:function () {
            $.ajax(bankLinkage.firstParam).done(function (res) {

                if (res.code === 1 && res.data instanceof Array) {

                    bankLinkage.firstSelect.html(bankLinkage.renderFirst(res.data));
                }
            });
            bankLinkage.addEvent('change.firstSelect', this.firstChangeHandler);
        },
        renderFirst:function (list) {
            var tpl = '';
            $.each(list, function (i, item) {
                tpl += '<option value="' + item.code + '" title="' + item.code + '">' + item.name + '</option>';
            });
            return tpl;
        },
        renderSecond:function (list) {
            var tpl = '';
            $.each(list, function (i, item) {
                tpl += '<option value="' + item.code + '" title="' + item.code + '">' + item.name + '</option>';
            });
            return tpl;
        },
        resetSecond:function () {
            var tpl = '<option value="" title="请先选择银行类别">——请先选择银行类别——</option>';
            bankLinkage.secondSelect.html(tpl);
        },
        addEvent:function (eType, handler) {
            this.firstSelect.off(eType).on(eType, handler);
        },
        firstChangeHandler:function () {
            bankLinkage.secondParam.data = {
                bankTypeCode:$('#bank_first').val()
            };
            bankLinkage.resetSecond();
            $.ajax(bankLinkage.secondParam).done(function (res) {

                if (res.code === 1 && res.data instanceof Array) {

                    bankLinkage.secondSelect.html(bankLinkage.renderSecond(res.data));
                }else {
                    bankLinkage.secondSelect.html('<option value="">暂无数据</option>');
                }
            });
        }
    };

    // 联系人table组件
    var contactTable = {
        table:$('#contact_table'),
        addBtn:'[name="addBtn"]',
        delBtn:'[name="delBtn"]',
        dtlBtn:'[name="dtlBtn"]',
        chkAllBtn:$('[name="checkedAll"]', $('#contact_table')),
        container:$('[name="contacts"]', $('#contact_table')),
        param:{
            url:basePath+'/supplier/factories/'+id+'/linkmen',
            type:'GET'
        },
        argsIds:[], // 删除的项目的id
        argsIndex:[], // 删除的对象在数组中的下标
        data:[], // 请求的数据对象
        ectype:null, // 数据对象副本
        item:null,
        init:function () {
            this.empty();

            if (id!=='') {

                this.refresh();
            }

            this.addEvent('click.checkedAll', '[name="checkedAll"]', this.checkedAllHandler); // 全选
            this.addEvent('click.delItem', '[name="delBtn"]', this.deleteHandler); // 删除
            this.addEvent('click.dtlBtn', '[name="dtlBtn"]', this.showModalHandler); // 详情
            this.addEvent('click.addBtn', '[name="addBtn"]', this.addHandler); // 新增
        },
        refresh:function () {
            var container = this.container;
            $.ajax(this.param).done(function (res) {

                if (res.code!==1) return;

                contactTable.data = res.data || [];
                contactTable.ectype = $.extend(true, [], contactTable.data); // 深拷贝一份数据对象的副本
                container.html(contactTable.render(contactTable.data));
            });
        },
        empty:function () {
            this.container.html('');
        },
        render:function (list) {

            if (!(list instanceof Array) || list.length===0) return '<tr><td colspan="4">暂无数据</td></tr>';

            var tpl = '';
            $.each(list, function(i, item){
                tpl +=
                    '<tr>' +
                    '<td class="hidden" data-view="editView"><div class="checkbox"><label for="checkedOne">' +
                    '<input name="checkedOne" type="checkbox" value="'+contactTable.hasField(item.id)+'">' +
                    '</label></div></td>'+
                    '<td class="hidden" data-view="editView"><a href="#" name="dtlBtn" title="'+contactTable.hasField(item.name)+'">'+contactTable.hasField(item.name)+'</a></td>'+
                    '<td data-view="editHide" title="'+contactTable.hasField(item.name)+'">'+contactTable.hasField(item.name)+'</td>'+
                    '<td title="'+contactTable.hasField(item.phone)+'">'+contactTable.hasField(item.phone)+'</td>'+
                    '<td title="'+contactTable.hasField(item.email)+'">'+contactTable.hasField(item.email)+'</td>'+
                    '</tr>';
            });
            return tpl;
        },
        hasField:function (field) {

            if (field===null||field===undefined){
                return '';
            }else {
                return field;
            }
        },
        addEvent:function (eType, el, handler) {
            this.table.off(eType).on(eType, el, handler);
        },
        checkedAllHandler:function () { // 全选

            if (contactTable.chkAllBtn.prop('checked')) {

                contactTable.container.find('input').prop('checked', true);
            }else {
                contactTable.container.find('input').prop('checked', false);
            }
        },
        deleteHandler:function () { // 删除
            var el = contactTable.container.find('input');

            if (el.filter(':checked').length>0) {

                if (!confirm('确定要删除这些项吗？')) return;

                el.each(function (i) {

                    if ($(this).prop('checked')) {

                        contactTable.argsIndex.push(i); // 取得选中项的下标数组
                        return true;
                    }else{
                        return true;
                    }
                });

                contactTable.data = contactTable.data.filter(function (v, i, args) {

                    if (contactTable.argsIndex.indexOf(i)>-1 && typeof args[i].id==='number') {

                        contactTable.argsIds.push(args[i].id); // 取得删除项的id数组
                    }
                    return contactTable.argsIndex.indexOf(i)===-1;
                });

                contactTable.container.html(contactTable.render(contactTable.data)); // 刷新列表
                contactTable.argsIndex = []; // 重置选中项的下标数组
                basicPanel.editForm();
            }else {
                alert('请选择要删除的项！');
            }
        },
        showModalHandler:function (e) {
            e.preventDefault();
            var i = $(this).closest('tr').index(); // 取得当前项的下标
            contactTable.item = contactTable.data[i]; // 取得数组中的当前项
            contactModal.empty(); // 对联系人modal执行以下操作，清空>渲染>显示
            contactModal.render(contactTable.item);
            contactModal.modal.modal('show');
        },
        addHandler:function () {
            contactTable.item = null; // 用来判断contactModal的保存操作是执行新增，还是编辑
            contactModal.empty();
            contactModal.modal.modal('show');
        }
    };

    // 联系人modal组件
    var contactModal = {
        modal:$('#contact_modal'),
        form:$('#contact_form'),
        saveBtn:'[name="save"]',
        cancelBtn:'[name="cancel"]',
        verify:(function () {
            return $('#contact_form').validate({
                rules: {
                    name: 'required'
                },
                messages: {
                    name:{
                        required:em('必填','top:-29px','right:0')
                    }
                }
            });
        })(),
        init:function (item) {
            contactModal.empty();

            if (item!==undefined && item!==null) {

                contactModal.render(item);
            }
            this.addEvent('click.cancel', '[name="cancel"]', this.cancelHandler);
            this.addEvent('click.save', '[name="save"]', this.saveHandler);
        },
        render:function (data) {
            $('[name="name"]', contactModal.form).val(data.name);
            $('[name="phone"]', contactModal.form).val(data.phone);
            $('[name="email"]', contactModal.form).val(data.email);
        },
        empty:function () {
            contactModal.form[0].reset();
        },
        addEvent:function (eType, el, handler) {
            this.modal.off(eType).on(eType, el, handler);
        },
        cancelHandler:function () {
            contactModal.modal.modal('hide');
        },
        saveHandler:function () {

            if (!contactModal.verify.form()) return;

            var isAdd = (contactTable.item === null); // 判断是新增还是编辑

            if (isAdd) contactTable.item = {};

            contactTable.item.name = $('[name="name"]', contactModal.form).val();
            contactTable.item.phone = $('[name="phone"]', contactModal.form).val();
            contactTable.item.email = $('[name="email"]', contactModal.form).val();

            if (isAdd) contactTable.data.push(contactTable.item);

            contactTable.container.html(contactTable.render(contactTable.data)); // 刷新列表
            contactModal.modal.modal('hide');
            basicPanel.editForm();
        },
        isPass:function () {
            return contactModal.verify.form();
        }
    };

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
        paramPut:{
            url:basePath+'/supplier/factories/'+id,
            type:'PUT',
            contentType:'application/json;charset=UTF-8'
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
            {
                name:'orgName',
                place:{
                    name:'id',
                    field:'pkOrg'
                }
            },
            {
                name:'name'
            },
            {
                name:'abbr'
            },
            {
                name:'oldName'
            },
            {
                name:'registerfund'
            },
            {
                name:'address'
            },
            {
                name:'cooperateTime'
            },
            {
                name:'coopMonths'
            },
            {
                name:'productionLicenses'
            },
            {
                name:'pesticideRegistration'
            },
            {
                name:'dischargePermit'
            },
            {
                name:'remark'
            },
            {
                name:'supstate'
            },
            {
                name:'score',
            },
            {
                name:'managerOrgName',
                place:{
                    name:'id',
                    field:'managerOrgCode'
                }
            },
            {
                name:'managerDepName',
                place:{
                    name:'id',
                    field:'managerDepCode'
                }
            },
            {
                name:'manager',
                place:{
                    name:'id',
                    field:'managerCode'
                }
            },
            {
                name:'modifyTime'
            },
            {
                name:'modifyName'
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
                }/*else if (item.type==='select') {

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

    // 币种选择框
    var currtypeSelect = {
        container:$('#currtype_name'),
        param:{
            url:basePath+'/doc/currtypes',
            type:'GET'
        },
        init:function () {
            $.ajax(this.param).done(function (res) {

                if (res.code===1) {

                    currtypeSelect.container.html(currtypeSelect.render(res.data));
                }
            })
        },
        render:function (list) {
            var tpl = '';
            $.each(list, function (i, item) {
                tpl += '<option value="' + item.code + '" title="' + item.code + '">' + item.name + '</option>';
            });
            return tpl;
        }
    };

    bankTable.init();
    bankLinkage.init();
    contactModal.init();
    contactTable.init();
    basicPanel.init();
    treeModal.init();
    searchSelect.init();
    imgGroup.init();
    upImgModal.init();
    timeLinkage.init();
    currtypeSelect.init();
});