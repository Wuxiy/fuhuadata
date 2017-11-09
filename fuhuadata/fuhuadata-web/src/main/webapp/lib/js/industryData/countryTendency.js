/**
 * Created by Huxiangyang on 2017/7/5.
 */

(function () {
    var form = {
            child:[
                $('[name="timeType"]','#search_data'),
                $('[name="daterange"]','#search_data'),
                $('[name="countries"]','#search_data'),
                $('[name="statType"]','#search_data'),
                $('[name="categoryType"]','#search_data'),
                $('[name="categoryId"]','#search_data')
            ],
            data:{},
            getData:function () {
                var self = this,
                    arr = self.child[1].val().split(' - '),
                    data = {
                        timeType:self.child[0].val(),
                        startDate:arr[0],
                        endDate:arr[1],
                        statIds:self.child[2].selectpicker('val'),
                        statType:self.child[3].val(),
                        categoryType:self.child[4].val(),
                        categoryId:self.child[5].val()
                    };

                if (Array.isArray(data.statIds)) data.statIds=data.statIds.join(',');

                if (data.startDate.length<5) {

                    data.startDate = data.startDate + '-01-01';
                    data.endDate = data.endDate + '-01-01';
                }else {

                    data.startDate = data.startDate + '-01';
                    data.endDate = data.endDate + '-01';
                }
                self.data = data;
            }
        },
        subDropdownList = {
            parent:'#search_data',
            target:'[name="categoryId"]',
            isListen:false,
            init:function () {
                var self = this;
                form.getData();
                $.ajax({
                    url:basePath+'/customs/'+
                    (form.data.categoryType==='type'?'product/types':'products'),
                    type:'GET'
                }).done(function (res) {
                    if (!(res.code===1&&res.data)) return;
                    var _html = self.render(res.data);
                    $(self.target,self.parent).html(_html);
                    myChart.init();
                });

                if (!self.isListen) {

                    self.addEvent()
                }else {

                    return false;
                }
            },
            render:function (list) {

                if (Array.isArray(list)) {

                    var tlp = '';
                    $.each(list, function (i, item) {
                        tlp += '<option value="'+item.id+'">'+item.name+'</option>';
                    })
                    return tlp;
                }
            },
            addEvent:function () {
                var self = this;
                $(self.target, self.parent).on('change', self.changeHandler);
                self.isListen = true;
            },
            changeHandler:function () {
                myChart.init();
            }
        },
        supDropdownList = {
            parent:'#search_data',
            target:'[name="categoryType"]',
            init:function () {
                this.addEvent();
            },
            addEvent:function () {
                var self = this;
                $(self.target, self.parent).on('change', self.changeHandler);
            },
            changeHandler:function () {
                subDropdownList.init();
            }
        },
        otherInput = {
            parent:'#search_data',
            target:'[name="statType"]',
            init:function () {
                this.addEvent();
            },
            addEvent:function () {
                var self = this;
                $(self.target, self.parent).on('change', self.changeHandler);
            },
            changeHandler:function () {
                myChart.init()
            }
        },
        upExcelBtn = {
            parent:'#uploadFile',
            target:'[name="save"]',
            verify:(function () {
                return $('#customsForm').validate({
                    rules: {
                        startDate: 'required',
                        endDate: 'required',
                        excel: 'required'
                    },
                    messages: {
                        startDate:{
                            required:em('必填','top:-29px','right:0')
                        },
                        endDate:{
                            required:em('必填','top:-29px','right:0')
                        },
                        excel:{
                            required:em('请选择一个excel文件','top:-29px','left:0')
                        }
                    }
                });
            })(),
            init:function () {
                this.addEvent();
            },
            addEvent:function () {
                var self = this;
                $(self.target, self.parent).on('click', self.changeHandler);
            },
            changeHandler:function () {
//                console.log($('#customsForm')[0]);

                if (!upExcelBtn.isPass()) return;

                var data = new FormData($('#customsForm')[0]);
                masking.showLoading('上传中,时间可能稍长,请耐心等待...');
                $.ajax({
                    url:basePath+'/customs/data/excel',
                    type:'POST',
                    dataType:'JSON',
                    cache:false,
                    processData:false,
                    contentType:false,
                    data:data
                }).done(function (res) {

                    if (!(res.code===1)) return;

                    alert(res.data);
                    $('#uploadFile').modal('hide');
                    $('#customsForm')[0].reset();
                }).fail(function () {
                    alert('上传失败,请重试!');
                }).always(function () {
                    masking.hideLoading();
                });
            },
            isPass:function () {
                var self = this;
                return self.verify.form();
            }
        },
        myChart = {
            stateBindColor:[
                {
                    name:'Brazil',
                    color:'rgb(51,204,51)'
                },
                {
                    name:'Garner',
                    color:'rgb(255,102,0)'
                },
                {
                    name:'Russia',
                    color:'rgb(0,255,255)'
                },
                {
                    name:'Australia',
                    color:'rgb(255,80,80)'
                },
                {
                    name:'Argentina',
                    color:'rgb(204,255,153)'
                },
                {
                    name:'Cote d\'lvoire',
                    color:'rgb(255,153,51)'
                },
                {
                    name:'Ukraine',
                    color:'rgb(51,51,255)'
                },
                {
                    name:'India',
                    color:'rgb(204,0,102)'
                },
                {
                    name:'USA',
                    color:'rgb(153,255,153)'
                },
                {
                    name:'Nigeria',
                    color:'rgb(255,204,0)'
                },
                {
                    name:'Turkey',
                    color:'rgb(0,102,255)'
                },
                {
                    name:'Indonesia',
                    color:'rgb(255,102,153)'
                },
                {
                    name:'Canada',
                    color:'rgb(102,255,51)'
                },
                {
                    name:'Kenya',
                    color:'rgb(204,153,0)'
                },
                {
                    name:'Belarus',
                    color:'rgb(0,153,255)'
                },
                {
                    name:'Malaysia',
                    color:'rgb(255,153,204)'
                },
                {
                    name:'Uruguay',
                    color:'rgb(0,255,0)'
                },
                {
                    name:'South Africa',
                    color:'rgb(255,255,0)'
                },
                {
                    name:'Denmark',
                    color:'rgb(0,0,204)'
                },
                {
                    name:'Thailand',
                    color:'rgb(204,51,153)'
                },
                {
                    name:'Paraguay',
                    color:'rgb(102,255,102)'
                },
                {
                    name:'Cameroon',
                    color:'rgb(204,102,0)'
                },
                {
                    name:'Ireland',
                    color:'rgb(102,255,204)'
                },
                {
                    name:'Philippines',
                    color:'rgb(255,0,0)'
                },
                {
                    name:'Mexico',
                    color:'rgb(153,255,102)'
                },
                {
                    name:'Israel',
                    color:'rgb(204,51,0)'
                },
                {
                    name:'Latvia',
                    color:'rgb(0,153,153)'
                },
                {
                    name:'Vietnam',
                    color:'rgb(128,0,128)'
                },
                {
                    name:'Chile',
                    color:'rgb(204,255,102)'
                },
                {
                    name:'Japan',
                    color:'rgb(255,153,153)'
                },
                {
                    name:'Other Country',
                    color:'rgb(191,191,191)'
                },
                {
                    name:'South Korea',
                    color:'rgb(255,204,255)'
                }
            ],
            insChart:echarts.init(document.getElementById('main')),
            option: {
                /*tooltip : {
                    trigger: 'axis',
                    axisPointer : {
                        type : 'shadow'
                    }
                },*/
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross',
                        crossStyle: {
                            color: '#999'
                        }
                    }
                },
                toolbox: {
                    feature: {
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                legend: {
                    data: [] // ajax获取
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis:  {
                    type: 'category',
                    data: [], // ajax获取
                    axisPointer: {
                        type: 'shadow'
                    }
                },
                yAxis: [
                    {
                        type: 'value',
                        name: '数量',
                        axisLabel: {
                            formatter: '{value} '
                        }
                    },
                    {
                        type: 'value',
                        name: '单价',
                        axisLabel: {
                            formatter: '{value} $'
                        }
                    }
                ],
                series: [

                ] // ajax获取
            },
            init:function () {
                var self = this,
                    arr = [];
                if (self.option.legend.data.length>0) {

                    self.render();
                }else {

                    $.ajax({
                        url:basePath+'/customs/countries',
                        type:'GET'
                    }).done(function (res) {

                        if (!(res.code===1&&res.data)) return;

                        /*$.each(res.data, function (i, item) {

                            if (item.name) {

                                self.option.legend.data.push(item.name);
                                if (i<5) {

                                    self.option.legend.selected[item.name] = true;
                                    arr.push(item.name);
                                }else {

                                    self.option.legend.selected[item.name] = false;
                                }
                            }else {

                                return true;
                            }
                        });*/
                        // console.log(self.option.legend.selected);
                        /*self.render();
                        selectpicker.render(res.data);
                        $(selectpicker.target,selectpicker.parent).selectpicker('val',arr);*/

                        // 国家多选框
                        selectpicker.render(res.data);
                        $.each(res.data,function (i, item) {
                            if (i<5) {
                                arr.push(item.id);
                            }else {
                                return true;
                            }
                        });
                        $(selectpicker.target,selectpicker.parent).selectpicker('val',arr);
                        self.render();
                    });
                }

                // 监听实例的legendselectchanged事件
                /*self.insChart.on('legendselectchanged',function (params) {
                    // console.log(params);
                    var arr = Object.keys(params.selected);
                    arr = arr.filter(function (item) {
                        return params.selected[item];
                    });
                    $(selectpicker.target,selectpicker.parent).selectpicker('val',arr);
                    self.option.legend.selected=params;
                })*/
            },
            render:function () {
                var self = this;
                form.getData();
                self.insChart.showLoading();
                $.ajax({
                    url:basePath+'/customs/data/bar/country',
                    type:'GET',
                    data:form.data
                }).done(function (res) {

                    if (!(res.code===1)) return;

                    if (res.data) {
                        var data = res.data.data,
                            leg = res.data.legends,
                            x = res.data.categories;
                        self.option.series = leg.map(function(item){
                            var o = {};
                            this.forEach(function(_item){

                                if(_item.name===item) {
                                    o.name = _item.name;
                                    o.data = data[_item.name];
                                    o.type = 'bar';
                                    o.stack = '数量';
                                    o.itemStyle = o.itemStyle || {};
                                    o.itemStyle.normal = o.itemStyle.normal || {};
                                    o.itemStyle.normal.color = _item.color;
                                }
                            });
                        // console.log(o);
                            return o;
                        },self.stateBindColor);
                        if (form.data.statType==='dollar_total'){
                            self.option.yAxis[0].name='总价';
                        }else {
                            self.option.yAxis[0].name='数量';
                        }
                        self.option.legend.data = leg;
                        self.option.xAxis.data = x;
                        // console.log(self.option);

                        if (uPriceCheckedBox.isChecked()){ // 获取折线图数据

                            var otherData = $.extend(true, {}, form.data);
                            otherData.statType = uPriceCheckedBox.val;
                            $.ajax({
                                url:basePath+'/customs/data/bar/country',
                                type:'GET',
                                data:otherData
                            }).done(function (res) {

                                if (!(res.code===1)) return;

                                if (res.data) {
                                    var data = res.data.data,
                                        labels=[],
                                        arr;
                                    arr = leg.map(function(item){
                                        var o = {};
                                        this.forEach(function(_item){

                                            if(_item.name===item) {
                                                labels.push(_item.name+' U/P');
                                                o.name = _item.name+' U/P';
                                                o.data = data[_item.name];
                                                o.type = 'line';
                                                o.yAxisIndex=1;
                                               /* o.itemStyle = o.itemStyle || {};
                                                o.itemStyle.normal = o.itemStyle.normal || {};
                                                o.itemStyle.normal.color = _item.color;*/
                                            }
                                        });
                                        // console.log(o);
                                        return o;
                                    },self.stateBindColor);
                                    self.option.series = self.option.series.concat(arr);
                                    self.option.legend.data = self.option.legend.data.concat(labels);
                                    self.insChart.setOption(self.option, true);
                                    self.insChart.hideLoading();
                                }
                            });
                        }else {
                            self.insChart.setOption(self.option, true);
                            self.insChart.hideLoading();
                        }
                    }else {

                        alert('暂无数据，请选择其他项！');
                    }
                });
            }
        },
        selectpicker = {
            parent:'#search_data',
            target:'[name="countries"]',
            init:function () {
                var self = this;
                $(self.target,self.parent).on('hidden.bs.select',function () {
                    myChart.init();
                })
            },
            render:function (list) {

                if (Array.isArray(list)) {
                    var self = this,
                        _html = '';
                    $.each(list,function (i,item) {
                        _html += '<option value="'+item.id+'">'+item.name+'</option>';
                    });

                    $(self.target,self.parent)
                        .selectpicker('setStyle', 'btn-xs', 'add')
                        .html(_html)
                        .selectpicker('refresh');
                }
            }
        },
        calendar={
            parent:'#search_data',
            target:'[name="daterange"]',
            icon:'.icon-calendar',
            params:function (timeType) {
                var o,
                    newDate = new Date(),
                    year = newDate.getFullYear(),
                    month = newDate.getMonth()+1,
                    calculateStart = {
                      year:function () {
                          var _year = year-2;
                          return _year+'';
                      },
                      month:function () {
                          var _month,_year;

                          _year = year-1;
                          _month = month;

                          return _year+'-'+_month;
                      }
                    };
                if (timeType==='month') {
                    o = {
                        showDropdowns: true,
                        autoApply: true,
                        startDate: calculateStart.month(),
                        endDate: year+'-'+(month.toString().length===1?'0'+month:month),
                        locale: {
                            format: 'YYYY-MM'
                        }
                    };

                }else if(timeType==='year') {

                    o = {
                        showDropdowns: true,
                        autoApply: true,
                        startDate: calculateStart.year(),
                        endDate: year+'',
                        locale: {
                            format: 'YYYY'
                        }
                    };
                }
                return o;
            },
            init:function () {
                var self = this;
                $(self.target, self.parent).daterangepicker(self.params('month'))
                    .on('hide.daterangepicker',function () {
                        self.cb();
                    });
                $(self.icon, self.parent).on('click',function () {
                    $(this).parent().find('input').click();
                });
            },
            cb:function () {
                myChart.init();
            }
        },
        timeType = {
            parent:'#search_data',
            target:'[name="timeType"]',
            init:function () {
                var self = this;
                $(self.target, self.parent).on('change.timeType', function () {
                    var val = $(this).val();
                    $(calendar.target, self.parent).daterangepicker(calendar.params(val))
                        .on('hide.daterangepicker',function () {
                            calendar.cb();
                        });
                    myChart.init();
                });
            }
        },
        uPriceCheckedBox={
            parent:'#search_data',
            target:'[name="unitPrice"]',
            val:$('[name="unitPrice"]','#search_data').val(),
            isChecked:function () {
              var self = this;
              return $(self.target, self.parent).prop('checked');
            },
            init:function () {
                var self = this;
                $(self.target, self.parent).on('change',function () {
                    myChart.init();
                })
            }
        };
    selectpicker.init();
    calendar.init();
    subDropdownList.init();
    supDropdownList.init();
    otherInput.init();
    upExcelBtn.init();
    timeType.init();
    uPriceCheckedBox.init();
})();