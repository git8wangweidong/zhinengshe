<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<title>学生登陆页</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript">
	;(function(window, document){
		function change(){
			document.documentElement.style.fontSize=20*document.documentElement.clientWidth/320+'px';
		}
		change();
		window.addEventListener('resize', change, false);
	})(window, document);
	
</script>
</head>
<body>
	<div class="login">
		<div class="top-one"></div>
		<div class="in">
			<h2>智能社学员在线网</h2>
			<p>欢迎您登陆智能社答题测评系统!</p>
			<form action="${pageContext.request.contextPath }/login/studentLogin" method="post">
			
				<ul>
					<li class="user">
						<span class="icon"></span>
						<input type="text" class="txt" placeholder="邮箱/手机/用户名" name = "username">
					</li>
					<li class="pwd">
						<span class="icon"></span>
						<input type="password" class="txt" placeholder="密码" name = "password">
					</li>
					<li class="sb">
                    	<input type="submit" value="登录" class="btn" />
                    </li>
				</ul>
			</form>
		</div>
		<div class="footer">
			<p>智能社WWW.ZHINENGSHE.COM|专注前端 培训专家</p>
					<p>400-000-3154</p>
		</div>
	</div>
</body>
</html>