package com.catchyourbook.Controller.Rest;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.catchyourbook.DTO.BookRecommend;
import com.catchyourbook.DTO.MemberInfo;
import com.catchyourbook.Service.BookRecommendService;

@RestController
public class BookRecommendController {

	private static final Logger logger = LoggerFactory.getLogger(BookRecommendController.class); 

	@Resource(name="BookRecommendService")
	BookRecommendService bookRecommendService;
	
	@PostMapping(value="book/recommend/add")
	public Map<String, Object> addBookRecommend (@RequestBody BookRecommend bookRecommend, HttpSession session) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MemberInfo loginInfo = (MemberInfo)session.getAttribute("loginInfo");
			bookRecommend.setMemberNo(loginInfo.getMemberNo());
			
			logger.info(">>>>>>>>> add BookREcommend");
			bookRecommendService.addBookRecommends(bookRecommend);
			
			result.put("success", "success");
		} catch(Exception e) {
			e.getStackTrace();
			result.put("success", "false");
		}
		
		return result;
	}
	
 }
