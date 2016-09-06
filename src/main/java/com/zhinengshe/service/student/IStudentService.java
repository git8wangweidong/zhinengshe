package com.zhinengshe.service.student;

import java.util.Date;

import com.zhinengshe.pojo.student.Student;
import com.zhinengshe.pojo.student.StudentExample;
import com.zhinengshe.service.baseservice.IBaseService;
import com.zhinengshe.utlis.pagenation.Pagination;

/**
 * 学生管理
 * @author Administrator
 *
 */
public interface IStudentService extends IBaseService<Student, StudentExample>{

	/**
	 * 学生列表分页
	 * @param name 姓名
	 * @param username 用户名
	 * @param classes 班级
	 * @param tel 电话
	 * @param stustate 学生状态
	 * @param registTime 注册时间
	 * @param qsstate 问卷状态
	 * @param pageNo 当前页码
	 * @return 分页对象
	 */
	Pagination list(String name, String username, 
						String classes, String tel,Integer pageNo, 
							Byte qsstate,Byte stustate, Date registTime)throws Exception;
}
