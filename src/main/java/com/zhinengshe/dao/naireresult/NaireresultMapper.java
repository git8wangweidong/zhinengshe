package com.zhinengshe.dao.naireresult;

import com.zhinengshe.pojo.naireresult.IdListAndPeriods;
import com.zhinengshe.pojo.naireresult.Naireresult;
import com.zhinengshe.pojo.naireresult.NaireresultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NaireresultMapper {
	
	/**
	 * 求问卷简答题结果
	 * @param idListAndPeriods
	 * @return
	 */
	List<Naireresult> selectTextByIdListAndPeriods(IdListAndPeriods idListAndPeriods);
	/**
	 * 求问卷打分题结果的平均值
	 * @param idListAndPeriods
	 * @return
	 */
	List<Naireresult> selectAvgByIdListAndPeriods(IdListAndPeriods idListAndPeriods);
	
	/**
	 * 批量添加数据
	 * @param naireresults
	 * @return
	 */
	int insertList(List<Naireresult> naireresults);
	
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