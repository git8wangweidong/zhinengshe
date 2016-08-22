package com.zhinengshe.dao.questiontype;

import com.zhinengshe.pojo.questiontype.Questiontype;
import com.zhinengshe.pojo.questiontype.QuestiontypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestiontypeMapper {
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