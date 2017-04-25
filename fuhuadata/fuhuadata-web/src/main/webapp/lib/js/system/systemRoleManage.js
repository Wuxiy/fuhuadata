/**
 * Created by Huxiangyang on 2017/4/6.
 */


CRM.systemRoleManage = window.CRM.systemRoleManage || {};

CRM.systemRoleManage.ROLE_DETAILS_GET = basePath + '/sys/role/ajax/'; // 角色详情
CRM.systemRoleManage.ROLE_ADD_POST = basePath + '/sys/role/ajax/add'; // 角色添加or更新
CRM.systemRoleManage.ROLE_DELETE_POST = basePath + '/sys/role/ajax/'; // 角色删除
CRM.systemRoleManage.ROLE_RELEVANCE_MENU_POST = basePath + '/sys/roleauth/save'; // 角色关联菜单
CRM.systemRoleManage.ROLE_RELEVANCE_MENU_LOOK_GET = basePath + '/sys/roleauth/menu?roleId='; // 角色菜单查看
CRM.systemRoleManage.MENU_RELEVANCE_LIMITS_POST = basePath + '/sys/roleauth/permission'; // 菜单关联权限
CRM.systemRoleManage.MENU_RELEVANCE_LIMITS_LOOK_GET = basePath + '/sys/roleauth/permission?roleId='; // 菜单权限查看
CRM.systemRoleManage.USER_RELEVANCE_AREA_POST = basePath + '/sys/user/area/save'; // 用户关联地区
CRM.systemRoleManage.ROLE_RELEVANCE_USER_POST = basePath + '/sys/role/users'; // 角色关联用户
CRM.systemRoleManage.ROLE_DELETE_USER_POST = basePath + '/sys/role/users/delete'; // 角色删除用户
CRM.systemRoleManage.ROLE_RELEVANCE_USER_LOOK_GET = basePath + '/sys/role/users?roleId='; // 角色关联用户查看
CRM.systemRoleManage.ROLE_RELEVANCE_USER_TREE_GET = basePath + '/sys/user/role/depts/tree?roleId='; // 角色关联用户树查看
CRM.systemRoleManage.USER_ORG_TREE_GET = basePath + '/sys/user/org/tree'; // 组织树
CRM.systemRoleManage.USER_BY_DEPT_GET = basePath + '/sys/user/dept/users'; // 部门下的用户
CRM.systemRoleManage.AREA_TREE_GET = basePath + '/sys/area/foreign';// 地区树
CRM.systemRoleManage.AREA_TREE_OF_USER_GET = basePath + '/sys/area/user?userId=';// 用户所关联的地区树

// 保存树的数据
CRM.systemRoleManage.areaTreeData = null;
CRM.systemRoleManage.roleTreeData = null;
CRM.systemRoleManage.orgTreeData = null;
CRM.systemRoleManage.menuTreeData = null;
CRM.systemRoleManage.menuTreeSelectedData = [];
CRM.systemRoleManage.AreaTreeData = [];
CRM.systemRoleManage.AreaTreeSelectedData = [];

CRM.systemRoleManage.editView = $(CRM.el.EDIT_VIEW); // 编辑状态下显示的标签
CRM.systemRoleManage.editHide = $(CRM.el.EDIT_HIDE); // 编辑状态下隐藏的标签
CRM.systemRoleManage.elOff = $(CRM.el.OFF_CONTROL); // 编辑状态下开启的控件
CRM.systemRoleManage.fModCnt = $('#treeModal'); // 第一个模态框
CRM.systemRoleManage.sModL = $('#left'); // 第二个模态框左边
CRM.systemRoleManage.sModR = $('#right'); // 第二个模态框右边
CRM.systemRoleManage.fMod = $('#fModal'); // 第一个模态框的树容器
CRM.systemRoleManage.aside = $('#roleTree'); // 侧边栏
CRM.systemRoleManage.asidePanel = $('#asidePanel'); // 左边面板
CRM.systemRoleManage.tab = $('#myTab'); // tab页
CRM.systemRoleManage.table = $('#table'); // 表格
CRM.systemRoleManage.shiftModal = $('#multiple');// 左右两棵树的模态框

// 按钮
CRM.systemRoleManage.editBelOrg = $('#editBelOrg'); // 所属组织查找按钮
CRM.systemRoleManage.editSperUser = $('#editSperUser'); // 上级角色查找按钮
CRM.systemRoleManage.editUserTree = $('#userTree'); // 已关联用户编辑按钮
CRM.systemRoleManage.editOrgTree = $('#orgTree'); // 已分配组织编辑按钮
CRM.systemRoleManage.userTable = $('#userTable'); // 已关联用户表
CRM.systemRoleManage.add = $('#add'); // 新增按钮
CRM.systemRoleManage.cancel = $('#cancel'); // 取消按钮
CRM.systemRoleManage.save = $('#save'); // 保存按钮
CRM.systemRoleManage.delete = $('#delete');// 删除角色

