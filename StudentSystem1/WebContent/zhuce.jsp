<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>录入信息界面</title>
</head>
<body>
<h1>${zhu}</h1>
   <form action="ZhuceServlet"method="post" style="padding-top:-700px;">
    输入用户名:<input name="name" type="text"><br><br>
    输入密码:<input name="password" type="password"><br><br>
    选择性别:<input type="radio" name="sex" value="男"checked>男
          <input type="radio" name="sex" value="女">女<br><br>
    民族:<input type="text" name="race" >族<br><br>
    出生日期:<input type="date" name="birthday" id="birthday" placeholder="2019-11-19"><br><br>
    职位:<input type="text" name="duty"><br><br>
    <input type="reset" value="重置"><input type="submit" value="确认录入">
   </form>
</body>
</html>