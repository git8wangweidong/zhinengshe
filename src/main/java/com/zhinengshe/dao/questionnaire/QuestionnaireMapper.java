package com.zhinengshe.dao.questionnaire;

import com.zhinengshe.dao.basedao.IBaseMapper;
import com.zhinengshe.pojo.questionnaire.Questionnaire;
import com.zhinengshe.pojo.questionnaire.QuestionnaireExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionnaireMapper extends IBaseMapper<Questionnaire, QuestionnaireExample>{
	
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