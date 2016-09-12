package com.zhinengshe.service.role.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.menu.MenuMapper;
import com.zhinengshe.dao.role.RoleMapper;
import com.zhinengshe.pojo.menu.Menu;
import com.zhinengshe.pojo.role.Role;
import com.zhinengshe.pojo.role.RoleExample;
import com.zhinengshe.pojo.tree.Tree;
import com.zhinengshe.service.baseservice.impl.AbstractService;
import com.zhinengshe.service.role.IRoleService;

@Service("roleService")
public class RoleServiceImpl extends AbstractService<Role, RoleExample> implements IRoleService {

	@Resource
	private RoleMapper roleMapper;
	
	@Resource
	private MenuMapper menuMapper;
	
	@Autowired
	public void setBaseMapper(){
		super.setBaseMapper(roleMapper);
	}
	
	/**
	 * 读取菜单树
	 */
	@Override
	public List<Tree> readRoleMenus(Integer roleId){
		
		// 构建tree集合数据
		List<Tree> trees = new ArrayList<>();
		
		// 获取角色用户有的权限
		List<Menu> menus = roleMapper.selectRoleMenu(roleId).getMenus();
		
		// 获取所有数据
		List<Menu> menu0= menuMapper.selectMenuList(0);
		for (Menu menu1 : menu0.get(0).getMenus()){
			// 构建一级树菜单
			Tree tree1 = new Tree();
			tree1.setId(menu1.getMenuid());
			tree1.setText(menu1.getMenuname());
			for (Menu menu2 : menu1.getMenus()){
				// 构建二级树菜单
				Tree tree2 = new Tree();
				tree2.setId(menu2.getMenuid());
				tree2.setText(menu2.getMenuname());
				tree1.getChildren().add(tree2); // 将二级菜单挂到一级菜单下
				for (Menu menu : menus) {
					if (menu.getMenuid().equals(menu2.getMenuid())) {
						tree2.setChecked(true);  // 判断相等 勾选
					}
				}
			}
			trees.add(tree1);
		}
		return trees;
	}

	
	@Override
	public boolean updateRoleMenus(Integer id, String checkedStr) {
		
		Role role = roleMapper.selectByPrimaryKey(id);
		role.setMenus(new ArrayList<Menu>()); // 角色权限置空
		
		// 获取菜单ids
		String[] menuIds = checkedStr.split(",");
		for (String menuId : menuIds) {
			Menu menu = menuMapper.selectByPrimaryKey(Integer.parseInt(menuId));
			role.getMenus().add(menu); 
		}
		return false;
	}
	
}
