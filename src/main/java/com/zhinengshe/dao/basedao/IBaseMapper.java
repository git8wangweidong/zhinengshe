package com.zhinengshe.dao.basedao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IBaseMapper <T,K> {
	
	
	int countByExample(K example);

    int deleteByExample(K example);

    int deleteByPrimaryKey(Integer id);

    int insert(T t);

    int insertSelective(T t);

    List<T> selectByExample(K example);

    T selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("t") T t, @Param("example") K example);

    int updateByExample(@Param("t") T t, @Param("example") K example);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

}