// 表单控件
CRM.systemRoleManage.roleId = $('#roleId');
CRM.systemRoleManage.orgId = $('#orgId');
CRM.systemRoleManage.orgName = $('#orgName');
CRM.systemRoleManage.parentId = $('#parentId');
CRM.systemRoleManage.parentName = $('#parentName');
CRM.systemRoleManage.parentIds = $('#parentIds');
CRM.systemRoleManage.enable = $('#enable');
CRM.systemRoleManage.name = $('#name');
CRM.systemRoleManage.userId = $('#userId');

(function (page) {

    function nodeToZTreeNode(node) {
        return {
            id: node.cid,
            pId: node.pid,
            name: node.cname
        }
    }

    function nodesToZTreeNodes(nodes) {
        return $.map(nodes, function (item, idx) {
            return nodeToZTreeNode(item);
        });
    }

    $.extend(page, {
        nodeToZTreeNode: nodeToZTreeNode,
        nodesToZTreeNodes: nodesToZTreeNodes
    });
})(CRM.systemRoleManage);

// zTree 数据转换为简单数组数据
CRM.systemRoleManage.treesToSimpleArray = function (trees) {

    var result = [];

    $.each(trees, function (idx, item) {
        result.push(CRM.zTreeObjToSimpleObj(item));
    });

    return result;
};

// 获取树节点的 id 数组
CRM.systemRoleManage.getNodeIds = function (nodes) {

    return $.map(nodes, function (item, idx) {
        return item.id;
    });
};

// 为旧节点添加新节点
CRM.systemRoleManage.addNodes = function (oldNodes, newNodes) {

    oldNodes = CRM.uniqBy($.merge(oldNodes, newNodes), function (item) {
        return item["id"];
    });

    return oldNodes;
};

CRM.systemRoleManage.getDeletedIds = function (nodes) {
    var deletedNodes = [];

    $.each(nodes, function (idx, item) {
        var checkStatus = item.getCheckStatus();
        if (!checkStatus.half) {
            deletedNodes.push(item.id);
        }
    });

    return deletedNodes;
};

// 从节点中删除节点
CRM.systemRoleManage.deleteNodes = function (nodes, deleteNodes) {
    var deleteIds = this.getDeletedIds(deleteNodes);

    return $.grep(nodes, function (item, idx) {
        return -1 === $.inArray(item.id, deleteIds);
    });
};

// 按照 source nodes 排序 target nodes
CRM.systemRoleManage.sortNodes = function (sourceNodes, targetNodes) {
    var targetIds = CRM.systemRoleManage.getNodeIds(targetNodes),
        result = [];

    $.each(sourceNodes, function (idx, source) {
        if ($.inArray(source.id, targetIds) !== -1) {
            result.push(CRM.zTreeObjToSimpleObj(source));
        }
    });

    return result;
};

// 渲染数据
CRM.systemRoleManage.renderData = function (res) {
    var page = CRM.systemRoleManage;
    if (res !== null) {
        page.roleId.val(res.roleId);
        page.orgId.val(res.orgId);
        page.orgName.val(res.orgName);
        page.parentId.val(res.parentId);
        page.parentName.val(res.parentName);
        page.parentIds.val(res.parentIds);
        page.name.val(res.name);
        page.enable.val([res.enable]);
    }
};

// 收集数据
CRM.systemRoleManage.collectData = function () {
    var page = CRM.systemRoleManage,
        obj = {
            orgId: page.orgId.val(),
            parentId: page.parentId.val(),
            enable: page.enable.val(),
            name: page.name.val()
        };
    return obj;
};

// 刷新页面数据
CRM.systemRoleManage.resetPage = function (id) {
    var page = CRM.systemRoleManage;

    if (id === 0) {
        page.renderData({
            roleId: id,
            name: '全部',
            enable: 1
        });
    } else {
        CRM.ajaxCall({
            url: page.ROLE_DETAILS_GET + id,
            type: 'GET',
            callback: page.renderData
        })
    }
};

// 处理用户表格渲染
CRM.systemRoleManage.dealRenderUserTable = function () {
    var page = CRM.systemRoleManage;
    CRM.ajaxCall({
        url: page.ROLE_RELEVANCE_USER_LOOK_GET,
        type: 'GET',
        callback: page.renderUserTable
    })
};

// 侧栏角色树的点击事件
CRM.systemRoleManage.asideTreeOnClick = function (event, modLeftId, treeNode) {
    var page = CRM.systemRoleManage,
        t = $('#tabl').parent('li');

    // 渲染表单
    page.resetPage(treeNode.id);

    // 渲染第用户表格
    page.table.html('');
    $(CRM.el.DEL_BTN).removeClass("hidden");
    CRM.addOnlyClass(t, 'li', page.tab, 'active');
    page.renderUserTable(treeNode.id);
};

