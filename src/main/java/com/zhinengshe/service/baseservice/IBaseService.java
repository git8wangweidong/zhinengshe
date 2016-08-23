package com.zhinengshe.service.baseservice;

import java.util.List;

public interface IBaseService <T, K>{
	
	/**
	 * 添加
	 * @param T
	 * @return boolean
	 */
	Boolean add(T t);
	
	/**
	 * 删除
	 * @param id
	 * @return boolean
	 */
	Boolean del(Integer id);
	
	
	/**
	 * 更新
	 * @param T
	 * @return boolean
	 */
	Boolean update(T t);
	
	/**
	 * 通过Id查询
	 * @param id
	 * @return T
	 */
	T get(Integer id);
	
	/**
	 * 多条件查询
	 * @param id
	 * @return List<T>
	 */
	List<T> get(T t);
	
	/**
	 * 查询所有
	 * @return List<T>
	 */
	List<T> list(K example);

}
