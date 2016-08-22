package com.zhinengshe.service.baseservice;

import java.io.Serializable;
import java.util.List;

public interface IBaseService <T, K extends Serializable>{
	
	/**
	 * 添加
	 * @param T
	 * @return
	 */
	Boolean add(T t);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	Boolean del(Integer id);
	
	
	/**
	 * 更新
	 * @param T
	 * @return
	 */
	Boolean update(T t);
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	List<T> get(T t);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<T> list();

}