CRM.systemRoleManage.fModOrgTreeOnDbClick = function (event, modLeftId, treeNode) {
    var page = CRM.systemRoleManage;
    page.orgName.val(treeNode.name);
    page.orgId.val(treeNode.id);
    page.fModCnt.find('button.close').click(); // 关闭模态
};

CRM.systemRoleManage.fModRoleTreeOnDbClick = function (event, modLeftId, treeNode) {
    var page = CRM.systemRoleManage;
    page.parentName.val(treeNode.name);
    page.parentId.val(treeNode.id);
    page.fModCnt.find('button.close').click(); // 关闭模态
};

// 新增处理
CRM.systemRoleManage.addRole = function () {
    var page = CRM.systemRoleManage;
    page.parentId.val(page.roleId.val());
    page.parentName.val(page.name.val());
    page.roleId.val('');
    page.name.val('');
};

// 渲染用户表格
CRM.systemRoleManage.renderUserTable = function (id) {
    var page = CRM.systemRoleManage;
    CRM.ajaxCall({
        url: page.ROLE_RELEVANCE_USER_LOOK_GET + id,
        type: 'GET',
        callback: page.renderUserTableHandle
    })

};

// 渲染用户表格处理
CRM.systemRoleManage.renderUserTableHandle = function (res) {
    var page = CRM.systemRoleManage,
        data = {
            data: page.returnUserTableData(res)
        },
        html0 = bt('userTable', data);

    // 渲染到页面
    $('#table').html(html0);
};

// 返回处理过后的用户表格数据
CRM.systemRoleManage.returnUserTableData = function (data) {
    var arr = [];
    data = data || [];

    $.each(data, function (i, item) {
        var obj = {
            id: item.id,
            userId: item.userId,
            name: item.userName,
            beginTime: item.beginTime ? item.beginTime.split(/\s/)[0] : '',
            endTime: item.endTime ? item.endTime.split(/\s/)[0] : '',
            areasId: '',
            areasName: '',
            authUserName: item.authUserName,
            authTime: item.authTime
        };
        if (item.user.areas instanceof Array && item.user.areas.length > 0) {
            $.each(item.user.areas, function (j, item) {
                obj.areasId += item.id + ',';
                obj.areasName += item.name + '、';
            });
            obj.areasId = obj.areasId.slice(0, -1);
            obj.areasName = obj.areasName.slice(0, -1);
        }
        arr.push(obj);
    });
    return arr;
};

// 渲染菜单表格
CRM.systemRoleManage.renderMenuTable = function (id) {
    var page = CRM.systemRoleManage;
    CRM.ajaxCall({
        url: page.ROLE_RELEVANCE_MENU_LOOK_GET + id,
        type: 'GET',
        callback: page.renderMenuTableHandle
    })

};

// 渲染菜单节点
CRM.systemRoleManage.renderMenuNode = function (node, level) {
    var html = "<tbody>";
    html += "<tr>";
    html += "<td>" + node.cid + "</td>";
    html += "<td class='text-left'>";

    for (var i = 0; i < level; i++) {
        html += '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
    }

    if (node.nodes && node.nodes.length > 0) {
        html += node.cname;
        // html += "<a href='#'><b class='caret'></b>" + node.cname + "</a>";
    } else {
        html += node.cname;
    }

    html += "</td>";
    html += "<td>" + (node.roleAuthority.authUserName || "") + "</td>";
    html += "<td>" + (node.roleAuthority.authTime || "") + "</td>";
    html += "</tr>";
    html += "</tbody>";

    if (node.nodes && node.nodes.length > 0) {
        level++;
        $.each(node.nodes, function (idx, item) {
            html += CRM.systemRoleManage.renderMenuNode(item, level);
        });
    }

    return html;
};

// 渲染菜单表格处理
CRM.systemRoleManage.renderMenuTableHandle = function (res) {

    var page = CRM.systemRoleManage,
        data = {
            data: res
        },
        html0 = bt('menuTable', data);

    // 渲染到页面
    $('#table').html(html0);
};

// 渲染按钮表格
CRM.systemRoleManage.renderBtnTable = function (id) {
    var page = CRM.systemRoleManage;
    CRM.ajaxCall({
        url: page.MENU_RELEVANCE_LIMITS_LOOK_GET + id,
        type: 'GET',
        callback: page.renderBtnTableHandle
    })

};

// 渲染按钮表格处理
CRM.systemRoleManage.renderBtnTableHandle = function (res) {

    var page = CRM.systemRoleManage,
        data = {
            data: res
        },
        html0 = bt('btnTable', data);

    // 渲染到页面
    $('#table').html(html0);
};

