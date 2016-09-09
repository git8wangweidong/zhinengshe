package com.zhinengshe.service.menu;

import java.util.List;

import com.zhinengshe.pojo.menu.Menu;
import com.zhinengshe.pojo.menu.MenuExample;
import com.zhinengshe.service.baseservice.IBaseService;

public interface IMenuService extends IBaseService<Menu, MenuExample> {

	List<Menu> listMenus(Integer menuId);
}
