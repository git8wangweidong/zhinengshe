package com.zhinengshe.dao.question;

import com.zhinengshe.dao.basedao.IBaseMapper;
import com.zhinengshe.pojo.question.Question;
import com.zhinengshe.pojo.question.QuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionMapper extends IBaseMapper<Question, QuestionExample> {
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