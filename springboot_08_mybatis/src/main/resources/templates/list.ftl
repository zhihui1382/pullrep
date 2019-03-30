<!DOCTYPE html>
<html>
<head lang="en">
<title>Spring Boot Demo - FreeMarker</title>
</head>
	<table border="1" align="center">
		<tr>
			<td>编号</td>
			<td>登录名</td>
			<td>身份证</td>
			<td>姓名</td>
			<td>性别</td>
			<td>地址</td>
			<td>电话</td>
			<td>职业</td>
			<td>操作</td>
		</tr>
		<#list userList as u>
			<tr>
				<td>${u.userid}</td>
				<td>${u.loginname}</td>
				<td>${u.identity}</td>
				<td>${u.realname}</td>
				<td>
					<#if u.sex==1>
						男
					<#else>
						女
					</#if>
				</td>
				<td>${u.address}</td>
				<td>${u.phone}</td>
				<td>${u.position}</td>
				<td><a href="users/${u.userid}">删除</a></td>
			</tr>
		</#list>
	</table>
	
</body>
</html>