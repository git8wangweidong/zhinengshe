package com.zhinengshe.dao.question;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhinengshe.dao.basedao.IBaseMapper;
import com.zhinengshe.pojo.question.Question;
import com.zhinengshe.pojo.question.QuestionExample;
import com.zhinengshe.pojo.student.Student;

public interface QuestionMapper extends IBaseMapper<Question, QuestionExample> {

	// 分页结果集查询
	List<Student> selectByPage(Question question);

	// 分页总记录条数查询
	int selectTotalCount(Question question);

	int countByExample(QuestionExample example);

	int deleteByExample(QuestionExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Question record);

	int insertSelective(Question record);

	List<Question> selectByExample(QuestionExample example);

	Question selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

	int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

	int updateByPrimaryKeySelective(Question record);

	int updateByPrimaryKey(Question record);
}