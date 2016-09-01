package com.zhinengshe.service.question.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.question.QuestionMapper;
import com.zhinengshe.pojo.question.Question;
import com.zhinengshe.pojo.question.QuestionExample;
import com.zhinengshe.pojo.student.Student;
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
	
	// TODO 分页展示问题
	@Override
	public Pagination list(String question, Integer questiontype,Integer pageNo) {
		
		StringBuffer params = new StringBuffer();
		Question que = new Question();
		
		if (question!=null && question.trim().length()>0) {
			params.append("question=").append(question);
			que.setQuestion(question);
		}
		
		if (questiontype!= null) {
			params.append("&questiontype=").append(questiontype);
			que.setQuestiontype(questiontype);
		}
		
		que.setPageNo(Pagination.cpn(pageNo));
		
		List<Student> list = mapper.selectByPage(que);
		int totalCount = mapper.selectTotalCount(que);
		
		Pagination pagination = new Pagination(que.getPageNo(), que.getPageSize(), totalCount, list);
		
		String url = "question/list";
		pagination.pageView(url, params.toString());
		
		return pagination;
		
	}




}
