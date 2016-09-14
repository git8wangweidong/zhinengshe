var id;//用户ID
var clickRow=function(rowIndex,rowData){
	id=rowData.eid;//角色ID赋值
	$('#tree').tree({
		url:'/emp/empRoles?id='+id,
		animate:true,
		checkbox:true
	});	
}

function save(){
	alert(id)
	//得到选中的节点集合
	var nodes= $('#tree').tree('getChecked');	
	var checkedStr="";
	for(var i=0;i<nodes.length;i++){
		if(i>0){
			checkedStr+=","
		}
		checkedStr+=nodes[i].id;		
	}	
	//提交更新
	$.ajax({
		url:'/emp/updateEmpRole',
		data:{"id":id,"checkedStr":checkedStr},
		dataType:'json',
		type:'post',
		success:function(value){
			$.messager.alert('提示',value.msg);
		}		
	});
}

