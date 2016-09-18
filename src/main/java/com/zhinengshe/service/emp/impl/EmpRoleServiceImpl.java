package com.zhinengshe.service.emp.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.emp.EmpMapper;
import com.zhinengshe.dao.emp.EmpRoleMapper;
import com.zhinengshe.dao.menu.MenuMapper;
import com.zhinengshe.dao.role.RoleMapper;
import com.zhinengshe.pojo.emp.Emp;
import com.zhinengshe.pojo.emp.EmpExample;
import com.zhinengshe.pojo.emp.EmpRole;
import com.zhinengshe.pojo.emp.EmpRoleExample;
import com.zhinengshe.pojo.menu.Menu;
import com.zhinengshe.pojo.role.Role;
import com.zhinengshe.pojo.tree.Tree;
import com.zhinengshe.service.baseservice.impl.AbstractService;
import com.zhinengshe.service.emp.IEmpRoleService;

@Service("empRoleService")
public class EmpRoleServiceImpl extends AbstractService<Emp, EmpExample> implements IEmpRoleService {

	@Resource
	private MenuMapper menuMapper;

	@Resource
	private EmpMapper empMapper;

	@Resource
	private RoleMapper roleMapper;

	@Resource
	private EmpRoleMapper empRoleMapper;

	@Autowired
	private void setBaseMapper() {
		super.setBaseMapper(empMapper);
	}

	// 查询用户角色列表
	@Override
	public List<Tree> listEmpRoles(Integer empId) {

		List<Tree> trees = new ArrayList<>();

		Emp empRoles = empMapper.selectEmpRoles(empId); // 查询当前用户的所有角色
		// 查询所有角色
		List<Role> roleList = roleMapper.selectByExample(null);
		for (Role role : roleList) {
			Tree tree = new Tree();
			tree.setId(role.getId());
			tree.setText(role.getName());
			for (Role role1 : empRoles.getRoles()) {
				if (role1.getId().equals(role.getId())) {
					tree.setChecked(true);
				}
			}
			trees.add(tree);
		}
		return trees;
	}

	// 更新用户角色
	@Override
	public boolean updateEmpRoles(Integer empId, String checkedStr) {

		EmpRoleExample example = new EmpRoleExample();
		example.createCriteria().andEmpEidEqualTo(empId);
		empRoleMapper.deleteByExample(example); // 清空当前用户角色信息

		List<EmpRole> empRoles = new ArrayList<>();
		String[] roleIds = checkedStr.split(",");
		for (String roleId : roleIds) {
			EmpRole empRole = new EmpRole();
			empRole.setEmpEid(empId);
			empRole.setRoleId(Integer.valueOf(roleId));
			empRoles.add(empRole);
		}

		int j = empRoleMapper.insertList(empRoles); // 添加角色用户关系

		return j > 0;
	}

	// 根据用户id查询用户权限列表
	@Override
	public List<Menu> getEmpMenus(Integer empId) {

		return menuMapper.getEmpMenusByEmpId(empId);

	}

	/**
	 * 复制菜单
	 * @param menu
	 * @return
	 */
	private Menu copyMenu(Menu menu) {

		Menu m = new Menu();
		m.setIcon(menu.getIcon());
		m.setMenuid(menu.getMenuid());
		m.setMenuname(menu.getMenuname());
		m.setUrl(menu.getUrl());
		m.setMenus(new ArrayList<Menu>());
		return m;
	}

	/**
	 * 读取菜单id
	 */
	public Menu readEmpMenus(Integer empId) {

		List<Menu> menus = menuMapper.getEmpMenusByEmpId(empId);
		Menu menu0 = menuMapper.selectMenuList(0).get(0); // 获得全部的菜单树
		Menu m0 = copyMenu(menu0); // 构建新的根菜单
		// 循环一级菜单
		for (Menu menu1 : menu0.getMenus()) {
			Menu m1 = copyMenu(menu1); // 克隆一级菜单
			for (Menu menu2 : menu1.getMenus()) { // 循环二级菜单
				Menu m2 = copyMenu(menu2);  // 克隆二级菜单
				for (Menu menu3 : menus) {  // 将二级菜单挂到一级菜单下
					if (menu3.getMenuid().equals(menu2.getMenuid())) {
						m1.getMenus().add(m2);
					}
					for (Menu menu4 : menu2.getMenus()) {
						Menu m3 = copyMenu(menu4);  // 循环三级菜单
						for (Menu menu5 : menus) {
							if (menu5.getMenuid().equals(menu4.getMenuid())) {
								m2.getMenus().add(m3);
							}
						}
					}
					if (m2.getMenus().size()>0) { // 判断二级菜单下是否有三级菜单
						m1.getMenus().add(m2);  // 将二级菜单挂到一级菜单下
					}
				}
			}
			if (m1.getMenus().size() > 0) {// 判断一级菜单下是否有二级菜单
				m0.getMenus().add(m1);// 将一级菜单挂到根菜单下
			}
		}
		return m0;
	}
}
