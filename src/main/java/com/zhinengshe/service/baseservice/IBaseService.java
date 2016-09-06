package com.zhinengshe.service.baseservice;

import java.io.Serializable;
import java.util.List;

public interface IBaseService <T, K extends Serializable>{
	
	/**
	 * 添加
	 * @param t
	 * @return
	 * @throws Exception
	 */
	Boolean add(T t) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @return boolean
	 * @throws Exception
	 */
	Boolean del(Integer id)throws Exception;
	
	
	/**
	 * 更新
	 * @param T
	 * @return boolean
	 * @throws Exception
	 */
	Boolean update(T t)throws Exception;
	
	/**
	 * 通过Id查询
	 * @param id
	 * @return T
	 * @throws Exception
	 */
	T get(Integer id)throws Exception;
	
	/**
	 * 展示所有
	 * @return
	 * @throws Exception
	 */
	List<T> show()throws Exception;
	
}
