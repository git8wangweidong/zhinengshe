package com.zhinengshe.controller.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhinengshe.controller.BaseController;
import com.zhinengshe.pojo.role.Role;
import com.zhinengshe.pojo.tree.Tree;
import com.zhinengshe.service.role.IRoleService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	@Resource
	private IRoleService roleService;
	
	@RequestMapping("/roleMenus")
	public String roleMenus(){
		return "back/user/tree";
	}
	
	@RequestMapping("/roleMenus2")
	public @ResponseBody List<Tree> roleMenus2(Integer id){
		List<Tree> roleMenus = roleService.readRoleMenus(id);
		return roleMenus;
	}
	
	@RequestMapping("/roleList")
	public @ResponseBody List<Role> roleList(){
		List<Role> list = null;
		try {
			list = roleService.show();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return list;
	}
}
