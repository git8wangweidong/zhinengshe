package com.zhinengshe.service.question;

import com.zhinengshe.pojo.question.Question;
import com.zhinengshe.pojo.question.QuestionExample;
import com.zhinengshe.service.baseservice.IBaseService;
import com.zhinengshe.utlis.pagenation.Pagination;

public interface IQuestionService extends IBaseService<Question, QuestionExample>{

	Pagination list(String question, Integer questiontype, Integer pageNo);
}
