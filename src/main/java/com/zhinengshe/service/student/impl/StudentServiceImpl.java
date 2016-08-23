package com.zhinengshe.service.student.impl;

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

			if (t.getName() != null) {
				String name = t.getName();
				criteria.andNameLike("%" + name + "%");
			}
			if (t.getClasses() != null) {
				criteria.andClassesEqualTo(t.getClasses());

			}
			if (t.getUsername() != null) {
				String username = t.getUsername();
				criteria.andUsernameLike("%" + username + "%");
			}
			if (t.getQsstate() != null) {
				criteria.andQsstateEqualTo(t.getQsstate());
			}
			if (t.getStustate() != null) {
				criteria.andStustateEqualTo(t.getStustate());
			}
			List<Student> list = this.mapper.selectByExample(example);
			return list;
		}

		return null;
	}

	
	/*@Override
	public Boolean add(Student t) {
		// TODO 参数校验-数据格式校验未编写
		if (t != null) {
			if (t.getName() != null && t.getName().trim().length() > 0) {
				if (t.getClasses() != null && t.getClasses().trim().length() > 0) {
					// 时间格式未校验
					if (t.getRegisttime() != null) {
						if (t.getStustate() != null) {
							if (t.getTel() != null) {
								if (t.getQsstate() != null) {
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
				}
			}
		}

		return false;
	}

	@Override
	public Boolean del(Integer id) {
		// TODO Auto-generated method stub
		if (id != null) {
			int i = this.mapper.deleteByPrimaryKey(id);
			return i > 0;
		}
		return false;
	}

	@Override
	public Boolean update(Student t) {
		// TODO 参数校验
		if (t != null) {
			int i = this.mapper.updateByPrimaryKey(t);
			return i > 0;
		}
		return false;
	}
	*/
	
	

}
