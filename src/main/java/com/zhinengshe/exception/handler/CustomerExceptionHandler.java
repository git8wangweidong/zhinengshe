package com.zhinengshe.exception.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.zhinengshe.exception.SystemException;

public class CustomerExceptionHandler extends SimpleMappingExceptionResolver {

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {

		String viewName = determineViewName(ex, request);
		if (viewName != null) {// JSP格式返回  
			if (!(request.getHeader("accept").indexOf("application/json") > -1
					|| (request.getHeader("X-Requested-With") != null
							&& request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
				
				Integer statusCode = determineStatusCode(request, viewName); // 如果不是异步请求
				
				if (statusCode != null) {
					applyStatusCodeIfPossible(request, response, statusCode);
				}
				
				return getModelAndView(viewName, ex, request);
				
			} else {// JSON格式返回
				// 异步请求的话，发生异常则直接把异常写到输出流中，将ModelAndView置为空，则springmvc不处理response
				try {
					PrintWriter writer = response.getWriter();
					writer.write(ex.getMessage());
					writer.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}
		} else {
			throw new SystemException( "返回异常字符串！！！！！" , "utf-8" );
		}

	}

}
