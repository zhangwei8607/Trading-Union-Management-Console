package com.it.tu.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.it.tu.beans.User;
import com.it.tu.services.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	 
	 
	@Autowired
	private UserService userService;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView register(ModelMap model) {
 
		User user = new User(); 
		return new ModelAndView("register").addObject(user);
	}
 
	@RequestMapping(value="/regfailed", method = RequestMethod.GET)
	public String registerError(ModelMap model) {
 
		model.addAttribute("error", "true");
		return "register";
 
	}

	@ResponseBody 
	@RequestMapping(value = "/checkEmail", method = RequestMethod.GET)
	public String checkEmailExist(@RequestParam(value ="email") String email) {

		if(userService.findUserByEmail(email) != null) {

			return "false";
		} else {
			return "true";
		}
	}
	
	@ResponseBody 
	@RequestMapping(value = "/checkUserName", method = RequestMethod.GET)
	public String checkUserNameExist(@RequestParam(value ="name") String name) {

		if(userService.findUserByName(name) != null) {

			return "false";
		} else {
			return "true";
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user,
			BindingResult result, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "/register/";
		}
		user.setName(user.getEmail().substring(0, user.getEmail().indexOf("@")));
		user.setDob(Calendar.getInstance().getTime());
		user.setStatus(0);
		user.setType(0);
		user.setRoleId(2);
		if(userService.findUserByEmail(user.getEmail()) != null) {

			return "/register/";
		} else {
			
			userService.create(user);
			redirectAttributes.addFlashAttribute("msgSucessAddUser", "User Cadastrado Com Sucesso!!!");
			return "redirect:/";
		}
		
	}
}
