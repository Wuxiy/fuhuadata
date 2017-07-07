/**
 * Created by Huxiangyang on 2017/7/5.
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
                    data = {
                        startDate:self.child[0].val(),
                        endDate:self.child[1].val(),
                        statType:self.child[2].val(),
                        categoryType:self.child[3].val(),
                        categoryId:self.child[4].val()
                    };
                self.oldData = $.extend(true, {}, self.data); // 深拷贝
                self.data = data;
            },
            resetChild:function () {
                var self = this;
                self.child[0].val(self.oldData.startDate);
                self.child[1].val(self.oldData.endDate);
                self.child[2].val(self.oldData.statType);
                self.child[3].val(self.oldData.categoryType);
                self.child[4].val(self.oldData.categoryId);
                self.data = $.extend(true, {}, self.oldData);
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
            target:'[name="statType"],[name="startDate"],[name="endDate"]',
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
                        url:basePath+'/customs/companies',
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
                    url:basePath+'/customs/data/company',
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
                        // console.log(o);
                            return o;
                        },self.stateBindColor);
                        // console.log(self.option);
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
        };
    subDropdownList.init();
    supDropdownList.init();
    otherInput.init();
    upExcelBtn.init();
    selectpicker.init();
})();