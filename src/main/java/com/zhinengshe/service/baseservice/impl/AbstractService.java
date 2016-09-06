package com.zhinengshe.service.baseservice.impl;

import java.io.Serializable;
import java.util.List;

import com.zhinengshe.dao.basedao.IBaseMapper;
import com.zhinengshe.service.baseservice.IBaseService;

public abstract class AbstractService<T, K extends Serializable> implements IBaseService<T, K> {

	private IBaseMapper<T, K> baseMapper;

	public void setBaseMapper(IBaseMapper<T, K> baseMapper) {
		this.baseMapper=baseMapper;
		
	}
	
	/**
	 * 添加
	 * @param t	
	 * @return
	 */
	@Override
	public Boolean add(T t) throws Exception{
		int i = baseMapper.insert(t);
		return i>0;
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@Override
	public Boolean del(Integer id)throws Exception{
		int i = baseMapper.deleteByPrimaryKey(id);
		return i>0;
	}

	/**
	 * 更新
	 * @param t
	 * @return
	 */
	@Override
	public Boolean update(T t)throws Exception{
		int i = baseMapper.updateByPrimaryKey(t);
		return i>0;
	}

	/**
	 * 根据Id查询
	 */
	@Override
	public T get(Integer id)throws Exception{
		return baseMapper.selectByPrimaryKey(id);
	}

	/**
	 * 查询所有
	 */
	@Override
	public List<T> show() throws Exception {
		
		return baseMapper.selectByExample(null);
	}
	

}
