<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.1.1.js" ></script>
</head>
<body> 
		<form method = "post" action = "pet.do?m=AddPet" enctype="multipart/form-data">
			<input type="text" name="name" placeholder="请输入名字"><span id="message"></span> <br>
			<input type="text" name="type" placeholder="请输入宠物类型"> <br>
			<input type="text" name="age" placeholder="请输入年龄"> <br>
			<input type="file" name="image" placeholder="请输入照片"> <br>
			<input type= "submit" name=""  value="提交">
		</form>
		<script type="text/javascript">
		$("[name=name]:text").blur(function(){
			$.post("pet.do?m=CheckPet",
			{name:$(this).val()},
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