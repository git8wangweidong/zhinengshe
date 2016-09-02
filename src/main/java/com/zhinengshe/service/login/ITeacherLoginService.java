package com.zhinengshe.service.login;

import java.util.List;

import com.zhinengshe.exception.ParameterException;

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
	public <T> List<T> login(String username, String password)throws ParameterException, Exception;

}
