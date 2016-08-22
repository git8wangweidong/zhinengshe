<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta charset="utf-8">
<title>后台登陆管理</title>
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/css/base.css" />
</head>
<body>
	<div class="box">
	<h2>学员在线评分-管理员登陆</h2>
	<div class="con">
		<form name="frm" method="post" action="/login/managerLogin">
        	<ul>
            	<li class="clearfix">
                    <input type="text" class="fl txt"  placeholder="请输入账号" name = "username"/>
                </li>
            	<li class="clearfix">
                    <input type="password" class="fl txt"  placeholder="请输入密码"  name = "password"/>
                </li>
                <li>
                	<input type="submit" value="登录" class="btn" />
                </li>
        	</ul>
        </form>
	</div>
	</div>
</body>
</html>