package com.zhinengshe.dao.naireresult;

import com.zhinengshe.pojo.naireresult.Naireresult;
import com.zhinengshe.pojo.naireresult.NaireresultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NaireresultMapper {
    int countByExample(NaireresultExample example);

    int deleteByExample(NaireresultExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Naireresult record);

    int insertSelective(Naireresult record);

    List<Naireresult> selectByExample(NaireresultExample example);

    Naireresult selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Naireresult record, @Param("example") NaireresultExample example);

    int updateByExample(@Param("record") Naireresult record, @Param("example") NaireresultExample example);

    int updateByPrimaryKeySelective(Naireresult record);

    int updateByPrimaryKey(Naireresult record);
}