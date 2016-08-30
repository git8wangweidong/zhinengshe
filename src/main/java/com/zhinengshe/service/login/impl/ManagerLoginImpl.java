package com.zhinengshe.service.login.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.manager.ManagerMapper;
import com.zhinengshe.exception.ParameterException;
import com.zhinengshe.pojo.manager.Manager;
import com.zhinengshe.pojo.manager.ManagerExample;
import com.zhinengshe.pojo.manager.ManagerExample.Criteria;
import com.zhinengshe.service.login.IManagerLoginService;

/**
 * 管理员登陆控制
 * @author Administrator
 *
 */

@Service("managerLoginService")
public class ManagerLoginImpl implements IManagerLoginService {

	@Resource
	private ManagerMapper managerMapper;
	
	private static Logger log = Logger.getLogger(ManagerLoginImpl.class);

	/**
	 * 登陆方法
	 * @param username
	 * @param password
	 * @return List<Manager>
	 */
	public List<Manager> login(String username, String password) throws ParameterException, Exception{

		ManagerExample example = new ManagerExample();
		Criteria criteria = example.createCriteria();

		// 判断用户名
		if (username != null && username.trim().length() > 0) {
			criteria.andUsernameEqualTo(username);
			// 判断密码
			if (password != null && password.trim().length() > 0) {
				criteria.andPasswordEqualTo(password);
				// 查询数据库
				List<Manager> list = null;
				try {
					list = managerMapper.selectByExample(example);
				} catch (Exception e) {
					log.info("管理员登陆查询数据库异常", e);
				}
				if (list != null && list.size() > 0) {
					return list;
				}
			}
			throw new ParameterException("密码格式不正确");
		}
		throw new ParameterException("账号格式不正确");
	}

}
