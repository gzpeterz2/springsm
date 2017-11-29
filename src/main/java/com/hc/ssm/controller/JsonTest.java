package com.hc.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hc.ssm.po.Items;

/**
 * 
* @Title: JsonTest.java 
* @Package com.hc.ssm.controller 
* @Description:  jason 的测试
* @author  zhangwen 
* @date 2017年11月17日 上午6:48:46 
* @version V1.0
 */
@Controller
public class JsonTest {
	
	@RequestMapping("/requestJson")
	public  @ResponseBody Items requestJson( @RequestBody Items items) {
		System.out.println(items);
		return items;
	}

}
