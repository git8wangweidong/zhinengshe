package com.zhinengshe.service.role;

import java.util.List;

import com.zhinengshe.pojo.role.Role;
import com.zhinengshe.pojo.role.RoleExample;
import com.zhinengshe.pojo.tree.Tree;
import com.zhinengshe.service.baseservice.IBaseService;

public interface IRoleService extends IBaseService<Role, RoleExample> {

	/**
	 * 读取角色菜单
	 * @return
	 */
	List<Tree> readRoleMenus(Integer roleId);
	
	/**
	 * 更新角色菜单
	 * @param id
	 * @param checkedStr
	 * @return
	 */
	boolean updateRoleMenus(Integer id,String checkedStr);
	
}
