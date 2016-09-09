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
import com.zhinengshe.service.menu.IMenuService;
import com.zhinengshe.service.role.IRoleService;
import com.zhinengshe.test.basetest.BaseTest;

public class MenuTests extends BaseTest{

	@Autowired
	private IMenuService menuService;
	
	@Autowired
	private IRoleService roleService;
	
	@Test
	public void testSelectMenus() throws IllegalAccessException, InvocationTargetException, IntrospectionException{
		List<Menu> list = menuService.listMenus(0);
		System.out.println(list.size());
		for (Menu menu : list) {
			System.out.println(JSON.toJSONString(menu,SerializerFeature.DisableCircularReferenceDetect));
		}
	}
	@Test
	public void readMenus(){
		List<Tree> list = roleService.readRoleMenus();
		
		System.out.println(list.size());
		for (Tree tree : list) {
			System.out.println(JSON.toJSONString(tree));
		}
	}
}
