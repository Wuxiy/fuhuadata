<%@ page import="com.fuhuadata.domain.UserAccount" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>用户列表页</title>
 </head>
 <body>
 <c:forEach items="${userAccountList}" var="p">
  <tr>
   <td>${p.id}</td>
   <td>${p.name}</td>
   <td>
   </td>
  </tr>
 </c:forEach>
 <a href="/userAccount/addUserAccount">新增用户</a>
 <a href="/userAccount/addUserAccount">新增用户2</a>
 <div>${message}</div>
 </body>
</html>