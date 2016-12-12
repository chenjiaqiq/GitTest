<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户更新</title>
    
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
      <div><h2>显示用户</h2></div>
       <s:set name="user" value="#request.user"/>
      <form action="<%=path %>/User/update.action" method="post">
      <table>
      <%--  <tr>
         <td>编 号 ：</td>
         <td><input type="text" name="user.id"  value="<s:property value='#user.id'/>"></td>
        </tr> --%>
        <input type="hidden" name="user.id"  value="<s:property value='#user.id'/>">
        
        <tr>
         <td>用户名：</td>
         <td><input type="text" name="user.username" value="<s:property value='#user.username'/>"></td>
        </tr>
        <tr>
         <td>密 码 ：</td>
         <td><input type="password" name="user.password" value="<s:property value='#user.password'/>"></td>
        </tr>
        <tr>
         <td colspan="2">
         <input type="submit" value="更新">
         </td>
        </tr>
         </table>
         </form>
    </center>
  </body>
</html>
