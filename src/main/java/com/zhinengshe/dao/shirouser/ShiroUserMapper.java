package com.zhinengshe.dao.shirouser;

import java.util.Set;

import com.zhinengshe.pojo.shirouser.ShiroUser;

public interface ShiroUserMapper {
	
	/**
	 * 通过用户名查询user
	 * @param username
	 * @return ShiroUser
	 */
    ShiroUser findUserByUsername(String username);

    /**
     * 通过用户名查询roles
     * @param username
     * @return roleSet
     */
    Set<String> findRoles(String username);

    /**
     * 通过用户名获取权限列表
     * @param username
     * @return	permissionSet
     */
    Set<String> findPermissions(String username);
    
}