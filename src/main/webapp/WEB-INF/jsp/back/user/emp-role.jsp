<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/icon.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/empRole.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.easyui.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户权限管理</title>
</head>
<body class="easyui-layout">
 <div data-options="region:'west',title:'请选择用户',split:true" style="width:210px;">
	<table class="easyui-datagrid" data-options="url:'/emp/empList',singleSelect:true,onClickRow:clickRow" >
		<thead>
			<tr>
				<th data-options="field:'eid',width:100">角色编号</th>
				<th data-options="field:'ename',width:100">角色名称</th>
			</tr>
		</thead>
	</table> 
 </div>   
 <div data-options="region:'center',title:'请设置角色'" style="padding:5px;background:#eee;">
    <ul id="tree"></ul>
    <button onclick="save()">保存</button>
 </div> 
</body>
</html>
