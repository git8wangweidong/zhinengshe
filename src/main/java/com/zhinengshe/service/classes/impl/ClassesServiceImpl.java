package com.zhinengshe.service.classes.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.classes.ClassesMapper;
import com.zhinengshe.pojo.classes.Classes;
import com.zhinengshe.pojo.classes.ClassesExample;
import com.zhinengshe.pojo.classes.ClassesExample.Criteria;
import com.zhinengshe.service.baseservice.impl.AbstractService;
import com.zhinengshe.service.classes.IClassesService;
import com.zhinengshe.utlis.pagenation.Pagination;

@Transactional
@Service("classesService")
public class ClassesServiceImpl extends AbstractService<Classes, ClassesExample> implements IClassesService {

	
	@Resource
	private ClassesMapper classesMapper;

	@Autowired
	public void setBaseMapper(){
		super.setBaseMapper(classesMapper);
	}


	/**
	 * 多条件查询
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


	@Override
	public Pagination list(String name, Byte category, String username, String tel, Integer pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
