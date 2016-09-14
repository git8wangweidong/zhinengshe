package com.zhinengshe.test;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zhinengshe.pojo.menu.Menu;
import com.zhinengshe.pojo.tree.Tree;
import com.zhinengshe.service.emp.IEmpRoleService;
import com.zhinengshe.service.menu.IMenuService;
import com.zhinengshe.service.role.IRoleMenuService;
import com.zhinengshe.test.basetest.BaseTest;

public class MenuTests extends BaseTest {

	@Autowired
	private IMenuService menuService;

	@Autowired
	private IRoleMenuService roleService;

	@Autowired
	private IEmpRoleService empService;

	@Test
	public void testSelectMenus() throws IllegalAccessException, InvocationTargetException, IntrospectionException {
		List<Menu> list = menuService.listMenus(500);
		System.out.println(list.size());
		for (Menu menu : list) {
			System.out.println(JSON.toJSONString(menu, SerializerFeature.DisableCircularReferenceDetect));
		}
	}

	@Test
	public void readMenus() {
		List<Tree> list = roleService.readRoleMenus(1);

		System.out.println(list.size());
		for (Tree tree : list) {
			System.out.println(JSON.toJSONString(tree));
		}
	}

	@Test
	public void updateRoleMenus() {
		Integer id = 1;
		String checkedStr = "100,200";
		boolean b = roleService.updateRoleMenus(id, checkedStr);
		System.out.println(b);

	}

	@Test
	public void listEmpRoles() {

		List<Tree> empRoles = empService.listEmpRoles(1);
		for (Tree tree : empRoles) {
			System.out.println(JSON.toJSONString(tree));
		}
	}

	@Test
	public void updateEmpRoles() {
		Integer id = 1;
		String checkedStr = "1,2";
		boolean b = empService.updateEmpRoles(id, checkedStr);
		System.out.println(b);

	}

	@Test
	public void getEmpMenus() {

		List<Menu> empMenus = empService.getEmpMenus(1);
		for (Menu menu : empMenus) {
			System.out.println(JSON.toJSONString(menu));

		}
	}

	@Test
	public void readEmpMenus() {

		Menu menu = empService.readEmpMenus(1);
		System.out.println(JSON.toJSONString(menu));

	}

}
