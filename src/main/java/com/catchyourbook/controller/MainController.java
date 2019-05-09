package com.catchyourbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping(value = "/aaa")
	public String test() {
		
		return "/main";
	}
	
	@RequestMapping(value = "/test")
	public ModelAndView mvTest() {
	
		ModelAndView mv = new ModelAndView("/main");
		
//		mv.addObject("test", "testStrValue");
		
		return mv;
	}
 }
