<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache,must-revalidate");
    response.setDateHeader("Expires", 0);
     response.flushBuffer();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function jumurl(){
			window.location.href="register.jsp";
		}
		function jumurl2(){
			window.location.href="nanny.do?m=NannyPage";
		}
	</script>
	<style type="text/css">
			*{
				margin: 0 auto;
			}
		
			a{
			width:20px;
			height:20px;
			color:red;
			border:1px;
			}
			.yema a{
			font-size:30px;
			}
			
			.text{
			width:100%;
			}
			.text h1{
				text-align:center;
				color:red;
			}
			.left{
			margin-top:30px;
			width:20%;
			float:left;
			}
			.left input{
			font-size:40px;
 			float:left;
 			width:300px;
 			background-color:green;
 			text-align:center;
 			margin-top:50px;
 			margin-left:5%;
			}
			.right{
			width:70%;
			float:left;
			margin-left:3%;
			}
			.yema{
				margin-top:500px;
			}
			
		</style>
		 <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="text">
		<h1>欢迎来到系统管理界面</h1>
		<div class="left">
			<input type="button" value="用户管理"><br>
			<input type="button"  value="保姆管理" onclick="jumurl2()"><br>
			<input type="button" value="工作管理">
	</div>
		
		<div class="right">
		<table style="background-color:pink" class="table  table-bordered table-hover table-condensed">
		<tr><td colspan="6" style="text-align:center"><h2>当前管理员用户:${admin.username}</h2></td></tr>
			<tr>
			<th>编号</th> <th>名字</th> <th>别名</th> <th>地址</th> <th>电话</th> <th>编辑</th>
			</tr>
			<c:forEach var="user" items="${page.data}">
				<tr>
					<td>${user.user_id }</td>
					<td>${user.username }</td>
					<td>${user.realname}</td>
					<td>${user.address }</td>
					<td>${user.tel}</td>
					
					<td style="width:120px ">
					<a href="user.do?m=SelectUserById&id=${user.user_id} ">更新</a>
			
					<a href="javascript:if(confirm('是否删除?'))location.href
					='user.do?m=DelUser&id=${user.user_id }' ">删除</a></td>
				</tr>
			</c:forEach>
			<tr><td colspan="6" style="text-align:center">
			<input style="background-color:yellow;width:150px" type="button" id="register" name = "" value="添加用户" onclick="jumurl()" />
			</td></tr>
		</table>
	</div>
	
	</div>
	
	<div class="yema" style="text-align:center">
		<c:if test="${page.currentPage>1}">
			<a href="user.do?m=UserPage&pageNow=${page.currentPage-1}">上一页---</a>
		</c:if>
		<!--i就是当前页-->
		<c:forEach var="i" begin="1" end="${page.pageCount}" step="3">
			<a href="user.do?m=UserPage&pageNow=${i}">---第${i}页---</a>
		</c:forEach>
		<c:if test="${page.currentPage<page.pageCount}">
			<a href="user.do?m=UserPage&pageNow=${page.currentPage+1}">---下一页</a>
		</c:if>
	</div>
	
	
	
		
		
</body>
</html>