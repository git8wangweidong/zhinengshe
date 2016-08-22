package com.zhinengshe.service.login.impl;

import java.util.List;

import javax.annotation.Resource;

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

	/**
	 * 登陆方法
	 * @param username
	 * @param password
	 * @return List<Manager>
	 */
	public List<Manager> login(String username, String password) {

		ManagerExample example = new ManagerExample();
		Criteria criteria = example.createCriteria();

		// 判断用户名
		if (username != null && username.trim().length() > 0) {
			criteria.andUsernameEqualTo(username);
			// 判断密码
			if (password != null && password.trim().length() > 0) {
				criteria.andPasswordEqualTo(password);
				// 查询数据库
				List<Manager> list = managerMapper.selectByExample(example);
				if (list == null || list.size() <= 0) {
					return null;
				}
				return list;
			}else {
				throw new ParameterException("");
			}
		}
		return null;
	}

}
