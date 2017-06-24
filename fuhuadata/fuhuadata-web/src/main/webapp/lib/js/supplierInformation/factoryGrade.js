/**
 * Created by 胡向阳 on 2017/6/8.
 */

$(function(){
    var orderId = $('#orderId').val(),
        panel = {
            panelDom:'#container',
            eidtBtn:'[name="edit"]',
            init:function (id) {

                if (id+'') { // 如果有id进入编辑状态

                    var bindEl = this.eidtBtn,
                        handler = this.toEditHandler;
                    this.toShowHandler();
                    this.addEvent('click.edit', bindEl, handler);

                }else {

                    this.toEditHandler();
                }
            },
            toShowHandler:function () { // 展示状态
                var hide = form.editViews,
                    show = form.editHides,
                    ON = form.editOFF,
                    OFF = form.editON;
                hide.addClass('hidden');
                show.removeClass('hidden');
                ON.attr('disabled', false);
                OFF.attr('disabled', true);
            },
            toEditHandler:function () { // 编辑状态
                var hide = form.editHides,
                    show = form.editViews,
                    ON = form.editON,
                    OFF = form.editOFF;
                hide.addClass('hidden');
                show.removeClass('hidden');
                ON.attr('disabled', false);
                OFF.attr('disabled', true);
            },
            addEvent:function (eType, el, handler) {
                $(this.panelDom).off(eType).on(eType, el, handler);
            },
        },
        form = {
            formDom:'#order_grade',
            body:'#grade_list',
            scores:'[name="evaScore"]',
            remarks:'[name="evaRemark"]',
            remark:'[name="remark"]',
            saveBtn:'[name="save"]',
            cancelBtn:'[name="cancel"]',
            totalScore:$('[name="totalScore"]', '#order_grade'),
            editViews:$('[data-view="editView"]', '#container'), // 编辑状态显示的dom
            editHides:$('[data-view="editHide"]', '#container'), // 编辑状态隐藏的dom
            editON:$('[data-edit="on"]', '#container'), // 编辑状态启用的控件
            editOFF:$('[data-edit="off"]', '#container'), // 编辑状态禁用的控件
            verify:(function () {
                return $('#order_grade').validate({
                    rules: {
                        evaScore: 'required'
                    },
                    messages: {
                        evaScore:{
                            required:em('必填','top:-29px','right:0')
                        }
                    }
                });
            })(),
            data:{},
            ectype:null,
            init:function () {
                var self = this;

                $.ajax({
                    url:basePath+'/factory/eva/'+orderId,
                    dataType:'json',
                    contentType:'application/json',
                    async:true,
                    type:'GET'
                }).done(function (res) {

                    if (res.code===1) {

                        if (res.data) {

                            self.data = res.data;
                            self.ectype = $.extend(true, {}, self.data); // 深拷贝一份数据对象的副本
                            self.render(self.data);
                        }else {

                            self.data.id = '';
                            self.data.totalScore = 0;
                            self.data.remark = '';
                            self.data.items = [];
                            $(self.body).find('tr[name]').each(function (i, item) {
                                var o = {
                                    id:parseInt($(this).attr('name')),
                                    score:parseInt($(this).find('[name="maxScore"]').text().trim()),
                                    evaScore:0,
                                    evaRemark:''
                                };
                                self.data.items.push(o);
                            });
                            self.render(self.data);
                            self.addEvent('click.cancel', self.cancelBtn, self.cancelHandler);
                            self.addEvent('click.save', self.saveBtn, self.saveHandler);
                            self.addEvent('input.calculate', self.scores, self.calculateHandler);
                            self.addEvent('change.upData', self.remarks+','+self.remark, self.upDataHandler);
                        }

                        panel.init(self.data.id);
                    }
                });
            },
            render:function (data) {

                if (!data) return;
                var self = this;
                $.each(data.items, function (i, item) {
                    $('[name="'+item.id+'"]', self.formDom).find('[name="evaScore"]')
                        .val(self.hasField(item.evaScore))
                        .end().find('[name="evaRemark"]')
                        .val(self.hasField(item.evaRemark));
                });
                self.totalScore.text(self.hasField(data.totalScore));
                $(self.remark,'#order_grade').val(self.hasField(data.remark));
            },
            hasField:function (field) {

                if (field===null||field===undefined){
                    return '';
                }else {
                    return field;
                }
            },
            addEvent:function (eType, el, handler) {
                $(this.formDom).off(eType).on(eType, el, handler);
            },
            cancelHandler:function () {
                if (history.length>1) {

                    history.back(-1);
                }else {

                    window.close();
                }
            },
            saveHandler:function () {

                if (!form.isPass()) return;

                if (confirm('确定要保存吗？保存过后将不能修改。')) {

                    $.ajax({
                        url:basePath+'/factory/eva/'+orderId,
                        type:'PUT',
                        data:JSON.stringify(form.data),
                        contentType:'application/json'
                    }).done(function (res) {

                        if (res.code===1) {

                            alert('评价成功！');
                           /* form.init();*/
                           form.cancelHandler();
                        }
                    })
                }

            },
            calculateHandler:function () {

                var id = parseInt($(this).closest('tr').attr('name')),
                    val = $(this).val(),
                    isRender = false;
                form.data.totalScore = 0;

                $.each(form.data.items, function (i, item) {


                    val = parseInt(val===''?0:val);

                    if (item.id===id && item.evaScore!==val) {

                        if (item.score>=val && val>=0) {

                            item.evaScore=val;
                            isRender = true;
                        }else {

                            alert('请输入有效值0~'+item.score+'！');
                            isRender = true;
                        }
                    }

                    // 重新计算综合得分
                    form.data.totalScore += parseInt(item.evaScore);
                    return true;
                });

                if (isRender) {

                    form.render(form.data);
                }
            },
            upDataHandler:function () {

                var id = parseInt($(this).closest('tr').attr('name')===undefined?-1:$(this).closest('tr').attr('name')),
                    val = $(this).val();
                val = val.trim();

                if (id!==-1) {

                    $.each(form.data.items, function (i, item) {

                        if (item.id===id && item.evaRemark!==val) {

                            item.evaRemark=val;
                            return false;
                        }else {

                            return true;
                        }
                    });
                }else {

                    form.data.remark=val;
                }

                /*form.render(form.data);*/
            },
            isPass:function () {
                return form.verify.form();
            }
        };
    form.init();
});