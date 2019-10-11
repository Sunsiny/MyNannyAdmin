<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保姆列表</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <script type="text/javascript">
		function jumurl(){
			window.location.href="SelectNannyWorks.jsp";
		}
	</script>
	<style type="text/css">
	button{
		background-color:red;
		font-size:40px;
	}
	</style>
</head>
<body>
		<div class="nanny">
			<table style="background-color:green" class="table  table-bordered table-hover table-condensed" >
		<tr>
			<th>编号</th> <th>名字</th> <th>年龄</th> <th>性别</th> 
			<th>电话</th> <th>薪资</th> <th>工作月份</th> <th>教育水平</th>
			<th>居住地</th> <th>地址</th> <th>照片</th> <th>工作天数</th>
			<th>表扬</th>  <th>任职</th> <th>身份证号</th> <th>工作类型id</th> 
			<th>民族</th> <th>是否结婚</th> <th>属相</th> <th>当前城市</th> <th>目标城市</th> 
			<th>状态</th> <th>id照片</th> <th>编辑</th>
			</tr>
			<c:forEach var="nanny" items="${page.data}">
				<tr>
				<td>${nanny.nanny_id}</td> <td>${nanny.name}</td> <td>${nanny.age}</td> <td>${nanny.gender}</td>
				<td>${nanny.tel}</td> <td>${nanny.salary}</td> <td>${nanny.months}</td> <td>${nanny.edu}</td>
				<td>${nanny.place}</td> <td>${nanny.address}</td>
				<td><img src="http://localhost/upload/${nanny.picture}" style="width:30px;height:30px" /></td>
				<td>${nanny.work_days}</td> <td>${nanny.phraise}</td> <td>${nanny.appointments}</td> <td>${nanny.pid}</td>
				<td>${nanny.nanny_type_id}</td> <td>${nanny.nation }</td> <td>${nanny.marrital}</td> <td>${nanny.zodiac}</td>
				<td>${nanny.current_city}</td> <td>${nanny.target_city}</td> <td>${nanny.status}</td>
				<td>
				<img src="http://localhost/upload/${nanny.id_picture}" style="width:30px;height:30px"/>
				</td>
				
				<td>
					<a>更新</a>
					<a href="javascript:if(confirm('是否删除?'))location.href
					='nanny.do?m=DeleteNanny&id=${nanny.nanny_id }' ">删除</a>
					<a href="addNanny.jsp">添加用户</a>
				</td>
				</tr>
			</c:forEach>
	</table>
		</div>
		
		<div class="fenye" style="text-align:center">
		<c:if test="${page.currentPage>1}">
			<a href="nanny.do?m=NannyPage&pageNow=${page.currentPage-1}">上一页---</a>
		</c:if>
		<!--i就是当前页-->
		<c:forEach var="i" begin="1" end="${page.pageCount}" step="1">
			<a href="nanny.do?m=NannyPage&pageNow=${i}">---第${i}页---</a>
		</c:forEach>
		<c:if test="${page.currentPage<page.pageCount}">
			<a href="nanny.do?m=NannyPage&pageNow=${page.currentPage+1}">---下一页</a>
		</c:if>
	</div>
	<button onclick="jumurl()">保姆工作数量图表</button>
</body>
</html>