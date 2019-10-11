<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
			*{
				margin: 0 auto;
			}
			
		</style>
</head>
<body>
	<form method = "post" action = "user.do?m=UpdateUser">
				<input type="hidden"  name="id" value="${user.user_id }" />
		<table>
			<tr>
			<td>用户名：</td>
			<td><input type="text" name="username" value="${user.username }" /></td>
			</tr>
			<tr>
			<td>姓名：</td>
			<td><input type="text" name="realname" value="${user.realname }" /></td>
			</tr>
			<tr>
			<td>地址：</td>
			<td><input type="text" name="address" value="${user.address }" /></td>
			</tr>
			<tr>
			<td>电话</td>
			<td><input type="text" name="tel" value="${user.tel }" /></td>
			</tr>
			<tr>
			<td><input type="submit" value="更新"/></td>
			</tr>
		</table>
	</form>
</body>
</html>