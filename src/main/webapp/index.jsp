<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎页</title>
</head>
<body>

<h4>欢迎来到智能社只能评分系统</h4>
<a href="<%=request.getContextPath()%>/teacherLogin">教师登陆</a><br>

<a href="<%=request.getContextPath()%>/studentLogin">学生登陆</a><br>

<a href="<%=request.getContextPath()%>/managerLogin">管理员登陆</a><br>

</body>
</html>