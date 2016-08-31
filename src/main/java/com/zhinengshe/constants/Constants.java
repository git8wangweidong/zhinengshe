package com.zhinengshe.constants;

import java.util.Arrays;
import java.util.List;

public interface Constants {
	
	/**
	 * 单行题 题型常量
	 */
	public static final Integer QUESTION_INPUT_TYPE = 4;
	
	/**
	 * 多行题 题型常量
	 */
	public static final Integer QUESTION_TEXT_TYPE = 3;
	
	/**
	 * 单选题题 题型常量
	 */
	public static final Integer QUESTION_SINGLE_TYPE = 1;
	
	/**
	 * 选择题选项
	 */
	public static final List<String> ANSWER_LIST = Arrays.asList("1","2","3","4","5","6","7","8",
																			"9","10","A","B","C","D","E","F");

	
	
}
