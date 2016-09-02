package com.zhinengshe.service.questiontype;

import java.util.List;

import com.zhinengshe.pojo.questiontype.Questiontype;
import com.zhinengshe.pojo.questiontype.QuestiontypeExample;
import com.zhinengshe.service.baseservice.IBaseService;
import com.zhinengshe.utlis.pagenation.Pagination;

public interface IQuestionTypeService extends IBaseService<Questiontype, QuestiontypeExample> {

	/**
	 * 分页展示问题类型
	 * @param name 问题名称
	 * @param pageNo 当前页码
	 * @return
	 */
	Pagination list(String name, Integer pageNo);
	
	/**
	 * 展示问题类型 
	 * @return
	 */
	List<Questiontype> list();
}
