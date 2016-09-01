package com.zhinengshe.dao.classes;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhinengshe.dao.basedao.IBaseMapper;
import com.zhinengshe.pojo.classes.Classes;
import com.zhinengshe.pojo.classes.ClassesExample;
import com.zhinengshe.pojo.student.Student;

@Repository
public interface ClassesMapper extends IBaseMapper<Classes, ClassesExample> {

	// 分页结果集查询
	List<Student> selectByPage(Classes classes);

	// 分页总记录条数查询
	int selectTotalCount(Classes classes);

	int countByExample(ClassesExample example);

	int deleteByExample(ClassesExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Classes record);

	int insertSelective(Classes record);

	List<Classes> selectByExample(ClassesExample example);

	Classes selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Classes record, @Param("example") ClassesExample example);

	int updateByExample(@Param("record") Classes record, @Param("example") ClassesExample example);

	int updateByPrimaryKeySelective(Classes record);

	int updateByPrimaryKey(Classes record);
}