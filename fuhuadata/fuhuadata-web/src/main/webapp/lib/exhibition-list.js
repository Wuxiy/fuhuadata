require.config({
    baseUrl: "/js/app",
    paths: {
        "jquery": "lib/jquery-1.8.3",
        "ui": "../ui.min",
        "domReady": "lib/domReady",
        "datatables": "lib/dataTables/dataTables.min",
        "inputPages": "lib/dataTables/plugins/inputPages",
        "sas": "../sas"
    },
    shim: {
        "jquery": {
            exports: "jQuery"
        },
        "ui": {
            deps: ['jquery'],
            exports: "UI"
        },
        "inputPages": {
            deps: ['jquery', 'datatables']
        },
        "sas": {
            deps: ['jquery']
        }
    }
});

require(
    [
        "domReady",
        "jquery",
        "ui",
        "datatables",
        "inputPages",
        "sas"
    ],

    function(domReady, $, UI){
        domReady(function(){


            var ajaxUrl = '/exhibitionInfo/exhibitionInfoList';



            var columns = [

                {"data": "exhibitionId"},
                {"data": "exhibitionName"},
                {"data": "sponsor"},
                {"data": "organizer"},
                {"data": "country"},
                {"data": "city"},
                {"data": "startDate"},
                {"data": "finishDate"},
                {"data": "exhibitionAddr"},
                {"data": "exhibitionInfo"},
                {"data": "exhibitionLink"},
                {"data": "creator"},
                {"data": "createTime"}
            ];



            var checkAll = function(){
                var checkAll = $('#checkAll'),
                allCheckbox = $("input[name='cellcheckbox']");

                //监听全选框变化
                checkAll.change(function(){
                    if (checkAll.attr('checked')) {
                        allCheckbox.each(function(){
                            if($(this).attr('disabled') != 'disabled'){
                                $(this).attr('checked',true);
                                $(this).parent().parent().addClass('marked');
                            }
                        });
                    } else {
                        allCheckbox.each(function(){
                            if($(this).attr('disabled') != 'disabled'){
                                $(this).removeAttr('checked');
                                $(this).parent().parent().removeClass('marked');
                            }
                        });
                    }
                });

                //给所有的子复选框添加监听函数
                allCheckbox.change(function(){
                    $this = $(this);
                    if ($this.attr('checked')) {
                        $this.parent().parent().addClass('marked');
                    } else {
                        $this.parent().parent().removeClass('marked');
                        checkAll.removeAttr('checked');
                    }
                });
            };

            var tableDrawCallbck = function() {

                //设置全选操作
                checkAll();

                //生成用户证书
                $('.license-btn').unbind('click').bind('click',function(){
                    var url = $(this).attr("data_url");
                    top.dialog.show({
                        "title":'生成证书',
                        "url":url,
                        "call":'hideDialogCall',
                        "width":'400',
                        "height":'380'
                    });
                });
                $(".cert-down").unbind('click').bind('click',function(){
                    var url = $(this).attr("data_url");
                    window.location.href=url;
                });

                //创建关联策略
                $('.acp-create-btn').unbind('click').bind('click',function(){
                    var url = $(this).attr("data_url");
                    window.location.href=url;
                });

                //查看关联策略
                $('.acp-view-btn').unbind('click').bind('click',function(){
                    var url = $(this).attr("data_url");
                    top.dialog.show({
                        "title":'关联策略',
                        "url":url,
                        "call":"hideDialogCall",
                        "width":'880',
                        "height":'600'
                    });
                });

                //设置用户状态
                $('.enable_check').unbind('click').bind('click',function(){
                    var msg ='确定要改变此用户的使用状态';

                    if (confirm(msg)) {
                        var url = $(this).attr("data_url");

                        $.ajax({
                            url: url,
                            type: "GET",
                            dataType:"json",
                            success: function(resp){
                                if (resp.code != 0) {
                                    alert(resp.msg);
                                }
                                user_table.ajax.reload();
                            }
                        });
                    } else {
                        user_table.ajax.reload();
                    }
                    return;
                });

                //查看关联日志
                $('.log-view-btn').unbind('click').bind('click',function(){
                    var url = $(this).attr("data_url");
                    top.dialog.show({
                        "title":'查看',
                        "url":url,
                        "width":'880',
                        "height":'600'
                    });
                });

                //编辑用户
                $('.edit-btn').unbind('click').bind('click',function(){
                    var url = $(this).attr("data_url");
                    window.location.href=url;
                });

                //删除用户
                $('.delete-btn').unbind('click').bind('click',function(d){
                    var url = $(this).attr("data_url");
                    var role = $(this).attr('data_role');

                    if (role == 'auditors') {
                        $.ajax({
                            url:url,
                            type:"GET",
                            success:function() {
                                user_table.ajax.reload();
                            }
                        });
                    } else {
                        top.dialog.show({
                            "title":'删除确认',
                            "url":url,
                            "call":'hideDialogCall',
                            "width":'440',
                            "height":'380'
                        });
                    }
                });

                UI.table_hover();
                UI.input_hover();
            };

            var initCallback = function(settings, resp) {

                var rights = resp.rights;
                var create_btn = '',edit_btn='',delete_btn='';

                if (rights.has_create_right) {
                    create_btn = '<button id="user-create" class="cmn_btn cmn_btn_focus" style="margin-left: 8px; margin-bottom: 6px;">新建</button>';
                }
                if (rights.has_del_right) {
                    delete_btn = '<button id="user-delete" class="cmn_btn" style="margin-bottom: 6px">删除</button>';
                }
                if (rights.has_edit_right) {
                    edit_btn = '<button id="user-edit" class="cmn_btn" style="margin-bottom: 6px;margin-right:0px;">批量修改</button>';
                }

                var operate_btn = '<div id="drop" style="margin-bottom:6px;display:inline-block"></div>';
                var btn = create_btn+delete_btn+edit_btn+operate_btn;

                $("#user_table_filter").append(btn);

                var arrJson = eval(rights.operation_list);

                SAS.dropOpera('drop','操作',arrJson,false);

                //控制列

                if (cat == 'temp') {
                    user_table.column(9).visible(true);
                } else {
                    user_table.column(9).visible(false);
                }

                if (rights.has_cert_right) {
                    user_table.column(10).visible(true);
                } else {
                    user_table.column(10).visible(false);
                }

                if (rights.has_policy_right) {
                    user_table.column(11).visible(true);
                } else {
                    user_table.column(11).visible(false);
                }

                if (rights.has_enable_right) {
                    user_table.column(12).visible(true);
                } else {
                    user_table.column(12).visible(false);
                }

                if (rights.has_del_right||rights.has_edit_right) {
                    user_table.column(0).visible(true);
                } else {
                    user_table.column(0).visible(false);
                }

                if (rights.has_edit_right||rights.has_del_right||rights.has_log_right) {
                    user_table.column(13).visible(true);
                } else {
                    user_table.column(13).visible(false);
                }

                //新建函数
                $("#user-create").on("click", function(){
                    var url = '/user/create/cat/'+cat;
                    window.location.href = url;
                });

                //批量删除函数
                $("#user-delete").on("click", function(){
                    var ids = new Array();
                    $("input[name='cellcheckbox']:checked").each(function () {
                        ids.push($(this).val());
                    });

                    if (ids.length > 0){
                        var msg = '确定要批量删除所选的用户？批量删除所选用户，将强制删除或更新对应的用户组和策略';

                        if (confirm(msg)) {
                            var url = '/user/deleteBatched';
                            var param = {'userID': ids+''};

                            $.ajax({
                                url:url,
                                data:param,
                                type:'post',
                                success:function(resp){
                                    var resp = eval(resp);
                                    if (resp != true) {
                                        alert("批量删除用户失败或异常");
                                        user_table.ajax.reload();
                                    } else {
                                        user_table.ajax.reload();
                                    }
                                }
                            });
                        }
                    } else {
                        alert("你还未选择要批量删除的用户");
                    }

                    return;
                });

                //批量修改函数
                $("#user-edit").on("click", function(){
                    var ids = new Array();
                    $("input[name='cellcheckbox']:checked").each(function () {
                        ids.push($(this).val());
                    });

                    if (ids.length > 0) {
                        var msg = '确定要批量修改所选的用户？';
                        if(confirm(msg)){
                            var url = '/user/updateBatched/id/' + ids;

                            top.dialog.show({
                                "title":'批量修改',
                                "url":url,
                                "call":'hideDialogCall',
                                "refresh":false,
                                "width":480,
                                "height":300
                            });
                        }
                    } else {
                        alert('你还未选择要批量修改的用户');
                    }

                    return;
                });
            };

            var user_table = $('#exhibition_table').DataTable({
                "dom": '<"cmn_page"fr<lip>>t<"cmn_page"r<lip>>',
                "pagingType": "full", //分页样式
                "ordering": false,      //表格排序
                "pageLength": 25,      //每页显示条数
                "stateSave": false,
                "processing": true,
                "lengthChange": true,
                "ajax": ajaxUrl,
                "columns": columns,
                "columnDefs": columnDefs,
                "language": {
                    "url": '/js/app/lib/dataTables/lang/dataTables.lang.zh',
                    "searchPlaceholder": '关键字'
                },
                //"fnPreDrawCallback": preDrawCallback,
                //"fnRowCallback": rowDrawCallback,
                "fnDrawCallback": tableDrawCallbck,
                "fnInitComplete": initCallback
            });
            //更改作用域为windows对象,方便弹出框关闭后回调
            window.user_table = user_table;

            UI.table_hover();
            UI.input_hover();
        });
    }
);
