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
	 * 添加教师
	 *//*
	@Override
	public Boolean add(Teacher t) {
		// TODO 参数校验-数据合法性
		if (t != null) {
			if (t.getName() != null) {
				if (t.getCategory() != null) {
					if (t.getTel() != null) {
						if (t.getUsername() != null) {
							if (t.getPassword() != null) {
								int i = this.mapper.insertSelective(t);
								return i > 0;
							}
						}
					}
				}

			}
		}
		return false;
	}

	*//**
	 * 删除教师
	 *//*
	@Override
	public Boolean del(Integer id) {
		// TODO 参数校验
		if (id != null && id instanceof Integer) {

			int i = this.mapper.deleteByPrimaryKey(id);
			return i > 0;
		}

		return false;
	}

	*//**
	 * 更新教师
	 *//*
	@Override
	public Boolean update(Teacher t) {
		// TODO 参数校验 数据是否合法
		if (t != null) {

			int i = this.mapper.updateByPrimaryKey(t);
			return i > 0;
		}

		return false;
	}*/

	/**
	 * 查询教师
	 */
	@Override
	public List<Teacher> get(Teacher t) {
		// TODO 查询教师

		if (t != null) {

			TeacherExample example = new TeacherExample();
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

			List<Teacher> list = this.mapper.selectByExample(example);

			if (list != null && list.size() > 0) {
				return list;
			}

		}

		return null;
	}

}
