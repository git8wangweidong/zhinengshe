package com.zhinengshe.service.student.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.student.StudentMapper;
import com.zhinengshe.pojo.student.Student;
import com.zhinengshe.pojo.student.StudentExample;
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
	
	// TODO 学生分页具体实现
	@Override
	public Pagination list(String name, String username, String classes, String tel, Byte stustate, Date registTime,
			Byte qsstate, Integer pageNo) {
		return null;
	}

}
