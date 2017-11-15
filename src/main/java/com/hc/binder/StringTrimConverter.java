package com.hc.binder;

import org.springframework.core.convert.converter.Converter;

public class StringTrimConverter implements Converter<String, String>{

	@Override
	public String convert(String source) {
		if (source != null) {
			String str = source.trim();
			if (str.equals("")) {
				return null;
			}
			return str;
		} 
		return null;
	}
}
