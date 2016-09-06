package com.zhinengshe.service.nairetype.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.nairetype.NairetypeMapper;
import com.zhinengshe.pojo.nairetype.Nairetype;
import com.zhinengshe.pojo.nairetype.NairetypeExample;
import com.zhinengshe.pojo.student.Student;
import com.zhinengshe.service.baseservice.impl.AbstractService;
import com.zhinengshe.service.nairetype.INaireTypeService;
import com.zhinengshe.utlis.pagenation.Pagination;

@Service("naireTypeService")
public class NaireTypeServiceImpl extends AbstractService<Nairetype, NairetypeExample> implements INaireTypeService{

	
	@Resource
	private NairetypeMapper mapper;
	
	@Autowired
	public void setBaseMapper(){
		super.setBaseMapper(mapper);
	}
	
	@Override
	public Pagination list(String typename, Integer pageNo)throws Exception{
		
		StringBuffer params = new StringBuffer();
		Nairetype naireType = new Nairetype();
		
		if (typename!=null) {
			params.append("typename=").append(typename);
			naireType.setTypename(typename);
		}
		
		naireType.setPageNo(Pagination.cpn(pageNo));
		
		List<Student> list = mapper.selectByPage(naireType);
		int totalCount = mapper.selectTotalCount(naireType);
		
		Pagination pagination = new Pagination(naireType.getPageNo(), naireType.getPageSize(), totalCount, list);
		
		String url = "/naireType/list";
		pagination.pageView(url, params.toString());
		
		return pagination;
	}

}
