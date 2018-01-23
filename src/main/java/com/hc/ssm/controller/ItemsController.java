package com.hc.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hc.exception.CustomException;
import com.hc.ssm.po.Items;
import com.hc.ssm.po.ItemsQueryVo;
import com.hc.ssm.service.ItemsService;

@Controller
@RequestMapping("/item")
// @SessionAttributes("itemsType")
public class ItemsController {
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/query")
	// @RequestMapping(value="/query", method={RequestMethod.GET})
	public ModelAndView query(HttpServletRequest request, ModelMap model) throws SQLException {
		System.out.println("request id is " + request.getParameter("id"));
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
	
	@RequestMapping("/editquery")
	public ModelAndView editquery(HttpServletRequest request, ModelMap model) throws SQLException {
		System.out.println("request id is " + request.getParameter("id"));
		List<Items> list = null;
		try {
			list = itemsService.getItemsList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", list);
		modelAndView.setViewName("editList");
		return modelAndView;
	}

	@RequestMapping("/editmap")
	public ModelAndView editMap(HttpServletRequest request, ModelMap model) throws SQLException {
		System.out.println("request id is " + request.getParameter("id"));
		List<Items> list = null;
		try {
			list = itemsService.getItemsList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", list);
		modelAndView.setViewName("editmap");
		return modelAndView;
	}
	
	@RequestMapping(value="/edit", method={RequestMethod.GET})
	public String edit(
			@RequestParam(value="id", defaultValue="2", required=true) Integer myid,
			Boolean status,
			ModelMap model
			) throws SQLException, CustomException {
		Items items = itemsService.findById(myid);
		model.addAttribute("itemsCustom", items);
		model.addAttribute("item", items);
		model.addAttribute("id", myid);
		System.out.println("status is " + status);
		// Map<String, String> map = (Map<String, String>) model.get("itemsType");
		// map.put("004", "inedit");
		return "editItem";
		// return "editItem2";
	}

	@RequestMapping(value="/view/{id}", method={RequestMethod.GET})
	public String view(
			@PathVariable("id") Integer myid,
			ModelMap model
			) throws SQLException, CustomException {
		Items items = itemsService.findById(myid);
		model.addAttribute("itemsCustom", items);
		model.addAttribute("item", items);
		model.addAttribute("id", myid);
		return "editItem";
	}
	
	// @RequestMapping(value="/editSubmit", method={RequestMethod.POST} )
	@RequestMapping("/editSubmit")
	public String editSubmit(HttpServletRequest request, Model model, 
			Integer id, 
			@ModelAttribute(value="itemsCustom") Items items,
			MultipartFile pictureFile
			// @ModelAttribute(value="itemsType") Map<String, String> map 
			) throws SQLException, IllegalStateException, IOException {
		System.out.println("item is " + items);
		System.out.println("model to string is  " + model);
		// System.out.println("itemsQueryVo " + itemsQueryVo);
		
		// System.out.println("name is " + itemCustom.getName());
		System.out.println("id is " + id);
		System.out.println("request is  is " + request.getParameter("id"));
		System.out.println("request is  is " + request);
		// Map<String, String> mymap = (Map<String, String>) map.get("itemsType");
		if (items.getName() == null) {
			// model.addAttribute("itemsCustom", items);
			model.addAttribute("id", id);
			model.addAttribute("message", "这是回显");
			// mymap.put("003", "显示器");
			return "editItem";
		}
		
		String fileName = pictureFile.getOriginalFilename();
		if (!fileName.equals("") ) {
			String newFileName =
					UUID.randomUUID().toString() + fileName.
					substring(fileName.lastIndexOf("."));
			File uploadPic = new File("D:/develop/upload/tmp/" +
					newFileName);
			if (!uploadPic.exists()) {
				uploadPic.mkdirs();
			}
			
			pictureFile.transferTo(uploadPic);
			items.setPic(newFileName);
		}
		

		// items.setCreatetime(new Date());
		// BeanUtils.copyProperties(itemsQueryVo.getItemsCustom(), items);
		itemsService.update(id, items);
		// return "redirect:query.action?id=" + id;
		// return "forward:query.action";
		return "success";
	} 

	@RequestMapping("/delete") 
	public String delete(Integer[] item_id){
		System.out.println(item_id);
		// 
		return "success";
	}

	@RequestMapping("/updatelist") 
	public String updateList(ItemsQueryVo queryVo){
		System.out.println(queryVo);
		// 
		return "success";
	}
	
	@RequestMapping("/editMapSubmit") 
	public String editMapSubmit(ItemsQueryVo queryVo){
		System.out.println(queryVo);
		Map<String, String> map = queryVo.getItemsInfo();
		System.out.println(map);
		// 
		return "success";
	}
	
	@ModelAttribute("itemsType")
	public Map<String, String> getItemsType() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("001", "数码");
		map.put("002", "家电");
		return map;
	}
	
/*	@RequestMapping("/editSubmit")
	public void editSubmit(HttpServletRequest request, 
			HttpServletResponse response,
			Integer id, Items items) throws SQLException, ServletException, IOException {
		System.out.println("item is " + items);
		// System.out.println("name is " + itemCustom.getName());
		System.out.println("id is " + id);
		items.setCreatetime(new Date());
		itemsService.update(id, items);
		request.getRequestDispatcher("/WEB-INF/jsp/success.jsp")
			.forward(request, response);
		// return "success";
	}*/

//	@InitBinder
//	public void initBinder(WebDataBinder binder) throws Exception {
//		//注册自定义的属性编辑器  
//	    //1、日期  
//	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
//	    // 定义此值 是否可以为空
//	    CustomDateEditor dateEditor = new CustomDateEditor(df, true);  
//	    //表示如果命令对象有Date类型的属性，将使用该属性编辑器进行类型转换  
//	    binder.registerCustomEditor(Date.class, dateEditor);      
//	}
}
