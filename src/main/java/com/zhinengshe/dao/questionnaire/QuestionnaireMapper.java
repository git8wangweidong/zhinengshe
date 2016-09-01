package com.zhinengshe.dao.questionnaire;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhinengshe.dao.basedao.IBaseMapper;
import com.zhinengshe.pojo.questionnaire.Questionnaire;
import com.zhinengshe.pojo.questionnaire.QuestionnaireExample;
import com.zhinengshe.pojo.student.Student;

public interface QuestionnaireMapper extends IBaseMapper<Questionnaire, QuestionnaireExample> {

	// 分页结果集查询
	List<Student> selectByPage(Questionnaire questionnaire);

	// 分页总记录条数查询
	int selectTotalCount(Questionnaire questionnaire);

	int countByExample(QuestionnaireExample example);

	int deleteByExample(QuestionnaireExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Questionnaire record);

	int insertSelective(Questionnaire record);

	List<Questionnaire> selectByExample(QuestionnaireExample example);

	Questionnaire selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Questionnaire record, @Param("example") QuestionnaireExample example);

	int updateByExample(@Param("record") Questionnaire record, @Param("example") QuestionnaireExample example);

	int updateByPrimaryKeySelective(Questionnaire record);

	int updateByPrimaryKey(Questionnaire record);
}