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
import com.it.tu.beans.EnterpriseRegister;
import com.it.tu.beans.EnterpriseRegisterQuery;
import com.it.tu.services.CategoryItemService;
import com.it.tu.services.EnterpriseRegisterService;

@Controller
@RequestMapping("/enterpriseregister")
public class EnterpriseRegisterController {
	@Autowired
	private EnterpriseRegisterService service;

	@Autowired
	private CategoryItemService itemService;
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public ModelAndView EnterpriseRegisterAdd(ModelMap model) {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("enterpriseregister/add");
		EnterpriseRegister _enterpriseregister = new EnterpriseRegister();
		List<CategoryItem> items=itemService.findByCategoryId(301100);
		return modelView.addObject("enterpriseregister",_enterpriseregister).addObject("items",items);
	}
   @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
   @ExceptionHandler
   public Map<String, String> EnterpriseRegisterAdd(@RequestBody EnterpriseRegister _enterpriseregister){
       Map<String, String> map = new HashMap<String, String>(1);
       _enterpriseregister.setEnterpriseId(1);
       service.create(_enterpriseregister);
       map.put("success", "true");
     return map;
	}


	@ResponseBody 
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteEnterpriseRegister(@ModelAttribute("id") Integer id)
	{
		service.delete(id);
		return "true";
	}

	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ModelAndView EnterpriseRegisterList(ModelMap model) {
		ModelAndView modelView = new ModelAndView();
		EnterpriseRegisterQuery q = new EnterpriseRegisterQuery();
		List<CategoryItem> items=itemService.findByCategoryId(301100);
		return modelView.addObject("enterpriseregisters",service.findByQuery(q)).addObject("enterpriseregisterquery",q).addObject("items",items);
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ExceptionHandler
	public Map<String, Object> queryList(@RequestBody EnterpriseRegisterQuery q){
		List<EnterpriseRegister> list = service.findByQuery(q);
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
	    modelMap.put("data", list);
	    modelMap.put("success", "true");
	    return modelMap;
	}
	@RequestMapping(value="/list1", method = RequestMethod.GET)
	public ModelAndView EnterpriseRegisterList1(ModelMap model) {
		ModelAndView modelView = new ModelAndView();
		EnterpriseRegisterQuery q = new EnterpriseRegisterQuery();
		return modelView.addObject("enterpriseregisters",service.findByQuery(q)).addObject("enterpriseregisterquery",q);
	}
	@RequestMapping(value = "/list1", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ExceptionHandler
	public Map<String, Object> queryList1(@RequestBody EnterpriseRegisterQuery q){
		List<EnterpriseRegister> list = service.findByQuery(q);
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
		model.setViewName("enterpriseregister/view");
		model.addObject("enterpriseregister", service.findById(id));
		return model;
	}
}