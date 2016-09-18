package com.zhinengshe.controller.emp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhinengshe.controller.BaseController;
import com.zhinengshe.pojo.emp.Emp;
import com.zhinengshe.pojo.menu.Menu;
import com.zhinengshe.pojo.role.Role;
import com.zhinengshe.pojo.tree.Tree;
import com.zhinengshe.service.emp.IEmpRoleService;
import com.zhinengshe.service.role.IRoleMenuService;

@Controller
@RequestMapping("/emp")
public class EmpController extends BaseController{

	@Resource
	private IRoleMenuService roleService;
	
	@Resource
	private IEmpRoleService empRoleService;
	
	/**
	 * to角色菜单页面
	 * @return
	 */
	@RequestMapping("/roleMenus")
	public String roleMenus(){
		return "back/user/role-menu";
	}
	
	/**
	 * 角色菜单
	 * @param id
	 * @return
	 */
	@RequestMapping("/roleMenus2")
	public @ResponseBody List<Tree> roleMenus2(Integer id){
		List<Tree> roleMenus = roleService.readRoleMenus(id);
		return roleMenus;
	}
	
	/**
	 * 角色列表
	 * @return
	 */
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
	
	/**
	 * 更新角色菜单
	 * @param id
	 * @param checkedStr
	 * @return
	 */
	@RequestMapping("/updateRoleMenus")
	public @ResponseBody Map<String, String>  updateRoleMenus(Integer id,String checkedStr){
		boolean b = roleService.updateRoleMenus(id, checkedStr);
		Map<String, String> map = new HashMap<>();
		if (b) {
			map.put("msg", "修改成功");
		}else{
			map.put("msg", "修改失败");
		}
		return map;
	}
	
	/**
	 * to员工角色页面
	 * @return
	 */
	@RequestMapping("/empRole")
	public String empRole(){
		return "back/user/emp-role";
	}
	
	/**
	 * 员工角色
	 * @param id
	 * @return
	 */
	@RequestMapping("/empRoles")
	public @ResponseBody List<Tree> empRoles(Integer id){
		List<Tree> empRoles = empRoleService.listEmpRoles(id);
		return empRoles;
	}
	
	/**
	 * 员工列表
	 * @return
	 */
	@RequestMapping("/empList")
	public @ResponseBody List<Emp> empList(){
		List<Emp> list = null;
		try {
			list = empRoleService.show();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return list;
	}
	
	@RequestMapping("/updateEmpRole")
	public @ResponseBody Map<String, String>  updateEmpRole(Integer id,String checkedStr){
		boolean b = empRoleService.updateEmpRoles(id, checkedStr);
		Map<String, String> map = new HashMap<>();
		if (b) {
			map.put("msg", "修改成功");
		}else{
			map.put("msg", "修改失败");
		}
		return map;
	}
	
	/**
	 * 显示当前角色菜单
	 * @return
	 */
	@RequestMapping("/empMenuList")
	public @ResponseBody Menu empMenuList(Integer empId) {
		Menu empMenus = empRoleService.readEmpMenus(empId);
		return empMenus;
	}
	
}
