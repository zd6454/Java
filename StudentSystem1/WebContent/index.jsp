<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>失败</title>
</head>
<body>
       <h1><%response.setHeader("refresh", "3,URL=WebContent/WEB-INF/denglu.jsp"); %>很遗憾，登录失败！！！</h1>
       <font color="red" size="5"> 您的登录信息错误<br> 三秒后将跳转到登录页面 <br>
		如果没有跳转,请点击 <a href="denglu.jsp">这里</a>!!! <br>
	</font>
</body>
</html>