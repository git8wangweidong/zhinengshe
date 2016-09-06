package com.zhinengshe.service.login;

import com.zhinengshe.pojo.manager.Manager;

/**
 * 登陆控制
 * @author Administrator
 *
 */
public interface IManagerLoginService {
	
	/**
	 * 登陆方法
	 * @param username
	 * @param password
	 * @return
	 */
	public Manager login(String username, String password)throws Exception;

}
