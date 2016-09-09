package com.zhinengshe.service.menu.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.menu.MenuMapper;
import com.zhinengshe.pojo.menu.Menu;
import com.zhinengshe.pojo.menu.MenuExample;
import com.zhinengshe.service.baseservice.impl.AbstractService;
import com.zhinengshe.service.menu.IMenuService;

@Service("menuService")
public class MenuServiceImpl extends AbstractService<Menu, MenuExample> implements IMenuService {

  @Resource
  private MenuMapper mapper;
  
  @Autowired
  private void setBaseMapper(){
	  super.setBaseMapper(mapper);
  }
	@Override
	public List<Menu> listMenus(Integer menuId) {
		
		List<Menu> list = mapper.selectMenuList(menuId);
		
		return list;
	}
  
  
}
