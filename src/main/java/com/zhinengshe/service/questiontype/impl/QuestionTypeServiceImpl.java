package com.zhinengshe.service.questiontype.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.questiontype.QuestiontypeMapper;
import com.zhinengshe.pojo.questiontype.Questiontype;
import com.zhinengshe.pojo.questiontype.QuestiontypeExample;
import com.zhinengshe.pojo.student.Student;
import com.zhinengshe.service.baseservice.impl.AbstractService;
import com.zhinengshe.service.questiontype.IQuestionTypeService;
import com.zhinengshe.utlis.pagenation.Pagination;

@Service("questionTypeService")
public class QuestionTypeServiceImpl extends AbstractService<Questiontype, QuestiontypeExample> implements IQuestionTypeService{

	@Resource
	private QuestiontypeMapper mapper;
	
	@Autowired
	public void setBaseMapper(){
		super.setBaseMapper(mapper);
	}
	
	
	// TODO 分页展示问题类型
	@Override
	public Pagination list(String name, Integer pageNo) {
		
		StringBuffer params = new StringBuffer();
		
		Questiontype questiontype = new Questiontype();
		
		if (name!=null && !"".equals(name.trim())) {
			params.append("name=").append(name);
			questiontype.setName(name);
			
		}

		questiontype.setPageNo(Pagination.cpn(pageNo));
		
		// 查询结果集 和总记录条数
		List<Student> list = mapper.selectByPage(questiontype);
		int totalCount = mapper.selectTotalCount(questiontype);
		
		Pagination pagination = new Pagination(questiontype.getPageNo(), questiontype.getPageSize(), totalCount, list);
		
		String url = "questionType/list";
		pagination.pageView(url, params.toString());
		
		return pagination;
		
	}

	
	
	@Override
	public List<Questiontype> list() {
		List<Questiontype> list = mapper.selectByExample(null);
		
		return list;
	}

}