// 渲染菜单功能权限表格
CRM.systemRoleManage.renderPermissionNode = function (node, level) {
    var html = "<tbody class='j-button-tbody'>";
    html += "<tr data-auth-id='" + node.roleAuthority.id + "'>";
    html += "<td>" + node.cid + "</td>";
    html += "<td class='text-left'>";

    for (var i = 0; i < level; i++) {
        html += '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
    }

    if (node.nodes && node.nodes.length > 0) {
        html += node.cname;
        // html += "<a href='#'><b class='caret'></b>" + node.cname + "</a>";
    } else {
        html += node.cname;
    }

    html += "</td>";

    html += "<td>";
    if (node.buttons && node.buttons.length > 0) {
        $.each(node.buttons, function (idx, item) {
            html += '<label class="checkbox-inline">';
            html += '<input type="checkbox" ';
            html += item.permitted ? 'checked' : '';
            html += ' name="' + item.buttonId + '">' + item.buttonName + '</label>';
        });
    }
    html += "</td>";

    html += "<td>" + (node.roleAuthority.authUserName || "") + "</td>";
    html += "<td>" + (node.roleAuthority.authTime || "") + "</td>";
    html += "</tr>";
    html += "</tbody>";

    if (node.nodes && node.nodes.length > 0) {
        level++;
        $.each(node.nodes, function (idx, item) {
            html += CRM.systemRoleManage.renderPermissionNode(item, level);
        });
    }

    return html;
};

// 渲染组织表格
CRM.systemRoleManage.renderOrgTable = function (id) {
    var page = CRM.systemRoleManage;
    CRM.ajaxCall({
        url: page.MENU_RELEVANCE_LIMITS_LOOK_GET + id,
        type: 'GET',
        callback: page.renderOrgTableHandle
    })

};

// 渲染组织表格处理
CRM.systemRoleManage.renderOrgTableHandle = function (res) {

    var page = CRM.systemRoleManage,
        data = {
            data: res
        },
        html0 = bt('orgTable', data);

    // 渲染到页面
    $('#table').html(html0);
};

// 渲染角色树到侧边栏
CRM.systemRoleManage.renderRoleTreeToAside = function (data) {
    var page = CRM.systemRoleManage,
        setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            edit: {
                enable: false
            },
            callback: {
                onClick: page.asideTreeOnClick
            }
        },
        id = page.aside.attr('id'),
        treeObj = null;

    page.roleTreeData = CRM.toArr(data); // 将角色树的数据保存到page对象属性
    $.fn.zTree.init(page.aside, setting, page.roleTreeData);
    treeObj = $.fn.zTree.getZTreeObj(id);
    treeObj.expandAll(true); // 默认展开
};

// 销毁模态中的两棵树
CRM.systemRoleManage.destroyModalTree = function () {
    var page = CRM.systemRoleManage;
    $.fn.zTree.destroy(page.sModL.attr("id"));
    $.fn.zTree.destroy(page.sModR.attr("id"));
};

// 渲染地区树到模态的左边
CRM.systemRoleManage.renderAreaTreeToLeft = function (data) {
    var page = CRM.systemRoleManage,
        setting = {
            check: {
                enable: true
            },
            data: {
                simpleData: {
                    enable: true,
                    idKey: 'pkAreacl',
                    pIdKey: 'pkFatherarea'
                }
            },
            edit: {
                enable: false
            }
        },
        id = page.sModL.attr('id'),
        treeObj;

    page.areaTreeData = data;
    $.fn.zTree.init(page.sModL, setting, page.areaTreeData);
    treeObj = $.fn.zTree.getZTreeObj(id);
    treeObj.expandAll(true);
};

// 渲染组织树到模态的左边
CRM.systemRoleManage.renderOrgTreeToLeft = function (data) {
    var page = CRM.systemRoleManage,
        setting = {
            check: {
                enable: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            edit: {
                enable: false
            }
        },
        id = page.sModL.attr('id'),
        treeObj = null;

    page.orgTreeData = CRM.toArr(data);
    $.fn.zTree.init(page.sModL, setting, page.orgTreeData);
    treeObj = $.fn.zTree.getZTreeObj(id);
    treeObj.expandAll(true);
};

// 渲染组织树到第一模态
CRM.systemRoleManage.renderOrgTreeToFModal = function (data) {
    var page = CRM.systemRoleManage,
        setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            edit: {
                enable: false
            },
            callback: {
                onClick: page.fModOrgTreeOnDbClick
            }
        },
        id = page.fMod.attr('id'),
        treeObj = null;
    page.orgTreeData = CRM.toArr(data);
    $.fn.zTree.init(page.fMod, setting, page.orgTreeData);
    treeObj = $.fn.zTree.getZTreeObj(id);
    treeObj.expandAll(true);
};

