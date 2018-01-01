package com.it.tu.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.http.MediaType;

import com.it.tu.beans.CategoryItem;
import com.it.tu.beans.Enterprise;
import com.it.tu.beans.EnterpriseQuery;
import com.it.tu.services.CategoryItemService;
import com.it.tu.services.EnterpriseService;

@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {
	@Autowired
	private EnterpriseService service;

	@Autowired
	private CategoryItemService itemService;
	
	@RequestMapping(value="/add1", method = RequestMethod.GET)
	public ModelAndView EnterpriseAdd1(ModelMap model) {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("enterprise/add1");
		Enterprise _enterprise = new Enterprise();
		return modelView.addObject("enterprise",_enterprise);
	}
   @RequestMapping(value = "/add1", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
   @ExceptionHandler
   public Map<String, String> addCompany(@RequestBody Enterprise _enterprise){
       Map<String, String> map = new HashMap<String, String>(1);
       service.create(_enterprise);
       map.put("success", "true");
     return map;
	}
	@RequestMapping(value="/edit3/{id}", method = RequestMethod.GET)
	public ModelAndView EnterpriseEdit3(@ModelAttribute("id") Integer id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("enterprise/edit3");
		Enterprise _enterprise = service.findById(id);
		return model.addObject("enterprise",_enterprise);
	}
	@RequestMapping(value = "/edit3/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
   @ExceptionHandler
   public Map<String, String> EnterpriseEdit3(@RequestBody Enterprise _enterprise,@ModelAttribute("id") Integer id){
       Map<String, String> map = new HashMap<String, String>(1);
       _enterprise.setId(id);
       service.update(_enterprise);
         map.put("success", "true");
         return map;
	}


	@ResponseBody 
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteEnterprise(@ModelAttribute("id") Integer id)
	{
		service.delete(id);
		return "true";
	}

	@RequestMapping(value="/list2", method = RequestMethod.GET)
	public ModelAndView EnterpriseList2(ModelMap model) {
		ModelAndView modelView = new ModelAndView();
		EnterpriseQuery q = new EnterpriseQuery();
		List<CategoryItem> items=itemService.findByCategoryId(201010);
		return modelView.addObject("enterprises",service.findByQuery(q)).addObject("enterprisequery",q).addObject("items",items);
	}
	@RequestMapping(value = "/list2", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ExceptionHandler
	public Map<String, Object> queryList2(@RequestBody EnterpriseQuery q){
		List<Enterprise> list = service.findByQuery(q);
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
	    modelMap.put("data", list);
	    modelMap.put("success", "true");
	    return modelMap;
	}


	@ResponseBody
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public ModelAndView getView(@ModelAttribute("id") Integer id) 
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("enterprise/view");
		model.addObject("enterprise", service.findById(id));
		return model;
	}
}