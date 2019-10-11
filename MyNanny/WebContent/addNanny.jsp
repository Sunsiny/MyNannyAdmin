<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="nanny.do?m=AddNanny" method="post" enctype="multipart/form-data">
		<input type="text" name="name"  placeholder="请输入保姆名"><br>
		<input type="text" name="age"  placeholder="请输入年龄"><br>
		<input type="text" name="gender"  placeholder="请输入性别"><br>
		<input type="text" name="tel"  placeholder="手机号"><br>
		<input type="text" name="salary"  placeholder="请输入工资"><br>
		<input type="text" name="months"  placeholder="请输入月份"><br>
		<input type="text" name="edu"  placeholder="请输入受教育程度"><br>
		<input type="text" name="place"  placeholder="请输入地方"><br>
		<input type="text" name="address"  placeholder="请输入地址"><br>
		<input type="file" name="picture"  placeholder="请输入照片"><br>
		<input type="text" name="work_days"  placeholder="请输入工作天数"><br>
		<input type="text" name="phraise"  placeholder="请输入30"><br>
		<input type="text" name="appointments"  placeholder="请输入观点数"><br>
		<input type="text" name="pid"  placeholder="请输入身份证"><br>
		<input type="text" name="nanny_type_id"  placeholder="请输入工作id"><br>
		<input type="text" name="nation"  placeholder="请输入民族"><br>
		<input type="text" name="marrital"  placeholder="是否结婚"><br>
		<input type="text" name="zodiac"  placeholder="请输入属相"><br>
		<input type="text" name="current_city"  placeholder="请输入当前城市"><br>
		<input type="text" name="target_city"  placeholder="请输入目标城市"><br>
		<input type="text" name="status"  placeholder="是否待岗"><br>
		<input type="file" name="id_picture"  placeholder="id照片"><br>
		<input type="submit" name="submit" value="提交"/>
	</form>

</body>
</html>