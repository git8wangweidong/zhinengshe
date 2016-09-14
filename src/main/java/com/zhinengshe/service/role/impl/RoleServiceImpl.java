package com.zhinengshe.service.role.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.menu.MenuMapper;
import com.zhinengshe.dao.role.RoleMapper;
import com.zhinengshe.dao.role.RoleMenuMapper;
import com.zhinengshe.pojo.menu.Menu;
import com.zhinengshe.pojo.role.Role;
import com.zhinengshe.pojo.role.RoleExample;
import com.zhinengshe.pojo.role.RoleMenu;
import com.zhinengshe.pojo.role.RoleMenuExample;
import com.zhinengshe.pojo.tree.Tree;
import com.zhinengshe.service.baseservice.impl.AbstractService;
import com.zhinengshe.service.role.IRoleMenuService;

@Service("roleService")
public class RoleServiceImpl extends AbstractService<Role, RoleExample> implements IRoleMenuService {

	@Resource
	private RoleMenuMapper roleMenuMapper;

	@Resource
	private RoleMapper roleMapper;

	@Resource
	private MenuMapper menuMapper;

	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(roleMapper);
	}

	/**
	 * 读取菜单树
	 */
	@Override
	public List<Tree> readRoleMenus(Integer roleId) {

		// 构建tree集合数据
		List<Tree> trees = new ArrayList<>();

		// 获取角色用户有的权限
		List<Menu> menus = roleMapper.selectRoleMenu(roleId).getMenus();

		// 获取所有数据
		List<Menu> menu0 = menuMapper.selectMenuList(0);
		for (Menu menu1 : menu0.get(0).getMenus()) {
			// 构建一级树菜单
			Tree tree1 = new Tree();
			tree1.setId(menu1.getMenuid());
			tree1.setText(menu1.getMenuname());
			for (Menu menu2 : menu1.getMenus()) {
				// 构建二级树菜单
				Tree tree2 = new Tree();
				tree2.setId(menu2.getMenuid());
				tree2.setText(menu2.getMenuname());
				tree1.getChildren().add(tree2); // 将二级菜单挂到一级菜单下
				for (Menu menu : menus) {
					if (menu.getMenuid().equals(menu2.getMenuid())) {
						tree2.setChecked(true); // 判断相等 勾选
					}
				}
				for (Menu menu3 : menu2.getMenus()) {
					Tree tree3 = new Tree();
					tree3.setId(menu3.getMenuid());
					tree3.setText(menu3.getMenuname());
					tree2.getChildren().add(tree3);
					for (Menu menu4 : menus) {
						if (menu4.getMenuid().equals(menu3.getMenuid())) {
							tree3.setChecked(true);
						}
					}
				}
			}
			trees.add(tree1);
		}
		return trees;
	}

	@Override
	public boolean updateRoleMenus(Integer id, String checkedStr) {
		
		RoleMenuExample example = new RoleMenuExample();
		example.createCriteria().andRoleIdEqualTo(id);
		roleMenuMapper.deleteByExample(example);  // 清空当前角色权限关系
		
		// 声明list接收roleMenu
		List<RoleMenu> roleMenus  = new ArrayList<>();
		
		String[] menuIds = checkedStr.split(",");
		for (String menuId : menuIds) {
			RoleMenu roleMenu = new RoleMenu();
			roleMenu.setRoleId(id);
			roleMenu.setMenuId(Integer.parseInt(menuId));
			roleMenus.add(roleMenu);
		}

		int i = roleMenuMapper.insertList(roleMenus); // 添加角色权限关系
		return i>0;
	}	
}
