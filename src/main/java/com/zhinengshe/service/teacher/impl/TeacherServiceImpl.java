package com.zhinengshe.service.teacher.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.teacher.TeacherMapper;
import com.zhinengshe.pojo.teacher.Teacher;
import com.zhinengshe.pojo.teacher.TeacherExample;
import com.zhinengshe.service.baseservice.impl.AbstractService;
import com.zhinengshe.service.teacher.ITeacherService;
import com.zhinengshe.utlis.pagenation.Pagination;

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

	// TODO 教师分页具体实现
	@Override
	public Pagination list(String name, Byte category, String username ,String tel, Integer pageNo)throws Exception{
		
		
		StringBuffer params = new StringBuffer();
		
		Teacher teacher = new Teacher();
		
		// 拼接查询条件
		if (name !=null && name.trim().length()>0) {
			params.append("name=").append(name);
			teacher.setName(name);
		}
		if (username !=null && username.trim().length()>0) {
			params.append("&username=").append(username);
			teacher.setUsername(username);
			
		}
		if (tel !=null && tel.trim().length()>0) {
			params.append("&tel=").append(tel);
			teacher.setTel(tel);
		}
		if (category !=null && category.toString().trim().length()>0) {
			params.append("&category=").append(category);
			teacher.setCategory(category);
			
		}
		
		teacher.setPageNo(Pagination.cpn(pageNo));  // 设置初始页
		
		// 带条件查询结果集
		List<Teacher> list = mapper.selectByPage(teacher);
		// 查询记录条数
		int totalCount = mapper.selectTotalCount(teacher);
		
		// 初始化pagination 对象
		Pagination pagination = new Pagination(teacher.getPageNo(), teacher.getPageSize(), totalCount, list);
		
		String url = "/teacher/list";
		pagination.pageView(url, params.toString());
		return pagination;
	}

	
}
