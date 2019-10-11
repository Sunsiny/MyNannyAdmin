<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
		<table style="background-color:pink" class="table  table-bordered table-hover table-condensed">
			<tr>
			<th>编号</th> <th>名字</th> <th>宠物类型</th> <th>年龄</th> <th>照片</th> <th>编辑</th>
			</tr>
			<c:forEach var="pet" items="${pets}">
				<tr>
					<td>${pet.id}</td>
					<td>${pet.name}</td>
					<td>${pet.type}</td>
					<td>${pet.age}</td>
					<td><img src="http://localhost/upload/${pet.image}" style="width:30px;height:30px"/></td>
					<td><a href="addPet.jsp">添加</a></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>