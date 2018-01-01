package com.it.tu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.it.tu.beans.CategoryItem;
import com.it.tu.beans.Cliente;
import com.it.tu.services.CategoryItemService;
import com.it.tu.services.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private CategoryItemService itemService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView lista() {
		ModelAndView model = new ModelAndView();
		model.setViewName("cliente/lista");
		model.addObject("clientes", clienteService.getClientes());
		return model;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo() {
		try{
			
			List<CategoryItem> itemList = itemService.findByCategoryId(301000);
			
			int itemCount=itemList.size();
			System.out.println("1");
			System.out.println(itemCount);
			
			return new ModelAndView("cliente/client", "cliente", new Cliente("")).addObject("items",itemList);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return new ModelAndView();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ExceptionHandler
	public Map<String, String> addCliente(@RequestBody Cliente cliente) {
		Map<String, String> map = new HashMap<String, String>(1);

		clienteService.addCliente(cliente);

	    map.put("success", "true");
	    return map;
	}
}
