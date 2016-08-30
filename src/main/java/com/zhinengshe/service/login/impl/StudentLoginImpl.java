package com.zhinengshe.service.login.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.student.StudentMapper;
import com.zhinengshe.exception.ParameterException;
import com.zhinengshe.pojo.student.Student;
import com.zhinengshe.pojo.student.StudentExample;
import com.zhinengshe.pojo.student.StudentExample.Criteria;
import com.zhinengshe.service.login.IStudentLoginService;

/**
 * 学生登陆控制
 * @author Administrator
 */

@Service("studentLoginService")
public class StudentLoginImpl implements IStudentLoginService {

		@Resource
		private StudentMapper studentMapper;
		
		private static Logger log = Logger.getLogger(StudentLoginImpl.class);
		
		/**
		 * 登陆方法
		 * @param username
		 * @param password
		 * @return List<Student>
		 */
		public List<Student> login(String username, String password) throws ParameterException, Exception{
			
			StudentExample example = new StudentExample();
			Criteria criteria = example.createCriteria();
			
			
			// 判断用户名
			if (username != null && username.trim().length() > 0) {
				criteria.andUsernameEqualTo(username);
				// 判断密码
				if (username != null && username.trim().length() > 0) {
					criteria.andPasswordEqualTo(password);
					// 查询数据库
					List<Student> list = null;
					try {
						list = studentMapper.selectByExample(example);
					} catch (Exception e) {
						log.info("学生登陆查询数据库异常", e);
					}
					if (list == null || list.size()<= 0) {
						return list;
					}
				}
				throw new ParameterException("密码格式错误");
			}
			throw new ParameterException("账号格式错误");
		
	}

}
