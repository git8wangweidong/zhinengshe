<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<h5>我是管理员index</h5> <br><br>

<a href="<%=request.getContextPath()%>/manager/toAdd">管理员管理</a><br><br>

<a href="<%=request.getContextPath()%>/teacher/toAdd">教师管理</a><br><br>

<a href="<%=request.getContextPath()%>/student/toAdd">学生管理</a><br><br>

<a href="<%=request.getContextPath()%>/classess/toAdd">班级管理</a><br><br>



</body>
</html>