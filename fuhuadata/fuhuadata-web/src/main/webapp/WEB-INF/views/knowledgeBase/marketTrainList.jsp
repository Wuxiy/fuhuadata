<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2017/1/12
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>营销培训</title>
    <link rel="stylesheet" type="text/css" href="../../css/bootstrap.css" />
</head>

<body class="bg-page">
<div class="container-fluid">
    <!--头部开始-->
    <nav class="navbar navbar-cards navbar-fixed-top">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">
                福华客户关系管理系统
            </a>
        </div>
        <div class="navbar-btn btn-group btn-group-xs pull-right">
            <button class="btn btn-primary"><span class="glyphicon glyphicon-envelope"></span></button>
            <button class="btn btn-primary">业务员</button>
            <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></button>
            <ul class="dropdown-menu pull-right">
                <li><a href="">修改密码</a></li>
                <li><a href="">退出</a></li>
            </ul>
        </div>
        <ul id="nav-affix" class="nav nav-cards">
            <li class="shadow-in" title="客户信息">
                <div id="collapseOne" class="list-group collapse">
                    <a class="list-group-item" href="#">客户列表</a>
                    <a class="list-group-item" href="#">潜在客户新增</a>
                    <a class="list-group-item" href="#">潜在客户信息查看</a>
                    <a class="list-group-item" href="#">客户信息查看</a>
                </div>
                <a data-toggle="collapse" href="#collapseOne" data-parent="#nav-affix">
                    <span class="glyphicon glyphicon-user"></span>
                    客户信息
                    <b class="caret"></b>
                </a>
            </li>
            <li class="shadow-in" title="供应商信息">
                <div id="collapseTwo" class="list-group collapse">
                    <a class="list-group-item" href="#">加工厂</a>
                    <a class="list-group-item" href="#">货代</a>
                </div>
                <a data-toggle="collapse" href="#collapseTwo" data-parent="#nav-affix">
                    <span class="glyphicon glyphicon-briefcase"></span>
                    供应商信息
                    <b class="caret"></b>
                </a>
            </li>
            <li class="shadow-in" title="销售统计">
                <div id="collapseThree" class="list-group collapse">
                    <a class="list-group-item" href="#">商机</a>
                    <a class="list-group-item" href="#">销售动态</a>
                    <a class="list-group-item" href="#">费用与利润</a>
                    <a class="list-group-item" href="#">客户维护</a>
                </div>
                <a data-toggle="collapse" href="#collapseThree" data-parent="#nav-affix">
                    <span class="glyphicon glyphicon-stats"></span>
                    销售统计
                    <b class="caret"></b>
                </a>
            </li>
            <li class="shadow-in" title="行业数据">
                <div id="collapseFour" class="list-group collapse">
                    <a class="list-group-item" href="#">市场数据</a>
                </div>
                <a data-toggle="collapse" href="#collapseFour" data-parent="#nav-affix">
                    <span class="glyphicon glyphicon-list-alt"></span>
                    行业数据
                    <b class="caret"></b>
                </a>
            </li>
            <li class="active shadow-in" title="知识库">
                <div id="collapseFive" class="list-group collapse">
                    <a class="list-group-item" href="faq_list.html">产品常见问题</a>
                    <a class="list-group-item" href="train_list.html">营销培训</a>
                    <a class="list-group-item" href="product_list.html">客户产品包装要求</a>
                    <a class="list-group-item" href="product_list.html">标准产品档案</a>
                    <a class="list-group-item" href="pack-price_list.html">包材成本参考</a>
                    <a class="list-group-item" href="finished-cost_list.html">加工成本参考</a>
                    <a class="list-group-item" href="encyclopedia_list.html">百科</a>
                    <a class="list-group-item" href="expo_list.html">展会动态</a>
                    <a class="list-group-item" href="">其他</a>
                </div>
                <a data-toggle="collapse" href="#collapseFive" data-parent="#nav-affix">
                    <span class="glyphicon glyphicon-book"></span>
                    知识库
                    <b class="caret"></b>
                </a>
            </li>
            <li class="shadow-in" title="决策支持" >
                <div id="collapseSix" class="list-group collapse">
                    <a class="list-group-item" href="#">销售数据</a>
                    <a class="list-group-item" href="#">成本费用</a>
                    <a class="list-group-item" href="#">数据库</a>
                </div>
                <a data-toggle="collapse" href="#collapseSix" data-parent="#nav-affix">
                    <span class="glyphicon glyphicon-pencil"></span>
                    决策支持
                    <b class="caret"></b>
                </a>
            </li>
            <li class="shadow-in" title="系统管理">
                <div id="collapseSeven" class="list-group collapse">
                    <a class="list-group-item" href="#">设置</a>
                </div>
                <a data-toggle="collapse" href="#collapseSeven" data-parent="#nav-affix">
                    <span class="glyphicon glyphicon-cog"></span>
                    系统管理
                    <b class="caret"></b>
                </a>
            </li>
        </ul>
    </nav>
    <!--头部结束-->
    <div class="clearfix content shadow-out">
        <!--面包屑导航开始-->
        <div class="breadcrumb-more">
            <span class="breadcrumb-unit pull-left">当前位置</span>
            <ul class="breadcrumb shadow-out">
                <li><a href="">知识库</a></li>
                <li class="active">百科</li>
            </ul>
        </div>
        <!--面包屑导结束-->
        <div class="dashboard-wrapper">
            <!--表格开始-->
            <div class="panel panel-default">
                <div class="panel-heading">
                    <button class="btn btn-xs btn-primary pull-right panel-heading-btn" href="" data-toggle="modal" data-target="#addTrain" data-keyboard="true">
                        <span class="glyphicon glyphicon-plus"></span>
                        新增
                    </button>
                    <h3 class="panel-title">
                        营销培训
                    </h3>
                </div>
                <div class="panel-body clearfix">
                    <!--搜索框开始-->
                    <div class="form-horizontal">
                        <div class="form-group">
                            <div class="col-xs-1 pull-right">
                                <button type="button" class="btn btn-block btn-primary btn-xs">
                                    搜索
                                </button>
                            </div>
                            <div class="col-xs-2 pull-right">
                                <input class="form-control" type="search" value="" placeholder="请输入标题"/>
                            </div>
                            <label class="col-xs-1 control-label pull-right">标题</label>
                            <div class="col-xs-2 pull-right">
                                <div class="input-group">
                                    <input class="form-control" type="search" value="" placeholder="请输入品类"/>
                                    <span class="input-group-btn">
												<button data-toggle="modal" data-target="#search" class="btn btn-xs btn-default" type="button">
													<span class="glyphicon glyphicon-search"></span>
												</button>
											</span>
                                </div>
                            </div>
                            <label class="col-xs-1 control-label pull-right">品类</label>
                        </div>
                    </div>
                    <!--搜索框结束-->
                    <!--表格开始-->
                    <table class="table table-condensed table-bordered table-striped text-center">
                        <thead>
                        <tr>
                            <th class="col-xs-1 text-center">编号</th>
                            <th class="col-xs-4 text-center">标题</th>
                            <th class="col-xs-2 text-center">产品种类</th>
                            <th class="col-xs-2 text-center">上传人</th>
                            <th class="col-xs-2 text-center">上传时间</th>
                            <th class="col-xs-1 text-center">可否下载</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1</td>
                            <td>草甘膦知识培训</td>
                            <td>草甘膦</td>
                            <td>刘凯洋</td>
                            <td>2016-10-10 18:00</td>
                            <td><a href="">下载</a></td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>草甘膦知识培训</td>
                            <td>草甘膦</td>
                            <td>刘凯洋</td>
                            <td>2016-10-10 18:00</td>
                            <td><a href="">下载</a></td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>草甘膦知识培训</td>
                            <td>草甘膦</td>
                            <td>刘凯洋</td>
                            <td>2016-10-10 18:00</td>
                            <td><a href="">下载</a></td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>草甘膦知识培训</td>
                            <td>草甘膦</td>
                            <td>刘凯洋</td>
                            <td>2016-10-10 18:00</td>
                            <td><a href="">下载</a></td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td>草甘膦知识培训</td>
                            <td>草甘膦</td>
                            <td>刘凯洋</td>
                            <td>2016-10-10 18:00</td>
                            <td><a href="">下载</a></td>
                        </tr>
                        <tr>
                            <td>6</td>
                            <td>草甘膦知识培训</td>
                            <td>草甘膦</td>
                            <td>刘凯洋</td>
                            <td>2016-10-10 18:00</td>
                            <td><a href="">下载</a></td>
                        </tr>
                        <tr>
                            <td>7</td>
                            <td>草甘膦知识培训</td>
                            <td>草甘膦</td>
                            <td>刘凯洋</td>
                            <td>2016-10-10 18:00</td>
                            <td><a href="">下载</a></td>
                        </tr>
                        <tr>
                            <td>8</td>
                            <td>草甘膦知识培训</td>
                            <td>草甘膦</td>
                            <td>刘凯洋</td>
                            <td>2016-10-10 18:00</td>
                            <td><a href="">下载</a></td>
                        </tr>
                        <tr>
                            <td>9</td>
                            <td>草甘膦知识培训</td>
                            <td>草甘膦</td>
                            <td>刘凯洋</td>
                            <td>2016-10-10 18:00</td>
                            <td><a href="">下载</a></td>
                        </tr>
                        <tr>
                            <td>10</td>
                            <td>草甘膦知识培训</td>
                            <td>草甘膦</td>
                            <td>刘凯洋</td>
                            <td>2016-10-10 18:00</td>
                            <td><a href="">下载</a></td>
                        </tr>
                        <tr>
                            <td>11</td>
                            <td>草甘膦知识培训</td>
                            <td>草甘膦</td>
                            <td>刘凯洋</td>
                            <td>2016-10-10 18:00</td>
                            <td><a href="">下载</a></td>
                        </tr>
                        <tr>
                            <td>12</td>
                            <td>草甘膦知识培训</td>
                            <td>草甘膦</td>
                            <td>刘凯洋</td>
                            <td>2016-10-10 18:00</td>
                            <td><a href="">下载</a></td>
                        </tr>
                        <tr>
                            <td>13</td>
                            <td>草甘膦知识培训</td>
                            <td>草甘膦</td>
                            <td>刘凯洋</td>
                            <td>2016-10-10 18:00</td>
                            <td><a href="">下载</a></td>
                        </tr>
                        <tr>
                            <td>14</td>
                            <td>草甘膦知识培训</td>
                            <td>草甘膦</td>
                            <td>刘凯洋</td>
                            <td>2016-10-10 18:00</td>
                            <td><a href="">下载</a></td>
                        </tr>
                        <tr>
                            <td>15</td>
                            <td>草甘膦知识培训</td>
                            <td>草甘膦</td>
                            <td>刘凯洋</td>
                            <td>2016-10-10 18:00</td>
                            <td><a href="">下载</a></td>
                        </tr>
                        </tbody>
                    </table>
                    <!--表格结束-->
                    <!--分页导航开始-->
                    <div class="form-group pull-left table-pagination">
                        共<span>123</span>条记录，<span>130</span>页，跳转到第&nbsp;<input class="form-control pagination-input" type="number"/>&nbsp;页
                        <button class="btn btn-xs btn-primary">确定</button>
                    </div>
                    <ul class="pagination pull-right table-pagination">
                        <li class="disabled"><a href="#">上一页</a></li>
                        <li class="active"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">6</a></li>
                        <li><a href="#">7</a></li>
                        <li><a href="">&hellip;</a></li>
                        <li><a href="#">下一页</a></li>
                    </ul>
                    <!--分页导航结束-->
                </div>
            </div>
            <!--表格结束-->
        </div>
    </div>
