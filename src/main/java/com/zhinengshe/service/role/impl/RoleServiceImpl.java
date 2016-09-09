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
	
	
	@Override
	public List<Tree> readRoleMenus() {
		
		// 构建tree集合数据
		List<Tree> trees = new ArrayList<>();
		// 获取所有数据
		List<Menu> menus= menuMapper.selectMenuList(0);
		Menu menu0 = menus.get(0);
		for (Menu menu1 : menu0.getMenus()){
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
			}
			trees.add(tree1);
		}
		return trees;
	}

}
