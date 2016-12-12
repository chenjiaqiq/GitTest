<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>全部信息显示</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">

	</head>
	<center>
		<h2>
			全部信息列表
		</h2>
	</center>
	<body>
		<center>
         <center><a href="insert.jsp">插入</a></center>
		  <table border="1" width="600">
               <tr align="center">
					<td align="center">
						序号
					</td align="center">
					<td align="center">
						用户名
					</td>
					<td align="center">
						密码
					</td>
                    <td colspan="3" align="center">操作</td>
				</tr>
				<s:iterator value="#request.list" status="index">
					<tr align="center">
					    <td align="center"> <s:property value="#index.index"/></td>
						<td align="center">
							<s:property value="username"/></td>
						<td align="center">
							<s:property value="password"/></td>
						<td align="center">
							<a href="query.action?id=<s:property value='id'/>">更新</a>
						</td>
						<td align="center">
							<a href="delete.action?id=<s:property value='id'/>">删除</a>
						</td>
						<td align="center">
						    <a href="query.action?id=<s:property value='id'/>">详情</a>
					    </td>						
					</tr>
				</s:iterator>
			</table>
		</center>
	</body>
</html>