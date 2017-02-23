 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html style="height: 100%;">
 <head>
  <meta charset="UTF-8">
  <title lang="zh">登录</title>
  <script type="text/javascript" src="/lib/js/jquery-2.1.0.js"></script>
  <script type="text/javascript" src="/lib/js/commons/log_in.js"></script>
  <link rel="stylesheet" type="text/css" href="lib/css/bootstrap.css"/>
 </head>
 <body class="bg-page" style="background: url(lib/img/logoBg.jpg) no-repeat 100% 100%; height: 100%;">
 <div class="bg-warning">
  <div class="col-xs-4">
   <h1 class="logo" style="color: #fff; font-size: 40px; font-weight: bold;">CRM</h1>
  </div>
 </div>
 <div class="col-xs-3 col-xs-offset-8">
  <div class="jumbotron" style="background-color: rgba(255,255,255,0.5); margin-top: 50px;">
   <div class="container">
    <h3 lang="zh">登录</h3>
    <div class="form-group">
     <div class="input-group input-group-lg">
      <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
      <input class="form-control" type="text" value="" id="account"/>
     </div>
    </div>
    <div class="form-group">
     <div class="input-group input-group-lg">
      <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
      <input class="form-control" type="password" value="" id="password"/>
     </div>
    </div>
    <div class="form-group">
     <a class="btn btn-success btn-lg btn-block" role="button" id="login">
      登录
     </a>
    </div>
   </div>
  </div>
 </div>
</body>
 </html>