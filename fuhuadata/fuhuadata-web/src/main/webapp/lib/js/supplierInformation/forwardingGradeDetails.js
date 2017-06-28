/**
 * Created by 胡向阳 on 2017/6/8.
 */

$(function(){
    var scoreId = $('#scoreId').val(),
        forwardingId = $('#forwardingId').val(),
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
            verify:(function () {
                return $('#order_grade').validate({
                    errorPlacement: function(error, element) {
                        $( element )
                            .closest( "td" )
                            .append( error );
                    },
                    rules: {
                        '1': 'required',
                        '2': 'required',
                        '3': 'required',
                        '4': 'required',
                        '5': 'required',
                        '6': 'required',
                        '7': 'required',
                        '8': 'required',
                        '9': 'required',
                        '10': 'required',
                        '11': 'required',
                        '12': 'required',
                        '13': 'required',
                        '14': 'required',
                        '15': 'required',
                        '16': 'required',
                        '17': 'required',
                        '18': 'required',
                        '19': 'required',
                        '20': 'required',
                        '21': 'required',
                        '22': 'required',
                        '23': {
                            'required':'#rel:checked'
                        }
                    },
                    messages: {
                        '1': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '2': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '3': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '4': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '5': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '6': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '7': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '8': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '9': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '10': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '11': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '12': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '13': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '14': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '15': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '16': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '17': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '18': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '19': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '20': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '21': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '22': {
                            required:em('请选择一个值','top:-29px','left:0')
                        },
                        '23': {
                            required:em('请选择一个值','top:-29px','left:0')
                        }
                    }
                });
            })(),
            data:[],
            ectype:null,
            init:function () {
                var self = this;
                $.ajax({
                    url:basePath+'/supplier/forwarding/evaluationIndexItem?scoreId='+scoreId,
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
                            self.renderObj(res.data.forwardingScore);
                            panel.toShowHandler();
                            /*self.addEvent('click.cancel', self.cancelBtn, self.cancelHandler);
                            self.addEvent('click.save', self.saveBtn, self.saveHandler);
                            self.addEvent('click.calculate', self.radios, self.calculateHandler);
                            self.addEvent('change.calculate', self.remarks, self.upDataHandler);
                            panel.toEditHandler();*/
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
                                tr += '<td rowspan="'+thisRow+'">'+item.itemName+'</td>';
                                rows = 0;
                                part = 'part'+i; // 标记，代表属于哪一部分
                                cir(item.nodes);
                                break;
                            case 2:
                                if (i>0) tr += '<tr>';
                                tr += '<td rowspan="'+item.nodes.length+'">'+item.itemName+'</td>';
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
                                    '<td><input class="form-control" name="remark'+theItem+'" data-edit="on" type="text" disabled></td>';
                                    switch (theItem) {
                                        case 8:
                                            tr += '<td class="text-info" name="score'+theItem+'" data-name="'+part+'" rowspan="4"></td></tr>';
                                        break;
                                        case 9:
                                            break;
                                        case 10:
                                            break;
                                        case 11:
                                            break;
                                        default:
                                            tr += '<td class="text-info" name="score'+theItem+'" data-name="'+part+'"></td></tr>';
                                    }
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
                $('[name="22"]', form.formDom).eq(1).attr('id','rel');
            },
            renderData:function (list) {

                if (!Array.isArray(list)) return;

                var total = 0,
                    isCalculate=true,
                    multiValue=6,
                    theScore;
                $.each(list, function (i, item) {
                    var theItem = item.evaluationItemId;

                    $('[name="'+theItem+'"]')
                        .val([form.hasField(item.score)])
                        .data('index',i); // 单选按钮
                    $('[name="remark'+theItem+'"]')
                        .val(form.hasField(item.remarks)); // 备注
                    switch (theItem) {
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                            if (!item.score) { // 8 9 10 11执行同一个函数
                                isCalculate = false;
                            }
                            /*console.log(isCalculate);*/
                            break;
                        case 23:
                            break;
                        case 22:
                            theScore=item.score;
                        default:
                            $('[name="score'+theItem+'"]')
                                .text(form.hasField(item.score)); // 得分
                            total += (typeof item.score==='number'?item.score:0);
                    }

                });
                var a = $('[name="8"]').data('index');

                if (typeof a==='number') {

                    var res = multiValue*(isCalculate?1:0);
                    $('[name="score8"]')
                        .text(form.hasField(res)); // 得分
                    total += res;
                }
                var i = $('[name="23"]').data('index');

                if (theScore===0) { // 有投诉记录时，启用整改评价

                    if (typeof i === 'number') {
                        var b =typeof form.data[i].score==='number'?form.data[i].score:0;
                        $('[name="score23').text(form.hasField(b));
                        total += b;
                    }
                    $('[name="23"]').attr('disabled', false);
                    $('[name="remark23"]').attr('disabled', false);
                }else {
                    if (typeof i === 'number') {
                        form.data[i].score=0;
                        form.data[i].remarks='';
                    }
                    $('[name="23"]').attr('disabled', true).prop('checked', false);
                    $('[name="remark23"]').attr('disabled', true).val('');
                    $('[name="score23').text('')
                }
                form.totalScore.text(total);
            },
            renderObj:function (o) {

                if (!!o) {

                    $('[name="primaryRemark"]', form.formDom).val(o.remarks);
                }
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

                if (!form.isPass()) return;

                if (confirm('确定要保存吗？保存过后将不能修改。')) {

                    var data = {
                        score:{},
                        list:form.data
                    };
                    data.score.serviceScore = form.addNumber('[data-name="part1"]');
                    data.score.priceScore = form.addNumber('[data-name="part2"]');
                    /*console.log(data.score.serviceScore);*/
                    data.score.warehouseScore = form.addNumber('[data-name="part3"]');
                    data.score.complaintsScore = form.addNumber('[data-name="part4"]');
                    data.score.totalScore = data.score.serviceScore + data.score.priceScore + data.score.warehouseScore + data.score.complaintsScore;
                    data.score.remarks = $('[name="primaryRemark"]',form.formDom).val();
                    data.score.forwardingId = forwardingId;
                    data.score.id = scoreId;
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
                    val = parseFloat($('[name="'+name+'"]',form.formDom).filter(':checked').val()),
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
                        evaluationItemId:parseInt(name),
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
                        evaluationItemId:parseInt(name),
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
            },
            isPass:function () { // 验证
                return form.verify.form();
            }
        };
    form.init();
});