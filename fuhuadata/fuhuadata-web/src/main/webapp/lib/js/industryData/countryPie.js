/**
 * Created by Huxiangyang on 2017/6/30.
 */

(function () {
    var form = {
            child:[
                $('[name="startDate"]','#search_data'),
                $('[name="endDate"]','#search_data'),
                $('[name="statType"]','#search_data'),
                $('[name="categoryType"]','#search_data'),
                $('[name="categoryId"]','#search_data')
            ],
            data:{},
            oldData:{},
            getData:function () {
                var self = this,
                    startDate = self.child[0],
                    endDate = self.child[1],
                    startY = startDate.find('[name="year"]').val(),
                    startM = startDate.find('[name="month"]').val().length===1?'0'+startDate.find('[name="month"]').val():startDate.find('[name="month"]').val(),
                    endY = endDate.find('[name="year"]').val(),
                    endM = endDate.find('[name="month"]').val().length===1?'0'+endDate.find('[name="month"]').val():endDate.find('[name="month"]').val(),
                    data = {
                        startDate:parseInt(startY)<parseInt(endY)||(parseInt(startY)===parseInt(endY)&&parseInt(startM)<=parseInt(endM))?startY+'-'+startM+'-01':endY+'-'+endM+'-01',
                        endDate:parseInt(startY)<parseInt(endY)||(parseInt(startY)===parseInt(endY)&&parseInt(startM)<=parseInt(endM))?formatEndDate(endY, endM):formatEndDate(startY, startM),
                        statType:self.child[2].val(),
                        categoryType:self.child[3].val(),
                        categoryId:self.child[4].val()
                    };
                self.oldData = $.extend(true, {}, self.data); // 深拷贝
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
            option:{
                tooltip : {
                    trigger: 'item',
                    formatter: "{b} : {c} ({d}%)"
                },
                toolbox: {
                    feature: {
                        saveAsImage: {show: true}
                    }
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: [], // ajax获取
                    selected: {} // 配置默认选中项
                },
                series : [
                    {
                        name: '访问来源',
                        type: 'pie',
                        radius : '70%',
                        center: ['50%', '50%'],
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            },
            // defaultSelected:[],
            // onceRender:true,
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

                        $.each(res.data, function (i, item) {

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
                        });
                        // console.log(self.option.legend.selected);
                        self.render();
                        selectpicker.render(res.data);
                        $(selectpicker.target,selectpicker.parent).selectpicker('val',arr);
                    });
                }

                // 监听实例的legendselectchanged事件
                self.insChart.on('legendselectchanged',function (params) {
                    // console.log(params);
                    var arr = Object.keys(params.selected);
                    arr = arr.filter(function (item) {
                            return params.selected[item];
                        });
                    $(selectpicker.target,selectpicker.parent).selectpicker('val',arr);
                    self.option.legend.selected=params;
                })
            },
            render:function () {
                var self = this;
                form.getData();
                self.insChart.showLoading();
                $.ajax({
                    url:basePath+'/customs/data/country',
                    type:'GET',
                    data:form.data
                }).done(function (res) {

                    if (!(res.code===1)) return;

                    if (res.data) {

                        self.option.series[0].data = res.data.map(function(item){
                            var o = {};
                            this.forEach(function(_item){

                                if(_item.name===item.name) {
                                    o.name = item.name;
                                    o.value = item.value;
                                    o.itemStyle = o.itemStyle || {};
                                    o.itemStyle.normal = o.itemStyle.normal || {};
                                    o.itemStyle.normal.color = _item.color;
                                }
                            });
//                        console.log(o);
                            return o;
                        },self.stateBindColor);


                        // 从大到小排序
                        self.option.series[0].data.sort(compareNum);


                        self.insChart.setOption(self.option);
                    }else {

                        alert('暂无数据，请选择其他项！');
                        self.option.series[0].data = [];
                        self.insChart.setOption(self.option);
                    }
                    self.insChart.hideLoading();
                });
            }
        },
        selectpicker = {
            parent:'#search_data',
            target:'[name="countries"]',
            init:function () {
                var self = this;
                $(self.target,self.parent).on('hidden.bs.select',function () {
                    // 对echarts实例进行操作
                    myChart.insChart.showLoading();
                    var arr = $(this).selectpicker('val'),
                        otherArr = myChart.option.legend.data;
                    arr = otherArr.map(function (item,i,arr) {

                        if (this.indexOf(item)===-1) {

                            return {
                                type: 'legendUnSelect',
                                // 图例名称
                                name: item
                            }
                        }else {

                            return {
                                type: 'legendSelect',
                                // 图例名称
                                name: item
                            }
                        }
                    },arr||[]);
                    $.each(arr,function (i, item) {
                        myChart.insChart.dispatchAction(item);
                    });
                    myChart.insChart.hideLoading();
                })
            },
            render:function (list) {

                if (Array.isArray(list)) {
                    var self = this,
                        _html = '';
                    $.each(list,function (i,item) {
                        _html += '<option value="'+item.name+'">'+item.name+'</option>';
                    });

                    $(self.target,self.parent)
                        .selectpicker('setStyle', 'btn-xs', 'add')
                        .html(_html)
                        .selectpicker('refresh');
                }
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
    },
        compareNum = function (a, b) { // 排序规则：从大到小
            if (a.value < b.value) {
                return 1;
            }
            if (a.value > b.value) {
                return -1;
            }

            return 0;
        };
    selectDate.init('year', 'month');
    subDropdownList.init();
    supDropdownList.init();
    otherInput.init();
    upExcelBtn.init();
    selectpicker.init();
})();