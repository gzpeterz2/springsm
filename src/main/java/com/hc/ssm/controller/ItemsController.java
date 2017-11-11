package com.hc.ssm.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hc.ssm.po.Items;
import com.hc.ssm.service.ItemsService;

@Controller
@RequestMapping("/item")
public class ItemsController {
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/query")
	public ModelAndView query() throws SQLException {
		
		List<Items> list = null;
		try {
			list = itemsService.getItemsList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", list);
		modelAndView.setViewName("itemsList");
		return modelAndView;
	}
	
	@RequestMapping("/edit")
	public String edit(Model model, Integer id) throws SQLException {
		Items items = itemsService.findById(id);
		model.addAttribute("itemsCustom", items);
		model.addAttribute("id", id);
		return "editItem";
	}
	
	// @RequestMapping(value="/editSubmit", method={RequestMethod.POST} )
	@RequestMapping("/editSubmit")
	public String editSubmit(Integer id, Items items) throws SQLException {
		System.out.println("item is " + items);
		// System.out.println("name is " + itemCustom.getName());
		System.out.println("id is " + id);
		// System.out.println("request is  is " + request.getAttribute("id"));
		items.setCreatetime(new Date());
		itemsService.update(id, items);
		return "success";
	}
}
