<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.1.1.js" ></script>

<style type="text/css">
			*{
				margin: 0 auto;
			}
			
		</style>
</head>
<body>
	
	<form method = "post" action = "user.do?m=addUser">
		<table>
		<tr>
		<td style="color:red"><span>${register_error}</span></td>
		</tr>
			<tr>
			<td>用户名：</td>
			<td><input type="text" name="username" /><span id="message"></span></td>
			</tr>
			<tr>
			<td>姓名：</td>
			<td><input type="text" name="realname" /></td>
			</tr>
			<tr>
			<td>地址：</td>
			<td><input type="text" name="address" /></td>
			</tr>
			<tr>
			<td>电话</td>
			<td><input type="text" name="tel" /></td>
			</tr>
			<tr>
			<td><input type="submit" name="submit" value="提交"/></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		$("[name=username]:text").blur(function(){
			$.post("user.do?m=CheckUser",
			{username:$(this).val()},
			function(respText){
				if(respText=="true"){
					$("#message").css("color","yellow").text("这个用户可以使用");
				}else{
					$("#message").css("color","red").text("这个用户不可以使用");
				
				}
			}
			);
		});
	
	</script>
</body>
</html>