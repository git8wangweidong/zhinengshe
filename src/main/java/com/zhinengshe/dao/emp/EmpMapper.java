package com.zhinengshe.dao.emp;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhinengshe.dao.basedao.IBaseMapper;
import com.zhinengshe.pojo.emp.Emp;
import com.zhinengshe.pojo.emp.EmpExample;

public interface EmpMapper extends IBaseMapper<Emp, EmpExample>{
	
	/**
	 * 查询员工权限列表
	 * @param empId
	 * @return
	 */
	Emp selectEmpRoles(Integer empId);
	
    int countByExample(EmpExample example);

    int deleteByExample(EmpExample example);

    int deleteByPrimaryKey(Integer eid);

    int insert(Emp record);

    int insertSelective(Emp record);

    List<Emp> selectByExample(EmpExample example);

    Emp selectByPrimaryKey(Integer eid);

    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}