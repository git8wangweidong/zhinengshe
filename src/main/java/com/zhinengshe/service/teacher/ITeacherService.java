package com.zhinengshe.service.teacher;

import com.zhinengshe.pojo.teacher.Teacher;
import com.zhinengshe.pojo.teacher.TeacherExample;
import com.zhinengshe.service.baseservice.IBaseService;
import com.zhinengshe.utlis.pagenation.Pagination;

/**
 * 教师操作
 * @author Administrator
 *
 */

public interface ITeacherService extends IBaseService<Teacher, TeacherExample>{
	
	/**
	 * 教师列表分页
	 * @param name 姓名
	 * @param category 类别
	 * @param username 用户名
	 * @param tel 电话
	 * @param pageNo 当前页码
	 * @return 分页对象
	 */
	Pagination list(String name, Byte category, String username ,String tel, Integer pageNo)throws Exception;
}
