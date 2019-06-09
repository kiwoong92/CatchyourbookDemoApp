package com.catchyourbook.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.catchyourbook.DTO.BookPrd;
import com.catchyourbook.DTO.UniClassGroup;
import com.catchyourbook.Service.BookPrdService;
import com.catchyourbook.Service.UniClassGroupService;
import com.catchyourbook.Service.UniUniverysityService;

@Controller
public class MyPageController {

	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class); 

	@Resource(name="BookPrdService")
	BookPrdService bookPrdService;
	
	@Resource(name="UniClassGroupService")
	UniClassGroupService uniClassGroupService;
	
	@Resource(name="UniUniversityService")
	UniUniverysityService uniUniversityService;
	
	@RequestMapping(value="/cart")
	public ModelAndView goMyPage(Session session) {
		ModelAndView mv = new ModelAndView("/main/cart");
		
		return mv;
	}
 }
