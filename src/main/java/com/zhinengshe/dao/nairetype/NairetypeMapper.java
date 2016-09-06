package com.zhinengshe.dao.nairetype;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhinengshe.dao.basedao.IBaseMapper;
import com.zhinengshe.pojo.nairetype.Nairetype;
import com.zhinengshe.pojo.nairetype.NairetypeExample;
import com.zhinengshe.pojo.student.Student;

public interface NairetypeMapper extends IBaseMapper<Nairetype, NairetypeExample> {

	// 分页结果集查询
	List<Student> selectByPage(Nairetype nairetype);

	// 分页总记录条数查询
	int selectTotalCount(Nairetype nairetype);

	int countByExample(NairetypeExample example);

	int deleteByExample(NairetypeExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Nairetype record);

	int insertSelective(Nairetype record);

	List<Nairetype> selectByExample(NairetypeExample example);

	Nairetype selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Nairetype record, @Param("example") NairetypeExample example);

	int updateByExample(@Param("record") Nairetype record, @Param("example") NairetypeExample example);

	int updateByPrimaryKeySelective(Nairetype record);

	int updateByPrimaryKey(Nairetype record);
}