package com.zhinengshe.dao.student;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhinengshe.dao.basedao.IBaseMapper;
import com.zhinengshe.pojo.student.Student;
import com.zhinengshe.pojo.student.StudentExample;

@Repository
public interface StudentMapper extends IBaseMapper<Student, StudentExample>{
	
	
	// 分页结果集查询
	List<Student> selectByPage(Student student);
	
	// 分页总记录条数查询
	int selectTotalCount(Student student);
	
	int countByExample(StudentExample example);

	int deleteByExample(StudentExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Student record);

	int insertSelective(Student record);

	List<Student> selectByExample(StudentExample example);

	Student selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

	int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

	int updateByPrimaryKeySelective(Student record);

	int updateByPrimaryKey(Student record);
}