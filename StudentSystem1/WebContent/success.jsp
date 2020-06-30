<%@ page language="java"  import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%
 String path=request.getContextPath();
 String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>登录成功</title>
</head>
<body>
        <div align="center">
         <h1>${zhu} <br> </h1>
         <a href="queryby.jsp">按条件查询</a>
         <a href="Searchall">查看所有用户</a>
           <form action="zhuce.jsp">
     <input type="submit" value="录入用户信息">
     </form>
     </div>
</body>
</html>