// 渲染角色树到第一模态框
CRM.systemRoleManage.renderRoleTreeToFModal = function (data) {
    var page = CRM.systemRoleManage,
        setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            edit: {
                enable: false
            },
            callback: {
                onClick: page.fModRoleTreeOnDbClick
            }
        },
        id = page.fMod.attr('id'),
        treeObj = null;

    page.roleTreeData = CRM.toArr(data);
    $.fn.zTree.init(page.fMod, setting, page.roleTreeData);
    treeObj = $.fn.zTree.getZTreeObj(id);
    treeObj.expandAll(true);
};

// 渲染用户数到模态框左边
CRM.systemRoleManage.renderUserTreeToModeL = function (data) {
    var page = CRM.systemRoleManage,
        setting = {
            async: {
                enable: true,
                url: page.USER_BY_DEPT_GET,
                type: 'GET',
                autoParam: ["cid=pid"]
            },
            data: {
                simpleData: {
                    enable: false
                },
                key: {
                    children: 'nodes',
                    name: 'cname',
                    url: 'xUrl'
                }
            },
            check: {
                enable: true
            },
            edit: {
                enable: false
            },
            callback: {}
        },
        id = page.sModL.attr('id'),
        treeObj = null;

    // page.menuTreeData = data;
    $.fn.zTree.destroy(id);
    $.fn.zTree.init(page.sModL, setting, data);
    treeObj = $.fn.zTree.getZTreeObj(id);
};

// 渲染用户数到模态框右边
CRM.systemRoleManage.renderUserTreeToModeR = function (data) {
    var page = CRM.systemRoleManage,
        setting = {
            data: {
                simpleData: {
                    enable: false
                },
                key: {
                    children: 'nodes',
                    name: 'cname',
                    url: 'xUrl'
                }
            },
            check: {
                enable: true
            },
            callback: {}
        },
        id = page.sModR.attr('id'),
        treeObj = null;

    // page.menuTreeData = data;
    $.fn.zTree.destroy(id);
    $.fn.zTree.init(page.sModR, setting, data);
    treeObj = $.fn.zTree.getZTreeObj(id);
};

// 渲染菜单树到模态框左边
CRM.systemRoleManage.renderMenuTreeToFModal = function (data) {
    var page = CRM.systemRoleManage,
        setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            check: {
                enable: true
            },
            edit: {
                enable: false
            },
            callback: {}
        },
        id = page.sModL.attr('id'),
        treeObj = null;

    page.menuTreeData = CRM.toArr(data);
    $.fn.zTree.destroy(id);
    $.fn.zTree.init(page.sModL, setting, page.menuTreeData);
    treeObj = $.fn.zTree.getZTreeObj(id);
    treeObj.expandAll(true);
};

// 渲染菜单树到模态框右边边
CRM.systemRoleManage.renderMenuTreeToSModalR = function (data) {
    var page = CRM.systemRoleManage,
        setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            check: {
                enable: true
            },
            edit: {
                enable: false
            },
            callback: {}
        },
        id = page.sModR.attr('id'),
        treeObj = null;

    page.menuTreeSelectedData = data;
    $.fn.zTree.destroy(id);
    $.fn.zTree.init(page.sModR, setting, page.menuTreeSelectedData);
    treeObj = $.fn.zTree.getZTreeObj(id);
    treeObj.expandAll(true);
};

// 渲染地区树到模态框左边
CRM.systemRoleManage.renderAreaTreeToSModalL = function (data) {
    var page = CRM.systemRoleManage,
        setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            check: {
                enable: true
            }
        },
        id = page.sModL.attr('id'),
        treeObj = null;

    page.AreaTreeData = data;
    $.fn.zTree.destroy(id);
    $.fn.zTree.init(page.sModL, setting, page.AreaTreeData);
    treeObj = $.fn.zTree.getZTreeObj(id);
    treeObj.expandAll(true);
};

// 渲染菜单树到模态框右边边
CRM.systemRoleManage.renderAreaTreeToSModalR = function (data) {
    var page = CRM.systemRoleManage,
        setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            check: {
                enable: true
            }
        },
        id = page.sModR.attr('id'),
        treeObj = null;

    page.AreaTreeSelectedData = data;
    $.fn.zTree.destroy(id);
    $.fn.zTree.init(page.sModR, setting, page.AreaTreeSelectedData);
    treeObj = $.fn.zTree.getZTreeObj(id);
    treeObj.expandAll(true);
};

//初始化页面
CRM.systemRoleManage.init = function () {
    var page = CRM.systemRoleManage;

    // 禁用和隐藏的元素
    CRM.showOrHide(page.editView, page.editHide, false);
    CRM.onOrOff(page.elOff, false);

    // 新建Panel对象实例，绑定编辑、保存、取消事件
    var roleManage = new CRM.module.Panel('#roleManage');
    roleManage.startEdit();
    roleManage.startSave();
    roleManage.startCancel();

    // 渲染侧边栏的角色树
    CRM.ajaxCall({
        url: CRM.url.ROLE_TREE_GET,
        type: 'GET',
        callback: page.renderRoleTreeToAside
    });

};

