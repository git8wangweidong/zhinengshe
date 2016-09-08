package com.zhinengshe.test;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zhinengshe.pojo.menu.Menu;
import com.zhinengshe.service.menu.IMenuService;
import com.zhinengshe.test.basetest.BaseTest;

public class MenuTests extends BaseTest{

	@Autowired
	private IMenuService menuService;
	
	@Test
	public void testSelectMenus() throws IllegalAccessException, InvocationTargetException, IntrospectionException{
		List<Menu> list = menuService.listMenus();
		for (Menu menu : list) {
			/*List collection = util.MapUtil.convertCollection(menu.getMenus(), 0);*/
			
			System.out.println(JSON.toJSONString(util.MapUtil.convertCollection(menu.getMenus(), 0),SerializerFeature.DisableCircularReferenceDetect));
		}
	}
}
