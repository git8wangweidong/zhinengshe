package com.zhinengshe.service.login;

import java.util.List;

import com.zhinengshe.pojo.teacher.Teacher;

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
	public <T> List<T> login(String username, String password);

}
