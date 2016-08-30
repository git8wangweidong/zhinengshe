package com.zhinengshe.service.teacher.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.teacher.TeacherMapper;
import com.zhinengshe.pojo.teacher.Teacher;
import com.zhinengshe.pojo.teacher.TeacherExample;
import com.zhinengshe.pojo.teacher.TeacherExample.Criteria;
import com.zhinengshe.service.baseservice.impl.AbstractService;
import com.zhinengshe.service.teacher.ITeacherService;

/**
 * 教师管理实现
 * 
 * @author Administrator
 *
 */
@Service("teacherService")
public class TeacherServiceImpl extends AbstractService<Teacher, TeacherExample> implements ITeacherService {

	

	@Resource
	private TeacherMapper mapper;

	@Autowired
	public void setMapper() {
		super.setBaseMapper(mapper);
	}

	/**
	 * 查询教师
	 */
	@Override
	public List<Teacher> get(Teacher t) {
		// TODO 查询教师

		if (t != null) {

			TeacherExample example = new TeacherExample();
			example.setOrderByClause(" id  desc ");
			Criteria criteria = example.createCriteria();
			String name = t.getName();
			Byte category = t.getCategory();
			Integer id = t.getId();
			
			if (name != null && name.trim().length() > 0) {
				criteria.andNameLike("%" + name + "%");
			}

			if (category != null) {
				criteria.andCategoryEqualTo(category);
			}

			if (id != null) {
				criteria.andIdEqualTo(id);
			}

			List<Teacher> list = mapper.selectByExample(example);

			if (list != null && list.size() > 0) {
				return list;
			}

		}

		return null;
	}

	@Override
	public List<Teacher> list(TeacherExample example) {
		
		
		// TODO Auto-generated method stub
		return super.list(example);
	}
	
	
	
}
