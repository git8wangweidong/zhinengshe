package com.zhinengshe.dao.manager;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhinengshe.dao.basedao.IBaseMapper;
import com.zhinengshe.pojo.manager.Manager;
import com.zhinengshe.pojo.manager.ManagerExample;
import com.zhinengshe.pojo.student.Student;

@Repository
public interface ManagerMapper extends IBaseMapper<Manager, ManagerExample> {

	// 分页结果集查询
	List<Student> selectByPage(Manager manager);

	// 分页总记录条数查询
	int selectTotalCount(Manager manager);

	int countByExample(ManagerExample example);

	int deleteByExample(ManagerExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Manager record);

	int insertSelective(Manager record);

	List<Manager> selectByExample(ManagerExample example);

	Manager selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Manager record, @Param("example") ManagerExample example);

	int updateByExample(@Param("record") Manager record, @Param("example") ManagerExample example);

	int updateByPrimaryKeySelective(Manager record);

	int updateByPrimaryKey(Manager record);
}