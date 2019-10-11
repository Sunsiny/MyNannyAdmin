<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.1.1.js" ></script>
<script type="text/javascript" src="js"></script>
 <script type="text/javascript" src="js/echarts.js"></script>
 
 <script type="text/javascript">
 $(function(){
	 $.get("nanny.do?m=SelectNannyWorks",
			 function(respText){
			 var works = JSON.parse(respText);
			 var names=[];
			 var counts= new Array();
			 
			 for(var i=0;i<works.length;i++){
			 	names[i] = works[i].nannyname;
			 	counts[i] = works[i].workcount;
		 	}
			 var myChart = echarts.init(document.getElementById('nannyWork'));

		        // 指定图表的配置项和数据
		        var option = {
		            title: {
		                text: '工作量示例图'
		            },
		            tooltip: {},
		            legend: {
		                data:['工作量']
		            },
		            xAxis: {
		                data: names
		            },
		            yAxis: {},
		            series: [{
		                name: '工作量',
		                type: 'line',
		                data: counts
		            }]
		        };

		        // 使用刚指定的配置项和数据显示图表。
		        myChart.setOption(option);
	 });
 });

 </script>
 	<style type="text/css">
 		*{
				margin: 0 auto;
			
 		}
 		.left{
 			float:left;
 		}
 		.left input{
 		font-size:40px;
 		float:left;
 		width:300px;
 		background-color:green;
 		margin-left:200px;
 		text-align:center;
 		margin-top:50px;
 		}
 		#nannyWork{
 			float:left;
 			margin-left:100px;
 		}
 	</style>
 <script type="text/javascript">
		function jumurl(){
			window.location.href="user.do?m=UserPage";
		}
		function jumurl2(){
			window.location.href="nanny.do?m=NannyPage";
		}
	</script>
</head>
<body>
		<div class="content">
		
			<div class="left">
			<input type="button" value="用户管理" name="username" onclick="jumurl()"><br>
			<input type="button" value="保姆管理" name="nannyname" onclick="jumurl2()"><br>
			<input type="button" value="工作管理" name="workname" ><br>
	</div>
		<div id="nannyWork" style="width:600px;height:400px;background:#cccccc"></div>
		</div>
		
</body>
</html>