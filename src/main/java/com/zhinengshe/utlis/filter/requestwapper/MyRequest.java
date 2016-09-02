package com.zhinengshe.utlis.filter.requestwapper;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {
	
	HttpServletRequest request ;

	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	// TODO 转换编码格式为utf-8
	@Override
	public String getParameter(String name) {
		
		String value = this.request.getParameter(name);
		String method = this.request.getMethod();
		
		
		// 获得当前的编码格式
		String encoding = this.request.getCharacterEncoding();
		// 判断用户的请求是否是get请求
		if("GET".equals(method)){
			if (encoding==null){  // 如果当编码格式为null 则设置编码格式为utf-8
				encoding = "UTF-8";
			}
			try {
				value = new String(value.getBytes("iso8859-1"), encoding);
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}
		
		return value;
	}
	
	
}
