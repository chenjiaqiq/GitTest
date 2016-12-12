<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>插入用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <center>
      <div><h2>插入用户</h2></div>
      <form action="<%=path%>/User/insert.action" method="post">
      <table>
        <tr>
         <td>用户名：</td>
         <td><input type="text" name="user.username"></td>
        </tr>
        <tr>
         <td>密 码 ：</td>
         <td><input type="password" name="user.password"></td>
        </tr>
        <tr>
         <td colspan="2">
         <input type="submit" value="插入">
         </td>
        </tr>
         </table>
         </form>
    </center>
  </body>
</html>
