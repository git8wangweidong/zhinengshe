package com.zhinengshe.service.student.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.student.StudentMapper;
import com.zhinengshe.pojo.student.Student;
import com.zhinengshe.pojo.student.StudentExample;
import com.zhinengshe.pojo.student.StudentExample.Criteria;
import com.zhinengshe.service.baseservice.impl.AbstractService;
import com.zhinengshe.service.student.IStudentService;
import com.zhinengshe.utlis.pagenation.Pagination;

/**
 * 学生管理实现
 * 
 * @author Administrator
 *
 */
@Service("stuService")
public class StudentServiceImpl extends AbstractService<Student, StudentExample> implements IStudentService {

	@Resource
	private StudentMapper mapper;

	@Autowired
	public void setMapper(StudentMapper mapper) {
		super.setBaseMapper(mapper);
	}


	@Override
	public List<Student> get(Student t) {
		// TODO 参数校验

		StudentExample example = new StudentExample();
		if (t != null) {
			Criteria criteria = example.createCriteria();

			if (t.getName() != null && t.getName().trim().length()>0) {
				String name = t.getName();
				criteria.andNameLike("%" + name + "%");
			}
			if (t.getClasses() != null && t.getClasses().trim().length()>0) {
				criteria.andClassesEqualTo(t.getClasses());

			}
			if (t.getUsername() != null && t.getUsername().trim().length()>0) {
				String username = t.getUsername();
				criteria.andUsernameLike("%" + username + "%");
			}
			if (t.getQsstate() != null && t.getQsstate().toString().trim().length()>0) {
				criteria.andQsstateEqualTo(t.getQsstate());
			}
			if (t.getStustate() != null && t.getStustate().toString().trim().length()>0) {
				criteria.andStustateEqualTo(t.getStustate());
			}
			List<Student> list = this.mapper.selectByExample(example);
			return list;
		}

		return null;
	}


	@Override
	public Pagination list(String name, Byte category, String username, String tel, Integer pageNo) {
		// TODO Auto-generated method stub
		return null;
	}


}
