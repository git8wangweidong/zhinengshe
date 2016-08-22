package com.zhinengshe.service.classes.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.CreateException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.classes.ClassesMapper;
import com.zhinengshe.pojo.classes.Classes;
import com.zhinengshe.pojo.classes.ClassesExample;
import com.zhinengshe.pojo.classes.ClassesExample.Criteria;
import com.zhinengshe.service.baseservice.impl.AbstractService;
import com.zhinengshe.service.classes.IClassesService;

@Transactional
@Service("classesService")
public class ClassesServiceImpl extends AbstractService<Classes, ClassesExample> implements IClassesService {

	
	@Resource
	private ClassesMapper classesMapper;

	@Autowired
	public void setBaseMapper(){
		super.setBaseMapper(classesMapper);
	}

	@Override
	public Boolean add(Classes t) {
		
		if (t!=null) {
			if (t.getCourse()!=null && t.getCourse().trim().length()>0) {
				if (t.getName()!=null && t.getName().trim().length()>0) {
					if (t.getState()!=null && t.getState().toString().trim().length()>0) {
						if (t.getStarttime()!=null) {
							if (t.getEndtime()!=null) {
								if (t.getTotalcount()!=null && t.getTotalcount()>=0) {
									int i = classesMapper.insert(t);
									return i>0;
								}
							}
						}
					}
				}
			}
			
		}
		
		return false;
	}

	/**
	 * 删除
	 */
	@Override
	public Boolean del(Integer id) {
		if (id instanceof Integer) {
			int i = classesMapper.deleteByPrimaryKey(id);
			return  i>0;
		}
		return false;
	}

	/**
	 * 更新
	 */
	@Override
	public Boolean update(Classes t) {
		if (t!=null) {
			int i = classesMapper.updateByPrimaryKey(t);
			return i>0;
		}
		return false;
	}

	/**
	 * 查询
	 */
	@Override
	public List<Classes> get(Classes t) {
		
		ClassesExample example = new ClassesExample();
		Criteria criteria = example.createCriteria();
		if (t.getName()!=null && t.getName().trim().length()>0) {
			criteria.andNameLike("%"+t.getName()+"%");
		}
		if (t.getStarttime()!=null && t.getStarttime().toString().trim().length()>0) {
			criteria.andStarttimeGreaterThanOrEqualTo(t.getStarttime());
		}
		if (t.getEndtime()!=null && t.getEndtime().toString().trim().length()>0) {
			criteria.andEndtimeLessThanOrEqualTo(t.getEndtime());
		}
		if (t.getCourse()!=null && t.getCourse().trim().length()>0) {
			criteria.andCourseLike("%"+t.getCourse()+"%");
		}
		List<Classes> list = classesMapper.selectByExample(example);
		if (list.size()>0) {
			return list;
		}
		return null;
	}

	/**
	 * 列表
	 */
	@Override
	public List<Classes> list() {
		
		ClassesExample example = new ClassesExample();
		
		List<Classes> list = classesMapper.selectByExample(example);
		if (list.size()>0) {
			return list;
		}
		return null;

	}
	

}
