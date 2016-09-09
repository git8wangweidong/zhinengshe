package com.zhinengshe.controller.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhinengshe.pojo.tree.Tree;
import com.zhinengshe.service.role.IRoleService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IRoleService roleService;
	
	@RequestMapping("/roleMenus")
	public String roleMenus(){
		return "back/user/tree";
	}
	
	@ResponseBody
	@RequestMapping("/roleMenus2")
	public void roleMenus2(){
		List<Tree> roleMenus = roleService.readRoleMenus();
	}
}
