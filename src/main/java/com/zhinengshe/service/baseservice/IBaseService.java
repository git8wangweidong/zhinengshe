package com.zhinengshe.service.baseservice;

import java.io.Serializable;

public interface IBaseService <T, K extends Serializable>{
	
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
	
}
