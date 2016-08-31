package com.zhinengshe.service.question.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.question.QuestionMapper;
import com.zhinengshe.pojo.question.Question;
import com.zhinengshe.pojo.question.QuestionExample;
import com.zhinengshe.pojo.question.QuestionExample.Criteria;
import com.zhinengshe.service.baseservice.impl.AbstractService;
import com.zhinengshe.service.question.IQuestionService;
import com.zhinengshe.utlis.pagenation.Pagination;

@Service("questionService")
public class QuestionServiceImpl extends AbstractService<Question, QuestionExample> implements IQuestionService {
	
	@Resource
	private QuestionMapper mapper;
	
	@Autowired
	public void setMapper(){
		super.setBaseMapper(mapper);
	}

	@Override
	public List<Question> get(Question t) {
		
		QuestionExample example = new QuestionExample();
		Criteria criteria = example.createCriteria();
		
		if (t.getId() !=null && t.getId() instanceof Integer) {
			criteria.andIdEqualTo(t.getId());
		}
		if (t.getQuestiontype() !=null && t.getQuestiontype() instanceof Integer) {
			criteria.andQuestiontypeEqualTo(t.getQuestiontype());
		}
		
		List<Question> list = mapper.selectByExample(example);
		return list;
	}

	public Pagination list(String name, Byte category, String username, String tel, Integer pageNo) {
		// TODO Auto-generated method stub
		return null;
	}


}
