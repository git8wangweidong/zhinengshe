package com.zhinengshe.dao.teacher;

import com.zhinengshe.dao.basedao.IBaseMapper;
import com.zhinengshe.pojo.teacher.Teacher;
import com.zhinengshe.pojo.teacher.TeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherMapper extends IBaseMapper<Teacher, TeacherExample>{
	
	/**
	 * 分页查询
	 * @param teacher
	 * @return
	 */
	List<Teacher> selectByPage(Teacher teacher);
	
	/**
	 * 查询总记录条数
	 * @param teacher
	 * @return
	 */
	int selectTotalCount(Teacher teacher);
	
    int countByExample(TeacherExample example);

    int deleteByExample(TeacherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    List<Teacher> selectByExample(TeacherExample example);

    Teacher selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}