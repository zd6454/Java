<%@ page language="java"  import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"   %>
    <%@ page  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
 String path=request.getContextPath();
 String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<base href="<%=basePath%>">
<title>所有用户界面</title>
</head>
<body>
<h1 align="center">${success}</h1>
<h1 align="center">用户档案界面</h1>
  <table width="600"  align="center"  cellpadding="0" >
    <tr>
    <th>ID</th>
    <th>姓名</th>
    <th>性别</th>
    <th>民族</th>
    <th>出生日期</th>
    <th>密码</th>
    <th>权限</th>
    <th>职务</th>
    <th>操作</th>
    </tr>
     <c:forEach var="U" items="${userAll}" >  
        <form action="UpdateServlet" method="post">
         <tr>
           <td><input type="text" value="${U.id}" name="id"> </td>
           <td><input type="text" value="${U.name}" name="name"></td>
	       <td><input type="text" value="${U.sex}" name="sex"></td>
	       <td><input type="text" value="${U.race}" name="race"></td>
	       <td><input type="text" value="${U.birthday}" name="birthday"></td>
	       <td><input type="text" value="${U.password}" name="password"></td>
	       <td><input type="text" value="${U.type}" name="type"></td>
	       <td><input type="text" value="${U.duty}" name="duty"></td>
	       <td><a href="DeleteServlet?id=${U.id}">删除</a>  <input type="submit" value="更新"/></td>
     </tr>
        </form>
 </c:forEach>
  </table>
  <div align="center">
   <a  href="Downfile" >下载档案信息</a>
   <a href="zhuce.jsp">添加新用户</a><br> 
  </div>
  <a href="success.jsp">返回</a> <br>
</body>
</html>