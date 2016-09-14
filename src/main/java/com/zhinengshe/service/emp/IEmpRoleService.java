package com.zhinengshe.service.emp;

import java.util.List;

import com.zhinengshe.pojo.emp.Emp;
import com.zhinengshe.pojo.emp.EmpExample;
import com.zhinengshe.pojo.menu.Menu;
import com.zhinengshe.pojo.tree.Tree;
import com.zhinengshe.service.baseservice.IBaseService;

public interface IEmpRoleService extends IBaseService<Emp, EmpExample> {

	/**
	 * 查询员工角色列表
	 * @param empId
	 * @return
	 */
	List<Tree> listEmpRoles(Integer empId);
	
	/**
	 * 更新用户角色
	 * @param empId
	 * @param checkedStr
	 * @return
	 */
	boolean updateEmpRoles(Integer empId, String checkedStr);
	
	/**
	 * 根据员工id查询权限列表
	 * @param empId
	 * @return
	 */
	List<Menu> getEmpMenus(Integer empId);
	
	/**
	 * 根据员工id读取菜单树
	 * @param empId
	 * @return
	 */
	Menu readEmpMenus(Integer empId);
}
