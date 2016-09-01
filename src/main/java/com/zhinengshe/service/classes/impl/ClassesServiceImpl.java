package com.zhinengshe.service.classes.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.classes.ClassesMapper;
import com.zhinengshe.pojo.classes.Classes;
import com.zhinengshe.pojo.classes.ClassesExample;
import com.zhinengshe.pojo.classes.ClassesExample.Criteria;
import com.zhinengshe.pojo.student.Student;
import com.zhinengshe.service.baseservice.impl.AbstractService;
import com.zhinengshe.service.classes.IClassesService;
import com.zhinengshe.utlis.pagenation.Pagination;

@Transactional
@Service("classesService")
public class ClassesServiceImpl extends AbstractService<Classes, ClassesExample> implements IClassesService {

	
	@Resource
	private ClassesMapper mapper;

	@Autowired
	public void setBaseMapper(){
		super.setBaseMapper(mapper);
	}

	// TODO  分页展示班级
	@Override
	public Pagination list(String name, String course, Integer totalcount, Integer pageNo, Byte state, Date starttime,
			Date endtime) {
		
		StringBuffer params = new StringBuffer();
		Classes classes = new Classes();
		
		if (name!=null && name.trim().length()>0) {
			params.append("name=").append(name);
			classes.setName(name);
		}
		if (course!=null && course.trim().length()>0) {
			params.append("&course=").append(course);
			classes.setCourse(course);
			
		}
		if (state!=null && state.toString().trim().length()>0) {
			params.append("&state=").append(state);
			classes.setState(state);
		}
		if (starttime!=null) {
			params.append("&starttime=").append(starttime);
			classes.setStarttime(starttime);
		}
		if (endtime!=null) {
			params.append("&endtime=").append(endtime);
			classes.setEndtime(endtime);
		}
		
		// 初始化当前页
		classes.setPageNo(Pagination.cpn(pageNo));
		
		// 根据条件查询结果集
		List<Student> list = mapper.selectByPage(classes);
		int count = mapper.selectTotalCount(classes);
		
		Pagination pagination = new Pagination(classes.getPageNo(), classes.getPageSize(), count, list);
		
		String url = "/classes/list";
		pagination.pageView(url, params.toString());
		
		return pagination;
		
	}



}
