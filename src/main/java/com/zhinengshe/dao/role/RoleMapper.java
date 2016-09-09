package com.zhinengshe.dao.role;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhinengshe.dao.basedao.IBaseMapper;
import com.zhinengshe.pojo.role.Role;
import com.zhinengshe.pojo.role.RoleExample;

public interface RoleMapper extends IBaseMapper<Role, RoleExample>{
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}