package com.zhinengshe.service.baseservice;

import java.util.Date;
import java.util.List;

import com.zhinengshe.utlis.pagenation.Pagination;

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
	 * 教师列表分页
	 * @param name 姓名
	 * @param category 类别
	 * @param username 用户名
	 * @param tel 电话
	 * @param pageNo 当前页码
	 * @return 分页对象
	 */
	Pagination list(String name, Byte category, String username ,String tel, Integer pageNo);
	
	
	/**
	 * 学生列表分页
	 * @param name 姓名
	 * @param username 用户名
	 * @param classes 班级
	 * @param tel 电话
	 * @param stustate 学生状态
	 * @param registTime 注册时间
	 * @param qsstate 问卷状态
	 * @param pageNo 当前页码
	 * @return 分页对象
	 */
	Pagination list(String name, String username, String classes, String tel,Byte stustate, Date registTime,Byte qsstate, Integer pageNo);

}
