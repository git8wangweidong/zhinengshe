package com.zhinengshe.service.student.impl;

import java.util.Date;
import java.util.List;

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
	public Pagination list(String name, String username,
									String classes, String tel, Integer pageNo,
										Byte qsstate,Byte stustate, Date registtime)throws Exception
	{
		
		// 创建接收url参数
		StringBuffer params = new StringBuffer();
		
		// 创建student拼接查询条件
		Student student = new Student();
		
		// 判断参数 拼接sql查询条件及url 
		if (name!=null && name.trim().length()>0) {
			params.append("name=").append(name);
			student.setName(name);
		}
		
		if (username!=null && username.trim().length()>0) {
			params.append("&username=").append(username);
			student.setUsername(username);
		}
		
		if (classes!=null && classes.trim().length()>0) {
			params.append("&classes=").append(classes);
			student.setClasses(classes);
		}
		
		if (tel!=null && tel.trim().length()>0) {
			params.append("&tel=").append(tel);
			student.setTel(tel);
		}
		
		if (qsstate!=null && qsstate.toString().trim().length()>0 ) {
			params.append("&qsstate=").append(qsstate);
			student.setQsstate(qsstate);
		}
		
		if (stustate!=null && stustate.toString().trim().length()>0 ) {
			params.append("&stustate=").append(stustate);
			student.setStustate(stustate);
		}
		
		if (registtime!=null) {
			params.append("&registtime=").append(registtime);
			student.setRegisttime(registtime);
		}
		
		// 初始化当前页
		student.setPageNo(Pagination.cpn(pageNo));
		
		// 带条件查询结果集
		List<Student> list = mapper.selectByPage(student);
		// 带条件查询总记录数
		int totalcount = mapper.selectTotalCount(student);
		
		// 初始化分页对象
		Pagination pagination = new Pagination(student.getPageNo(),student.getPageSize(),totalcount, list);
		
		// 拼接分页url
		String url = "/student/list";
		pagination.pageView(url, params.toString());
		
		// 返回结果集
		return pagination;
	}
	

}
