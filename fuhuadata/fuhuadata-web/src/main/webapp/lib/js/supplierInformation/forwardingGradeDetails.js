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
            data:{},
            ectype:null,
            init:function () {
                var self = this;

                $.ajax({
                    url:basePath+'/supplier/forwarding/evaluationIndexItem?scoreId=1',
                    dataType:'json',
                    contentType:'application/json',
                    type:'GET'
                }).done(function (res) {

                    if (res.code===1) {

                        if (res.data) {

                            self.data = res.data.scoreList;
                            self.ectype = $.extend(true, [], self.data); // 深拷贝一份数据对象的副本
                            self.renderTable(res.data.terms); // 渲染table Dom结构
                            self.renderData(self.data); // 为table渲染数据
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
            renderTable:function (data) { // 渲染表格

                if (!data) return;

                var self = this,
                    tr='',
                    lev = 0,
                    rows = 0,
                    thisRow = '';
                function cir(arr) {
                    lev++; // 标志当前循环的层级
                    $.each(arr, function (i, item) {
                        var level = lev;
                        switch (level) {
                            case 1:
                                thisRow = 'level'+level+'_'+(++i);
                                tr += '<tr>';
                                tr += '<td rowspan="'+thisRow+'">' + item.itemName + '</td>';
                                rows = 0;
                                cir(item.nodes);
                                break;
                            case 2:
                                if (i>0) tr += '<tr>';
                                tr += '<td rowspan="'+item.nodes.length+'">' + item.itemName + '</td>';
                                rows += item.nodes.length;
                                cir(item.nodes);
                                break;
                            case 3:
                                if (i>0) tr += '<tr>';
                                var theItem;
                                tr += '<td>'+item.itemName+'</td>';
                                tr += '<td>';
                                $.each(item.values, function (j, o) {
                                    theItem = o.evaluationItemId;
                                    tr +=
                                        '<label class="radio-inline">' +
                                        '<input name="'+theItem+'" type="radio" value="'+o.value+'">'+
                                        o.optionName+
                                        '</label>';
                                });
                                tr += '</td>' +
                                    '<td><input class="form-control" name="remark'+theItem+'" type="text"></td>' +
                                    '<td class="text-info" name="score'+theItem+'"></td></tr>';
                                break;
                        }
                    });
                    lev--; // 标志退出当前循环的层级

                    if (lev===1) { // 退出第二层循环时替换level*-*字段

                        tr = tr.replace(thisRow,rows);
                    }
                }
                cir(data);
                $('#factory_list').html(tr);
            },
            renderData:function (list) {

                if (!Array.isArray(list)) return;

                $.each(list, function (i, item) {
                    $('[name="'+item.evaluationValueId+'"]').val([item.score]);
                    $('[name="remark'+item.evaluationValueId+'"]').val(item.remarks);
                    $('[name="score'+item.evaluationValueId+'"]').text(item.score);
                });
                /*"id": 1,
                    "forwardingScoreId": 1,
                    "evaluationValueId": 1,
                    "remarks": "备注",
                    "score": 6*/
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
                /*form.render(form.ectype);
                 panel.toShowHandler();*/

            },
            saveHandler:function () {

                if (confirm('确定要保存吗？保存过后将不能修改。')) {

                    $.ajax({
                        url:basePath+'/factory/eva/'+orderId,
                        type:'PUT',
                        data:JSON.stringify(form.data),
                        contentType:'application/json'
                    }).done(function (res) {

                        if (res.code===1) {

                            alert('评价成功！');
                            form.init();
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
            }
        };
    form.init();
});