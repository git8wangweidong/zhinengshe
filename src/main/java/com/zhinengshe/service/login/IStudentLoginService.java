package com.zhinengshe.service.login;

import com.zhinengshe.pojo.student.Student;

/**
 * 登陆控制
 * @author Administrator
 *
 */
public interface IStudentLoginService {
	
	/**
	 * 登陆方法
	 * @param username
	 * @param password
	 * @return
	 */
	public <T> Student login(String username, String password)throws Exception;

}
