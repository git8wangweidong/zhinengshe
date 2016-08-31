package com.zhinengshe.service.student;

import java.util.List;

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

	Pagination list(Student student);

}