</div>
<div class="footer">
    <small>
        &copy; baswaAdmin 2014
    </small>
</div>
<!--添加模态框开始 -->
<div class="modal fade" id="addTrain" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static" data-keyboard="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
            </div>
            <div class="modal-body ">
                <form class="form-horizontal" action="">
                    <div class="form-group ">
                        <label class="col-xs-2 control-label">标题</label>
                        <div class="col-xs-6">
                            <input class="form-control" type="text"/>
                        </div>
                    </div>
                    <div class="form-group ">
                        <label class="col-xs-2 control-label">产品名称</label>
                        <div class="col-xs-4">
                            <select class="form-control">
                                <option value="" selected>草甘膦</option>
                                <option value="">草胺膦</option>
                                <option value="">化工品</option>
                                <option value="">贸易品</option>
                                <option value="">其他</option>
                            </select>
                        </div>
                        <div class="col-xs-4">
                            <select class="form-control">
                                <option value="" selected>全部</option>
                                <option value="">草甘膦</option>
                                <option value="">草甘膦原药</option>
                                <option value="">草甘膦水剂</option>
                                <option value="">草甘膦颗粒剂</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group ">
                        <label class="col-xs-2 control-label" for="inputfile">附件</label>
                        <div class="col-xs-6">
                            <input class="form-control" id="inputfile" type="file"/>
                        </div>
                        <div class="col-xs-2">
                            <button type="submit" class="btn btn-xs btn-primary btn-block">上传</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <div class="row">
                    <div class="col-xs-3 col-xs-offset-3">
                        <button type="button" class="btn btn-primary btn-block">
                            完成
                        </button>
                    </div>
                    <div class="col-xs-3">
                        <button type="button" class="btn btn-default btn-block" data-dismiss="modal">取消
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--添加模态框结束 -->
<script src="../../js/jquery-2.1.0.js" type="text/javascript" charset="utf-8"></script>
<script src="../../js/dropdown.js" type="text/javascript" charset="utf-8"></script>
<script src="../../js/modal.js" type="text/javascript" charset="utf-8"></script>
<script src="../../js/collapse.js" type="text/javascript" charset="utf-8"></script>
<script src="../../js/transition.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
