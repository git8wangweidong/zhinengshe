package com.zhinengshe.dao.manager;

import com.zhinengshe.dao.basedao.IBaseMapper;
import com.zhinengshe.pojo.classes.Classes;
import com.zhinengshe.pojo.classes.ClassesExample;
import com.zhinengshe.pojo.manager.Manager;
import com.zhinengshe.pojo.manager.ManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerMapper extends IBaseMapper<Manager, ManagerExample>{
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