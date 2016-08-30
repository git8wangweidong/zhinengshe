package com.zhinengshe.service.login.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.teacher.TeacherMapper;
import com.zhinengshe.exception.BusinessException;
import com.zhinengshe.exception.ParameterException;
import com.zhinengshe.pojo.teacher.Teacher;
import com.zhinengshe.pojo.teacher.TeacherExample;
import com.zhinengshe.pojo.teacher.TeacherExample.Criteria;
import com.zhinengshe.service.login.ITeacherLoginService;

/**
 * 教师登陆控制
 * @author Administrator
 */

@Service("teacherLoginService")
public class TeacherLoginImpl implements ITeacherLoginService {

	@Resource
	private TeacherMapper teacherMapper;
	
	private static Logger log= Logger.getLogger(TeacherLoginImpl.class);
	
	/**
	 * 登陆方法
	 * @param username
	 * @param password
	 * @return List<Teacher>
	 */
	public List<Teacher> login(String username, String password)throws ParameterException, Exception{
		
		TeacherExample example = new TeacherExample();
		Criteria criteria = example.createCriteria();
		
		// 判断用户名
		if (username != null && username.trim().length() > 0) {
			criteria.andUsernameEqualTo(username);
			// 判断密码
			if (username != null && username.trim().length() > 0) {
				criteria.andPasswordEqualTo(password);
				// 查询数据库
				List<Teacher> list =null;
				try {
					list = teacherMapper.selectByExample(example);
				} catch (Exception e) {
					log.info("教师登陆查询数据库报错",e);
				}
				if (list != null && list.size() >= 0) {
					return list;
				}
			}
			throw new ParameterException("密码格式错误");
		}
		throw new ParameterException("用户名格式错误");
	}

}
