package com.zhinengshe.shiro.realm;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.zhinengshe.dao.shirouser.ShiroUserMapper;
import com.zhinengshe.pojo.manager.Manager;
import com.zhinengshe.pojo.shirouser.ShiroUser;
import com.zhinengshe.service.login.IManagerLoginService;

public class MyShiroRealm extends AuthorizingRealm {

	// 注入登陆service
	@Resource
	private IManagerLoginService loginService;
	
	@Resource
	private ShiroUserMapper mapper;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("执行授权");

		// 获得用户名 通过用户名查询角色及角色权限
		String username = principals.getPrimaryPrincipal().toString();
		Set<String> roles = mapper.findRoles(username);
		Set<String> permissions = mapper.findPermissions(username);
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(); // 未执行任何授权
		info.setRoles(roles);
		info.setStringPermissions(permissions);
		
		return info;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("执行登陆验证");

		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token; // 获取用户token

		// 获取token中的用户名密码 调用登陆service
		
		String username = usernamePasswordToken.getUsername();
		String password = String.valueOf(usernamePasswordToken.getPassword());
		
		 //获取用户账号
		Manager manager = null;
		try {
			manager = this.loginService.login(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//将查询到的用户账号和密码存放到 authenticationInfo用于后面的权限判断。第三个参数传入realName。
		if (manager != null) {
			return new SimpleAuthenticationInfo(manager.getUsername(),manager.getPassword(),getName());
		}else {
			return null;
		}

	}

}
