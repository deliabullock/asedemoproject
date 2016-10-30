package com.therealzads.telestrations.controller;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import org.springframework.stereotype.Controller;  
 
@Controller
public class NewAccountController {
	String message = "Please enter a username and password";
 
	@RequestMapping("/newAccPage")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "*user*") String name) {
		System.out.println("in controller");
 
		ModelAndView mv = new ModelAndView("newaccpage");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
}
