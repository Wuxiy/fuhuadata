<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2017/1/12
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>加工成本参考</title>
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
                    <span class="glyphicon glyphicon-user"></span> 客户信息
                    <b class="caret"></b>
                </a>
            </li>
            <li class="shadow-in" title="供应商信息">
                <div id="collapseTwo" class="list-group collapse">
                    <a class="list-group-item" href="#">加工厂</a>
                    <a class="list-group-item" href="#">货代</a>
                </div>
                <a data-toggle="collapse" href="#collapseTwo" data-parent="#nav-affix">
                    <span class="glyphicon glyphicon-briefcase"></span> 供应商信息
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
                    <span class="glyphicon glyphicon-stats"></span> 销售统计
                    <b class="caret"></b>
                </a>
            </li>
            <li class="shadow-in" title="行业数据">
                <div id="collapseFour" class="list-group collapse">
                    <a class="list-group-item" href="#">市场数据</a>
                </div>
                <a data-toggle="collapse" href="#collapseFour" data-parent="#nav-affix">
                    <span class="glyphicon glyphicon-list-alt"></span> 行业数据
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
                    <span class="glyphicon glyphicon-book"></span> 知识库
                    <b class="caret"></b>
                </a>
            </li>
            <li class="shadow-in" title="决策支持">
                <div id="collapseSix" class="list-group collapse">
                    <a class="list-group-item" href="#">销售数据</a>
                    <a class="list-group-item" href="#">成本费用</a>
                    <a class="list-group-item" href="#">数据库</a>
                </div>
                <a data-toggle="collapse" href="#collapseSix" data-parent="#nav-affix">
                    <span class="glyphicon glyphicon-pencil"></span> 决策支持
                    <b class="caret"></b>
                </a>
            </li>
            <li class="shadow-in" title="系统管理">
                <div id="collapseSeven" class="list-group collapse">
                    <a class="list-group-item" href="#">设置</a>
                </div>
                <a data-toggle="collapse" href="#collapseSeven" data-parent="#nav-affix">
                    <span class="glyphicon glyphicon-cog"></span> 系统管理
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
                <li class="active">加工成本参考</li>
            </ul>
        </div>
        <!--面包屑导结束-->
        <div class="dashboard-wrapper">
            <!--tab导航开始-->
            <ul id="myTab" class="nav nav-tabs">
                <li class="active"><a href="#adEexpense" data-toggle="tab">制剂加工费</a></li>
                <li><a href="#freight" data-toggle="tab">国内运费</a></li>
                <li><a href="#cost" data-toggle="tab">成分价格</a></li>
                <li><a href="#portSurcharge" data-toggle="tab">港杂费</a></li>
                <li><a href="#rate" data-toggle="tab">费率</a></li>
            </ul>
            <!--tab导航结束-->
            <div class="tab-content">
                <div id="adEexpense" class="tab-pane fade in active">
                    <div class="row">
                        <div class="col-xs-7">
                            <!--制剂加工费表开始-->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <a href="" class="btn btn-xs btn-primary panel-heading-btn pull-right">
                                        新增
                                    </a>
                                    <h3 class="panel-title">
                                        水剂加工费
                                    </h3>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-bordered table-condensed text-center">
                                        <thead>
                                        <tr>
                                            <th class="text-center col-xs-2">费用项</th>
                                            <th class="text-center col-xs-2">单价（元/T）</th>
                                            <th class="text-center col-xs-2">价格有效期</th>
                                            <th class="text-center col-xs-6">备注</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>200ML</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>500ML</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>1L</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>4L</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>5L</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>20L</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>100L</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>200L</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <a href="" class="btn btn-xs btn-primary panel-heading-btn pull-right">
                                        新增
                                    </a>
                                    <h3 class="panel-title">
                                        颗粒剂加工费
                                    </h3>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-bordered table-condensed text-center">
                                        <thead>
                                        <tr>
                                            <th class="text-center col-xs-2">费用项</th>
                                            <th class="text-center col-xs-2">单价（元/T）</th>
                                            <th class="text-center col-xs-2">价格有效期</th>
                                            <th class="text-center col-xs-6">备注</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>水、电、气</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>利润</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>管理费</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>税金</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>加工费合计</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!--制剂加工费表结束-->
                        </div>
                    </div>
                </div>
                <div id="freight" class="tab-pane fade">
                    <div class="row">
                        <div class="col-xs-7">
                            <!--运费维护表开始-->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <a href="" class="btn btn-xs btn-primary panel-heading-btn pull-right">
                                        新增
                                    </a>
                                    <h3 class="panel-title">
                                        运费维护
                                    </h3>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-bordered table-condensed text-center">
                                        <thead>
                                        <tr>
                                            <th class="text-center col-xs-2">加工厂</th>
                                            <th class="text-center col-xs-2">起运城市</th>
                                            <th class="text-center col-xs-2">目的城市</th>
                                            <th class="text-center col-xs-2">单价（元/T（KL））</th>
                                            <th class="text-center col-xs-4">备注</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>杭州海辰</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>杭州乐川</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>安徽银山</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>浙江菱化</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!--运费维护表结束-->
                        </div>
                    </div>
                </div>
                <div id="cost" class="tab-pane fade">
                    <div class="row">
                        <div class="col-xs-7">
                            <!--成分价格表开始-->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <a href="" class="btn btn-xs btn-primary panel-heading-btn pull-right">
                                        新增
                                    </a>
                                    <h3 class="panel-title">
                                        成分价格
                                    </h3>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-bordered table-condensed text-center">
                                        <thead>
                                        <tr>
                                            <th class="text-center col-xs-2">成分名称</th>
                                            <th class="text-center col-xs-2">单耗（kg/T）</th>
                                            <th class="text-center col-xs-2">单价（元/kg）</th>
                                            <th class="text-center col-xs-2">价格有效期</th>
                                            <th class="text-center col-xs-2">适合产品</th>
                                            <th class="text-center col-xs-2">备注</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>原粉</td>
                                            <td>——</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>颗粒剂助剂A</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>颗粒剂助剂B</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>碳酸氢铵</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>填料</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>异丙胺</td>
                                            <td>——</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>助剂</td>
                                            <td>——</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>氨</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!--成分价格表结束-->
                        </div>
                    </div>
                </div>
                <div id="portSurcharge" class="tab-pane fade">
                    <div class="row">
                        <div class="col-xs-7">
                            <!--港杂费参考表开始-->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <a href="" class="btn btn-xs btn-primary panel-heading-btn pull-right">
                                        新增
                                    </a>
                                    <h3 class="panel-title">
                                        港杂费参考价
                                    </h3>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-bordered table-condensed text-center">
                                        <thead>
                                        <tr>
                                            <th colspan="3" class="text-center col-xs-6">项目</th>
                                            <th class="text-center col-xs-3">一般化工品</th>
                                            <th class="text-center col-xs-3">危险品</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td colspan="2" rowspan="2">订舱费（元/柜）</td>
                                            <td class="text-left">20GP</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td class="text-left">20GP&HQ</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td rowspan="4">装箱费（元/柜）</td>
                                            <td rowspan="2">外港</td>
                                            <td class="text-left">20GP</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td class="text-left">40GP&HQ</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td rowspan="2">洋山港</td>
                                            <td class="text-left">20GP</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td class="text-left">40GP&HQ</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">文件费（元/票）</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">电放费（元/票）</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">改单费（元/票）</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">快递费</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">报关费（元/票）</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">进仓费（卸货费）（元/吨）</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" rowspan="5">打托费（托盘、打托、缠膜）（元/托）</td>
                                            <td class="text-left">普通托盘</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td class="text-left">熏蒸托盘</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td class="text-left">双面托</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td class="text-left">CP3托盘</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td class="text-left">塑料托盘</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">垫板费（元/张）</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">纸板费（元/个）</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">气囊费（元/个）</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">唛头（元/张）（黑白打印，A4纸一半）</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">拉网费（元/柜）</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">紧固带费（元/柜）</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td rowspan="2" colspan="2">抄条码费</td>
                                            <td class="text-left">600KG-1000KG包装（元/包）</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td class="text-left">25KG包装（元/柜）</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">封子费（元/柜）</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">检查费（元/柜）</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">美式门封（元/柜）</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td rowspan="2" colspan="2">FOB操作费（元/柜）</td>
                                            <td class="text-left">20GP</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td class="text-left">40GP&<hq></hq></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">护条（元/个）</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">护角（元/个）</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">仓储费</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">商检换单（元/票）</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!--港杂费参考表结束-->
                        </div>
                    </div>
                </div>
                <div id="rate" class="tab-pane fade">
                    <div class="row">
                        <div class="col-xs-7">
                            <!--费率表开始-->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <a href="" class="btn btn-xs btn-primary panel-heading-btn pull-right">
                                        新增
                                    </a>
                                    <h3 class="panel-title">
                                        币种&汇率
                                    </h3>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-bordered table-condensed text-center">
                                        <thead>
                                        <tr>
                                            <th class="text-center col-xs-2">币种</th>
                                            <th class="text-center col-xs-2">汇率</th>
                                            <th class="text-center col-xs-2">价有效期</th>
                                            <th class="text-center col-xs-6">备注</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>人民币</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>澳元</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>美元</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>欧元</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <a href="" class="btn btn-xs btn-primary panel-heading-btn pull-right">
                                        新增
                                    </a>
                                    <h3 class="panel-title">
                                        毛利率
                                    </h3>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-bordered table-condensed text-center">
                                        <thead>
                                        <tr>
                                            <th class="text-center col-xs-2">产品种类</th>
                                            <th class="text-center col-xs-2">毛利率</th>
                                            <th class="text-center col-xs-2">有效期</th>
                                            <th class="text-center col-xs-6">备注</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>除草剂-草甘膦</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>除草剂-草铵膦</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <a href="" class="btn btn-xs btn-primary panel-heading-btn pull-right">
                                        新增
                                    </a>
                                    <h3 class="panel-title">
                                        其他费率
                                    </h3>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-bordered table-condensed text-center">
                                        <thead>
                                        <tr>
                                            <th class="text-center col-xs-2">费率项</th>
                                            <th class="text-center col-xs-2">费率值</th>
                                            <th class="text-center col-xs-2">有效期</th>
                                            <th class="text-center col-xs-6">备注</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>保险费费率</td>
                                            <td>0.03%</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>信保费率</td>
                                            <td>0.24%</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>资金利息费率</td>
                                            <td>6%</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>税金销售费用比率</td>
                                            <td>0.50%</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>管理费用比率</td>
                                            <td>0.20%</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!--费率表结束-->
                        </div>
                    </div>
                </div>
            </div>
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
<script src="../../js/tab.js" type="text/javascript" charset="utf-8"></script>
<script src="../../js/transition.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>