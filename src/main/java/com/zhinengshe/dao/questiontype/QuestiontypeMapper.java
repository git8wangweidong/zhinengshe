package com.zhinengshe.dao.questiontype;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhinengshe.dao.basedao.IBaseMapper;
import com.zhinengshe.pojo.questiontype.Questiontype;
import com.zhinengshe.pojo.questiontype.QuestiontypeExample;
import com.zhinengshe.pojo.student.Student;

@Repository
public interface QuestiontypeMapper extends IBaseMapper<Questiontype, QuestiontypeExample> {

	// 分页结果集查询
	List<Student> selectByPage(Questiontype questiontype);

	// 分页总记录条数查询
	int selectTotalCount(Questiontype questiontype);

	int countByExample(QuestiontypeExample example);

	int deleteByExample(QuestiontypeExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Questiontype record);

	int insertSelective(Questiontype record);

	List<Questiontype> selectByExample(QuestiontypeExample example);

	Questiontype selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Questiontype record, @Param("example") QuestiontypeExample example);

	int updateByExample(@Param("record") Questiontype record, @Param("example") QuestiontypeExample example);

	int updateByPrimaryKeySelective(Questiontype record);

	int updateByPrimaryKey(Questiontype record);
}