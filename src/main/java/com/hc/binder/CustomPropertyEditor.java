package com.hc.binder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class CustomPropertyEditor implements PropertyEditorRegistrar{
	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {

	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    // 定义此值 是否可以为空
	    CustomDateEditor dateEditor = new CustomDateEditor(df, true);  
	    //表示如果命令对象有Date类型的属性，将使用该属性编辑器进行类型转换  
	    registry.registerCustomEditor(Date.class, dateEditor);    
	}
}
