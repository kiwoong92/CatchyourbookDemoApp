package com.catchyourbook.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.catchyourbook.DTO.BookPrd;
import com.catchyourbook.DTO.UniClassGroup;
import com.catchyourbook.Service.BookPrdService;
import com.catchyourbook.Service.UniClassGroupService;

@Controller
public class MainController {

	/*
	 * remote patch test
	 * */
	private static final Logger logger = LoggerFactory.getLogger(MainController.class); 

	@Resource(name="BookPrdService")
	BookPrdService bookPrdService;
	
	@Resource(name="UniClassGroupService")
	UniClassGroupService uniClassGroupService;
	
	@RequestMapping(value = "/main")
	public String test() {
		List<BookPrd> bookResult = bookPrdService.getBookPrdList();
		logger.info("###### bookResult : {}", bookResult);
		
		return "/main/index";
	}
	
	@RequestMapping(value = "/books")
	public ModelAndView moveBookPage() {
	
		ModelAndView mv = new ModelAndView("/main/books");
		
		List<BookPrd> bookResult = bookPrdService.getBookPrdList();
		mv.addObject("bookList", bookResult);
//		mv.addObject("test", "testStrValue");
		
		return mv;
	}
	
	@RequestMapping(value="/mytables")
	public ModelAndView moveTablePage() {
		//임시로 YONSEI로 세팅, 나중에 로그인한 사용자의 학교ID로 세팅.
		ModelAndView mv = new ModelAndView("/main/tables");
		String uniId = "YONSEI_WON";
		List<UniClassGroup> classGroupList = uniClassGroupService.getTopUniClassGroupByUniId(uniId); 
		mv.addObject("topGroupList", classGroupList);
		
		return mv;
	}
	 
	@RequestMapping(value="/joinus")
	public ModelAndView joinUsPage() {
		ModelAndView mv = new ModelAndView("/main/joinus");
		
		return mv;
	}
	
	@RequestMapping(value="/login")
	public ModelAndView loginPage() {
		ModelAndView mv = new ModelAndView("/main/login");
		
		return mv;
	}
	
	@RequestMapping(value="/matching", method=RequestMethod.POST)
	public ModelAndView moveMatchingPage(String[] bookIdArray) {
		 
		logger.info("######## hello ");
		
		List<String> bookIdlist = new ArrayList<>();
		for (String bookId : bookIdArray) {
			bookIdlist.add(bookId);
		}
		
//		bookIdlist.add("YONSEI_OOP");
		
		ModelAndView mv = new ModelAndView("/main/matching");
		List<BookPrd> bookResult = bookPrdService.getMatchingList(bookIdlist);

		if (bookIdlist != null && bookIdlist.size() > 0) {
			mv.addObject("matchingList", bookResult);
		}
		
		return mv;
	}
 }
