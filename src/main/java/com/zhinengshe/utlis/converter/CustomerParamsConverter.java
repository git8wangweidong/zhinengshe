package com.zhinengshe.utlis.converter;

import org.springframework.core.convert.converter.Converter;

public class CustomerParamsConverter implements Converter<String, String> {

	@Override
	public String convert(String  source) {
		
		if (source !=null) {
			source = source.trim();
			if (""!=source) {
				return source;
			}
		}
		return null;
	}

}
