/**
 * Created by Huxiangyang on 2017/7/7.
 */


(function () {
    var form = {
            child:[
                $('[name="timeType"]','#search_data'),
                // $('[name="daterange"]','#search_data'),
                $('[name="startDate"]','#search_data'),
                $('[name="endDate"]','#search_data'),
                $('[name="countries"]','#search_data'),
                $('[name="statType"]','#search_data'),
                $('[name="categoryType"]','#search_data'),
                $('[name="categoryId"]','#search_data')
            ],
            data:{},
            getData:function () {
                var self = this,
                    startDate = self.child[1],
                    endDate = self.child[2],
                    startY = startDate.find('[name="year"]').val(),
                    startM = startDate.find('[name="month"]').val().length===1?'0'+startDate.find('[name="month"]').val():startDate.find('[name="month"]').val(),
                    endY = endDate.find('[name="year"]').val(),
                    endM = endDate.find('[name="month"]').val().length===1?'0'+endDate.find('[name="month"]').val():endDate.find('[name="month"]').val(),
                    data = {
                        timeType:self.child[0].val(),
                        startDate:parseInt(startY)<parseInt(endY)||(parseInt(startY)===parseInt(endY)&&parseInt(startM)<=parseInt(endM))?startY+'-'+startM+'-01':endY+'-'+endM+'-01',
                        endDate:parseInt(startY)<parseInt(endY)||(parseInt(startY)===parseInt(endY)&&parseInt(startM)<=parseInt(endM))?formatEndDate(endY, endM):formatEndDate(startY, startM),
                        statIds:self.child[3].selectpicker('val'),
                        statType:self.child[4].val(),
                        categoryType:self.child[5].val(),
                        categoryId:self.child[6].val()
                    };


                if (Array.isArray(data.statIds)) data.statIds=data.statIds.join(',');


                // 如果日期类型是按年份，且开始日期大于结束日期的年份，则交换两个字段的年份
                if (data.timeType==='year' && parseInt(startY)>parseInt(endY)) {
                    var startCopy = data.startDate;
                    data.startDate = endY + data.endDate.slice(4,7) + '-01';
                    data.endDate = startY + startCopy.slice(4,7) + '-31';
                    startDate.find('[name="month"]').val(12);
                    endDate.find('[name="month"]').val(1);
                }else if(data.timeType==='year' && parseInt(startY)<parseInt(endY)){
                    startDate.find('[name="month"]').val(1);
                    endDate.find('[name="month"]').val(12);
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
            target:'[name="statType"],[name="year"],[name="month"]',
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
                    name:'Dongzhi Guangxin',
                    color:'rgb(255,204,255)'
                },
                {
                    name:'Fuhua',
                    color:'rgb(51,204,51)'
                },
                {
                    name:'Jingma',
                    color:'rgb(153,255,153)'
                },
                {
                    name:'Linhua',
                    color:'rgb(255,0,102)'
                },
                {
                    name:'China Jiangsu International',
                    color:'rgb(252,237,191)'
                },
                {
                    name:'Wynca',
                    color:'rgb(0,176,204)'
                },
                {
                    name:'Sanonda',
                    color:'rgb(217,217,217)'
                },
                {
                    name:'Changshu pesticide factory',
                    color:'rgb(255,192,0)'
                },
                {
                    name:'Jiangshan',
                    color:'rgb(255,153,204)'
                },
                {
                    name:'HDF',
                    color:'rgb(134,138,209)'
                },
                {
                    name:'Huaxing',
                    color:'rgb(0,176,80)'
                },
                {
                    name:'Sinochem',
                    color:'rgb(182,185,227)'
                },
                {
                    name:'Xingfa',
                    color:'rgb(255,255,0)'
                },
                {
                    name:'Jinfanda',
                    color:'rgb(75,177,168)'
                },
                {
                    name:'Jiahui',
                    color:'rgb(255,255,153)'
                },
                {
                    name:'Eastchem',
                    color:'rgb(253,227,224)'
                },
                {
                    name:'Yangnong',
                    color:'rgb(124,200,236)'
                },
                {
                    name:'Hujiang',
                    color:'rgb(181,224,220)'
                },
                {
                    name:'Shenglian',
                    color:'rgb(153,102,0)'
                },
                {
                    name:'CAC Nantong',
                    color:'rgb(255,188,121)'
                },
                {
                    name:'Ninhua',
                    color:'rgb(206,234,232)'
                },
                {
                    name:'Good Harvest',
                    color:'rgb(255,0,0)'
                },
                {
                    name:'Jiahua',
                    color:'rgb(255,102,0)'
                },
                {
                    name:'Taicang pesticide factory',
                    color:'rgb(255,80,80)'
                },
                {
                    name:'Baocheng',
                    color:'rgb(248,2,201)'
                },
                {
                    name:'Rainbow',
                    color:'rgb(248,211,94)'
                },
                {
                    name:'Other',
                    color:'rgb(166,166,166)'
                },
                {
                    name:'Nutrichem',
                    color:'rgb(153,51,102)'
                }
            ],
            insChart:echarts.init(document.getElementById('main')),
            option: {
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
                        url:basePath+'/customs/companies',
                        type:'GET'
                    }).done(function (res) {

                        if (!(res.code===1&&res.data)) return;

                        // 多选框
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

            },
            render:function () {
                var self = this;
                form.getData();
                self.insChart.showLoading();
                $.ajax({
                    url:basePath+'/customs/data/bar/company',
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
                                url:basePath+'/customs/data/bar/company',
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
            init:function (timeType) {
                var startDate = $('[name="startDate"]','#search_data'),
                    endDate = $('[name="endDate"]','#search_data'),
                    monthLabel = $('[name="month-label"]', '#search_data'),
                    startY = startDate.find('[name="year"]'),
                    startM = startDate.find('[name="month"]'),
                    endY = endDate.find('[name="year"]'),
                    endM = endDate.find('[name="month"]'),
                    minDate = $('[name="minDate"]').val().split('-'),
                    maxDate = $('[name="maxDate"]').val().split('-');


                if (timeType==='month') {
                    // startY.val(minDate[0]);
                    // if (minDate[1].includes(0)) {
                    //     startM.val(minDate[1].slice(1,2));
                    // }else {
                    //     startM.val(minDate[1]);
                    // }
                    // endY.val(maxDate[0]);
                    // if (maxDate[1].includes(0)) {
                    //     endM.val(maxDate[1].slice(1,2));
                    // }else {
                    //     endM.val(maxDate[1]);
                    // }
                    startM.removeClass('hidden');
                    endM.removeClass('hidden');
                    monthLabel.removeClass('hidden');


                }else if(timeType==='year') {
                    // startY.val(minDate[0]);
                    startM.val(1);
                    // endY.val(maxDate[0]);
                    endM.val(12);
                    startM.addClass('hidden');
                    endM.addClass('hidden');
                    monthLabel.addClass('hidden');
                }
            }
        },
        timeType = {
            parent:'#search_data',
            target:'[name="timeType"]',
            init:function () {
                var self = this;
                $(self.target, self.parent).on('change.timeType', function () {
                    var val = $(this).val();
                    calendar.init(val);
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
        },
        selectDate = {
            min: $('[name="minDate"]').val(),
            max: $('[name="maxDate"]').val(),
            init: function (year, month) {
                var elYear = $('[name='+year+']'),
                    elMonth = $('[name='+month+']'),
                    startSelect= $('[name="startDate"]'),
                    endSelect= $('[name="endDate"]'),
                    startY = startSelect.find('[name="year"]'),
                    startM = startSelect.find('[name="month"]'),
                    endY = endSelect.find('[name="year"]'),
                    endM = endSelect.find('[name="month"]'),
                    minDate = this.min.split('-'),
                    maxDate = this.max.split('-'),
                    minY = parseInt(minDate[0]),
                    maxY = parseInt(maxDate[0]),
                    arrY = [],
                    arrM = [],
                    optionsY = '',
                    optionsM = '';



                for (var i = minY; i <= maxY; i++) {
                    arrY.push(i);
                }
                for (var j = 1; j <= 12; j++) {
                    arrM.push(j);
                }


                $.each(arrY, function (i, item) {
                    optionsY += '<option value="'+item+'">' + item + '</option>';
                });
                $.each(arrM, function (i, item) {
                    optionsM += '<option value="'+item+'">' + item + '</option>';
                });


                // 渲染日期下拉菜单
                elYear.append(optionsY);
                elMonth.append(optionsM);


                // 为日期下拉菜单设定默认值
                startY.val(minDate[0]);
                if (minDate[1].includes(0)) {
                    startM.val(minDate[1].slice(1,2));
                }else {
                    startM.val(minDate[1]);
                }
                endY.val(maxDate[0]);
                if (maxDate[1].includes(0)) {
                    endM.val(maxDate[1].slice(1,2));
                }else {
                    endM.val(maxDate[1]);
                }

            }
        },
        formatEndDate= function (year, month) {
            var y = parseInt(year),
                m = parseInt(month),
                d;


            switch (m) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    d = 31;
                    break;
                case 2:
                    if (((y%4==0)&&!(y%100==0))||(y%400==0)){
                        d = 29;
                    } else{
                        d = 28;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    d = 30;
                    break;
            }

            if (m.toString().length===1) {
                m = '0'+m;
            }

            return y+'-'+m+'-'+d;
        };
    selectDate.init('year', 'month');
    selectpicker.init();
    calendar.init();
    subDropdownList.init();
    supDropdownList.init();
    otherInput.init();
    upExcelBtn.init();
    timeType.init();
    uPriceCheckedBox.init();
})();