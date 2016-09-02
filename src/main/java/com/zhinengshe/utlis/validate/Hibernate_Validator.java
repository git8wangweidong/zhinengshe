package com.zhinengshe.utlis.validate;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class Hibernate_Validator {
	
	/**
	 * 提取检查参数方法
	 * @param model
	 * @param result
	 * @return
	 */
	public static boolean checkParam(Model model,BindingResult result){
		
		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				model.addAttribute("ERR_" + fieldError.getField(), fieldError.getDefaultMessage());
			}
			return true;
		}
		return false;
	}
}
