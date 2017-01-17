<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2017/1/12
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>展会动态</title>
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
                <li class="active">展会动态</li>
            </ul>
        </div>
        <!--面包屑导结束-->
        <div class="dashboard-wrapper">
            <!--表格开始-->
            <div class="panel panel-default">
                <div class="panel-heading">
                    <a class="btn btn-xs btn-primary pull-right panel-heading-btn" href="expo_add.html" data-toggle="modal">
                        <span class="glyphicon glyphicon-plus"></span>
                        新增
                    </a>
                    <h3 class="panel-title">
                        展会动态
                    </h3>
                </div>
                <div class="panel-body clearfix">
                    <!--搜索框开始-->
                    <div class="form-horizontal">
                        <div class="form-group ">
                            <div class="col-xs-2 pull-right">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="请输入关键词查找">
                                    <div class="input-group-btn">
                                        <button type="button" class="btn btn-primary btn-xs">
                                            <span class="glyphicon glyphicon-search"></span>
                                            搜索
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--搜索框结束-->
                    <!--表格开始-->
                    <table class="table table-condensed table-bordered table-striped text-center">
                        <thead>
                        <tr>
                            <th class="text-center ">编号</th>
                            <th class="col-xs-2 text-center">展会名称</th>
                            <th class="col-xs-1 text-center">主办方</th>
                            <th class="col-xs-2 text-center">承办单位</th>
                            <th class="text-center">国家</th>
                            <th class="text-center">城市</th>
                            <th class="col-xs-1 text-center">开始时间</th>
                            <th class="col-xs-1 text-center">结束日期</th>
                            <th class="col-xs-1 text-center">展会地址</th>
                            <th class="col-xs-2 text-center">展会介绍</th>
                            <th class="col-xs-1 text-center">展会介绍连接</th>
                            <th class="text-center">创建人</th>
                            <th class="col-xs-1 text-center">创建时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1</td>
                            <td>2016全国植保会</td>
                            <td>全国农业技术推广服务中心</td>
                            <td>江苏省植物保护站厦门市凤凰创意会展服务有限公司</td>
                            <td>中国</td>
                            <td>南京</td>
                            <td>2016年11月25日</td>
                            <td>2016年11月27日</td>
                            <td>南京国际博览中心</td>
                            <td>吸引来自全国30参展范围涉及农药原药、农药、肥料、植保机械及包装设备等，涵盖整个农化产业上、中、下游产品，是国内参展产品最齐全的大会。</td>
                            <td><a href="http://www.1988.tv/zhanhui/2016qgzbh/about.html">点击进入</a></td>
                            <td>刘凯洋</td>
                            <td>2016-10-12</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>2016全国植保会</td>
                            <td>全国农业技术推广服务中心</td>
                            <td>江苏省植物保护站厦门市凤凰创意会展服务有限公司</td>
                            <td>中国</td>
                            <td>南京</td>
                            <td>2016年11月25日</td>
                            <td>2016年11月27日</td>
                            <td>南京国际博览中心</td>
                            <td>吸引来自全国30参展范围涉及农药原药、农药、肥料、植保机械及包装设备等，涵盖整个农化产业上、中、下游产品，是国内参展产品最齐全的大会。</td>
                            <td><a href="http://www.1988.tv/zhanhui/2016qgzbh/about.html">点击进入</a></td>
                            <td>刘凯洋</td>
                            <td>2016-10-12</td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>2016全国植保会</td>
                            <td>全国农业技术推广服务中心</td>
                            <td>江苏省植物保护站厦门市凤凰创意会展服务有限公司</td>
                            <td>中国</td>
                            <td>南京</td>
                            <td>2016年11月25日</td>
                            <td>2016年11月27日</td>
                            <td>南京国际博览中心</td>
                            <td>吸引来自全国30参展范围涉及农药原药、农药、肥料、植保机械及包装设备等，涵盖整个农化产业上、中、下游产品，是国内参展产品最齐全的大会。</td>
                            <td><a href="http://www.1988.tv/zhanhui/2016qgzbh/about.html">点击进入</a></td>
                            <td>刘凯洋</td>
                            <td>2016-10-12</td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>2016全国植保会</td>
                            <td>全国农业技术推广服务中心</td>
                            <td>江苏省植物保护站厦门市凤凰创意会展服务有限公司</td>
                            <td>中国</td>
                            <td>南京</td>
                            <td>2016年11月25日</td>
                            <td>2016年11月27日</td>
                            <td>南京国际博览中心</td>
                            <td></td>
                            <td><a href="http://www.1988.tv/zhanhui/2016qgzbh/about.html">点击进入</a></td>
                            <td>刘凯洋</td>
                            <td>2016-10-12</td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td>2016全国植保会</td>
                            <td>全国农业技术推广服务中心</td>
                            <td>江苏省植物保护站厦门市凤凰创意会展服务有限公司</td>
                            <td>中国</td>
                            <td>南京</td>
                            <td>2016年11月25日</td>
                            <td>2016年11月27日</td>
                            <td>南京国际博览中心</td>
                            <td>吸引来自全国30参展范围涉及农药原药、农药、肥料、植保机械及包装设备等，涵盖整个农化产业上、中、下游产品，是国内参展产品最齐全的大会。</td>
                            <td><a href="http://www.1988.tv/zhanhui/2016qgzbh/about.html">点击进入</a></td>
                            <td>刘凯洋</td>
                            <td>2016-10-12</td>
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
<script src="../../js/jquery-2.1.0.js" type="text/javascript" charset="utf-8"></script>
<script src="../../js/dropdown.js" type="text/javascript" charset="utf-8"></script>
<script src="../../js/collapse.js" type="text/javascript" charset="utf-8"></script>
<script src="../../js/transition.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
