/**
 * Created by 胡向阳 on 2017/6/8.
 */

$(function(){
    var orderId = $('#orderId').val(),
        panel = {
            panelDom:'#container',
            eidtBtn:'[name="edit"]',
            toShowHandler:function () { // 展示状态
                var hide = form.editViews,
                    show = form.editHides,
                    ON = form.editOFF,
                    OFF = form.editON;
                hide.addClass('hidden');
                show.removeClass('hidden');
                $(ON,'#container').attr('disabled', false);
                $(OFF,'#container').attr('disabled', true);
            },
            toEditHandler:function () { // 编辑状态
                var hide = form.editHides,
                    show = form.editViews,
                    ON = form.editON,
                    OFF = form.editOFF;
                hide.addClass('hidden');
                show.removeClass('hidden');
                $(ON,'#container').attr('disabled', false);
                $(OFF,'#container').attr('disabled', true);
            }
        },
        form = {
            formDom:'#order_grade',
            body:'#grade_list',
            remarks:'[name^="remark"]',
            saveBtn:'[name="save"]',
            cancelBtn:'[name="cancel"]',
            radios:'[type="radio"]',
            totalScore:$('[name="totalScore"]', '#order_grade'),
            editViews:$('[data-view="editView"]', '#container'), // 编辑状态显示的dom
            editHides:$('[data-view="editHide"]', '#container'), // 编辑状态隐藏的dom
            editON:'[data-edit="on"]', // 编辑状态启用的控件
            editOFF:'[data-edit="off"]', // 编辑状态禁用的控件
            data:[],
            ectype:null,
            init:function () {
                var self = this;
                $.ajax({
                    url:basePath+'/supplier/forwarding/evaluationIndexItem?scoreId=2',
                    dataType:'json',
                    contentType:'application/json',
                    type:'GET'
                }).done(function (res) {

                    if (res.code===1) {

                        self.renderTable(res.data.terms); // 渲染table Dom结构

                        if (res.data.scoreList) {

                            self.data = res.data.scoreList;
                            self.ectype = $.extend(true, [], self.data); // 深拷贝一份数据对象的副本
                            self.renderData(self.data); // 为table渲染数据
                            panel.toShowHandler();
                        }else {
                            self.addEvent('click.cancel', self.cancelBtn, self.cancelHandler);
                            self.addEvent('click.save', self.saveBtn, self.saveHandler);
                            self.addEvent('click.calculate', self.radios, self.calculateHandler);
                            self.addEvent('change.calculate', self.remarks, self.upDataHandler);
                            panel.toEditHandler();
                        }
                    }
                });
            },
            renderTable:function (data) { // 渲染表格

                if (!data) return;

                var self = this,
                    tr='',
                    lev = 0,
                    rows = 0,
                    thisRow = '',
                    part = '',
                    cir = function (arr) {
                    lev++; // 标志当前循环的层级
                    $.each(arr, function (i, item) {
                        var level = lev;
                        switch (level) {
                            case 1:
                                thisRow = 'level'+level+'_'+(++i);
                                tr += '<tr>';
                                tr += '<td rowspan="'+thisRow+'">' + item.itemName + '</td>';
                                rows = 0;
                                part = 'part'+i; // 标记，代表属于哪一部分
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
                                        '<input name="'+theItem+'" data-edit="on" type="radio" value="'+o.value+'" disabled>'+
                                        o.optionName+
                                        '</label>';
                                });
                                tr += '</td>' +
                                    '<td><input class="form-control" name="remark'+theItem+'" data-edit="on" type="text" disabled></td>' +
                                    '<td class="text-info" name="score'+theItem+'" data-name="'+part+'"></td></tr>';
                                break;
                        }
                    });
                    lev--; // 标志退出当前循环的层级

                    if (lev===1) { // 退出第二层循环时替换level*-*字段

                        tr = tr.replace(thisRow,rows);
                    }
                };
                cir(data);
                $('#factory_list').html(tr);
            },
            renderData:function (list) {

                if (!Array.isArray(list)) return;

                var total = 0;
                $.each(list, function (i, item) {
                    $('[name="'+item.evaluationValueId+'"]')
                        .val([form.hasField(item.score)])
                        .data('index',i);
                    $('[name="remark'+item.evaluationValueId+'"]')
                        .val(form.hasField(item.remarks));
                    $('[name="score'+item.evaluationValueId+'"]')
                        .text(form.hasField(item.score));
                    total += item.score;
                });
                form.totalScore.text(total);
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
                location.href = basePath+'/supplier/forwarding/intoForwardingGradeList?id=1'
            },
            saveHandler:function () {

                if (confirm('确定要保存吗？保存过后将不能修改。')) {

                    var data = {
                        score:{},
                        list:form.data
                    };
                    data.score.serviceScore = form.addNumber('[data-name="part1"]');
                    data.score.priceScore = form.addNumber('[data-name="part2"]');
                    data.score.warehouseScore = form.addNumber('[data-name="part3"]');
                    data.score.complaintsScore = form.addNumber('[data-name="part4"]');
                    data.score.totalScore = data.score.serviceScore + data.score.priceScore + data.score.warehouseScore + data.score.complaintsScore;
                    data.score.forwardingId = 1;
                    data.score.monthTime = "2016-12";
                    data.score.id = 2;
                    /*console.log(data);*/
                    $.ajax({
                        url:basePath+'/supplier/forwarding/saveScore',
                        type:'POST',
                        data:JSON.stringify(data),
                        contentType:'application/json'
                    }).done(function (res) {

                        if (res.code===1) {

                            alert('评价成功！');
                            /*form.init();*/
                            location.href = basePath+'/supplier/forwarding/intoForwardingGradeList?id=1'
                        }
                    })
                }

            },
            calculateHandler:function () {

                var name = $(this).attr('name'),
                    val = parseInt($('[name="'+name+'"]',form.formDom).filter(':checked').val()),
                    i = $('[name="'+name+'"]',form.formDom).data('index'), // 与form.data数组的下标相对应，如果没有则为undefined
                    cb = function () {
                        form.renderData(form.data);
                    };
                if (typeof i==='number') {

                    if (val===form.data[i].score) return; // 如果点击的值和当前值相等则返回

                    form.data[i].score = val;
                    cb(); // 重新渲染数据
                }else {

                    var obj = {
                        score:val,
                        evaluationValueId:parseInt(name),
                    };
                    i = form.data.push(obj)-1;
                    $('[name="'+name+'"]',form.formDom).data('index',i);
                    cb();
                }
                /*console.log(form.data);*/
            },
            upDataHandler:function () {
                var val = $(this).val().trim(),
                    str = $(this).attr('name'),
                    j = str.search(/\d/),
                    name = str.slice(j), // 取得对应radio的name
                    i = $('[name="'+name+'"]',form.formDom).data('index');

                if (typeof i==='number') {

                    form.data[i].remarks = val;
                }else {

                    var obj = {
                        remarks:val,
                        evaluationValueId:parseInt(name),
                    };
                    i = form.data.push(obj)-1;
                    $('[name="'+name+'"]',form.formDom).data('index',i);
                }

            },
            addNumber:function (els) {
                var n = 0;
                $(els).each(function () {
                    n+=parseInt(($(this).text()?$(this).text():0));
                });
                return n;
            }
        };
    form.init();
});