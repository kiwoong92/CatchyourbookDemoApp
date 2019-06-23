package com.catchyourbook.Controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.catchyourbook.DTO.BookPrd;
import com.catchyourbook.DTO.BookRecommend;
import com.catchyourbook.DTO.MemberInfo;
import com.catchyourbook.DTO.UniClassGroup;
import com.catchyourbook.Service.BookPrdService;
import com.catchyourbook.Service.BookRecommendService;
import com.catchyourbook.Service.UniClassGroupService;
import com.catchyourbook.Service.UniUniverysityService;

@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class); 

	@Resource(name="BookPrdService")
	BookPrdService bookPrdService;
	
	@Resource(name="UniClassGroupService")
	UniClassGroupService uniClassGroupService;
	
	@Resource(name="UniUniversityService")
	UniUniverysityService uniUniversityService;

	@Resource(name="BookRecommendService")
	BookRecommendService bookRecommendService;
	
	@RequestMapping(value = "/main")
	public String test() {
		List<BookPrd> bookResult = bookPrdService.getBookPrdList();
		logger.info("###### bookResult : {}", bookResult);
		
		return "/main/index";
	}
	
	@RequestMapping(value = { "/books", "/books/{searchData}"})
	public ModelAndView moveBookPage(@PathVariable(value = "searchData", required=false)String searchData) {
	
		ModelAndView mv = new ModelAndView("/main/books");
		
		List<BookPrd> bookResult = new ArrayList<>(); 
		if (StringUtils.isEmpty(searchData)) {
			bookResult = bookPrdService.getBookPrdList();
		} else {
			bookResult = bookPrdService.getBookSearchList(searchData);
			mv.addObject("searchData",searchData);
		}
			
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
		
		mv.addObject("univerysityList", uniUniversityService.getAllUniversityList());
		
		return mv;
	}
	
	@RequestMapping(value="/login")
	public ModelAndView loginPage() {
		ModelAndView mv = new ModelAndView("/main/login");
		
		return mv;
	}
	
	@RequestMapping(value="/matching", method=RequestMethod.POST)
	public ModelAndView moveMatchingPage(String[] bookIdArray, HttpSession session) {
		 
		MemberInfo loginInfo = (MemberInfo) session.getAttribute("loginInfo");
		
		if (loginInfo == null || loginInfo.getMemberNo() <= 0) {
			return new ModelAndView("redirect:/login");
		}
		
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
	

	@RequestMapping(value="/logout")
	public String Logout(HttpSession session) {
		
		session.setAttribute("loginInfo", null);
		
		return "redirect:/login";
	}
	
	@RequestMapping(value=  "/recommend")
	public ModelAndView moveRecommendPage(HttpSession session, @RequestParam("page") int page) {
		
		ModelAndView mv = new ModelAndView("/main/recommend");
		
		 
		MemberInfo loginInfo = (MemberInfo) session.getAttribute("loginInfo");
		
		if (loginInfo == null || loginInfo.getMemberNo() <= 0) {
			return new ModelAndView("redirect:/login");
		} else {
			List<BookRecommend> bookRecommends = bookRecommendService.getBookRecommendsByPaging(page);
			mv.addObject("bookRecommends", bookRecommends);
		}
		
		return mv;
	}
 }
