package com.zhinengshe.utlis.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhinengshe.utlis.filter.requestwapper.MyRequest;

public class MyEncodingFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("myfilter初始化");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO 转换get请求编码格式为 utf-8
		System.out.println("myfilter执行转化");
		// 将ServletRequest  ServletResponse 转换成 HttpServletRequest HttpServleResponse
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		MyRequest myRequest = new MyRequest(request);
		
		myRequest.setCharacterEncoding("UTF-8");
		
		// 放行
		chain.doFilter(myRequest, response);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
