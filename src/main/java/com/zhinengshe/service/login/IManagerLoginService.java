package com.zhinengshe.service.login;

import java.util.List;

import com.zhinengshe.exception.ParameterException;
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
	public List<Manager> login(String username, String password)throws ParameterException,Exception;

}
