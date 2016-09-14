package com.zhinengshe.dao.emp;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhinengshe.dao.basedao.IBaseMapper;
import com.zhinengshe.pojo.emp.EmpRole;
import com.zhinengshe.pojo.emp.EmpRoleExample;

public interface EmpRoleMapper extends IBaseMapper<EmpRole, EmpRoleExample>{
	
	int insertList(List<EmpRole> empRoles);
	
    int countByExample(EmpRoleExample example);

    int deleteByExample(EmpRoleExample example);

    int insert(EmpRole record);

    int insertSelective(EmpRole record);

    List<EmpRole> selectByExample(EmpRoleExample example);

    int updateByExampleSelective(@Param("record") EmpRole record, @Param("example") EmpRoleExample example);

    int updateByExample(@Param("record") EmpRole record, @Param("example") EmpRoleExample example);
}