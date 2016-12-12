<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.println("登錄");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <style type="text/css">
<!--
body center {
}
-->
  </style><meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
  
  <body>
    <center>
      <div><h2>用户登录</h2></div>
      <form action="<%=path %>/User/login.action" method="post">
      <table>
        <tr>
         <td>用户名：</td>
         <td><input type="text" name="user.username"></td>
        </tr>
        <tr>
         <td>密  码：</td>
         <td><input type="password" name="user.password"></td>
        </tr>
        <tr>
         <td colspan="2">
         <input type="submit" value="登录">
         <input type="reset" value="重置">
         </td>
        </tr>
        </table>
      </form>
  </center>
</body>
</html>