$(function () {
    var page = CRM.systemRoleManage;

    // 初始化页面
    page.init();

    // 新增
    page.add.on('click.add', function () {

        // 将上级角色的id和name替换为当前节点的，并清空当前节点的属性
        page.addRole();

        //清空table
        page.table.html('');

        // 隐藏侧栏和tab页
        page.asidePanel.fadeOut();
        page.tab.fadeOut();
    });

    // 删除角色
    page.delete.on('click.delete', function (e) {

        var roleId = page.roleId.val();
        if (roleId == null || roleId == "") {
            alert("请选择需要删除的角色！");
            return false;
        } else if (roleId == 0) {
            alert("根节点不能删除！");
            return false;
        } else if (!confirm("确认删除该角色及其子节点？")) {
            return false;
        }
        CRM.ajaxCall({
            url: page.ROLE_DELETE_POST + roleId + '/remove',
            type: 'POST',
            callback: function (data) {
                alert("删除成功");
                window.location.reload();
            }
        });
    });

    //保存
    page.save.on('click.save', function () {

        // 提交数据，以返回的id刷新表单
        CRM.ajaxCall({
            url: page.ROLE_ADD_POST,
            data: page.collectData(),
            type: 'POST',
            callback: page.resetPage
        });

        // 刷新侧边栏的角色树
        CRM.ajaxCall({
            url: CRM.url.ROLE_TREE_GET,
            type: 'GET',
            callback: page.renderRoleTreeToAside
        });

        // 显示侧栏和tab页
        page.asidePanel.fadeIn();
        page.tab.fadeIn();

        // 激活第一页tab页
        page.tab.find('li').removeClass('active');
        $('#tabl').parent('li').addClass('active');

    });

    // 取消
    page.cancel.on('click.cancel', function () {

        // 取得父id，并刷新表单和用户表格
        var id = page.parentId.val();
        page.resetPage(id);
        page.renderUserTable(id);

        // 显示侧栏和tab页
        page.asidePanel.fadeIn();
        page.tab.fadeIn();

        // 激活第一页tab页
        page.tab.find('li').removeClass('active');
        $('#tabl').parent('li').addClass('active');

    });

    // tab页点击
    page.tab.on('click.tab', 'a', function (e) {
        var el = $(e.target),
            id = el.attr('id'),
            par = el.parent('li'),
            val = page.roleId.val();

        // 清空table
        page.table.html('');

        // 根据点击的tab页不同渲染数据table
        if (val !== '') {
            if (id === 'tabl') {

                // 渲染用户表格
                page.renderUserTable(val);
            } else if (id === 'tab2') {

                // 渲染菜单表格
                page.renderMenuTable(val);
            } else if (id === 'tab3') {

                // 渲染按钮表格
                page.renderBtnTable(val)
            } else if (id === 'tab4') {

            }

            // 给当前tab页添加激活样式
            CRM.addOnlyClass(par, 'li', page.tab, 'active');
        } else {

            alert('请在侧栏选择角色');
        }

        return false;

    });

    // 编辑分配组织
    page.editOrgTree.on('click.org', function (e) {

        $('#multiple').find('[data-btn="finish"]').attr('id', 'saveOrg');
        page.sModL.html('');
        CRM.ajaxCall({
            url: CRM.url.ORG_TREE_GET,
            type: 'GET',
            callback: page.renderOrgTreeToLeft
        });
    });

    // 编辑所属组织
    page.editBelOrg.on('click.area', function (e) {

        page.fMod.html('');
        CRM.ajaxCall({
            url: CRM.url.ORG_TREE_GET,
            type: 'GET',
            callback: page.renderOrgTreeToFModal
        });
    });

    // 编辑上级角色
    page.editSperUser.on('click.area', function (e) {

        page.fMod.html('');
        CRM.ajaxCall({
            url: CRM.url.ROLE_TREE_GET,
            type: 'GET',
            callback: page.renderRoleTreeToFModal
        });
    });

    // 编辑关联用户
    page.table.on('click.user.edit', '#userTree', function (e) {

        $('#multiple').find('[data-btn="finish"]').attr('id', 'saveUser');
        $('#multiple').find('.j-modal-body').attr('id', 'userModal');
        $('#multiple').find('.j-candi').html("待选用户");
        $('#multiple').find('.j-selected').html("已选用户");

        CRM.systemRoleManage.destroyModalTree();
        CRM.ajaxCall({
            url: CRM.systemRoleManage.USER_ORG_TREE_GET,
            type: 'GET',
            callback: page.renderUserTreeToModeL
        });

        var roleId = CRM.systemRoleManage.roleId.val();
        refreshUserTree(roleId);
    });

    function refreshUserTree(roleId) {
        CRM.ajaxCall({
            url: CRM.systemRoleManage.ROLE_RELEVANCE_USER_TREE_GET + roleId,
            type: 'GET',
            callback: page.renderUserTreeToModeR
        });
    }

    function addUsersForRole(userIds, deptIds) {
        var page = CRM.systemRoleManage,
            roleId = page.roleId.val();

        CRM.ajaxCall({
            url: page.ROLE_RELEVANCE_USER_POST,
            type: 'POST',
            data: {
                roleId: roleId,
                userIds: userIds.join(","),
                deptIds: deptIds.join(",")
            },
            callback: function (data) {
                refreshUserTree(roleId);
            }
        });
    }

    // 角色取消关联用户
    function deleteUsersForRole(userIds) {
        var page = CRM.systemRoleManage,
            roleId = page.roleId.val();

        CRM.ajaxCall({
            url: page.ROLE_DELETE_USER_POST,
            type: 'POST',
            data: {
                roleId: roleId,
                userIds: userIds.join(",")
            },
            callback: function (data) {
                refreshUserTree(roleId);
            }
        });
    }

    // 用户添加节点
    $('#multiple').on('click.add', '#userModal .j-add-node', function (e) {

        var page = CRM.systemRoleManage,
            leftTree = $.fn.zTree.getZTreeObj(page.sModL.attr('id')),
            checkedNodes = leftTree.getCheckedNodes();

        var userIds = [],
            deptIds = [];

        $.each(checkedNodes, function (idx, item) {
            console.log(item);
            if (item.type === 3) {
                userIds.push(item.cid);
            } else if (item.type === 2 && !item.zAsync) {
                deptIds.push(item.cid);
            }
        });

        addUsersForRole(userIds, deptIds);
    });

    // 用户删除节点
    $('#multiple').on('click.delete', '#userModal .j-delete-node', function (e) {

        var page = CRM.systemRoleManage,
            rightTree = $.fn.zTree.getZTreeObj(page.sModR.attr('id')),
            checkedNodes = rightTree.getCheckedNodes();

        var userIds = [];
        $.each(checkedNodes, function (idx, item) {
            if (item.type === 3) {
                userIds.push(item.cid);
            }
        });

        deleteUsersForRole(userIds);
    });

    $('#multiple').on('click.user.save', '#saveUser', function (e) {
        page.renderUserTable(page.roleId.val());
    });

    // 编辑菜单权限
    page.table.on('click.menu', '#menuTree', function (e) {

        $('#multiple').find('[data-btn="finish"]').attr('id', 'saveMenu');
        $('#multiple').find('.j-modal-body').attr('id', 'menuModal');
        $('#multiple').find('.j-candi').html("待选菜单");
        $('#multiple').find('.j-selected').html("已选菜单");

        CRM.ajaxCall({
            url: CRM.url.MENU_TREE_GET,
            type: 'GET',
            callback: page.renderMenuTreeToFModal
        });

        var roleId = CRM.systemRoleManage.roleId.val();
        CRM.ajaxCall({
            url: CRM.systemRoleManage.ROLE_RELEVANCE_MENU_LOOK_GET + roleId,
            type: 'GET',
            callback: function (result) {
                page.renderMenuTreeToSModalR(CRM.toArr(result));
            }
        });
    });

    // 菜单树添加节点
    $('#multiple').on('click.add', '#menuModal .j-add-node', function (e) {

        var page = CRM.systemRoleManage,
            leftTree = $.fn.zTree.getZTreeObj(page.sModL.attr('id')),
            checkedNodes = leftTree.getCheckedNodes(),
            allNodes = leftTree.transformToArray(leftTree.getNodes()),
            newNodes = page.addNodes(page.menuTreeSelectedData, checkedNodes),
            nodes = page.sortNodes(allNodes, newNodes);

        page.renderMenuTreeToSModalR(nodes);
    });

    // 菜单树删除节点
    $('#multiple').on('click.delete', '#menuModal .j-delete-node', function (e) {

        var page = CRM.systemRoleManage,
            rightTree = $.fn.zTree.getZTreeObj(page.sModR.attr('id')),
            checkedNodes = rightTree.getCheckedNodes(),
            nodes = page.deleteNodes(page.menuTreeSelectedData, checkedNodes);

        page.renderMenuTreeToSModalR(nodes);
    });

    // 角色关联菜单
    $('#multiple').on('click.menu.save', '#saveMenu', function (e) {

        var page = CRM.systemRoleManage,
            rightTree = $.fn.zTree.getZTreeObj(page.sModR.attr('id')),
            menuNodes = rightTree.transformToArray(rightTree.getNodes()),
            roleId = page.roleId.val();

        var menus = $.map(menuNodes, function (item, idx) {
            return {
                resourceId: item.id
            };
        });

        CRM.ajaxCall({
            url: page.ROLE_RELEVANCE_MENU_POST,
            type: 'POST',
            data: {
                roleId: roleId,
                auths: JSON.stringify(menus)
            },
            callback: function (data) {
                CRM.systemRoleManage.renderMenuTable(roleId);
            }
        });
    });

    // 用户关联地区功能

    function refreshAreeTreeOfUser(userId) {
        CRM.ajaxCall({
            url: CRM.systemRoleManage.AREA_TREE_OF_USER_GET + userId,
            type: 'GET',
            callback: function (result) {
                result = result || [];
                page.renderAreaTreeToSModalR(page.nodesToZTreeNodes(result));
            }
        });
    }

    function refreshAreaTree() {
        if (page.AreaTreeData && page.AreaTreeData.length > 0) {
            page.renderAreaTreeToSModalL(page.AreaTreeData);
        } else {
            CRM.ajaxCall({
                url: page.AREA_TREE_GET,
                type: 'GET',
                callback: function (data) {
                    if (data !== null && $.isArray(data)) {
                        page.renderAreaTreeToSModalL(page.nodesToZTreeNodes(data));
                    }
                }
            });
        }
    }

    // 打开关联地区模态
    page.table.on('click.area', '.j-area-tree', function (e) {
        var $this = $(this),
            $tr = $this.closest("tr"),
            userId = $tr.data("userId");

        $('#multiple').find('[data-btn="finish"]').attr('id', 'saveArea');
        $('#multiple').find('.j-modal-body').attr('id', 'areaModal');
        $('#multiple').find('.j-candi').html("待选地区");
        $('#multiple').find('.j-selected').html("已选地区");
        page.userId.val(userId);

        page.destroyModalTree();
        refreshAreaTree();
        refreshAreeTreeOfUser(userId);
    });

    // 地区树添加节点
    $('#multiple').on('click.add', '#areaModal .j-add-node', function (e) {

        var leftTree = $.fn.zTree.getZTreeObj(page.sModL.attr('id')),
            checkedNodes = leftTree.getCheckedNodes(),
            allNodes = leftTree.transformToArray(leftTree.getNodes()),
            newNodes = page.addNodes(page.AreaTreeSelectedData, checkedNodes),
            nodes = page.sortNodes(allNodes, newNodes);

        page.renderAreaTreeToSModalR(nodes);
    });

    // 地区树删除节点
    $('#multiple').on('click.delete', '#areaModal .j-delete-node', function (e) {

        var rightTree = $.fn.zTree.getZTreeObj(page.sModR.attr('id')),
            checkedNodes = rightTree.getCheckedNodes(),
            nodes = page.deleteNodes(page.AreaTreeSelectedData, checkedNodes);

        page.renderAreaTreeToSModalR(nodes);
    });

    // 用户关联地区
    $('#multiple').on('click.menu.save', '#saveArea', function (e) {

        var rightTree = $.fn.zTree.getZTreeObj(page.sModR.attr('id')),
            menuNodes = rightTree.transformToArray(rightTree.getNodes()),
            userId = page.userId.val(),
            areaIds = [], areaNames = [];

        $.each(menuNodes, function (idx, item) {
            if (!item.isParent) {
                areaIds.push(item.id);
                areaNames.push(item.name);
            }
        });

        CRM.ajaxCall({
            url: page.USER_RELEVANCE_AREA_POST,
            type: 'POST',
            data: {
                userId: userId,
                areaIds: areaIds.join(',')
            },
            callback: function (data) {
                if (areaIds.length === parseInt(data)) {
                    $('tr[data-user-id=' + userId + ']').find('.j-area-label').html(areaNames.join('、'));
                }
            }
        });
    });

    // 保存功能权限
    page.table.on('click.button.save', '#saveButton', function (e) {
        var auths = [];

        page.table.find('.j-button-tbody tr').each(function (idx, item) {
            var auth = {},
                $tr = $(item),
                authId = $tr.data("authId"),
                buttonIds = [];

            $tr.find("input:checked").each(function (idx, item) {
                var $button = $(item),
                    buttonId = $button.attr("name");

                buttonIds.push(buttonId);
            });

            auths.push({
                id: authId,
                permissionIds: buttonIds.join(",")
            });
        });

        $.ajax({
            url: page.MENU_RELEVANCE_LIMITS_POST,
            type: 'POST',
            data: {
                permissions: JSON.stringify(auths)
            },
            success: function (result) {
                if (result.code === 1) {
                    alert("保存成功！");
                } else {
                    alert(result.message);
                }
            }
        });
    });
});
