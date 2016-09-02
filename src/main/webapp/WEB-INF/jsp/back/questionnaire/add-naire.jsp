<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <title>问卷展示页</title><%=request.getContextPath() %>
  <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath() %>/css/base.css" />
  <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>
<link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css'>
 <link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" media="screen" type="text/css" />
 <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>
 <script src='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js'></script>
</head>
<body>
<div class="heade"></div>
<div class="heade-bottom">
	<ul class="top clearfix">
		<li class="active clearfix">
			<i class="icon1"></i>
			<span>编辑问卷</span>
		</li>
		<li><i class="icon2"></i><span>发布问卷</span></li>
		<li class=""><i class="icon3"></i><span>问卷列表</span></li>
		<li><i class="icon4"></i><span>用户编辑</span></li>
	</ul>
</div>
<div class="all-content">
  <form role="form">
  <!-- 58-94-6B-38-11-94 -->
  </form> 
  <div class="row-content">
	  <div class="row">
	    <div class="col-sm-6 left-content">
	      <div id="modules">
	      	<c:if test="${!empty questiontypes }">
	      		<c:forEach items="${questiontypes }" var="questiontype">
			        <p class="drag" type='a1'><a  class="btn btn-default caname">${questiontype.name }</a></p>
			    </c:forEach>
	        </c:if>
	      </div>
	    </div>
	    <div class="col-sm-6 right">
	    	<div class="project">
	    		<h1>
					<p class="caname">满意度调查</p>
				</h1>
	    	</div>
			<div class="intro caname">欢迎参加本次答题</div>
			<div class="hr-intro"></div>
	      <div id="dropzone"></div>
	    </div>
	  </div>
  </div>
</div>
<script src="<%=request.getContextPath() %>/js/index.js"></script>
<div class="footer"></div>
</body>
</html>



