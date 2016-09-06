package com.zhinengshe.service.login;

import com.zhinengshe.pojo.teacher.Teacher;

/**
 * 登陆控制
 * @author Administrator
 *
 */
public interface ITeacherLoginService {
	
	/**
	 * 登陆方法
	 * @param username
	 * @param password
	 * @return
	 */
	public <T> Teacher login(String username, String password)throws Exception;

}
