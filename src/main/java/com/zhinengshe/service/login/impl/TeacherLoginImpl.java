package com.zhinengshe.service.login.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhinengshe.dao.teacher.TeacherMapper;
import com.zhinengshe.pojo.teacher.Teacher;
import com.zhinengshe.pojo.teacher.TeacherExample;
import com.zhinengshe.pojo.teacher.TeacherExample.Criteria;
import com.zhinengshe.service.login.ITeacherLoginService;

/**
 * 教师登陆控制
 * 
 * @author Administrator
 */

@Service("teacherLoginService")
public class TeacherLoginImpl implements ITeacherLoginService {

	@Resource
	private TeacherMapper teacherMapper;

	/**
	 * 登陆方法
	 * @param username
	 * @param password
	 * @return List<Teacher>
	 */
	public Teacher login(String username, String password) throws Exception {

		TeacherExample example = new TeacherExample();
		Criteria criteria = example.createCriteria();

		// 判断用户名
		if (username != null && username.trim().length() > 0) {
			criteria.andUsernameEqualTo(username);
			// 判断密码
			if (username != null && username.trim().length() > 0) {
				criteria.andPasswordEqualTo(password);
				// 查询数据库
				List<Teacher> list = teacherMapper.selectByExample(example);
				if (list != null && list.size() >= 0) {
					return list.get(0);
				}
			}
			return null;
		}
		return null;
	}

}
